package controllers;

// Importaciones específicas en lugar de importaciones con asterisco
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.java.dev.jaxb.array.StringArray;
import servidor.publicar.*;
import utils.CookiesUtils;
import utils.LocalDateSerializer;
import utils.LocalDateTimeAdapter;

import java.io.IOException;
import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	private static servidor.publicar.ServicioOfertasService serviceOfertas = new servidor.publicar.ServicioOfertasService();
	private static servidor.publicar.ServicioOfertas portOfertas = serviceOfertas.getServicioOfertasPort();
	private static servidor.publicar.ServicioUsuariosService service = new servidor.publicar.ServicioUsuariosService();
	private static servidor.publicar.ServicioUsuarios portUsuarios = service.getServicioUsuariosPort();
    private static CookiesUtils cookies = CookiesUtils.obtenerInstancia();
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
     * @throws KeywordExisteException_Exception 
	 * 
	 */
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UsuarioRepetidoException, NicknameNoExisteException, NombreExisteException, KeywordExisteException, KeywordExisteException_Exception {
    	String jwt = cookies.obtenerJWTEnCookies(request, response);
    	if(jwt != null) {
    		 String tipoUsuario = portUsuarios.tipoUsuario(jwt);
    	        DtUsuario user = portUsuarios.obtenerDatosDeUsuarioJWT(jwt);
    	        if(user!=null) {
    	        	request.setAttribute("imgPerfil", user.getUrlImagen());
    	        }
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
    	                	StringArray keywordsList = (StringArray) Arrays.asList(keywords);
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
    	     	            	    (keywords==null || keywords.length == 0) || formaPago.isEmpty() || (formaPago.isEmpty() && (paqueteSeleccionado == null || paqueteSeleccionado.isEmpty()))) {           		 
    	     	            	    request.setAttribute("error", "Todos los campos son obligatorios.");
    	     	            	    request.getRequestDispatcher("/WEB-INF/empresa/altaOfertaLaboral.jsp").forward(request, response);
    	     	            	    
    	     	            	} else {
    	     	            		try {
    	     	            		
    	     	            		DtUsuario usuarioActual = portUsuarios.obtenerDatosDeUsuarioJWT(jwt);
    	     	            		String usuarioNickname = usuarioActual.getNickname();
    	     	            		portOfertas.altaOfertaWeb(nombre, descripcion, remuneracion, horario, ciudad, departamento,
    	     	            				tipoPublicacion, formaPago, paqueteSeleccionado,EnumEstadoOferta.INGRESADA, keywordsList, urlImagen,
    	     	            				usuarioNickname);		     	            		
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
    	                	
    	                	List<String> keywords = portOfertas.obtenerKeywords().getItem();
    	                	List<DtTipoPublicacion> tiposPub = portOfertas.obtenerTipos().getItem();
    	                	Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
    	                	        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
    	                	String tiposPubJson = gson.toJson(tiposPub);
    	                	String keywordsJson = gson.toJson(keywords);
    	                	request.setAttribute("tiposPub", tiposPubJson);
    	                	request.setAttribute("keywords", keywordsJson);
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
    	else {
    		request.getRequestDispatcher("/WEB-INF/visitante/inicio.jsp").forward(request, response);
    	}

    }
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException  e) {
			e.printStackTrace();
		}
		catch (UsuarioRepetidoException e) {
            e.printStackTrace();
		} catch (NicknameNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NombreExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeywordExisteException_Exception e) {
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
	        request.getRequestDispatcher("/WEB-INF/errorPages/ofertaExiste.jsp").forward(request, response);
	        e.printStackTrace();
	    } catch (UsuarioRepetidoException e) {
	        request.setAttribute("error", "El nickname ya existe.");
	        request.getRequestDispatcher("/WEB-INF/errorPages/ofertaExiste.jsp").forward(request, response);
	        e.printStackTrace();
	    } catch (NicknameNoExisteException e) {
	        request.setAttribute("error", "El nickname no existe.");
	        request.getRequestDispatcher("/WEB-INF/errorPages/ofertaExiste.jsp").forward(request, response);
	        e.printStackTrace();
	    } catch (NombreExisteException e) {
	        request.getRequestDispatcher("/WEB-INF/errorPages/ofertaExiste.jsp").forward(request, response);
	        e.printStackTrace();
	    } catch (KeywordExisteException e) {
	        request.setAttribute("error", "La palabra clave ya existe.");
	        request.getRequestDispatcher("/WEB-INF/errorPages/ofertaExiste.jsp").forward(request, response);
	        e.printStackTrace();
	    } catch (KeywordExisteException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
