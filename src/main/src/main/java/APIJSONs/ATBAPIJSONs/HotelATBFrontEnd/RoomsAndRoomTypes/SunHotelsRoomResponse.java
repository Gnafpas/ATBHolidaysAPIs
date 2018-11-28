
package APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes;


import java.util.List;

public class SunHotelsRoomResponse {

    private int roomId;
    private int beds;
    private int extrabeds;
    private List<SunHotelsRoomMealResponse> meals;
    private List<SunHotelsCancelationPolicy> cancellationPolicies;


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

    public List<SunHotelsRoomMealResponse> getMeals() {
        return meals;
    }

    public void setMeals(List<SunHotelsRoomMealResponse> meals) {
        this.meals = meals;
    }

    public List<SunHotelsCancelationPolicy> getCancellationPolicies() {
        return cancellationPolicies;
    }

    public void setCancellationPolicies(List<SunHotelsCancelationPolicy> cancellationPolicies) {
        this.cancellationPolicies = cancellationPolicies;
    }
}
