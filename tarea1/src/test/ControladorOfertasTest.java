package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.*;
import logica.Empresa;
import logica.Fabrica;
import logica.IControladorOfertas;
import logica.IControladorPublicaciones;
import logica.IControladorUsuario;
import logica.ManejadorOfertaLaboral;
import logica.ManejadorPublicaciones;
import logica.ManejadorUsuarios;
import utils.DTEmpresa;
import utils.DTOferta;

public class ControladorOfertasTest {

	private static IControladorOfertas controladorOfertas;
	private static IControladorUsuario controladorUsuario;
	private static IControladorPublicaciones controladorPublicaciones;
	
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
	
	// tests altaOferta()
	@Test
	void testAltaOferta_OK() throws NombreExisteException, KeywordExisteException, UsuarioRepetidoException, TipoPublicExisteException {
		//empresa
		String nicknameTest = "nickname";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "empresa";
		String descripcionTest = "descripcionEmpresaUno";
		String linkWebTest = "linkWebEmpresaUno";
		
		//oferta
		String nombreTest = "testOferta";
		String descTest = "desc";
		List<String> keys = new ArrayList<String>();
		
		//tipo
		String nombreTipo = "tipo";
		String descTipo = "descTipo";
		int exposicion = 3;
		int duracion = 1;
		int costo = 1;
		LocalDate fecha = LocalDate.now();
		
//		(String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDate fecha) throws TipoPublicExisteException
		try {
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipo, descTipo, exposicion, duracion, costo, fecha);

			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest, nombreEmpresaTest, descTest, linkWebTest);
			controladorOfertas.altaOferta(nombreEmpresaTest, descripcionTest, nombreTest, apellidoTest, keys, emailTest, descripcionTest, nombreTipo, nicknameTest);			
			
		} catch (NicknameNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testAltaOferta_keys() throws NombreExisteException, KeywordExisteException, UsuarioRepetidoException, TipoPublicExisteException, OfertaNoExisteException, NicknameNoExisteException {
		//empresa
		String nicknameTest = "nickname";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "empresa";
		String descripcionTest = "descripcionEmpresaUno";
		String linkWebTest = "linkWebEmpresaUno";
		
		String remuTest = "10 peso";
		String horaTest = "10-18";
		String nombreTest = "testOferta";
		String descTest = "desc";
		List<String> keys = new ArrayList<String>();
		
		keys.add("key");
		keys.add("word");
		

		//tipo
		String nombreTipo = "tipo";
		String descTipo = "descTipo";
		int exposicion = 3;
		int duracion = 1;
		int costo = 1;
		LocalDate fecha = LocalDate.now();
		
//		(String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDate fecha) throws TipoPublicExisteException
		try {
			controladorOfertas.altaKeyword("key");
			controladorOfertas.altaKeyword("word");
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipo, descTipo, exposicion, duracion, costo, fecha);

			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest, nombreEmpresaTest, descTest, linkWebTest);
			controladorOfertas.altaOferta(nombreEmpresaTest, descripcionTest, remuTest, horaTest, keys, emailTest, descripcionTest, nombreTipo, nicknameTest);			
			
		} catch (NicknameNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		DTOferta oferta = manejadorOL.obtenerOfertaLaboral(nombreEmpresaTest);
		Empresa emp = (Empresa) manejadorU.getUsuario(nicknameTest);
		
		Set<DTOferta> ofertas = emp.getOfertas();
		assertEquals(ofertas.isEmpty(), false);
		
		System.out.println(emp.getOfertas().isEmpty());
		assertEquals(oferta.getDescripcion(), descripcionTest);
		assertEquals(oferta.getNombre(), nombreEmpresaTest);
		assertEquals(oferta.getRemuneracion(), remuTest);
		assertEquals(oferta.getHorario(), horaTest);
	
	}
	
	@Test
	void testAltaOferta_keysThrow() throws NombreExisteException, KeywordExisteException, UsuarioRepetidoException, TipoPublicExisteException {
		//empresa
		String nicknameTest = "nickname";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "empresa";
		String descripcionTest = "descripcionEmpresaUno";
		String linkWebTest = "linkWebEmpresaUno";
		
		String nombreTest = "testOferta";
		String descTest = "desc";
		List<String> keys = new ArrayList<String>();
		
		keys.add("key");
		keys.add("Messi");
		

		//tipo
		String nombreTipo = "tipo";
		String descTipo = "descTipo";
		int exposicion = 3;
		int duracion = 1;
		int costo = 1;
		LocalDate fecha = LocalDate.now();
		
//		(String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDate fecha) throws TipoPublicExisteException
		try {
			controladorOfertas.altaKeyword("key");
			controladorOfertas.altaKeyword("word");
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipo, descTipo, exposicion, duracion, costo, fecha);

			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest, nombreEmpresaTest, descTest, linkWebTest);
			
		} catch (KeywordExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(KeywordExisteException.class, () -> controladorOfertas.altaOferta(nombreEmpresaTest, descripcionTest, nombreTest, apellidoTest, keys, emailTest, descripcionTest, nombreTipo, nicknameTest));

		
	}
	
	@Test
	void testAltaOferta_REP() throws NombreExisteException, KeywordExisteException, UsuarioRepetidoException, TipoPublicExisteException {
		//empresa
		String nicknameTest = "nickname";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "empresa";
		String descripcionTest = "descripcionEmpresaUno";
		String linkWebTest = "linkWebEmpresaUno";
		
		String nombreTest = "testOferta";
		String descTest = "desc";
		List<String> keys = new ArrayList<String>();
		
		//tipo
		String nombreTipo = "tipo";
		String descTipo = "descTipo";
		int exposicion = 3;
		int duracion = 1;
		int costo = 1;
		LocalDate fecha = LocalDate.now();
		
//		(String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDate fecha) throws TipoPublicExisteException
		try {
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipo, descTipo, exposicion, duracion, costo, fecha);

			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest, nombreEmpresaTest, descTest, linkWebTest);
			controladorOfertas.altaOferta(nombreEmpresaTest, descripcionTest, nombreTest, apellidoTest, keys, emailTest, descripcionTest, nombreTipo, nicknameTest);
			
			
		} catch (NicknameNoExisteException | NombreExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(NombreExisteException.class, () -> controladorOfertas.altaOferta(nombreEmpresaTest, descripcionTest, nombreTest, apellidoTest, keys, emailTest, descripcionTest, nombreTipo, nicknameTest));
		
	}
	
	// tests obtenerEmpresas()
	@Test
	void testObtenerEmpresas_ok() throws UsuarioRepetidoException {
		String nicknameTest = "nickname";
		String nombreTestEmp = "nombre";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "empresa";
		String descripcionTest = "descripcionEmpresaUno";
		String linkWebTest = "linkWebEmpresaUno";
		
		controladorUsuario.altaEmpresa(nicknameTest, nombreTestEmp, apellidoTest, emailTest, nombreEmpresaTest, descripcionTest, linkWebTest);
		
		 List<DTEmpresa> emps = controladorOfertas.obtenerEmpresas();
		 
		 
		assertEquals(emps.size(), 1);
		assertEquals(emps.get(0).getDescripcion(), "descripcionEmpresaUno");

	}
	
	@Test
	void testObtenerDatosOferta() throws KeywordExisteException, TipoPublicExisteException, NombreExisteException, UsuarioRepetidoException, OfertaNoExisteException {
		String nicknameTest = "nickname";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "empresa";
		String descripcionTest = "descripcionEmpresaUno";
		String linkWebTest = "linkWebEmpresaUno";
		
		String remuTest = "10 peso";
		String horaTest = "10-18";
		String nombreTest = "testOferta";
		String descTest = "desc";
		List<String> keys = new ArrayList<String>();
		
		keys.add("key");
		keys.add("word");
		

		//tipo
		String nombreTipo = "tipo";
		String descTipo = "descTipo";
		int exposicion = 3;
		int duracion = 1;
		int costo = 1;
		LocalDate fecha = LocalDate.now();
		
//		(String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDate fecha) throws TipoPublicExisteException
		try {
			controladorOfertas.altaKeyword("key");
			controladorOfertas.altaKeyword("word");
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipo, descTipo, exposicion, duracion, costo, fecha);

			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest, nombreEmpresaTest, descTest, linkWebTest);
			controladorOfertas.altaOferta(nombreEmpresaTest, descripcionTest, remuTest, horaTest, keys, emailTest, descripcionTest, nombreTipo, nicknameTest);			
			
		} catch (NicknameNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		DTOferta datos = controladorOfertas.obtenerDatosOferta(nombreEmpresaTest);
		
		assertEquals(datos.getDescripcion(), descripcionTest);
		assertEquals(datos.getNombre(), nombreEmpresaTest);
		assertEquals(datos.getRemuneracion(), remuTest);
		assertEquals(datos.getHorario(), horaTest);
	}
	
}
