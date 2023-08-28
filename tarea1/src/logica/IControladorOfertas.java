package logica;

import utils.DTEmpresa;
import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;

import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;
import excepciones.NombreExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsEmpresaException;
import excepciones.UsuarioNoEsPostulanteException;
import utils.DTOferta;
import utils.DTPostulante;


public interface IControladorOfertas {

	public abstract void altaKeyword(String nombre) throws KeywordExisteException;
	public abstract List<String> obtenerKeywords();
	public void altaOferta(String nombre, String desc, String remuner, String horario, List<String> keywords, String ciudad, String depa, String tipo, String empresa) throws NombreExisteException, KeywordExisteException, NicknameNoExisteException;

	/**
	 * Devuelve un DTOferta con la informacion de la oferta con el nombre brindado incluyendo sus postulaciones.
	 * Si no existe una oferta con ese nombre en el sistema tira una OfertaNoExisteException.
	 */
	public DTOferta obtenerDatosOferta(String nombreOferta) throws OfertaNoExisteException;
	public List<DTEmpresa> obtenerEmpresas();

	/**
	 * Postula al postulante con nick "nicknamePostulante" a la oferta de nombre "nombreOfertaLaboral".
	 * Si no existe un usuario con ese nick tira una NicknameNoExisteException.
	 * Si el usuario asociado al nick "nicknamePostulante" no es un postulante tira una UsuarioNoEsPostulanteException
	 * Si no existe una oferta con el nombre "nombreOfertaLaboral" tira una OfertaNoExisteException.
	 */
	public void postularAOferta(String nombreOfertaLaboral, String nicknamePostulante, String cvReducido, String motivacion, LocalDateTime fechaPostulacion) throws NicknameNoExisteException, UsuarioNoEsPostulanteException, OfertaNoExisteException;
	List<DTPostulante> obtenerPostulantes();
	Set<DTOferta> obtenerOfertasEmpresa(String nombreEmpresa)
			throws NicknameNoExisteException, UsuarioNoEsEmpresaException;

}
