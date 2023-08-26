package logica;

import utils.DTOferta;
import utils.DTPostulacion;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class OfertaLaboral {
	
	private String nombre; //unico
	private String descripcion;
	private String ciudad;
	private String departamento;
	private String horario;
	private String remuneracion;
	private Date fechaAlta;
	private List<Postulacion> postulaciones;
	
	// constructores
	public OfertaLaboral() {
		setNombre(new String());
		setDescripcion(new String());
		setCiudad(new String());
		setDepartamento(new String());
		setHorario(new String());
		setRemuneracion(new String());
		setFechaAlta(new Date());
		this.postulaciones = new ArrayList<Postulacion>();
	}
	
	public OfertaLaboral(String n, String desc, String c, String dep, String hora, Date fecha, String remuneracion) {
		this.ciudad = c;
		this.departamento = dep;
		this.descripcion = desc;
		this.fechaAlta = fecha;
		this.horario = hora;
		this.nombre = n;
		this.remuneracion = remuneracion;
		this.postulaciones = new ArrayList<Postulacion>();
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
	
	/**
	 * Devuelve una lista sin ordenar de tipo DTPostulacion con todas las postulaciones asociadas a la oferta laboral.
	 * Si no hay postulaciones asociadas a la oferta laboral devuelve una lista vacia.
	 */
	public List<DTPostulacion> getPostulaciones() {
		if ( this.postulaciones.isEmpty() )
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
	public void setFechaAlta(Date fa) {
		this.fechaAlta = fa;
	}
	
	public void asociarPostulacion(Postulacion postulacion) {
		this.postulaciones.add(postulacion);
	}
	
	/**
	 * Devuelve los datos de la oferta como un datatype DTOferta.
	 */
	public DTOferta toDataType() {
		return new DTOferta(this.nombre, this.descripcion, this.ciudad, this.departamento, this.horario, this.remuneracion, this.getPostulaciones());
	}
	
}
