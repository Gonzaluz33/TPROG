package logica;

import java.util.List;

import excepciones.NicknameNoExisteException;
import utils.DTUsuario;

public interface IControladorUsuario {

	/**
	 * Devuelve una lista de tipo DTUsuario con la informacion de todos los usuarios registrados en el sistema ordenados segun su cedula.
	 * Si no hay usuarios registrados devuelve una lista vacia.
	 */
	public abstract List<DTUsuario> listarUsuarios();
	
	/**
	 * Dado el nickname de un usuario devuelve todos sus datos.
	 * Si es una empresa tambien devuelve un set  de tipo DTOferta con sus ofertas ordenadas alfabeticamente por el nombre de las mismas.
	 * Si es un postulante tambien devuelve una lista de tipo DTPostulacion con sus postulaciones.
	 */
	public abstract DTUsuario consultarUsuario(String nicknameUsuario) throws NicknameNoExisteException;

}
