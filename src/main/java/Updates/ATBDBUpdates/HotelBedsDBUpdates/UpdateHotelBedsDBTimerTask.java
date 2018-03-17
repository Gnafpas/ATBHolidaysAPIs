package Updates.ATBDBUpdates.HotelBedsDBUpdates;

import Updates.ATBDBUpdates.SunHotelsDBUpdates.UpdateSunHotelsDB;

import java.util.TimerTask;

/**
 * Created by George on 06/10/2017.
 */
public class UpdateHotelBedsDBTimerTask extends TimerTask {
    @Override
    public void run() {
        UpdateHotelBedsDB.updateHotelsContent();
    }
}
