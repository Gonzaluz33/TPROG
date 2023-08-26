package logica;

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
	
	public void altaTipoPublicacionOL(String nombre, String descripcion, String exposicion, Integer duracion, Integer costoPublic, LocalDateTime fechaAlta ) 
			throws TipoPublicExisteException {
		ManejadorPublicaciones manejadorP = ManejadorPublicaciones.getInstance();
		
		TipoPublicacion.EnumExposicion exposicionEnum = TipoPublicacion.EnumExposicion.valueOf(exposicion); // Convertir la cadena a EnumExposicion
		
		TipoPublicacion tipoP = new TipoPublicacion( nombre, descripcion, duracion, costoPublic, fechaAlta, exposicionEnum);
		manejadorP.altaTipoPublicacionOL(tipoP);
	}
	
	
}
