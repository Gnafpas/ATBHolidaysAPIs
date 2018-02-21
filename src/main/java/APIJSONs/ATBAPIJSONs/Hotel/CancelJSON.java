package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.StandardJSON;
import DAOs.SunHotelsAPIDAOs.CancellationResult;

/**
 * Created by George on 04/02/2018.
 */
public class CancelJSON  extends StandardJSON {

    private CancellResult cancellationResult;

    public CancellResult getCancellationResult() {
        return cancellationResult;
    }

    public void setCancellationResult(CancellResult cancellationResult) {
        this.cancellationResult = cancellationResult;
    }
}
