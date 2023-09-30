package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import model.EstadoSesion;

/**
 * Servlet implementation class Visitante
 */
@WebServlet ("/visitante")
public class Visitante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Visitante() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("paginas_navegadas") == null) {
			session.setAttribute("paginas_navegadas", 0);
		}
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
	}
	
	
	public static EstadoSesion getEstado(HttpServletRequest request)
	{
		return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
	}
    
    
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		initSession(req);
		
		switch(getEstado(req)){
			case NO_LOGIN:
				req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
				break;
			case LOGIN_INCORRECTO: 
				req.getRequestDispatcher("/WEB-INF/visitante/inicioErroneo.jsp").
						forward(req, resp);
				break;
			case LOGIN_EMPRESA:
				req.getRequestDispatcher("/WEB-INF/visitante/dashboardEmpresa.jsp").forward(req, resp);
				break;
			case LOGIN_POSTULANTE:
				req.getRequestDispatcher("/WEB-INF/visitante/dashboardPostulante.jsp").forward(req, resp);
				break;
		default:
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
		processRequest(request, response);
	}

}
