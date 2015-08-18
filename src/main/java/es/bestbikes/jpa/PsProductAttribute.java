/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author isthar
 */
@Entity
@Table(name = "ps_product_attribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductAttribute.findAll", query = "SELECT p FROM PsProductAttribute p"),
    @NamedQuery(name = "PsProductAttribute.findByIdProductAttribute", query = "SELECT p FROM PsProductAttribute p WHERE p.idProductAttribute = :idProductAttribute"),
    @NamedQuery(name = "PsProductAttribute.findByIdProduct", query = "SELECT p FROM PsProductAttribute p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "PsProductAttribute.findByReference", query = "SELECT p FROM PsProductAttribute p WHERE p.reference = :reference"),
    @NamedQuery(name = "PsProductAttribute.findBySupplierReference", query = "SELECT p FROM PsProductAttribute p WHERE p.supplierReference = :supplierReference"),
    @NamedQuery(name = "PsProductAttribute.findByLocation", query = "SELECT p FROM PsProductAttribute p WHERE p.location = :location"),
    @NamedQuery(name = "PsProductAttribute.findByEan13", query = "SELECT p FROM PsProductAttribute p WHERE p.ean13 = :ean13"),
    @NamedQuery(name = "PsProductAttribute.findByUpc", query = "SELECT p FROM PsProductAttribute p WHERE p.upc = :upc"),
    @NamedQuery(name = "PsProductAttribute.findByWholesalePrice", query = "SELECT p FROM PsProductAttribute p WHERE p.wholesalePrice = :wholesalePrice"),
    @NamedQuery(name = "PsProductAttribute.findByPrice", query = "SELECT p FROM PsProductAttribute p WHERE p.price = :price"),
    @NamedQuery(name = "PsProductAttribute.findByEcotax", query = "SELECT p FROM PsProductAttribute p WHERE p.ecotax = :ecotax"),
    @NamedQuery(name = "PsProductAttribute.findByQuantity", query = "SELECT p FROM PsProductAttribute p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "PsProductAttribute.findByWeight", query = "SELECT p FROM PsProductAttribute p WHERE p.weight = :weight"),
    @NamedQuery(name = "PsProductAttribute.findByUnitPriceImpact", query = "SELECT p FROM PsProductAttribute p WHERE p.unitPriceImpact = :unitPriceImpact"),
    @NamedQuery(name = "PsProductAttribute.findByDefaultOn", query = "SELECT p FROM PsProductAttribute p WHERE p.defaultOn = :defaultOn"),
    @NamedQuery(name = "PsProductAttribute.findByMinimalQuantity", query = "SELECT p FROM PsProductAttribute p WHERE p.minimalQuantity = :minimalQuantity"),
    @NamedQuery(name = "PsProductAttribute.findByAvailableDate", query = "SELECT p FROM PsProductAttribute p WHERE p.availableDate = :availableDate")})
public class PsProductAttribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product_attribute")
    private Integer idProductAttribute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product")
    private int idProduct;
    @Size(max = 32)
    @Column(name = "reference")
    private String reference;
    @Size(max = 32)
    @Column(name = "supplier_reference")
    private String supplierReference;
    @Size(max = 64)
    @Column(name = "location")
    private String location;
    @Size(max = 13)
    @Column(name = "ean13")
    private String ean13;
    @Size(max = 12)
    @Column(name = "upc")
    private String upc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "wholesale_price")
    private BigDecimal wholesalePrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ecotax")
    private BigDecimal ecotax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private BigDecimal weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_price_impact")
    private BigDecimal unitPriceImpact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "default_on")
    private boolean defaultOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "minimal_quantity")
    private int minimalQuantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "available_date")
    @Temporal(TemporalType.DATE)
    private Date availableDate;

    public PsProductAttribute() {
    }

    public PsProductAttribute(Integer idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public PsProductAttribute(Integer idProductAttribute, int idProduct, BigDecimal wholesalePrice, BigDecimal price, BigDecimal ecotax, int quantity, BigDecimal weight, BigDecimal unitPriceImpact, boolean defaultOn, int minimalQuantity, Date availableDate) {
        this.idProductAttribute = idProductAttribute;
        this.idProduct = idProduct;
        this.wholesalePrice = wholesalePrice;
        this.price = price;
        this.ecotax = ecotax;
        this.quantity = quantity;
        this.weight = weight;
        this.unitPriceImpact = unitPriceImpact;
        this.defaultOn = defaultOn;
        this.minimalQuantity = minimalQuantity;
        this.availableDate = availableDate;
    }

    public Integer getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(Integer idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getEcotax() {
        return ecotax;
    }

    public void setEcotax(BigDecimal ecotax) {
        this.ecotax = ecotax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getUnitPriceImpact() {
        return unitPriceImpact;
    }

    public void setUnitPriceImpact(BigDecimal unitPriceImpact) {
        this.unitPriceImpact = unitPriceImpact;
    }

    public boolean getDefaultOn() {
        return defaultOn;
    }

    public void setDefaultOn(boolean defaultOn) {
        this.defaultOn = defaultOn;
    }

    public int getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(int minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductAttribute != null ? idProductAttribute.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductAttribute)) {
            return false;
        }
        PsProductAttribute other = (PsProductAttribute) object;
        if ((this.idProductAttribute == null && other.idProductAttribute != null) || (this.idProductAttribute != null && !this.idProductAttribute.equals(other.idProductAttribute))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductAttribute[ idProductAttribute=" + idProductAttribute + " ]";
    }
    
}
