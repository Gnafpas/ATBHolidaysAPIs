package APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes;

import java.math.BigDecimal;

/**
 * Created by George on 13/12/2017.
 */
public class SunHotelsCancelationPolicy {

    private BigDecimal percentage;
    private int deadline;

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }
}
