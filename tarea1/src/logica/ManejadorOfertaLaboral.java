package logica;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

import excepciones.OfertaNoExisteException;
import excepciones.KeywordExisteException;
import utils.DTOferta;

public class ManejadorOfertaLaboral {

	private Map<String, OfertaLaboral> coleccionOfertasLaborales = new TreeMap<String, OfertaLaboral>();
	private Map<String, Keyword> coleccionKeyword = new HashMap<String, Keyword>();

	private static ManejadorOfertaLaboral instancia;
	
	public static ManejadorOfertaLaboral getInstance() {
        if (instancia == null) {
            instancia = new ManejadorOfertaLaboral();
        }
        return instancia;
    }
	
	/**
	 * Devuelve un DTOferta con la informacion de la oferta con el nombre brindado incluyendo sus postulaciones.
	 * Si no existe una oferta con ese nombre en el sistema tira una OfertaNoExisteException.
	 */
	public DTOferta obtenerOfertaLaboral(String nombreOferta) throws OfertaNoExisteException {
		return coleccionOfertasLaborales
				.get(nombreOferta)
				.toDataType();
	}

	public void addKeyword(Keyword key) throws KeywordExisteException {
		if(coleccionKeyword.get(key.getNombre()) == null) {
			throw new KeywordExisteException("La Keyword con nombre" + key.getNombre() + " ya existe");
		}
		coleccionKeyword.put(key.getNombre(), key);
	}
	
	/**
	 * Sustituye la coleccion de ofertas laborales por una vacia.
	 */
	public void limpiarColeccionOfertasLaborales() {
		this.coleccionOfertasLaborales = new TreeMap<String, OfertaLaboral>();
	}
	
	/**
	 * Sustituye la coleccion de keywords por una vacia.
	 */
	public void limpiarColeccionKeywords() {
		this.coleccionKeyword = new HashMap<String, Keyword>();
	}

}
