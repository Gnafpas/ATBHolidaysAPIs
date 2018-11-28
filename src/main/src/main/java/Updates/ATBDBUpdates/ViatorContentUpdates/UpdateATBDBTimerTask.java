package Updates.ATBDBUpdates.ViatorContentUpdates;

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
        /**
         * From the second time of timertask runs and so on these values will be again default
         */
        this.firstProductCode="";
        this.lastProductCode="";
    }
}
