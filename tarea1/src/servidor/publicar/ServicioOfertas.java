package servidor.publicar;

import logica.*;
import servidor.types.DTOferta;
import servidor.types.DTPublicacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import excepciones.KeywordExisteException;
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
    
    @WebMethod
    public DTPublicacion[] obtenerPublicaciones() {
        Fabrica factory = Fabrica.getInstance();
        IControladorPublicaciones ICP = factory.getIControladorPublicaciones();
        List<DTPublicacion> todasLasPublicaciones = ICP.obtenerPublicaciones();
        DTPublicacion[] publicaciones = todasLasPublicaciones.toArray(new DTPublicacion[0]);
        return publicaciones;
    }
    
    
    /*@WebMethod
    public DTPublicacion[] obtenerPublicacionesPorKeywords(ArrayList<String> keywords) {
        // Instancia del manejador
        ManejadorPublicaciones manejadorPublicaciones = ManejadorPublicaciones.getInstance();
        ArrayList<DTPublicacion> publicaciones = (ArrayList<DTPublicacion>) manejadorPublicaciones.obtenerPublicaciones();

        // Convertir las keywords a lowercase para la comparación
        ArrayList<String> keywordsLowerCase = keywords.stream()
            .map(String::toLowerCase)
            .collect(Collectors.toCollection(ArrayList::new));

        // Filtrar las publicaciones por keywords
        ArrayList<DTPublicacion> listaPublicacionesFiltradas = publicaciones.stream()
            .filter(dtPublicacion -> {
                DTOferta oferta = dtPublicacion.getDtOferta();
                ArrayList<String> ofertaKeywords = new ArrayList<>(oferta.getKeywords());
                ArrayList<String> ofertaKeywordsLowerCase = ofertaKeywords.stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toCollection(ArrayList::new));

                return !Collections.disjoint(keywordsLowerCase, ofertaKeywordsLowerCase);
            })
            .collect(Collectors.toCollection(ArrayList::new));

        // Convertir la lista filtrada a un array
        DTPublicacion[] publicacionesFiltradas = listaPublicacionesFiltradas.toArray(new DTPublicacion[0]);

        return publicacionesFiltradas;
    }*/
}

