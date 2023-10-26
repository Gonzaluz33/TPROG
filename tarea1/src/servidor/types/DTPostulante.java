package servidor.types;


import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DTPostulante extends DTUsuario {

	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private List<DTPostulacion> postulaciones;
	
	// constructores
	public DTPostulante(String string, String string2, String string3, String string4, String string5, LocalDate localDate, String string6) {
		super();
		this.setFechaNacimiento(localDate);
        this.setNacionalidad(string6);
        this.setPostulaciones(new ArrayList<DTPostulacion>());
	}
	
	/**
	 * Constructor SIN la lista de postulaciones asociada al postulante.
	 */
	public DTPostulante(String nickname, String nombre, String apellido, String correo, String contraseña ,LocalDate fechaNacimiento, String nacionalidad, String url_imagen) {
		super(nickname, nombre, apellido, correo, contraseña, url_imagen);
		this.setFechaNacimiento(fechaNacimiento);
        this.setNacionalidad(nacionalidad);
        this.setPostulaciones(new ArrayList<DTPostulacion>());
	}
	
	public DTPostulante(String nickname, String nombre, String apellido, String correo, String contraseña ,LocalDate fechaNacimiento, String nacionalidad, List<DTPostulacion> postulaciones, String url_imagen) {
		super(nickname, nombre, apellido, correo, contraseña, url_imagen);
		this.setFechaNacimiento(fechaNacimiento);
        this.setNacionalidad(nacionalidad);
        this.setPostulaciones(postulaciones);
	}
	
	// getters
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public List<DTPostulacion> getPostulaciones() {
		return postulaciones;
	}
	
	// setters
	private void setFechaNacimiento(LocalDate fechaNacimiento2) {
		this.fechaNacimiento = fechaNacimiento2;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public void setPostulaciones(List<DTPostulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}
	
}

