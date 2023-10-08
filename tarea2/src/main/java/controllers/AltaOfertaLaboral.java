package controllers;

// Importaciones específicas en lugar de importaciones con asterisco
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

 /**
 * Servlet implementation class AltaOfertaLaboral
 */
@WebServlet("/altaOfertaLaboral")
public class AltaOfertaLaboral extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
  * @see HttpServlet#HttpServlet()
  */
  public AltaOfertaLaboral() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
    UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
    String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(req, resp);
    switch (tipoUsuario) {
      case "postulante":
        req.getRequestDispatcher("/WEB-INF/postulante/dashboardPostulante.jsp").forward(req, resp);
        break;
      case "empresa":
        req.getRequestDispatcher("/WEB-INF/empresa/altaOfertaLaboral.jsp").forward(req, resp);
        break;
      default:
        req.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(req, resp);
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
    doGet(request, response);
  }
}
