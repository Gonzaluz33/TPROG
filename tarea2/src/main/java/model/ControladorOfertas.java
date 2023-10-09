package model;

import utils.DTEmpresa;
import utils.DTOferta;
import utils.DTPostulacion;
import utils.EnumEstadoOferta;
import excepciones.NombreExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsEmpresaException;
import excepciones.UsuarioNoEsPostulanteException;
import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;

public class ControladorOfertas implements IControladorOfertas {

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

	public void altaOferta(String nombre, String desc, String remuner, String horario, List<String> keywords,
			String ciudad, String depa, String tipo, String empresa)
			throws NombreExisteException, KeywordExisteException, NicknameNoExisteException {
		LocalDateTime fecha = LocalDateTime.now();
		ControladorUsuarios contU = ControladorUsuarios.getInstance();
		Empresa usuarioEmpresa = (Empresa) contU.obtenerUsuario(empresa);
		ManejadorOfertaLaboral mOL = ManejadorOfertaLaboral.getInstance();
		OfertaLaboral ofL = new OfertaLaboral(nombre, desc, ciudad, depa, horario, fecha,EnumEstadoOferta.INGRESADA, remuner, usuarioEmpresa);
		mOL.addOferta(ofL, keywords);
		// despues de crear la oferta, creo la publicacion con el tipo
		ControladorPublicaciones contPub = ControladorPublicaciones.getInstance();
		Publicacion pub = contPub.addPublicacion(ofL, tipo);
		usuarioEmpresa.asociarOferta(ofL.toDataType());
		ofL.addPublicacion(pub);
	}
	
	public void altaOfertaWeb(String nombre, String descripcion, String renumeracion, String horario, String ciudad, String departanemto, String tipoPublicacion, String formaPago, String paqueteSeleccionado,EnumEstadoOferta estado, String[] Keywords,String urlImagen, String empresaActual ) throws NicknameNoExisteException, NombreExisteException, KeywordExisteException{
		LocalDateTime fecha = LocalDateTime.now();
		ManejadorOfertaLaboral mOL = ManejadorOfertaLaboral.getInstance();
		ControladorUsuarios contU = ControladorUsuarios.getInstance();
		Empresa usuarioEmpresa = (Empresa) contU.obtenerUsuario(empresaActual);
		OfertaLaboral ofl;
	    if (urlImagen != null && !urlImagen.trim().isEmpty() && paqueteSeleccionado != null && !paqueteSeleccionado.trim().isEmpty()) {
	        // Constructor con URL y paquete
	        ofl = new OfertaLaboral(nombre, descripcion, ciudad, departanemto, horario, fecha,estado , renumeracion, usuarioEmpresa, formaPago, urlImagen, paqueteSeleccionado);
	    } else if (urlImagen != null && !urlImagen.trim().isEmpty()) {
	        // Constructor solo con URL
	        ofl = new OfertaLaboral(nombre, descripcion, ciudad, departanemto, horario, fecha,estado , renumeracion, urlImagen, usuarioEmpresa, formaPago);
	    } else if (paqueteSeleccionado != null && !paqueteSeleccionado.trim().isEmpty()) {
	        // Constructor solo con paquete
	        ofl = new OfertaLaboral(nombre, descripcion, ciudad, departanemto, horario, fecha,estado , renumeracion, usuarioEmpresa, formaPago, paqueteSeleccionado);
	    } else {
	        // Constructor básico con formaPago
	        ofl = new OfertaLaboral(nombre, descripcion, ciudad, departanemto, horario, fecha,estado , renumeracion, usuarioEmpresa, formaPago);
	    }
	    List<String> keywordsList = new ArrayList<>(Arrays.asList(Keywords));
	    mOL.addOferta(ofl, keywordsList);
	    ControladorPublicaciones contPub = ControladorPublicaciones.getInstance();
		Publicacion pub = contPub.addPublicacion(ofl, tipoPublicacion);
		usuarioEmpresa.asociarOferta(ofl.toDataType());
		ofl.addPublicacion(pub);
	}


	public List<String> obtenerKeywords() {
		ManejadorOfertaLaboral mOL = ManejadorOfertaLaboral.getInstance();
		return mOL.obtenerKeywords();
	}

	public void postularAOferta(String nombreOfertaLaboral, String nicknamePostulante, String cvReducido,
			String motivacion, LocalDateTime fechaPostulacion)
			throws NicknameNoExisteException, UsuarioNoEsPostulanteException, OfertaNoExisteException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		manejadorOL.postularAOferta(nombreOfertaLaboral, nicknamePostulante, cvReducido, motivacion, fechaPostulacion);
	}

	public List<DTEmpresa> obtenerEmpresas() {
		IControladorUsuario controlU = ControladorUsuarios.getInstance();
		List<DTEmpresa> empresas = controlU.listarEmpresas();
		return empresas;
	}

	public List<DTOferta> obtenerOfertasLaborales() {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		return manejadorOL.obtenerOfertasLaborales();
	}

	public Set<DTOferta> obtenerOfertasVigentesDeEmpresa(String nicknameEmpresa)
			throws NicknameNoExisteException, UsuarioNoEsEmpresaException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		return manejadorOL.obtenerOfertasVigentesDeEmpresa(nicknameEmpresa);
	}
	
	public List<DTPostulacion> obtenerPostulacionesPorPostulante(String nicknamePostulante)
            throws NicknameNoExisteException, UsuarioNoEsPostulanteException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		return manejadorOL.obtenerPostulacionesPorPostulante(nicknamePostulante);
		
	}
	
	public DTPostulacion estaPostuladoAOfertaLaboral(String nicknameUsuario, String nombreOfertaLaboral)
            throws OfertaNoExisteException, NicknameNoExisteException, UsuarioNoEsPostulanteException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		return manejadorOL.estaPostuladoAOfertaLaboral(nicknameUsuario, nombreOfertaLaboral);
	};
	
	
	
	

}
