package controllers;

// Importaciones específicas en lugar de importaciones con asterisco
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorOfertas;
import model.IControladorPublicaciones;
import utils.DTOferta;
import utils.DTPostulacion;
import utils.DTPostulante;
import utils.DTPublicacion;
import utils.DTUsuario;
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

  private void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    String nombreOferta = req.getParameter("nombreOferta");
    if (!nombreOferta.isEmpty()) {
      Fabrica factory = Fabrica.getInstance();
      IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
      IControladorOfertas ICO = factory.getIControladorOfertas();
      try {    
        Gson gsonAux = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
        DTPublicacion publicacion = ICP.obtenerPublicacionAsociadaAOferta(nombreOferta).toDatatype();
        DTOferta oferta = ICO.obtenerDatosOferta(nombreOferta);
        String publicacionJSON = gsonAux.toJson(publicacion);
        req.setAttribute("publicacion", publicacionJSON);
        
        UtilidadesJWT jwtUtil = UtilidadesJWT.obtenerInstancia();
        DTUsuario user = jwtUtil.obtenerDatosDeUsuarioJWT(req, resp);
        if (user != null) {
          req.setAttribute("imgPerfil", (String) user.getUrlImagen());
          if (user instanceof DTPostulante) {
            DTPostulacion mostrarPostulacion = null;
            try {
              mostrarPostulacion = ICO.estaPostuladoAOfertaLaboral(user.getNickname(), oferta.getNombre());
            } catch (NicknameNoExisteException | UsuarioNoEsPostulanteException e) {
              // TODO: handle exception
            }
            if (mostrarPostulacion != null) {
              String mostrarPostulacionJSON = gsonAux.toJson(mostrarPostulacion);
              req.setAttribute("postulacion", mostrarPostulacionJSON);
            }
          }
        }
      } catch (OfertaNoExisteException e) {
        e.printStackTrace();
      }
    }
    
    UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
    String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(req, resp);
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