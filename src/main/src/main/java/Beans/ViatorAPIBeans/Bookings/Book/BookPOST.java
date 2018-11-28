package Beans.ViatorAPIBeans.Bookings.Book;

import Helper.ProjectProperties;

import java.util.List;

/**
 * Created by George on 02/08/2017.
 */
public class BookPOST {
    private String sessionId="";
    private String ipAddress="";
    private boolean newsletterSignUp=false;
    private boolean demo=false;
    private String currencyCode= ProjectProperties.defaultCurrencyCode;
    private OtherDetail otherDetail=null;
    private PartnerDetail partnerDetail=new PartnerDetail();
    private Booker booker=new Booker();
    private List<Item> items;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean isNewsletterSignUp() {
        return newsletterSignUp;
    }

    public void setNewsletterSignUp(boolean newsletterSignUp) {
        this.newsletterSignUp = newsletterSignUp;
    }

    public boolean isDemo() {
        return demo;
    }

    public void setDemo(boolean demo) {
        this.demo = demo;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public OtherDetail getOtherDetail() {
        return otherDetail;
    }

    public void setOtherDetail(OtherDetail otherDetail) {
        this.otherDetail = otherDetail;
    }

    public PartnerDetail getPartnerDetail() {
        return partnerDetail;
    }

    public void setPartnerDetail(PartnerDetail partnerDetail) {
        this.partnerDetail = partnerDetail;
    }

    public Booker getBooker() {
        return booker;
    }

    public void setBooker(Booker booker) {
        this.booker = booker;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
