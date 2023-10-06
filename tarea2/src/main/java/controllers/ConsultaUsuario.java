package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorUsuario;
import utils.DTPostulante;
import utils.DTUsuario;
import utils.LocalDateSerializer;
import utils.LocalDateTimeAdapter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet ("/consultaUsuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
       
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
    	String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(req, resp);
		Fabrica factory = Fabrica.getInstance();
	    IControladorUsuario icontuser = factory.getIControladorUsuario();
		List<DTUsuario> usuarios = new ArrayList<>();
		usuarios = icontuser.listarUsuarios();    	
    	Gson gson = new GsonBuilder()
    		    .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
    		    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
    		    .create();

    	String usuariosJson = gson.toJson(usuarios);
    	System.out.println(usuariosJson);
    	req.setAttribute("jsonUsers", usuariosJson);
		req.setAttribute("usuarios", usuarios);
    	switch(tipoUsuario) {
    		case ("postulante"):
    			req.getRequestDispatcher("/WEB-INF/postulante/consultaUsuario.jsp").forward(req, resp);
    			break;
    		case ("empresa"):
    			req.getRequestDispatcher("/WEB-INF/empresa/consultaUsuario.jsp").forward(req, resp);
    			break;
    		default:
    			req.getRequestDispatcher("/WEB-INF/visitante/consultaUsuario.jsp").forward(req, resp);
    			break;
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
