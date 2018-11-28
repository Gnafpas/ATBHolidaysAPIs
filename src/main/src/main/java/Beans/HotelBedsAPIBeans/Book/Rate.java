package Beans.HotelBedsAPIBeans.Book;

import java.util.List;

/**
 * Created by George on 27/04/2018.
 */
public class Rate {
    private String rateClass;
    private String net;
    private String rateComments;
    private String paymentType;
    private boolean packaging;
    private String boardCode;
    private String boardName;
    private List<CancelationPolicy> cancellationPolicies;
    private int rooms;
    private int adults;
    private int children;


    public String getRateClass() {
        return rateClass;
    }

    public void setRateClass(String rateClass) {
        this.rateClass = rateClass;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getRateComments() {
        return rateComments;
    }

    public void setRateComments(String rateComments) {
        this.rateComments = rateComments;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public boolean isPackaging() {
        return packaging;
    }

    public void setPackaging(boolean packaging) {
        this.packaging = packaging;
    }

    public String getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(String boardCode) {
        this.boardCode = boardCode;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public List<CancelationPolicy> getCancellationPolicies() {
        return cancellationPolicies;
    }

    public void setCancellationPolicies(List<CancelationPolicy> cancellationPolicies) {
        this.cancellationPolicies = cancellationPolicies;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }
}
