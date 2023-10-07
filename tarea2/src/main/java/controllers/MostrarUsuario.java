package controllers;

import excepciones.NicknameNoExisteException;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorUsuario;
import utils.DTUsuario;
import utils.DTPostulante;

@WebServlet("/mostrarUsuario")
public class MostrarUsuario extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, java.io.IOException {
        String usuarioSeleccionado = request.getParameter("nickname");
        UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
    	String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(request, response);
		Fabrica factory = Fabrica.getInstance();
	    IControladorUsuario icontuser = factory.getIControladorUsuario();
        DTUsuario usuario = null;
		try {
			usuario = icontuser.consultarUsuario(usuarioSeleccionado);
		} catch (NicknameNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        request.setAttribute("usuarioSeleccionado", usuario);

        switch(tipoUsuario) {
		case ("postulante"):
			if (usuario instanceof DTPostulante) {
				request.getRequestDispatcher("/WEB-INF/postulante/mostrarPostulante.jsp").forward(request, response);
				break;
			}
			request.getRequestDispatcher("/WEB-INF/postulante/mostrarEmpresa.jsp").forward(request, response);
			break;
		case ("empresa"):
			if (usuario instanceof DTPostulante) {
				request.getRequestDispatcher("/WEB-INF/empresa/mostrarPostulante.jsp").forward(request, response);
				break;
			}
			request.getRequestDispatcher("/WEB-INF/empresa/mostrarEmpresa.jsp").forward(request, response);
			break;
		default:
			if (usuario instanceof DTPostulante) {
				request.getRequestDispatcher("/WEB-INF/visitante/mostrarPostulante.jsp").forward(request, response);
				break;
			}
			request.getRequestDispatcher("/WEB-INF/visitante/mostrarEmpresa.jsp").forward(request, response);
			break;
	}   
    }
}