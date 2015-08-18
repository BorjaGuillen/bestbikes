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
@Table(name = "ps_product_tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductTag.findAll", query = "SELECT p FROM PsProductTag p"),
    @NamedQuery(name = "PsProductTag.findByIdProduct", query = "SELECT p FROM PsProductTag p WHERE p.psProductTagPK.idProduct = :idProduct"),
    @NamedQuery(name = "PsProductTag.findByIdTag", query = "SELECT p FROM PsProductTag p WHERE p.psProductTagPK.idTag = :idTag")})
public class PsProductTag implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductTagPK psProductTagPK;

    public PsProductTag() {
    }

    public PsProductTag(PsProductTagPK psProductTagPK) {
        this.psProductTagPK = psProductTagPK;
    }

    public PsProductTag(int idProduct, int idTag) {
        this.psProductTagPK = new PsProductTagPK(idProduct, idTag);
    }

    public PsProductTagPK getPsProductTagPK() {
        return psProductTagPK;
    }

    public void setPsProductTagPK(PsProductTagPK psProductTagPK) {
        this.psProductTagPK = psProductTagPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductTagPK != null ? psProductTagPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductTag)) {
            return false;
        }
        PsProductTag other = (PsProductTag) object;
        if ((this.psProductTagPK == null && other.psProductTagPK != null) || (this.psProductTagPK != null && !this.psProductTagPK.equals(other.psProductTagPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductTag[ psProductTagPK=" + psProductTagPK + " ]";
    }
    
}
