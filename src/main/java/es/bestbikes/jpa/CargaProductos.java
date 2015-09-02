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
@Table(name = "cargaProductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargaProductos.findAll", query = "SELECT c FROM CargaProductos c"),
    @NamedQuery(name = "CargaProductos.findByNumber", query = "SELECT c FROM CargaProductos c WHERE c.number = :number"),
    @NamedQuery(name = "CargaProductos.findByUnitprice", query = "SELECT c FROM CargaProductos c WHERE c.unitprice = :unitprice"),
    @NamedQuery(name = "CargaProductos.findByScaledunitprice", query = "SELECT c FROM CargaProductos c WHERE c.scaledunitprice = :scaledunitprice"),
    @NamedQuery(name = "CargaProductos.findByRecommendedretailprice", query = "SELECT c FROM CargaProductos c WHERE c.recommendedretailprice = :recommendedretailprice"),
    @NamedQuery(name = "CargaProductos.findByDescription1", query = "SELECT c FROM CargaProductos c WHERE c.description1 = :description1"),
    @NamedQuery(name = "CargaProductos.findByDescription2", query = "SELECT c FROM CargaProductos c WHERE c.description2 = :description2"),
    @NamedQuery(name = "CargaProductos.findByAvailablestatus", query = "SELECT c FROM CargaProductos c WHERE c.availablestatus = :availablestatus"),
    @NamedQuery(name = "CargaProductos.findByAvailablestatusdesc", query = "SELECT c FROM CargaProductos c WHERE c.availablestatusdesc = :availablestatusdesc"),
    @NamedQuery(name = "CargaProductos.findBySupplieritemnumber", query = "SELECT c FROM CargaProductos c WHERE c.supplieritemnumber = :supplieritemnumber"),
    @NamedQuery(name = "CargaProductos.findByTax", query = "SELECT c FROM CargaProductos c WHERE c.tax = :tax"),
    @NamedQuery(name = "CargaProductos.findByEan", query = "SELECT c FROM CargaProductos c WHERE c.ean = :ean"),
    @NamedQuery(name = "CargaProductos.findByManufacturerean", query = "SELECT c FROM CargaProductos c WHERE c.manufacturerean = :manufacturerean"),
    @NamedQuery(name = "CargaProductos.findByCustomstariffnumber", query = "SELECT c FROM CargaProductos c WHERE c.customstariffnumber = :customstariffnumber"),
    @NamedQuery(name = "CargaProductos.findBySupplier", query = "SELECT c FROM CargaProductos c WHERE c.supplier = :supplier"),
    @NamedQuery(name = "CargaProductos.findByCategorykey", query = "SELECT c FROM CargaProductos c WHERE c.categorykey = :categorykey"),
    @NamedQuery(name = "CargaProductos.findByInfourl", query = "SELECT c FROM CargaProductos c WHERE c.infourl = :infourl"),
    @NamedQuery(name = "CargaProductos.findByPictureurl", query = "SELECT c FROM CargaProductos c WHERE c.pictureurl = :pictureurl"),
    @NamedQuery(name = "CargaProductos.findByCargar", query = "SELECT c FROM CargaProductos c WHERE c.cargar = :cargar"),
    @NamedQuery(name = "CargaProductos.findByFccarga", query = "SELECT c FROM CargaProductos c WHERE c.fccarga = :fccarga")})
public class CargaProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "number")
    private String number;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "unitprice")
    private BigDecimal unitprice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "scaledunitprice")
    private BigDecimal scaledunitprice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recommendedretailprice")
    private BigDecimal recommendedretailprice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65000)
    @Column(name = "description1")
    private String description1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65000)
    @Column(name = "description2")
    private String description2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "availablestatus")
    private boolean availablestatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "availablestatusdesc")
    private String availablestatusdesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "supplieritemnumber")
    private String supplieritemnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private BigDecimal tax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "ean")
    private String ean;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "manufacturerean")
    private String manufacturerean;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "customstariffnumber")
    private String customstariffnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "supplier")
    private String supplier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "categorykey")
    private String categorykey;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65000)
    @Column(name = "infourl")
    private String infourl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pictureurl")
    private String pictureurl;
    @Column(name = "cargar")
    private Boolean cargar;
    @Column(name = "Fc_carga")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fccarga;

    public CargaProductos() {
    }

    public CargaProductos(String number) {
        this.number = number;
    }

    public CargaProductos(String number, BigDecimal unitprice, BigDecimal scaledunitprice, BigDecimal recommendedretailprice, String description1, String description2, boolean availablestatus, String availablestatusdesc, String supplieritemnumber, BigDecimal tax, String ean, String manufacturerean, String customstariffnumber, String supplier, String categorykey, String infourl, String pictureurl) {
        this.number = number;
        this.unitprice = unitprice;
        this.scaledunitprice = scaledunitprice;
        this.recommendedretailprice = recommendedretailprice;
        this.description1 = description1;
        this.description2 = description2;
        this.availablestatus = availablestatus;
        this.availablestatusdesc = availablestatusdesc;
        this.supplieritemnumber = supplieritemnumber;
        this.tax = tax;
        this.ean = ean;
        this.manufacturerean = manufacturerean;
        this.customstariffnumber = customstariffnumber;
        this.supplier = supplier;
        this.categorykey = categorykey;
        this.infourl = infourl;
        this.pictureurl = pictureurl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public BigDecimal getScaledunitprice() {
        return scaledunitprice;
    }

    public void setScaledunitprice(BigDecimal scaledunitprice) {
        this.scaledunitprice = scaledunitprice;
    }

    public BigDecimal getRecommendedretailprice() {
        return recommendedretailprice;
    }

    public void setRecommendedretailprice(BigDecimal recommendedretailprice) {
        this.recommendedretailprice = recommendedretailprice;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public boolean getAvailablestatus() {
        return availablestatus;
    }

    public void setAvailablestatus(boolean availablestatus) {
        this.availablestatus = availablestatus;
    }

    public String getAvailablestatusdesc() {
        return availablestatusdesc;
    }

    public void setAvailablestatusdesc(String availablestatusdesc) {
        this.availablestatusdesc = availablestatusdesc;
    }

    public String getSupplieritemnumber() {
        return supplieritemnumber;
    }

    public void setSupplieritemnumber(String supplieritemnumber) {
        this.supplieritemnumber = supplieritemnumber;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getManufacturerean() {
        return manufacturerean;
    }

    public void setManufacturerean(String manufacturerean) {
        this.manufacturerean = manufacturerean;
    }

    public String getCustomstariffnumber() {
        return customstariffnumber;
    }

    public void setCustomstariffnumber(String customstariffnumber) {
        this.customstariffnumber = customstariffnumber;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCategorykey() {
        return categorykey;
    }

    public void setCategorykey(String categorykey) {
        this.categorykey = categorykey;
    }

    public String getInfourl() {
        return infourl;
    }

    public void setInfourl(String infourl) {
        this.infourl = infourl;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public Boolean getCargar() {
        return cargar;
    }

    public void setCargar(Boolean cargar) {
        this.cargar = cargar;
    }

    public Date getFccarga() {
        return fccarga;
    }

    public void setFccarga(Date fccarga) {
        this.fccarga = fccarga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (number != null ? number.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargaProductos)) {
            return false;
        }
        CargaProductos other = (CargaProductos) object;
        if ((this.number == null && other.number != null) || (this.number != null && !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.bean.CargaProductos[ number=" + number + " ]";
    }
    
}
