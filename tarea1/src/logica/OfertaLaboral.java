package logica;

import utils.DTOferta;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class OfertaLaboral {
	
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private String horario;
	private String remuneracion;
	private Date fechaAlta;
	private List<Publicacion> publicaciones = new ArrayList<Publicacion>();
	private List<Keyword> keywords = new ArrayList<Keyword>();
	
	public OfertaLaboral(String n, String desc, String c, String dep, String hora, Date fecha, String remuneracion) {
		this.ciudad = c;
		this.departamento = dep;
		this.descripcion = desc;
		this.fechaAlta = fecha;
		this.horario = hora;
		this.nombre = n;
		this.remuneracion = remuneracion;
	}
	
	public void addPublicacion(Publicacion pub) {
        publicaciones.add(pub);
    }
	
	public void addKeyword(Keyword keyword) {
        keywords.add(keyword);
    }
	
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getDepartamento() {
		return departamento;
	}
	public String getHorario() {
		return horario;
	}
	public String getRemuneracion() {
		return remuneracion;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public List<Keyword> getKeywords(){
		return keywords;
	}
	
		
	public void setNombre(String n) {
		this.nombre = n;
	}
	public void setDescripcion(String d) {
		this.descripcion= d;
	}
	
	public void setCiudad(String c) {
		this.ciudad = c;
	}
	
	public void setDepartamento(String d) {
		this.departamento=d;
	}
	public void setHorario(String h) {
		this.horario = h;
	}
	public void setRemuneracion(String r) {
		this.remuneracion = r;
	}
	public void setFechaAlta(Date fa) {
		this.fechaAlta = fa;
	}
	public void setPublicacion(ArrayList<Publicacion> pub) {
		this.publicaciones = pub;
	}
	public void setKeywords(ArrayList<Keyword> keys) {
		this.keywords = keys;
	}
	
	/**
	 * Devuelve los datos de la oferta como un datatype DTOferta.
	 */
	public DTOferta toDataType() {
		return new DTOferta(this.nombre, this.descripcion, this.ciudad, this.departamento, this.horario, this.remuneracion, this.fechaAlta);
	}
	
}
