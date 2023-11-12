package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servidor.publicar.DtEmpresa;
import servidor.publicar.DtOferta;
import servidor.publicar.DtPostulacion;
import servidor.publicar.DtPostulacionArray;
import servidor.publicar.DtPostulante;
import servidor.publicar.DtPublicacion;
import servidor.publicar.DtUsuario;
import servidor.publicar.EnumEstadoOferta;
import servidor.publicar.KeywordExisteException_Exception;
import servidor.publicar.NicknameNoExisteException_Exception;
import servidor.publicar.OfertaNoExisteException_Exception;
import servidor.publicar.ServicioOfertas;
import servidor.publicar.ServicioOfertasService;
import servidor.publicar.ServicioUsuarios;
import servidor.publicar.ServicioUsuariosService;
import servidor.publicar.UsuarioNoEsPostulanteException_Exception;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/ver-oferta")
public class verOferta extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JWT_COOKIE_NAME = "jwt";
    private ServicioOfertas portOfertas;
    private ServicioUsuarios portUsuarios;

    public verOferta() {
        super();
        ServicioOfertasService serviceOfertas = new ServicioOfertasService();
        portOfertas = serviceOfertas.getServicioOfertasPort();
        ServicioUsuariosService serviceUsuarios = new ServicioUsuariosService();
        portUsuarios = serviceUsuarios.getServicioUsuariosPort();
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
    
    /*public static String predecirGenero(String nombre) {

        nombre = nombre.toLowerCase();
        String[] terminacionesFemeninas = {"a", "ia", "ra", "na", "da", "la"};
        for (String terminacion : terminacionesFemeninas) {
            if (nombre.endsWith(terminacion)) {
                return "Femenino";
            }
        }
        return "Masculino";
    }*/
    
    public static String predecirGenero(String nombre) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String url = "https://api.genderize.io?name=" + nombre;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

            return jsonResponse.get("gender").getAsString().equals("male") ? "Masculino" : "Femenino";
        } catch (Exception e) {
            e.printStackTrace();
            return "Desconocido";
        }
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, KeywordExisteException_Exception {
        boolean isMobile = isMobileRequest(req);
        String jwt = getJwtFromCookies(req.getCookies());
        if (jwt != null && portUsuarios.validarToken(jwt)) {
            String tipoUsuario = portUsuarios.tipoUsuario(jwt);
            DtUsuario usuario = portUsuarios.obtenerDatosDeUsuarioJWT(jwt);
  
            req.setAttribute("postulante", usuario.getNickname());
            req.setAttribute("imgPerfil", usuario.getUrlImagen());
            req.setAttribute("nombre", usuario.getNombre());
            req.setAttribute("posibleGenero", predecirGenero(usuario.getNombre()));
            if ("postulante".equals(tipoUsuario)) {
            	
            	String nombreOferta = req.getParameter("nombreOferta");
                if (!nombreOferta.isEmpty()) {
                  try {    
                    DtPublicacion publicacion = portOfertas.obtenerPublicacionAsociadaAOferta(nombreOferta);
                    DtOferta oferta = portOfertas.obtenerDatosOferta(nombreOferta);
                    req.setAttribute("publicacion", publicacion);
                    req.setAttribute("fecha", oferta.getFechaAlta());
                    if (jwt != null) {
                      DtUsuario user = portUsuarios.obtenerDatosDeUsuarioJWT(jwt);
                      tipoUsuario = portUsuarios.tipoUsuario(jwt);
                      req.setAttribute("imgPerfil", (String) user.getUrlImagen());
                      req.setAttribute("nickname", (String) user.getNickname());
                      if (user instanceof DtPostulante) {
                    	boolean  estaPostulado = portOfertas.estaPostuladoAOfertaBoolean(user.getNickname(), oferta.getNombre());  
                        if (estaPostulado) {
                        	DtPostulacion mostrarPostulacion = null;
                            try {
                              mostrarPostulacion = portOfertas.estaPostuladoAOfertaLaboral(user.getNickname(), oferta.getNombre());
                            } catch (NicknameNoExisteException_Exception | OfertaNoExisteException_Exception | UsuarioNoEsPostulanteException_Exception e) {
                              // TODO: handle exception
                            }
                          req.setAttribute("postulacion", mostrarPostulacion);
                        }
                      }
                    }
                  } catch (OfertaNoExisteException_Exception | NicknameNoExisteException_Exception | UsuarioNoEsPostulanteException_Exception e) {
                    e.printStackTrace();
                  }
                }
            	
                if (isMobile) {
                    dispatchToPage(req, resp, "/WEB-INF/mobile/verOferta.jsp");
                } else {
                	resp.sendRedirect("visitante");
                }
                
            } else {
                resp.sendRedirect("visitante");
            }
        } else {
        	resp.sendRedirect("visitante");
        }
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
			processRequest(request, response);
		} catch (ServletException | IOException | KeywordExisteException_Exception e) {
			e.printStackTrace();
		}
    }
    
  
}
	

	
