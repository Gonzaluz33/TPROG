package controllers;

// Importaciones específicas en lugar de importaciones con asterisco
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Fabrica;
import model.IControladorOfertas;
import model.IControladorUsuario;
import model.TokenBlacklist;
import utils.DTUsuario;
import utils.EnumEstadoOferta;

import java.io.IOException;
import java.security.Key;

import excepciones.CorreoRepetidoException;
import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;
import excepciones.NombreExisteException;
import excepciones.UsuarioRepetidoException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

 /**
 * Servlet implementation class AltaOfertaLaboral
 */
@WebServlet("/altaOfertaLaboral")
public class AltaOfertaLaboral extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String secret_Key = "6a2b5c8e1f4a7d0987654321abcdef09"; // Clave secreta para verificar JWT
       
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
     * @throws KeywordExisteException 
     * @throws NombreExisteException 
     * @throws NicknameNoExisteException 
	 * 
	 */
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UsuarioRepetidoException, NicknameNoExisteException, NombreExisteException, KeywordExisteException {
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
                	int remuneracionInt = 0; // Default value
                	boolean remuneracionValida = false;

                	if (!remuneracion.isEmpty()) {
                	    try {
                	        remuneracionInt = Integer.parseInt(remuneracion);
                	        if (remuneracionInt >= 0) {
                	            remuneracionValida = true;
                	        }
                	    } catch (NumberFormatException e) {
                	        // La conversión falló; remuneracionValida permanece como false.
                	    }
                	}
                	String paqueteSeleccionado = request.getParameter("paqueteSeleccionado");	
                	 if (tipoPublicacion.isEmpty() || nombre.isEmpty() ||  !remuneracionValida || horario.isEmpty() || 
     	            	    departamento.isEmpty() || ciudad.isEmpty() || descripcion.isEmpty() || 
     	            	    (keywords==null || keywords.length == 0) || formaPago.isEmpty() || (paqueteSeleccionado == null || paqueteSeleccionado.isEmpty())) {           		 
     	            	    request.setAttribute("error", "Todos los campos son obligatorios.");
     	            	    request.getRequestDispatcher("/WEB-INF/empresa/altaOfertaLaboral.jsp").forward(request, response);
     	            	    
     	            	} else {
     	            		try {
     	            		Fabrica factory = Fabrica.getInstance();
     	            		IControladorOfertas iconofer = factory.getIControladorOfertas();
     	            		DTUsuario usuarioActual = utilidadesJWT.obtenerDatosDeUsuarioJWT(request, response);
     	            		String usuarioNickname = usuarioActual.getNickname();
     	            		iconofer.altaOfertaWeb(nombre, descripcion, remuneracion, horario, ciudad, departamento, tipoPublicacion, formaPago, paqueteSeleccionado,EnumEstadoOferta.INGRESADA, keywords, urlImagen, usuarioNickname);		     	            		
     	            		request.setAttribute("message", "Oferta laboral registrada con éxito");
     	                    request.getRequestDispatcher("/Empresa").forward(request, response);
     	            		}
     	                   catch (Exception e) {
     	                	    // Aquí puedes registrar el error y mostrar un mensaje de error al usuario.
     	                	    e.printStackTrace();
     	                	    request.setAttribute("error", "Hubo un problema al registrar la oferta laboral. Por favor, inténtalo de nuevo.");
     	                	    request.getRequestDispatcher("/WEB-INF/empresa/altaOfertaLaboral.jsp").forward(request, response);
     	                	}
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
            request.getRequestDispatcher("/WEB-INF/empresa/altaOfertaLaboral.jsp").forward(request, response);
			e.printStackTrace();
		}
		catch (UsuarioRepetidoException e) {
			request.setAttribute("error", "El nickname ya existe.");
            request.getRequestDispatcher("/WEB-INF/empresa/altaOfertaLaboral.jsp").forward(request, response);
            e.printStackTrace();
		} catch (NicknameNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NombreExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeywordExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        processRequest(request, response);
	    } catch (ServletException | IOException e) {
	        request.setAttribute("error", "Ocurrió un error.");
	        request.getRequestDispatcher("/WEB-INF/empresa/registro.jsp").forward(request, response);
	        e.printStackTrace();
	    } catch (UsuarioRepetidoException e) {
	        request.setAttribute("error", "El nickname ya existe.");
	        request.getRequestDispatcher("/WEB-INF/empresa/registro.jsp").forward(request, response);
	        e.printStackTrace();
	    } catch (NicknameNoExisteException e) {
	        request.setAttribute("error", "El nickname no existe.");
	        request.getRequestDispatcher("/WEB-INF/empresa/registro.jsp").forward(request, response);
	        e.printStackTrace();
	    } catch (NombreExisteException e) {
	        request.setAttribute("error", "Ya existe una oferta laboral con el nombre ingresado.");
	        request.getRequestDispatcher("/WEB-INF/empresa/altaOfertaLaboral.jsp").forward(request, response);
	        e.printStackTrace();
	    } catch (KeywordExisteException e) {
	        request.setAttribute("error", "La palabra clave ya existe.");
	        request.getRequestDispatcher("/WEB-INF/empresa/altaOfertaLaboral.jsp").forward(request, response);
	        e.printStackTrace();
	    }
	}
	
}
