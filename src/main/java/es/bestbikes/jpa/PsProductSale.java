/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.jpa;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author isthar
 */
@Entity
@Table(name = "ps_product_sale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductSale.findAll", query = "SELECT p FROM PsProductSale p"),
    @NamedQuery(name = "PsProductSale.findByIdProduct", query = "SELECT p FROM PsProductSale p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "PsProductSale.findByQuantity", query = "SELECT p FROM PsProductSale p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "PsProductSale.findBySaleNbr", query = "SELECT p FROM PsProductSale p WHERE p.saleNbr = :saleNbr"),
    @NamedQuery(name = "PsProductSale.findByDateUpd", query = "SELECT p FROM PsProductSale p WHERE p.dateUpd = :dateUpd")})
public class PsProductSale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product")
    private Integer idProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sale_nbr")
    private int saleNbr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_upd")
    @Temporal(TemporalType.DATE)
    private Date dateUpd;

    public PsProductSale() {
    }

    public PsProductSale(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public PsProductSale(Integer idProduct, int quantity, int saleNbr, Date dateUpd) {
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.saleNbr = saleNbr;
        this.dateUpd = dateUpd;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSaleNbr() {
        return saleNbr;
    }

    public void setSaleNbr(int saleNbr) {
        this.saleNbr = saleNbr;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductSale)) {
            return false;
        }
        PsProductSale other = (PsProductSale) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductSale[ idProduct=" + idProduct + " ]";
    }
    
}
