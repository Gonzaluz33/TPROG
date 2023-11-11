
package servidor.publicar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dtPublicacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="dtPublicacion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="costoAsociado" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="fechaAlta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="fechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="dtOferta" type="{http://publicar.servidor/}dtOferta" minOccurs="0"/>
 *         <element name="dtTipo" type="{http://publicar.servidor/}dtTipoPublicacion" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtPublicacion", propOrder = {
    "id",
    "costoAsociado",
    "fechaAlta",
    "fechaVencimiento",
    "dtOferta",
    "dtTipo"
})
public class DtPublicacion {

    protected Integer id;
    protected Integer costoAsociado;
    protected String fechaAlta;
    protected String fechaVencimiento;
    protected DtOferta dtOferta;
    protected DtTipoPublicacion dtTipo;

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
     * Gets the value of the costoAsociado property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCostoAsociado() {
        return costoAsociado;
    }

    /**
     * Sets the value of the costoAsociado property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCostoAsociado(Integer value) {
        this.costoAsociado = value;
    }

    /**
     * Gets the value of the fechaAlta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Sets the value of the fechaAlta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaAlta(String value) {
        this.fechaAlta = value;
    }

    /**
     * Gets the value of the fechaVencimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Sets the value of the fechaVencimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaVencimiento(String value) {
        this.fechaVencimiento = value;
    }

    /**
     * Gets the value of the dtOferta property.
     * 
     * @return
     *     possible object is
     *     {@link DtOferta }
     *     
     */
    public DtOferta getDtOferta() {
        return dtOferta;
    }

    /**
     * Sets the value of the dtOferta property.
     * 
     * @param value
     *     allowed object is
     *     {@link DtOferta }
     *     
     */
    public void setDtOferta(DtOferta value) {
        this.dtOferta = value;
    }

    /**
     * Gets the value of the dtTipo property.
     * 
     * @return
     *     possible object is
     *     {@link DtTipoPublicacion }
     *     
     */
    public DtTipoPublicacion getDtTipo() {
        return dtTipo;
    }

    /**
     * Sets the value of the dtTipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DtTipoPublicacion }
     *     
     */
    public void setDtTipo(DtTipoPublicacion value) {
        this.dtTipo = value;
    }

}
