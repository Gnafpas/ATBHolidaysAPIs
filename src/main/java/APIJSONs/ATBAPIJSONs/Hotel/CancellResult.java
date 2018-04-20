package APIJSONs.ATBAPIJSONs.Hotel;

import java.math.BigDecimal;

/**
 * Created by George on 05/02/2018.
 */
public class CancellResult {

    private boolean cancellationSucceed;
    private BigDecimal refund;
    private String  cancellationNote;

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public boolean isCancellationSucceed() {
        return cancellationSucceed;
    }

    public void setCancellationSucceed(boolean cancellationSucceed) {
        this.cancellationSucceed = cancellationSucceed;
    }

    public String getCancellationNote() {
        return cancellationNote;
    }

    public void setCancellationNote(String cancellationNote) {
        this.cancellationNote = cancellationNote;
    }
}
