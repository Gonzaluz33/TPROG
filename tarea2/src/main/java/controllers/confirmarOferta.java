package controllers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Fabrica;
import model.IControladorOfertas;
import utils.DTUsuario;
import excepciones.OfertaNoExisteException;

@WebServlet("/confirmarOferta")
public class confirmarOferta extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public confirmarOferta() {
        super();
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreOferta = request.getParameter("nombreOferta");
        if (nombreOferta != null && !nombreOferta.isEmpty()) {
        	UtilidadesJWT utilsJwt = UtilidadesJWT.obtenerInstancia();
        	DTUsuario user = utilsJwt.obtenerDatosDeUsuarioJWT(request, response);
        	Fabrica factory = Fabrica.getInstance();
        	IControladorOfertas ICO = factory.getIControladorOfertas();
        	boolean perteneceAUsuario = false;
        	try {
				perteneceAUsuario = ICO.verificarPertenenciaOferta(nombreOferta, user.getNickname());
			} catch (OfertaNoExisteException e) {
				
			}
        	if(perteneceAUsuario) {
        		try {
	            	ICO.confirmarOfertaLaboral(nombreOferta);
	                request.setAttribute("mensaje", "La oferta ha sido confirmada exitosamente.");
	            } catch (OfertaNoExisteException e) {
	                request.setAttribute("mensaje", "Error: La oferta no existe."); 
	            }
        	}
            request.getRequestDispatcher("visitante").forward(request, response);
        } else {
            request.setAttribute("mensaje", "Error: Nombre de oferta no proporcionado."); 
            request.getRequestDispatcher("/WEB-INF/empresa/MiUsuario.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
