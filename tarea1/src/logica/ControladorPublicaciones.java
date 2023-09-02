package logica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import utils.DTPaquete;
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
	
	public Publicacion addPublicacion(OfertaLaboral ofL, String tipo) {
		ManejadorPublicaciones manPub = ManejadorPublicaciones.getInstance();
		Integer id = manPub.getLastPubId();
		TipoPublicacion datosTipo = manPub.getTipo(tipo);
		LocalDate inicio = datosTipo.getAlta();
		LocalDate fin = LocalDate.of(inicio.getYear(),inicio.getMonthValue(),inicio.getDayOfMonth()).plusDays(datosTipo.getDuracion());
		Publicacion pub = new Publicacion(id, datosTipo.getCosto(), inicio, fin, ofL);
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
	
	public void altaPaqueteTipoPublicacion(String nombre, String descripcion, int validez, int descuento) throws PaqueteExisteException {
		ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaParseada = LocalDate.parse(fecha, formatter);
		Paquete paquete = new Paquete(nombre, descripcion, validez, descuento, 0, fechaParseada);
		manejadorP.addPaqueteTipoPublicacion(paquete);
	};
	
	
	public  void agregarTipoPublicacion(String nombrePaquete ,Integer cant, String nombreTipoPublicacion) {
		
	}

	public List<DTPaquete> listarPaquetes() {
		ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
		return manejadorP.obtenerListaPaquetes();
	}
}
