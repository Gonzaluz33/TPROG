package utils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class DTOferta {

	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private String horario;
	private String remuneracion;
	private LocalDateTime fechaAlta;
	private EnumEstadoOferta estado;
<<<<<<< HEAD
	private String imagen;
	private List<DTPostulacion> postulaciones;
	private List<String> keywords;

=======
	private List<DTPostulacion> postulaciones;
	private List<String> keywords;
	private String formaPago;
	private String urlImagen;
	private String paqueteSeleccionado;
	
>>>>>>> WEB-altaconsulta
	private String nicknameEmpresa;

	// constructores
<<<<<<< HEAD
	public DTOferta() {
		this.setNombre(new String());
		this.setDescripcion(new String());
		this.setCiudad(new String());
		this.setDepartamento(new String());
		this.setHorario(new String());
		this.setRemuneracion(new String());
		this.setFechaAlta(fechaAlta);
		this.setEstado(estado);
		this.setImagen(imagen);
		this.setPostulacion(new ArrayList<DTPostulacion>());
		this.setNicknameEmpresa(new String());
=======
    public DTOferta() {
        this.setNombre(new String());
        this.setDescripcion(new String());
        this.setCiudad(new String());
        this.setDepartamento(new String());
        this.setHorario(new String());
        this.setRemuneracion(new String());
        this.setFechaAlta(fechaAlta);
        this.setEstado(estado);
        this.setPostulacion(new ArrayList<DTPostulacion>());
        this.setNicknameEmpresa(new String());
>>>>>>> WEB-altaconsulta
		this.setKeywords(new ArrayList<String>());
	}

<<<<<<< HEAD
	/**
	 * Constructor SIN lista de postulaciones asociadas a la oferta laboral.
	 */
	public DTOferta(String nombre, String descripcion, String ciudad, String departamento, String horario,
			String remuneracion, LocalDateTime fechaAlta, EnumEstadoOferta estado ,String imagen,String nicknameEmpresa, List<String> keywords) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setCiudad(ciudad);
		this.setDepartamento(departamento);
		this.setHorario(horario);
		this.setRemuneracion(remuneracion);
		this.setFechaAlta(fechaAlta);
		this.setEstado(estado);
		this.setImagen(imagen);
		this.setPostulacion(null);
		this.setNicknameEmpresa(nicknameEmpresa);
=======
    /**
     * Constructor SIN lista de postulaciones asociadas a la oferta laboral.
     */
    public DTOferta(String nombre, String descripcion, String ciudad, String departamento, String horario, String remuneracion, LocalDateTime fechaAlta,EnumEstadoOferta estado, String nicknameEmpresa, List<String> keywords) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCiudad(ciudad);
        this.setDepartamento(departamento);
        this.setHorario(horario);
        this.setRemuneracion(remuneracion);
        this.setFechaAlta(fechaAlta);
        this.setEstado(estado);
        this.setPostulacion(null);
        this.setNicknameEmpresa(nicknameEmpresa);
>>>>>>> WEB-altaconsulta
		this.setKeywords(keywords);
	}

<<<<<<< HEAD
	/**
	 * Constructor CON lista de postulaciones asociadas a la oferta laboral.
	 */
	public DTOferta(String nombre, String descripcion, String ciudad, String departamento, String horario,
			String remuneracion, LocalDateTime fechaAlta,EnumEstadoOferta estado ,String imagen ,List<DTPostulacion> postulaciones, String nicknameEmpresa,
			List<String> keywords) {
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setCiudad(ciudad);
		this.setDepartamento(departamento);
		this.setHorario(horario);
		this.setRemuneracion(remuneracion);
		this.setFechaAlta(fechaAlta);
		this.setEstado(estado);
		this.setImagen(imagen);
=======
    /**
     * Constructor CON lista de postulaciones asociadas a la oferta laboral.
     */
    public DTOferta(String nombre, String descripcion, String ciudad, String departamento, String horario, String remuneracion, LocalDateTime fechaAlta,EnumEstadoOferta estado, List<DTPostulacion> postulaciones, String nicknameEmpresa, List<String> keywords) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCiudad(ciudad);
        this.setDepartamento(departamento);
        this.setHorario(horario);
        this.setRemuneracion(remuneracion);
        this.setFechaAlta(fechaAlta);
        this.setEstado(estado);
>>>>>>> WEB-altaconsulta
		this.setPostulacion(postulaciones);
		this.setNicknameEmpresa(nicknameEmpresa);
		this.setKeywords(keywords);
	}

	// getters
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getHorario() {
		return horario;
	}

	public String getRemuneracion() {
		return remuneracion;
	}

	public List<DTPostulacion> getPostulaciones() {
		return postulaciones;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public String getNicknameEmpresa() {
		return nicknameEmpresa;
	}

	public List<String> getKeywords() {
		return keywords;
	}
	
	public EnumEstadoOferta getEstado() {
		return estado;
	}
<<<<<<< HEAD
	
	public String getImagen() {
		return imagen;
=======

	
	public String getUrlImagen() {
	    return urlImagen;
	}
	
	public String getPaqueteSeleccionado() {
	    return paqueteSeleccionado;
	}
	
	public String getFormaPago() {
	    return formaPago;
>>>>>>> WEB-altaconsulta
	}

	// setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setRemuneracion(String remuneracion) {
		this.remuneracion = remuneracion;
	}

	public void setPostulacion(List<DTPostulacion> postulaciones) {
		this.postulaciones = postulaciones;
	}

	public void setFechaAlta(LocalDateTime fecha) {
		this.fechaAlta = fecha;
	}

	public void setNicknameEmpresa(String nicknameEmpresa) {
		this.nicknameEmpresa = nicknameEmpresa;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
	public void setEstado (EnumEstadoOferta estado) {
		this.estado = estado;
	}
<<<<<<< HEAD
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
=======

	
	public void setUrlImagen(String urlImagen) {
	    this.urlImagen = urlImagen;
	}
	
	public void setPaqueteSeleccionado(String paqueteSeleccionado) {
	    this.paqueteSeleccionado = paqueteSeleccionado;
	}
	
	public void setFormaPago(String formaPago) {
	    this.formaPago = formaPago;
>>>>>>> WEB-altaconsulta
	}

}
