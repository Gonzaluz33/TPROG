package utils;

import java.util.Date;

/**
 * DataType para transportar la información de un postulante entre capa lógica y de presentación.
 * Clase hija de DTUsuario.
 *
 */
public class DTPostulante extends DTUsuario {

	private Date fechaNacimiento;
	private String nacionalidad;
	
	// constructores
	public DTPostulante() {
		super();
		this.setFechaNacimiento(new Date());
		this.setNacionalidad(new String());
	}
	
	public DTPostulante(String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, String nacionalidad) {
		super(nickname, nombre, apellido, correo);
		this.setFechaNacimiento(fechaNacimiento);
        this.setNacionalidad(nacionalidad);
	}
	
	// getters
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}
	
	// setters
	private void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	private void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
}
