package APIJSONs.ATBAPIJSONs.Product;

/**
 * Created by George on 02/04/2018.
 */
public class ProductOptions {

    private int id;
    private String productId;
    private String guidingLive;
    private String guidingAudio;
    private String guidingBooklets;
    private String duration;
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getGuidingLive() {
        return guidingLive;
    }

    public void setGuidingLive(String guidingLive) {
        this.guidingLive = guidingLive;
    }

    public String getGuidingAudio() {
        return guidingAudio;
    }

    public void setGuidingAudio(String guidingAudio) {
        this.guidingAudio = guidingAudio;
    }

    public String getGuidingBooklets() {
        return guidingBooklets;
    }

    public void setGuidingBooklets(String guidingBooklets) {
        this.guidingBooklets = guidingBooklets;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
