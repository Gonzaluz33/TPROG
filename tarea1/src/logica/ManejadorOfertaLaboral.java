package logica;

import java.util.Map;
import java.util.TreeMap;
import java.time.LocalDateTime;
import java.util.HashMap;

import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsPostulanteException;
import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;
import utils.DTOferta;
import utils.DTPostulante;
import utils.DTUsuario;

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
	 * Postula al postulante a la oferta cuyo nombre es "nombreOfertaLaboral".
	 * Si no existe una oferta con ese nombre tira una OfertaNoExisteException.
	 */
	public void postularAOferta(String nombreOfertaLaboral, String nicknamePostulante, String cvReducido, String motivacion, LocalDateTime fechaPostulacion) throws NicknameNoExisteException, UsuarioNoEsPostulanteException, OfertaNoExisteException {
		OfertaLaboral oferta = this.coleccionOfertasLaborales.get(nombreOfertaLaboral);
		
		// checkeo si existe el postulante con el nick "nicknamePostulante"
		ManejadorUsuarios manejadorU = ManejadorUsuarios.getInstance();
		DTUsuario usuario = manejadorU.obtenerUsuario(nicknamePostulante);
		
		// checkeo si el usuario es un postulante
		if (usuario instanceof DTPostulante)
			throw new UsuarioNoEsPostulanteException("El usuario con nickname " + nicknamePostulante + " no es un postulante.");
		
		// checkeo si el postulante ya habia postulado a la oferta laboral
		boolean postulacionRepetida = oferta.getPostulaciones()
				.stream().
				anyMatch(postulacionDT -> postulacionDT.getNicknamePostulante()
						.equals(nicknamePostulante));
		if (postulacionRepetida)
			throw new OfertaNoExisteException("Ya existe una postulacion a la oferta " + nombreOfertaLaboral + " asociada al postulante " + nicknamePostulante + ".");
		
		// si nunca habia postulado a la oferta entonces creo la nueva postulacion
		Postulacion postulacion = new Postulacion(nombreOfertaLaboral, nicknamePostulante, cvReducido, motivacion, fechaPostulacion);
		oferta.asociarPostulacion(postulacion);
		manejadorU.postularAOferta(postulacion);
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
