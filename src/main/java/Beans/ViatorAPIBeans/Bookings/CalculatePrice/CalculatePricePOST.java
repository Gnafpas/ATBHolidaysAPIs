package Beans.ViatorAPIBeans.Bookings.CalculatePrice;

import Beans.ViatorAPIBeans.Bookings.Book.PartnerDetail;

import java.util.List;

/**
 * Created by George on 03/08/2017.
 */
public class CalculatePricePOST {

    private String promoCode;
    private PartnerDetail partnerDetail;
    private String currencyCode;
    private List<Item> items;

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public PartnerDetail getPartnerDetail() {
        return partnerDetail;
    }

    public void setPartnerDetail(PartnerDetail partnerDetail) {
        this.partnerDetail = partnerDetail;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
