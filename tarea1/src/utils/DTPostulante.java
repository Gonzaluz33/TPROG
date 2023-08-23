package utils;

import java.util.List;

/**
 * DataType para transportar la información de un postulante entre capa lógica y de presentación.
 * Clase hija de DTUsuario.
 *
 */
public class DTPostulante extends DTUsuario {

	private String fechaNacimiento;
	private String nacionalidad;
	private List<DTPostulacion> postulaciones;
	
	// constructores
	/**
	 * Constructor SIN la lista de postulaciones asociada al postulante.
	 */
	public DTPostulante(String nickname, String nombre, String apellido, String correo, String fechaNacimiento, String nacionalidad) {
		super(nickname, nombre, apellido, correo);
		this.setFechaNacimiento(fechaNacimiento);
        this.setNacionalidad(nacionalidad);
        this.setPostulaciones(null);
	}
	

	/**
	 * Constructor CON la lista de postulaciones asociada al postulante.
	 */
	public DTPostulante(String nickname, String nombre, String apellido, String correo, String fechaNacimiento, String nacionalidad, List<DTPostulacion> postulaciones) {
		super(nickname, nombre, apellido, correo);
		this.setFechaNacimiento(fechaNacimiento);
        this.setNacionalidad(nacionalidad);
        this.setPostulaciones(postulaciones);
	}
	
	// getters
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public List<DTPostulacion> getPostulaciones() {
		return postulaciones;
	}
	
	// setters
	private void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	private void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	private void setPostulaciones(List<DTPostulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}
	
}
