package APIBeans.Product_Details;

import java.net.URL;

/**
 * Created by George on 10/06/17.
 */
public class Product_Detail_productPhotos {

    private String photoURL;
    private String supplier;
    private String caption;

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
