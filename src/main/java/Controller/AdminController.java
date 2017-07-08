package Controller;

import DBUpdates.UpdateCategories;
import DBUpdates.UpdateDestinations;
import DBUpdates.UpdateProducts;
import WebServicesBeans.UpdateDBJSONs.InfoJSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by George on 29/05/17.
 */
@RestController
public class AdminController extends TimerTask {

    private int StartingDestId;
    private int StopDesId;
    private Timer timer;
    private boolean timerRuns = false;//todo figure out how to parse these parameters


    @Override
    public void run() {
        timerRuns=true;
        UpdateProducts updateProducts =new UpdateProducts();
        updateProducts.updateProducts(28612,28612);//todo figure out how to parse these parameters

    }


    /**
     * All functions return results about the update.If there were errors in communication with viator server or DB
     * How many products added/updated  to DB,which products failed  due to communication with
     * viator or communication with DB.When update started and when lasted.Also returns
     * the destinations of the products that failed to run the update again for that specific destinations.
     * @RequestParam StartingDestId :From which destination to start the update.
     * @RequestParam StopDestId :At which destination to last the update.
     * All destinations are stored in DB with a sort order.
     * If StartingDestId=0 and  StopDestId=0 the update runs for all destinations.
     */
    @RequestMapping("/startUpdateProducts")
    public String startUpdateProducts(@RequestParam(value="StartingDestId", defaultValue="0") Integer StartingDestId,
                                                 @RequestParam(value="StopDestId", defaultValue="0") Integer StopDestId) {
        this.StartingDestId=StartingDestId;
        this.StopDesId=StopDestId;
        /**
         * Update products with timer every 24 hours.
         */
        TimerTask timerTask = new AdminController();
        timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 60 * 60 * 24 * 1000);
        return "Update timer started";
    }

    @RequestMapping("/stopUpdateProducts")
    public String stopUpdateProducts(){
        if(timerRuns) {
            timer.cancel();
            timer.purge();
            timerRuns = false;
            return "Update timer stopped. ";
        }else
            return "Update timer isn't running. ";

    }

    @RequestMapping("/updateCategories")
    public InfoJSON updateCategories() {
        UpdateCategories updateCategories=new UpdateCategories();
        return updateCategories.updateCategories();
    }

    @RequestMapping("/updateDestinations")
    public InfoJSON updateDestinations() {
        UpdateDestinations updateDestinations=new UpdateDestinations();
        return updateDestinations.updateDestinations();
    }

}
