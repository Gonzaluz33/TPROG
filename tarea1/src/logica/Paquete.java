package logica;

import utils.DTPaquete;



public class Paquete {
	private String nombre;
	private String descripcion;
	private Integer validez;
	private Integer descuento;
	private Integer costoAsociado;
	
	public Paquete() {
		this.nombre = new String();
		this.descripcion = new String();
		this.validez = 0;
		this.descuento = 0;
		this.costoAsociado = 0;
	}
	
	public Paquete(String nombre, String descripcion, Integer validez, Integer descuento, Integer costoAsociado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.validez = validez;
		this.descuento = descuento;
		this.costoAsociado = costoAsociado;
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

    /**
     * Retorna los datos del usuario como un DataType DTPaquete.
     */
    DTPaquete toDataType() {
    	return new DTPaquete(getNombre(), getDescripcion(), getValidez(),getDescuento(), getCostoAsociado());
    }

}
