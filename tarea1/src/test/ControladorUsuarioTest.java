package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.NicknameNoExisteException;
import excepciones.UsuarioRepetidoException;
import utils.DTUsuario;
import utils.DTEmpresa;
import logica.Fabrica;
import logica.IControladorUsuario;
import logica.ManejadorUsuarios;
import logica.ManejadorOfertaLaboral;
import logica.ManejadorPublicaciones;

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
	
	@Test
	void testConsultarUsuarioOK() {
		String nicknameTest = "nicknameEmpresaUno";
		String nombreTest = "nombrePersonaEmpresaUno";
		String apellidoTest = "apellidoEmpresaUno";
		String emailTest = "emailEmpresaUno";
		String nombreEmpresaTest = "nombreEmpresaUno";
		String descripcionTest = "descripcionEmpresaUno";
		String linkWebTest = "linkWebEmpresaUno";
		
		try {
			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest, nombreEmpresaTest, descripcionTest, linkWebTest);
			
			DTUsuario usuarioConsultado = controladorUsuario.consultarUsuario(nicknameTest);
			
			assertEquals(usuarioConsultado.getNickname(), nicknameTest);
			assertEquals(usuarioConsultado.getNombre(), nombreTest);
			assertEquals(usuarioConsultado.getApellido(), apellidoTest);
			assertEquals(usuarioConsultado.getCorreo(), emailTest);
			assertEquals(((DTEmpresa) usuarioConsultado).getNombreEmpresa(), nombreEmpresaTest);
			assertEquals(((DTEmpresa) usuarioConsultado).getDescripcion(), descripcionTest);
			assertEquals(((DTEmpresa) usuarioConsultado).getLinkWeb(), linkWebTest);
		} catch (NicknameNoExisteException | UsuarioRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testConsultarUsuarioNoExiste() {
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
		String linkWebTest = "linkWebEmpresaUno";
		try {
			controladorUsuario.altaEmpresa(nicknameTest, nombreTest, apellidoTest, emailTest, nombreEmpresaTest, descripcionTest, linkWebTest);
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
			e.printStackTrace();
		}
		
		// testeo sobre una coleccion con 1 usuario en el sistema
		assertThrows(NicknameNoExisteException.class, () -> controladorUsuario.consultarUsuario(nicknameUsuarioQueNoExiste));
	}
	
}
