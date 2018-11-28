package APIJSONs.ATBAPIJSONs.Product;

import Beans.ATBDBBeans.KalitaonProduct.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 23/10/2017.
 */
public class Availability {
    private List<HAvailableDateBean> availableDates=new ArrayList<>();
    private List<HSpecialDateBean> specialDates=new ArrayList<>();
    private List<HStopsaleDateBean> stopsaleDates=new ArrayList<>();
   // private List<IAvailableTimeBean> availableTime=new ArrayList<>();
    private String planId;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public List<HAvailableDateBean> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<HAvailableDateBean> availableDates) {
        this.availableDates = availableDates;
    }

    public List<HSpecialDateBean> getSpecialDates() {
        return specialDates;
    }

    public void setSpecialDates(List<HSpecialDateBean> specialDates) {
        this.specialDates = specialDates;
    }

    public List<HStopsaleDateBean> getStopsaleDates() {
        return stopsaleDates;
    }

    public void setStopsaleDates(List<HStopsaleDateBean> stopsaleDates) {
        this.stopsaleDates = stopsaleDates;
    }

//    public List<IAvailableTimeBean> getAvailableTime() {
//        return availableTime;
//    }
//
//    public void setAvailableTime(List<IAvailableTimeBean> availableTime) {
//        this.availableTime = availableTime;
//    }
}
