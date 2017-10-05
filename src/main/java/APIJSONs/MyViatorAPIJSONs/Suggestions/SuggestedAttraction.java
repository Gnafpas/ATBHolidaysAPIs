package APIJSONs.MyViatorAPIJSONs.Suggestions;

/**
 * Created by George on 07/06/17.
 */
public class SuggestedAttraction {

    private String title;
    private String city;
    private String state;
    private double rating;
    private int seoId;

    public int getSeoId() {
        return seoId;
    }

    public void setSeoId(int seoId) {
        this.seoId = seoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
