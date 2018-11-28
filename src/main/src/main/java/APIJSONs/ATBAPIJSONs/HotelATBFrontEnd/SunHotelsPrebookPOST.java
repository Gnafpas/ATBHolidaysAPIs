package APIJSONs.ATBAPIJSONs.HotelATBFrontEnd;

import java.util.List;

/**
 * Created by George on 28/11/2017.
 */
public class SunHotelsPrebookPOST {
    private String currency;
    private String checkInDate;
    private String checkOutDate;
    private int rooms;
    private int adults;
    private int children;
    private String childrenAges="";
    private int infant;
    private int mealId;
    private String customerCountry;
    private String searchPrice;
    private String roomtypeId;
    private String blockSuperDeal;
    private String hotelId;
    private String showPriceBreakdown;


    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getChildrenAges() {
        return childrenAges;
    }

    public void setChildrenAges(String childrenAges) {
        this.childrenAges = childrenAges;
    }

    public int getInfant() {
        return infant;
    }

    public void setInfant(int infant) {
        this.infant = infant;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getSearchPrice() {
        return searchPrice;
    }

    public void setSearchPrice(String searchPrice) {
        this.searchPrice = searchPrice;
    }

    public String getRoomtypeId() {
        return roomtypeId;
    }

    public void setRoomtypeId(String roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    public String getBlockSuperDeal() {
        return blockSuperDeal;
    }

    public void setBlockSuperDeal(String blockSuperDeal) {
        this.blockSuperDeal = blockSuperDeal;
    }

    public String getShowPriceBreakdown() {
        return showPriceBreakdown;
    }

    public void setShowPriceBreakdown(String showPriceBreakdown) {
        this.showPriceBreakdown = showPriceBreakdown;
    }
}
