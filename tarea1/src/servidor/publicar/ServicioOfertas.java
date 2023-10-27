package servidor.publicar;

import logica.*;
import servidor.types.DTOferta;
import servidor.types.DTPublicacion;
import servidor.types.DTTipoPublicacion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import excepciones.KeywordExisteException;
import excepciones.NicknameNoExisteException;
import excepciones.NombreExisteException;
import excepciones.OfertaNoExisteException;
import excepciones.UsuarioNoEsEmpresaException;
import excepciones.UsuarioNoEsPostulanteException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ServicioOfertas {

    private Endpoint endpoint = null;
    //Constructor
    public ServicioOfertas(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9128/servicioofertas", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    
    //CONSULTAS
    @WebMethod
    public Object[] obtenerKeywords() throws KeywordExisteException{
        Fabrica factory = Fabrica.getInstance();
        IControladorOfertas ICO = factory.getIControladorOfertas();
        Object[] keywords = ICO.obtenerKeywords().toArray();
        return keywords;
    }
    
    
    @WebMethod
    public DTPublicacion[] obtenerPublicacionesPorBusqueda(String busqueda) {
        Fabrica factory = Fabrica.getInstance();
        IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
        List<DTPublicacion> todasLasPublicaciones = ICP.obtenerPublicaciones();
        List<DTPublicacion> listaPublicaciones = todasLasPublicaciones.stream()
            .filter(dtPublicacion -> {
                DTOferta oferta = dtPublicacion.getDtOferta();
                return oferta.getNombre().toLowerCase().contains(busqueda.toLowerCase())
                    || oferta.getDescripcion().toLowerCase().contains(busqueda.toLowerCase())
                    || oferta.getCiudad().toLowerCase().contains(busqueda.toLowerCase())
                    || oferta.getDepartamento().toLowerCase().contains(busqueda.toLowerCase());
            })
            .collect(Collectors.toList());
        DTPublicacion[] publicaciones = listaPublicaciones.toArray(new DTPublicacion[0]);
        return publicaciones;
    }
    /*
    @WebMethod
    public DTPublicacion[] obtenerPublicacionesPorKeywords(List<String> keywords) {
    	return null;
    }*/
    
    
    @WebMethod
    public DTPublicacion[] obtenerPublicaciones() {
        Fabrica factory = Fabrica.getInstance();
        IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
        List<DTPublicacion> todasLasPublicaciones = ICP.obtenerPublicaciones();
        DTPublicacion[] publicaciones = todasLasPublicaciones.toArray(new DTPublicacion[0]);
        return publicaciones;
    }
    
    @WebMethod
    public DTTipoPublicacion[] obtenerTipos() {
        Fabrica factory = Fabrica.getInstance();
        IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
        List<DTTipoPublicacion> todosLosTipos = ICP.obtenerTipos();
        DTTipoPublicacion[] tipos = todosLosTipos.toArray(new DTTipoPublicacion[0]);
        return tipos;
    }
    
    @WebMethod
    public DTOferta obtenerDatosOferta(String nombreOferta) throws OfertaNoExisteException {
    	Fabrica factory = Fabrica.getInstance();
    	IControladorOfertas ICO = factory.getIControladorOfertas();
		return ICO.obtenerDatosOferta(nombreOferta);
    }
    
    @WebMethod
    public DTTipoPublicacion obtenerDatosTipoPublicacion(String nombre) {
    	Fabrica factory = Fabrica.getInstance();
        IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
		return ICP.obtenerDatosTipoPublicacion(nombre);
    	
    }
    
    @WebMethod
    public Publicacion obtenerPublicacionAsociadaAOferta(String nombreOferta) {
    	Fabrica factory = Fabrica.getInstance();
    	IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
    	return ICP.obtenerPublicacionAsociadaAOferta(nombreOferta);
    }
    
    @WebMethod
    public DTOferta[] obtenerOfertasVigentesDeEmpresa(String nicknameEmpresa) throws NicknameNoExisteException, UsuarioNoEsEmpresaException{
    	Fabrica factory = Fabrica.getInstance();
    	IControladorOfertas ICO = factory.getIControladorOfertas();
    	Set<DTOferta> todasOfertasVigentes = ICO.obtenerOfertasVigentesDeEmpresa(nicknameEmpresa);
    	return todasOfertasVigentes.toArray(new DTOferta[0]);
    }
    
    @WebMethod
    public DTPublicacion[] obtenerPublicacionesDeEmpresa(String nicknameEmpresa) {
    	Fabrica factory = Fabrica.getInstance();
    	IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
    	List<DTPublicacion> todasPublicacionesEmpresa = ICP.obtenerPublicacionesDeEmpresa(nicknameEmpresa);
    	return todasPublicacionesEmpresa.toArray(new DTPublicacion[0]);
    }
    
    @WebMethod
    public boolean verificarPertenenciaOferta(String nombreOferta, String nickname) throws OfertaNoExisteException {
    	Fabrica factory = Fabrica.getInstance();
    	IControladorOfertas ICO = factory.getIControladorOfertas();
    	return ICO.verificarPertenenciaOferta(nombreOferta, nickname);
    }
    
    @WebMethod
    public void confirmarOfertaLaboral(String nombreOferta) throws OfertaNoExisteException {
    	Fabrica factory = Fabrica.getInstance();
    	IControladorOfertas ICO = factory.getIControladorOfertas();
    	ICO.confirmarOfertaLaboral(nombreOferta);
    }
    
    //POSTULACIONES
    @WebMethod
    public void postularAOferta(String nombreOfertaLaboral, String nicknamePostulante, String cvReducido, String motivacion, LocalDateTime fechaPostulacion) throws NicknameNoExisteException, UsuarioNoEsPostulanteException, OfertaNoExisteException {
    	Fabrica factory = Fabrica.getInstance();
    	IControladorOfertas ICO = factory.getIControladorOfertas();
    	ICO.postularAOferta(nombreOfertaLaboral, nicknamePostulante, cvReducido, motivacion, fechaPostulacion);
    }

    //ALTAS
    @WebMethod
    public void altaOferta(String nombre,String desc,String remuner,String horario,List<String> keywords,String ciudad,
    String depa,String tipo,String empresa) throws NombreExisteException, KeywordExisteException, NicknameNoExisteException{
    	 Fabrica factory = Fabrica.getInstance();
    	 IControladorOfertas ICO = factory.getIControladorOfertas();
    	 ICO.altaOferta(nombre, desc, remuner, horario, keywords, ciudad, depa, tipo, empresa);
    }

}

