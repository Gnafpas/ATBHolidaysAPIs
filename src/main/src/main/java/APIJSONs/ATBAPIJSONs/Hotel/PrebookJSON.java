package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.CancelationPolicyResponse;
import APIJSONs.ATBAPIJSONs.StandardJSON;
import DAOs.SunHotelsAPIDAOs.*;

import java.util.List;

/**
 * Created by George on 13/12/2017.
 */
public class PrebookJSON extends StandardJSON {

    private List<CancelationPolicyResponse> cancelationPolicies;
    private ArrayOfCalendarNote5 notes;
    private MonetaryValue price;
    private String roomId;
    private  String preBookCode;

    public List<CancelationPolicyResponse> getCancelationPolicies() {
        return cancelationPolicies;
    }

    public void setCancelationPolicies(List<CancelationPolicyResponse> cancelationPolicies) {
        this.cancelationPolicies = cancelationPolicies;
    }

    public ArrayOfCalendarNote5 getNotes() {
        return notes;
    }

    public void setNotes(ArrayOfCalendarNote5 notes) {
        this.notes = notes;
    }

    public MonetaryValue getPrice() {
        return price;
    }

    public void setPrice(MonetaryValue price) {
        this.price = price;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getPreBookCode() {
        return preBookCode;
    }

    public void setPreBookCode(String preBookCode) {
        this.preBookCode = preBookCode;
    }
}
