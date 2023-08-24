package logica;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import excepciones.KeywordExisteException;

public class ManejadorOfertaLaboral {

	private TreeMap<String, OfertaLaboral> coleccionOfertasLaborales;
	private Map<String, Keyword> coleccionKeyword = new HashMap<String, Keyword>();

	private static ManejadorOfertaLaboral instancia;
	
	public static ManejadorOfertaLaboral getInstance() {
        if (instancia == null) {
            instancia = new ManejadorOfertaLaboral();
        }
        return instancia;
    }
	
	public void addKeyword(Keyword key) throws KeywordExisteException {
		if(coleccionKeyword.get(key.getNombre()) == null) {
			throw new KeywordExisteException("La Keyword con nombre" + key.getNombre() + " ya existe");
		}
		coleccionKeyword.put(key.getNombre(), key);
	}
}
