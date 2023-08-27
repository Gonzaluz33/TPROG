package logica;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import utils.DTTipoPublicacion;
import java.time.LocalDateTime;
import excepciones.TipoPublicExisteException;

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
	
	public void addPaquete(String nombre, String descripcion, int validez, int descuento, int costoAsociado) {
		Paquete paq = new Paquete(nombre, descripcion, validez, descuento, costoAsociado);
		ManejadorPublicaciones manPub = ManejadorPublicaciones.getInstance();
		manPub.addPaquete(paq);
	}
	
	public Publicacion addPublicacion(OfertaLaboral ofL, String tipo) {
		ManejadorPublicaciones manPub = ManejadorPublicaciones.getInstance();
		int id = manPub.getLastPubId();
		TipoPublicacion datosTipo = manPub.getTipo(tipo);
		LocalDate inicio = datosTipo.getAlta();
		LocalDate fin = LocalDate.of(inicio.getYear(),inicio.getMonthValue(),inicio.getDayOfMonth() + datosTipo.getDuracion());
		ContadorPublicaciones contador;
		if (datosTipo.getContador(ofL.getNombre()) != null) {
			contador = datosTipo.getContador(ofL.getNombre());
		} else {
			contador = new ContadorPublicaciones(datosTipo);
		}
		Publicacion pub = new Publicacion(id, datosTipo.getCosto(), inicio, fin, ofL, contador);
		contador.addPublicacion(pub);
		manPub.addPublicacion(pub);
		return pub;
	}
	
	public void altaTipoPublicacionOL(String nombre, String descripcion, String exposicion, Integer duracion, Integer costoPublic, LocalDate fechaAlta ) 
			throws TipoPublicExisteException {
		ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
		
		TipoPublicacion.EnumExposicion exposicionEnum = TipoPublicacion.EnumExposicion.valueOf(exposicion); // Convertir la cadena a EnumExposicion
		
		TipoPublicacion tipoP = new TipoPublicacion( nombre, descripcion, duracion, costoPublic, fechaAlta, exposicionEnum);
		manejadorP.altaTipoPublicacionOL(tipoP);
	}

	@Override
	public Publicacion addPublicacion(OfertaLaboral ofL, DTTipoPublicacion tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
