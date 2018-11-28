package Beans.ATBDBBeans.KalitaonProduct;

import javax.persistence.*;

/**
 * Created by George on 14/09/2017.
 */
@Entity
@Table(name = "a_product_title", schema = "atb_DB", catalog = "")
public class AProductTitleBean {
    private int id;
    private String subId;
    private String productCode;
    private String textLanguage;
    private String countryCode;
    private String countryName;
    private String cityCode;
    private String cityName;
    private String productTitle;
    private String productReferenceCode;
    private String typeOfProduct;
    private String mainSupplierId;
    private String mainSupplierName;
    private String subSupplierId;
    private String subSupplierName;
    private String aPoint;
    private String bPoint;
    private String bookingEngine;
    private String thumbnailUrl;
    private String categoriesTag;
    private String showPrice;
    private String marchandNetPrice;
    private String currencyCode;
    private String sortOrder;
    private String onSale;
    private String reason;
    private String createdAt;
    private String updatedAt;
    private String stock;
    private boolean shippable;
    private boolean updatable;


    public AProductTitleBean () {
        super();
    }
    public AProductTitleBean (boolean init){
        super();
        if (init) {
            this.subId = "";
            this.productCode = "";
            this.textLanguage = "";
            this.countryCode = "";
            this.countryName = "";
            this.cityCode = "";
            this.cityName = "";
            this.productTitle = "";
            this.productReferenceCode = "";
            this.typeOfProduct = "";
            this.mainSupplierId = "";
            this.mainSupplierName = "";
            this.subSupplierId = "";
            this.subSupplierName = "";
            this.aPoint = "";
            this.bPoint = "";
            this.bookingEngine = "";
            this.thumbnailUrl = "";
            this.categoriesTag = "";
            this.showPrice = "";
            this.marchandNetPrice = "";
            this.currencyCode = "";
            this.sortOrder = "";
            this.onSale = "";
            this.reason = "";
            this.createdAt = "";
            this.updatedAt = "";
            this.stock = "";
            this.shippable= false;
            this.updatable= false;
        }

    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sub_id")
    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "text_language")
    public String getTextLanguage() {
        return textLanguage;
    }

    public void setTextLanguage(String textLanguage) {
        this.textLanguage = textLanguage;
    }

    @Basic
    @Column(name = "country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Basic
    @Column(name = "city_code")
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "product_title")
    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    @Basic
    @Column(name = "product_reference_code")
    public String getProductReferenceCode() {
        return productReferenceCode;
    }

    public void setProductReferenceCode(String productReferenceCode) {
        this.productReferenceCode = productReferenceCode;
    }

    @Basic
    @Column(name = "type_of_product")
    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    @Basic
    @Column(name = "main_supplier_id")
    public String getMainSupplierId() {
        return mainSupplierId;
    }

    public void setMainSupplierId(String mainSupplierId) {
        this.mainSupplierId = mainSupplierId;
    }

    @Basic
    @Column(name = "main_supplier_name")
    public String getMainSupplierName() {
        return mainSupplierName;
    }

    public void setMainSupplierName(String mainSupplierName) {
        this.mainSupplierName = mainSupplierName;
    }

    @Basic
    @Column(name = "sub_supplier_id")
    public String getSubSupplierId() {
        return subSupplierId;
    }

    public void setSubSupplierId(String subSupplierId) {
        this.subSupplierId = subSupplierId;
    }

    @Basic
    @Column(name = "sub_supplier_name")
    public String getSubSupplierName() {
        return subSupplierName;
    }

    public void setSubSupplierName(String subSupplierName) {
        this.subSupplierName = subSupplierName;
    }

    @Basic
    @Column(name = "a_point")
    public String getaPoint() {
        return aPoint;
    }

    public void setaPoint(String aPoint) {
        this.aPoint = aPoint;
    }

    @Basic
    @Column(name = "b_point")
    public String getbPoint() {
        return bPoint;
    }

    public void setbPoint(String bPoint) {
        this.bPoint = bPoint;
    }

    @Basic
    @Column(name = "booking_engine")
    public String getBookingEngine() {
        return bookingEngine;
    }

    public void setBookingEngine(String bookingEngine) {
        this.bookingEngine = bookingEngine;
    }

    @Basic
    @Column(name = "thumbnail_url")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Basic
    @Column(name = "categories_tag")
    public String getCategoriesTag() {
        return categoriesTag;
    }

    public void setCategoriesTag(String categoriesTag) {
        this.categoriesTag = categoriesTag;
    }

    @Basic
    @Column(name = "show_price")
    public String getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(String showPrice) {
        this.showPrice = showPrice;
    }

    @Basic
    @Column(name = "marchand_net_price")
    public String getMarchandNetPrice() {
        return marchandNetPrice;
    }

