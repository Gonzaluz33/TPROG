
package servidor.publicar;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;
import net.java.dev.jaxb.array.StringArray;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "ServicioOfertas", targetNamespace = "http://publicar.servidor/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    net.java.dev.jaxb.array.ObjectFactory.class,
    servidor.publicar.ObjectFactory.class
})
public interface ServicioOfertas {


    /**
     * 
     * @return
     *     returns servidor.publicar.DtPublicacionArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/obtenerPublicacionesRequest", output = "http://publicar.servidor/ServicioOfertas/obtenerPublicacionesResponse")
    public DtPublicacionArray obtenerPublicaciones();

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtPublicacionArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/obtenerPublicacionesPorKeywordsRequest", output = "http://publicar.servidor/ServicioOfertas/obtenerPublicacionesPorKeywordsResponse")
    public DtPublicacionArray obtenerPublicacionesPorKeywords(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtOferta
     * @throws OfertaNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/obtenerDatosOfertaRequest", output = "http://publicar.servidor/ServicioOfertas/obtenerDatosOfertaResponse", fault = {
        @FaultAction(className = OfertaNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/obtenerDatosOferta/Fault/OfertaNoExisteException")
    })
    public DtOferta obtenerDatosOferta(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws OfertaNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtTipoPublicacion
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/obtenerDatosTipoPublicacionRequest", output = "http://publicar.servidor/ServicioOfertas/obtenerDatosTipoPublicacionResponse")
    public DtTipoPublicacion obtenerDatosTipoPublicacion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtPublicacion
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/obtenerPublicacionAsociadaAOfertaRequest", output = "http://publicar.servidor/ServicioOfertas/obtenerPublicacionAsociadaAOfertaResponse")
    public DtPublicacion obtenerPublicacionAsociadaAOferta(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtOfertaArray
     * @throws NicknameNoExisteException_Exception
     * @throws UsuarioNoEsEmpresaException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/obtenerOfertasVigentesDeEmpresaRequest", output = "http://publicar.servidor/ServicioOfertas/obtenerOfertasVigentesDeEmpresaResponse", fault = {
        @FaultAction(className = NicknameNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/obtenerOfertasVigentesDeEmpresa/Fault/NicknameNoExisteException"),
        @FaultAction(className = UsuarioNoEsEmpresaException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/obtenerOfertasVigentesDeEmpresa/Fault/UsuarioNoEsEmpresaException")
    })
    public DtOfertaArray obtenerOfertasVigentesDeEmpresa(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws NicknameNoExisteException_Exception, UsuarioNoEsEmpresaException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtPublicacionArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/obtenerPublicacionesDeEmpresaRequest", output = "http://publicar.servidor/ServicioOfertas/obtenerPublicacionesDeEmpresaResponse")
    public DtPublicacionArray obtenerPublicacionesDeEmpresa(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns boolean
     * @throws OfertaNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/verificarPertenenciaOfertaRequest", output = "http://publicar.servidor/ServicioOfertas/verificarPertenenciaOfertaResponse", fault = {
        @FaultAction(className = OfertaNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/verificarPertenenciaOferta/Fault/OfertaNoExisteException")
    })
    public boolean verificarPertenenciaOferta(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws OfertaNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws OfertaNoExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioOfertas/confirmarOfertaLaboralRequest", output = "http://publicar.servidor/ServicioOfertas/confirmarOfertaLaboralResponse", fault = {
        @FaultAction(className = OfertaNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/confirmarOfertaLaboral/Fault/OfertaNoExisteException")
    })
    public void confirmarOfertaLaboral(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws OfertaNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtPostulacionArray
     * @throws NicknameNoExisteException_Exception
     * @throws UsuarioNoEsPostulanteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/obtenerPostulacionesPorPostulanteRequest", output = "http://publicar.servidor/ServicioOfertas/obtenerPostulacionesPorPostulanteResponse", fault = {
        @FaultAction(className = NicknameNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/obtenerPostulacionesPorPostulante/Fault/NicknameNoExisteException"),
        @FaultAction(className = UsuarioNoEsPostulanteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/obtenerPostulacionesPorPostulante/Fault/UsuarioNoEsPostulanteException")
    })
    public DtPostulacionArray obtenerPostulacionesPorPostulante(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws NicknameNoExisteException_Exception, UsuarioNoEsPostulanteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns servidor.publicar.DtPostulacion
     * @throws NicknameNoExisteException_Exception
     * @throws OfertaNoExisteException_Exception
     * @throws UsuarioNoEsPostulanteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/estaPostuladoAOfertaLaboralRequest", output = "http://publicar.servidor/ServicioOfertas/estaPostuladoAOfertaLaboralResponse", fault = {
        @FaultAction(className = OfertaNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/estaPostuladoAOfertaLaboral/Fault/OfertaNoExisteException"),
        @FaultAction(className = NicknameNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/estaPostuladoAOfertaLaboral/Fault/NicknameNoExisteException"),
        @FaultAction(className = UsuarioNoEsPostulanteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/estaPostuladoAOfertaLaboral/Fault/UsuarioNoEsPostulanteException")
    })
    public DtPostulacion estaPostuladoAOfertaLaboral(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws NicknameNoExisteException_Exception, OfertaNoExisteException_Exception, UsuarioNoEsPostulanteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtPublicacionArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/obtenerPublicacionesPorBusquedaRequest", output = "http://publicar.servidor/ServicioOfertas/obtenerPublicacionesPorBusquedaResponse")
    public DtPublicacionArray obtenerPublicacionesPorBusqueda(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns boolean
     * @throws NicknameNoExisteException_Exception
     * @throws OfertaNoExisteException_Exception
     * @throws UsuarioNoEsPostulanteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/estaPostuladoAOfertaBooleanRequest", output = "http://publicar.servidor/ServicioOfertas/estaPostuladoAOfertaBooleanResponse", fault = {
        @FaultAction(className = OfertaNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/estaPostuladoAOfertaBoolean/Fault/OfertaNoExisteException"),
        @FaultAction(className = NicknameNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/estaPostuladoAOfertaBoolean/Fault/NicknameNoExisteException"),
        @FaultAction(className = UsuarioNoEsPostulanteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/estaPostuladoAOfertaBoolean/Fault/UsuarioNoEsPostulanteException")
    })
    public boolean estaPostuladoAOfertaBoolean(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws NicknameNoExisteException_Exception, OfertaNoExisteException_Exception, UsuarioNoEsPostulanteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws OfertaNoExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioOfertas/finalizarOfertaRequest", output = "http://publicar.servidor/ServicioOfertas/finalizarOfertaResponse", fault = {
        @FaultAction(className = OfertaNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/finalizarOferta/Fault/OfertaNoExisteException")
    })
    public void finalizarOferta(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws OfertaNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg10
     * @param arg11
     * @param arg12
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @throws KeywordExisteException_Exception
     * @throws NicknameNoExisteException_Exception
     * @throws NombreExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioOfertas/altaOfertaWebRequest", output = "http://publicar.servidor/ServicioOfertas/altaOfertaWebResponse", fault = {
        @FaultAction(className = NicknameNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/altaOfertaWeb/Fault/NicknameNoExisteException"),
        @FaultAction(className = NombreExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/altaOfertaWeb/Fault/NombreExisteException"),
        @FaultAction(className = KeywordExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/altaOfertaWeb/Fault/KeywordExisteException")
    })
    public void altaOfertaWeb(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8,
        @WebParam(name = "arg9", partName = "arg9")
        EnumEstadoOferta arg9,
        @WebParam(name = "arg10", partName = "arg10")
        String arg10,
        @WebParam(name = "arg11", partName = "arg11")
        String arg11,
        @WebParam(name = "arg12", partName = "arg12")
        String arg12)
        throws KeywordExisteException_Exception, NicknameNoExisteException_Exception, NombreExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @throws NicknameNoExisteException_Exception
     * @throws OfertaNoExisteException_Exception
     * @throws UsuarioNoEsPostulanteException_Exception
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioOfertas/postularAOfertaRequest", output = "http://publicar.servidor/ServicioOfertas/postularAOfertaResponse", fault = {
        @FaultAction(className = NicknameNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/postularAOferta/Fault/NicknameNoExisteException"),
        @FaultAction(className = UsuarioNoEsPostulanteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/postularAOferta/Fault/UsuarioNoEsPostulanteException"),
        @FaultAction(className = OfertaNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/postularAOferta/Fault/OfertaNoExisteException")
    })
    public void postularAOferta(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5)
        throws NicknameNoExisteException_Exception, OfertaNoExisteException_Exception, UsuarioNoEsPostulanteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @throws NicknameNoExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioOfertas/agregarEliminarFavoritoRequest", output = "http://publicar.servidor/ServicioOfertas/agregarEliminarFavoritoResponse", fault = {
        @FaultAction(className = NicknameNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/agregarEliminarFavorito/Fault/NicknameNoExisteException")
    })
    public void agregarEliminarFavorito(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws NicknameNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @throws OfertaNoExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioOfertas/seleccionarPostulacionesRequest", output = "http://publicar.servidor/ServicioOfertas/seleccionarPostulacionesResponse", fault = {
        @FaultAction(className = OfertaNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/seleccionarPostulaciones/Fault/OfertaNoExisteException")
    })
    public void seleccionarPostulaciones(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws OfertaNoExisteException_Exception
    ;

    /**
     * 
     * @return
     *     returns servidor.publicar.DtTipoPublicacionArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/obtenerTiposRequest", output = "http://publicar.servidor/ServicioOfertas/obtenerTiposResponse")
    public DtTipoPublicacionArray obtenerTipos();

    /**
     * 
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     * @throws KeywordExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioOfertas/obtenerKeywordsRequest", output = "http://publicar.servidor/ServicioOfertas/obtenerKeywordsResponse", fault = {
        @FaultAction(className = KeywordExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/obtenerKeywords/Fault/KeywordExisteException")
    })
    public StringArray obtenerKeywords()
        throws KeywordExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @throws KeywordExisteException_Exception
     * @throws NicknameNoExisteException_Exception
     * @throws NombreExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioOfertas/altaOfertaRequest", output = "http://publicar.servidor/ServicioOfertas/altaOfertaResponse", fault = {
        @FaultAction(className = NombreExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/altaOferta/Fault/NombreExisteException"),
        @FaultAction(className = KeywordExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/altaOferta/Fault/KeywordExisteException"),
        @FaultAction(className = NicknameNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioOfertas/altaOferta/Fault/NicknameNoExisteException")
    })
    public void altaOferta(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        ArrayList arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8)
        throws KeywordExisteException_Exception, NicknameNoExisteException_Exception, NombreExisteException_Exception
    ;

}
