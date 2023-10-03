package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import excepciones.CorreoRepetidoException;
import excepciones.NicknameNoExisteException;
import excepciones.UsuarioNoEncontrado;
import excepciones.UsuarioRepetidoException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.IControladorUsuario;
import utils.DTUsuario;
import model.Fabrica;

/**
 * Servlet implementation class Login
 */
@WebServlet("/registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 * @throws NicknameNoExisteException 
	 * @throws CorreoRepetidoException 
	 * @throws UsuarioRepetidoException 
	 * 
	 */
	

	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, UsuarioRepetidoException, CorreoRepetidoException{
		  String action = request.getParameter("action");
	        if ("altaEmpresa".equals(action)) {
	        
	            String nickname = request.getParameter("nickname");
	            String nombre = request.getParameter("nombre");
	            String apellido = request.getParameter("apellido");
	            String email = request.getParameter("email");
	            String nomEmpresa = request.getParameter("nomEmpresa");
	            String desc = request.getParameter("desc");
	            String linkWeb = request.getParameter("linkWeb");
	            String password = request.getParameter("password"); // Nueva contraseña
	            Fabrica factory = Fabrica.getInstance();
	            IControladorUsuario iconuser = factory.getIControladorUsuario();
	            iconuser.altaEmpresa(nickname,nombre,apellido,email,password,nomEmpresa ,desc, linkWeb);
	            response.sendRedirect("visitante");
	        } else {
	        	if ("altaPostulante".equals(action)) {
	        		
	                String nickname = request.getParameter("nickname");
	                String nombre = request.getParameter("nombre");
	                String apellido = request.getParameter("apellido");
	                String email = request.getParameter("email");
	                String fechaNacimiento = request.getParameter("fechaNacimiento");
	                String nacionalidad = request.getParameter("nacionalidad");
	                String password = request.getParameter("password"); // Nueva contraseña
	                Fabrica factory = Fabrica.getInstance();
	                IControladorUsuario iconuser = factory.getIControladorUsuario();
	                iconuser.altaPostulante(nickname,nombre,apellido,email,password ,parseFecha(fechaNacimiento),nacionalidad);
	                response.sendRedirect("visitante");
	        	}else {
	        		request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
	        	}
	        }
	}

	private LocalDate parseFecha(String fechaNacimiento) {
	    try {
	        return LocalDate.parse(fechaNacimiento);
	    } catch (DateTimeParseException e) {
	        // Manejar la excepción si la cadena de fecha no es válida
	        e.printStackTrace(); // O puedes manejarla de otra manera
	        return null; // Devolver null en caso de error
	    }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				try {
					processRequest(request, response);
				} catch (ServletException | IOException | UsuarioRepetidoException | CorreoRepetidoException e) {
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
				try {
					processRequest(request, response);
				} catch (ServletException | IOException | UsuarioRepetidoException | CorreoRepetidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	

}
