package WebServicesBeans.Paging_List;

import java.util.List;

/**
 * Created by George on 09/06/17.
 */
public class Attractions_Paging_List_JSON {

    private List<Attraction_Summary> attractions;
    private boolean viator_error=false;       /**Communication error or Viator error.*/
    private int totalCount;                   /**Count of receiving attractions for paging assistance.*/

    public List<Attraction_Summary> getAtractions() {
        return attractions;
    }

    public void setAtractions(List<Attraction_Summary> atractions) {
        this.attractions = atractions;
    }

    public boolean isViator_error() {
        return viator_error;
    }

    public void setViator_error(boolean viator_error) {
        this.viator_error = viator_error;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
