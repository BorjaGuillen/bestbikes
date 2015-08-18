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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ps_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProduct.findAll", query = "SELECT p FROM PsProduct p"),
    @NamedQuery(name = "PsProduct.findByIdProduct", query = "SELECT p FROM PsProduct p WHERE p.idProduct = :idProduct"),
    @NamedQuery(name = "PsProduct.findByIdSupplier", query = "SELECT p FROM PsProduct p WHERE p.idSupplier = :idSupplier"),
    @NamedQuery(name = "PsProduct.findByIdManufacturer", query = "SELECT p FROM PsProduct p WHERE p.idManufacturer = :idManufacturer"),
    @NamedQuery(name = "PsProduct.findByIdCategoryDefault", query = "SELECT p FROM PsProduct p WHERE p.idCategoryDefault = :idCategoryDefault"),
    @NamedQuery(name = "PsProduct.findByIdShopDefault", query = "SELECT p FROM PsProduct p WHERE p.idShopDefault = :idShopDefault"),
    @NamedQuery(name = "PsProduct.findByIdTaxRulesGroup", query = "SELECT p FROM PsProduct p WHERE p.idTaxRulesGroup = :idTaxRulesGroup"),
    @NamedQuery(name = "PsProduct.findByOnSale", query = "SELECT p FROM PsProduct p WHERE p.onSale = :onSale"),
    @NamedQuery(name = "PsProduct.findByOnlineOnly", query = "SELECT p FROM PsProduct p WHERE p.onlineOnly = :onlineOnly"),
    @NamedQuery(name = "PsProduct.findByEan13", query = "SELECT p FROM PsProduct p WHERE p.ean13 = :ean13"),
    @NamedQuery(name = "PsProduct.findByUpc", query = "SELECT p FROM PsProduct p WHERE p.upc = :upc"),
    @NamedQuery(name = "PsProduct.findByEcotax", query = "SELECT p FROM PsProduct p WHERE p.ecotax = :ecotax"),
    @NamedQuery(name = "PsProduct.findByQuantity", query = "SELECT p FROM PsProduct p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "PsProduct.findByMinimalQuantity", query = "SELECT p FROM PsProduct p WHERE p.minimalQuantity = :minimalQuantity"),
    @NamedQuery(name = "PsProduct.findByPrice", query = "SELECT p FROM PsProduct p WHERE p.price = :price"),
    @NamedQuery(name = "PsProduct.findByWholesalePrice", query = "SELECT p FROM PsProduct p WHERE p.wholesalePrice = :wholesalePrice"),
    @NamedQuery(name = "PsProduct.findByUnity", query = "SELECT p FROM PsProduct p WHERE p.unity = :unity"),
    @NamedQuery(name = "PsProduct.findByUnitPriceRatio", query = "SELECT p FROM PsProduct p WHERE p.unitPriceRatio = :unitPriceRatio"),
    @NamedQuery(name = "PsProduct.findByAdditionalShippingCost", query = "SELECT p FROM PsProduct p WHERE p.additionalShippingCost = :additionalShippingCost"),
    @NamedQuery(name = "PsProduct.findByReference", query = "SELECT p FROM PsProduct p WHERE p.reference = :reference"),
    @NamedQuery(name = "PsProduct.findBySupplierReference", query = "SELECT p FROM PsProduct p WHERE p.supplierReference = :supplierReference"),
    @NamedQuery(name = "PsProduct.findByLocation", query = "SELECT p FROM PsProduct p WHERE p.location = :location"),
    @NamedQuery(name = "PsProduct.findByWidth", query = "SELECT p FROM PsProduct p WHERE p.width = :width"),
    @NamedQuery(name = "PsProduct.findByHeight", query = "SELECT p FROM PsProduct p WHERE p.height = :height"),
    @NamedQuery(name = "PsProduct.findByDepth", query = "SELECT p FROM PsProduct p WHERE p.depth = :depth"),
    @NamedQuery(name = "PsProduct.findByWeight", query = "SELECT p FROM PsProduct p WHERE p.weight = :weight"),
    @NamedQuery(name = "PsProduct.findByOutOfStock", query = "SELECT p FROM PsProduct p WHERE p.outOfStock = :outOfStock"),
    @NamedQuery(name = "PsProduct.findByQuantityDiscount", query = "SELECT p FROM PsProduct p WHERE p.quantityDiscount = :quantityDiscount"),
    @NamedQuery(name = "PsProduct.findByCustomizable", query = "SELECT p FROM PsProduct p WHERE p.customizable = :customizable"),
    @NamedQuery(name = "PsProduct.findByUploadableFiles", query = "SELECT p FROM PsProduct p WHERE p.uploadableFiles = :uploadableFiles"),
    @NamedQuery(name = "PsProduct.findByTextFields", query = "SELECT p FROM PsProduct p WHERE p.textFields = :textFields"),
    @NamedQuery(name = "PsProduct.findByActive", query = "SELECT p FROM PsProduct p WHERE p.active = :active"),
    @NamedQuery(name = "PsProduct.findByRedirectType", query = "SELECT p FROM PsProduct p WHERE p.redirectType = :redirectType"),
    @NamedQuery(name = "PsProduct.findByIdProductRedirected", query = "SELECT p FROM PsProduct p WHERE p.idProductRedirected = :idProductRedirected"),
    @NamedQuery(name = "PsProduct.findByAvailableForOrder", query = "SELECT p FROM PsProduct p WHERE p.availableForOrder = :availableForOrder"),
    @NamedQuery(name = "PsProduct.findByAvailableDate", query = "SELECT p FROM PsProduct p WHERE p.availableDate = :availableDate"),
    @NamedQuery(name = "PsProduct.findByCondition", query = "SELECT p FROM PsProduct p WHERE p.condition = :condition"),
    @NamedQuery(name = "PsProduct.findByShowPrice", query = "SELECT p FROM PsProduct p WHERE p.showPrice = :showPrice"),
    @NamedQuery(name = "PsProduct.findByIndexed", query = "SELECT p FROM PsProduct p WHERE p.indexed = :indexed"),
    @NamedQuery(name = "PsProduct.findByVisibility", query = "SELECT p FROM PsProduct p WHERE p.visibility = :visibility"),
    @NamedQuery(name = "PsProduct.findByCacheIsPack", query = "SELECT p FROM PsProduct p WHERE p.cacheIsPack = :cacheIsPack"),
    @NamedQuery(name = "PsProduct.findByCacheHasAttachments", query = "SELECT p FROM PsProduct p WHERE p.cacheHasAttachments = :cacheHasAttachments"),
    @NamedQuery(name = "PsProduct.findByIsVirtual", query = "SELECT p FROM PsProduct p WHERE p.isVirtual = :isVirtual"),
    @NamedQuery(name = "PsProduct.findByCacheDefaultAttribute", query = "SELECT p FROM PsProduct p WHERE p.cacheDefaultAttribute = :cacheDefaultAttribute"),
    @NamedQuery(name = "PsProduct.findByDateAdd", query = "SELECT p FROM PsProduct p WHERE p.dateAdd = :dateAdd"),
    @NamedQuery(name = "PsProduct.findByDateUpd", query = "SELECT p FROM PsProduct p WHERE p.dateUpd = :dateUpd"),
    @NamedQuery(name = "PsProduct.findByAdvancedStockManagement", query = "SELECT p FROM PsProduct p WHERE p.advancedStockManagement = :advancedStockManagement"),
    @NamedQuery(name = "PsProduct.findByPackStockType", query = "SELECT p FROM PsProduct p WHERE p.packStockType = :packStockType")})
