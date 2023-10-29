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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Visitante() {
		super();
		// TODO Auto-generated constructor stub
	}
	

    public static List<DtPublicacion> filtrarPublicacionesConfirmadas(List<DtPublicacion> publicaciones) {
        return publicaciones.stream()
                .filter(publicacion -> EnumEstadoOferta.CONFIRMADA.equals(publicacion.getDtOferta().getEstado()))
                .collect(Collectors.toList());
    }
    
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,
			UsuarioRepetidoException, CorreoRepetidoException, NicknameNoExisteException, KeywordExisteException_Exception {
		
		servidor.publicar.ServicioOfertasService serviceOfertas = new servidor.publicar.ServicioOfertasService();
        servidor.publicar.ServicioOfertas portOfertas = serviceOfertas.getServicioOfertasPort();
        String userAgent = req.getHeader("User-Agent");
        boolean isMobile = false;

        if (userAgent != null) {
            isMobile = userAgent.matches(".*(Android|iPhone|iPad|iPod|Windows Phone|webOS|BlackBerry|Mobile).*");
        }

        
		StringArray keywords = portOfertas.obtenerKeywords();
		req.setAttribute("keywords", keywords.getItem());

		String busqueda = req.getParameter("busqueda");
		String[] keywordsSeleccionadas = req.getParameterValues("keywords");
		String keywordsString = "";
		if (keywordsSeleccionadas != null) {
		    keywordsString = String.join("/", keywordsSeleccionadas);
		}
		List<DtPublicacion> publicaciones = new ArrayList<>();
		if (busqueda != null && !busqueda.isEmpty()) {
			publicaciones = portOfertas.obtenerPublicacionesPorBusqueda(busqueda).getItem();
		} else if (keywordsSeleccionadas != null && keywordsSeleccionadas.length > 0) {
			publicaciones = portOfertas.obtenerPublicacionesPorKeywords(keywordsString).getItem();
		} else {
			publicaciones = portOfertas.obtenerPublicaciones().getItem();
		}
		
		List<DtPublicacion> pubFiltered = filtrarPublicacionesConfirmadas(publicaciones);
		req.setAttribute("publicaciones", pubFiltered);
		
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
	        		req.setAttribute("invalidToken", true);
					Cookie jwtCookie = new Cookie("jwt", "");
					jwtCookie.setMaxAge(0);
					resp.addCookie(jwtCookie);
					if (isMobile) {
			        	req.getRequestDispatcher("/WEB-INF/mobile/inicio.jsp").forward(req, resp);
			        } else {
			        	req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
			        	
			        }
	        	}	
	        }else {
	        	req.setAttribute("invalidToken", true);
				Cookie jwtCookie = new Cookie("jwt", "");
				jwtCookie.setMaxAge(0);
				resp.addCookie(jwtCookie);
				if (isMobile) {
		        	req.getRequestDispatcher("/WEB-INF/mobile/inicio.jsp").forward(req, resp);
		        } else {
		        	req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
		        	
		        }
	        }
	        
		} else {
			if (isMobile) {
	        	req.getRequestDispatcher("/WEB-INF/mobile/inicio.jsp").forward(req, resp);
	        } else {
	        	req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
	        	
	        }
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
