package WebServicesBeans.UpdateDBJSONs;

import java.util.List;

/**
 * Created by George on 28/06/2017.
 */
public class InfoJSON {
    private boolean viatorError=false;
    private String viatorErrorInfo;
    private boolean dbCommError;
    private int dbCommErrorCounter;

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

    public boolean isViatorError() {
        return viatorError;
    }

    public void setViatorError(boolean viatorError) {
        this.viatorError = viatorError;
    }

    public String getViatorErrorInfo() {
        return viatorErrorInfo;
    }

    public void setViatorErrorInfo(String vitorErrorInfo) {
        this.viatorErrorInfo = vitorErrorInfo;
    }
}
