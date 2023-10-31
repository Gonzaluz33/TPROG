package controllers;

import excepciones.NicknameNoExisteException;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servidor.publicar.*;
import utils.CookiesUtils;

@WebServlet("/mostrarUsuario")
public class MostrarUsuario extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, java.io.IOException {
		servidor.publicar.ServicioUsuariosService serviceUsuarios = new servidor.publicar.ServicioUsuariosService();
		servidor.publicar.ServicioUsuarios portUsuarios = serviceUsuarios.getServicioUsuariosPort();
		String usuarioSeleccionado = request.getParameter("nickname");
		if(usuarioSeleccionado == null) {
			response.sendRedirect("visitante");
			return;
		}
		CookiesUtils cookies = CookiesUtils.obtenerInstancia();
        String jwt = cookies.obtenerJWTEnCookies(request, response);
        String tipoUsuario = portUsuarios.tipoUsuario(jwt);
        DtUsuario usuario = null;
		try {
			usuario = portUsuarios.consultarUsuario(usuarioSeleccionado);
		} catch (NicknameNoExisteException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(jwt != null) {
    		DtUsuario autenticado = portUsuarios.obtenerDatosDeUsuarioJWT(jwt);
    		request.setAttribute("imgPerfil", autenticado.getUrlImagen());
    		request.setAttribute("autenticado", autenticado.getNickname());
           
    	}
    	request.setAttribute("usuarioSeleccionado", usuario);
    
        switch(tipoUsuario) {
		case ("postulante"):
			if (usuario instanceof DtPostulante) {
				request.getRequestDispatcher("/WEB-INF/postulante/mostrarPostulante.jsp").forward(request, response);
				break;
			}
			request.getRequestDispatcher("/WEB-INF/postulante/mostrarEmpresa.jsp").forward(request, response);
			break;
		case ("empresa"):
			if (usuario instanceof DtPostulante) {
				request.getRequestDispatcher("/WEB-INF/empresa/mostrarPostulante.jsp").forward(request, response);
				break;
			}
			request.getRequestDispatcher("/WEB-INF/empresa/mostrarEmpresa.jsp").forward(request, response);
			break;
		default:
			if (usuario instanceof DtPostulante) {
				request.getRequestDispatcher("/WEB-INF/visitante/mostrarPostulante.jsp").forward(request, response);
				break;
			}
			request.getRequestDispatcher("/WEB-INF/visitante/mostrarEmpresa.jsp").forward(request, response);
			break;
	}   
    }
}