package APIJSONs.MyViatorAPIJSONs.Suggestions;

/**
 * Created by George on 06/06/17.
 */
public class Region {

    private String name;
    private String country;
    private int destinationId;

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
