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

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet ("/consultaUsuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String secret_Key = "6a2b5c8e1f4a7d0987654321abcdef09"; // Clave secreta para firmar JWT
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String obtenerTipoUsuarioPorRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	Cookie[] cookies = req.getCookies();
        String jwtCookieName = "jwt";
        String jwt = null;
        String response = "invalido";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (jwtCookieName.equals(cookie.getName())) {
                    jwt = cookie.getValue();
                    break;
                }
            }
            
            if (jwt != null) {
            	response = "visitante";
		        TokenBlacklist blacklist = TokenBlacklist.getInstance();
		       	 if(!blacklist.isTokenBlacklisted(jwt)) {
				             try {
				            	 Key secretKey = Keys.hmacShaKeyFor(secret_Key.getBytes());
				                 Jws<Claims> claimsJws = Jwts.parserBuilder()
				                         .setSigningKey(secretKey)
				                         .build()
				                         .parseClaimsJws(jwt);
				
				                 Claims claims = claimsJws.getBody();
				        	    String tipoUsuario = (String) claims.get("tipoUsuario");
				        	    response = tipoUsuario;
				        	    
				             } catch (Exception e) {
				            	 response = "visitante"; 
				             }
		        }
            }
        }else {
        	response = "visitante";
        }
		return response;  
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	if(obtenerTipoUsuarioPorRequest(req,resp).equals("postulante")) {
    		req.getRequestDispatcher("/WEB-INF/postulante/consultaUsuario.jsp").forward(req, resp);
    	}else {
    		if(obtenerTipoUsuarioPorRequest(req,resp).equals("empresa")) {
    			req.getRequestDispatcher("/WEB-INF/empresa/consultaUsuario.jsp").forward(req, resp);
    		}else {
    			req.getRequestDispatcher("/WEB-INF/visitante/consultaUsuario.jsp").forward(req, resp);
    		}	
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
		processRequest(request,response);
	}

}
