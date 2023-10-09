package logica;

import org.mindrot.jbcrypt.BCrypt;
import java.util.Date;
import java.util.List;
import java.util.Set;

import excepciones.CorreoRepetidoException;
import excepciones.NicknameNoExisteException;
import excepciones.UsuarioNoEsEmpresaException;
import excepciones.UsuarioRepetidoException;
import utils.DTEmpresa;
import utils.DTOferta;
import utils.DTPostulante;
import utils.DTUsuario;

public class ControladorUsuarios implements IControladorUsuario{
	
	private static ControladorUsuarios instancia; 
	
	public static ControladorUsuarios getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        return instancia;
    }

	public void altaPostulante(String nickname, String nombre, String apellido, String email,String contraseña ,Date fechaNacimiento,
			String nacionalidad) throws UsuarioRepetidoException, CorreoRepetidoException {
        ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
        String contraseñaHasheada = BCrypt.hashpw(contraseña, BCrypt.gensalt());
        Postulante p = new Postulante(nickname, nombre, apellido, email, contraseñaHasheada ,fechaNacimiento, nacionalidad);
        manejadorU.altaPostulante(p);
	}
	
	@Override
	public void altaEmpresa(String nickname, String nombre, String apellido, String email, String contraseña ,String nomEmpresa ,String desc,
			String linkWeb) throws UsuarioRepetidoException, CorreoRepetidoException {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		String contraseñaHasheada = BCrypt.hashpw(contraseña, BCrypt.gensalt());
		Empresa e = new Empresa(nickname, nombre, apellido, email, contraseñaHasheada ,nomEmpresa ,desc, linkWeb);
        manejadorU.altaEmpresa(e);
	}
	
	public Usuario obtenerUsuario(String nickname) throws NicknameNoExisteException {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.getUsuario(nickname);
	}
	
	public Boolean validarUsuario(String correo, String contraseña) throws NicknameNoExisteException {
		try {
	        ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
	        Usuario u = manejadorU.getUsuarioXCorreo(correo);
	        return BCrypt.checkpw(contraseña, u.getContraseña());
	    } catch (NicknameNoExisteException e) {
	        return false;
	    } 
	}
	
	public List<DTUsuario> listarUsuarios() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.obtenerListaUsuarios();
	}
	
	public List<DTEmpresa> listarEmpresas() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.obtenerListaEmpresas();
	}
	
	public List<DTPostulante> listarPostulantes() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.obtenerListaPostulantes();
	}
	
	public DTUsuario consultarUsuario(String nicknameUsuario) throws NicknameNoExisteException {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.obtenerUsuario(nicknameUsuario);
	}

	public Set<DTOferta> obtenerOfertasDeEmpresa(String nicknameEmpresa) throws NicknameNoExisteException, UsuarioNoEsEmpresaException {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.obtenerOfertasDeEmpresa(nicknameEmpresa);
	}
	public void actualizarDatosEmpresa(String nickFiltrado,String nuevoNombre,String nuevoApellido,String nombreEmpresa,String descripcionEmpresa, String linkWebEmpresa) {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		try {
			manejadorU.actualizarDatosEmpresa(nickFiltrado,nuevoNombre,nuevoApellido,nombreEmpresa,descripcionEmpresa,linkWebEmpresa);
		} catch (NicknameNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizarDatosPostulante(String nickname, String nuevoNombre,String nuevoApellido,String fechaNacimiento, String nacionalidad) {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		try {
			manejadorU.actualizarDatosPostulante(nickname,nuevoNombre,nuevoApellido,fechaNacimiento,nacionalidad);
		} catch (NicknameNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
