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
                 Jws<Claims> claimsJws = Jwts.parserBuilder()
                     .setSigningKey(Keys.hmacShaKeyFor("clave_secreta".getBytes()))
                     .build()
                     .parseClaimsJws(jwt); //validacion del token

                 Claims claims = claimsJws.getBody();
                 int userId = Integer.parseInt(claims.getSubject());
                 String nombre = (String) claims.get("nombre");
                 String apellido = (String) claims.get("apellido");
                 String email = (String) claims.get("email");
                 Fabrica factory = Fabrica.getInstance();
        		 IControladorUsuario icontuser = factory.getIControladorUsuario();
        		 DTUsuario user = icontuser.consultarUsuario(email);
        		 DTEmpresa emp = (DTEmpresa) user;
        		 DTPostulante post = (DTPostulante) user;
        		 if(emp != null) {
        			 req.getRequestDispatcher("/WEB-INF/visitante/dashboardEmpresa.jsp").forward(req, resp);
        		 }
        		 if(post != null) {
        			 req.getRequestDispatcher("/WEB-INF/visitante/dashboardPostulante.jsp").forward(req, resp);
        		 }
        		 
          
                 // Aquí puedes realizar las comprobaciones necesarias con la información del JWT
                 // Por ejemplo, verificar la autenticidad, autorización, etc.
                 
                 // Luego, puedes redirigir o responder de acuerdo a la validación del JWT.
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
