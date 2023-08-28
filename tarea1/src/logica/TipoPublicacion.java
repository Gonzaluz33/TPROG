package logica;

import java.time.LocalDate;

import utils.DTTipoPublicacion;



public class TipoPublicacion {
	private String nombre;
	private String descripcion;
	private Integer duracionPublicacion;
	private Integer costo;
	private LocalDate fechaAlta;
	private int exposicion;
	
	public TipoPublicacion(){
		this.nombre = new String();
		this.descripcion = new String();
		this.duracionPublicacion = 0;
		this.costo = 0;
		this.fechaAlta = null;
		this.exposicion = 0;
	}
	
	public TipoPublicacion(String nombre, String descripcion, Integer duracionPublicacion, Integer costo, LocalDate alta, int exposicion ){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionPublicacion = duracionPublicacion;
		this.costo = costo;
		this.fechaAlta = alta;
		this.exposicion = exposicion;
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
	
	public LocalDate getAlta() {
	
		return fechaAlta;
	}
	
	public int getExposicion() {
		return exposicion;
	}
	
	
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	
	public void setDuracion(Integer duracion) {
		this.duracionPublicacion = duracion;
	}
	
	public void setAlta(LocalDate alta) {
		this.fechaAlta = alta;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setExposicion(int exposicion) {
		this.exposicion = exposicion;
	}
	
    /**
     * Retorna los datos del usuario como un DataType DTTipoPublicacion.
     */
    DTTipoPublicacion toDataType() {
    	return new DTTipoPublicacion(getNombre(), getDescripcion(), getDuracion(),getCosto(), getAlta(), getExposicion());
    }

	
}