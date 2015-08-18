/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author isthar
 */
@Embeddable
public class PsProductShopPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_shop")
    private int idShop;

    public PsProductShopPK() {
    }

    public PsProductShopPK(int idProduct, int idShop) {
        this.idProduct = idProduct;
        this.idShop = idShop;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduct;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductShopPK)) {
            return false;
        }
        PsProductShopPK other = (PsProductShopPK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductShopPK[ idProduct=" + idProduct + ", idShop=" + idShop + " ]";
    }
    
}
