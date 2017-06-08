package WebServicesBeans;

import java.util.List;

/**
 * Created by George on 06/06/17.
 */
public class Attractions_Search {

    private List<Attraction> atractions;
    private boolean viator_error=false;

    public List<Attraction> getAtractions() {
        return atractions;
    }

    public void setAtractions(List<Attraction> atractions) {
        this.atractions = atractions;
    }

    public boolean isViator_error() {
        return viator_error;
    }

    public void setViator_error(boolean viator_error) {
        this.viator_error = viator_error;
    }
}
