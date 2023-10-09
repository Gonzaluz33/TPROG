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
import java.time.LocalDateTime;

import excepciones.NicknameNoExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsPostulanteException;

/**
 * Servlet implementation class ConfirmarPostulacion
 */
@WebServlet( urlPatterns = { "/confirmarPostulacion/*", "/confirmarPostulacion"})
public class ConfirmarPostulacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarPostulacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String NombreOferta = request.getParameter("NombreOferta");
        UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
    	String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(request, response);
		Fabrica factory = Fabrica.getInstance();
		IControladorOfertas ICO = factory.getIControladorOfertas();
		DTUsuario user = utilidadesJWT.obtenerDatosDeUsuarioJWT(request, response);
		if(user!=null) {
			request.setAttribute("imgPerfil", user.getUrlImagen());
		}
		try {
			DTOferta ofertaSeleccionada = ICO.obtenerDatosOferta(NombreOferta);
			request.setAttribute("ofertaSeleccionada", ofertaSeleccionada);
			switch(tipoUsuario) {
			case ("postulante"):
				request.getRequestDispatcher("/WEB-INF/postulante/confirmarPostulacion.jsp").forward(request, response);
				break;
			case ("empresa"):
				request.getRequestDispatcher("/WEB-INF/empresa/dashboardEmpresa.jsp").forward(request, response);
				break;
			default:
				request.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(request, response);
				break;
	        }
		} catch (OfertaNoExisteException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
		String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(request, response);
		try {
			switch(tipoUsuario) {
			case ("postulante"):
				Fabrica factory = Fabrica.getInstance();
				String NombreOferta = request.getParameter("NombreOferta");
		        String nicknamePostulante = utilidadesJWT.obtenerDatosDeUsuarioJWT(request, response).getNickname();
		        String cvReducido = request.getParameter("cv");
		        String motivacion = request.getParameter("motivacion");
		        LocalDateTime fechaActual = LocalDateTime.now();
				IControladorOfertas ICO = factory.getIControladorOfertas();
				ICO.postularAOferta(NombreOferta, nicknamePostulante, cvReducido, motivacion, fechaActual);
				response.sendRedirect("postulante");
				break;
			case ("empresa"):
				response.sendRedirect("empresa");
				break;
			default:
				response.sendRedirect("visitante");
				break;
	        }
		} catch (NicknameNoExisteException | UsuarioNoEsPostulanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(OfertaNoExisteException e) {
			request.setAttribute("error", e.getMessage());
			doGet(request, response);
            e.printStackTrace();
		}
		
	}

}

