package WebServicesBeans.OldSearchController;

import java.util.List;

/**
 * Created by George on 09/06/17.
 */
public class AttractionsSummaryPagingListJSON {

    private List<AttractionSummary> attractions;
    private boolean viatorΕrror=false;       /**Communication error or Viator error.*/
    private int totalCount;                   /**Count of receiving attractions for paging assistance.*/

    public List<AttractionSummary> getAtractions() {
        return attractions;
    }

    public void setAtractions(List<AttractionSummary> atractions) {
        this.attractions = atractions;
    }

    public boolean isViatorΕrror() {
        return viatorΕrror;
    }

    public void setViatorΕrror(boolean viatorΕrror) {
        this.viatorΕrror = viatorΕrror;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
