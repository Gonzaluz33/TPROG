package logica;

import java.util.List;

import utils.DTTipoPublicacion;

public interface IControladorPublicaciones {

	 public List<DTTipoPublicacion> obtenerTipos();
	 public Publicacion addPublicacion(OfertaLaboral ofL, DTTipoPublicacion tipo);
}
