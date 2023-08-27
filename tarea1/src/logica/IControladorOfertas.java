package logica;

import utils.DTOferta;

import java.time.LocalDateTime;

import excepciones.NicknameNoExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsPostulanteException;

public interface IControladorOfertas {

	/**
	 * Devuelve un DTOferta con la informacion de la oferta con el nombre brindado incluyendo sus postulaciones.
	 * Si no existe una oferta con ese nombre en el sistema tira una OfertaNoExisteException.
	 */
	public DTOferta obtenerDatosOferta(String nombreOferta) throws OfertaNoExisteException;
	
	/**
	 * Postula al postulante con nick "nicknamePostulante" a la oferta de nombre "nombreOfertaLaboral".
	 * Si no existe un usuario con ese nick tira una NicknameNoExisteException.
	 * Si el usuario asociado al nick "nicknamePostulante" no es un postulante tira una UsuarioNoEsPostulanteException
	 * Si no existe una oferta con el nombre "nombreOfertaLaboral" tira una OfertaNoExisteException.
	 */
	public void postularAOferta(String nombreOfertaLaboral, String nicknamePostulante, String cvReducido, String motivacion, LocalDateTime fechaPostulacion) throws NicknameNoExisteException, UsuarioNoEsPostulanteException, OfertaNoExisteException;

}
