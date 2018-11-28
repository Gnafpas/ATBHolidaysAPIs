package Beans.TravelGateXBeans;

import java.math.BigDecimal;

/**
 * Created by George on 16/07/2018.
 */
public class CancelPenalty {

    private Integer hoursBefore;
    private String penaltyType;
    private String currency;
    private BigDecimal value;

    public Integer getHoursBefore() {
        return hoursBefore;
    }

    public void setHoursBefore(Integer hoursBefore) {
        this.hoursBefore = hoursBefore;
    }

    public String getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
