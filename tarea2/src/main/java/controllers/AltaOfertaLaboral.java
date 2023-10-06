package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Fabrica;
import model.IControladorOfertas;

import java.io.IOException;

import excepciones.CorreoRepetidoException;
import excepciones.NicknameNoExisteException;
import excepciones.UsuarioRepetidoException;

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
    
    /**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 * 
	 */
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UsuarioRepetidoException {
        UtilidadesJWT utilidadesJWT = UtilidadesJWT.obtenerInstancia();
        String tipoUsuario = utilidadesJWT.obtenerTipoUsuarioPorRequest(request, response);
        
        switch(tipoUsuario) {
            case "empresa":
                if ("POST".equalsIgnoreCase(request.getMethod())) {
                	String tipoPublicacion = request.getParameter("tipoPublicacion");
                	String nombre = request.getParameter("nombre");
                	String remuneracion = request.getParameter("remuneracion");
                	String horario = request.getParameter("horario");
                	String departamento = request.getParameter("departamento");
                	String ciudad = request.getParameter("ciudad");
                	String urlImagen = request.getParameter("urlImagen");
                	String descripcion = request.getParameter("descripcion");
                	String[] keywords = request.getParameterValues("keywords"); 
                	String formaPago = request.getParameter("formaPago");
                	String paqueteSeleccionado = request.getParameter("paqueteSeleccionado");	
                	 if (tipoPublicacion.isEmpty() || nombre.isEmpty() || remuneracion.isEmpty() || horario.isEmpty() || 
     	            	    departamento.isEmpty() || ciudad.isEmpty() || descripcion.isEmpty() || 
     	            	    (keywords==null || keywords.length == 0) || formaPago.isEmpty() || paqueteSeleccionado.isEmpty()) {           		 
     	            	    request.setAttribute("error", "Todos los campos son obligatorios.");
     	            	    request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
     	            	    
     	            	} else {
     	            		Fabrica factory = Fabrica.getInstance();
     	            		IControladorOfertas iconofer = factory.getIControladorOfertas();
     	            		iconofer.altaOferta(nombre, descripcion, remuneracion, horario, ciudad, departamento, tipoPublicacion, formaPago, paqueteSeleccionado, keywords);
     	            		
     	            		
     	            		request.setAttribute("message", "Oferta laboral registrada con éxito");
     	                    // req.getRequestDispatcher("/WEB-INF/empresa/confirmacionOferta.jsp").forward(req, resp);
     	            	}		
                    
                } else {
                    // Es un GET, solo mostrar el formulario
                    request.getRequestDispatcher("/WEB-INF/empresa/altaOfertaLaboral.jsp").forward(request, response);
                }
                break;

            case "postulante":
                request.getRequestDispatcher("/WEB-INF/postulante/dashboardPostulante.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(request, response);
                break;
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException  e) {
			request.setAttribute("error", "Ocurrio un error.");
            request.getRequestDispatcher("/WEB-INF/registro/altaOfertaLaboral.jsp").forward(request, response);
			e.printStackTrace();
		}
		catch (UsuarioRepetidoException e) {
			request.setAttribute("error", "El nickname ya existe.");
            request.getRequestDispatcher("/WEB-INF/registro/altaOfertaLaboral.jsp").forward(request, response);
            e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException  e) {
			request.setAttribute("error", "Ocurrio un error.");
            request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
			e.printStackTrace();
		}
		catch (UsuarioRepetidoException e) {
			request.setAttribute("error", "El nickname ya existe.");
            request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
            e.printStackTrace();
		}
	}

}
