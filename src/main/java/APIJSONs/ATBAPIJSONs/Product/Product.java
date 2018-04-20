package APIJSONs.ATBAPIJSONs.Product;

import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;

/**
 * Created by George on 28/03/2018.
 */
public class Product {
    private int id;
    private String textLanguage;
    private String countryCode;
    private String countryName;
    private String cityCode;
    private String cityName;
    private String productTitle;
    private String typeOfProduct;
    private String aPoint;
    private String bPoint;
    private String thumbnailUrl;
    private String categoriesTag;
    private String marchandNetPrice;
    private String currencyCode;
    private boolean onSale;
    private String updatedAt;
    private String stock;
    //private boolean shippable;


//    public boolean isShippable() {
//        return shippable;
//    }
//
//    public void setShippable(boolean shippable) {
//        this.shippable = shippable;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextLanguage() {
        return textLanguage;
    }

    public void setTextLanguage(String textLanguage) {
        this.textLanguage = textLanguage;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public String getaPoint() {
        return aPoint;
    }

    public void setaPoint(String aPoint) {
        this.aPoint = aPoint;
    }

    public String getbPoint() {
        return bPoint;
    }

    public void setbPoint(String bPoint) {
        this.bPoint = bPoint;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getCategoriesTag() {
        return categoriesTag;
    }

    public void setCategoriesTag(String categoriesTag) {
        this.categoriesTag = categoriesTag;
    }

    public String getMarchandNetPrice() {
        return marchandNetPrice;
    }

    public void setMarchandNetPrice(String marchandNetPrice) {
        this.marchandNetPrice = marchandNetPrice;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
