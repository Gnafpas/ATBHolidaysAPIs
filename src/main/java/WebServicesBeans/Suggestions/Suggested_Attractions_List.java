package WebServicesBeans.Suggestions;

import java.util.List;

/**
 * Created by George on 06/06/17.
 */
public class Suggested_Attractions_List {

    private List<Suggested_Attraction> atractions;
    private boolean viator_error=false;

    public List<Suggested_Attraction> getAtractions() {
        return atractions;
    }

    public void setAtractions(List<Suggested_Attraction> atractions) {
        this.atractions = atractions;
    }

    public boolean isViator_error() {
        return viator_error;
    }

    public void setViator_error(boolean viator_error) {
        this.viator_error = viator_error;
    }
}
