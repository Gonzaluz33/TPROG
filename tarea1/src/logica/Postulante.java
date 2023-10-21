package logica;

import utils.DTPostulante;
import utils.DTPostulacion;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Representa al postulante en el sistema.
 * Tiene nickname, nombre, apellido, correo, fechaNacimiento, nacionalidad y un HashMap<String, Postulacion> postulaciones.
 * El campo postulaciones contiene las postulaciones asociadas al postulante y usa como key el nombre de la oferta laboral asociada a cada postulacion.
 * Clase hija de Usuario.
 *
 */
public class Postulante extends Usuario{

	private Date fechaNacimiento;
	private String nacionalidad;
	private Map<String, Postulacion> postulaciones;
	
	// constructores
	public Postulante() {
		super();
		this.setFechaNacimiento(new Date());
		this.setNacionalidad(new String());
		this.postulaciones = new HashMap<String, Postulacion>();
	}
	
	public Postulante(String nickname, String nombre, String apellido, String correo, String contraseña ,Date fechaNacimiento, String nacionalidad) {
		super(nickname, nombre, apellido, correo, contraseña);
		this.setFechaNacimiento(fechaNacimiento);
		this.setNacionalidad(nacionalidad);
		this.postulaciones = new HashMap<String, Postulacion>();
	}
	
	// getters
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public List<DTPostulacion> getPostulaciones() {
		return postulaciones.values()
				.stream()
				.map(Postulacion::toDataType)
				.collect(Collectors.toList());
	}
	
	// setters
	void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	/**
	 * Asocia la postulacion al postulante y usa el nombre de la oferta asociada a la postulacion como la key en el mapa de postulaciones.
	 */
	public void asociarPostulacion(Postulacion postulacion, String nombreOferta) {
		this.postulaciones.put(nombreOferta, postulacion);
	}
	
	/**
	 * Retorna los datos del usuario como un datatype DTPostulante.
	 */
	@Override
	public DTPostulante toDataType() {
		return new DTPostulante(getNickname(), getNombre(), getApellido(), getCorreo(), getContraseña() ,getFechaNacimiento(), getNacionalidad(), getPostulaciones());
	}
	
}