    public void setMarchandNetPrice(String marchandNetPrice) {
        this.marchandNetPrice = marchandNetPrice;
    }

    @Basic
    @Column(name = "currency_code")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Basic
    @Column(name = "sort_order")
    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Basic
    @Column(name = "on_sale")
    public String getOnSale() {
        return onSale;
    }

    public void setOnSale(String onSale) {
        this.onSale = onSale;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "stock")
    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "shippable")
    public boolean isShippable() {
        return shippable;
    }

    public void setShippable(boolean shippable) {
        this.shippable = shippable;
    }

    @Basic
    @Column(name = "updatable")
    public boolean isUpdatable() {
        return updatable;
    }

    public void setUpdatable(boolean updatable) {
        this.updatable = updatable;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AProductTitleBean that = (AProductTitleBean) o;

        if (id != that.id) return false;
        if (subId != null ? !subId.equals(that.subId) : that.subId != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (textLanguage != null ? !textLanguage.equals(that.textLanguage) : that.textLanguage != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        if (cityCode != null ? !cityCode.equals(that.cityCode) : that.cityCode != null) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;
        if (productTitle != null ? !productTitle.equals(that.productTitle) : that.productTitle != null) return false;
        if (productReferenceCode != null ? !productReferenceCode.equals(that.productReferenceCode) : that.productReferenceCode != null)
            return false;
        if (typeOfProduct != null ? !typeOfProduct.equals(that.typeOfProduct) : that.typeOfProduct != null)
            return false;
        if (mainSupplierId != null ? !mainSupplierId.equals(that.mainSupplierId) : that.mainSupplierId != null)
            return false;
        if (mainSupplierName != null ? !mainSupplierName.equals(that.mainSupplierName) : that.mainSupplierName != null)
            return false;
        if (subSupplierId != null ? !subSupplierId.equals(that.subSupplierId) : that.subSupplierId != null)
            return false;
        if (subSupplierName != null ? !subSupplierName.equals(that.subSupplierName) : that.subSupplierName != null)
            return false;
        if (aPoint != null ? !aPoint.equals(that.aPoint) : that.aPoint != null) return false;
        if (bPoint != null ? !bPoint.equals(that.bPoint) : that.bPoint != null) return false;
        if (bookingEngine != null ? !bookingEngine.equals(that.bookingEngine) : that.bookingEngine != null)
            return false;
        if (thumbnailUrl != null ? !thumbnailUrl.equals(that.thumbnailUrl) : that.thumbnailUrl != null) return false;
        if (categoriesTag != null ? !categoriesTag.equals(that.categoriesTag) : that.categoriesTag != null)
            return false;
        if (showPrice != null ? !showPrice.equals(that.showPrice) : that.showPrice != null) return false;
        if (marchandNetPrice != null ? !marchandNetPrice.equals(that.marchandNetPrice) : that.marchandNetPrice != null)
            return false;
        if (currencyCode != null ? !currencyCode.equals(that.currencyCode) : that.currencyCode != null) return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;
        if (onSale != null ? !onSale.equals(that.onSale) : that.onSale != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        if (shippable != that.shippable) return false;
        if (updatable != that.updatable) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subId != null ? subId.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (textLanguage != null ? textLanguage.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (cityCode != null ? cityCode.hashCode() : 0);
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (productTitle != null ? productTitle.hashCode() : 0);
        result = 31 * result + (productReferenceCode != null ? productReferenceCode.hashCode() : 0);
        result = 31 * result + (typeOfProduct != null ? typeOfProduct.hashCode() : 0);
        result = 31 * result + (mainSupplierId != null ? mainSupplierId.hashCode() : 0);
        result = 31 * result + (mainSupplierName != null ? mainSupplierName.hashCode() : 0);
        result = 31 * result + (subSupplierId != null ? subSupplierId.hashCode() : 0);
        result = 31 * result + (subSupplierName != null ? subSupplierName.hashCode() : 0);
        result = 31 * result + (aPoint != null ? aPoint.hashCode() : 0);
        result = 31 * result + (bPoint != null ? bPoint.hashCode() : 0);
        result = 31 * result + (bookingEngine != null ? bookingEngine.hashCode() : 0);
        result = 31 * result + (thumbnailUrl != null ? thumbnailUrl.hashCode() : 0);
        result = 31 * result + (categoriesTag != null ? categoriesTag.hashCode() : 0);
        result = 31 * result + (showPrice != null ? showPrice.hashCode() : 0);
        result = 31 * result + (marchandNetPrice != null ? marchandNetPrice.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + (onSale != null ? onSale.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (shippable ? 1 : 0);
        result = 31 * result + (updatable ? 1 : 0);
        return result;
    }
}
