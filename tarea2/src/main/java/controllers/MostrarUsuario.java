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
			request.getRequestDispatcher("/WEB-INF/postulante/mostrarUsuario.jsp").forward(request, response);
			break;
		case ("empresa"):
			request.getRequestDispatcher("/WEB-INF/empresa/mostrarUsuario.jsp").forward(request, response);
			break;
		default:
			request.getRequestDispatcher("/WEB-INF/visitante/mostrarUsuario.jsp").forward(request, response);
			break;
	}   
    }
}