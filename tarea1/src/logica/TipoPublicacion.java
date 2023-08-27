package logica;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import utils.DTTipoPublicacion;



public class TipoPublicacion {
	private String nombre;
	private String descripcion;
	private Integer duracionPublicacion;
	private Integer costo;
	private LocalDate fechaAlta;
	private Map<String, ContadorPublicaciones> cantidades = new HashMap<String, ContadorPublicaciones>();
	
	private EnumExposicion exposicion;
	
	public TipoPublicacion(){
		this.nombre = new String();
		this.descripcion = new String();
		this.duracionPublicacion = 0;
		this.costo = 0;
		this.fechaAlta = null;
		this.exposicion = EnumExposicion.Baja;
	}
	
public TipoPublicacion(String nombre, String descripcion, Integer duracionPublicacion, Integer costo, LocalDate alta, EnumExposicion exposicion ){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionPublicacion = duracionPublicacion;
		this.costo = costo;
		this.fechaAlta = alta;
		this.exposicion = exposicion;
	}
	
	public enum EnumExposicion {
	    Alta,
	    Media,
	    Baja
	}
	
	public void addCantidad(String nombre, ContadorPublicaciones contador) {
		if (!cantidades.containsKey(nombre)) {
			cantidades.put(nombre, contador);
		}
	}
	public ContadorPublicaciones getContador(String nickname) {
		return cantidades.get(nickname);
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
	
	public EnumExposicion getExposicion() {
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
	
	public void setExposicion(EnumExposicion exposicion) {
		this.exposicion = exposicion;
	}
	
    /**
     * Retorna los datos del usuario como un DataType DTTipoPublicacion.
     */
    DTTipoPublicacion toDataType() {
    	return new DTTipoPublicacion(getNombre(), getDescripcion(), getDuracion(),getCosto(), getAlta());
    }

	
}