package servidor.types;

import java.time.LocalDateTime;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
public class DTPostulacion {

	private String nicknamePostulante;
	private String nombreOfertaLaboral;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime fecha;
	private String cvReducido;
	private String motivacion;
	private String urlVideo;


	// constructores
	public DTPostulacion() {
		this.setNicknamePostulante(new String());
		this.setNombreOfertaLaboral(new String());
		this.setFecha(null);
		this.setCvReducido(new String());
		this.setMotivacion(new String());
		this.setUrlVideo(new String());
	}

	public DTPostulacion(String nicknamePostulante, String nombreOfertaLaboral, LocalDateTime fecha, String cvReducido,
			String motivacion, String urlVideo) {
		this.setNicknamePostulante(nicknamePostulante);
		this.setNombreOfertaLaboral(nombreOfertaLaboral);
		this.setFecha(fecha);
		this.setCvReducido(cvReducido);
		this.setMotivacion(motivacion);
		this.setUrlVideo(urlVideo);

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
	
	public String getVideo() {
		return this.urlVideo;
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

	private void setUrlVideo(String urlVid) {
		this.urlVideo = urlVid;
	}
}
