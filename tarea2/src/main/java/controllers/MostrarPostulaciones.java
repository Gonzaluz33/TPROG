package controllers;

import java.io.IOException;

import excepciones.OfertaNoExisteException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorOfertas;
import model.IControladorPublicaciones;
import utils.DTOferta;
import utils.DTTipoPublicacion;

@WebServlet(urlPatterns = { "/mostrarPostulacion/*", "/mostrarPostulacion"})
public class MostrarPostulaciones extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarPostulaciones() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, OfertaNoExisteException {
    	String nombre = request.getParameter("nombre");
        UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
    	String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(request, response);
		Fabrica factory = Fabrica.getInstance();
		IControladorOfertas icontof = factory.getIControladorOfertas();
		DTOferta oferta = icontof.obtenerDatosOferta(nombre);
        request.setAttribute("oferta", oferta);
        switch(tipoUsuario) {
		case "postulante":
			request.getRequestDispatcher("/WEB-INF/postulante/dashboardPostulante.jsp").forward(request, response);
			break;
		case "empresa":
			request.getRequestDispatcher("/WEB-INF/empresa/informacionPostulacion.jsp").forward(request, response);
			break;
		default:
			request.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(request, response);
			break;
        }
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request,response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OfertaNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
