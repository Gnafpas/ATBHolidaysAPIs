package Beans.ViatorAPIBeans.Bookings.Cancel;

import java.util.List;

/**
 * Created by George on 03/08/2017.
 */
public class CancelData {

    private long itineraryId;
    private String distributorRef;
    private List<ResponseCancelItem> cancelItems;

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

    public List<ResponseCancelItem> getCancelItems() {
        return cancelItems;
    }

    public void setCancelItems(List<ResponseCancelItem> cancelItems) {
        this.cancelItems = cancelItems;
    }
}
