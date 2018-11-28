package APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes;

import java.math.BigDecimal;

/**
 * Created by George on 13/12/2017.
 */
public class CancelationPolicyResponse {

    private BigDecimal percentage;
    private Integer deadline;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }
}
