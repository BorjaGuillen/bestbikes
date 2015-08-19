//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.08.19 a las 06:53:54 PM CEST 
//


package es.bestbikes.jaxb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}processtype"/&gt;
 *         &lt;element ref="{}processstatus"/&gt;
 *         &lt;element ref="{}processmessage"/&gt;
 *         &lt;element ref="{}GUID"/&gt;
 *         &lt;element ref="{}page"/&gt;
 *         &lt;element ref="{}ofpages"/&gt;
 *         &lt;element ref="{}filter" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{}item" maxOccurs="unbounded"/&gt;
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
    "processtype",
    "processstatus",
    "processmessage",
    "guid",
    "page",
    "ofpages",
    "filter",
    "item"
})
@XmlRootElement(name = "root")
public class Root {

    @XmlElement(required = true)
    protected String processtype;
    @XmlElement(required = true)
    protected String processstatus;
    @XmlElement(required = true)
    protected String processmessage;
    @XmlElement(name = "GUID", required = true)
    protected String guid;
    @XmlElement(required = true)
    protected BigInteger page;
    @XmlElement(required = true)
    protected BigInteger ofpages;
    @XmlElement(required = true)
    protected List<Filter> filter;
    @XmlElement(required = true)
    protected List<Item> item;

    /**
     * Obtiene el valor de la propiedad processtype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcesstype() {
        return processtype;
    }

    /**
     * Define el valor de la propiedad processtype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcesstype(String value) {
        this.processtype = value;
    }

    /**
     * Obtiene el valor de la propiedad processstatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessstatus() {
        return processstatus;
    }

    /**
     * Define el valor de la propiedad processstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessstatus(String value) {
        this.processstatus = value;
    }

    /**
     * Obtiene el valor de la propiedad processmessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessmessage() {
        return processmessage;
    }

    /**
     * Define el valor de la propiedad processmessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessmessage(String value) {
        this.processmessage = value;
    }

    /**
     * Obtiene el valor de la propiedad guid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGUID() {
        return guid;
    }

    /**
     * Define el valor de la propiedad guid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGUID(String value) {
        this.guid = value;
    }

    /**
     * Obtiene el valor de la propiedad page.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPage() {
        return page;
    }

    /**
     * Define el valor de la propiedad page.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPage(BigInteger value) {
        this.page = value;
    }

    /**
     * Obtiene el valor de la propiedad ofpages.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOfpages() {
        return ofpages;
    }

    /**
     * Define el valor de la propiedad ofpages.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOfpages(BigInteger value) {
        this.ofpages = value;
    }

    /**
     * Gets the value of the filter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Filter }
     * 
     * 
     */
    public List<Filter> getFilter() {
        if (filter == null) {
            filter = new ArrayList<Filter>();
        }
        return this.filter;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     * 
     * 
     */
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }

}
