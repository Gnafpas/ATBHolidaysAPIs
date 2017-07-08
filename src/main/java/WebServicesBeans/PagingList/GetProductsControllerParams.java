package WebServicesBeans.PagingList;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 07/07/2017.
 */
public class GetProductsControllerParams {

    private String text="";
    private Integer firstProduct=0;
    private Integer lastProduct=0;
    private String sortOrder="";
    private Integer destId=0;
    private Integer primaryDestId=0;
    private String country="";
    private String city="";
    private String region="";
    private String code="";
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private List<Integer> categories=new ArrayList<>();
    private List<Integer> subcategories=new ArrayList<>();

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getPrimaryDestId() {
        return primaryDestId;
    }

    public void setPrimaryDestId(Integer primaryDestId) {
        this.primaryDestId = primaryDestId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getDestId() {
        return destId;
    }

    public void setDestId(Integer destId) {
        this.destId = destId;
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

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public List<Integer> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Integer> subcategories) {
        this.subcategories = subcategories;
    }
}
