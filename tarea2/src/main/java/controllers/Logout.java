package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TokenBlacklist;
import java.io.IOException;
import java.security.Key;
import java.util.Date;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * Servlet implementation class Logout
 */

@WebServlet("/cerrar-sesion")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String secret_Key = "6a2b5c8e1f4a7d0987654321abcdef09"; // Clave secreta para verificar JWT
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void CerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	Cookie[] cookies = request.getCookies();
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
            Date expirationDate = claims.getExpiration();
            long expirationTimeMillis = expirationDate.getTime();
            TokenBlacklist blacklist = TokenBlacklist.getInstance();
            blacklist.blacklistToken(jwt, expirationTimeMillis);
            Cookie cookie = new Cookie("jwt", "");
	        cookie.setMaxAge(0);
	        response.addCookie(cookie);
	        response.sendRedirect("visitante");
        
	    } catch (Exception e) {
	    	 Cookie cookie = new Cookie("jwt", "");
	         cookie.setMaxAge(0);
	         response.addCookie(cookie);
	         response.sendRedirect("visitante");
        }
    	
    	 
        }else {
        	response.sendRedirect("visitante");
        }
	    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CerrarSesion(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
