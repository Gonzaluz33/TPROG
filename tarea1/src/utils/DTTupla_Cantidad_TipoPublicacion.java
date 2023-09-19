package utils;

public class DTTupla_Cantidad_TipoPublicacion {
	private Integer cantidad;
	private String tipoPublicacion;

	public DTTupla_Cantidad_TipoPublicacion(Integer cantidad, String tipo) {
		this.setCantidad(cantidad);
		this.setTipoPublicacion(tipo);
	}
	
	//getters 
	public Integer getCantidad() {
		return cantidad;
	}
	
	public String getTipoPublicacion() {
		return tipoPublicacion;
	}
	
	public void setCantidad(Integer cant) {
		this.cantidad = cant;
	}
	
	public void setTipoPublicacion(String s) {
		this.tipoPublicacion = s;
	}

}
