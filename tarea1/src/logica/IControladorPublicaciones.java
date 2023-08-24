package logica;
import java.util.Date;

import excepciones.TipoPublicExisteException;

public interface IControladorPublicaciones {

	public abstract void altaTipoPublicacionOL (String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublicacion, Date fechaAlta ) throws TipoPublicExisteException ;
}
