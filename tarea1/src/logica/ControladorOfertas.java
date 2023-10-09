package logica;


import utils.DTEmpresa;
import utils.DTOferta;
import utils.EnumEstadoOferta;
import excepciones.NombreExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsEmpresaException;
import excepciones.UsuarioNoEsPostulanteException;
import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.time.LocalDateTime;



public class ControladorOfertas implements IControladorOfertas{
	
	private static ControladorOfertas instancia; 
	
	public static ControladorOfertas getInstance() {
        if (instancia == null) {
            instancia = new ControladorOfertas();
        }
        return instancia;
    }
	
	public void confirmarOfertaLaboral(String nombreOferta) throws OfertaNoExisteException {
	    ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
	    manejadorOL.confirmarOfertaLaboral(nombreOferta);
	}
	

	public DTOferta obtenerDatosOferta(String nombreOferta) throws OfertaNoExisteException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		return manejadorOL.obtenerOfertaLaboral(nombreOferta);
	}
	
	public OfertaLaboral getOfertaLaboral(String nombreOferta) throws OfertaNoExisteException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		return manejadorOL.getOfertaLaboral(nombreOferta);
	}

	public void altaKeyword(String nombre) throws KeywordExisteException {
		Keyword key = new Keyword(nombre);
		ManejadorOfertaLaboral mOL = ManejadorOfertaLaboral.getInstance();
		mOL.addKeyword(key);
	}
	
	public boolean verificarPertenenciaOferta(String nombreOferta, String nickname) throws OfertaNoExisteException {
        ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
        OfertaLaboral oferta = manejadorOL.getOfertaLaboral(nombreOferta); 
        if (oferta != null) {
            String nicknameEmpresa = oferta.getEmpresa().getNickname(); 
            return nicknameEmpresa.equals(nickname);
        } else {
            throw new OfertaNoExisteException("No existe una oferta laboral con el nombre proporcionado: " + nombreOferta);
        }
    }
		
	public void altaOferta(String nombre, String desc, String remuner, String horario, List<String> keywords, String ciudad, String depa, String tipo, String empresa)
			throws NombreExisteException, KeywordExisteException, NicknameNoExisteException {
		LocalDateTime fecha = LocalDateTime.now();
		ControladorUsuarios contU = ControladorUsuarios.getInstance();
		Empresa usuarioEmpresa = (Empresa) contU.obtenerUsuario(empresa);
		ManejadorOfertaLaboral mOL = ManejadorOfertaLaboral.getInstance();
		OfertaLaboral ofL = new OfertaLaboral(nombre, desc, ciudad, depa, horario, EnumEstadoOferta.INGRESADA ,fecha, remuner, usuarioEmpresa);
		mOL.addOferta(ofL, keywords);
		// despues de crear la oferta, creo la publicacion con el tipo
		ControladorPublicaciones contPub = ControladorPublicaciones.getInstance();
		Publicacion pub = contPub.addPublicacion(ofL, tipo);
		usuarioEmpresa.asociarOferta(ofL.toDataType());
		ofL.addPublicacion(pub);
	}

	public List<String> obtenerKeywords() {
		ManejadorOfertaLaboral mOL = ManejadorOfertaLaboral.getInstance();
		return mOL.obtenerKeywords();
	}
	
	public void postularAOferta(String nombreOfertaLaboral, String nicknamePostulante, String cvReducido, String motivacion, LocalDateTime fechaPostulacion) throws NicknameNoExisteException, UsuarioNoEsPostulanteException, OfertaNoExisteException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		manejadorOL.postularAOferta(nombreOfertaLaboral, nicknamePostulante, cvReducido, motivacion, fechaPostulacion);
	}
	
	public void actualizarEstadoOfertaLaboral(String nombreOfertaLaboral, EnumEstadoOferta estado) throws OfertaNoExisteException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		OfertaLaboral o = manejadorOL.getOfertaLaboral(nombreOfertaLaboral);
		o.setEstado(estado);
	}
	public List<DTEmpresa> obtenerEmpresas(){
		IControladorUsuario controlU = ControladorUsuarios.getInstance();
		List<DTEmpresa> empresas = controlU.listarEmpresas();
		return empresas;
	}

	public Set<DTOferta> obtenerOfertasVigentesDeEmpresa(String nicknameEmpresa) throws NicknameNoExisteException, UsuarioNoEsEmpresaException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		return manejadorOL.obtenerOfertasVigentesDeEmpresa(nicknameEmpresa);
	}
	
	public TreeSet<DTOferta> obtenerOfertasIngresadasDeEmpresa(String nicknameEmpresa)throws NicknameNoExisteException, UsuarioNoEsEmpresaException {
		ManejadorOfertaLaboral manejadorOL = ManejadorOfertaLaboral.getInstance();
		return manejadorOL.obtenerOfertasIngresadasDeEmpresa(nicknameEmpresa);
	}
	

}
