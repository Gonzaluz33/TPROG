package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servidor.publicar.DtUsuario;
import utils.CookiesUtils;

import java.io.IOException;

/**
 * Servlet implementation class ModificarDatosUsuario
 */
@WebServlet("/modificarDatosUsuario")
public class ModificarDatosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static servidor.publicar.ServicioUsuariosService service = new servidor.publicar.ServicioUsuariosService();
	private static servidor.publicar.ServicioUsuarios portUsuarios = service.getServicioUsuariosPort();
    private static CookiesUtils cookies = CookiesUtils.obtenerInstancia();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarDatosUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jwt = cookies.obtenerJWTEnCookies(request, response);
    	if(jwt!= null) {
    		 String tipoUsuario = portUsuarios.tipoUsuario(jwt);
    		 DtUsuario user = portUsuarios.obtenerDatosDeUsuarioJWT(jwt);
 	         if(user!=null) {
 	        	request.setAttribute("imgPerfil", user.getUrlImagen());
 	        	request.setAttribute("usuario", user);
 	         }
 	         switch(tipoUsuario) {
 	         	case "empresa":
 	         		request.getRequestDispatcher("/WEB-INF/empresa/modificarDatos.jsp").forward(request, response);
 	         		break;
 	         	case "postulante":
 	         		request.getRequestDispatcher("/WEB-INF/postulante/modificarDatos.jsp").forward(request, response);
 	         		break;
 	         	default:
 	         		request.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(request, response);
 	         		break;
 	         }
    		
    	}
    	else {    		
    		request.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(request, response);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
