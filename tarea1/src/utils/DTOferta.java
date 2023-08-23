package utils;

import java.util.Date;

public class DTOferta {
	
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private String horario;
	private String remuneracion;
	private Date fechaAlta;
	//private int costoAsociado;
	
	// constructores
    public DTOferta() {
        this.setNombre(new String());
        this.setDescripcion(new String());
        this.setCiudad(new String());
        this.setDepartamento(new String());
        this.setHorario(new String());
        this.setRemuneracion(new String());
        this.setFechaAlta(new Date());
        //this.setCostoAsociado(-1);
    }

    public DTOferta(String nombre, String descripcion, String ciudad, String departamento, String horario, String remuneracion, Date fechaAlta/*, int costoAsociado*/) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCiudad(ciudad);
        this.setDepartamento(departamento);
        this.setHorario(horario);
        this.setRemuneracion(remuneracion);
        this.setFechaAlta(fechaAlta);
        //this.setCostoAsociado(costoAsociado);
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

    public Date getFechaAlta() {
        return fechaAlta;
    }

    /*
    public int getCostoAsociado() {
        return costoAsociado;
    }
    */

    // setters
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    private void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    private void setHorario(String horario) {
        this.horario = horario;
    }

    private void setRemuneracion(String remuneracion) {
        this.remuneracion = remuneracion;
    }

    private void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /*
    private void setCostoAsociado(int costoAsociado) {
        this.costoAsociado = costoAsociado;
    }
    */

}
