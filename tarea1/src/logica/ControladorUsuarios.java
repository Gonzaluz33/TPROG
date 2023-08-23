package logica;

import java.util.Date;

public class ControladorUsuarios implements IControladorUsuario{
	
	private static ControladorUsuarios instancia; 
	
	public static ControladorUsuarios getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        return instancia;
    }

	public void altaPostulante(String nickname, String nombre, String apellido, String email, Date fechaNacimiento,
			String nacionalidad) {
        ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
//        Usuario u = mu.obtenerUsuario(ci);
//        if (u != null)
//            throw new UsuarioRepetidoException("El usuario " + ci + " ya esta registrado");

        Postulante p = new Postulante(nickname, nombre, apellido, email, fechaNacimiento, nacionalidad);
        manejadorU.altaPostulante(p);
	}

	@Override
	public void altaEmpresa(String nickname, String nombre, String apellido, String email, String desc,
			String linkWeb) {
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		Empresa e = new Empresa(nickname, nombre, apellido, email, desc, linkWeb);
        manejadorU.altaEmpresa(e);
		
	}
	
}
