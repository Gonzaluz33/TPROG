package utils;

import java.util.Date;
import java.util.List;

/**
 * DataType para transportar la información de un postulante entre capa lógica y de presentación.
 * Clase hija de DTUsuario.
 *
 */
public class DTPostulante extends DTUsuario {

	private Date fechaNacimiento;
	private String nacionalidad;
	private List<DTPostulacion> postulaciones;
	
	// constructores
	public DTPostulante(String string, String string2, String string3, String string4, Date date, String string5, List<DTPostulacion> list) {
		super();
		this.setFechaNacimiento(new Date());
		this.setNacionalidad(new String());
	}
	
	public DTPostulante(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, String nacionalidad) {
		super(nickname, nombre, apellido, correo);
		this.setFechaNacimiento(fechaNacimiento);
        this.setNacionalidad(nacionalidad);
        this.setPostulaciones(postulaciones);
	}
	
	// getters
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public List<DTPostulacion> getPostulaciones() {
		return postulaciones;
	}
	
	// setters
	private void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	private void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	private void setPostulaciones(List<DTPostulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}
	
}
