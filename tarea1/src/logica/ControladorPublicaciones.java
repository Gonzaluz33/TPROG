package logica;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import utils.DTTipoPublicacion;

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
	
	public Publicacion addPublicacion(OfertaLaboral ofL, DTTipoPublicacion tipo) {
//		Integer id, Integer costo, Date alta, Date fin
		ManejadorPublicaciones manPub = ManejadorPublicaciones.getInstance();
		Integer id = manPub.getLastPubId();
		LocalDate inicio = tipo.getAlta();
		LocalDate fin = LocalDate.of(inicio.getYear(),inicio.getMonthValue(),inicio.getDayOfMonth() + tipo.getDuracion());
		Publicacion pub = new Publicacion(id, tipo.getCosto(), inicio, fin, ofL);
		manPub.addPublicacion(pub);
		//find tipo, agregar asociacion si no existe, y pumquepam
		return pub;
	}
}
