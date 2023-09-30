package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.security.Key;
import java.util.Date;
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
	private static final String secret_Key = "6a2b5c8e1f4a7d0987654321abcdef09"; // Clave secreta para firmar JWT
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Visitante() {
        super();
        // TODO Auto-generated constructor stub
    }
      
    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
         }else {
             req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
             return;
         }
         
         if (jwt != null) {
             try {
            	 Key secretKey = Keys.hmacShaKeyFor(secret_Key.getBytes());
                 Jws<Claims> claimsJws = Jwts.parserBuilder()
                         .setSigningKey(secretKey)
                         .build()
                         .parseClaimsJws(jwt);

                 Claims claims = claimsJws.getBody();
                 Date expirationDate = claims.getExpiration();
                 if (expirationDate.before(new Date())) {
                     // El token ha expirado, maneja este caso según tus necesidades
                	 
                	 req.setAttribute("sessionExpired", true);
                     req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
                     return;
                     
                 }

                 // Verificar otros datos en el token, como el sujeto
                 String username = (String) claims.get("sub");
                 req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);

                 // Realizar comprobaciones adicionales si es necesario

                 // Aquí puedes realizar las comprobaciones necesarias con la información del JWT
                 // Por ejemplo, verificar la autenticidad, autorización, etc.

                 // Luego, puedes redirigir o responder de acuerdo a la validación del JWT
                 // ...
             } catch (Exception e) {
                 // El JWT no es válido o ha expirado, maneja este caso según tus necesidades
                 req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
             }
         } else {
             // El JWT no se encontró en las cookies, maneja este caso según tus necesidades
             req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
         }
         
    	
    		
	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
