package logica;

import java.util.*;

import utils.DTUsuario;
import utils.DTEmpresa;
import utils.DTOferta;

/**
 * Representa a la empresa en el sistema.
 * Tiene nombreEmpresa, descripcion, linkWeb y un set ofertasLaborales de tipo DTOferta que contiene todas las ofertas asociadas a la empresa ordenadas por su nombre.
 * Clase hija de Usuario.
 *
 */
public class Empresa extends Usuario {

	private String nombreEmpresa;
	private String descripcion;
	private String linkWeb;
	private Set<DTOferta> ofertasLaborales = new TreeSet<DTOferta>();
	
	// constructores
	public Empresa() {
		super();
		this.setNombreEmpresa(new String());
		this.setDescripcion(new String());
		this.setLinkWeb(new String());
		this.ofertasLaborales = new TreeSet<>(Comparator.comparing(DTOferta::getNombre));
	}
	
	public Empresa(String nickname, String nombre, String apellido, String correo, String nombreEmpresa, String descripcion, String linkWeb) {
		super(nickname, nombre, apellido, correo);
		this.setNombreEmpresa(nombreEmpresa);
		this.setDescripcion(descripcion);
		this.setLinkWeb(linkWeb);
		this.ofertasLaborales = new TreeSet<>(Comparator.comparing(DTOferta::getNombre));
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
	
	/**
	 * Devuelve un set de DTOferta con todas las ofertas laborales asociadas a la empresa ordenadas segun su nombre.
	 * El set devuelto no comparte memoria con el original.
	 */
	public Set<DTOferta> getOfertas() {
//		return new TreeSet<DTOferta>(this.ofertasLaborales);
		return ofertasLaborales;
	}
	
	// setters
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setLinkWeb(String linkWeb) {
		this.linkWeb = linkWeb;
	}
	
	/**
	 * Agrega el nombre de la oferta laboral al set ordenado de ofertas laborales asociadas a la empresa.
	 */
	public void asociarOferta(DTOferta oferta) {
		this.ofertasLaborales.add(oferta);
	}
	
	/**
	 * Retorna los datos de la empresa como un datatype DTUsuario excepto el set de ofertas laborales asociadas a la misma.
	 */
	@Override
	public DTUsuario toDataType() {
		return new DTEmpresa(this.getNickname(), this.getNombre(), this.getApellido(), this.getCorreo(), this.getNombreEmpresa(), this.getDescripcion(), this.getLinkWeb(), this.getOfertas());
	}

}
