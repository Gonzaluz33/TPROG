package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import excepciones.PaqueteExisteException;
import excepciones.TipoPublicExisteException;
import utils.DTPaquete;
import utils.DTTipoPublicacion;


public class ManejadorPublicaciones {

	private Map<Integer, Publicacion> coleccionPublicaciones =  new HashMap<Integer, Publicacion>();
	private Map<String, TipoPublicacion> coleccionTipos = new HashMap<String, TipoPublicacion>();
	private Map<String, Paquete> coleccionPaquetes = new HashMap<String, Paquete>();

	
	private static ManejadorPublicaciones instancia;
	
	public static ManejadorPublicaciones getInstance() {
        if (instancia == null) {
            instancia = new ManejadorPublicaciones();
        }
        return instancia;
    }
	
	public List<DTTipoPublicacion> obtenerTipos() {
		List<DTTipoPublicacion> res = new ArrayList<DTTipoPublicacion>();
		
		for (Map.Entry<String, TipoPublicacion> entry : coleccionTipos.entrySet()) {
			TipoPublicacion tipo = entry.getValue();
			res.add(tipo.toDataType());
		}
		return res;
	}
	
	public List<DTPaquete> obtenerListaPaquetes(){
		List<DTPaquete> listaPaquetes = this.coleccionPaquetes
				.values()
				.stream()
				.map(Paquete::toDataType)
				.collect(Collectors.toList());
		return listaPaquetes;
	}
	
	public Integer getLastPubId() {
		return this.coleccionPublicaciones.size();
	}
	
	public void addPublicacion(Publicacion pub) {
		coleccionPublicaciones.put(pub.getId(), pub);
	}
	
	public TipoPublicacion getTipo(String nombre) {
		return coleccionTipos.get(nombre);
	}

	/**
	 * Crea el Tipo de Publicacion y lo agrega a coleccionTipos.
	 */
	public void altaTipoPublicacionOL(TipoPublicacion p) throws TipoPublicExisteException {
		if(coleccionTipos.get(p.getNombre()) != null) {
			throw new TipoPublicExisteException("El Tipo Publicacion de Oferta Laboral con nombre" + p.getNombre() + " ya existe");
		}
		else {
			coleccionTipos.put(p.getNombre(), p);			
		}
	}
	
	public void addPaqueteTipoPublicacion(Paquete p) throws PaqueteExisteException {
		if(coleccionPaquetes.get(p.getNombre()) != null) {
			throw new PaqueteExisteException("Ya existe un paquete con el nombre ingresado.");
		}
		else {
			coleccionPaquetes.put(p.getNombre(), p);	
		}
	};
	
	
	
	/**
	 * Sustituye la coleccion de publicaciones por una vacia.
	 */
	public void limpiarColeccionPublicaciones() {
		this.coleccionPublicaciones = new HashMap<Integer, Publicacion>();
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
