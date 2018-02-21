package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 20/12/2017.
 */
@Entity
@Table(name = "search_log", schema = "Sunhotels", catalog = "")
public class SearchLogBean {
    private int searchId;
    private String request;
    private String response;
    private Integer currentDisplayedHotels;
    private String currentSortOrder;
    private String currentSortBy;
    private String currentDistricts;
    private String currentStarRatings;
    private String currentMealPlans;
    private String currentMinPrice;
    private String currentMaxPrice;

    @Id
    @Column(name = "search_id")
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
    @Column(name = "current_displayed_hotels")
    public Integer getCurrentDisplayedHotels() {
        return currentDisplayedHotels;
    }

    public void setCurrentDisplayedHotels(Integer currentDisplayedHotels) {
        this.currentDisplayedHotels = currentDisplayedHotels;
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
    @Column(name = "current_star_ratings")
    public String getCurrentStarRatings() {
        return currentStarRatings;
    }

    public void setCurrentStarRatings(String currentStarRatings) {
        this.currentStarRatings = currentStarRatings;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchLogBean that = (SearchLogBean) o;

        if (searchId != that.searchId) return false;
        if (request != null ? !request.equals(that.request) : that.request != null) return false;
        if (response != null ? !response.equals(that.response) : that.response != null) return false;
        if (currentDisplayedHotels != null ? !currentDisplayedHotels.equals(that.currentDisplayedHotels) : that.currentDisplayedHotels != null)
            return false;
        if (currentSortOrder != null ? !currentSortOrder.equals(that.currentSortOrder) : that.currentSortOrder != null)
            return false;
        if (currentSortBy != null ? !currentSortBy.equals(that.currentSortBy) : that.currentSortBy != null)
            return false;
        if (currentDistricts != null ? !currentDistricts.equals(that.currentDistricts) : that.currentDistricts != null)
            return false;
        if (currentStarRatings != null ? !currentStarRatings.equals(that.currentStarRatings) : that.currentStarRatings != null)
            return false;
        if (currentMealPlans != null ? !currentMealPlans.equals(that.currentMealPlans) : that.currentMealPlans != null)
            return false;
        if (currentMinPrice != null ? !currentMinPrice.equals(that.currentMinPrice) : that.currentMinPrice != null)
            return false;
        if (currentMaxPrice != null ? !currentMaxPrice.equals(that.currentMaxPrice) : that.currentMaxPrice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = searchId;
        result = 31 * result + (request != null ? request.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (currentDisplayedHotels != null ? currentDisplayedHotels.hashCode() : 0);
        result = 31 * result + (currentSortOrder != null ? currentSortOrder.hashCode() : 0);
        result = 31 * result + (currentSortBy != null ? currentSortBy.hashCode() : 0);
        result = 31 * result + (currentDistricts != null ? currentDistricts.hashCode() : 0);
        result = 31 * result + (currentStarRatings != null ? currentStarRatings.hashCode() : 0);
        result = 31 * result + (currentMealPlans != null ? currentMealPlans.hashCode() : 0);
        result = 31 * result + (currentMinPrice != null ? currentMinPrice.hashCode() : 0);
        result = 31 * result + (currentMaxPrice != null ? currentMaxPrice.hashCode() : 0);
        return result;
    }
}
