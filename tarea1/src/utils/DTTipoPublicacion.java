package utils;

import java.util.Date;

public class DTTipoPublicacion {
	private String nombre;
	private String descripcion;
	private Integer duracionPublicacion;
	private Integer costo;
	private Date fechaAlta;
	
	public DTTipoPublicacion(String nombre, String descripcion, Integer duracionPublicacion, Integer costo, Date alta ){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionPublicacion = duracionPublicacion;
		this.costo = costo;
		this.fechaAlta = alta;
	}
	
	public enum EnumExposicion {
	    Alta,
	    Media,
	    Baja
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Integer getDuracion() {
		return duracionPublicacion;
	}
	
	public Integer getCosto() {
		return costo;
	}
	
	public Date getAlta() {
		return fechaAlta;
	}
	
	
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	
	public void setDuracion(Integer duracion) {
		this.duracionPublicacion = duracion;
	}
	
	public void setAlta(Date alta) {
		this.fechaAlta = alta;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
