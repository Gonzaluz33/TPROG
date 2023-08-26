package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	public Integer getLastPubId() {
		return this.coleccionPublicaciones.size();
	}
	
	public void addPublicacion(Publicacion pub) {
		coleccionPublicaciones.put(pub.getId(), pub);
	}
}
