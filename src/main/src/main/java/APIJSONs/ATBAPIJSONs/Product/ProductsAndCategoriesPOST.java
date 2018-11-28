package APIJSONs.ATBAPIJSONs.Product;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 07/07/2017.
 */
public class ProductsAndCategoriesPOST {

    private String title="";
    private Integer firstProduct=0;
    private Integer lastProduct=100;
    private String countryCode="";
    private String cityCode="";
    private int priceFrom=0;
    private int priceTo=0;
    private String country="";
    private String city="";
    private int productId=0;
    private String startDate=null;
    private String endDate=null;
    private int typeOfProduct=0;
    private boolean onlyOnsaleProducts=false;
    private List<String> categories=new ArrayList<>();
    private String currencyCode="";


    public boolean isOnlyOnsaleProducts() {
        return onlyOnsaleProducts;
    }

    public void setOnlyOnsaleProducts(boolean onlyOnsaleProducts) {
        this.onlyOnsaleProducts = onlyOnsaleProducts;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(int typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    public int getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(int priceFrom) {
        this.priceFrom = priceFrom;
    }

    public int getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(int priceTo) {
        this.priceTo = priceTo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getFirstProduct() {
        return firstProduct;
    }

    public void setFirstProduct(Integer firstProduct) {
        this.firstProduct = firstProduct;
    }

    public Integer getLastProduct() {
        return lastProduct;
    }

    public void setLastProduct(Integer lastProduct) {
        this.lastProduct = lastProduct;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }


}
