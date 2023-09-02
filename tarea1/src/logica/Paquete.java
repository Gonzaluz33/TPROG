package logica;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.DTPaquete;
import utils.DTTupla_Cantidad_TipoPublicacion;



public class Paquete {
	private String nombre;
	private String descripcion;
	private Integer validez;
	private Integer descuento;
	private LocalDate fechaAlta;
	private Integer costoAsociado;
	private List<Tupla_Cantidad_TipoPublicacion> listaDeTuplas = new ArrayList<>();
	
	public Paquete() {
		this.setNombre(new String());
		this.setDescripcion(new String());
		this.setValidez(0);
		this.setDescuento(0);
		this.setCostoAsociado(0);
		this.setListaDeTuplas(null);
	}
	
	public Paquete(String nombre, String descripcion, Integer validez, Integer descuento, Integer costoAsociado, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.validez = validez;
		this.descuento = descuento;
		this.costoAsociado = costoAsociado;
		this.fechaAlta = fechaAlta;
	}
	
    // Getters
    public String getNombre() {
        return nombre;
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

    public Integer getCostoAsociado() {
        return costoAsociado;
    }
    public LocalDate getFechaAlta() {
    	return fechaAlta;
    }
    public List<Tupla_Cantidad_TipoPublicacion> getListaDeTuplas(){
    	return listaDeTuplas;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    public void agregarTipoPublicacion(Integer cant, TipoPublicacion tipoPublicacion) {
   	 boolean encontrado = false;
   	    for (Tupla_Cantidad_TipoPublicacion tupla : listaDeTuplas) {
   	        if (tupla.getTipoPublicacion().getNombre().equals(tipoPublicacion.getNombre())) {
   	            tupla.agregarCantidad(cant);
   	            encontrado = true;
   	            break;
   	        }
   	    }
   	    if (!encontrado) {
   	        Tupla_Cantidad_TipoPublicacion nuevaTupla = new Tupla_Cantidad_TipoPublicacion(cant, tipoPublicacion);
   	        listaDeTuplas.add(nuevaTupla);
   	    }
   }

    public void agregarTipoPublicacion(Integer cant, TipoPublicacion tipoPublicacion) {
    	 boolean encontrado = false;
    	    for (Tupla_Cantidad_TipoPublicacion tupla : listaDeTuplas) {
    	        if (tupla.getTipoPublicacion().getNombre().equals(tipoPublicacion.getNombre())) {
    	            tupla.agregarCantidad(cant);
    	            encontrado = true;
    	            break;
    	        }
    	    }
    	    if (!encontrado) {
    	        Tupla_Cantidad_TipoPublicacion nuevaTupla = new Tupla_Cantidad_TipoPublicacion(cant, tipoPublicacion);
    	        listaDeTuplas.add(nuevaTupla);
    	    }
    }

    /**
     * Retorna los datos del usuario como un DataType DTPaquete.
     */
    DTPaquete toDataType() {
    	return new DTPaquete(getNombre(), getDescripcion(), getValidez(),getDescuento(), getCostoAsociado(), getFechaAlta(), getListaDeTuplas());
    }

}
