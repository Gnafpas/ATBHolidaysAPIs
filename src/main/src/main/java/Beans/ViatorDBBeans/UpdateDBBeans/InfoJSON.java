package Beans.ViatorDBBeans.UpdateDBBeans;

/**
 * Created by George on 28/06/2017.
 */
public class InfoJSON {
    private boolean viatorError=false;
    private String viatorErrorInfo="";
    private boolean dbCommError;
    private int dbCommErrorsCounter;

    public boolean isDbCommError() {
        return dbCommError;
    }

    public void setDbCommError(boolean dbCommError) {
        this.dbCommError = dbCommError;
    }

    public int getDbCommErrorsCounter() {
        return dbCommErrorsCounter;
    }

    public void setDbCommErrorsCounter(int dbCommErrorsCounter) {
        this.dbCommErrorsCounter = dbCommErrorsCounter;
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
