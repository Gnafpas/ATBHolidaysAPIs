package Beans.HotelBedsAPIBeans.Hotels;

import java.util.List;

/**
 * Created by George on 12/01/2018.
 */
public class RoomStay {

    private String stayType;
    private String description;
    private String order;
    private List<FacilityList> facilityList;

    public String getStayType() {
        return stayType;
    }

    public void setStayType(String stayType) {
        this.stayType = stayType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public List<FacilityList> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<FacilityList> facilityList) {
        this.facilityList = facilityList;
    }
}
