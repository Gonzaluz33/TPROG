package logica;

import java.util.List;

import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;
import excepciones.NombreExisteException;
import utils.DTTipoPublicacion;

public interface IControladorOfertas {
	public abstract void altaKeyword(String nombre) throws KeywordExisteException;
	public abstract List<String> obtenerKeywords();
	public void altaOferta(String nombre, String desc, String remuner, String horario, List<String> keywords, String ciudad, String depa, String tipo, String empresa) throws NombreExisteException, KeywordExisteException, NicknameNoExisteException;
}
