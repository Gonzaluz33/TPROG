package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servidor.publicar.DtPublicacion;
import servidor.publicar.EnumEstadoOferta;
import servidor.publicar.KeywordExisteException_Exception;
import servidor.publicar.ServicioOfertas;
import servidor.publicar.ServicioOfertasService;
import servidor.publicar.ServicioUsuarios;
import servidor.publicar.ServicioUsuariosService;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/postulante")
public class Postulante extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JWT_COOKIE_NAME = "jwt";
    private ServicioOfertas portOfertas;
    private ServicioUsuarios portUsuarios;

    public Postulante() {
        super();
        ServicioOfertasService serviceOfertas = new ServicioOfertasService();
        portOfertas = serviceOfertas.getServicioOfertasPort();
        ServicioUsuariosService serviceUsuarios = new ServicioUsuariosService();
        portUsuarios = serviceUsuarios.getServicioUsuariosPort();
    }

    private List<DtPublicacion> filtrarPublicacionesConfirmadas(List<DtPublicacion> publicaciones) {
        return publicaciones.stream()
                .filter(p -> EnumEstadoOferta.CONFIRMADA.equals(p.getDtOferta().getEstado()))
                .collect(Collectors.toList());
    }

    private boolean isMobileRequest(HttpServletRequest req) {
        String userAgent = req.getHeader("User-Agent");
        return userAgent != null && userAgent.matches(".*(Android|iPhone|iPad|iPod|Windows Phone|webOS|BlackBerry|Mobile).*");
    }

    private String getJwtFromCookies(Cookie[] cookies) {
        if (cookies == null) return null;
        return Arrays.stream(cookies)
                .filter(c -> JWT_COOKIE_NAME.equals(c.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);
    }

    private void dispatchToPage(HttpServletRequest req, HttpServletResponse resp, String page) throws ServletException, IOException {
        req.getRequestDispatcher(page).forward(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, KeywordExisteException_Exception {
        boolean isMobile = isMobileRequest(req);
        req.setAttribute("keywords", portOfertas.obtenerKeywords().getItem());
        List<DtPublicacion> publicaciones = getPublicaciones(req);
        req.setAttribute("publicaciones", filtrarPublicacionesConfirmadas(publicaciones));

        String jwt = getJwtFromCookies(req.getCookies());
        if (jwt != null && portUsuarios.validarToken(jwt)) {
            String tipoUsuario = portUsuarios.tipoUsuario(jwt);
            if ("postulante".equals(tipoUsuario)) {
                if (isMobile) {
                    dispatchToPage(req, resp, "/WEB-INF/mobile/inicio.jsp");
                } else {
                    dispatchToPage(req, resp, "/WEB-INF/postulante/dashboardPostulante.jsp");
                }
            } else {
                resp.sendRedirect("visitante");
            }
        } else {
        	resp.sendRedirect("visitante");
        }
    }

    private List<DtPublicacion> getPublicaciones(HttpServletRequest req) {
        String busqueda = req.getParameter("busqueda");
        String[] keywordsSeleccionadas = req.getParameterValues("keywords");
        if (busqueda != null && !busqueda.isEmpty()) {
            return portOfertas.obtenerPublicacionesPorBusqueda(busqueda).getItem();
        } else if (keywordsSeleccionadas != null && keywordsSeleccionadas.length > 0) {
            String keywordsString = String.join("/", keywordsSeleccionadas);
            return portOfertas.obtenerPublicacionesPorKeywords(keywordsString).getItem();
        }
        return portOfertas.obtenerPublicaciones().getItem();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ServletException | IOException | KeywordExisteException_Exception e) {
            // Properly log the exception and handle it, if required
            throw new ServletException(e);
        }
    }

  
}
	
