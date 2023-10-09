package controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletContext;
import excepciones.CorreoRepetidoException;
import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;
import excepciones.NombreExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.PaqueteExisteException;
import excepciones.TipoPublicExisteException;
import excepciones.UsuarioNoEsPostulanteException;
import excepciones.UsuarioRepetidoException;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import model.Fabrica;
import model.IControladorOfertas;
import model.IControladorPublicaciones;
import model.IControladorUsuario;
import model.Postulacion;
import utils.EnumEstadoOferta;

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
	    	 String csvFilePathEmpresas = sce.getServletContext().getRealPath("/WEB-INF/DatosCSV/Empresas.csv");
	    	 String csvFilePathTiposPublicacion = sce.getServletContext().getRealPath("/WEB-INF/DatosCSV/TiposPublicacion.csv");
	    	 String csvFilePathPaquetes = sce.getServletContext().getRealPath("/WEB-INF/DatosCSV/Paquetes.csv");
	    	 String csvFilePathTiposPublicacionPaquetes = sce.getServletContext().getRealPath("/WEB-INF/DatosCSV/TiposPublicacionPaquetes.csv");
	    	 String csvFilePathOfertasLaboralesPrueba = sce.getServletContext().getRealPath("/WEB-INF/DatosCSV/OfertasLaboralesPrueba.csv");	    	 
	    	 String csvFilePathPostulaciones = sce.getServletContext().getRealPath("/WEB-INF/DatosCSV/Postulaciones.csv");

	    	 try {
	     		cargarDatosPostulantes(csvFilePathPostulantes);
	     		cargarDatosKeywords(csvFilePathKeywords);
	     		cargarDatosEmpresas(csvFilePathEmpresas); 
	     		cargarDatosTipoPublicacion(csvFilePathTiposPublicacion);
	     		cargarDatosPaquetes(csvFilePathPaquetes);
	     		cargarDatosTiposPublicacionPaquetes(csvFilePathTiposPublicacionPaquetes);
	     		cargarDatosOfertasLaboralesPrueba(csvFilePathOfertasLaboralesPrueba);
	     		cargarPostulaciones(csvFilePathPostulaciones);
				context.setAttribute("datosCargados", "true");
			} catch (UsuarioRepetidoException | CorreoRepetidoException | KeywordExisteException | TipoPublicExisteException | PaqueteExisteException | NombreExisteException | NicknameNoExisteException | IOException e) {
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
    
    
    private LocalDate parseFechaNacimiento(String fechaNacimiento) {
	    try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

	        LocalDate fechaNacimientoParsed = LocalDate.parse(fechaNacimiento, formatter);
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
    private LocalDate parseFecha(String fecha) {
	    try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate fechaParsed = LocalDate.parse(fecha, formatter);
	            return fechaParsed;
	    } catch (DateTimeParseException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
    
    
    private void cargarDatosKeywords(String csvFile) throws KeywordExisteException{	
	    String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader bufferReader = new BufferedReader(new FileReader(csvFile))) {
	    	//br.readLine();
	        while ((line = bufferReader.readLine()) != null) {
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
        String line;
        String csvSplitBy = ";";
        int iter = 1;
        try (BufferedReader bufferReader = new BufferedReader(new FileReader(csvFile))) {
            // Leer la primera línea (encabezados) y descartarla si es necesario
            //br.readLine();
            while ((line = bufferReader.readLine()) != null) {
                String[] datos = line.split(csvSplitBy);
                String nickname = "";
	            String nombre = "";
	            String apellido = "";
	            String correo = "";
	            LocalDate fecha = null;
	            String nacionalidad = "";
	            String password = "";
	            String url_imagen = "";
	            if(datos.length > 0) {
	            	 nickname = datos[0];
	            	 nombre = datos[1];
	            	 apellido = datos[2];
	            	 correo = datos[3];
	            	 fecha = parseFechaNacimiento(datos[4].trim());
	            	 nacionalidad = datos[5];
	            	 password = datos[6];
	            	 url_imagen = "media/img/imgPostulantes/U"+iter+".jpg";
	            	 iter++;
	            	 Fabrica factory = Fabrica.getInstance();
	            	 IControladorUsuario ICU = factory.getIControladorUsuario();
	            	 ICU.altaPostulante(nickname, nombre, apellido, correo, password,fecha, nacionalidad,url_imagen);
	            }
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 
      
    }
    
    private void cargarDatosEmpresas(String csvFile) throws UsuarioRepetidoException, CorreoRepetidoException {	
	    String line = "";
	    String cvsSplitBy = ";";
	    int iter = 11;
	    try (BufferedReader bufferReader = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = bufferReader.readLine()) != null) {
	            String[] empresaData = line.split(cvsSplitBy);
	            String nickname = "";
	            String nombre = "";
	            String apellido = "";
	            String correo = "";
	            String descripcion = "";
	            String link = "";
	            String password = "";
	            String url_imagen = "";            
	            if(empresaData.length > 0) {
	            	 nickname = empresaData[0];
	            	 nombre = empresaData[1];
	            	 apellido = empresaData[2];
	            	 correo = empresaData[3];
	            	 descripcion = empresaData[4];
			         link = empresaData[5]; 
			         password = empresaData[6];
			         url_imagen = "media/img/imgEmpresas/U"+iter+".jpg";
	            	 iter++;
			         Fabrica factory = Fabrica.getInstance();
	            	 IControladorUsuario ICU = factory.getIControladorUsuario();
	            	 ICU.altaEmpresa(nickname, nombre, apellido, correo, password,nickname, descripcion, link,url_imagen);
	            }
	            
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	   
	}
    private void cargarDatosTipoPublicacion(String csvFile) throws TipoPublicExisteException{	
	    String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader bufferReader = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = bufferReader.readLine()) != null) {
	            String[] tiposPublicaionData = line.split(cvsSplitBy);
	            String nombre = "";
	            String desc = "";
	            int exp = 0;
	            Integer duracion = 0;
	            Integer costo = 0;
	            LocalDate alta = null;	            
	            if(tiposPublicaionData.length > 0) {
	            	 nombre = tiposPublicaionData[0];
	            	 desc = tiposPublicaionData[1];
	            	 exp = Integer.parseInt(tiposPublicaionData[2]) ;
	            	 duracion = Integer.parseInt(tiposPublicaionData[3]) ;
	            	 costo = Integer.parseInt(tiposPublicaionData[4]);
	            	 alta = parseFecha(tiposPublicaionData[5].trim());
	            	 Fabrica factory = Fabrica.getInstance();
	            	 IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
	            	 ICP.altaTipoPublicacionOL(nombre, desc, exp, duracion, costo, alta);
	            }
	            
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	   
	}
    
    private void cargarDatosPaquetes(String csvFile) throws KeywordExisteException, PaqueteExisteException{	  
	    String line = "";
	    String cvsSplitBy = ";";
	    int iter = 1;
	    try (BufferedReader bufferReader = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = bufferReader.readLine()) != null) {
	            String[] paquetesData = line.split(cvsSplitBy);
	            String nombreTipo = "";
	            String descripcionTipo = "";
	            int validez = 0;
	            int descuento = 0;
	            String fechaAlta = "00/00/0000";
	            String url_imagen = "";
	            if(paquetesData.length > 0) {
	            	nombreTipo = paquetesData[0];
	            	descripcionTipo = paquetesData[1];
	            	validez = Integer.parseInt(paquetesData[2]);
	            	descuento = Integer.parseInt(paquetesData[3]);
	            	fechaAlta = paquetesData[4];
	            	url_imagen = "media/img/imgPaquetes/Paq"+iter+".jpg";
			        iter++;
	             	Fabrica factory = Fabrica.getInstance();
	            	IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
	            	ICP.altaPaqueteTipoPublicacion(nombreTipo, descripcionTipo, validez, descuento, fechaAlta,url_imagen);
	            }      
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	   
	}
    
   private void cargarDatosTiposPublicacionPaquetes(String csvFile){	
	    String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader bufferReader = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = bufferReader.readLine()) != null) {
	            String[] tiposPublicaionPaquetesData = line.split(cvsSplitBy);
	            String nombrePaquete = "";
	            Integer cantidad = 0;
	            String nombreTipoPublicacion = "";
	            if(tiposPublicaionPaquetesData.length > 0) {
	            	nombrePaquete = tiposPublicaionPaquetesData[0];
	            	cantidad = Integer.parseInt(tiposPublicaionPaquetesData[2]);
	            	nombreTipoPublicacion = tiposPublicaionPaquetesData[1];
	            	Fabrica factory = Fabrica.getInstance();
	            	IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
	            	ICP.agregarTipoPublicacion(nombrePaquete,cantidad,nombreTipoPublicacion);
	            }
	            
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	   
	}
   
   
   private void cargarDatosOfertasLaboralesPrueba(String csvFile) throws NombreExisteException, KeywordExisteException, NicknameNoExisteException{	
	   	String line = "";
	    String cvsSplitBy = ";";
	    int iter = 1;
	    try (BufferedReader bufferReader = new BufferedReader(new FileReader(csvFile))) {
	    	bufferReader.readLine();
	        while ((line = bufferReader.readLine()) != null) {
	            String[] ofertasLaboralesData = line.split(cvsSplitBy);
	            String nombre = "";    
	            String desc = ""; 
	            String rem = ""; 
	            String horario = ""; 
	            List<String> keysList = new ArrayList<>();
	            String ciudad = ""; 
	            String depa = ""; 
	            String tipo = "";
	            String empresa = ""; 
	            String url_imagen = "";  
	            String estado = "";
	            String formaPago = "";
	            String compraPaquete = "";
	            String paqueteSeleccionado = "";
	            Fabrica factory = Fabrica.getInstance();
           	 	IControladorOfertas ICO = factory.getIControladorOfertas();
	            if(ofertasLaboralesData.length > 0) {
	            	
	            	 nombre = ofertasLaboralesData[0];
	            	 desc = ofertasLaboralesData[1];
	            	 rem = ofertasLaboralesData[5];
	            	 horario = ofertasLaboralesData[4];
	            	 ciudad = ofertasLaboralesData[3];
	            	 depa = ofertasLaboralesData[2];
	            	 tipo = ofertasLaboralesData[7];
	            	 empresa = ofertasLaboralesData[6];
	            	 estado = ofertasLaboralesData[9];
	            	 compraPaquete = ofertasLaboralesData[10];
	            	 if ("Sin paquete".equals(compraPaquete)) {
	            		    formaPago = "General";
	            		} else {
	            		    formaPago = "Paquete adquirido previamente";
	            		    paqueteSeleccionado = compraPaquete;
	            		}

	            	 
			         url_imagen = "media/img/imgOfertas/O"+iter+".jpg";
			         
			         iter++;
			         keysList = Arrays.asList(ofertasLaboralesData[12].split("/"));
		                
		             // Convertir la lista keysList a un array de String
		             String[] keysArray = keysList.toArray(new String[0]);
                     
		             //cambio de string al enumerado el estado
		             EnumEstadoOferta estadoEnum = null;
		             if ("Ingresada".equals(estado)) {
		                 estadoEnum = EnumEstadoOferta.INGRESADA;
		             } else if ("Confirmada".equals(estado)) {
		                 estadoEnum = EnumEstadoOferta.CONFIRMADA;
		             } else if ("Rechazada".equals(estado)) {
		                 estadoEnum = EnumEstadoOferta.RECHAZADA;
		             }
		             try {
		                 ICO.altaOfertaWeb(nombre, desc, rem, horario, ciudad, depa, tipo, formaPago, paqueteSeleccionado,estadoEnum , keysArray, url_imagen, empresa);
	            	 }catch(Exception e) {
	            		 e.printStackTrace();
	            	 }
	            } 
	            
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	   
	}
   
   private void cargarPostulaciones(String csvFile) throws FileNotFoundException, IOException {
	   String line = "";
	   String cvsSplitBy = ";";
	   try (BufferedReader bufferReader = new BufferedReader(new FileReader(csvFile))) {
		   while ((line = bufferReader.readLine()) != null) {
			   //String nombreOfertaLaboral, String nicknamePostulante, String CVReducido, String motivacion,  LocalDateTime fechaPublic 
			   String[] postulacionesData = line.split(cvsSplitBy);
	           String nombre = "";    
	           String motivacion = "";
	           String nickname = ""; 
	           String cv = "";

	           LocalDateTime fecha = null;
	           if(postulacionesData.length > 0) {
	        	   nickname = postulacionesData[0];
	        	   nombre = postulacionesData[4];
	        	   cv = postulacionesData[1];
	        	   motivacion = postulacionesData[2];
	        	   fecha= parseFecha(postulacionesData[3].trim()).atStartOfDay();
	        	   Fabrica factory = Fabrica.getInstance();
	               IControladorOfertas ICO = factory.getIControladorOfertas();
	               try {
	            	   ICO.postularAOferta(nombre, nickname, cv, motivacion, fecha);
            	   }catch(Exception e) {
	            		 
	            	 }
	           }

		   }
	   }catch (IOException e) {
	        e.printStackTrace();
	    }
   }
	
}
