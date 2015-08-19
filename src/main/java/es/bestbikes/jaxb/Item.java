//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.08.19 a las 08:04:30 PM CEST 
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
 *         &lt;element ref="{}number"/&gt;
 *         &lt;element ref="{}unitprice"/&gt;
 *         &lt;element ref="{}scaledunitprice"/&gt;
 *         &lt;element ref="{}recommendedretailprice"/&gt;
 *         &lt;element ref="{}description1"/&gt;
 *         &lt;element ref="{}description2"/&gt;
 *         &lt;element ref="{}availablestatus"/&gt;
 *         &lt;element ref="{}availablestatusdesc"/&gt;
 *         &lt;element ref="{}supplieritemnumber"/&gt;
 *         &lt;element ref="{}tax"/&gt;
 *         &lt;element ref="{}ean"/&gt;
 *         &lt;element ref="{}manufacturerean"/&gt;
 *         &lt;element ref="{}customstariffnumber"/&gt;
 *         &lt;element ref="{}supplier"/&gt;
 *         &lt;element ref="{}categorykey"/&gt;
 *         &lt;element ref="{}infourl"/&gt;
 *         &lt;element ref="{}pictureurl"/&gt;
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
    "number",
    "unitprice",
    "scaledunitprice",
    "recommendedretailprice",
    "description1",
    "description2",
    "availablestatus",
    "availablestatusdesc",
    "supplieritemnumber",
    "tax",
    "ean",
    "manufacturerean",
    "customstariffnumber",
    "supplier",
    "categorykey",
    "infourl",
    "pictureurl"
})
@XmlRootElement(name = "item")
public class Item {

    @XmlElement(required = true)
    protected BigInteger number;
    @XmlElement(required = true)
    protected String unitprice;
    @XmlElement(required = true)
    protected String scaledunitprice;
    @XmlElement(required = true)
    protected String recommendedretailprice;
    @XmlElement(required = true)
    protected String description1;
    @XmlElement(required = true)
    protected String description2;
    @XmlElement(required = true)
    protected String availablestatus;
    @XmlElement(required = true)
    protected String availablestatusdesc;
    @XmlElement(required = true)
    protected String supplieritemnumber;
    protected double tax;
    @XmlElement(required = true)
    protected String ean;
    @XmlElement(required = true)
    protected String manufacturerean;
    @XmlElement(required = true)
    protected String customstariffnumber;
    @XmlElement(required = true)
    protected String supplier;
    @XmlElement(required = true)
    protected String categorykey;
    @XmlElement(required = true)
    protected String infourl;
    @XmlElement(required = true)
    protected String pictureurl;

    /**
     * Obtiene el valor de la propiedad number.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumber() {
        return number;
    }

    /**
     * Define el valor de la propiedad number.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumber(BigInteger value) {
        this.number = value;
    }

    /**
     * Obtiene el valor de la propiedad unitprice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitprice() {
        return unitprice;
    }

    /**
     * Define el valor de la propiedad unitprice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitprice(String value) {
        this.unitprice = value;
    }

    /**
     * Obtiene el valor de la propiedad scaledunitprice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScaledunitprice() {
        return scaledunitprice;
    }

    /**
     * Define el valor de la propiedad scaledunitprice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScaledunitprice(String value) {
        this.scaledunitprice = value;
    }

    /**
     * Obtiene el valor de la propiedad recommendedretailprice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecommendedretailprice() {
        return recommendedretailprice;
    }

    /**
     * Define el valor de la propiedad recommendedretailprice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecommendedretailprice(String value) {
        this.recommendedretailprice = value;
    }

    /**
     * Obtiene el valor de la propiedad description1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription1() {
        return description1;
    }

    /**
     * Define el valor de la propiedad description1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription1(String value) {
        this.description1 = value;
    }

    /**
     * Obtiene el valor de la propiedad description2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription2() {
        return description2;
    }

    /**
     * Define el valor de la propiedad description2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription2(String value) {
        this.description2 = value;
    }

    /**
     * Obtiene el valor de la propiedad availablestatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailablestatus() {
        return availablestatus;
    }

    /**
     * Define el valor de la propiedad availablestatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailablestatus(String value) {
        this.availablestatus = value;
    }

    /**
     * Obtiene el valor de la propiedad availablestatusdesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailablestatusdesc() {
        return availablestatusdesc;
    }

    /**
     * Define el valor de la propiedad availablestatusdesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailablestatusdesc(String value) {
        this.availablestatusdesc = value;
    }

    /**
     * Obtiene el valor de la propiedad supplieritemnumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplieritemnumber() {
        return supplieritemnumber;
    }

    /**
     * Define el valor de la propiedad supplieritemnumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplieritemnumber(String value) {
        this.supplieritemnumber = value;
    }

    /**
     * Obtiene el valor de la propiedad tax.
     * 
     */
    public double getTax() {
        return tax;
    }

    /**
     * Define el valor de la propiedad tax.
     * 
     */
    public void setTax(double value) {
        this.tax = value;
    }

    /**
     * Obtiene el valor de la propiedad ean.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEan() {
        return ean;
    }

    /**
     * Define el valor de la propiedad ean.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEan(String value) {
        this.ean = value;
    }

    /**
     * Obtiene el valor de la propiedad manufacturerean.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturerean() {
        return manufacturerean;
    }

    /**
     * Define el valor de la propiedad manufacturerean.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturerean(String value) {
        this.manufacturerean = value;
    }

    /**
     * Obtiene el valor de la propiedad customstariffnumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomstariffnumber() {
        return customstariffnumber;
    }

    /**
     * Define el valor de la propiedad customstariffnumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomstariffnumber(String value) {
        this.customstariffnumber = value;
    }

    /**
     * Obtiene el valor de la propiedad supplier.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * Define el valor de la propiedad supplier.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplier(String value) {
        this.supplier = value;
    }

    /**
     * Obtiene el valor de la propiedad categorykey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategorykey() {
        return categorykey;
    }

    /**
     * Define el valor de la propiedad categorykey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategorykey(String value) {
        this.categorykey = value;
    }

    /**
     * Obtiene el valor de la propiedad infourl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfourl() {
        return infourl;
    }

    /**
     * Define el valor de la propiedad infourl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfourl(String value) {
        this.infourl = value;
    }

    /**
     * Obtiene el valor de la propiedad pictureurl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPictureurl() {
        return pictureurl;
    }

    /**
     * Define el valor de la propiedad pictureurl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureurl(String value) {
        this.pictureurl = value;
    }

}
