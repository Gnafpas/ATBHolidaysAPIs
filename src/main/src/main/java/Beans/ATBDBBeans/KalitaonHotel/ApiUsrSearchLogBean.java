package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 27/12/2017.
 */
@Entity
@Table(name = "api_usr_search_log", schema = "Sunhotels", catalog = "")
public class ApiUsrSearchLogBean {
    private int searchId;
    private String request;
    private String response;
    private String currentSortOrder;
    private String currentSortBy;
    private String currentDistricts;
    private String currentMinStarRating;
    private String currentMaxStarRating;
    private String currentMealPlans;
    private String currentMinPrice;
    private String currentMaxPrice;
    private String clientApiKey;

    @Id
    @Column(name = "search_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    @Basic
    @Column(name = "request")
    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Basic
    @Column(name = "response")
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Basic
    @Column(name = "current_sort_order")
    public String getCurrentSortOrder() {
        return currentSortOrder;
    }

    public void setCurrentSortOrder(String currentSortOrder) {
        this.currentSortOrder = currentSortOrder;
    }

    @Basic
    @Column(name = "current_sort_by")
    public String getCurrentSortBy() {
        return currentSortBy;
    }

    public void setCurrentSortBy(String currentSortBy) {
        this.currentSortBy = currentSortBy;
    }

    @Basic
    @Column(name = "current_districts")
    public String getCurrentDistricts() {
        return currentDistricts;
    }

    public void setCurrentDistricts(String currentDistricts) {
        this.currentDistricts = currentDistricts;
    }

    @Basic
    @Column(name = "current_min_star_rating")
    public String getCurrentMinStarRating() {
        return currentMinStarRating;
    }

    public void setCurrentMinStarRating(String currentMinStarRating) {
        this.currentMinStarRating = currentMinStarRating;
    }

    @Basic
    @Column(name = "current_max_star_rating")
    public String getCurrentMaxStarRating() {
        return currentMaxStarRating;
    }

    public void setCurrentMaxStarRating(String currentMaxStarRating) {
        this.currentMaxStarRating = currentMaxStarRating;
    }




    @Basic
    @Column(name = "current_meal_plans")
    public String getCurrentMealPlans() {
        return currentMealPlans;
    }

    public void setCurrentMealPlans(String currentMealPlans) {
        this.currentMealPlans = currentMealPlans;
    }

    @Basic
    @Column(name = "current_min_price")
    public String getCurrentMinPrice() {
        return currentMinPrice;
    }

    public void setCurrentMinPrice(String currentMinPrice) {
        this.currentMinPrice = currentMinPrice;
    }

    @Basic
    @Column(name = "current_max_price")
    public String getCurrentMaxPrice() {
        return currentMaxPrice;
    }

    public void setCurrentMaxPrice(String currentMaxPrice) {
        this.currentMaxPrice = currentMaxPrice;
    }

    @Basic
    @Column(name = "client_api_key")
    public String getClientApiKey() {
        return clientApiKey;
    }

    public void setClientApiKey(String clientApiKey) {
        this.clientApiKey = clientApiKey;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiUsrSearchLogBean that = (ApiUsrSearchLogBean) o;

        if (searchId != that.searchId) return false;
        if (request != null ? !request.equals(that.request) : that.request != null) return false;
        if (response != null ? !response.equals(that.response) : that.response != null) return false;
        if (currentSortOrder != null ? !currentSortOrder.equals(that.currentSortOrder) : that.currentSortOrder != null)
            return false;
        if (currentSortBy != null ? !currentSortBy.equals(that.currentSortBy) : that.currentSortBy != null)
            return false;
        if (currentDistricts != null ? !currentDistricts.equals(that.currentDistricts) : that.currentDistricts != null)
            return false;
        if (currentMinStarRating != null ? !currentMinStarRating.equals(that.currentMinStarRating) : that.currentMinStarRating != null)
            return false;
        if (currentMaxStarRating != null ? !currentMaxStarRating.equals(that.currentMaxStarRating) : that.currentMaxStarRating != null)
            return false;
        if (currentMealPlans != null ? !currentMealPlans.equals(that.currentMealPlans) : that.currentMealPlans != null)
            return false;
        if (currentMinPrice != null ? !currentMinPrice.equals(that.currentMinPrice) : that.currentMinPrice != null)
            return false;
        if (currentMaxPrice != null ? !currentMaxPrice.equals(that.currentMaxPrice) : that.currentMaxPrice != null)
            return false;
        if (clientApiKey != null ? !clientApiKey.equals(that.clientApiKey) : that.clientApiKey != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = searchId;
        result = 31 * result + (request != null ? request.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (currentSortOrder != null ? currentSortOrder.hashCode() : 0);
        result = 31 * result + (currentSortBy != null ? currentSortBy.hashCode() : 0);
        result = 31 * result + (currentDistricts != null ? currentDistricts.hashCode() : 0);
        result = 31 * result + (currentMinStarRating != null ? currentMinStarRating.hashCode() : 0);
        result = 31 * result + (currentMaxStarRating != null ? currentMaxStarRating.hashCode() : 0);
        result = 31 * result + (currentMealPlans != null ? currentMealPlans.hashCode() : 0);
        result = 31 * result + (currentMinPrice != null ? currentMinPrice.hashCode() : 0);
        result = 31 * result + (currentMaxPrice != null ? currentMaxPrice.hashCode() : 0);
        result = 31 * result + (clientApiKey != null ? clientApiKey.hashCode() : 0);
        return result;
    }
}
