package logica;

import utils.DTOferta;
import excepciones.OfertaNoExisteException;

public interface IControladorOfertas {

	/**
	 * Devuelve un DTOferta con la informacion de la oferta con el nombre brindado incluyendo sus postulaciones.
	 * Si no existe una oferta con ese nombre en el sistema tira una OfertaNoExisteException.
	 */
	public DTOferta obtenerDatosOferta(String nombreOferta) throws OfertaNoExisteException;

}
