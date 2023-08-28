package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

import excepciones.NombreExisteException;
import utils.DTUsuario;
import java.time.LocalDateTime;

import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsPostulanteException;

import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;
import utils.DTEmpresa;
import utils.DTOferta;
import utils.DTPostulante;


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
	
	public void addOferta(OfertaLaboral ofL, List<String> keys) throws NombreExisteException, KeywordExisteException{
		if (coleccionOfertasLaborales.containsKey(ofL.getNombre())) {
			throw new NombreExisteException("Ya existe una oferta laboral con el nombre ingresado");
		}
		for(String key: keys) {
			if(!coleccionKeyword.containsKey(key)) {
				throw new KeywordExisteException("La Keyword con nombre" + key + " no existe");
			}
			Keyword keyword = coleccionKeyword.get(key);
			ofL.addKeyword(keyword);
		}
		coleccionOfertasLaborales.put(ofL.getNombre(), ofL);
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
		if(coleccionKeyword.containsKey(key.getNombre())) {
			throw new KeywordExisteException("La Keyword con nombre" + key.getNombre() + " ya existe");
		}
		coleccionKeyword.put(key.getNombre(), key);
	}

	public List<String> obtenerKeywords() {
		List<String> out = new ArrayList<String>();
		for (Map.Entry<String, Keyword> entry : coleccionKeyword.entrySet()) {
			out.add(entry.getKey());
		}
		return out;
	}
	
	/**
	 * Postula al postulante a la oferta cuyo nombre es "nombreOfertaLaboral".
	 * Si no existe una oferta con ese nombre tira una OfertaNoExisteException.
	 */
	public void postularAOferta(String nombreOfertaLaboral, String nicknamePostulante, String cvReducido, String motivacion, LocalDateTime fechaPostulacion) throws NicknameNoExisteException, UsuarioNoEsPostulanteException, OfertaNoExisteException {
		OfertaLaboral oferta = this.coleccionOfertasLaborales.get(nombreOfertaLaboral);
		
		// checkeo si existe el postulante con el nick "nicknamePostulante"
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		DTUsuario usuario = manejadorU.obtenerUsuario(nicknamePostulante);
		
		// checkeo si el usuario es un postulante
		if (!(usuario instanceof DTPostulante))
			throw new UsuarioNoEsPostulanteException("El usuario con nickname " + nicknamePostulante + " no es un postulante.");
		
		// checkeo si el postulante ya habia postulado a la oferta laboral
		boolean postulacionRepetida = oferta.getPostulaciones()
				.stream()
				.anyMatch(postulacionDT -> postulacionDT.getNicknamePostulante()
						.equals(nicknamePostulante));
		if (postulacionRepetida)
			throw new OfertaNoExisteException("Ya existe una postulacion a la oferta " + nombreOfertaLaboral + " asociada al postulante " + nicknamePostulante + ".");
		
		// si nunca habia postulado a la oferta entonces creo la nueva postulacion
		Postulacion postulacion = new Postulacion(nombreOfertaLaboral, nicknamePostulante, cvReducido, motivacion, fechaPostulacion);
		oferta.asociarPostulacion(postulacion);
		manejadorU.postularAOferta(postulacion);
	}
	
	
	
	/**
	 * Devuelve la cantidad de ofertas laborales actualmente en el sistema.
	 */
	public int getCantidadOfertas() {
		return this.coleccionOfertasLaborales.size();
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
