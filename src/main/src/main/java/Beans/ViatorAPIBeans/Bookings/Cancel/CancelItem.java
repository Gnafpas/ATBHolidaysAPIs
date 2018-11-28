package Beans.ViatorAPIBeans.Bookings.Cancel;

/**
 * Created by George on 03/08/2017.
 */
public class CancelItem {

    private long itemId;
    private String distributorItemRef="distroItemRef";
    private String cancelCode;
    private String cancelDescription;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getDistributorItemRef() {
        return distributorItemRef;
    }

    public void setDistributorItemRef(String distributorItemRef) {
        this.distributorItemRef = distributorItemRef;
    }

    public String getCancelCode() {
        return cancelCode;
    }

    public void setCancelCode(String cancelCode) {
        this.cancelCode = cancelCode;
    }

    public String getCancelDescription() {
        return cancelDescription;
    }

    public void setCancelDescription(String cancelDescription) {
        this.cancelDescription = cancelDescription;
    }
}
