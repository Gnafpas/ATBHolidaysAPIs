package Updates.ATBDBUpdates.SunHotelsDBUpdates;

import java.util.TimerTask;

/**
 * Created by George on 06/10/2017.
 */
public class UpdateSunHotelsDBTimerTask extends TimerTask {
    private int StartingDestId;
    private int StopDestId;


    public UpdateSunHotelsDBTimerTask(int StartingDestId, int StopDestId){
        this.StartingDestId=StartingDestId;
        this.StopDestId=StopDestId;
    }

    @Override
    public void run() {
        UpdateSunHotelsDB.updateHotelsContent(StartingDestId,StopDestId);
        /**
         * From the second time of timertask runs and so on these values will be again default
         */
        this.StartingDestId=0;
        this.StopDestId=0;
    }
}
