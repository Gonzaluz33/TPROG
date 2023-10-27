package controllers;

import utils.*;
import servidor.publicar.DtPublicacion;
import servidor.publicar.DtPublicacionArray;
import servidor.publicar.EnumEstadoOferta;
import servidor.publicar.KeywordExisteException_Exception;
import servidor.publicar.DtOferta;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.java.dev.jaxb.array.StringArray;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import excepciones.CorreoRepetidoException;
import excepciones.NicknameNoExisteException;
import excepciones.UsuarioRepetidoException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * Servlet implementation class Visitante
 */
@WebServlet("/visitante")
public class Visitante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String secret_Key = "6a2b5c8e1f4a7d0987654321abcdef09"; // Clave secreta para verificar JWT

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Visitante() {
		super();
		// TODO Auto-generated constructor stub
	}
	

    /*public static List<DtPublicacion> filtrarPublicacionesConfirmadas(List<DtPublicacion> publicaciones) {
        return publicaciones.stream()
                .filter(publicacion -> EnumEstadoOferta.CONFIRMADA.equals(publicacion.getDtOferta().getEstado()))
                .collect(Collectors.toList());
    }*/
    

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,
			UsuarioRepetidoException, CorreoRepetidoException, NicknameNoExisteException, KeywordExisteException_Exception {
		
		servidor.publicar.ServicioOfertasService serviceOfertas = new servidor.publicar.ServicioOfertasService();
        servidor.publicar.ServicioOfertas portOfertas = serviceOfertas.getServicioOfertasPort();
        
		StringArray keywords = portOfertas.obtenerKeywords();
		req.setAttribute("keywords", keywords.getItem());

		//Gson gsonAux = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
		//		.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
		
		//String busqueda = req.getParameter("busqueda");
		//String[] keywordsSeleccionadas = req.getParameterValues("keywords");
		

		/*if (busqueda != null && !busqueda.isEmpty()) {
			publicaciones = portOfertas.obtenerPublicacionesPorBusqueda(busqueda);
		} else if (keywordsSeleccionadas != null && keywordsSeleccionadas.length > 0) {
			
			publicaciones = portOfertas.obtenerPublicaciones();
		} else {
			publicaciones = portOfertas.obtenerPublicaciones();
		}*/
		DtPublicacionArray publicaciones = portOfertas.obtenerPublicaciones();
		//List<DTPublicacion> pubFiltered = filtrarPublicacionesConfirmadas(publicaciones);
		//String publicacionesJSON = gsonAux.toJson(publicaciones);
		req.setAttribute("publicaciones", publicaciones.getItem());
		
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
		}
		if (jwt != null) {
			servidor.publicar.ServicioUsuariosService service = new servidor.publicar.ServicioUsuariosService();
	        servidor.publicar.ServicioUsuarios port = service.getServicioUsuariosPort();
	        boolean esValido = port.validarToken(jwt);
	        
	        if(esValido){
	        	String tipoUsuario = port.tipoUsuario(jwt);
	        	if(tipoUsuario.equals("empresa")) {
	        		resp.sendRedirect("empresa");
	        	}else if(tipoUsuario.equals("postulante")){
	        		resp.sendRedirect("postulante");
	        	}else {
	        		
	        	}
	        	
	        }else {
	        	req.setAttribute("invalidToken", true);
				Cookie jwtCookie = new Cookie("jwt", "");
				jwtCookie.setMaxAge(0);
				resp.addCookie(jwtCookie);
				req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
	        }
	        
		} else {
			req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | UsuarioRepetidoException | CorreoRepetidoException
				| NicknameNoExisteException | KeywordExisteException_Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | UsuarioRepetidoException | CorreoRepetidoException
				| NicknameNoExisteException | KeywordExisteException_Exception e) {

			e.printStackTrace();
		}
	}

}
