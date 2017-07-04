package WebServicesBeans.Suggestions;

/**
 * Created by George on 07/06/17.
 */
public class SearchFreetextSuggestionsJSON {

    private SuggestedProductsList products;
    private SuggestedAttractionsList attractionsList;
    private SuggestedDestinationsList destinations;
    private boolean dbCommError=false;

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

    public boolean isDbCommError() {
        return dbCommError;
    }

    public void setDbCommError(boolean dbCommError) {
        this.dbCommError = dbCommError;
    }
}
