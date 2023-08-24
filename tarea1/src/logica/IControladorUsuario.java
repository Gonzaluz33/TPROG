package logica;

import java.util.Date;

import excepciones.UsuarioRepetidoException;

public interface IControladorUsuario {

    public abstract void altaPostulante(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String nacionalidad) throws UsuarioRepetidoException;
    public abstract void altaEmpresa(String nickname, String nombre, String apellido, String email, String desc, String linkWeb);
    
}
