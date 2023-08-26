package logica;
import java.time.LocalDateTime;

import excepciones.TipoPublicExisteException;

public interface IControladorPublicaciones {

	public abstract void altaTipoPublicacionOL (String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDateTime fechaAlta ) throws TipoPublicExisteException ;
}
