package logica;

import java.util.Date;
import java.util.List;
import java.util.Set;

import excepciones.NicknameNoExisteException;
import excepciones.UsuarioNoEsEmpresaException;
import utils.DTEmpresa;
import utils.DTOferta;
import utils.DTPostulante;
import excepciones.UsuarioRepetidoException;
import utils.DTUsuario;

public interface IControladorUsuario {

	/**
	 * Devuelve una lista de tipo DTUsuario con la informacion de todos los usuarios registrados en el sistema ordenados segun su nombre.
	 * Si no hay usuarios registrados devuelve una lista vacia.
	 */
	public List<DTUsuario> listarUsuarios();
	
	/**
	 * Devuelve una lista de tipo DTUsuario con la informacion de todas las empresas registradas en el sistema ordenadas segun el nombre de la empresa.
	 * Si no hay empresas registradas devuelve una lista vacia.
	 */
	public List<DTEmpresa> listarEmpresas();
	
	/**
	 * Devuelve una lista de tipo DTPostulante con la informacion de todos los postulantes registrados en el sistema ordenados segun su nombre.
	 * Si no hay postulantes registrados devuelve una lista vacia.
	 */
	public List<DTPostulante> listarPostulantes();
	
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
    public abstract  List<DTEmpresa> obtenerListaEmpresas();
    
    /**
	 * Devuelve un set de tipo DTOferta con todas las ofertas asociadas a la empresa con el nickname "nicknameEmpresa" ordenadas alfabeticamente por el nombre de las ofertas.
	 * Si el nickname no esta asociado a un usuario en el sistema tira una NicknameNoExisteException.
	 * Si existe el usuario con ese nickname pero no es una empresa tira una UsuarioNoEsEmpresaException.
	 * Si no tiene ofertas asociadas devuelve una lista vacia.
	 */
	public Set<DTOferta> obtenerOfertasDeEmpresa(String nicknameEmpresa) throws NicknameNoExisteException, UsuarioNoEsEmpresaException;
    
}
