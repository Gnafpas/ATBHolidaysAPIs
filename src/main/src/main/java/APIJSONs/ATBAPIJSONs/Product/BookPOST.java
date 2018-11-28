package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book.ViatorItem;
import Beans.ViatorAPIBeans.Bookings.Book.Booker;
import Helper.ProjectProperties;

import java.util.List;

/**
 * Created by George on 02/08/2017.
 */
public class BookPOST {

    private Booker Booker =new Booker();
    private List<Item> Items;
    private String customerCountry;
    private String currencyCode="";
    private ShippingDetails shippingDetails;
    private boolean demo=false;

    public boolean isDemo() {
        return demo;
    }

    public void setDemo(boolean demo) {
        this.demo = demo;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Beans.ViatorAPIBeans.Bookings.Book.Booker getBooker() {
        return Booker;
    }

    public void setBooker(Beans.ViatorAPIBeans.Bookings.Book.Booker booker) {
        Booker = booker;
    }

    public List<Item> getItems() {
        return Items;
    }

    public void setItems(List<Item> items) {
        Items = items;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }
}
