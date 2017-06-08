package WebServicesBeans;

/**
 * Created by George on 07/06/17.
 */
public class Search_Freetext_JSON {

    private Products_Search products;
    private Attractions_Search attractions;
    private Destinations_Search destinations;
    private boolean viator_error=false;

    public Products_Search getProducts() {
        return products;
    }

    public void setProducts(Products_Search products) {
        this.products = products;
    }

    public Attractions_Search getAttractions() {
        return attractions;
    }

    public void setAttractions(Attractions_Search attractions) {
        this.attractions = attractions;
    }

    public Destinations_Search getDestinations() {
        return destinations;
    }

    public void setDestinations(Destinations_Search destinations) {
        this.destinations = destinations;
    }

    public boolean isViator_error() {
        return viator_error;
    }

    public void setViator_error(boolean viator_error) {
        this.viator_error = viator_error;
    }
}
