package logica;

import utils.DTPostulante; 

/**
 * Representa al postulante en el sistema.
 * Clase hija de Usuario.
 *
 */
public class Postulante extends Usuario{

	private String fechaNacimiento;
	private String nacionalidad;
	
	// constructores
	public Postulante(String nickname, String nombre, String apellido, String correo, String fechaNacimiento, String nacionalidad) {
		super(nickname, nombre, apellido, correo);
		this.setFechaNacimiento(fechaNacimiento);
		this.setNacionalidad(nacionalidad);
	}
	
	// getters
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	// setters
	private void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	private void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	/**
	 * Retorna los datos del usuario como un datatype DTPostulante.
	 */
	DTPostulante toDataType() {
		return new DTPostulante(getNickname(), getNombre(), getApellido(), getCorreo(), getFechaNacimiento(), getNacionalidad());
	}
	
}
