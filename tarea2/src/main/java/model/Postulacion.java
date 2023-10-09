package model;

import java.time.LocalDateTime;

import utils.DTPostulacion;

public class Postulacion {

	private String nombreOfertaLaboral;
	private String nicknamePostulante;
	private String CVreducido;
	private String motivacion;
	private LocalDateTime fechaPublic;
	
	// Constructores
	public Postulacion(){
		this.nombreOfertaLaboral = new String();
		this.nicknamePostulante = new String();
		this.CVreducido = new String();
		this.motivacion = new String();
		this.fechaPublic = null;
	}
	
	public Postulacion(String nombreOfertaLaboral, String nicknamePostulante, String CVReducido, String motivacion,  LocalDateTime fechaPublic ) {
		this.setNombreOfertaLaboral(nombreOfertaLaboral);
		this.setNicknamePostulante(nicknamePostulante);
		this.setCVReducido(CVReducido);
		this.setMotivacion(motivacion);
		this.setFechaPublic(fechaPublic);
	}
	
    // Setters
    public void setNombreOfertaLaboral(String nombreOfertaLaboral) {
    	this.nombreOfertaLaboral = nombreOfertaLaboral;
    }

	public void setNicknamePostulante(String nicknamePostulante) {
    	this.nicknamePostulante = nicknamePostulante;
    }
    
    public void setCVReducido(String CVReducido) {
        this.CVreducido = CVReducido;
    }

    public void setMotivacion(String motivacion) {
        this.motivacion = motivacion;
    }

    public void setFechaPublic(LocalDateTime fechaPublic) {
        this.fechaPublic = fechaPublic;
    }
    
    // Getters
    public String getNombreOfertaLaboral() {
    	return nombreOfertaLaboral;
    }
    
    public String getNicknamePostulante() {
    	return nicknamePostulante;
    }
    
    public String getCVReducido() {
        return CVreducido;
    }

    public String getMotivacion() {
        return motivacion;
    }

    public LocalDateTime getFechaPublic() {
        return fechaPublic;
    }
    
    /**
     * Retorna los datos de la postulacion como un DTPostulacion.
     */
    public DTPostulacion toDataType() {
    	return new DTPostulacion(getNicknamePostulante(), getNombreOfertaLaboral(), getFechaPublic(), getCVReducido(), getMotivacion());
    }

}
