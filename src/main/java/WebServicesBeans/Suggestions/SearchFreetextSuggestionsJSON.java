package WebServicesBeans.Suggestions;

/**
 * Created by George on 07/06/17.
 */
public class SearchFreetextSuggestionsJSON {

    private SuggestedProductsList products;
    private SuggestedAttractionsList attractionsList;
    private SuggestedDestinationsList destinations;
    private boolean DBError=false;

    public boolean isDBError() {
        return DBError;
    }

    public void setDBError(boolean DBError) {
        this.DBError = DBError;
    }

    public SuggestedProductsList getProducts() {
        return products;
    }

    public void setProducts(SuggestedProductsList products) {
        this.products = products;
    }

    public SuggestedAttractionsList getAttractionsList() {
        return attractionsList;
    }

    public void setAttractionsList(SuggestedAttractionsList attractionsList) {
        this.attractionsList = attractionsList;
    }

    public SuggestedDestinationsList getDestinations() {
        return destinations;
    }

    public void setDestinations(SuggestedDestinationsList destinations) {
        this.destinations = destinations;
    }

}
