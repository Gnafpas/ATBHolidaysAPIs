package WebServicesBeans.Suggestions;

/**
 * Created by George on 07/06/17.
 */
public class Search_Freetext_Suggestions_JSON {

    private Suggested_Products_List products;
    private Suggested_Attractions_List attractionsList;
    private Suggested_Destinations_List destinations;
    private boolean viator_error=false;

    public Suggested_Products_List getProducts() {
        return products;
    }

    public void setProducts(Suggested_Products_List products) {
        this.products = products;
    }

    public Suggested_Attractions_List getAttractionsList() {
        return attractionsList;
    }

    public void setAttractionsList(Suggested_Attractions_List attractionsList) {
        this.attractionsList = attractionsList;
    }

    public Suggested_Destinations_List getDestinations() {
        return destinations;
    }

    public void setDestinations(Suggested_Destinations_List destinations) {
        this.destinations = destinations;
    }

    public boolean isViator_error() {
        return viator_error;
    }

    public void setViator_error(boolean viator_error) {
        this.viator_error = viator_error;
    }
}
