package utils;

import java.util.Date;

public class DTPostulacion {

	private String nicknamePostulante;
	private String nombreOfertaLaboral;
	private Date fecha;
	private String cv;
	private String motivacion;
	private EnumEstadoSeleccion estadoSeleccion;
	
	// constructores
	public DTPostulacion(String nicknamePostulante, String nombreOfertaLaboral, Date fecha, String cv, String motivacion, EnumEstadoSeleccion estadoSeleccion) {
		this.setNicknamePostulante(nicknamePostulante);
		this.setNombreOfertaLaboral(nombreOfertaLaboral);
		this.setFecha(fecha);
		this.setCv(cv);
		this.setMotivacion(motivacion);
		this.setEstadoSeleccion(estadoSeleccion);
	}
	
	// getters
	public String getNicknamePostulante() {
		return this.nicknamePostulante;
	}
	
	public String getNombreOfertaLaboral() {
		return this.nombreOfertaLaboral;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
	
	public String getCv() {
		return this.cv;
	}
	
	public String getMotivacion() {
		return this.motivacion;
	}
	
	public EnumEstadoSeleccion getEstadoSeleccion() {
		return this.estadoSeleccion;
	}
	
	// setters
	private void setNicknamePostulante(String nicknamePostulante) {
		this.nicknamePostulante = nicknamePostulante;
	}
	
	private void setNombreOfertaLaboral(String ofertaLaboral) {
		this.nombreOfertaLaboral = ofertaLaboral;
	}
	
	private void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	private void setCv(String cv) {
		this.cv = cv;
	}
	
	private void setMotivacion(String motivacion) {
		this.motivacion = motivacion;
	}
	
	private void setEstadoSeleccion(EnumEstadoSeleccion estadoSeleccion) {
		this.estadoSeleccion = estadoSeleccion;
	}
	
}
