package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.*;
import logica.*;
import utils.DTPostulacion;
import utils.DTPostulante;

public class ControladorOfertasTest {

	private static IControladorOfertas controladorOfertas;
	private static IControladorUsuario controladorUsuarios;
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
	public void limpiarColecciones() {
		manejadorU.limpiarColeccionUsuarios();
		manejadorOL.limpiarColeccionOfertasLaborales();
		manejadorOL.limpiarColeccionKeywords();
		manejadorP.limpiarColeccionPublicaciones();
		manejadorP.limpiarColeccionPaquetes();
		manejadorP.limpiarColeccionTipos();
	}
	
	
	@SuppressWarnings("unused")
	@Test
	public void testContructoresVacios() {
		Paquete paqueteVacio = new Paquete();
		OfertaLaboral ofertaVacia = new OfertaLaboral();
		Empresa empresaVacia = new Empresa();
		Postulante postulanteVacio = new Postulante();
		Keyword keywordVacia = new Keyword();
		Postulacion postulacionVacia = new Postulacion();
		Publicacion publicacionVacia = new Publicacion();
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
	
	// tests postularAOferta()
	@Test
	public void testPostularAOferta_OK() {
		// le cargo una empresa al sistema
		String nicknameEmpresa1 = "nicknameEmpresaUno";
		String nombreEmpresa1 = "nombrePersonaEmpresaUno";
		String apellidoEmpresa1 = "apellidoEmpresaUno";
		String emailEmpresa1 = "emailEmpresaUno";
		String nombreEmpresaEmpresa1 = "nombreEmpresaUno";
		String descripcionEmpresa1 = "descripcionEmpresaUno";
		String linkWebEmpresa1 = "linkWebEmpresaUno";
		try {
			controladorUsuarios.altaEmpresa(nicknameEmpresa1, nombreEmpresa1, apellidoEmpresa1, emailEmpresa1, nombreEmpresaEmpresa1, descripcionEmpresa1, linkWebEmpresa1);
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertEquals(controladorUsuarios.listarEmpresas().size(), 1);

		// le cargo un postulante al sistema
		String nicknamePostulante1 = "nicknamePostulanteUno";
		String nombrePostulante1 = "nombrePersonaPostulanteUno";
		String apellidoPostulante1 = "apellidoPostulanteUno";
		String emailPostulante1 = "emailPostulanteUno";
		Date fechaNacimientoPostulante1 = new Date();
		String nacionalidadPostulante1 = "nacionalidadPostulanteUno";
		try {
			controladorUsuarios.altaPostulante(nicknamePostulante1, nombrePostulante1, apellidoPostulante1, emailPostulante1, fechaNacimientoPostulante1, nacionalidadPostulante1);
		} catch (UsuarioRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertEquals(controladorUsuarios.listarPostulantes().size(), 1);
		assertEquals(controladorUsuarios.listarUsuarios().size(), 2);
		
		// le cargo un tipo de publicacion al sistema
		String nombreTipoPublicacion1 = "nombreTipoPublicacionUno";
		String descripcionTipoPublicacion1 = "descripcionTipoPublicacionUno";
		int exposicionTipoPublicacion1 = 68;
		Integer duracionTipoPublicacion1 = 24;
		Integer costoTipoPublicacion1 = 9001;
		LocalDate fechaTipoPublicacion1 = LocalDate.now();
		try {
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipoPublicacion1, descripcionTipoPublicacion1, exposicionTipoPublicacion1, duracionTipoPublicacion1, costoTipoPublicacion1, fechaTipoPublicacion1);
		} catch (TipoPublicExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertEquals(controladorPublicaciones.obtenerTipos().size(), 1);
		
		// le cargo una oferta al sistema
		String nombreOferta1 = "nombreOfertaUno";
		String descripcionOferta1 = "descripcionOfertaUno";
		String remuneracionOferta1 = "remuneracionOfertaUno";
		String horarioOferta1 = "horarioOfertaUno";
		List<String> keywordsOferta1 = new ArrayList<>();
		String ciudadOferta1 = "ciudadOfertaUno";
		String departamentoOferta1 = "departamentoOfertaUno";
		String tipoPostulacionOferta1 = nombreTipoPublicacion1;
		String nicknameEmpresaOferta1 = nicknameEmpresa1;
		try {
			controladorOfertas.altaOferta(nombreOferta1, descripcionOferta1, remuneracionOferta1, horarioOferta1, keywordsOferta1, ciudadOferta1, departamentoOferta1, tipoPostulacionOferta1, nicknameEmpresaOferta1);
		} catch (NombreExisteException | KeywordExisteException | NicknameNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertEquals(manejadorOL.getCantidadOfertas(), 1);
		
		// ahora si, postulo a la oferta
		String nombreOfertaPostulacion1 = nombreOferta1;
		String nicknamePostulantePostulacion1 = nicknamePostulante1;
		String cvReducidoPostulacion1 = "cvReducidoPostulacionUno";
		String motivacionPostulacion1 = "motivacionPostulacionUno";
		LocalDateTime fechaPostulacion1 = LocalDateTime.now();
		try {
			controladorOfertas.postularAOferta(nombreOfertaPostulacion1, nicknamePostulantePostulacion1, cvReducidoPostulacion1, motivacionPostulacion1, fechaPostulacion1);
		} catch (NicknameNoExisteException | UsuarioNoEsPostulanteException | OfertaNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}

		// checkeo si esta todo bien desde postulante
		List<DTPostulacion> postulacionesDePostulante = null;
		try {
			postulacionesDePostulante = ((DTPostulante) controladorUsuarios.consultarUsuario(nicknamePostulante1)).getPostulaciones();
		} catch (NicknameNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertEquals(postulacionesDePostulante.size(), 1);
		assertEquals(postulacionesDePostulante.get(0).getNicknamePostulante(), nicknamePostulantePostulacion1);
		assertEquals(postulacionesDePostulante.get(0).getNombreOfertaLaboral(), nombreOfertaPostulacion1);
		assertEquals(postulacionesDePostulante.get(0).getCvReducido(), cvReducidoPostulacion1);
		assertEquals(postulacionesDePostulante.get(0).getMotivacion(), motivacionPostulacion1);
		assertEquals(postulacionesDePostulante.get(0).getFecha(), fechaPostulacion1);
		
		// checkeo si esta todo bien desde oferta laboral
		List<DTPostulacion> postulacionesAOferta = null;
		try {
			postulacionesAOferta = controladorOfertas.obtenerDatosOferta(nombreOferta1).getPostulaciones();
		} catch (OfertaNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertEquals(postulacionesAOferta.size(), 1);
		assertEquals(postulacionesAOferta.get(0).getNicknamePostulante(), nicknamePostulantePostulacion1);
		assertEquals(postulacionesAOferta.get(0).getNombreOfertaLaboral(), nombreOfertaPostulacion1);
		assertEquals(postulacionesAOferta.get(0).getCvReducido(), cvReducidoPostulacion1);
		assertEquals(postulacionesAOferta.get(0).getMotivacion(), motivacionPostulacion1);
		assertEquals(postulacionesAOferta.get(0).getFecha(), fechaPostulacion1);
	}
	
	@Test
	public void testPostularAOferta_NoExistePostulante() {
		String nicknamePostulanteQueNoExiste = "eu nao esisto";
		assertThrows(NicknameNoExisteException.class, () -> controladorOfertas.postularAOferta(nicknamePostulanteQueNoExiste, nicknamePostulanteQueNoExiste, nicknamePostulanteQueNoExiste, nicknamePostulanteQueNoExiste, null));
	}
	
}
