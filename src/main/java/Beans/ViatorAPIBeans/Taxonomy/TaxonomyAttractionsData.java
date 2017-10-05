package Beans.ViatorAPIBeans.Taxonomy;

import java.net.URL;

/**
 * Created by George on 06/06/17.
 */
public class TaxonomyAttractionsData {
    private int sortOrder;
    private URL webURL;
    private String pageUrlName;
    private String primaryDestinationUrlName;
    private String publishedDate;
    private double attractionLatitude;
    private double attractionLongitude;
    private String attractionStreetAddress;
    private String attractionCity;
    private String attractionState;
    private int destinationId;
    private int seoId=0;
    private int productCount;
    private int photoCount;
    private int primaryDestinationId;
    private double rating;
    private String primaryDestinationName;
    private URL thumbnailURL;
    private URL thumbnailHiResURL;
    private String title;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public URL getWebURL() {
        return webURL;
    }

    public void setWebURL(URL webURL) {
        this.webURL = webURL;
    }

    public String getPageUrlName() {
        return pageUrlName;
    }

    public void setPageUrlName(String pageUrlName) {
        this.pageUrlName = pageUrlName;
    }

    public String getPrimaryDestinationUrlName() {
        return primaryDestinationUrlName;
    }

    public void setPrimaryDestinationUrlName(String primaryDestinationUrlName) {
        this.primaryDestinationUrlName = primaryDestinationUrlName;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public double getAttractionLatitude() {
        return attractionLatitude;
    }

    public void setAttractionLatitude(double attractionLatitude) {
        this.attractionLatitude = attractionLatitude;
    }

    public double getAttractionLongitude() {
        return attractionLongitude;
    }

    public void setAttractionLongitude(double attractionLongitude) {
        this.attractionLongitude = attractionLongitude;
    }

    public String getAttractionStreetAddress() {
        return attractionStreetAddress;
    }

    public void setAttractionStreetAddress(String attractionStreetAddress) {
        this.attractionStreetAddress = attractionStreetAddress;
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

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public int getSeoId() {
        return seoId;
    }

    public void setSeoId(int seoId) {
        this.seoId = seoId;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public int getPrimaryDestinationId() {
        return primaryDestinationId;
    }

    public void setPrimaryDestinationId(int primaryDestinationId) {
        this.primaryDestinationId = primaryDestinationId;
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
