package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.CorreoRepetidoException;
import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;
import excepciones.NombreExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.TipoPublicExisteException;
import excepciones.UsuarioRepetidoException;
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

public class ControladorOfertaTest {

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
		controladorUsuario = fabrica.getIControladorUsuario();
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
	
	@Test
	void testAltaOferta_OK() throws NombreExisteException, KeywordExisteException, UsuarioRepetidoException, TipoPublicExisteException {
		//empresa
		String nicknameTest = "nickname";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "empresa";
		String descripcionTest = "descripcionEmpresaUno";
		String contraseñaEmpresa1 = "contraseñaEmpresa1";
		String linkWebTest = "linkWebEmpresaUno";
		
		String nombreTest = "testOferta";
		String descTest = "desc";
		List<String> keys = new ArrayList<String>();
		
		//tipo
		String nombreTipo = "tipo";
		String descTipo = "descTipo";
		int exposicion = 24;
		int duracion = 1;
		int costo = 1;
		LocalDate fecha = LocalDate.now();
		
//		(String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDate fecha) throws TipoPublicExisteException
		try {
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipo, descTipo, exposicion, duracion, costo, fecha);

			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest, contraseñaEmpresa1 ,nombreEmpresaTest, descTest, linkWebTest);
			controladorOfertas.altaOferta(nombreEmpresaTest, descripcionTest, nombreTest, apellidoTest, keys, emailTest, descripcionTest, nombreTipo, nicknameTest);			
			
		} catch (Exception e) {
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
		String contraseñaEmpresa1 = "contraseñaEmpresa1";
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
		int exposicion = 24;
		int duracion = 1;
		int costo = 1;
		LocalDate fecha = LocalDate.now();
		
//		(String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDate fecha) throws TipoPublicExisteException
		try {
			controladorOfertas.altaKeyword("key");
			controladorOfertas.altaKeyword("word");
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipo, descTipo, exposicion, duracion, costo, fecha);

			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest,contraseñaEmpresa1,nombreEmpresaTest, descTest, linkWebTest);
			controladorOfertas.altaOferta(nombreEmpresaTest, descripcionTest, remuTest, horaTest, keys, emailTest, descripcionTest, nombreTipo, nicknameTest);			
			
		} catch (Exception e) {
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
		String contraseñaEmpresa1 = "contraseñaEmpresa1";
		String linkWebTest = "linkWebEmpresaUno";
		
		String nombreTest = "testOferta";
		String descTest = "desc";
		List<String> keys = new ArrayList<String>();
		
		keys.add("key");
		keys.add("Messi");
		

		//tipo
		String nombreTipo = "tipo";
		String descTipo = "descTipo";
		int exposicion = 24;
		int duracion = 1;
		int costo = 1;
		LocalDate fecha = LocalDate.now();
		
//		(String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDate fecha) throws TipoPublicExisteException
		try {
			controladorOfertas.altaKeyword("key");
			controladorOfertas.altaKeyword("word");
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipo, descTipo, exposicion, duracion, costo, fecha);

			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest,contraseñaEmpresa1 ,nombreEmpresaTest, descTest, linkWebTest);
			
		} catch (Exception e) {
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
		String contraseñaEmpresa1 = "contraseñaEmpresa1";
		String linkWebTest = "linkWebEmpresaUno";
		
		String nombreTest = "testOferta";
		String descTest = "desc";
		List<String> keys = new ArrayList<String>();
		
		//tipo
		String nombreTipo = "tipo";
		String descTipo = "descTipo";
		int exposicion = 24;
		int duracion = 1;
		int costo = 1;
		LocalDate fecha = LocalDate.now();
		
//		(String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDate fecha) throws TipoPublicExisteException
		try {
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipo, descTipo, exposicion, duracion, costo, fecha);

			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, contraseñaEmpresa1,emailTest, nombreEmpresaTest, descTest, linkWebTest);
			controladorOfertas.altaOferta(nombreEmpresaTest, descripcionTest, nombreTest, apellidoTest, keys, emailTest, descripcionTest, nombreTipo, nicknameTest);
			
			
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(NombreExisteException.class, () -> controladorOfertas.altaOferta(nombreEmpresaTest, descripcionTest, nombreTest, apellidoTest, keys, emailTest, descripcionTest, nombreTipo, nicknameTest));
		
	}
	
	@Test
	void testObtenerEmpresas_ok() throws UsuarioRepetidoException, CorreoRepetidoException {
		String nicknameTest = "nickname";
		String nombreTestEmp = "nombre";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "empresa";
		String descripcionTest = "descripcionEmpresaUno";
		String contraseñaEmpresa1 = "contraseñaEmpresa1";
		String linkWebTest = "linkWebEmpresaUno";
		
		controladorUsuario.altaEmpresa(nicknameTest, nombreTestEmp, apellidoTest,contraseñaEmpresa1 ,emailTest, nombreEmpresaTest, descripcionTest, linkWebTest);
		
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
		String contraseñaEmpresa1 = "contraseñaEmpresa1";
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
		int exposicion = 24;
		int duracion = 1;
		int costo = 1;
		LocalDate fecha = LocalDate.now();
		
//		(String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDate fecha) throws TipoPublicExisteException
		try {
			controladorOfertas.altaKeyword("key");
			controladorOfertas.altaKeyword("word");
			controladorPublicaciones.altaTipoPublicacionOL(nombreTipo, descTipo, exposicion, duracion, costo, fecha);

			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest, contraseñaEmpresa1, nombreEmpresaTest, descTest, linkWebTest);
			controladorOfertas.altaOferta(nombreEmpresaTest, descripcionTest, remuTest, horaTest, keys, emailTest, descripcionTest, nombreTipo, nicknameTest);			
			
		} catch (Exception e) {
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
