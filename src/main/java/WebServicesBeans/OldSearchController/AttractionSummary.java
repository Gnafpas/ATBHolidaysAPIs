package WebServicesBeans.OldSearchController;

import java.net.URL;

/**
 * Created by George on 09/06/17.
 */
public class AttractionSummary {

    private String pagePrimaryLanguage;
    private int reviewCount;
    private String descriptionText;
    private String attractionCity;
    private String attractionState;
    private int seoId;
    private double rating;
    private String primaryDestinationName;
    private URL thumbnailURL;
    private URL thumbnailHiResURL;
    private String title;


    public String getPagePrimaryLanguage() {
        return pagePrimaryLanguage;
    }

    public void setPagePrimaryLanguage(String pagePrimaryLanguage) {
        this.pagePrimaryLanguage = pagePrimaryLanguage;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public String getAttractionCity() {
        return attractionCity;
    }

    public void setAttractionCity(String attractionCity) {
        this.attractionCity = attractionCity;
    }

    public String getAttractionState() {
        return attractionState;
    }

    public void setAttractionState(String attractionState) {
        this.attractionState = attractionState;
    }

    public int getSeoId() {
        return seoId;
    }

    public void setSeoId(int seoId) {
        this.seoId = seoId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPrimaryDestinationName() {
        return primaryDestinationName;
    }

    public void setPrimaryDestinationName(String primaryDestinationName) {
        this.primaryDestinationName = primaryDestinationName;
    }

    public URL getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(URL thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public URL getThumbnailHiResURL() {
        return thumbnailHiResURL;
    }

    public void setThumbnailHiResURL(URL thumbnailHiResURL) {
        this.thumbnailHiResURL = thumbnailHiResURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
