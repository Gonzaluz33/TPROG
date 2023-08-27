package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excepciones.TipoPublicExisteException;
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
	
	public int getLastPubId() {
		return this.coleccionPublicaciones.size();
	}
	
	public void addPaquete(Paquete pub) {
		coleccionPaquetes.put(pub.getNombre(), pub);
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
		coleccionTipos.put(p.getNombre(), p);
	}

}
