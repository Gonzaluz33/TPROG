package model;
import java.time.LocalDate;

import excepciones.PaqueteExisteException;
import excepciones.TipoPublicExisteException;

import java.util.List;

import utils.DTPaquete;
import utils.DTPublicacion;
import utils.DTTipoPublicacion;

public interface IControladorPublicaciones {
	 public List<DTTipoPublicacion> obtenerTipos();
	 public Publicacion addPublicacion(OfertaLaboral ofL, String tipo);
	 public void altaTipoPublicacionOL (String nombre, String descripcion, int exposicion, Integer duracion, Integer CostoPublic, LocalDate fecha ) throws TipoPublicExisteException ;
	 public void altaPaqueteTipoPublicacion(String nombre, String descripcion, int validez, int descuento, String fecha,String url_imagen) throws PaqueteExisteException;
	 public List<DTPaquete> listarPaquetes();
	 public void agregarTipoPublicacion(String nombrePaquete ,Integer cant, String nombreTipoPublicacion);
	 public DTTipoPublicacion obtenerDatosTipoPublicacion(String nombre);
	 public List<DTPublicacion> obtenerPublicaciones();
	 public List<DTPublicacion> obtenerPublicacionesPorBusqueda(String busqueda);
	 public List<DTPublicacion> obtenerPublicacionesPorKeywords(List<String> keywords);
	 public Publicacion obtenerPublicacionAsociadaAOferta(String nombreOferta);
}
