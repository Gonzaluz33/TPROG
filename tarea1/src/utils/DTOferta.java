package utils;

import java.util.List;

public class DTOferta {
	
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private String horario;
	private String remuneracion;
	List<DTPostulacion> postulaciones;
	
	// constructores
    public DTOferta() {
        this.setNombre(new String());
        this.setDescripcion(new String());
        this.setCiudad(new String());
        this.setDepartamento(new String());
        this.setHorario(new String());
        this.setRemuneracion(new String());
    }

    /**
     * Constructor SIN lista de postulaciones asociadas a la oferta laboral.
     */
    public DTOferta(String nombre, String descripcion, String ciudad, String departamento, String horario, String remuneracion) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCiudad(ciudad);
        this.setDepartamento(departamento);
        this.setHorario(horario);
        this.setRemuneracion(remuneracion);
        this.setPostulacion(null);
    }

    /**
     * Constructor CON lista de postulaciones asociadas a la oferta laboral.
     */
    public DTOferta(String nombre, String descripcion, String ciudad, String departamento, String horario, String remuneracion, List<DTPostulacion> postulaciones) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCiudad(ciudad);
        this.setDepartamento(departamento);
        this.setHorario(horario);
        this.setRemuneracion(remuneracion);
		this.setPostulacion(postulaciones);
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


}
