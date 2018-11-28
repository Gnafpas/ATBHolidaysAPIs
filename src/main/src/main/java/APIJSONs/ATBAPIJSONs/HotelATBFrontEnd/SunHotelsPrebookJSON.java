package APIJSONs.ATBAPIJSONs.HotelATBFrontEnd;

import APIJSONs.ATBAPIJSONs.StandardJSON;
import DAOs.SunHotelsAPIDAOs.ArrayOfCalendarNote5;
import DAOs.SunHotelsAPIDAOs.ArrayOfStaticPercentageCancellationPolicy;
import DAOs.SunHotelsAPIDAOs.MonetaryValue;
import DAOs.SunHotelsAPIDAOs.PriceBreakdownResult;

/**
 * Created by George on 13/12/2017.
 */
public class SunHotelsPrebookJSON extends StandardJSON {

    private ArrayOfStaticPercentageCancellationPolicy  cancelationPolicies;
    private ArrayOfCalendarNote5 notes;
    private MonetaryValue price;
    private PriceBreakdownResult priceBreakDown;
    private String roomId;
    private  String preBookCode;

    public ArrayOfStaticPercentageCancellationPolicy getCancelationPolicies() {
        return cancelationPolicies;
    }

    public void setCancelationPolicies(ArrayOfStaticPercentageCancellationPolicy cancelationPolicies) {
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

    public PriceBreakdownResult getPriceBreakDown() {
        return priceBreakDown;
    }

    public void setPriceBreakDown(PriceBreakdownResult priceBreakDown) {
        this.priceBreakDown = priceBreakDown;
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
