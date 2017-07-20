package DBUpdates;

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
        UpdateProducts updateProducts =new UpdateProducts();
        updateProducts.updateProducts(StartingDestId,StopDestId);
    }
}
