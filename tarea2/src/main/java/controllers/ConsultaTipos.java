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
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ConsultaTipos
 */
@WebServlet("/consultaTipos")
public class ConsultaTipos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultaTipos() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
		String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(req, resp);
		Fabrica factory = Fabrica.getInstance();
		IControladorPublicaciones icontpub = factory.getIControladorPublicaciones();
		List<DTTipoPublicacion> tiposPublicacion = new ArrayList<>();
		tiposPublicacion = icontpub.obtenerTipos();    	
		req.setAttribute("tiposPublicacion", tiposPublicacion);
		
		switch (tipoUsuario) {
		case ("postulante"):
			req.getRequestDispatcher("/WEB-INF/postulante/consultaTipoPublicacion.jsp").forward(req, resp);
			break;
		case ("empresa"):
			req.getRequestDispatcher("/WEB-INF/empresa/consultaTipoPublicacion.jsp").forward(req, resp);
			break;
		default:
			req.getRequestDispatcher("/WEB-INF/visitante/consultaTipos.jsp").forward(req, resp);
			break;

		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
