package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.java.dev.jaxb.array.StringArray;
import servidor.publicar.DtPublicacion;
import servidor.publicar.DtUsuario;
import servidor.publicar.EnumEstadoOferta;
import servidor.publicar.KeywordExisteException_Exception;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servlet implementation class Postulante
 */
@WebServlet("/postulante")
public class Postulante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Postulante() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static List<DtPublicacion> filtrarPublicacionesConfirmadas(List<DtPublicacion> publicaciones) {
        return publicaciones.stream()
                .filter(publicacion -> EnumEstadoOferta.CONFIRMADA.equals(publicacion.getDtOferta().getEstado()))
                .collect(Collectors.toList());
    }

    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, KeywordExisteException_Exception {
    	
    	servidor.publicar.ServicioOfertasService serviceOfertas = new servidor.publicar.ServicioOfertasService();
        servidor.publicar.ServicioOfertas portOfertas = serviceOfertas.getServicioOfertasPort();
    	servidor.publicar.ServicioUsuariosService serviceUsuarios = new servidor.publicar.ServicioUsuariosService();
		servidor.publicar.ServicioUsuarios portUsuarios = serviceUsuarios.getServicioUsuariosPort();
    	
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
		
		boolean esValidoPostulante = false;
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
			if (!portUsuarios.isTokenBlacklisted(jwt)) {
				try {
					
					if (portUsuarios.validarToken(jwt)) {
						String correo = portUsuarios.obtenerCorreoPorJWT(jwt);
						DtUsuario usuario = portUsuarios.consultarUsuarioPorCorreo(correo); 
						if (portUsuarios.tipoUsuario(jwt).equals("postulante")) {
							esValidoPostulante = true;
							String imagen = usuario.getUrlImagen();
							req.setAttribute("imgPerfil", imagen);
						}
					} 

				} catch (Exception e) {

				}

			}

		} 
		
    	if(esValidoPostulante) {
    		req.getRequestDispatcher("/WEB-INF/postulante/dashboardPostulante.jsp").forward(req, resp);
    	}else {
    		resp.sendRedirect("visitante");
    	}
    		
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | KeywordExisteException_Exception e) {
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
