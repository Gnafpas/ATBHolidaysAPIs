package Beans.ViatorAPIBeans.ProductDetails;

/**
 * Created by George on 19/06/17.
 */
public class ProductDetailVideos {

    private String productCode;
    private String videoId;
    private String photoURL;
    private String caption;
    private String shortDescription;
    private String title;
    private String productTitle;
    private String description;
    private String thumbnailURL;
    private String copyright;
    private String photoHiResURL;
    private String source;//todo change to enum
    private boolean privatE;
    private int ownerId;
    private String ownerName;
    private String ownerCountry;
    private String ownerAvatarURL;
    private int sortOrder;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public boolean isPrivatE() {
        return privatE;
    }

    public void setPrivatE(boolean privatE) {
        this.privatE = privatE;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getPhotoHiResURL() {
        return photoHiResURL;
    }

    public void setPhotoHiResURL(String photoHiResURL) {
        this.photoHiResURL = photoHiResURL;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isPrivat() {
        return privatE;
    }

    public void setPrivat(boolean privat) {
        this.privatE = privat;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerCountry() {
        return ownerCountry;
    }

    public void setOwnerCountry(String ownerCountry) {
        this.ownerCountry = ownerCountry;
    }

    public String getOwnerAvatarURL() {
        return ownerAvatarURL;
    }

    public void setOwnerAvatarURL(String ownerAvatarURL) {
        this.ownerAvatarURL = ownerAvatarURL;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }
}
