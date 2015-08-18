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
public class PsProductTagPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tag")
    private int idTag;

    public PsProductTagPK() {
    }

    public PsProductTagPK(int idProduct, int idTag) {
        this.idProduct = idProduct;
        this.idTag = idTag;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduct;
        hash += (int) idTag;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductTagPK)) {
            return false;
        }
        PsProductTagPK other = (PsProductTagPK) object;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idTag != other.idTag) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductTagPK[ idProduct=" + idProduct + ", idTag=" + idTag + " ]";
    }
    
}
