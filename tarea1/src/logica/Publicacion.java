package logica;

import java.time.LocalDate;
import java.util.Date;

public class Publicacion {
	private int id;
	private int costoAsociado;
	private LocalDate  fechaAlta;
	private LocalDate  fechaVencimiento;
	private OfertaLaboral oferta;
	private ContadorPublicaciones contador;
	
	public Publicacion(int id, int costo, LocalDate  alta, LocalDate  fin, OfertaLaboral oferta, ContadorPublicaciones cont){
		this.costoAsociado = costo;
		this.fechaAlta = alta;
		this.fechaVencimiento = fin;
		this.id = id;
		this.contador = cont;
		this.oferta = oferta;
	}
	
	public int getCosto() {
		return costoAsociado;
	}
	
	public ContadorPublicaciones getContador() {
		return contador;
	}
	
	public OfertaLaboral getOferta() {
		return oferta;
	}
	
	public LocalDate  getAlta() {
		return fechaAlta;
	}
	
	public int getId() {
		return id;
	}
	
	public LocalDate  getFin() {
		return fechaVencimiento;
	}
	
	public void setCosto(int costo) {
		this.costoAsociado=costo;
	}
	
	public void setOferta(OfertaLaboral oferta) {
		this.oferta=oferta;
	}
	
	public void setAlta(LocalDate  alta) {
		this.fechaAlta=alta;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setFin(LocalDate  fin) {
		this.fechaVencimiento=fin;
	}
	
}
