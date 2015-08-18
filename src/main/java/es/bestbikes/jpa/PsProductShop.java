/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.bestbikes.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author isthar
 */
@Entity
@Table(name = "ps_product_shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductShop.findAll", query = "SELECT p FROM PsProductShop p"),
    @NamedQuery(name = "PsProductShop.findByIdProduct", query = "SELECT p FROM PsProductShop p WHERE p.psProductShopPK.idProduct = :idProduct"),
    @NamedQuery(name = "PsProductShop.findByIdShop", query = "SELECT p FROM PsProductShop p WHERE p.psProductShopPK.idShop = :idShop"),
    @NamedQuery(name = "PsProductShop.findByIdCategoryDefault", query = "SELECT p FROM PsProductShop p WHERE p.idCategoryDefault = :idCategoryDefault"),
    @NamedQuery(name = "PsProductShop.findByIdTaxRulesGroup", query = "SELECT p FROM PsProductShop p WHERE p.idTaxRulesGroup = :idTaxRulesGroup"),
    @NamedQuery(name = "PsProductShop.findByOnSale", query = "SELECT p FROM PsProductShop p WHERE p.onSale = :onSale"),
    @NamedQuery(name = "PsProductShop.findByOnlineOnly", query = "SELECT p FROM PsProductShop p WHERE p.onlineOnly = :onlineOnly"),
    @NamedQuery(name = "PsProductShop.findByEcotax", query = "SELECT p FROM PsProductShop p WHERE p.ecotax = :ecotax"),
    @NamedQuery(name = "PsProductShop.findByMinimalQuantity", query = "SELECT p FROM PsProductShop p WHERE p.minimalQuantity = :minimalQuantity"),
    @NamedQuery(name = "PsProductShop.findByPrice", query = "SELECT p FROM PsProductShop p WHERE p.price = :price"),
    @NamedQuery(name = "PsProductShop.findByWholesalePrice", query = "SELECT p FROM PsProductShop p WHERE p.wholesalePrice = :wholesalePrice"),
    @NamedQuery(name = "PsProductShop.findByUnity", query = "SELECT p FROM PsProductShop p WHERE p.unity = :unity"),
    @NamedQuery(name = "PsProductShop.findByUnitPriceRatio", query = "SELECT p FROM PsProductShop p WHERE p.unitPriceRatio = :unitPriceRatio"),
    @NamedQuery(name = "PsProductShop.findByAdditionalShippingCost", query = "SELECT p FROM PsProductShop p WHERE p.additionalShippingCost = :additionalShippingCost"),
    @NamedQuery(name = "PsProductShop.findByCustomizable", query = "SELECT p FROM PsProductShop p WHERE p.customizable = :customizable"),
    @NamedQuery(name = "PsProductShop.findByUploadableFiles", query = "SELECT p FROM PsProductShop p WHERE p.uploadableFiles = :uploadableFiles"),
    @NamedQuery(name = "PsProductShop.findByTextFields", query = "SELECT p FROM PsProductShop p WHERE p.textFields = :textFields"),
    @NamedQuery(name = "PsProductShop.findByActive", query = "SELECT p FROM PsProductShop p WHERE p.active = :active"),
    @NamedQuery(name = "PsProductShop.findByRedirectType", query = "SELECT p FROM PsProductShop p WHERE p.redirectType = :redirectType"),
    @NamedQuery(name = "PsProductShop.findByIdProductRedirected", query = "SELECT p FROM PsProductShop p WHERE p.idProductRedirected = :idProductRedirected"),
    @NamedQuery(name = "PsProductShop.findByAvailableForOrder", query = "SELECT p FROM PsProductShop p WHERE p.availableForOrder = :availableForOrder"),
    @NamedQuery(name = "PsProductShop.findByAvailableDate", query = "SELECT p FROM PsProductShop p WHERE p.availableDate = :availableDate"),
    @NamedQuery(name = "PsProductShop.findByCondition", query = "SELECT p FROM PsProductShop p WHERE p.condition = :condition"),
    @NamedQuery(name = "PsProductShop.findByShowPrice", query = "SELECT p FROM PsProductShop p WHERE p.showPrice = :showPrice"),
    @NamedQuery(name = "PsProductShop.findByIndexed", query = "SELECT p FROM PsProductShop p WHERE p.indexed = :indexed"),
    @NamedQuery(name = "PsProductShop.findByVisibility", query = "SELECT p FROM PsProductShop p WHERE p.visibility = :visibility"),
    @NamedQuery(name = "PsProductShop.findByCacheDefaultAttribute", query = "SELECT p FROM PsProductShop p WHERE p.cacheDefaultAttribute = :cacheDefaultAttribute"),
    @NamedQuery(name = "PsProductShop.findByAdvancedStockManagement", query = "SELECT p FROM PsProductShop p WHERE p.advancedStockManagement = :advancedStockManagement"),
    @NamedQuery(name = "PsProductShop.findByDateAdd", query = "SELECT p FROM PsProductShop p WHERE p.dateAdd = :dateAdd"),
    @NamedQuery(name = "PsProductShop.findByDateUpd", query = "SELECT p FROM PsProductShop p WHERE p.dateUpd = :dateUpd"),
    @NamedQuery(name = "PsProductShop.findByPackStockType", query = "SELECT p FROM PsProductShop p WHERE p.packStockType = :packStockType")})
