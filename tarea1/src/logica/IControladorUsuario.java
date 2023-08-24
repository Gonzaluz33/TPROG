package logica;

import java.util.Date;

public interface IControladorUsuario {

    public abstract void altaPostulante(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String nacionalidad);
    public abstract void altaEmpresa(String nickname, String nombre, String apellido, String email, String desc, String linkWeb);
    
}
