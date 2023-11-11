
package servidor.publicar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for publicacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="publicacion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="alta" type="{http://publicar.servidor/}localDate" minOccurs="0"/>
 *         <element name="costo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="fin" type="{http://publicar.servidor/}localDate" minOccurs="0"/>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="oferta" type="{http://publicar.servidor/}ofertaLaboral" minOccurs="0"/>
 *         <element name="tipo" type="{http://publicar.servidor/}tipoPublicacion" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publicacion", propOrder = {
    "alta",
    "costo",
    "fin",
    "id",
    "oferta",
    "tipo"
})
public class Publicacion {

    protected LocalDate alta;
    protected Integer costo;
    protected LocalDate fin;
    protected Integer id;
    protected OfertaLaboral oferta;
    protected TipoPublicacion tipo;

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
     * Gets the value of the fin property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFin() {
        return fin;
    }

    /**
     * Sets the value of the fin property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFin(LocalDate value) {
        this.fin = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the oferta property.
     * 
     * @return
     *     possible object is
     *     {@link OfertaLaboral }
     *     
     */
    public OfertaLaboral getOferta() {
        return oferta;
    }

    /**
     * Sets the value of the oferta property.
     * 
     * @param value
     *     allowed object is
     *     {@link OfertaLaboral }
     *     
     */
    public void setOferta(OfertaLaboral value) {
        this.oferta = value;
    }

    /**
     * Gets the value of the tipo property.
     * 
     * @return
     *     possible object is
     *     {@link TipoPublicacion }
     *     
     */
    public TipoPublicacion getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoPublicacion }
     *     
     */
    public void setTipo(TipoPublicacion value) {
        this.tipo = value;
    }

}
