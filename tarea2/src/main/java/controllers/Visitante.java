package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorOfertas;
import model.IControladorPublicaciones;
import model.IControladorUsuario;
import model.TokenBlacklist;
import utils.DTEmpresa;
import utils.DTPostulante;
import utils.DTPublicacion;
import utils.DTUsuario;
import utils.EnumEstadoOferta;
import utils.LocalDateSerializer;
import utils.LocalDateTimeAdapter;
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
	private static final String secret_Key = "6a2b5c8e1f4a7d0987654321abcdef09"; // Clave secreta para verificar JWT

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Visitante() {
		super();
		// TODO Auto-generated constructor stub
	}
	

    public static List<DTPublicacion> filtrarPublicacionesConfirmadas(List<DTPublicacion> publicaciones) {
        return publicaciones.stream()
                .filter(publicacion -> EnumEstadoOferta.CONFIRMADA.equals(publicacion.getDtOferta().getEstado()))
                .collect(Collectors.toList());
    }

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException,
			UsuarioRepetidoException, CorreoRepetidoException, NicknameNoExisteException {
		Fabrica factory = Fabrica.getInstance();
		IControladorOfertas ICO = factory.getIControladorOfertas();
		IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
		List<String> keywords = ICO.obtenerKeywords();
		Gson gson = new Gson();
		String keywordsJSON = gson.toJson(keywords);
		req.setAttribute("keywords", keywordsJSON);

		Gson gsonAux = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
				.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();

		String busqueda = req.getParameter("busqueda");
		String[] keywordsSeleccionadas = req.getParameterValues("keywords");
		List<DTPublicacion> publicaciones = new ArrayList<>();

		if (busqueda != null && !busqueda.isEmpty()) {
			publicaciones = ICP.obtenerPublicacionesPorBusqueda(busqueda);
		} else if (keywordsSeleccionadas != null && keywordsSeleccionadas.length > 0) {
			List<String> keywordsAFiltrar = new ArrayList<>(Arrays.asList(keywordsSeleccionadas));
			publicaciones = ICP.obtenerPublicacionesPorKeywords(keywordsAFiltrar);
		} else {

			publicaciones = ICP.obtenerPublicaciones();
		}
		List<DTPublicacion> pubFiltered = filtrarPublicacionesConfirmadas(publicaciones);
		String publicacionesJSON = gsonAux.toJson(pubFiltered);
		req.setAttribute("publicaciones", publicacionesJSON);

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

			TokenBlacklist blacklist = TokenBlacklist.getInstance();
			if (!blacklist.isTokenBlacklisted(jwt)) {
				try {
					Key secretKey = Keys.hmacShaKeyFor(secret_Key.getBytes());
					Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(jwt);

					Claims claims = claimsJws.getBody();
					// Date expirationDate = claims.getExpiration();
					String correo = (String) claims.get("email");
					IControladorUsuario iconuser = factory.getIControladorUsuario();
					if (iconuser.usuarioExiste(correo)) {
						DTUsuario usuario = iconuser.consultarUsuarioPorCorreo(correo);
						if (usuario instanceof DTEmpresa) {
							resp.sendRedirect("empresa");
						} else if (usuario instanceof DTPostulante) {
							resp.sendRedirect("postulante");
						}
					} else {
						// Eliminar la cookie JWT
						Cookie jwtCookie = new Cookie("jwt", "");
						jwtCookie.setMaxAge(0); // Establece la fecha de expiración en el pasado
						resp.addCookie(jwtCookie);
						req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
					}

				} catch (Exception e) {
					// El JWT no es válido o ha expirado, maneja este caso según tus necesidades
					req.setAttribute("sessionExpired", true);
					// Eliminar la cookie JWT
					Cookie jwtCookie = new Cookie("jwt", "");
					jwtCookie.setMaxAge(0); // Establece la fecha de expiración en el pasado
					resp.addCookie(jwtCookie);
					req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
				}

			} else {
				// El JWT esta en la blacklist
				req.setAttribute("invalidToken", true);
				// Eliminar la cookie JWT
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
				| NicknameNoExisteException e) {
			// TODO Auto-generated catch block
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
				| NicknameNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
