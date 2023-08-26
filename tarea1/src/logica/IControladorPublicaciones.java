package logica;
import java.time.LocalDateTime;

import excepciones.TipoPublicExisteException;

import java.util.List;

import utils.DTTipoPublicacion;

public interface IControladorPublicaciones {

	 public List<DTTipoPublicacion> obtenerTipos();
	 public Publicacion addPublicacion(OfertaLaboral ofL, DTTipoPublicacion tipo);
	public abstract void altaTipoPublicacionOL (String nombre, String descripcion, String exposicion, Integer duracion, Integer CostoPublic, LocalDateTime fechaAlta ) throws TipoPublicExisteException ;
}
