package APIJSONs.ATBAPIJSONs.HotelATBFrontEnd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 14/12/2017.
 */
public class SunhotelsBookPOST {

    private String currency;
    private String checkInDate;
    private String checkOutDate;
    private int rooms;
    private int infant;
    private int mealId;
    private String customerCountry;
    private int roomId;
    private String hotelId;
    private String email;
    private String prebookcode;
    private List<Adult> adults;
    private List<Children> children;

    public String getPrebookcode() {
        return prebookcode;
    }

    public void setPrebookcode(String prebookcode) {
        this.prebookcode = prebookcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Adult> getAdults() {
        return adults;
    }

    public void setAdults(List<Adult> adults) {
        this.adults = adults;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
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


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