public class PsProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product")
    private Integer idProduct;
    @Column(name = "id_supplier")
    private Integer idSupplier;
    @Column(name = "id_manufacturer")
    private Integer idManufacturer;
    @Column(name = "id_category_default")
    private Integer idCategoryDefault;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_shop_default")
    private int idShopDefault;
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
    @Size(max = 13)
    @Column(name = "ean13")
    private String ean13;
    @Size(max = 12)
    @Column(name = "upc")
    private String upc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ecotax")
    private BigDecimal ecotax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
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
    @Size(max = 32)
    @Column(name = "reference")
    private String reference;
    @Size(max = 32)
    @Column(name = "supplier_reference")
    private String supplierReference;
    @Size(max = 64)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Column(name = "width")
    private BigDecimal width;
    @Basic(optional = false)
    @NotNull
    @Column(name = "height")
    private BigDecimal height;
    @Basic(optional = false)
    @NotNull
    @Column(name = "depth")
    private BigDecimal depth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private BigDecimal weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "out_of_stock")
    private int outOfStock;
    @Column(name = "quantity_discount")
    private Boolean quantityDiscount;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "cache_is_pack")
    private boolean cacheIsPack;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cache_has_attachments")
    private boolean cacheHasAttachments;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_virtual")
    private boolean isVirtual;
    @Column(name = "cache_default_attribute")
    private Integer cacheDefaultAttribute;
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
    @Column(name = "advanced_stock_management")
    private boolean advancedStockManagement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pack_stock_type")
    private int packStockType;

    public PsProduct() {
    }

    public PsProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public PsProduct(Integer idProduct, int idShopDefault, int idTaxRulesGroup, boolean onSale, boolean onlineOnly, BigDecimal ecotax, int quantity, int minimalQuantity, BigDecimal price, BigDecimal wholesalePrice, BigDecimal unitPriceRatio, BigDecimal additionalShippingCost, BigDecimal width, BigDecimal height, BigDecimal depth, BigDecimal weight, int outOfStock, short customizable, short uploadableFiles, short textFields, boolean active, String redirectType, int idProductRedirected, boolean availableForOrder, Date availableDate, String condition, boolean showPrice, boolean indexed, String visibility, boolean cacheIsPack, boolean cacheHasAttachments, boolean isVirtual, Date dateAdd, Date dateUpd, boolean advancedStockManagement, int packStockType) {
        this.idProduct = idProduct;
        this.idShopDefault = idShopDefault;
        this.idTaxRulesGroup = idTaxRulesGroup;
        this.onSale = onSale;
        this.onlineOnly = onlineOnly;
        this.ecotax = ecotax;
        this.quantity = quantity;
        this.minimalQuantity = minimalQuantity;
        this.price = price;
        this.wholesalePrice = wholesalePrice;
        this.unitPriceRatio = unitPriceRatio;
        this.additionalShippingCost = additionalShippingCost;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.weight = weight;
        this.outOfStock = outOfStock;
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
        this.cacheIsPack = cacheIsPack;
        this.cacheHasAttachments = cacheHasAttachments;
        this.isVirtual = isVirtual;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.advancedStockManagement = advancedStockManagement;
        this.packStockType = packStockType;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }

    public Integer getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(Integer idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public Integer getIdCategoryDefault() {
        return idCategoryDefault;
    }

    public void setIdCategoryDefault(Integer idCategoryDefault) {
        this.idCategoryDefault = idCategoryDefault;
    }

    public int getIdShopDefault() {
        return idShopDefault;
    }

    public void setIdShopDefault(int idShopDefault) {
        this.idShopDefault = idShopDefault;
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

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public BigDecimal getEcotax() {
        return ecotax;
    }

    public void setEcotax(BigDecimal ecotax) {
        this.ecotax = ecotax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public int getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(int outOfStock) {
        this.outOfStock = outOfStock;
    }

    public Boolean getQuantityDiscount() {
        return quantityDiscount;
    }

    public void setQuantityDiscount(Boolean quantityDiscount) {
        this.quantityDiscount = quantityDiscount;
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

    public boolean getCacheIsPack() {
        return cacheIsPack;
    }

    public void setCacheIsPack(boolean cacheIsPack) {
        this.cacheIsPack = cacheIsPack;
    }

    public boolean getCacheHasAttachments() {
        return cacheHasAttachments;
    }

    public void setCacheHasAttachments(boolean cacheHasAttachments) {
        this.cacheHasAttachments = cacheHasAttachments;
    }

    public boolean getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(boolean isVirtual) {
        this.isVirtual = isVirtual;
    }

    public Integer getCacheDefaultAttribute() {
        return cacheDefaultAttribute;
    }

    public void setCacheDefaultAttribute(Integer cacheDefaultAttribute) {
        this.cacheDefaultAttribute = cacheDefaultAttribute;
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

    public boolean getAdvancedStockManagement() {
        return advancedStockManagement;
    }

    public void setAdvancedStockManagement(boolean advancedStockManagement) {
        this.advancedStockManagement = advancedStockManagement;
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
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProduct)) {
            return false;
        }
        PsProduct other = (PsProduct) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.bestbikes.jpa.PsProduct[ idProduct=" + idProduct + " ]";
    }
    
}
