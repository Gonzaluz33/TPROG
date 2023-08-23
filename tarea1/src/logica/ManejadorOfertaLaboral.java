package logica;

import java.util.TreeMap;

public class ManejadorOfertaLaboral {

	private TreeMap<String, OfertaLaboral> coleccionOfertasLaborales;
	private static ManejadorOfertaLaboral instancia;
	
	public static ManejadorOfertaLaboral getInstance() {
        if (instancia == null) {
            instancia = new ManejadorOfertaLaboral();
        }
        return instancia;
    }
}
