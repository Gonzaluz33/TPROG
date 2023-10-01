package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorUsuario;
import utils.DTEmpresa;
import utils.DTPostulante;
import utils.DTUsuario;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.security.Key;
import java.util.Date;
import excepciones.CorreoRepetidoException;
import excepciones.NicknameNoExisteException;
import excepciones.UsuarioRepetidoException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
/**
 * Servlet implementation class Visitante
 */
@WebServlet ("/visitante")
public class Visitante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String secret_Key = "6a2b5c8e1f4a7d0987654321abcdef09"; // Clave secreta para verificar JWT
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Visitante() {
        super();
        // TODO Auto-generated constructor stub
    }
      
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, UsuarioRepetidoException, CorreoRepetidoException, NicknameNoExisteException {
	    	
    	 Cookie[] cookies = req.getCookies();
         String jwtCookieName = "jwt";
         String jwt = null;
         if (cookies != null) {
             for (Cookie cookie : cookies) {
                 if (jwtCookieName.equals(cookie.getName())) {
                     jwt = cookie.getValue();
                     break;
                 }
             }
         }
    
         if (jwt != null) {
             try {
            	 Key secretKey = Keys.hmacShaKeyFor(secret_Key.getBytes());
                 Jws<Claims> claimsJws = Jwts.parserBuilder()
                         .setSigningKey(secretKey)
                         .build()
                         .parseClaimsJws(jwt);

                 Claims claims = claimsJws.getBody();
                 //Date expirationDate = claims.getExpiration();
        	    String correo = (String) claims.get("email");
 
        	    Fabrica factory = Fabrica.getInstance();
        	    IControladorUsuario iconuser = factory.getIControladorUsuario();
        	    
        	    if(iconuser.usuarioExiste(correo)) {
        	    	req.getRequestDispatcher("verifica bien si esxiste el usuario con ese correo").forward(req, resp);
        	        DTUsuario usuario = iconuser.consultarUsuarioPorCorreo(correo);
        	        DTEmpresa emp = (DTEmpresa) usuario;
        	        DTPostulante post = (DTPostulante) usuario;
            	        

        	        if(emp != null) {
        	            // Agrega información del usuario y lo redirige al dashboard de empresa
        	            req.getRequestDispatcher("/WEB-INF/empresa/dashboardEmpresa.jsp").forward(req, resp);
        	        }
        	        if(post != null) {
        	        	
        	            req.getRequestDispatcher("/WEB-INF/visitante/dashboardPostulante.jsp").forward(req, resp);
        	        }
        	    } else {
        	    	// Eliminar la cookie JWT
             	    Cookie jwtCookie = new Cookie("jwt", "");
             	    jwtCookie.setMaxAge(0); // Establece la fecha de expiración en el pasado
             	    resp.addCookie(jwtCookie);
        	        req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
        	    }
                	

                 
             } catch (Exception e) {
                 // El JWT no es válido o ha expirado, maneja este caso según tus necesidades
            	 req.setAttribute("sessionExpired", true);
         	    // Eliminar la cookie JWT
         	    Cookie jwtCookie = new Cookie("jwt", "");
         	    jwtCookie.setMaxAge(0); // Establece la fecha de expiración en el pasado
         	    resp.addCookie(jwtCookie);
         	    req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
             }
         } else {
             req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
         }
         
    	
    		
	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (ServletException | IOException | UsuarioRepetidoException | CorreoRepetidoException | NicknameNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | UsuarioRepetidoException | CorreoRepetidoException | NicknameNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
