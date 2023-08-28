package logica;

import java.time.LocalDate;

public class Publicacion {
	private Integer id;
	private Integer costoAsociado;
	private LocalDate  fechaAlta;
	private LocalDate  fechaVencimiento;
	private OfertaLaboral oferta;
	
	public Publicacion(Integer id, Integer costo, LocalDate  alta, LocalDate  fin, OfertaLaboral oferta){
		this.costoAsociado = costo;
		this.fechaAlta = alta;
		this.fechaVencimiento = fin;
		this.id = id;
		this.oferta = oferta;
	}
	
	public Integer getCosto() {
		return costoAsociado;
	}
	
	public OfertaLaboral getOferta() {
		return oferta;
	}
	
	public LocalDate  getAlta() {
		return fechaAlta;
	}
	
	public Integer getId() {
		return id;
	}
	
	public LocalDate  getFin() {
		return fechaVencimiento;
	}
	
	public void setCosto(Integer costo) {
		this.costoAsociado=costo;
	}
	
	public void setOferta(OfertaLaboral oferta) {
		this.oferta=oferta;
	}
	
	public void setAlta(LocalDate  alta) {
		this.fechaAlta=alta;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public void setFin(LocalDate  fin) {
		this.fechaVencimiento=fin;
	}
	
}
