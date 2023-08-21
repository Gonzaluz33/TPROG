package logica;


public class Paquete {
	private String nombre;
	private String descripcion;
	private Integer validez;
	private Integer descuento;
	private Integer costoAsociado;
	
	public Paquete(String nombre, String descripcion, Integer validez, Integer descuento, Integer costoAsociado ) {
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


}
