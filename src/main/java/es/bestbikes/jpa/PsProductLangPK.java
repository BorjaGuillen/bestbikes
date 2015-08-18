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
public class PsProductLangPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_lang")
    private int idLang;

    public PsProductLangPK() {
    }

    public PsProductLangPK(int idProduct, int idShop, int idLang) {
        this.idProduct = idProduct;
        this.idShop = idShop;
        this.idLang = idLang;
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

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduct;
        hash += (int) idShop;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductLangPK)) {
            return false;
        }
        PsProductLangPK other = (PsProductLangPK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductLangPK[ idProduct=" + idProduct + ", idShop=" + idShop + ", idLang=" + idLang + " ]";
    }
    
}
