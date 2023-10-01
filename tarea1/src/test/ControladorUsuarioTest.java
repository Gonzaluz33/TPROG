package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.*;
import utils.*;
import logica.*;

class ControladorUsuarioTest {

	private static IControladorUsuario controladorUsuario;
	
	private static ManejadorUsuarios manejadorU;
	private static ManejadorOfertaLaboral manejadorOL;
	private static ManejadorPublicaciones manejadorP;
	
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		controladorUsuario = fabrica.getIControladorUsuario();
		
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
	
	// tests consultarUsuario()
	@Test
	void testConsultarUsuario_OK() {
		String nicknameTest = "nicknameEmpresaUno";
		String nombreTest = "nombrePersonaEmpresaUno";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "nombreEmpresaUno";
		String descripcionTest = "descripcionEmpresaUno";
		String contraseñaEmpresa1 = "contraseñaEmpresa1";
		String linkWebTest = "linkWebEmpresaUno";
		
		try {
			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest,contraseñaEmpresa1,nombreEmpresaTest, descripcionTest, linkWebTest);
			
			DTUsuario usuarioConsultado = controladorUsuario.consultarUsuario(nicknameTest);
			
			assertEquals(usuarioConsultado.getNickname(), nicknameTest);
			assertEquals(usuarioConsultado.getNombre(), nombreTest);
			assertEquals(usuarioConsultado.getApellido(), apellidoTest);
			assertEquals(usuarioConsultado.getCorreo(), emailTest);
			assertEquals(((DTEmpresa) usuarioConsultado).getNombreEmpresa(), nombreEmpresaTest);
			assertEquals(((DTEmpresa) usuarioConsultado).getDescripcion(), descripcionTest);
			assertEquals(((DTEmpresa) usuarioConsultado).getLinkWeb(), linkWebTest);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testConsultarUsuario_NoExiste() {
		String nicknameUsuarioQueNoExiste = "eu nao esisto";
		
		// testeo sobre la coleccion vacia
		assertThrows(NicknameNoExisteException.class, () -> controladorUsuario.consultarUsuario(nicknameUsuarioQueNoExiste));
		
		// le cargo un usuario al sistema
		String nicknameTest = "nicknameEmpresaUno";
		String nombreTest = "nombrePersonaEmpresaUno";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "nombreEmpresaUno";
		String descripcionTest = "descripcionEmpresaUno";
		String contraseñaEmpresa1 = "contraseñaEmpresa1";
		String linkWebTest = "linkWebEmpresaUno";
		try {
			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest,contraseñaEmpresa1 ,nombreEmpresaTest, descripcionTest, linkWebTest);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		// testeo sobre una coleccion con 1 usuario en el sistema
		assertThrows(NicknameNoExisteException.class, () -> controladorUsuario.consultarUsuario(nicknameUsuarioQueNoExiste));
	}
	
	// tests listarUsuarios()
	@Test
	void testListarUsuarios_SinUsuarios() {
		assertEquals(controladorUsuario.listarUsuarios().size(), 0);
	}
	
	@Test
	void testListarUsuarios_UnUsuarioEmpresa() {
		// le cargo un usuario al sistema
		String nicknameTest = "nicknameEmpresaUno";
		String nombreTest = "nombrePersonaEmpresaUno";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "nombreEmpresaUno";
		String descripcionTest = "descripcionEmpresaUno";
		String contraseñaEmpresa1 = "contraseñaEmpresa1";
		String linkWebTest = "linkWebEmpresaUno";
		try {
			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest,contraseñaEmpresa1 ,nombreEmpresaTest, descripcionTest, linkWebTest);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		List<DTUsuario> listaUsuarios = controladorUsuario.listarUsuarios();
		DTUsuario primerUsuario = listaUsuarios.get(0);
		assertEquals(listaUsuarios.size(), 1);
		assertEquals(primerUsuario.getNickname(), nicknameTest);
		assertEquals(primerUsuario.getNombre(), nombreTest);
		assertEquals(primerUsuario.getApellido(), apellidoTest);
		assertEquals(primerUsuario.getCorreo(), emailTest);
		assertEquals(((DTEmpresa) primerUsuario).getNombreEmpresa(), nombreEmpresaTest);
		assertEquals(((DTEmpresa) primerUsuario).getDescripcion(), descripcionTest);
		assertEquals(((DTEmpresa) primerUsuario).getLinkWeb(), linkWebTest);
	}
	
	@Test
	void testListarUsuarios_UnUsuarioPostulante() {
		// le cargo un usuario al sistema
		String nicknameTest = "nicknamePostulanteUno";
		String nombreTest = "nombrePersonaPostulanteUno";
		String apellidoTest = "apellidoPostulanteUno";
		String emailTest = "emailPostulanteUno";
		String contraseñaPostulante1 = "contraseñaPostulante1";
		Date fechaNacimientoTest = new Date();
		String nacionalidadTest = "nacionalidadPostulanteUno";
		try {
			controladorUsuario.altaPostulante(nicknameTest, nombreTest, apellidoTest, emailTest,contraseñaPostulante1 ,fechaNacimientoTest, nacionalidadTest);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		List<DTUsuario> listaUsuarios = controladorUsuario.listarUsuarios();
		DTUsuario primerUsuario = listaUsuarios.get(0);
		assertEquals(listaUsuarios.size(), 1);
		assertEquals(primerUsuario.getNickname(), nicknameTest);
		assertEquals(primerUsuario.getNombre(), nombreTest);
		assertEquals(primerUsuario.getApellido(), apellidoTest);
		assertEquals(primerUsuario.getCorreo(), emailTest);
		assertEquals(((DTPostulante) primerUsuario).getFechaNacimiento(), fechaNacimientoTest);
		assertEquals(((DTPostulante) primerUsuario).getNacionalidad(), nacionalidadTest);
	}
	
	// tests listarEmpresas()
	@Test
	void testListarEmpresas_SinUsuarios() {
		assertEquals(controladorUsuario.listarEmpresas().size(), 0);
	}
	
	@Test
	void testListarEmpresas_SinEmpresas() {
		// le cargo un postulante al sistema
		String nicknameTest = "nicknamePostulanteUno";
		String nombreTest = "nombrePersonaPostulanteUno";
		String apellidoTest = "apellidoPostulanteUno";
		String emailTest = "emailPostulanteUno";
		String contraseñaPostulante1 = "contraseñaPostulante1";
		Date fechaNacimientoTest = new Date();
		String nacionalidadTest = "nacionalidadPostulanteUno";
		try {
			controladorUsuario.altaPostulante(nicknameTest, nombreTest, apellidoTest, emailTest, contraseñaPostulante1 ,fechaNacimientoTest, nacionalidadTest);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		assertEquals(controladorUsuario.listarEmpresas().size(), 0);
	}
	
	// tests listarPostulantes()
	@Test
	void testListarPostulantes_SinUsuarios() {
		assertEquals(controladorUsuario.listarPostulantes().size(), 0);
	}
	
	@Test
	void testListarPostulantes_UnPostulante() {
		// le cargo un postulante al sistema
		String nicknameTest = "nicknamePostulanteUno";
		String nombreTest = "nombrePersonaPostulanteUno";
		String apellidoTest = "apellidoPostulanteUno";
		String emailTest = "emailPostulanteUno";
		String contraseñaPostulante1 = "contraseñaPostulante1";
		Date fechaNacimientoTest = new Date();
		String nacionalidadTest = "nacionalidadPostulanteUno";
		try {
			controladorUsuario.altaPostulante(nicknameTest, nombreTest, apellidoTest, emailTest,contraseñaPostulante1 ,fechaNacimientoTest, nacionalidadTest);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		List<DTPostulante> listaPostulantes = controladorUsuario.listarPostulantes();
		DTPostulante primerPostulante = listaPostulantes.get(0);
		assertEquals(listaPostulantes.size(), 1);
		assertEquals(primerPostulante.getNickname(), nicknameTest);
		assertEquals(primerPostulante.getNombre(), nombreTest);
		assertEquals(primerPostulante.getApellido(), apellidoTest);
		assertEquals(primerPostulante.getCorreo(), emailTest);
		assertEquals(primerPostulante.getFechaNacimiento(), fechaNacimientoTest);
		assertEquals(primerPostulante.getNacionalidad(), nacionalidadTest);
	}
	
	//tests obtenerOfertasDeEmpresa()
	@Test
	void testObtenerOfertasDeEmpresa_SinOfertas() {
		// le cargo una empresa al sistema
		String nicknameTest = "nicknameEmpresaUno";
		String nombreTest = "nombrePersonaEmpresaUno";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String contraseñaPostulante1 = "contraseñaPostulante1";
		String nombreEmpresaTest = "nombreEmpresaUno";
		String descripcionTest = "descripcionEmpresaUno";
		String linkWebTest = "linkWebEmpresaUno";
		try {
			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest,contraseñaPostulante1 ,nombreEmpresaTest, descripcionTest, linkWebTest);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			assertEquals(controladorUsuario.obtenerOfertasDeEmpresa(nicknameTest).size(), 0);
		} catch (NicknameNoExisteException | UsuarioNoEsEmpresaException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	void testObtenerOfertasDeEmpresa_NoExisteEmpresa() {
		String nicknameDeEmpresaQueNoExiste = "eu nao esisto";
		assertThrows(NicknameNoExisteException.class, () -> controladorUsuario.obtenerOfertasDeEmpresa(nicknameDeEmpresaQueNoExiste));
	}
	
	@Test
	void testObtenerOfertasDeEmpresa_NoEsEmpresa() {
		// le cargo un postulante al sistema
		String nicknameTest = "nicknamePostulanteUno";
		String nombreTest = "nombrePersonaPostulanteUno";
		String apellidoTest = "apellidoPostulanteUno";
		String emailTest = "emailPostulanteUno";
		String contraseñaPostulante1 = "contraseñaPostulante1";
		Date fechaNacimientoTest = new Date();
		String nacionalidadTest = "nacionalidadPostulanteUno";
		try {
			controladorUsuario.altaPostulante(nicknameTest, nombreTest, apellidoTest, emailTest, contraseñaPostulante1,fechaNacimientoTest, nacionalidadTest);
		} catch (Exception e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		assertThrows(UsuarioNoEsEmpresaException.class, () -> controladorUsuario.obtenerOfertasDeEmpresa(nicknameTest));
	}
	
}
