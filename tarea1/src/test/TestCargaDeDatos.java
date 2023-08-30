package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.*;
import logica.*;
import utils.*;

public class TestCargaDeDatos {
	
	Fabrica fabrica = Fabrica.getInstance();
	IControladorUsuario ICU = fabrica.getIControladorUsuario();
	IControladorPublicaciones ICP = fabrica.getIControladorPublicaciones();
	IControladorOfertas ICO = fabrica.getIControladorOfertas();

	// setup para tests
	@SuppressWarnings("unused")
	private static IControladorOfertas controladorOfertas;
	@SuppressWarnings("unused")
	private static IControladorUsuario controladorUsuarios;
	@SuppressWarnings("unused")
	private static IControladorPublicaciones controladorPublicaciones;
	
	private static ManejadorUsuarios manejadorU;
	private static ManejadorOfertaLaboral manejadorOL;
	private static ManejadorPublicaciones manejadorP;
	
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		controladorOfertas = fabrica.getIControladorOfertas();
		controladorUsuarios = fabrica.getIControladorUsuario();
		controladorPublicaciones = fabrica.getIControladorPublicaciones();
		
		manejadorU = ManejadorUsuarios.getInstance();
		manejadorOL = ManejadorOfertaLaboral.getInstance();
		manejadorP = ManejadorPublicaciones.getInstance();
	}
	
	@BeforeEach
	public void reiniciarColecciones() {
		manejadorU.limpiarColeccionUsuarios();
		manejadorOL.limpiarColeccionOfertasLaborales();
		manejadorOL.limpiarColeccionKeywords();
		manejadorP.limpiarColeccionPublicaciones();
		manejadorP.limpiarColeccionPaquetes();
		manejadorP.limpiarColeccionTipos();
		this.cargarDatos();
	}
	
	// tests a ver si la carga de datos funciona bien
	@Test
	public void testCargaDatos() {
	    String currentDirectory = System.getProperty("user.dir");
	    
		try {
	    	String csvFilePostulantes = currentDirectory + File.separator + "Datos" + File.separator + "Postulantes.csv";
			testCargaDatos_Posulantes(csvFilePostulantes);
			
			String csvFileEmpresas = currentDirectory + File.separator + "Datos" + File.separator + "Empresas.csv";
			testCargaDatos_Empresas(csvFileEmpresas);
			
			String csvFileTiposPublicacion = currentDirectory + File.separator + "Datos" + File.separator + "TiposPublicacion.csv";
			testCargaDatos_TipoPublicacion(csvFileTiposPublicacion);

			String csvFileKeywords = currentDirectory + File.separator + "Datos" + File.separator + "Keywords.csv";
			testCargaDatos_Keywords(csvFileKeywords);

			String csvFileOfertaLaboral = currentDirectory + File.separator + "Datos" + File.separator + "OfertasLaborales.csv";
			testCargaDatos_OfertaLaborales(csvFileOfertaLaboral);

			String csvFilePostulaciones = currentDirectory + File.separator + "Datos" + File.separator + "Postulaciones.csv";
			testCargaDatos_Postulaciones(csvFilePostulaciones);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void testCargaDatos_Posulantes(String csvFile) throws Exception {
		String line = "";
		String cvsSplitBy = ";";
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
			    String[] postulanteData = line.split(cvsSplitBy);
			    if(postulanteData.length > 0) {
			        String nickname = postulanteData[0];
			        String nombre = postulanteData[1];
			        String apellido = postulanteData[2];
			        String correo = postulanteData[3];
			        Date fechaNacimiento = parseDate(postulanteData[4].trim());
			        String nacionalidad = postulanteData[5];
			        
			        // checkeo si existe el postulante en el sistema
			        DTUsuario usuarioDT = manejadorU.obtenerUsuario(nickname);
			        
			        // checkeo si es un postulante
			        if (!(usuarioDT instanceof DTPostulante))
			        	throw new Exception("El usuario con el nick " + nickname + " no es un postulante.");
			        DTPostulante postulanteDT = (DTPostulante) usuarioDT;
			        
			        // checkeo si los datos estan bien
			        assertEquals(postulanteDT.getNickname(), nickname);
			        assertEquals(postulanteDT.getNombre(), nombre);
			        assertEquals(postulanteDT.getApellido(), apellido);
			        assertEquals(postulanteDT.getCorreo(), correo);
			        assertEquals(postulanteDT.getFechaNacimiento(), fechaNacimiento);
			        assertEquals(postulanteDT.getNacionalidad(), nacionalidad);
			    }
			}
		}
	}
	
	public void testCargaDatos_Empresas(String csvFile) throws Exception {
		String line = "";
		String cvsSplitBy = ";";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				String[] empresaData = line.split(cvsSplitBy);
				if(empresaData.length > 0) {
					String nickname = empresaData[0];
					String nombre = empresaData[1];
					String apellido = empresaData[2];
					String correo = empresaData[3];
					String descripcion = empresaData[4];
					String link = empresaData[5];
						
					// checkeo si existe el postulante en el sistema
					DTUsuario usuarioDT = manejadorU.obtenerUsuario(nickname);
					
					// checkeo si es un postulante
					if (!(usuarioDT instanceof DTEmpresa))
						throw new Exception("El usuario con el nick " + nickname + " no es una empresa.");
					DTEmpresa empresaDT = (DTEmpresa) usuarioDT;
					
					// checkeo si los datos estan bien
					assertEquals(empresaDT.getNickname(), nickname);
					assertEquals(empresaDT.getNombre(), nombre);
					assertEquals(empresaDT.getApellido(), apellido);
					assertEquals(empresaDT.getCorreo(), correo);
					assertEquals(empresaDT.getDescripcion(), descripcion);
					assertEquals(empresaDT.getLinkWeb(), link);
				}
			}
		}
	}
	
	public void testCargaDatos_TipoPublicacion(String csvFile) throws Exception {
		String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	    	while ((line = br.readLine()) != null) {
	    		String[] tiposPublicaionData = line.split(cvsSplitBy);
	            if(tiposPublicaionData.length > 0) {
	            	String nombre = tiposPublicaionData[0];
	            	String desc = tiposPublicaionData[1];
	            	int exp = Integer.parseInt(tiposPublicaionData[2]) ;
	            	Integer duracion = Integer.parseInt(tiposPublicaionData[3]) ;
	            	Integer costo = Integer.parseInt(tiposPublicaionData[4]);
	            	LocalDate alta = parseToLocalDate(tiposPublicaionData[5].trim());
	            	
	            	// checkeo si existe el tipoPublicacion en el sistema
	            	TipoPublicacion tipoPublicacion = manejadorP.getTipo(nombre);
	            	if (tipoPublicacion == null)
	            		throw new Exception("No existe ningun TipoPublicacion llamado " + nombre);
	            	
	            	// checkeo si los datos estan bien
	            	assertEquals(tipoPublicacion.getNombre(), nombre);
	            	assertEquals(tipoPublicacion.getDescripcion(), desc);
	            	assertEquals(tipoPublicacion.getExposicion(), exp);
	            	assertEquals(tipoPublicacion.getDuracion(), duracion);
	            	assertEquals(tipoPublicacion.getCosto(), costo);
	            	assertEquals(tipoPublicacion.getAlta(), alta);
	            }
	        }
	    }
	}
	
	public void testCargaDatos_Keywords(String csvFile) throws Exception {
		String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	    	while ((line = br.readLine()) != null) {
	    		String[] tiposPublicacionData = line.split(cvsSplitBy);
	            String nombre = "";
	            if(tiposPublicacionData.length > 0) {
	            	nombre = tiposPublicacionData[0];
	            	
	            	// checkeo si existe la keyword en el sistema
	            	List<String> keywords = manejadorOL.obtenerKeywords();
	            	if (!keywords.contains(nombre))
	            		throw new Exception("No existe ninguna keyword llamada " + nombre);
	            }      
	        }
	    }
	}
	
	public void testCargaDatos_OfertaLaborales(String csvFile) throws Exception {
		String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	    	while ((line = br.readLine()) != null) {
	    		String[] ofertasLaboralesData = line.split(cvsSplitBy);
	            if (ofertasLaboralesData.length > 0) {
	            	String nombre = ofertasLaboralesData[0];
	            	String desc = ofertasLaboralesData[1];
	            	String rem = ofertasLaboralesData[5];
	            	String horario = ofertasLaboralesData[4];
	            	String ciudad = ofertasLaboralesData[3];
	            	String depa = ofertasLaboralesData[2];
	            	//String tipo = ofertasLaboralesData[7];
	            	String empresa = ofertasLaboralesData[6];
		            List<String> keys = new ArrayList<>();
	            	if (ofertasLaboralesData.length > 9)
	            		keys = Arrays.asList(ofertasLaboralesData[9].split("/"));
	            	
	            	// checkeo si existe la oferta en el sistema
	            	DTOferta oferta = manejadorOL.obtenerOfertaLaboral(nombre);
	            	
	            	// checkeo si los datos estan bien
	            	assertEquals(oferta.getNombre(), nombre);
	            	assertEquals(oferta.getDescripcion(), desc);
	            	assertEquals(oferta.getRemuneracion(), rem);
	            	assertEquals(oferta.getHorario(), horario);
	            	assertEquals(oferta.getCiudad(), ciudad);
	            	assertEquals(oferta.getDepartamento(), depa);
	            	// TODO: falta checkear si el tipoPublicacion esta bien =>   assertEquals(oferta.getTipoPublicacion(), tipo);
	            	assertEquals(oferta.getNicknameEmpresa(), empresa);
	            	keys.stream().forEach(keyword -> assertTrue(oferta.getKeywords().contains(keyword)));
	            }
	        }
	    }
	}
	
	public void testCargaDatos_Postulaciones(String csvFile) throws Exception {
		String line = "";
	    String cvsSplitBy = ";";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = br.readLine()) != null) {
	            String[] postulacionesData = line.split(cvsSplitBy);
	            if(postulacionesData.length > 0) {
	            	String fechaStr = postulacionesData[3];
	            	LocalDate fechaPostulacion = LocalDate.parse(fechaStr, formatter);
	            	
	            	String nicknamePostulante = postulacionesData[0];
	            	String nombreOL = postulacionesData[4];
	            	String cv = postulacionesData[1];
	            	String motivacion = postulacionesData[2];
	            	LocalDateTime fechaConTiempo = fechaPostulacion.atTime(00, 00, 0, 0);
	            	
	            	// checkeo si existe la postulacion del lado del postulante
	            	DTPostulante postulanteDT = (DTPostulante) manejadorU.obtenerUsuario(nicknamePostulante);
	            	DTPostulacion postulacionPostulante = postulanteDT.getPostulaciones()
	            			.stream()
	            			.filter(postulacion -> postulacion.getNombreOfertaLaboral().equals(nombreOL))
	            			.findFirst()
	            			.get();
	            	
	            	// checko si existe la postulacion del lado de la oferta
	            	DTOferta ofertaDT = manejadorOL.obtenerOfertaLaboral(nombreOL);
	            	DTPostulacion postulacionOferta = ofertaDT.getPostulaciones()
	            			.stream()
	            			.filter(postulacion -> postulacion.getNicknamePostulante().equals(nicknamePostulante))
	            			.findFirst()
	            			.get();
	            	
	            	// checko si los datos estan bien del lado del postulante
	            	assertEquals(postulacionPostulante.getNicknamePostulante(), nicknamePostulante);
	            	assertEquals(postulacionPostulante.getNombreOfertaLaboral(), nombreOL);
	            	assertEquals(postulacionPostulante.getCvReducido(), cv);
	            	assertEquals(postulacionPostulante.getMotivacion(), motivacion);
	            	assertEquals(postulacionPostulante.getFecha(), fechaConTiempo);
	            	
	            	// checko si los datos estan bien del lado de la oferta
	            	assertEquals(postulacionOferta.getNicknamePostulante(), nicknamePostulante);
	            	assertEquals(postulacionOferta.getNombreOfertaLaboral(), nombreOL);
	            	assertEquals(postulacionOferta.getCvReducido(), cv);
	            	assertEquals(postulacionOferta.getMotivacion(), motivacion);
	            	assertEquals(postulacionOferta.getFecha(), fechaConTiempo);
	            }      
	        }
	    }
	}
	
	// carga de datos
	public void cargarDatos() {
	    String currentDirectory = System.getProperty("user.dir");
	    try {	
	    	String csvFilePostulantes = currentDirectory + File.separator + "Datos" + File.separator + "Postulantes.csv";
	    	cargarDatosPostulantes(csvFilePostulantes);
		
	    	String csvFileEmpresas = currentDirectory + File.separator + "Datos" + File.separator + "Empresas.csv";
			cargarDatosEmpresas(csvFileEmpresas);
		
			String csvFileTiposPublicacion = currentDirectory + File.separator + "Datos" + File.separator + "TiposPublicacion.csv";
			cargarDatosTipoPublicacion(csvFileTiposPublicacion);
		
			String csvFileKeywords = currentDirectory + File.separator + "Datos" + File.separator + "Keywords.csv";
			cargarDatosKeywords(csvFileKeywords);
		
			String csvFileOfertaLaboral = currentDirectory + File.separator + "Datos" + File.separator + "OfertasLaborales.csv";
			cargarDatosOfertasLaborales(csvFileOfertaLaboral);
		
			String csvFilePostulaciones = currentDirectory + File.separator + "Datos" + File.separator + "Postulaciones.csv";
			cargarDatosPostulaciones(csvFilePostulaciones);
	    } catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cargarDatosPostulantes(String csvFile) throws UsuarioRepetidoException {	
	    String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = br.readLine()) != null) {
	            String[] postulanteData = line.split(cvsSplitBy);
	            String nickname = "";
	            String nombre = "";
	            String apellido = "";
	            String correo = "";
	            Date fecha = null;
	            String nacionalidad = "";
	            if(postulanteData.length > 0) {
	            	 nickname = postulanteData[0];
	            	 nombre = postulanteData[1];
	            	 apellido = postulanteData[2];
	            	 correo = postulanteData[3];
	            	 fecha = parseDate(postulanteData[4].trim());
	            	 nacionalidad = postulanteData[5];
	            	 ICU.altaPostulante(nickname, nombre, apellido, correo, fecha, nacionalidad);
	            }
	            
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private Date parseDate(String dateString) {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	        return formatter.parse(dateString);
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	private void cargarDatosEmpresas(String csvFile) throws UsuarioRepetidoException {	
	    String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = br.readLine()) != null) {
	            String[] empresaData = line.split(cvsSplitBy);
	            String nickname = "";
	            String nombre = "";
	            String apellido = "";
	            String correo = "";
	            String descripcion = "";
	            String link = "";
	            
	            if(empresaData.length > 0) {
	            	 nickname = empresaData[0];
	            	 nombre = empresaData[1];
	            	 apellido = empresaData[2];
	            	 correo = empresaData[3];
	            	 descripcion = empresaData[4];
			         link = empresaData[5];
	 
	            	 ICU.altaEmpresa(nickname, nombre, apellido, correo,nickname, descripcion, link);
	            }
	            
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private void cargarDatosTipoPublicacion(String csvFile) throws TipoPublicExisteException{	
	    String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = br.readLine()) != null) {
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
	            	 alta = parseToLocalDate(tiposPublicaionData[5].trim());
	            	 ICP.altaTipoPublicacionOL(nombre, desc, exp, duracion, costo, alta);
	            }
	            
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private LocalDate parseToLocalDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    return LocalDate.parse(dateString, formatter);
	}
	
	private void cargarDatosKeywords(String csvFile) throws KeywordExisteException{	
	    String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = br.readLine()) != null) {
	            String[] tiposPublicacionData = line.split(cvsSplitBy);
	            String nombre = "";         
	            if(tiposPublicacionData.length > 0) {
	            	 nombre = tiposPublicacionData[0];
	            	 ICO.altaKeyword(nombre);
	            }      
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private void cargarDatosOfertasLaborales(String csvFile) throws NombreExisteException, KeywordExisteException, NicknameNoExisteException{	
	    String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = br.readLine()) != null) {
	            String[] ofertasLaboralesData = line.split(cvsSplitBy);
	            String nombre = "";    
	            String desc = ""; 
	            String rem = ""; 
	            String horario = ""; 
	            List<String> keys = new ArrayList<>();
	            String ciudad = ""; 
	            String depa = ""; 
	            String tipo = "";
	            String empresa = ""; 
	            
	            
	            if(ofertasLaboralesData.length > 0) {
	            	
	            	 nombre = ofertasLaboralesData[0];
	            	 desc = ofertasLaboralesData[1];
	            	 rem = ofertasLaboralesData[5];
	            	 horario = ofertasLaboralesData[4];
	            	 ciudad = ofertasLaboralesData[3];
	            	 depa = ofertasLaboralesData[2];
	            	 tipo = ofertasLaboralesData[7];
	            	 empresa = ofertasLaboralesData[6];
	            	 if(ofertasLaboralesData.length > 9) {
		            	 keys = Arrays.asList(ofertasLaboralesData[9].split("/"));
	            	 }
	            	 ICO.altaOferta(nombre, desc, rem, horario, keys, ciudad, depa, tipo, empresa);
	            }      
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private void cargarDatosPostulaciones(String csvFile) throws NicknameNoExisteException, UsuarioNoEsPostulanteException, OfertaNoExisteException{	
	    String line = "";
	    String cvsSplitBy = ";";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = br.readLine()) != null) {
	            String[] postulacionesData = line.split(cvsSplitBy);
	            String nicknamePost = "";    
	            String nombreOL = ""; 
	            String cv = ""; 
	            String motivacion = ""; 
	            LocalDate fechaPostulacion = null; 
	            
	            if(postulacionesData.length > 0) {
	            	nicknamePost = postulacionesData[0];
	            	cv = postulacionesData[1];
	            	nombreOL = postulacionesData[4];
	            	motivacion = postulacionesData[2];
	            	String fechaStr = postulacionesData[3];
	            	fechaPostulacion = LocalDate.parse(fechaStr, formatter);
	            	LocalDateTime fechaConTiempo = fechaPostulacion.atTime(00, 00, 0, 0);
	            	ICO.postularAOferta(nombreOL, nicknamePost, cv, motivacion, fechaConTiempo);
	            }      
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
