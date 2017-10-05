package Beans.ViatorDBBeans.UpdateDBBeans;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 27/06/2017.
 */
public class UpdateProductsInfoJSON extends InfoJSON {
    private int totalLeafNodes=0;
    private int totalProducts=0;
    private int lastLeafDestid=0;
    private TotalExpiredProducts totalExpiredProducts=new TotalExpiredProducts();
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private List<Integer> failedDestinations=new ArrayList<>();
    private List<String> productsWithFailedAvailDates=new ArrayList<>();
    private List<String> productsWithFailedPricingMatrixes=new ArrayList<>();
    private List<String> productsWithFailedPickupHotels=new ArrayList<>();
    private List<FailedProduct> failedProducts=new ArrayList<>();
    private long totalProcessSleep;

    public List<String> getProductsWithFailedPickupHotels() {
        return productsWithFailedPickupHotels;
    }

    public void setProductsWithFailedPickupHotels(List<String> productsWithFailedPickupHotels) {
        this.productsWithFailedPickupHotels = productsWithFailedPickupHotels;
    }

    /**Idle time of update process due to viator request limit.*/



    public List<String> getProductsWithFailedAvailDates() {
        return productsWithFailedAvailDates;
    }

    public void setProductsWithFailedAvailDates(List<String> productsWithFailedAvailDates) {
        this.productsWithFailedAvailDates = productsWithFailedAvailDates;
    }

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

    public List<FailedProduct> getFailedProducts() {
        return failedProducts;
    }

    public void setFailedProducts(List<FailedProduct> failedProducts) {
        this.failedProducts = failedProducts;
    }

    public List<String> getProductsWithFailedPricingMatrixes() {
        return productsWithFailedPricingMatrixes;
    }

    public void setProductsWithFailedPricingMatrixes(List<String> productsWithFailedPricingMatrixes) {
        this.productsWithFailedPricingMatrixes = productsWithFailedPricingMatrixes;
    }
}

