package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import jakarta.servlet.ServletContext;
import excepciones.CorreoRepetidoException;
import excepciones.KeywordExisteException;
import excepciones.UsuarioRepetidoException;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import model.Fabrica;
import model.IControladorOfertas;
import model.IControladorUsuario;

/**
 * Application Lifecycle Listener implementation class InicializadorAppListener
 *
 */
@WebListener
public class InicializadorAppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InicializadorAppListener() {
        // TODO Auto-generated constructor stub
    }
    
    
    //esta funcionando la carga de datos al inicio falta terminarla y agregar los csv
    
    

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	 ServletContext context = sce.getServletContext();
	     boolean datosCargados = Boolean.parseBoolean(context.getInitParameter("datosCargados"));
	     if (!datosCargados) {
	    	 String csvFilePathPostulantes = sce.getServletContext().getRealPath("/WEB-INF/DatosCSV/Postulantes.csv");
	    	 String csvFilePathKeywords = sce.getServletContext().getRealPath("/WEB-INF/DatosCSV/Keywords.csv");
	     	 try {
	     		cargarDatosPostulantes(csvFilePathPostulantes);
	     		cargarDatosKeywords(csvFilePathKeywords);
				context.setAttribute("datosCargados", "true");
			} catch (UsuarioRepetidoException | CorreoRepetidoException | KeywordExisteException e) {
				e.printStackTrace();
			}
	    	
	     }
  
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
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
    
    private void cargarDatosKeywords(String csvFile) throws KeywordExisteException{	
	    String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	    	//br.readLine();
	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(cvsSplitBy);
	            String nombre = "";         
	            if(data.length > 0) {
	            	 nombre = data[0];
	            	 Fabrica factory = Fabrica.getInstance();
	            	 IControladorOfertas ICO = factory.getIControladorOfertas();
	            	 ICO.altaKeyword(nombre);
	            }      
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
    }
	   
    
    private void cargarDatosPostulantes(String csvFile) throws UsuarioRepetidoException, CorreoRepetidoException {
    	//String csvFile1 = "/java/Datos/Postulantes.csv";
        String line;
        String csvSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Leer la primera línea (encabezados) y descartarla si es necesario
            // Si tus datos CSV tienen encabezados, puedes descartar la primera línea
            //br.readLine();
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(csvSplitBy);
                String nickname = "";
	            String nombre = "";
	            String apellido = "";
	            String correo = "";
	            LocalDate fecha = null;
	            String nacionalidad = "";
	            if(datos.length > 0) {
	            	 nickname = datos[0];
	            	 nombre = datos[1];
	            	 apellido = datos[2];
	            	 correo = datos[3];
	            	 fecha = parseFecha(datos[4].trim());
	            	 nacionalidad = datos[5];
	            	 Fabrica factory = Fabrica.getInstance();
	            	 IControladorUsuario ICU = factory.getIControladorUsuario();
	            	 ICU.altaPostulante(nickname, nombre, apellido, correo, "asdasd" ,fecha, nacionalidad);
	            }
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 
      
    }
	
}
