package utils;

import java.time.*;

public class DTOferta {
	
	String nombre;
	String descripcion;
	String ciudad;
	String departamento;
	String horario;
	int renumeracion;
	LocalDateTime fechaAlta;
	int costoAsociado;
	
	// constructores
    public DTOferta() {
        this.setNombre(new String());
        this.setDescripcion(new String());
        this.setCiudad(new String());
        this.setDepartamento(new String());
        this.setHorario(new String());
        this.setRenumeracion(-1);
        this.setFechaAlta(null);
        this.setCostoAsociado(-1);
    }

    public DTOferta(String nombre, String descripcion, String ciudad, String departamento, String horario, int renumeracion, LocalDateTime fechaAlta, int costoAsociado) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCiudad(ciudad);
        this.setDepartamento(departamento);
        this.setHorario(horario);
        this.setRenumeracion(renumeracion);
        this.setFechaAlta(fechaAlta);
        this.setCostoAsociado(costoAsociado);
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

    public int getRenumeracion() {
        return renumeracion;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public int getCostoAsociado() {
        return costoAsociado;
    }

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

    private void setRenumeracion(int renumeracion) {
        this.renumeracion = renumeracion;
    }

    private void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    private void setCostoAsociado(int costoAsociado) {
        this.costoAsociado = costoAsociado;
    }

}
