
package servidor.publicar;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "UsuarioNoEsEmpresaException", targetNamespace = "http://publicar.servidor/")
public class UsuarioNoEsEmpresaException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UsuarioNoEsEmpresaException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public UsuarioNoEsEmpresaException_Exception(String message, UsuarioNoEsEmpresaException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public UsuarioNoEsEmpresaException_Exception(String message, UsuarioNoEsEmpresaException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: servidor.publicar.UsuarioNoEsEmpresaException
     */
    public UsuarioNoEsEmpresaException getFaultInfo() {
        return faultInfo;
    }

}
