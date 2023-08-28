package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.*;
import logica.Fabrica;
import logica.IControladorOfertas;
import logica.ManejadorOfertaLaboral;
import logica.ManejadorPublicaciones;
import logica.ManejadorUsuarios;

public class ControladorOfertasTest {

	private static IControladorOfertas controladorOfertas;
	
	private static ManejadorUsuarios manejadorU;
	private static ManejadorOfertaLaboral manejadorOL;
	private static ManejadorPublicaciones manejadorP;
	
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		controladorOfertas = fabrica.getIControladorOfertas();
		
		manejadorU = ManejadorUsuarios.getInstance();
		manejadorOL = ManejadorOfertaLaboral.getInstance();
		manejadorP = ManejadorPublicaciones.getInstance();
	}
	
	@BeforeEach
	public void limpiarColecciones() {
		manejadorU.limpiarColeccionUsuarios();
		manejadorOL.limpiarColeccionOfertasLaborales();
		manejadorOL.limpiarColeccionKeywords();
		manejadorP.limpiarColeccionPublicaciones();
		manejadorP.limpiarColeccionPaquetes();
		manejadorP.limpiarColeccionTipos();
	}
	
	
	// tests altaKeyword()
	@Test
	public void testAltaKeyword_OK() {
		String nombreKeyword = "llavepalabra";
		try {
			controladorOfertas.altaKeyword(nombreKeyword);
		} catch (KeywordExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		List<String> keywords = manejadorOL.obtenerKeywords();
		
		assertEquals(keywords.size(), 1);
		assertEquals(keywords.get(0), nombreKeyword);
	}
	
	@Test
	public void testAltaKeyword_Duplicada() {
		String nombreKeyword = "llavepalabra";
		try {
			controladorOfertas.altaKeyword(nombreKeyword);
		} catch (KeywordExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		List<String> keywords = manejadorOL.obtenerKeywords();
		assertEquals(keywords.size(), 1);
		
		assertThrows(KeywordExisteException.class, () -> controladorOfertas.altaKeyword(nombreKeyword));
	}
	
	// tests obtenerKeywords()
	@Test
	public void testObtenerKeywords_SinKeywords() {
		assertEquals(controladorOfertas.obtenerKeywords().size(), 0);
	}
	
	@Test
	public void testObtenerKeywords_UnaKeyword() {
		String nombreKeyword = "llavepalabra";
		try {
			controladorOfertas.altaKeyword(nombreKeyword);
		} catch (KeywordExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		List<String> keywords = controladorOfertas.obtenerKeywords();
		
		assertEquals(keywords.size(), 1);
		assertEquals(keywords.get(0), nombreKeyword);
	}
	
	@Test
	public void testObtenerKeywords_DosKeywords() {
		String nombreKeyword1 = "llavepalabra";
		String nombreKeyword2 = "llavepalabra2";
		try {
			controladorOfertas.altaKeyword(nombreKeyword1);
			controladorOfertas.altaKeyword(nombreKeyword2);
		} catch (KeywordExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		List<String> keywords = controladorOfertas.obtenerKeywords();

		assertEquals(keywords.size(), 2);
		assertTrue(keywords.stream().anyMatch(keyword -> keyword.equals(nombreKeyword1)));
		assertTrue(keywords.stream().anyMatch(keyword -> keyword.equals(nombreKeyword2)));
	}
	
}
