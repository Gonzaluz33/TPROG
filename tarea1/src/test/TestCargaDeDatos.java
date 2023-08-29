package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JMenuItem;

import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;
import excepciones.NombreExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.TipoPublicExisteException;
import excepciones.UsuarioNoEsPostulanteException;
import excepciones.UsuarioRepetidoException;

public class TestCargaDeDatos {
/*
	    String currentDirectory = System.getProperty("user.dir");
	    		
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
				
			} catch (UsuarioRepetidoException e1) {
				e1.printStackTrace();
			} catch (TipoPublicExisteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (KeywordExisteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NombreExisteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NicknameNoExisteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UsuarioNoEsPostulanteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (OfertaNoExisteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	});
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
	    try {
	        return LocalDate.parse(dateString, formatter);
	    } catch (DateTimeParseException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	private void cargarDatosKeywords(String csvFile) throws KeywordExisteException{	
	    String line = "";
	    String cvsSplitBy = ";";
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	        while ((line = br.readLine()) != null) {
	            String[] tiposPublicaionData = line.split(cvsSplitBy);
	            String nombre = "";         
	            if(tiposPublicaionData.length > 0) {
	            	 nombre = tiposPublicaionData[0];
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
	*/
}
