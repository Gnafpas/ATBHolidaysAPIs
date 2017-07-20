package Controller;

import DBUpdates.UpdateAttractions;
import DBUpdates.UpdateCategories;
import DBUpdates.UpdateDestinations;
import Helper.ProjectProperties;
import DBUpdates.UpdateDBTimerTask;
import WebServicesBeans.UpdateDBJSONs.InfoJSON;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by George on 29/05/17.
 */
@RestController
public class AdminController {

    private Timer timer;
    private boolean timerRuns = false;


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
        if(!timerRuns) {
            /**
             * Update products with timer every 24 hours.
             */
            TimerTask timerTask = new UpdateDBTimerTask(StartingDestId,StopDestId);
            timer = new Timer(true);
            timer.scheduleAtFixedRate(timerTask, 0, Helper.ProjectProperties.runDBUpdateEveryXMillisecs);
            timerRuns=true;
            return "Update timer task started.Runs every "+ ProjectProperties.runDBUpdateEveryXMillisecs /60 /60 /1000+" hours." ;
        }
        else
            return "Update timer task runs already.";
    }

    @RequestMapping("/stopUpdateProducts")
    @Secured("USER")
    public String stopUpdateProducts(){
        if(timerRuns) {
            timer.cancel();
            timer.purge();
            timerRuns = false;
            return "Update timer task  stopped. ";
        }else
            return "Update timer task isn't running. ";

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

    @RequestMapping("/updateAttractions")
    public InfoJSON updateAttractions(@RequestParam(value="StartingDestId", defaultValue="0") Integer StartingDestId,
                                      @RequestParam(value="StopDestId", defaultValue="0") Integer StopDestId) {
        UpdateAttractions updateAttractions=new UpdateAttractions();
        return updateAttractions.UpdateAttractions(StartingDestId,StopDestId);
    }

}
//todo organize System.out.printlns tou error/info files
