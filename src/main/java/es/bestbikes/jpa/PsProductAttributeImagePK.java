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
public class PsProductAttributeImagePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product_attribute")
    private int idProductAttribute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_image")
    private int idImage;

    public PsProductAttributeImagePK() {
    }

    public PsProductAttributeImagePK(int idProductAttribute, int idImage) {
        this.idProductAttribute = idProductAttribute;
        this.idImage = idImage;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProductAttribute;
        hash += (int) idImage;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductAttributeImagePK)) {
            return false;
        }
        PsProductAttributeImagePK other = (PsProductAttributeImagePK) object;
        if (this.idProductAttribute != other.idProductAttribute) {
            return false;
        }
        if (this.idImage != other.idImage) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductAttributeImagePK[ idProductAttribute=" + idProductAttribute + ", idImage=" + idImage + " ]";
    }
    
}
