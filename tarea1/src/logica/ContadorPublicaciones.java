package logica;

import java.util.HashMap;
import java.util.Map;

public class ContadorPublicaciones {

	private Integer cantidad;
	private TipoPublicacion tipo;
	private Map<Integer, Publicacion> publicaciones = new HashMap<Integer, Publicacion>();
	
	public ContadorPublicaciones(TipoPublicacion tipoP) {
		cantidad = 0;
		tipo = tipoP;
	}
	
	public void addPublicacion(Publicacion p) {
		if(!publicaciones.containsKey(p.getId())) {
			publicaciones.put(p.getId(), p);
			cantidad++;
		}
	}
	
	public TipoPublicacion getTipo() {
		return tipo;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
}
