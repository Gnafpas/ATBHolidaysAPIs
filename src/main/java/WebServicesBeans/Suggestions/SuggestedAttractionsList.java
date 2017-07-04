package WebServicesBeans.Suggestions;

import java.util.List;

/**
 * Created by George on 06/06/17.
 */
public class SuggestedAttractionsList {

    private List<SuggestedAttraction> atractions;
    private boolean dbCommError=false;

    public List<SuggestedAttraction> getAtractions() {
        return atractions;
    }

    public void setAtractions(List<SuggestedAttraction> atractions) {
        this.atractions = atractions;
    }

    public boolean isDbCommError() {
        return dbCommError;
    }

    public void setDbCommError(boolean dbCommError) {
        this.dbCommError = dbCommError;
    }
}
