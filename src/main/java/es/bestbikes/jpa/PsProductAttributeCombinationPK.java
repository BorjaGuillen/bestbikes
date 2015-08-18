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
public class PsProductAttributeCombinationPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_attribute")
    private int idAttribute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product_attribute")
    private int idProductAttribute;

    public PsProductAttributeCombinationPK() {
    }

    public PsProductAttributeCombinationPK(int idAttribute, int idProductAttribute) {
        this.idAttribute = idAttribute;
        this.idProductAttribute = idProductAttribute;
    }

    public int getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(int idAttribute) {
        this.idAttribute = idAttribute;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAttribute;
        hash += (int) idProductAttribute;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductAttributeCombinationPK)) {
            return false;
        }
        PsProductAttributeCombinationPK other = (PsProductAttributeCombinationPK) object;
        if (this.idAttribute != other.idAttribute) {
            return false;
        }
        if (this.idProductAttribute != other.idProductAttribute) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductAttributeCombinationPK[ idAttribute=" + idAttribute + ", idProductAttribute=" + idProductAttribute + " ]";
    }
    
}
