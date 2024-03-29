
package servidor.publicar;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "ServicioUsuarios", targetNamespace = "http://publicar.servidor/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServicioUsuarios {


    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/generateJWTRequest", output = "http://publicar.servidor/ServicioUsuarios/generateJWTResponse")
    public String generateJWT(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns boolean
     * @throws NicknameNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/validarUsuarioRequest", output = "http://publicar.servidor/ServicioUsuarios/validarUsuarioResponse", fault = {
        @FaultAction(className = NicknameNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioUsuarios/validarUsuario/Fault/NicknameNoExisteException")
    })
    public boolean validarUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws NicknameNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/isTokenBlacklistedRequest", output = "http://publicar.servidor/ServicioUsuarios/isTokenBlacklistedResponse")
    public boolean isTokenBlacklisted(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/obtenerCorreoPorJWTRequest", output = "http://publicar.servidor/ServicioUsuarios/obtenerCorreoPorJWTResponse")
    public String obtenerCorreoPorJWT(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtUsuario
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/obtenerDatosDeUsuarioJWTRequest", output = "http://publicar.servidor/ServicioUsuarios/obtenerDatosDeUsuarioJWTResponse")
    public DtUsuario obtenerDatosDeUsuarioJWT(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/tipoUsuarioRequest", output = "http://publicar.servidor/ServicioUsuarios/tipoUsuarioResponse")
    public String tipoUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/usuarioExisteRequest", output = "http://publicar.servidor/ServicioUsuarios/usuarioExisteResponse")
    public boolean usuarioExiste(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtUsuario
     * @throws CorreoNoEncontradoException_Exception
     * @throws NicknameNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/consultarUsuarioPorCorreoRequest", output = "http://publicar.servidor/ServicioUsuarios/consultarUsuarioPorCorreoResponse", fault = {
        @FaultAction(className = CorreoNoEncontradoException_Exception.class, value = "http://publicar.servidor/ServicioUsuarios/consultarUsuarioPorCorreo/Fault/CorreoNoEncontradoException"),
        @FaultAction(className = NicknameNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioUsuarios/consultarUsuarioPorCorreo/Fault/NicknameNoExisteException")
    })
    public DtUsuario consultarUsuarioPorCorreo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws CorreoNoEncontradoException_Exception, NicknameNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtUsuario
     * @throws NicknameNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/consultarUsuarioRequest", output = "http://publicar.servidor/ServicioUsuarios/consultarUsuarioResponse", fault = {
        @FaultAction(className = NicknameNoExisteException_Exception.class, value = "http://publicar.servidor/ServicioUsuarios/consultarUsuario/Fault/NicknameNoExisteException")
    })
    public DtUsuario consultarUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws NicknameNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioUsuarios/actualizarDatosPostulanteRequest", output = "http://publicar.servidor/ServicioUsuarios/actualizarDatosPostulanteResponse")
    public void actualizarDatosPostulante(
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
        String arg5);

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioUsuarios/actualizarDatosEmpresaRequest", output = "http://publicar.servidor/ServicioUsuarios/actualizarDatosEmpresaResponse")
    public void actualizarDatosEmpresa(
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
        String arg6);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/validarTokenRequest", output = "http://publicar.servidor/ServicioUsuarios/validarTokenResponse")
    public boolean validarToken(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioUsuarios/cerrarSesionRequest", output = "http://publicar.servidor/ServicioUsuarios/cerrarSesionResponse")
    public void cerrarSesion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtPostulante
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/esPostulanteRequest", output = "http://publicar.servidor/ServicioUsuarios/esPostulanteResponse")
    public DtPostulante esPostulante(
        @WebParam(name = "arg0", partName = "arg0")
        DtUsuario arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.publicar.DtEmpresa
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/esEmpresaRequest", output = "http://publicar.servidor/ServicioUsuarios/esEmpresaResponse")
    public DtEmpresa esEmpresa(
        @WebParam(name = "arg0", partName = "arg0")
        DtUsuario arg0);

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
     * @throws CorreoRepetidoException_Exception
     * @throws UsuarioRepetidoException_Exception
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioUsuarios/altaPostulanteRequest", output = "http://publicar.servidor/ServicioUsuarios/altaPostulanteResponse", fault = {
        @FaultAction(className = UsuarioRepetidoException_Exception.class, value = "http://publicar.servidor/ServicioUsuarios/altaPostulante/Fault/UsuarioRepetidoException"),
        @FaultAction(className = CorreoRepetidoException_Exception.class, value = "http://publicar.servidor/ServicioUsuarios/altaPostulante/Fault/CorreoRepetidoException")
    })
    public void altaPostulante(
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
        String arg7)
        throws CorreoRepetidoException_Exception, UsuarioRepetidoException_Exception
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
     * @throws CorreoRepetidoException_Exception
     * @throws UsuarioRepetidoException_Exception
     */
    @WebMethod
    @Action(input = "http://publicar.servidor/ServicioUsuarios/altaEmpresaRequest", output = "http://publicar.servidor/ServicioUsuarios/altaEmpresaResponse", fault = {
        @FaultAction(className = UsuarioRepetidoException_Exception.class, value = "http://publicar.servidor/ServicioUsuarios/altaEmpresa/Fault/UsuarioRepetidoException"),
        @FaultAction(className = CorreoRepetidoException_Exception.class, value = "http://publicar.servidor/ServicioUsuarios/altaEmpresa/Fault/CorreoRepetidoException")
    })
    public void altaEmpresa(
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
        String arg8)
        throws CorreoRepetidoException_Exception, UsuarioRepetidoException_Exception
    ;

    /**
     * 
     * @return
     *     returns servidor.publicar.DtUsuarioArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/listarUsuariosRequest", output = "http://publicar.servidor/ServicioUsuarios/listarUsuariosResponse")
    public DtUsuarioArray listarUsuarios();

    /**
     * 
     * @return
     *     returns servidor.publicar.DtEmpresaArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://publicar.servidor/ServicioUsuarios/listarEmpresasRequest", output = "http://publicar.servidor/ServicioUsuarios/listarEmpresasResponse")
    public DtEmpresaArray listarEmpresas();

}
