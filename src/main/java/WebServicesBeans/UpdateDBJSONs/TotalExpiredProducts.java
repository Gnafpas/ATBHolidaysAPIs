package WebServicesBeans.UpdateDBJSONs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 28/06/2017.
 */
public class TotalExpiredProducts {
    private int totalExpiredProducts=0;
    private List<String> totalExpiredProductsList=new ArrayList<>();
    private boolean viatorError;
    private String viatorErrorInfo;
    private boolean dbCommError;
    private int dbCommErrorCounter;

    public boolean isViatorError() {
        return viatorError;
    }

    public void setViatorError(boolean viatorError) {
        this.viatorError = viatorError;
    }

    public String getViatorErrorInfo() {
        return viatorErrorInfo;
    }

    public void setViatorErrorInfo(String viatorErrorInfo) {
        this.viatorErrorInfo = viatorErrorInfo;
    }

    public boolean isDbCommError() {
        return dbCommError;
    }

    public void setDbCommError(boolean dbCommError) {
        this.dbCommError = dbCommError;
    }

    public int getDbCommErrorCounter() {
        return dbCommErrorCounter;
    }

    public void setDbCommErrorCounter(int dbCommErrorCounter) {
        this.dbCommErrorCounter = dbCommErrorCounter;
    }

    public int getTotalExpiredProducts() {
        return totalExpiredProducts;
    }

    public void setTotalExpiredProducts(int totalExpiredProducts) {
        this.totalExpiredProducts = totalExpiredProducts;
    }

    public List<String> getTotalExpiredProductsList() {
        return totalExpiredProductsList;
    }

    public void setTotalExpiredProductsList(List<String> totalExpiredProductsList) {
        this.totalExpiredProductsList = totalExpiredProductsList;
    }

}
