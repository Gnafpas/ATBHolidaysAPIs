package WebServicesBeans;

/**
 * Created by George on 07/06/17.
 */
public class Search_Freetext_Suggestions_JSON {

    private Products_List products;
    private Attractions_List attractionsList;
    private Destinations_List destinations;
    private boolean viator_error=false;

    public Products_List getProducts() {
        return products;
    }

    public void setProducts(Products_List products) {
        this.products = products;
    }

    public Attractions_List getAttractionsList() {
        return attractionsList;
    }

    public void setAttractionsList(Attractions_List attractionsList) {
        this.attractionsList = attractionsList;
    }

    public Destinations_List getDestinations() {
        return destinations;
    }

    public void setDestinations(Destinations_List destinations) {
        this.destinations = destinations;
    }

    public boolean isViator_error() {
        return viator_error;
    }

    public void setViator_error(boolean viator_error) {
        this.viator_error = viator_error;
    }
}
