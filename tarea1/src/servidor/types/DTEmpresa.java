package servidor.types;

import java.util.Set;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DTEmpresa extends DTUsuario {

	private String nombreEmpresa;
	private String descripcion;
	private String linkWeb;
	private Set<DTOferta> ofertas;
	
	
	public DTEmpresa() {
		super();
		this.setNombreEmpresa(new String());
		this.setDescripcion(new String());
		this.setLinkWeb(new String());
		this.setOfertas();
	}

	// constructores
	public DTEmpresa(String nickname, String nombre, String apellido, String correo, String contraseña,
			String nombreEmpresa, String descripcion, String linkWeb, Set<DTOferta> ofertas, String url_imagen) {
		super(nickname, nombre, apellido, correo, contraseña, url_imagen);
		this.setNombreEmpresa(nombreEmpresa);
		this.setDescripcion(descripcion);
		this.setLinkWeb(linkWeb);
		this.setOfertas(ofertas);
	}

	// getters
	public String toString() {
		return nombreEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getLinkWeb() {
		return linkWeb;
	}

	public Set<DTOferta> getOfertas() {
		return ofertas;
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

	private void setOfertas(Set<DTOferta> ofertas) {
		this.ofertas = ofertas;
	}

}
