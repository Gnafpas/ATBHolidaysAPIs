package Beans.ViatorAPIBeans.Bookings.Cancel;

import java.util.List;

/**
 * Created by George on 03/08/2017.
 */
public class CancelPOST {
    private long itineraryId;
    private String distributorRef="distroRef";
    private List<CancelItem> cancelItems;

    public long getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(long itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getDistributorRef() {
        return distributorRef;
    }

    public void setDistributorRef(String distributorRef) {
        this.distributorRef = distributorRef;
    }

    public List<CancelItem> getCancelItems() {
        return cancelItems;
    }

    public void setCancelItems(List<CancelItem> cancelItems) {
        this.cancelItems = cancelItems;
    }
}
