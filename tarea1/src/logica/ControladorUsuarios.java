package logica;

import java.util.Date;
import java.util.List;

import utils.DTUsuario;
import excepciones.*;

public class ControladorUsuarios implements IControladorUsuario{
	
	private static ControladorUsuarios instancia; 
	
	public static ControladorUsuarios getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        return instancia;
    }

	public void altaPostulante(String nickname, String nombre, String apellido, String email, Date fechaNacimiento,
			String nacionalidad) throws UsuarioRepetidoException {
        ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
        Postulante p = new Postulante(nickname, nombre, apellido, email, fechaNacimiento, nacionalidad);
        manejadorU.altaPostulante(p);
	}

	@Override
	public void altaEmpresa(String nickname, String nombre, String apellido, String email, String nomEmpresa ,String desc,
			String linkWeb) throws UsuarioRepetidoException {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		Empresa e = new Empresa(nickname, nombre, apellido, email, nomEmpresa ,desc, linkWeb);
        manejadorU.altaEmpresa(e);
	}
	
	
	public List<DTUsuario> listarUsuarios() {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.obtenerListaUsuarios();
	}
	
	public DTUsuario consultarUsuario(String nicknameUsuario) throws NicknameNoExisteException {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		return manejadorU.obtenerUsuario(nicknameUsuario);
	}

}
