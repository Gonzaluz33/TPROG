package utils;

import java.time.LocalDateTime;

public class DTPostulacion {

	private String nicknamePostulante;
	private String nombreOfertaLaboral;
	
	private LocalDateTime fecha;
	private String cvReducido;
	private String motivacion;
	
	// constructores
	public DTPostulacion() {
		this.setNicknamePostulante(new String());
		this.setNombreOfertaLaboral(new String());
		this.setFecha(null);
		this.setCvReducido(new String());
		this.setMotivacion(new String());
	}
	
	public DTPostulacion(String nicknamePostulante, String nombreOfertaLaboral, LocalDateTime fecha, String cvReducido, String motivacion) {
		this.setNicknamePostulante(nicknamePostulante);
		this.setNombreOfertaLaboral(nombreOfertaLaboral);
		this.setFecha(fecha);
		this.setCvReducido(cvReducido);
		this.setMotivacion(motivacion);
	}
	
	// getters
	public String getNicknamePostulante() {
		return this.nicknamePostulante;
	}
	
	public String getNombreOfertaLaboral() {
		return this.nombreOfertaLaboral;
	}
	
	public LocalDateTime getFecha() {
		return this.fecha;
	}
	
	public String getCvReducido() {
		return this.cvReducido;
	}
	
	public String getMotivacion() {
		return this.motivacion;
	}
	
	// setters
	private void setNicknamePostulante(String nicknamePostulante) {
		this.nicknamePostulante = nicknamePostulante;
	}
	
	private void setNombreOfertaLaboral(String ofertaLaboral) {
		this.nombreOfertaLaboral = ofertaLaboral;
	}
	
	private void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	private void setCvReducido(String cvReducido) {
		this.cvReducido = cvReducido;
	}
	
	private void setMotivacion(String motivacion) {
		this.motivacion = motivacion;
	}
	
}
