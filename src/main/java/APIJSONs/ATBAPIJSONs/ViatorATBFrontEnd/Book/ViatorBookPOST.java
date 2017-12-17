package APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book;

import Beans.ViatorAPIBeans.Bookings.Book.Booker;
import Helper.ProjectProperties;

import java.util.List;

/**
 * Created by George on 02/08/2017.
 */
public class ViatorBookPOST {

    private boolean demo=false;
    private String currencyCode= ProjectProperties.defaultCurrencyCode;
    private Booker Booker =new Booker();
    private List<ViatorItem> Items;
    private String bookRef;

    public String getBookRef() {
        return bookRef;
    }

    public void setBookRef(String bookRef) {
        this.bookRef = bookRef;
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

    public Beans.ViatorAPIBeans.Bookings.Book.Booker getBooker() {
        return Booker;
    }

    public void setBooker(Beans.ViatorAPIBeans.Bookings.Book.Booker booker) {
        Booker = booker;
    }

    public List<ViatorItem> getItems() {
        return Items;
    }

    public void setItems(List<ViatorItem> items) {
        Items = items;
    }
}
