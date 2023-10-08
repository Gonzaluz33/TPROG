package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorOfertas;
import model.IControladorPublicaciones;
import utils.DTOferta;
import utils.DTPublicacion;
import utils.LocalDateSerializer;
import utils.LocalDateTimeAdapter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import excepciones.NicknameNoExisteException;
import excepciones.UsuarioNoEsEmpresaException;

/**
 * Servlet implementation class MostrarOfertasAPostular
 */
@WebServlet( urlPatterns = { "/mostrarOfertasAPostular/*", "/mostrarOfertasAPostular"})
public class MostrarOfertasAPostular extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarOfertasAPostular() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NicknameNoExisteException, UsuarioNoEsEmpresaException {
    	String nicknameEmpresa = request.getParameter("Empresa");
        UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
    	String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(request, response);
		Fabrica factory = Fabrica.getInstance();
		IControladorOfertas ICO = factory.getIControladorOfertas();
		Set<DTOferta> ofertas = new HashSet<DTOferta>();
		ofertas = (Set<DTOferta>) ICO.obtenerOfertasVigentesDeEmpresa(nicknameEmpresa);
		Gson gsonAux = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
		String ofertasJson = gsonAux.toJson(ofertas);
		request.setAttribute("ofertasVigentes", ofertasJson);
		
		switch(tipoUsuario) {
		case ("postulante"):
			request.getRequestDispatcher("/WEB-INF/postulante/mostrarOfertasAPostular.jsp").forward(request, response);
			break;
		case ("empresa"):
			request.getRequestDispatcher("/WEB-INF/empresa/dashboardEmpresa.jsp").forward(request, response);
			break;
		default:
			request.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(request, response);
			break;
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | NicknameNoExisteException | UsuarioNoEsEmpresaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
