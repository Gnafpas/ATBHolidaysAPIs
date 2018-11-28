package Beans.HotelBedsAPIBeans.Book;

/**
 * Created by George on 27/04/2018.
 */
public class ModificationPolicies {
    private boolean cancellation;
    private boolean modification;

    public boolean isCancellation() {
        return cancellation;
    }

    public void setCancellation(boolean cancellation) {
        this.cancellation = cancellation;
    }

    public boolean isModification() {
        return modification;
    }

    public void setModification(boolean modification) {
        this.modification = modification;
    }
}
