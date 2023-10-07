package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorPublicaciones;
import utils.DTTipoPublicacion;

import java.io.IOException;

import excepciones.NicknameNoExisteException;

/**
 * Servlet implementation class MostrarTipo
 */
@WebServlet( urlPatterns = { "/mostrarTipo/*", "/mostrarTipo"})
public class MostrarTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarTipo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	String nombre = request.getParameter("nombre");
        UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
    	String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(request, response);
		Fabrica factory = Fabrica.getInstance();
		IControladorPublicaciones icontpub = factory.getIControladorPublicaciones();
		DTTipoPublicacion tipo = null;
		tipo = icontpub.obtenerDatosTipoPublicacion(nombre);
        request.setAttribute("tipoSeleccionado", tipo);
        switch(tipoUsuario) {
		case ("postulante"):
			request.getRequestDispatcher("/WEB-INF/postulante/mostrarTipo.jsp").forward(request, response);
			break;
		case ("empresa"):
			request.getRequestDispatcher("/WEB-INF/empresa/mostrarTipo.jsp").forward(request, response);
			break;
		default:
			request.getRequestDispatcher("/WEB-INF/visitante/mostrarTipo.jsp").forward(request, response);
			break;
        }
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
