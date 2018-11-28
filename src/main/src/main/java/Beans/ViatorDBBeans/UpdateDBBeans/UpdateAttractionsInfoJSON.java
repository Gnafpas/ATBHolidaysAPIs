package Beans.ViatorDBBeans.UpdateDBBeans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 17/07/2017.
 */
public class UpdateAttractionsInfoJSON extends InfoJSON{

    private int totalLeafNodes=0;
    private int totalAttractions=0;
    private int lastLeafDestid=0;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private List<Integer> failedDestinations=new ArrayList<>();
    private List<FailedAttraction> failedAttractions=new ArrayList<>();
    private long totalProcessSleep;

    public int getTotalLeafNodes() {
        return totalLeafNodes;
    }

    public void setTotalLeafNodes(int totalLeafNodes) {
        this.totalLeafNodes = totalLeafNodes;
    }

    public int getTotalAttractions() {
        return totalAttractions;
    }

    public void setTotalAttractions(int totalAttractions) {
        this.totalAttractions = totalAttractions;
    }

    public int getLastLeafDestid() {
        return lastLeafDestid;
    }

    public void setLastLeafDestid(int lastLeafDestid) {
        this.lastLeafDestid = lastLeafDestid;
    }

    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }

    public List<Integer> getFailedDestinations() {
        return failedDestinations;
    }

    public void setFailedDestinations(List<Integer> failedDestinations) {
        this.failedDestinations = failedDestinations;
    }

    public List<FailedAttraction> getFailedAttractions() {
        return failedAttractions;
    }

    public void setFailedAttractions(List<FailedAttraction> failedAttractions) {
        this.failedAttractions = failedAttractions;
    }

    public long getTotalProcessSleep() {
        return totalProcessSleep;
    }

    public void setTotalProcessSleep(long totalProcessSleep) {
        this.totalProcessSleep = totalProcessSleep;
    }
}
