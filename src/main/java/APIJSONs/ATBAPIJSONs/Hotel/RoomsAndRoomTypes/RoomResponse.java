
package APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes;


import DAOs.SunHotelsAPIDAOs.*;

import java.util.List;

public class RoomResponse {

    private int roomId;
    private int beds;
    private int extrabeds;
    private List<RoomMealResponse> meals;
    private ArrayOfPercentageCancellationPolicy cancellationPolicies;
    private ArrayOfCalendarNote notes;//todo maybe it has to be change to custom if searcv2 doesn't return all the details for note and it returns only ids of note types
    private boolean isSuperDeal;
    private boolean isBestBuy;


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getExtrabeds() {
        return extrabeds;
    }

    public void setExtrabeds(int extrabeds) {
        this.extrabeds = extrabeds;
    }

    public List<RoomMealResponse> getMeals() {
        return meals;
    }

    public void setMeals(List<RoomMealResponse> meals) {
        this.meals = meals;
    }

    public ArrayOfPercentageCancellationPolicy getCancellationPolicies() {
        return cancellationPolicies;
    }

    public void setCancellationPolicies(ArrayOfPercentageCancellationPolicy cancellationPolicies) {
        this.cancellationPolicies = cancellationPolicies;
    }

    public ArrayOfCalendarNote getNotes() {
        return notes;
    }

    public void setNotes(ArrayOfCalendarNote notes) {
        this.notes = notes;
    }

    public boolean isSuperDeal() {
        return isSuperDeal;
    }

    public void setSuperDeal(boolean superDeal) {
        isSuperDeal = superDeal;
    }

    public boolean isBestBuy() {
        return isBestBuy;
    }

    public void setBestBuy(boolean bestBuy) {
        isBestBuy = bestBuy;
    }


}
