
package servidor.publicar;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enumEstadoOferta.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>{@code
 * <simpleType name="enumEstadoOferta">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="INGRESADA"/>
 *     <enumeration value="CONFIRMADA"/>
 *     <enumeration value="RECHAZADA"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "enumEstadoOferta")
@XmlEnum
public enum EnumEstadoOferta {

    INGRESADA,
    CONFIRMADA,
    RECHAZADA;

    public String value() {
        return name();
    }

    public static EnumEstadoOferta fromValue(String v) {
        return valueOf(v);
    }

}
