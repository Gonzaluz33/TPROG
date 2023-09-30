package controllers;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import excepciones.NicknameNoExisteException;
import excepciones.UsuarioNoEncontrado;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import model.IControladorUsuario;
import utils.DTUsuario;
import model.Fabrica;

/**
 * Servlet implementation class Login
 */
@WebServlet("/iniciar-sesion")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SECRET_KEY = "clave_secreta"; // Clave secreta para firmar JWT

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
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NicknameNoExisteException, UsuarioNoEncontrado {
		 Fabrica factory = Fabrica.getInstance();
		 IControladorUsuario icontuser = factory.getIControladorUsuario();
		 String login = request.getParameter("login");
	     String password = request.getParameter("password");
		if (icontuser.validarUsuario(login,password)) { //agregar checkeo con encriptacion
		} else {
			DTUsuario usr = icontuser.consultarUsuario(login);
		    String jwt = generateJWT(usr.getId(),usr.getNombre(),usr.getApellido(),usr.getCorreo());
		    response.addCookie(new Cookie("jwt", jwt));
		}
        RequestDispatcher dispatcher = request.getRequestDispatcher("/visitante");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		} catch (UsuarioNoEncontrado e) {
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
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NicknameNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioNoEncontrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String generateJWT(int userId, String nombre, String apellido, String email) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", userId); // Sujeto del JWT, generalmente el ID del usuario
        claims.put("nombre", nombre); // Agregar nombre al JWT
        claims.put("apellido", apellido); // Agregar apellido al JWT
        claims.put("email", email); // Agregar correo electrónico al JWT
        claims.put("exp", new Date(System.currentTimeMillis() + 3600000)); // Tiempo de expiración (1 hora)

        return Jwts.builder()
                .setClaims(claims)
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

}
