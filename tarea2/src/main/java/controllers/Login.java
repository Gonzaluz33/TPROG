package controllers;

import java.io.IOException;
import java.util.Date;
import java.security.Key;
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
@WebServlet("/iniciar-sesion")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String secret_Key = "6a2b5c8e1f4a7d0987654321abcdef09"; // Clave secreta para firmar JWT

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
	
	private String generateJWT(String email, String secret_Key) {
	    long expirationTimeMillis = System.currentTimeMillis() + 10000; // Tiempo de expiración (1 hora)
	    Key key = Keys.hmacShaKeyFor(secret_Key.getBytes());

	    String jwt = Jwts.builder()
	            .setSubject(email)
	            .claim("email", email)
	            .setExpiration(new Date(expirationTimeMillis))
	            .signWith(key, SignatureAlgorithm.HS256)
	            .compact();

	    return jwt;
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NicknameNoExisteException, UsuarioNoEncontrado, UsuarioRepetidoException, CorreoRepetidoException {
		 Fabrica factory = Fabrica.getInstance();
		 IControladorUsuario icontuser = factory.getIControladorUsuario();
		 String login = request.getParameter("login");
	     String password = request.getParameter("password");
		if (icontuser.validarUsuario(login,password)) {
		    String jwt = generateJWT(login,secret_Key);
		    response.addCookie(new Cookie("jwt", jwt));
		}
		response.sendRedirect("visitante");
		//request.getRequestDispatcher("/visitante").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				processRequest(request, response);
			} catch (ServletException | IOException | NicknameNoExisteException | UsuarioNoEncontrado e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UsuarioRepetidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CorreoRepetidoException e) {
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
			} catch (ServletException | IOException | NicknameNoExisteException | UsuarioNoEncontrado e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UsuarioRepetidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CorreoRepetidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

}
