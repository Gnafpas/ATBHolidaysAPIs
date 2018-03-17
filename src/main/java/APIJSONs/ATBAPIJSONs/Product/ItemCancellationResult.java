package APIJSONs.ATBAPIJSONs.Product;

/**
 * Created by George on 05/02/2018.
 */
public class ItemCancellationResult {

    private boolean cancellationSucceed;
    private String  cancellationNote;
    private int  itemId;
    private String  bookingId;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean isCancellationSucceed() {
        return cancellationSucceed;
    }

    public void setCancellationSucceed(boolean cancellationSucceed) {
        this.cancellationSucceed = cancellationSucceed;
    }

    public String getCancellationNote() {
        return cancellationNote;
    }

    public void setCancellationNote(String cancellationNote) {
        this.cancellationNote = cancellationNote;
    }
}
