package WebServicesBeans;

import java.util.List;

/**
 * Created by George on 06/06/17.
 */
public class Attractions_List {

    private List<Attraction_Summary> atractions;
    private boolean viator_error=false;

    public List<Attraction_Summary> getAtractions() {
        return atractions;
    }

    public void setAtractions(List<Attraction_Summary> atractions) {
        this.atractions = atractions;
    }

    public boolean isViator_error() {
        return viator_error;
    }

    public void setViator_error(boolean viator_error) {
        this.viator_error = viator_error;
    }
}
