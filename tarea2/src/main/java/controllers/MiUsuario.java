package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorOfertas;
import model.IControladorPublicaciones;
import utils.DTEmpresa;
import utils.DTOferta;
import utils.DTPostulacion;
import utils.DTPostulante;
import utils.DTPublicacion;
import utils.DTUsuario;
import utils.LocalDateSerializer;
import utils.LocalDateTimeAdapter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import excepciones.NicknameNoExisteException;
import excepciones.UsuarioNoEsEmpresaException;
import excepciones.UsuarioNoEsPostulanteException;

/**
 * Servlet implementation class MiUsuario
 */

@WebServlet("/miUsuario")
public class MiUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
    	DTUsuario user = utilidadesJWT.obtenerDatosDeUsuarioJWT(req, resp);
    	if(user != null) {
    		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
    				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
    		req.setAttribute("imgPerfil", user.getUrlImagen());
    		if(user instanceof DTPostulante) {
    			
        		req.setAttribute("nickname", user.getNickname());
        		req.setAttribute("nombre", user.getNombre());
        		req.setAttribute("apellido", user.getApellido());
        		req.setAttribute("correo", user.getCorreo());
        		Fabrica factory = Fabrica.getInstance();
        		IControladorOfertas ICO = factory.getIControladorOfertas();
        		List<DTPostulacion> postulacionesDePostulante = null;
        		try {
    				postulacionesDePostulante = ICO.obtenerPostulacionesPorPostulante(user.getNickname());
    			} catch (NicknameNoExisteException | UsuarioNoEsPostulanteException e) {
    				
    			}
        		if(postulacionesDePostulante != null) {
        			String postulacionesJSON = gson.toJson(postulacionesDePostulante);
        			req.setAttribute("postulaciones", postulacionesJSON);
        		}
    			
        		req.getRequestDispatcher("/WEB-INF/postulante/MiUsuario.jsp").forward(req, resp);
        	}else {
        		if(user  instanceof DTEmpresa) {
        			req.setAttribute("nickname", user.getNickname());
            		req.setAttribute("nombre", user.getNombre());
            		req.setAttribute("apellido", user.getApellido());
            		req.setAttribute("correo", user.getCorreo());
            		Fabrica factory = Fabrica.getInstance();
            		IControladorPublicaciones ICP = factory.getIControladorPublicaciones();	
            		 List<DTPublicacion> publicaciones = ICP.obtenerPublicacionesDeEmpresa(user.getNickname());
            		if(publicaciones != null && !publicaciones.isEmpty()) {
            			String publicacionesJSON = gson.toJson(publicaciones);
            			req.setAttribute("publicaciones", publicacionesJSON);
            		}
            		
        			req.getRequestDispatcher("/WEB-INF/empresa/MiUsuario.jsp").forward(req, resp);
        		}
        	}
    	}else {
    		resp.sendRedirect("visitante");
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
