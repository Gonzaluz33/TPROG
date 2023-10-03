package utils;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

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
	public DTPostulante(String string, String string2, String string3, String string4, String string5, LocalDate localDate, String string6, List<DTPostulacion> list) {
		super();
		this.setFechaNacimiento(new Date());
        this.setNacionalidad(new String());
        this.setPostulaciones(new ArrayList<DTPostulacion>());
	}
	
	/**
	 * Constructor SIN la lista de postulaciones asociada al postulante.
	 */
	public DTPostulante(String nickname, String nombre, String apellido, String correo, String contraseña ,Date fechaNacimiento, String nacionalidad) {
		super(nickname, nombre, apellido, correo, contraseña);
		this.setFechaNacimiento(fechaNacimiento);
        this.setNacionalidad(nacionalidad);
        this.setPostulaciones(new ArrayList<DTPostulacion>());
	}
	
	public DTPostulante(String nickname, String nombre, String apellido, String correo, String contraseña ,Date fechaNacimiento, String nacionalidad, List<DTPostulacion> postulaciones) {
		super(nickname, nombre, apellido, correo, contraseña);
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

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public void setPostulaciones(List<DTPostulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}
	
}
