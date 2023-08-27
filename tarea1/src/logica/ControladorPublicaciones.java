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
	
	public Publicacion addPublicacion(OfertaLaboral ofL, String tipo) {
		ManejadorPublicaciones manPub = ManejadorPublicaciones.getInstance();
		Integer id = manPub.getLastPubId();
		TipoPublicacion datosTipo = manPub.getTipo(tipo);
		LocalDate inicio = datosTipo.getAlta();
		LocalDate fin = LocalDate.of(inicio.getYear(),inicio.getMonthValue(),inicio.getDayOfMonth() + datosTipo.getDuracion());
		Publicacion pub = new Publicacion(id, datosTipo.getCosto(), inicio, fin, ofL);
		manPub.addPublicacion(pub);
		//find tipo, agregar asociacion si no existe, y pumquepam
		return pub;
	}
	public void altaTipoPublicacionOL(String nombre, String descripcion, String exposicion, Integer duracion, Integer costoPublic, LocalDate fechaAlta ) 
			throws TipoPublicExisteException {
		ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
		
		TipoPublicacion.EnumExposicion exposicionEnum = TipoPublicacion.EnumExposicion.valueOf(exposicion); // Convertir la cadena a EnumExposicion
		
		TipoPublicacion tipoP = new TipoPublicacion( nombre, descripcion, duracion, costoPublic, fechaAlta, exposicionEnum);
		System.out.println(tipoP);
		manejadorP.altaTipoPublicacionOL(tipoP);
	}

	@Override
	public Publicacion addPublicacion(OfertaLaboral ofL, DTTipoPublicacion tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
