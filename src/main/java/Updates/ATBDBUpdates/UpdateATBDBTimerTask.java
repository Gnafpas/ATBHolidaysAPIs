package Updates.ATBDBUpdates;

import java.util.TimerTask;

/**
 * Created by George on 06/10/2017.
 */
public class UpdateATBDBTimerTask extends TimerTask {
    private String firstProductCode;
    private String lastProductCode;


    public UpdateATBDBTimerTask(String firstProductCode, String lastProductCode){
        this.firstProductCode=firstProductCode;
        this.lastProductCode=lastProductCode;
    }

    @Override
    public void run() {
        UpdateATBProducts.updateProducts(firstProductCode,lastProductCode);
    }
}
