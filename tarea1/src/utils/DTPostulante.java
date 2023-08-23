package utils;

/**
 * DataType para transportar la información de un postulante entre capa lógica y de presentación.
 * Clase hija de DTUsuario.
 *
 */
public class DTPostulante extends DTUsuario {

	private String fechaNacimiento;
	private String nacionalidad;
	
	// constructores
	public DTPostulante() {
		super();
		this.setFechaNacimiento(new String());
		this.setNacionalidad(new String());
	}
	
	public DTPostulante(String nickname, String nombre, String apellido, String correo, String fechaNacimiento, String nacionalidad) {
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
	
}
