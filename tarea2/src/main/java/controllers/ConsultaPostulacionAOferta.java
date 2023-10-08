package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorOfertas;
import utils.DTOferta;
import utils.DTPostulante;
import utils.DTUsuario;

import java.io.IOException;
import java.util.Set;

import excepciones.NicknameNoExisteException;
import excepciones.UsuarioNoEsEmpresaException;

/**
 * Servlet implementation class ConsultaPostulacionAOferta
 */
@WebServlet("/consultaPostulacionAOferta")
public class ConsultaPostulacionAOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultaPostulacionAOferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NicknameNoExisteException, UsuarioNoEsEmpresaException {
		UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
		String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(req, resp);
		
		switch (tipoUsuario) {
		case "postulante":
			DTPostulante usuario = (DTPostulante) utilidadesJWT.obtenerDatosDeUsuarioJWT(req, resp);
			req.setAttribute("usuario", usuario);
			req.getRequestDispatcher("/WEB-INF/postulante/consultaPostulacionAOferta.jsp").forward(req, resp);
			break;
		case "empresa":
			Fabrica factory = Fabrica.getInstance();
	    	IControladorOfertas ICO = factory.getIControladorOfertas();
	    	DTUsuario usr = utilidadesJWT.obtenerDatosDeUsuarioJWT(req, resp);
	    	Set<DTOferta> ofertas = ICO.obtenerOfertasVigentesDeEmpresa(usr.getNickname());
	    	req.setAttribute("ofertas", ofertas);
	    	
			req.getRequestDispatcher("/WEB-INF/empresa/consultaPostulacionOferta.jsp").forward(req, resp);
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