public class PsProductShop implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductShopPK psProductShopPK;
    @Column(name = "id_category_default")
    private Integer idCategoryDefault;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tax_rules_group")
    private int idTaxRulesGroup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "on_sale")
    private boolean onSale;
    @Basic(optional = false)
    @NotNull
    @Column(name = "online_only")
    private boolean onlineOnly;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ecotax")
    private BigDecimal ecotax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "minimal_quantity")
    private int minimalQuantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "wholesale_price")
    private BigDecimal wholesalePrice;
    @Size(max = 255)
    @Column(name = "unity")
    private String unity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_price_ratio")
    private BigDecimal unitPriceRatio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "additional_shipping_cost")
    private BigDecimal additionalShippingCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customizable")
    private short customizable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uploadable_files")
    private short uploadableFiles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "text_fields")
    private short textFields;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "redirect_type")
    private String redirectType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_product_redirected")
    private int idProductRedirected;
    @Basic(optional = false)
    @NotNull
    @Column(name = "available_for_order")
    private boolean availableForOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "available_date")
    @Temporal(TemporalType.DATE)
    private Date availableDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "condition")
    private String condition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_price")
    private boolean showPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "indexed")
    private boolean indexed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "visibility")
    private String visibility;
    @Column(name = "cache_default_attribute")
    private Integer cacheDefaultAttribute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "advanced_stock_management")
    private boolean advancedStockManagement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pack_stock_type")
    private int packStockType;

    public PsProductShop() {
    }

    public PsProductShop(PsProductShopPK psProductShopPK) {
        this.psProductShopPK = psProductShopPK;
    }

    public PsProductShop(PsProductShopPK psProductShopPK, int idTaxRulesGroup, boolean onSale, boolean onlineOnly, BigDecimal ecotax, int minimalQuantity, BigDecimal price, BigDecimal wholesalePrice, BigDecimal unitPriceRatio, BigDecimal additionalShippingCost, short customizable, short uploadableFiles, short textFields, boolean active, String redirectType, int idProductRedirected, boolean availableForOrder, Date availableDate, String condition, boolean showPrice, boolean indexed, String visibility, boolean advancedStockManagement, Date dateAdd, Date dateUpd, int packStockType) {
        this.psProductShopPK = psProductShopPK;
        this.idTaxRulesGroup = idTaxRulesGroup;
        this.onSale = onSale;
        this.onlineOnly = onlineOnly;
        this.ecotax = ecotax;
        this.minimalQuantity = minimalQuantity;
        this.price = price;
        this.wholesalePrice = wholesalePrice;
        this.unitPriceRatio = unitPriceRatio;
        this.additionalShippingCost = additionalShippingCost;
        this.customizable = customizable;
        this.uploadableFiles = uploadableFiles;
        this.textFields = textFields;
        this.active = active;
        this.redirectType = redirectType;
        this.idProductRedirected = idProductRedirected;
        this.availableForOrder = availableForOrder;
        this.availableDate = availableDate;
        this.condition = condition;
        this.showPrice = showPrice;
        this.indexed = indexed;
        this.visibility = visibility;
        this.advancedStockManagement = advancedStockManagement;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.packStockType = packStockType;
    }

    public PsProductShop(int idProduct, int idShop) {
        this.psProductShopPK = new PsProductShopPK(idProduct, idShop);
    }

    public PsProductShopPK getPsProductShopPK() {
        return psProductShopPK;
    }

    public void setPsProductShopPK(PsProductShopPK psProductShopPK) {
        this.psProductShopPK = psProductShopPK;
    }

    public Integer getIdCategoryDefault() {
        return idCategoryDefault;
    }

    public void setIdCategoryDefault(Integer idCategoryDefault) {
        this.idCategoryDefault = idCategoryDefault;
    }

    public int getIdTaxRulesGroup() {
        return idTaxRulesGroup;
    }

    public void setIdTaxRulesGroup(int idTaxRulesGroup) {
        this.idTaxRulesGroup = idTaxRulesGroup;
    }

    public boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public boolean getOnlineOnly() {
        return onlineOnly;
    }

    public void setOnlineOnly(boolean onlineOnly) {
        this.onlineOnly = onlineOnly;
    }

    public BigDecimal getEcotax() {
        return ecotax;
    }

    public void setEcotax(BigDecimal ecotax) {
        this.ecotax = ecotax;
    }

    public int getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(int minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public BigDecimal getUnitPriceRatio() {
        return unitPriceRatio;
    }

    public void setUnitPriceRatio(BigDecimal unitPriceRatio) {
        this.unitPriceRatio = unitPriceRatio;
    }

    public BigDecimal getAdditionalShippingCost() {
        return additionalShippingCost;
    }

    public void setAdditionalShippingCost(BigDecimal additionalShippingCost) {
        this.additionalShippingCost = additionalShippingCost;
    }

    public short getCustomizable() {
        return customizable;
    }

    public void setCustomizable(short customizable) {
        this.customizable = customizable;
    }

    public short getUploadableFiles() {
        return uploadableFiles;
    }

    public void setUploadableFiles(short uploadableFiles) {
        this.uploadableFiles = uploadableFiles;
    }

    public short getTextFields() {
        return textFields;
    }

    public void setTextFields(short textFields) {
        this.textFields = textFields;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(String redirectType) {
        this.redirectType = redirectType;
    }

    public int getIdProductRedirected() {
        return idProductRedirected;
    }

    public void setIdProductRedirected(int idProductRedirected) {
        this.idProductRedirected = idProductRedirected;
    }

    public boolean getAvailableForOrder() {
        return availableForOrder;
    }

    public void setAvailableForOrder(boolean availableForOrder) {
        this.availableForOrder = availableForOrder;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(boolean showPrice) {
        this.showPrice = showPrice;
    }

    public boolean getIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Integer getCacheDefaultAttribute() {
        return cacheDefaultAttribute;
    }

    public void setCacheDefaultAttribute(Integer cacheDefaultAttribute) {
        this.cacheDefaultAttribute = cacheDefaultAttribute;
    }

    public boolean getAdvancedStockManagement() {
        return advancedStockManagement;
    }

    public void setAdvancedStockManagement(boolean advancedStockManagement) {
        this.advancedStockManagement = advancedStockManagement;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    public int getPackStockType() {
        return packStockType;
    }

    public void setPackStockType(int packStockType) {
        this.packStockType = packStockType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductShopPK != null ? psProductShopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductShop)) {
            return false;
        }
        PsProductShop other = (PsProductShop) object;
        if ((this.psProductShopPK == null && other.psProductShopPK != null) || (this.psProductShopPK != null && !this.psProductShopPK.equals(other.psProductShopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProductShop[ psProductShopPK=" + psProductShopPK + " ]";
    }
    
}
