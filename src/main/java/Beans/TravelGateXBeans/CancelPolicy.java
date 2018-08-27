package Beans.TravelGateXBeans;

import java.util.List;

/**
 * Created by George on 16/07/2018.
 */
public class CancelPolicy {

    private boolean refundable;
    private List<CancelPenalty> cancelPenalties;

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    public List<CancelPenalty> getCancelPenalties() {
        return cancelPenalties;
    }

    public void setCancelPenalties(List<CancelPenalty> cancelPenalties) {
        this.cancelPenalties = cancelPenalties;
    }
}
