package utils;

import java.time.LocalDate;

public class DTPublicacion {

	private Integer id;
	private Integer costoAsociado;
	private LocalDate fechaAlta;
	private LocalDate fechaVencimiento;
	private DTOferta dtOferta;
	private DTTipoPublicacion dtTipo;

	// Constructor
	public DTPublicacion() {
	}

	public DTPublicacion(Integer id, Integer costoAsociado, LocalDate fechaAlta, LocalDate fechaVencimiento,
			DTOferta dtOferta, DTTipoPublicacion dtTipo) {
		this.id = id;
		this.costoAsociado = costoAsociado;
		this.fechaAlta = fechaAlta;
		this.fechaVencimiento = fechaVencimiento;
		this.dtOferta = dtOferta;
		this.dtTipo = dtTipo;
	}

	// Getters
	public Integer getId() {
		return id;
	}

	public Integer getCostoAsociado() {
		return costoAsociado;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public DTOferta getDtOferta() {
		return dtOferta;
	}
	
	public DTTipoPublicacion getDtTipo() {
		return dtTipo;
	}

	// Setters
	public void setId(Integer id) {
		this.id = id;
	}

	public void setCostoAsociado(Integer costoAsociado) {
		this.costoAsociado = costoAsociado;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public void setDtOferta(DTOferta dtOferta) {
		this.dtOferta = dtOferta;
	}
	
	public void setDtTipo(DTTipoPublicacion dtTipo) {
		this.dtTipo = dtTipo;
	}
}