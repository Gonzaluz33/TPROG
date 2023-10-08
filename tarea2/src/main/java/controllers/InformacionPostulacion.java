package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorOfertas;
import utils.DTOferta;
import utils.DTUsuario;

import java.io.IOException;
import java.util.Set;

import excepciones.NicknameNoExisteException;
import excepciones.UsuarioNoEsEmpresaException;

/**
 * Servlet implementation class InformacionPostulacion
 */
@WebServlet("/informacionPostulacion")
public class InformacionPostulacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InformacionPostulacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NicknameNoExisteException, UsuarioNoEsEmpresaException {
		UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
		String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(req, resp);
		
		switch (tipoUsuario) {
		case ("postulante"):
			req.getRequestDispatcher("/WEB-INF/postulante/dashboardPostulante.jsp").forward(req, resp);
			break;
		case ("empresa"):
			req.getRequestDispatcher("/WEB-INF/empresa/informacionPostulacion.jsp").forward(req, resp);
			break;
		default:
			req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
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
		try {
			processRequest(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NicknameNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioNoEsEmpresaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
