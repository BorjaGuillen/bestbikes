//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.08.18 a las 07:07:44 PM CEST 
//


package es.bestbikes.jaxb;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}filterkey"/&gt;
 *         &lt;element ref="{}filtercount"/&gt;
 *         &lt;element ref="{}filterdesc"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "filterkey",
    "filtercount",
    "filterdesc"
})
@XmlRootElement(name = "filter")
public class Filter {

    @XmlElement(required = true)
    protected String filterkey;
    @XmlElement(required = true)
    protected BigInteger filtercount;
    @XmlElement(required = true)
    protected String filterdesc;

    /**
     * Obtiene el valor de la propiedad filterkey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterkey() {
        return filterkey;
    }

    /**
     * Define el valor de la propiedad filterkey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterkey(String value) {
        this.filterkey = value;
    }

    /**
     * Obtiene el valor de la propiedad filtercount.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFiltercount() {
        return filtercount;
    }

    /**
     * Define el valor de la propiedad filtercount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFiltercount(BigInteger value) {
        this.filtercount = value;
    }

    /**
     * Obtiene el valor de la propiedad filterdesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterdesc() {
        return filterdesc;
    }

    /**
     * Define el valor de la propiedad filterdesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterdesc(String value) {
        this.filterdesc = value;
    }

}
