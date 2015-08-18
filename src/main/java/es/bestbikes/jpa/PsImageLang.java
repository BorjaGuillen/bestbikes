/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author isthar
 */
@Entity
@Table(name = "ps_image_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsImageLang.findAll", query = "SELECT p FROM PsImageLang p"),
    @NamedQuery(name = "PsImageLang.findByIdImage", query = "SELECT p FROM PsImageLang p WHERE p.psImageLangPK.idImage = :idImage"),
    @NamedQuery(name = "PsImageLang.findByIdLang", query = "SELECT p FROM PsImageLang p WHERE p.psImageLangPK.idLang = :idLang"),
    @NamedQuery(name = "PsImageLang.findByLegend", query = "SELECT p FROM PsImageLang p WHERE p.legend = :legend")})
public class PsImageLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsImageLangPK psImageLangPK;
    @Size(max = 128)
    @Column(name = "legend")
    private String legend;

    public PsImageLang() {
    }

    public PsImageLang(PsImageLangPK psImageLangPK) {
        this.psImageLangPK = psImageLangPK;
    }

    public PsImageLang(int idImage, int idLang) {
        this.psImageLangPK = new PsImageLangPK(idImage, idLang);
    }

    public PsImageLangPK getPsImageLangPK() {
        return psImageLangPK;
    }

    public void setPsImageLangPK(PsImageLangPK psImageLangPK) {
        this.psImageLangPK = psImageLangPK;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psImageLangPK != null ? psImageLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsImageLang)) {
            return false;
        }
        PsImageLang other = (PsImageLang) object;
        if ((this.psImageLangPK == null && other.psImageLangPK != null) || (this.psImageLangPK != null && !this.psImageLangPK.equals(other.psImageLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsImageLang[ psImageLangPK=" + psImageLangPK + " ]";
    }
    
}
