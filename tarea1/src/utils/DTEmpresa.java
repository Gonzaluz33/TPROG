package utils;

/**
 * DataType para transportar la información de una empresa entre capa lógica y de presentación.
 * Clase hija de DTUsuario.
 *
 */
public class DTEmpresa extends DTUsuario {

	private String nombreEmpresa;
	private String descripcion;
	private String linkWeb;
	
	// constructores
	public DTEmpresa() {
		super();
		this.setNombreEmpresa(new String());
		this.setDescripcion(new String());
		this.setLinkWeb(new String());
	}
	
	public DTEmpresa(String nickname, String nombre, String apellido, String correo, String nombreEmpresa, String descripcion, String linkWeb) {
		super();
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
	
}
