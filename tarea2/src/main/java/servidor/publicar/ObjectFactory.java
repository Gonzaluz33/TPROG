
package servidor.publicar;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servidor.publicar package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _KeywordExisteException_QNAME = new QName("http://publicar.servidor/", "KeywordExisteException");
    private final static QName _DtPublicacion_QNAME = new QName("http://publicar.servidor/", "dtPublicacion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servidor.publicar
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link KeywordExisteException }
     * 
     * @return
     *     the new instance of {@link KeywordExisteException }
     */
    public KeywordExisteException createKeywordExisteException() {
        return new KeywordExisteException();
    }

    /**
     * Create an instance of {@link DtPublicacion }
     * 
     * @return
     *     the new instance of {@link DtPublicacion }
     */
    public DtPublicacion createDtPublicacion() {
        return new DtPublicacion();
    }

    /**
     * Create an instance of {@link DtOferta }
     * 
     * @return
     *     the new instance of {@link DtOferta }
     */
    public DtOferta createDtOferta() {
        return new DtOferta();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     * @return
     *     the new instance of {@link LocalDate }
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link DtPostulacion }
     * 
     * @return
     *     the new instance of {@link DtPostulacion }
     */
    public DtPostulacion createDtPostulacion() {
        return new DtPostulacion();
    }

    /**
     * Create an instance of {@link LocalDateTime }
     * 
     * @return
     *     the new instance of {@link LocalDateTime }
     */
    public LocalDateTime createLocalDateTime() {
        return new LocalDateTime();
    }

    /**
     * Create an instance of {@link DtTipoPublicacion }
     * 
     * @return
     *     the new instance of {@link DtTipoPublicacion }
     */
    public DtTipoPublicacion createDtTipoPublicacion() {
        return new DtTipoPublicacion();
    }

    /**
     * Create an instance of {@link DtPublicacionArray }
     * 
     * @return
     *     the new instance of {@link DtPublicacionArray }
     */
    public DtPublicacionArray createDtPublicacionArray() {
        return new DtPublicacionArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeywordExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link KeywordExisteException }{@code >}
     */
    @XmlElementDecl(namespace = "http://publicar.servidor/", name = "KeywordExisteException")
    public JAXBElement<KeywordExisteException> createKeywordExisteException(KeywordExisteException value) {
        return new JAXBElement<>(_KeywordExisteException_QNAME, KeywordExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DtPublicacion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DtPublicacion }{@code >}
     */
    @XmlElementDecl(namespace = "http://publicar.servidor/", name = "dtPublicacion")
    public JAXBElement<DtPublicacion> createDtPublicacion(DtPublicacion value) {
        return new JAXBElement<>(_DtPublicacion_QNAME, DtPublicacion.class, null, value);
    }

}
