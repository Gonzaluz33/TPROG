package logica;

import java.util.HashMap;
import excepciones.TipoPublicExisteException;

public class ManejadorPublicaciones {

	private HashMap<String, Publicacion> coleccionPublicaciones = new HashMap<String, Publicacion>();
	private HashMap<String, TipoPublicacion> coleccionTipos = new HashMap<String, TipoPublicacion>();
	private HashMap<String, Paquete> coleccionPaquetes = new HashMap<String, Paquete>();
	
	private static ManejadorPublicaciones instancia;
	
	public static ManejadorPublicaciones getInstance() {
        if (instancia == null) {
            instancia = new ManejadorPublicaciones();
        }
        return instancia;
    }
	
	/**
	 * Crea el Tipo de Publicacion y lo agrega a coleccionTipos.
	 */
	public void altaTipoPublicacionOL(TipoPublicacion p) throws TipoPublicExisteException {
		if(coleccionTipos.get(p.getNombre()) != null) {
			throw new TipoPublicExisteException("El Tipo Publicacion de Oferta Laboral con nombre" + p.getNombre() + " ya existe");
		}
		coleccionTipos.put(p.getNombre(), p);
	}
	
	/**
	 * Sustituye la coleccion de publicaciones por una vacia.
	 */
	public void limpiarColeccionPublicaciones() {
		this.coleccionPublicaciones = new HashMap<String, Publicacion>();
	}
	
	/**
	 * Sustituye la coleccion de tipos de publicacione por una vacia.
	 */
	public void limpiarColeccionTipos() {
		this.coleccionTipos = new HashMap<String, TipoPublicacion>();
	}
	
	/**
	 * Sustituye la coleccion de paquetes por una vacia.
	 */
	public void limpiarColeccionPaquetes() {
		this.coleccionPaquetes = new HashMap<String, Paquete>();
	}

}
