package logica;

import java.util.Date;
import java.util.List;

import excepciones.UsuarioRepetidoException;
import utils.DTUsuario;

public interface IControladorUsuario {

    public abstract void altaPostulante(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String nacionalidad) throws UsuarioRepetidoException;
    public abstract void altaEmpresa(String nickname, String nombre, String apellido, String email,String nomEmpresa ,String desc, String linkWeb)throws UsuarioRepetidoException;
    public abstract  List<DTUsuario> obtenerListaUsuarios();
    public abstract  List<DTUsuario> obtenerListaEmpresas();
    
}
