package controllers;

// Importaciones específicas en lugar de importaciones con asterisco
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servidor.publicar.*;
import utils.CookiesUtils;
import utils.LocalDateSerializer;
import utils.LocalDateTimeAdapter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import excepciones.NicknameNoExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsPostulanteException;

/**
 * Servlet implementation class ConsultaOferta
 */
@WebServlet("/consultaOferta")
public class ConsultaOferta extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ConsultaOferta() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  	servidor.publicar.ServicioUsuariosService service = new servidor.publicar.ServicioUsuariosService();
	servidor.publicar.ServicioUsuarios portUsuarios = service.getServicioUsuariosPort();
	servidor.publicar.ServicioOfertasService serviceOfertas = new servidor.publicar.ServicioOfertasService();
    servidor.publicar.ServicioOfertas portOfertas = serviceOfertas.getServicioOfertasPort();
	CookiesUtils cookies = CookiesUtils.obtenerInstancia();
    String jwt = cookies.obtenerJWTEnCookies(req, resp);
    String tipoUsuario = "visitante";
    
    String nombreOferta = req.getParameter("nombreOferta");
    if (!nombreOferta.isEmpty()) {
      try {    
        Gson gsonAux = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
        //DtPublicacion publicacion = portOfertas.obtenerPublicacionAsociadaAOferta(nombreOferta).toDataType();
        DtOferta oferta = portOfertas.obtenerDatosOferta(nombreOferta);
        //String publicacionJSON = gsonAux.toJson(publicacion);
        //req.setAttribute("publicacion", publicacionJSON);
        req.setAttribute("fecha", oferta.getFechaAlta());
        
        if (jwt != null) {
          DtUsuario user = portUsuarios.obtenerDatosDeUsuarioJWT(jwt);
          tipoUsuario = portUsuarios.tipoUsuario(jwt);
          req.setAttribute("imgPerfil", (String) user.getUrlImagen());
          if (user instanceof DtPostulante) {
            DtPostulacion mostrarPostulacion = null;
            try {
              mostrarPostulacion = portOfertas.estaPostuladoAOfertaLaboral(user.getNickname(), oferta.getNombre());
            } catch (NicknameNoExisteException_Exception | OfertaNoExisteException_Exception | UsuarioNoEsPostulanteException_Exception e) {
              // TODO: handle exception
            }
            if (mostrarPostulacion != null) {
              String mostrarPostulacionJSON = gsonAux.toJson(mostrarPostulacion);
              req.setAttribute("postulacion", mostrarPostulacionJSON);
            }
          }
        }
      } catch (OfertaNoExisteException_Exception e) {
        e.printStackTrace();
      }
    }
    switch (tipoUsuario) {
      case "postulante":
        req.getRequestDispatcher("/WEB-INF/postulante/consultaOfertaLaboral.jsp").forward(req, resp);
        break;
      case "empresa":
        req.getRequestDispatcher("/WEB-INF/empresa/consultaOfertaLaboral.jsp").forward(req, resp);
        break;
      default:
        req.getRequestDispatcher("/WEB-INF/visitante/consultaOfertaLaboral.jsp").forward(req, resp);
        break;
    }
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }
}