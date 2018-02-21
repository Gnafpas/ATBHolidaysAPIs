package APIJSONs.ATBAPIJSONs.Hotel;

import java.util.List;

/**
 * Created by George on 05/12/2017.
 */
public class HotelSearchPOST {

    private String currencyCode;
    private String checkInDate="";
    private String checkOutDate="";
    private int numberOfAdults=0;
    private int numberOfRooms=0;
    private List<Integer> childrenAges;
    private int numberOfChildren=0;
    private int infant=0;
    private String mealPlans;
    private String destinationId=null;
    private String customerCountry="";
    private List<Integer> hotelIDs;
    private int searchId=0;
    private String starRatings;
    private String maxPrice;
    private String minPrice;
    private String sortOrder;
    private String sortBy;
    private Integer listStartPosition=0;
    private Integer listLastPosition=30;

    public Integer getListLastPosition() {
        return listLastPosition;
    }

    public void setListLastPosition(Integer listLastPosition) {
        this.listLastPosition = listLastPosition;
    }

    public Integer getListStartPosition() {
        return listStartPosition;
    }

    public void setListStartPosition(Integer listStartPosition) {
        this.listStartPosition = listStartPosition;
    }

    public List<Integer> getChildrenAges() {
        return childrenAges;
    }

    public void setChildrenAges(List<Integer> childrenAges) {
        this.childrenAges = childrenAges;
    }

    public List<Integer> getHotelIDs() {
        return hotelIDs;
    }

    public void setHotelIDs(List<Integer> hotelIDs) {
        this.hotelIDs = hotelIDs;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getInfant() {
        return infant;
    }

    public void setInfant(int infant) {
        this.infant = infant;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMealPlans() {
        return mealPlans;
    }

    public void setMealPlans(String mealPlans) {
        this.mealPlans = mealPlans;
    }

    public String getStarRatings() {
        return starRatings;
    }

    public void setStarRatings(String starRatings) {
        this.starRatings = starRatings;
    }

    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }
}
