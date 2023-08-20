package logica;

import java.util.TreeMap;

public class ManejadorPublicaciones {

	private TreeMap<String, Publicacion> coleccionPublicaciones;
	private TreeMap<String, TipoPublicacion> coleccionTipos;
	private TreeMap<String, Paquete> coleccionPaquetes;
	
	private static ManejadorPublicaciones instancia;
	
	public static ManejadorPublicaciones getInstance() {
        if (instancia == null) {
            instancia = new ManejadorPublicaciones();
        }
        return instancia;
    }
}
