package DBUpdates;

import Helper.ProjectProperties;

import java.util.TimerTask;

/**
 * Created by George on 10/07/2017.
 */
public class UpdateDBTimerTask extends TimerTask {
    private int StartingDestId;
    private int StopDestId;


   public UpdateDBTimerTask(int StartingDestId,int StopDestId){
        this.StartingDestId=StartingDestId;
        this.StopDestId=StopDestId;
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
    }
}
