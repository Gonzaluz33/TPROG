package utils;

import java.util.ArrayList;
import java.util.List;

public class DTOfertaPostulaciones extends DTOferta {

	List<DTPostulacion> postulaciones;
	
	public DTOfertaPostulaciones(List<DTPostulacion> postulaciones) {
		super();
		this.setPostulacion(postulaciones);
	}
	
	public List<DTPostulacion> getPostulaciones() {
		return new ArrayList<DTPostulacion>(postulaciones);
	}
	
	public void setPostulacion(List<DTPostulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}
	
}
