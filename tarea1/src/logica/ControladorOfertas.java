package logica;

import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsPostulanteException;
import utils.DTOferta;

import java.time.LocalDateTime;

import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;

public class ControladorOfertas implements IControladorOfertas{
	
	private static ControladorOfertas instancia; 
	
	public static ControladorOfertas getInstance() {
        if (instancia == null) {
            instancia = new ControladorOfertas();
        }
        return instancia;
    }

	public DTOferta obtenerDatosOferta(String nombreOferta) throws OfertaNoExisteException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		return manejadorOL.obtenerOfertaLaboral(nombreOferta);
	}

	public void altaKeyword(String nombre) throws KeywordExisteException {
		Keyword key = new Keyword(nombre);
		ManejadorOfertaLaboral mOL = ManejadorOfertaLaboral.getInstance();
		mOL.addKeyword(key);
	}
	
	public void postularAOferta(String nombreOfertaLaboral, String nicknamePostulante, String cvReducido, String motivacion, LocalDateTime fechaPostulacion) throws NicknameNoExisteException, UsuarioNoEsPostulanteException, OfertaNoExisteException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		manejadorOL.postularAOferta(nombreOfertaLaboral, nicknamePostulante, cvReducido, motivacion, fechaPostulacion);
	}

}
