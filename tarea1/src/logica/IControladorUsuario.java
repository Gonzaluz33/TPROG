package logica;

import java.util.Date;
import java.util.List;

import excepciones.NicknameNoExisteException;
import utils.DTEmpresa;
import excepciones.UsuarioRepetidoException;
import utils.DTUsuario;

public interface IControladorUsuario {

	/**
	 * Devuelve una lista de tipo DTUsuario con la informacion de todos los usuarios registrados en el sistema ordenados segun su cedula.
	 * Si no hay usuarios registrados devuelve una lista vacia.
	 */
	public List<DTUsuario> listarUsuarios();
	
	/**
	 * Devuelve una lista de tipo DTUsuario con la informacion de todas las empresas registradas en el sistema ordenadas segun el nombre de la empresa.
	 * Si no hay empresas registrados devuelve una lista vacia.
	 */
	public List<DTEmpresa> listarEmpresas();
	
	/**
	 * Dado el nickname de un usuario devuelve todos sus datos.
	 * Si es una empresa tambien devuelve un set  de tipo DTOferta con sus ofertas ordenadas alfabeticamente por el nombre de las mismas.
	 * Si es un postulante tambien devuelve una lista de tipo DTPostulacion con sus postulaciones.
	 * Si no existe un usuario con el nickname brindado tira una NicknameNoExisteException.
	 */
	public DTUsuario consultarUsuario(String nicknameUsuario) throws NicknameNoExisteException;

    public abstract void altaPostulante(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String nacionalidad) throws UsuarioRepetidoException;
    public abstract void altaEmpresa(String nickname, String nombre, String apellido, String email,String nomEmpresa ,String desc, String linkWeb)throws UsuarioRepetidoException;
    public abstract  List<DTUsuario> obtenerListaUsuarios();
    
}
