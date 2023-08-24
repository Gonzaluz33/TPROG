package logica;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
	
	public void addOferta(OfertaLaboral ofL) throws NombreExisteException{
		if (coleccionOfertasLaborales.containsKey(ofL.getNombre())) {
			throw new NombreExisteException("Ya existe una oferta laboral con el nombre ingresado");
		}
		coleccionOfertasLaborales.put(ofL.getNombre(), ofL);

	public void addKeyword(Keyword key) throws KeywordExisteException {
		if(coleccionKeyword.get(key.getNombre()) == null) {
			throw new KeywordExisteException("La Keyword con nombre" + key.getNombre() + " ya existe");
		}
		coleccionKeyword.put(key.getNombre(), key);
	}
}
