package logica;

import java.util.List;

import excepciones.KeywordExisteException;
import excepciones.NombreExisteException;
import utils.DTTipoPublicacion;

public interface IControladorOfertas {
	public abstract void altaKeyword(String nombre) throws KeywordExisteException;
	public void altaOferta(String nombre, String desc, String remuner, String horario, List<String> keywords, String ciudad, String depa, DTTipoPublicacion tipo) throws NombreExisteException, KeywordExisteException;
}
