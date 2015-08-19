//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.08.18 a las 09:11:53 PM CEST 
//


package es.bestbikes.jaxb;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.bestbikes.jaxb package. 
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

    private final static QName _Processtype_QNAME = new QName("", "processtype");
    private final static QName _Processstatus_QNAME = new QName("", "processstatus");
    private final static QName _Processmessage_QNAME = new QName("", "processmessage");
    private final static QName _GUID_QNAME = new QName("", "GUID");
    private final static QName _Page_QNAME = new QName("", "page");
    private final static QName _Ofpages_QNAME = new QName("", "ofpages");
    private final static QName _Filterkey_QNAME = new QName("", "filterkey");
    private final static QName _Filtercount_QNAME = new QName("", "filtercount");
    private final static QName _Filterdesc_QNAME = new QName("", "filterdesc");
    private final static QName _Number_QNAME = new QName("", "number");
    private final static QName _Unitprice_QNAME = new QName("", "unitprice");
    private final static QName _Scaledunitprice_QNAME = new QName("", "scaledunitprice");
    private final static QName _Recommendedretailprice_QNAME = new QName("", "recommendedretailprice");
    private final static QName _Description1_QNAME = new QName("", "description1");
    private final static QName _Description2_QNAME = new QName("", "description2");
    private final static QName _Availablestatus_QNAME = new QName("", "availablestatus");
    private final static QName _Availablestatusdesc_QNAME = new QName("", "availablestatusdesc");
    private final static QName _Supplieritemnumber_QNAME = new QName("", "supplieritemnumber");
    private final static QName _Tax_QNAME = new QName("", "tax");
    private final static QName _Ean_QNAME = new QName("", "ean");
    private final static QName _Manufacturerean_QNAME = new QName("", "manufacturerean");
    private final static QName _Customstariffnumber_QNAME = new QName("", "customstariffnumber");
    private final static QName _Supplier_QNAME = new QName("", "supplier");
    private final static QName _Categorykey_QNAME = new QName("", "categorykey");
    private final static QName _Infourl_QNAME = new QName("", "infourl");
    private final static QName _Pictureurl_QNAME = new QName("", "pictureurl");
    private final static QName _Dni_QNAME = new QName("", "dni");
    private final static QName _EstadoCivil_QNAME = new QName("", "estadoCivil");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.bestbikes.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Root }
     * 
     */
    public Root createRoot() {
        return new Root();
    }

    /**
     * Create an instance of {@link Filter }
     * 
     */
    public Filter createFilter() {
        return new Filter();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "processtype")
    public JAXBElement<String> createProcesstype(String value) {
        return new JAXBElement<String>(_Processtype_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "processstatus")
    public JAXBElement<String> createProcessstatus(String value) {
        return new JAXBElement<String>(_Processstatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "processmessage")
    public JAXBElement<String> createProcessmessage(String value) {
        return new JAXBElement<String>(_Processmessage_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "GUID")
    public JAXBElement<String> createGUID(String value) {
        return new JAXBElement<String>(_GUID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "page")
    public JAXBElement<BigInteger> createPage(BigInteger value) {
        return new JAXBElement<BigInteger>(_Page_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ofpages")
    public JAXBElement<BigInteger> createOfpages(BigInteger value) {
        return new JAXBElement<BigInteger>(_Ofpages_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "filterkey")
    public JAXBElement<String> createFilterkey(String value) {
        return new JAXBElement<String>(_Filterkey_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "filtercount")
    public JAXBElement<BigInteger> createFiltercount(BigInteger value) {
        return new JAXBElement<BigInteger>(_Filtercount_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "filterdesc")
    public JAXBElement<String> createFilterdesc(String value) {
        return new JAXBElement<String>(_Filterdesc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "number")
    public JAXBElement<BigInteger> createNumber(BigInteger value) {
        return new JAXBElement<BigInteger>(_Number_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "unitprice")
    public JAXBElement<String> createUnitprice(String value) {
        return new JAXBElement<String>(_Unitprice_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "scaledunitprice")
    public JAXBElement<String> createScaledunitprice(String value) {
        return new JAXBElement<String>(_Scaledunitprice_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "recommendedretailprice")
    public JAXBElement<String> createRecommendedretailprice(String value) {
        return new JAXBElement<String>(_Recommendedretailprice_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description1")
    public JAXBElement<String> createDescription1(String value) {
        return new JAXBElement<String>(_Description1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "description2")
    public JAXBElement<String> createDescription2(String value) {
        return new JAXBElement<String>(_Description2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "availablestatus")
    public JAXBElement<String> createAvailablestatus(String value) {
        return new JAXBElement<String>(_Availablestatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "availablestatusdesc")
    public JAXBElement<String> createAvailablestatusdesc(String value) {
        return new JAXBElement<String>(_Availablestatusdesc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "supplieritemnumber")
    public JAXBElement<String> createSupplieritemnumber(String value) {
        return new JAXBElement<String>(_Supplieritemnumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tax")
    public JAXBElement<Double> createTax(Double value) {
        return new JAXBElement<Double>(_Tax_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ean")
    public JAXBElement<String> createEan(String value) {
        return new JAXBElement<String>(_Ean_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "manufacturerean")
    public JAXBElement<String> createManufacturerean(String value) {
        return new JAXBElement<String>(_Manufacturerean_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "customstariffnumber")
    public JAXBElement<String> createCustomstariffnumber(String value) {
        return new JAXBElement<String>(_Customstariffnumber_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "supplier")
    public JAXBElement<String> createSupplier(String value) {
        return new JAXBElement<String>(_Supplier_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "categorykey")
    public JAXBElement<String> createCategorykey(String value) {
        return new JAXBElement<String>(_Categorykey_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "infourl")
    public JAXBElement<String> createInfourl(String value) {
        return new JAXBElement<String>(_Infourl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pictureurl")
    public JAXBElement<String> createPictureurl(String value) {
        return new JAXBElement<String>(_Pictureurl_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "dni")
    public JAXBElement<BigInteger> createDni(BigInteger value) {
        return new JAXBElement<BigInteger>(_Dni_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "estadoCivil")
    public JAXBElement<String> createEstadoCivil(String value) {
        return new JAXBElement<String>(_EstadoCivil_QNAME, String.class, null, value);
    }

}
