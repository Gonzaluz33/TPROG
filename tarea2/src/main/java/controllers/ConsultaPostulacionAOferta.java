package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
    	String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(req, resp);
    	switch(tipoUsuario) {
    		case ("postulante"):
    			req.getRequestDispatcher("/WEB-INF/postulante/consultaPostulacionOferta.jsp").forward(req, resp);
    			break;
    		case ("empresa"):
    			req.getRequestDispatcher("/WEB-INF/empresa/consultaPostulacionAOferta.jsp").forward(req, resp);
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
