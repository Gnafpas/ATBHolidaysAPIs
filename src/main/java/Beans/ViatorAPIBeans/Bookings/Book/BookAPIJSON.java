package Beans.ViatorAPIBeans.Bookings.Book;

import Beans.ViatorAPIBeans.APIJSONMetada;

/**
 * Created by George on 02/08/2017.
 */
public class BookAPIJSON extends APIJSONMetada {

    private BookData data;

    public BookData getData() {
        return data;
    }

    public void setData(BookData data) {
        this.data = data;
    }
}
