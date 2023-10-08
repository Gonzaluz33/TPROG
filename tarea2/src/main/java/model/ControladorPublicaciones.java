package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import utils.DTOferta;
import utils.DTPaquete;
import utils.DTPublicacion;
import utils.DTTipoPublicacion;
import excepciones.TipoPublicExisteException;
import excepciones.PaqueteExisteException;

public class ControladorPublicaciones implements IControladorPublicaciones {

	private static ControladorPublicaciones instancia; 
	
	public static ControladorPublicaciones getInstance() {
        if (instancia == null) {
            instancia = new ControladorPublicaciones();
        }
        return instancia;
    }
	
	public List<DTTipoPublicacion> obtenerTipos() {
		ManejadorPublicaciones manP = ManejadorPublicaciones.getInstance();
		return manP.obtenerTipos();
	}
	
	public DTTipoPublicacion obtenerDatosTipoPublicacion(String nombre) {
		ManejadorPublicaciones manP = ManejadorPublicaciones.getInstance();
		return manP.obtenerTipoPublicacion(nombre).toDataType();
	}
	
	public Publicacion addPublicacion(OfertaLaboral ofL, String tipo) {
		ManejadorPublicaciones manPub = ManejadorPublicaciones.getInstance();
		TipoPublicacion datosTipo = manPub.getTipo(tipo);
		Integer id = manPub.getLastPubId();
		Integer duracion = datosTipo.getDuracion();
		LocalDate fechaActual = LocalDate.now();
		LocalDate fin = fechaActual.plusDays(duracion);
		Publicacion pub = new Publicacion(id, datosTipo.getCosto(), fechaActual, fin, ofL);
		manPub.addPublicacion(pub);
		//find tipo, agregar asociacion si no existe, y pumquepam
		return pub;
	}
	public void altaTipoPublicacionOL(String nombre, String descripcion, int exposicion, Integer duracion, Integer costoPublic, LocalDate fechaAlta ) 
			throws TipoPublicExisteException {
		ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
		TipoPublicacion tipoP = new TipoPublicacion( nombre, descripcion, duracion, costoPublic, fechaAlta, exposicion);
		manejadorP.altaTipoPublicacionOL(tipoP);
	}
	
	public void altaPaqueteTipoPublicacion(String nombre, String descripcion, int validez, int descuento ,String fecha,String url_imagen) throws PaqueteExisteException {
		ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
		if(!fecha.isEmpty()) {
		       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        LocalDate fechaParseada = LocalDate.parse(fecha, formatter);
				Paquete paquete = new Paquete(nombre, descripcion, validez, descuento, 0, fechaParseada,url_imagen);
				manejadorP.addPaqueteTipoPublicacion(paquete);
		}
		else {
			LocalDate fechaAlta = LocalDate.now();
			Paquete paquete = new Paquete(nombre, descripcion, validez, descuento, 0, fechaAlta,url_imagen);
			manejadorP.addPaqueteTipoPublicacion(paquete);
		}

	};
	
	public  void agregarTipoPublicacion(String nombrePaquete ,Integer cant, String nombreTipoPublicacion) {
		ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
		Paquete p = manejadorP.obtenerPaquete(nombrePaquete);
		TipoPublicacion t = manejadorP.obtenerTipoPublicacion(nombreTipoPublicacion);
		p.agregarTipoPublicacion(cant, t);
	}

	public List<DTPaquete> listarPaquetes() {
		ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
		return manejadorP.obtenerListaPaquetes();
	}
	
	public List<DTPublicacion> obtenerPublicaciones() {
		ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
		return manejadorP.obtenerPublicaciones();
	}
	
	public List<DTPublicacion> obtenerPublicacionesPorBusqueda(String busqueda) {
        ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
        List<DTPublicacion> publicaciones = manejadorP.obtenerPublicaciones();
        return publicaciones.stream()
                .filter(dtPublicacion -> {
                    DTOferta oferta = dtPublicacion.getDtOferta();
                    return oferta.getNombre().toLowerCase().contains(busqueda.toLowerCase())
                            || oferta.getDescripcion().toLowerCase().contains(busqueda.toLowerCase())
                            || oferta.getCiudad().toLowerCase().contains(busqueda.toLowerCase())
                            || oferta.getDepartamento().toLowerCase().contains(busqueda.toLowerCase());
                })
                .collect(Collectors.toList());
    }
	
	public List<DTPublicacion> obtenerPublicacionesPorKeywords(List<String> keywords) {
	    ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
	    List<DTPublicacion> publicaciones = manejadorP.obtenerPublicaciones();
	    List<String> keywordsLowerCase = keywords.stream()
	        .map(String::toLowerCase)
	        .collect(Collectors.toList());

	    return publicaciones.stream()
	        .filter(dtPublicacion -> {
	            DTOferta oferta = dtPublicacion.getDtOferta();
	            List<String> ofertaKeywords = oferta.getKeywords();

	            List<String> ofertaKeywordsLowerCase = ofertaKeywords.stream()
	                .map(String::toLowerCase)
	                .collect(Collectors.toList());

	            return !Collections.disjoint(keywordsLowerCase, ofertaKeywordsLowerCase);
	        })
	        .collect(Collectors.toList());
	}

	
}
