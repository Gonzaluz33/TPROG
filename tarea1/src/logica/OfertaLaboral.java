package logica;

import utils.DTOferta;
import utils.DTPostulacion;
import utils.DTUsuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OfertaLaboral {
	
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private String horario;
	private String remuneracion;
	private LocalDateTime fechaAlta;
	
	private List<Postulacion> postulaciones = new ArrayList<Postulacion>();
	private List<Publicacion> publicaciones = new ArrayList<Publicacion>();
	private List<Keyword> keywords = new ArrayList<Keyword>();
	
	private Usuario empresa;
	
	// constructores
	public OfertaLaboral() {
		this.ciudad = new String();
		this.departamento = new String();
		this.descripcion = new String();
		this.fechaAlta = null;
		this.horario = new String();
		this.nombre = new String();
		this.remuneracion = new String();
		this.empresa = new Empresa();
	}
	
	public OfertaLaboral(String n, String desc, String c, String dep, String hora, LocalDateTime fecha, String remuneracion, Usuario emp) {
		this.ciudad = c;
		this.departamento = dep;
		this.descripcion = desc;
		this.fechaAlta = fecha;
		this.horario = hora;
		this.nombre = n;
		this.remuneracion = remuneracion;
		this.empresa = emp;
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
	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}
	public List<Keyword> getKeywords(){
		return keywords;
	}
	public DTUsuario getEmpresa() {
		return empresa.toDataType();
	}
	
	/**
	 * Devuelve una lista sin ordenar de tipo DTPostulacion con todas las postulaciones asociadas a la oferta laboral.
	 * Si no hay postulaciones asociadas a la oferta laboral devuelve una lista vacia.
	 */
	public List<DTPostulacion> getPostulaciones() {
		if (this.postulaciones.isEmpty())
			return new ArrayList<DTPostulacion>();
		return this.postulaciones
				.stream()
				.map(Postulacion::toDataType)
				.collect(Collectors.toList());
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
	public void setFechaAlta(LocalDateTime fa) {
		this.fechaAlta = fa;
	}
	public void setPublicacion(ArrayList<Publicacion> pub) {
		this.publicaciones = pub;
	}
	public void setKeywords(ArrayList<Keyword> keys) {
		this.keywords = keys;
	}
	/**
	 * Añade la postulacion a la coleccion de postulaciones asociadas a la oferta laboral.
	 */
	public void asociarPostulacion(Postulacion postulacion) {
		this.postulaciones.add(postulacion);
	}

	/**
	 * Devuelve los datos de la oferta como un datatype DTOferta.
	 */
	public DTOferta toDataType() {
		return new DTOferta(this.nombre, this.descripcion, this.ciudad, this.departamento, this.horario, this.remuneracion);
	}
	
}
