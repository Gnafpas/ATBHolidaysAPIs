package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.List;

/**
 * Created by George on 04/02/2018.
 */
public class CancelJSON extends StandardJSON {

    private List<ItemCancellationResult> cancellationResult;

    public List<ItemCancellationResult> getCancellationResult() {
        return cancellationResult;
    }

    public void setCancellationResult(List<ItemCancellationResult> cancellationResult) {
        this.cancellationResult = cancellationResult;
    }
}
