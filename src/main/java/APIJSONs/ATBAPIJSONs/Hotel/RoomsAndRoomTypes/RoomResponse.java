
package APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes;


import DAOs.SunHotelsAPIDAOs.*;
import java.util.List;
public class RoomResponse {

    private int roomId;
    private int beds;
    private int extrabeds;
    private List<RoomMealResponse> meals;
    private List<CancelationPolicyResponse> cancellationPolicies;


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

    public List<CancelationPolicyResponse> getCancellationPolicies() {
        return cancellationPolicies;
    }

    public void setCancellationPolicies(List<CancelationPolicyResponse> cancellationPolicies) {
        this.cancellationPolicies = cancellationPolicies;
    }

}
