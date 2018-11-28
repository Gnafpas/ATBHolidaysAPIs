package Updates.ATBDBUpdates.SunHotelsDBUpdates;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 28/06/2017.
 */
public class TotalExpiredHotels {
    private int totalExpiredhotels=0;
    private List<Integer> totalExpiredHotelsList=new ArrayList<>();
    private int sunHotelsCommErrCounter=0;
    private int atbDBErrCommCounter=0;

    public int getTotalExpiredhotels() {
        return totalExpiredhotels;
    }

    public void setTotalExpiredhotels(int totalExpiredhotels) {
        this.totalExpiredhotels = totalExpiredhotels;
    }

    public List<Integer> getTotalExpiredHotelsList() {
        return totalExpiredHotelsList;
    }

    public void setTotalExpiredHotelsList(List<Integer> totalExpiredHotelsList) {
        this.totalExpiredHotelsList = totalExpiredHotelsList;
    }

    public int getSunHotelsCommErrCounter() {
        return sunHotelsCommErrCounter;
    }

    public void setSunHotelsCommErrCounter(int sunHotelsCommErrCounter) {
        this.sunHotelsCommErrCounter = sunHotelsCommErrCounter;
    }

    public int getAtbDBErrCommCounter() {
        return atbDBErrCommCounter;
    }

    public void setAtbDBErrCommCounter(int atbDBErrCommCounter) {
        this.atbDBErrCommCounter = atbDBErrCommCounter;
    }
}
