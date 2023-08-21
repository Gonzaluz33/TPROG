package logica;

import utils.DTUsuario;
import utils.DTEmpresa;

/**
 * Representa a la empresa en el sistema.
 * Clase hija de Usuario.
 *
 */
public class Empresa extends Usuario {

	private String nombreEmpresa;
	private String descripcion;
	private String linkWeb;
	
	// constructores
	public Empresa(String nickname, String nombre, String apellido, String correo, String nombreEmpresa, String descripcion, String linkWeb) {
		super(nickname, nombre, apellido, correo);
		this.setNombreEmpresa(nombreEmpresa);
		this.setDescripcion(descripcion);
		this.setLinkWeb(linkWeb);
	}
	
	// getters
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public String getLinkWeb() {
		return linkWeb;
	}
	
	// setters
	private void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	private void setLinkWeb(String linkWeb) {
		this.linkWeb = linkWeb;
	}
	
	/**
	 * Retorna los datos del usuario como un datatype DTPostulante.
	 */
	DTUsuario toDataType() {
		return new DTEmpresa(getNickname(), getNombre(), getApellido(), getCorreo(), getNombreEmpresa(), getDescripcion(), getLinkWeb());
	}
	
}
