package Beans.TravelGateXBeans;

import java.util.List;

/**
 * Created by George on 16/07/2018.
 */
public class RoomSearchData {

    private String code;
    private String description;
    private boolean refundable;
    private Integer units;
    private RoomPrice roomPrice;
    private List<Bed> beds;
    private List<RatePlan> ratePlans;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public RoomPrice getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(RoomPrice roomPrice) {
        this.roomPrice = roomPrice;
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    public List<RatePlan> getRatePlans() {
        return ratePlans;
    }

    public void setRatePlans(List<RatePlan> ratePlans) {
        this.ratePlans = ratePlans;
    }
}
