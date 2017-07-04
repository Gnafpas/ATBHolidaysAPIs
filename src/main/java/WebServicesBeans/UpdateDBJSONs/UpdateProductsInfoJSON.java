package WebServicesBeans.UpdateDBJSONs;


import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 27/06/2017.
 */
public class UpdateProductsInfoJSON extends InfoJSON {
    private int totalLeafNodes=0;
    private int totalProducts=0;
    private int lastLeafDestid=0;
    private TotalExpiredProducts totalExpiredProducts;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private List<Integer> failedDestinations=new ArrayList<>();
    private List<FailedProduct> failedProducts=new ArrayList<>();
    private long totalProcessSleep;/**Idle time of update process due to viator request limit.*/

    public long getTotalProcessSleep() {
        return totalProcessSleep;
    }

    public void setTotalProcessSleep(long totalProcessSleep) {
        this.totalProcessSleep = totalProcessSleep;
    }

    public int getTotalLeafNodes() {
        return totalLeafNodes;
    }

    public void setTotalLeafNodes(int totalLeafNodes) {
        this.totalLeafNodes = totalLeafNodes;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public TotalExpiredProducts getTotalExpiredProducts() {
        return totalExpiredProducts;
    }

    public void setTotalExpiredProducts(TotalExpiredProducts totalExpiredProducts) {
        this.totalExpiredProducts = totalExpiredProducts;
    }

    public int getLastLeafDestid() {
        return lastLeafDestid;
    }

    public void setLastLeafDestid(int lastLeafDestid) {
        this.lastLeafDestid = lastLeafDestid;
    }

    public ZonedDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(ZonedDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public ZonedDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(ZonedDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public List<Integer> getFailedDestinations() {
        return failedDestinations;
    }

    public void setFailedDestinations(List<Integer> failedDestinations) {
        this.failedDestinations = failedDestinations;
    }

    public List<FailedProduct> getFailedProducts() {
        return failedProducts;
    }

    public void setFailedProducts(List<FailedProduct> failedProducts) {
        this.failedProducts = failedProducts;
    }
}

