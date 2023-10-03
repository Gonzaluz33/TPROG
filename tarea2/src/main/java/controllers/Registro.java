package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import excepciones.CorreoRepetidoException;
import excepciones.NicknameNoExisteException;
import excepciones.UsuarioRepetidoException;
import model.IControladorUsuario;
import model.Fabrica;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Servlet implementation class Login
 */
@WebServlet("/registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registro() {
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
	 * @throws NicknameNoExisteException 
	 * @throws CorreoRepetidoException 
	 * @throws UsuarioRepetidoException 
	 * 
	 */
	
	public boolean isValidEmail(String email) {
	    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, UsuarioRepetidoException, CorreoRepetidoException{
		  String action = request.getParameter("action");
	        if ("altaEmpresa".equals(action)) {
	            String nickname = request.getParameter("nickname");
	            String nombre = request.getParameter("nombre");
	            String apellido = request.getParameter("apellido");
	            String email = request.getParameter("email");
	            String nomEmpresa = request.getParameter("nomEmpresa");
	            String desc = request.getParameter("desc");
	            String linkWeb = request.getParameter("linkWeb");
	            String password = request.getParameter("password");
	            String passwordConfirm = request.getParameter("confirmar_contrasena");
	            if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || 
	            	    nomEmpresa.isEmpty() || desc.isEmpty() || linkWeb.isEmpty() || password.isEmpty() || 
	            	    passwordConfirm.isEmpty()) {
	            	    request.setAttribute("error", "Todos los campos son obligatorios.");
	            	    request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
	            	} else {
				            if (!password.equals(passwordConfirm)) {
				                request.setAttribute("error", "Las contraseñas no coinciden.");
				                request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
				            }else {
				            	if(isValidEmail(email)) {
				            	Fabrica factory = Fabrica.getInstance();
					            IControladorUsuario iconuser = factory.getIControladorUsuario();
					            iconuser.altaEmpresa(nickname,nombre,apellido,email,password,nomEmpresa,desc,linkWeb);
					            request.setAttribute("succes_register", "Usuario Registrado con exito.");
					            response.sendRedirect("visitante");
				            	}else {
				            		request.setAttribute("error", "El email ingresado no es valido.");
					                request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
				            	}
				            }
	            	}
	        } else {
	        	if ("altaPostulante".equals(action)) {
	                String nickname = request.getParameter("nickname");
	                String nombre = request.getParameter("nombre");
	                String apellido = request.getParameter("apellido");
	                String email = request.getParameter("email");
	                String fechaNacimiento = request.getParameter("fechaNacimiento");
	                String nacionalidad = request.getParameter("nacionalidad");
	                String password = request.getParameter("password");
	                String passwordConfirm = request.getParameter("confirmar_contrasena");
	                if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || 
	                	    fechaNacimiento.isEmpty() || nacionalidad.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
	                	    request.setAttribute("error", "Todos los campos son obligatorios.");
	                	    request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
	                	} else {
	                		if (!password.equals(passwordConfirm)) {
				                request.setAttribute("error", "Las contraseñas no coinciden.");
				                request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
				            }else {
				            	if(isValidEmail(email)) {
					                Fabrica factory = Fabrica.getInstance();
					            	IControladorUsuario iconuser = factory.getIControladorUsuario();
					            	LocalDate fecha = parseFecha(fechaNacimiento);
					            	if(fecha != null) {
						                iconuser.altaPostulante(nickname,nombre,apellido,email,password,fecha,nacionalidad);
						                request.setAttribute("succes_register", "Usuario Registrado con exito.");
						                request.getRequestDispatcher("visitante").forward(request, response);
						                //response.sendRedirect("visitante");
					            	}else {
					            		request.setAttribute("error", "La fecha es invalida.");
						                request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
					            	}
				            	}else {
				            		request.setAttribute("error", "El email ingresado no es valido.");
					                request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
				            	}
				            }
	                	}          
	        	}else {
	        		request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
	        	}
	        }
	}

	private LocalDate parseFecha(String fechaNacimiento) {
	    try {
	        LocalDate fechaNacimientoParsed = LocalDate.parse(fechaNacimiento);
	        LocalDate fechaActual = LocalDate.now();
	        if (fechaNacimientoParsed.isBefore(fechaActual)) {
	            return fechaNacimientoParsed;
	        } else {
	            return null;
	        }
	    } catch (DateTimeParseException e) {
	        e.printStackTrace();
	        return null;
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
		} catch (ServletException | IOException  e) {
			request.setAttribute("error", "Ocurrio un error.");
            request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
			e.printStackTrace();
		}
		catch (UsuarioRepetidoException e) {
			request.setAttribute("error", "El nickname ya existe.");
            request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
            e.printStackTrace();
		} catch (CorreoRepetidoException e) {
			request.setAttribute("error", "El correo ya existe.");
            request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
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
				} catch (ServletException | IOException  e) {
					request.setAttribute("error", "Ocurrio un error.");
	                request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
					e.printStackTrace();
				}
				catch (UsuarioRepetidoException e) {
					request.setAttribute("error", "El nickname ya existe.");
	                request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
	                e.printStackTrace();
				} catch (CorreoRepetidoException e) {
					request.setAttribute("error", "El correo ya existe.");
	                request.getRequestDispatcher("/WEB-INF/registro/registro.jsp").forward(request, response);
	                e.printStackTrace();
				}
	}
}
	
	

	
