package logica;

import java.util.Date;

public class Publicacion {
	private Integer id;
	private Integer costoAsociado;
	private Date fechaAlta;
	private Date fechaVencimiento;
	
	public Publicacion(Integer id, Integer costo, Date alta, Date fin){
		this.costoAsociado = costo;
		this.fechaAlta = alta;
		this.fechaVencimiento = fin;
		this.id = id;
	}
	
	public Integer getCosto() {
		return costoAsociado;
	}
	
	public Date getAlta() {
		return fechaAlta;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Date getFin() {
		return fechaVencimiento;
	}
	
	public void setCosto(Integer costo) {
		this.costoAsociado=costo;
	}
	
	public void setAlta(Date alta) {
		this.fechaAlta=alta;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public void setFin(Date fin) {
		this.fechaVencimiento=fin;
	}
	
}
