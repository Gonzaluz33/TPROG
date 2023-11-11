
package servidor.publicar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dtPostulacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="dtPostulacion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="nicknamePostulante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="nombreOfertaLaboral" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="cvReducido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="motivacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="urlVideo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtPostulacion", propOrder = {
    "nicknamePostulante",
    "nombreOfertaLaboral",
    "fecha",
    "cvReducido",
    "motivacion",
    "urlVideo"
})
public class DtPostulacion {

    protected String nicknamePostulante;
    protected String nombreOfertaLaboral;
    protected String fecha;
    protected String cvReducido;
    protected String motivacion;
    protected String urlVideo;

    /**
     * Gets the value of the nicknamePostulante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNicknamePostulante() {
        return nicknamePostulante;
    }

    /**
     * Sets the value of the nicknamePostulante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNicknamePostulante(String value) {
        this.nicknamePostulante = value;
    }

    /**
     * Gets the value of the nombreOfertaLaboral property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreOfertaLaboral() {
        return nombreOfertaLaboral;
    }

    /**
     * Sets the value of the nombreOfertaLaboral property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreOfertaLaboral(String value) {
        this.nombreOfertaLaboral = value;
    }

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the cvReducido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvReducido() {
        return cvReducido;
    }

    /**
     * Sets the value of the cvReducido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvReducido(String value) {
        this.cvReducido = value;
    }

    /**
     * Gets the value of the motivacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivacion() {
        return motivacion;
    }

    /**
     * Sets the value of the motivacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivacion(String value) {
        this.motivacion = value;
    }

    /**
     * Gets the value of the urlVideo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlVideo() {
        return urlVideo;
    }

    /**
     * Sets the value of the urlVideo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlVideo(String value) {
        this.urlVideo = value;
    }

}
