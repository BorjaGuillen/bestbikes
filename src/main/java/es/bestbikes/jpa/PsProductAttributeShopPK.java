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
public class PsProductAttributeShopPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_shop")
    private int idShop;

    public PsProductAttributeShopPK() {
    }

    public PsProductAttributeShopPK(int idProductAttribute, int idShop) {
        this.idProductAttribute = idProductAttribute;
        this.idShop = idShop;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
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
        hash += (int) idProductAttribute;
        hash += (int) idShop;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductAttributeShopPK)) {
            return false;
        }
        PsProductAttributeShopPK other = (PsProductAttributeShopPK) object;
        if (this.idProductAttribute != other.idProductAttribute) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductAttributeShopPK[ idProductAttribute=" + idProductAttribute + ", idShop=" + idShop + " ]";
    }
    
}
