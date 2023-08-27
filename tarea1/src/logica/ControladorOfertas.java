package logica;

import java.util.Date;
import java.util.List;

import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;
import excepciones.NombreExisteException;
import utils.DTTipoPublicacion;

public class ControladorOfertas implements IControladorOfertas{
	
	private static ControladorOfertas instancia; 
	
	public static ControladorOfertas getInstance() {
        if (instancia == null) {
            instancia = new ControladorOfertas();
        }
        return instancia;
    }
	
	public void altaKeyword(String nombre) throws KeywordExisteException {
		Keyword key = new Keyword(nombre);
		ManejadorOfertaLaboral mOL = ManejadorOfertaLaboral.getInstance();
		mOL.addKeyword(key);
	}
	
	public void altaOferta(String nombre, String desc, String remuner, String horario, List<String> keywords, String ciudad, String depa, String tipo, String empresa)
			throws NombreExisteException, KeywordExisteException, NicknameNoExisteException {
		Date fecha = new Date();
		ControladorUsuarios contU = ControladorUsuarios.getInstance();
		Empresa usuarioEmpresa = (Empresa) contU.obtenerUsuario(empresa);
		ManejadorOfertaLaboral mOL = ManejadorOfertaLaboral.getInstance();
		OfertaLaboral ofL = new OfertaLaboral(nombre, desc, ciudad, depa, horario, fecha, remuner, usuarioEmpresa);
		mOL.addOferta(ofL, keywords);
		usuarioEmpresa.asociarOferta(ofL.toDataType());
		// despues de crear la oferta, creo la publicacion con el tipo
		ControladorPublicaciones contPub = ControladorPublicaciones.getInstance();
		Publicacion pub = contPub.addPublicacion(ofL, tipo);
		ofL.addPublicacion(pub);
	}

	public List<String> obtenerKeywords() {
		ManejadorOfertaLaboral mOL = ManejadorOfertaLaboral.getInstance();
		return mOL.obtenerKeywords();
	}
	
}
