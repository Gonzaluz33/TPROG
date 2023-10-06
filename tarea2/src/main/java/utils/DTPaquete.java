package utils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import model.Tupla_Cantidad_TipoPublicacion;

public class DTPaquete {
	private String nombre;
	private String descripcion;
	private Integer validez;
	private Integer descuento;
	private double costoAsociado;
	private LocalDate fechaAlta;
	private String url_imagen;
	private List<Tupla_Cantidad_TipoPublicacion> listaDeTuplas;
	
	public DTPaquete(String nombre, String descripcion, Integer validez, Integer descuento, double costoAsociado, LocalDate fechaAlta, List<Tupla_Cantidad_TipoPublicacion> lista,String url_imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.validez = validez;
		this.descuento = descuento;
		this.costoAsociado = costoAsociado;
		this.fechaAlta = fechaAlta;
		this.listaDeTuplas = lista;
		this.url_imagen = url_imagen;
	}
	
    // Getters
	public String toString() {
		return nombre;
	}
	
    public String getNombre() {
        return nombre;
    }
    public String getUrlImagen() {
        return url_imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getValidez() {
        return validez;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public double getCostoAsociado() {
        return costoAsociado;
    }
    
    public LocalDate getFechaAlta() {
    	return fechaAlta;
    }
    
    public List<DTTupla_Cantidad_TipoPublicacion> getListaDeTuplas(){

    	return listaDeTuplas
		.stream()
		.map(Tupla_Cantidad_TipoPublicacion::toDataType)
		.collect(Collectors.toList());
    	
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setUrlImagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValidez(Integer validez) {
        this.validez = validez;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public void setCostoAsociado(Integer costoAsociado) {
        this.costoAsociado = costoAsociado;
    }
    public void setFechaAlta(LocalDate d) {
    	this.fechaAlta = d;
    }
    
    public void setListaDeTuplas(List<Tupla_Cantidad_TipoPublicacion> l) {
    	this.listaDeTuplas = l;	
    }

}
