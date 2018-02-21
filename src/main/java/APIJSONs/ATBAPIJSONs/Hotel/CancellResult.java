package APIJSONs.ATBAPIJSONs.Hotel;

/**
 * Created by George on 05/02/2018.
 */
public class CancellResult {

    private boolean cancellationSucceed;
    private String  cancellationNote;

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
