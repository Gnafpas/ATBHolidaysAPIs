package Beans.ViatorAPIBeans.Bookings.Cancel;

/**
 * Created by George on 03/08/2017.
 */
public class ResponseCancelItem {

    private String distributorItemRef;
    private long itemId;
    private String cancellationResponseStatusCode;
    private String cancellationResponseDescription;

    public String getDistributorItemRef() {
        return distributorItemRef;
    }

    public void setDistributorItemRef(String distributorItemRef) {
        this.distributorItemRef = distributorItemRef;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getCancellationResponseStatusCode() {
        return cancellationResponseStatusCode;
    }

    public void setCancellationResponseStatusCode(String cancellationResponseStatusCode) {
        this.cancellationResponseStatusCode = cancellationResponseStatusCode;
    }

    public String getCancellationResponseDescription() {
        return cancellationResponseDescription;
    }

    public void setCancellationResponseDescription(String cancellationResponseDescription) {
        this.cancellationResponseDescription = cancellationResponseDescription;
    }
}
