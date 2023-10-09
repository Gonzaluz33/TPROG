package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorPublicaciones;
import model.IControladorUsuario;
import utils.DTEmpresa;
import utils.DTPublicacion;
import utils.DTUsuario;
import utils.EnumEstadoOferta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class PostularAOferta
 */
@WebServlet("/postularAOferta")
public class PostularAOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostularAOferta() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
    
    public static List<DTUsuario> obtenerEmpresasConPublicacionesConfirmadas(IControladorPublicaciones ICP, IControladorUsuario ICU) {
        List<DTUsuario> empresasConPublicacionesConfirmadas = new ArrayList<>();
        List<DTEmpresa> todasLasEmpresas = ICU.listarEmpresas();
        
        for (DTUsuario empresa : todasLasEmpresas) {
            List<DTPublicacion> publicacionesDeEmpresa = ICP.obtenerPublicacionesDeEmpresa(empresa.getNickname());
            for (DTPublicacion publicacion : publicacionesDeEmpresa) {
                if (EnumEstadoOferta.CONFIRMADA.equals(publicacion.getDtOferta().getEstado())) {
                    empresasConPublicacionesConfirmadas.add(empresa);
                    break; 
                }
            }
        }
        
        return empresasConPublicacionesConfirmadas;
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
    	String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(req, resp);
    	Fabrica factory = Fabrica.getInstance();
	    IControladorUsuario icontuser = factory.getIControladorUsuario();
	    IControladorPublicaciones icontpub = factory.getIControladorPublicaciones();
		List<DTUsuario> empresas = new ArrayList<>();
		empresas = obtenerEmpresasConPublicacionesConfirmadas(icontpub,icontuser);
		req.setAttribute("empresas", empresas);
		DTUsuario user = utilidadesJWT.obtenerDatosDeUsuarioJWT(req, resp);
		if(user!=null) {
			req.setAttribute("imgPerfil", user.getUrlImagen());
		}
		
    	switch(tipoUsuario) {
    		case ("postulante"):
    			req.getRequestDispatcher("/WEB-INF/postulante/PostularAOferta.jsp").forward(req, resp);
    			break;
    		case ("empresa"):
    			req.getRequestDispatcher("/WEB-INF/empresa/dashboardEmpresa.jsp").forward(req, resp);
    			break;
    		default:
    			req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
    			break;
    	}
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
