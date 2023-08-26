package logica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import excepciones.NombreExisteException;
import excepciones.KeywordExisteException;


public class ManejadorOfertaLaboral {

	private Map<String, OfertaLaboral> coleccionOfertasLaborales = new HashMap<String, OfertaLaboral>();
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

	public void addKeyword(Keyword key) throws KeywordExisteException {
		if(coleccionKeyword.containsKey(key.getNombre())) {
			throw new KeywordExisteException("La Keyword con nombre" + key.getNombre() + " ya existe");
		}
		coleccionKeyword.put(key.getNombre(), key);
	}
}
