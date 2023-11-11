
package servidor.publicar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipoPublicacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="tipoPublicacion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="alta" type="{http://publicar.servidor/}localDate" minOccurs="0"/>
 *         <element name="costo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="duracion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="exposicion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoPublicacion", propOrder = {
    "alta",
    "costo",
    "descripcion",
    "duracion",
    "exposicion",
    "nombre"
})
public class TipoPublicacion {

    protected LocalDate alta;
    protected Integer costo;
    protected String descripcion;
    protected Integer duracion;
    protected int exposicion;
    protected String nombre;

    /**
     * Gets the value of the alta property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getAlta() {
        return alta;
    }

    /**
     * Sets the value of the alta property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setAlta(LocalDate value) {
        this.alta = value;
    }

    /**
     * Gets the value of the costo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCosto() {
        return costo;
    }

    /**
     * Sets the value of the costo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCosto(Integer value) {
        this.costo = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the duracion property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDuracion() {
        return duracion;
    }

    /**
     * Sets the value of the duracion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDuracion(Integer value) {
        this.duracion = value;
    }

    /**
     * Gets the value of the exposicion property.
     * 
     */
    public int getExposicion() {
        return exposicion;
    }

    /**
     * Sets the value of the exposicion property.
     * 
     */
    public void setExposicion(int value) {
        this.exposicion = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

}
