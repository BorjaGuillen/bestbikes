/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.jpa;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author isthar
 */
@Entity
@Table(name = "ps_product_attribute_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductAttributeImage.findAll", query = "SELECT p FROM PsProductAttributeImage p"),
    @NamedQuery(name = "PsProductAttributeImage.findByIdProductAttribute", query = "SELECT p FROM PsProductAttributeImage p WHERE p.psProductAttributeImagePK.idProductAttribute = :idProductAttribute"),
    @NamedQuery(name = "PsProductAttributeImage.findByIdImage", query = "SELECT p FROM PsProductAttributeImage p WHERE p.psProductAttributeImagePK.idImage = :idImage")})
public class PsProductAttributeImage implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductAttributeImagePK psProductAttributeImagePK;

    public PsProductAttributeImage() {
    }

    public PsProductAttributeImage(PsProductAttributeImagePK psProductAttributeImagePK) {
        this.psProductAttributeImagePK = psProductAttributeImagePK;
    }

    public PsProductAttributeImage(int idProductAttribute, int idImage) {
        this.psProductAttributeImagePK = new PsProductAttributeImagePK(idProductAttribute, idImage);
    }

    public PsProductAttributeImagePK getPsProductAttributeImagePK() {
        return psProductAttributeImagePK;
    }

    public void setPsProductAttributeImagePK(PsProductAttributeImagePK psProductAttributeImagePK) {
        this.psProductAttributeImagePK = psProductAttributeImagePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductAttributeImagePK != null ? psProductAttributeImagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductAttributeImage)) {
            return false;
        }
        PsProductAttributeImage other = (PsProductAttributeImage) object;
        if ((this.psProductAttributeImagePK == null && other.psProductAttributeImagePK != null) || (this.psProductAttributeImagePK != null && !this.psProductAttributeImagePK.equals(other.psProductAttributeImagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductAttributeImage[ psProductAttributeImagePK=" + psProductAttributeImagePK + " ]";
    }
    
}
