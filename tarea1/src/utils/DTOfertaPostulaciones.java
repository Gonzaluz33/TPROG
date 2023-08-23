package utils;

import java.util.ArrayList;
import java.util.List;

public class DTOfertaPostulaciones extends DTOferta {

	List<DTPostulacion> postulaciones;
	
	public DTOfertaPostulaciones() {
		super();
		this.postulaciones = new ArrayList<>();
	}
	
	public List<DTPostulacion> getPostulaciones() {
		return new ArrayList<DTPostulacion>(postulaciones);
	}
	
	public void addPostulacion(DTPostulacion postulacion) {
		this.postulaciones.add(postulacion);
	}
	
}
