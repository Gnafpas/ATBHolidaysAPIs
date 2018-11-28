package Updates.ViatorDBUpdates;

import Updates.ATBDBUpdates.ViatorContentUpdates.UpdateATBProducts;
import Helper.ProjectProperties;

import java.util.TimerTask;

/**
 * Created by George on 10/07/2017.
 */
public class UpdateViatorDBTimerTask extends TimerTask {
    private int StartingDestId;
    private int StopDestId;

    private String firstProductCode;
    private String lastProductCode;


   public UpdateViatorDBTimerTask(int StartingDestId, int StopDestId , String firstProductCode, String lastProductCode){
        this.StartingDestId=StartingDestId;
        this.StopDestId=StopDestId;

        this.firstProductCode=firstProductCode;
        this.lastProductCode=lastProductCode;
    }

    @Override
    public void run() {

        UpdateCategories.updateCategories();
        /**
         * Time between viator server requests.There is a limit for the number of requests per
         * 10 seconds that we can make at viator's server(15req/10sec for prelive and 35req/10sec for live).
         * Process may sleep for an amount of time to stay in the limits.
         */
        try {
            Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        UpdateDestinations.updateDestinations();
        try {
            Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        UpdateProducts.updateProducts(StartingDestId,StopDestId);
        try {
            Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        UpdateATBProducts.updateProducts(firstProductCode,lastProductCode);


        /**
         * From the second time of timertask runs and so on these values will be again default
         */
        this.StartingDestId=0;
        this.StopDestId=0;
        this.firstProductCode="";
        this.lastProductCode="";//todo check if it works as expected
    }
}
