package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by George on 17/07/2017.
 */
@Entity
@Table(name = "viator_attractions", schema = "develope_viator", catalog = "")
public class ViatorAttractionsBean {
    private int seoId;
    private String webUrl;
    private String pageUrlName;
    private String primaryDestinationUrlName;
    private String publishedDate;
    private String userName;
    private String pageTitle;
    private boolean editorsPick;
    private String descriptionIntro;
    private String descriptionText;
    private String overviewSummary;
    private String pagePrimaryLanguage;
    private Integer destinationId;
    private Integer primaryDestinationId;
    private String thumbnailHiResUrl;
    private String primaryDestinationName;
    private String thumbnailUrl;
    private Integer productCount;
    private Double rating;
    private BigDecimal attractionLatitude;
    private BigDecimal attractionLongitude;
    private String attractionStreetAddress;
    private String attractionCity;
    private String attractionState;
    private String title;
    private Timestamp updatedAt;

    @Id
    @Column(name = "seo_id")
    public int getSeoId() {
        return seoId;
    }

    public void setSeoId(int seoId) {
        this.seoId = seoId;
    }

    @Basic
    @Column(name = "web_URL")
    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @Basic
    @Column(name = "page_Url_Name")
    public String getPageUrlName() {
        return pageUrlName;
    }

    public void setPageUrlName(String pageUrlName) {
        this.pageUrlName = pageUrlName;
    }

    @Basic
    @Column(name = "primary_Destination_Url_Name")
    public String getPrimaryDestinationUrlName() {
        return primaryDestinationUrlName;
    }

    public void setPrimaryDestinationUrlName(String primaryDestinationUrlName) {
        this.primaryDestinationUrlName = primaryDestinationUrlName;
    }

    @Basic
    @Column(name = "published_Date")
    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Basic
    @Column(name = "user_Name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "page_Title")
    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    @Basic
    @Column(name = "editors_Pick")
    public boolean getEditorsPick() {
        return editorsPick;
    }

    public void setEditorsPick(boolean editorsPick) {
        this.editorsPick = editorsPick;
    }

    @Basic
    @Column(name = "description_Intro")
    public String getDescriptionIntro() {
        return descriptionIntro;
    }

    public void setDescriptionIntro(String descriptionIntro) {
        this.descriptionIntro = descriptionIntro;
    }

    @Basic
    @Column(name = "description_Text")
    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    @Basic
    @Column(name = "overview_Summary")
    public String getOverviewSummary() {
        return overviewSummary;
    }

    public void setOverviewSummary(String overviewSummary) {
        this.overviewSummary = overviewSummary;
    }

    @Basic
    @Column(name = "page_Primary_Language")
    public String getPagePrimaryLanguage() {
        return pagePrimaryLanguage;
    }

    public void setPagePrimaryLanguage(String pagePrimaryLanguage) {
        this.pagePrimaryLanguage = pagePrimaryLanguage;
    }

    @Basic
    @Column(name = "destination_Id")
    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    @Basic
    @Column(name = "primary_Destination_Id")
    public Integer getPrimaryDestinationId() {
        return primaryDestinationId;
    }

    public void setPrimaryDestinationId(Integer primaryDestinationId) {
        this.primaryDestinationId = primaryDestinationId;
    }

    @Basic
    @Column(name = "thumbnail_HiRes_URL")
    public String getThumbnailHiResUrl() {
        return thumbnailHiResUrl;
    }

    public void setThumbnailHiResUrl(String thumbnailHiResUrl) {
        this.thumbnailHiResUrl = thumbnailHiResUrl;
    }

    @Basic
    @Column(name = "primary_Destination_Name")
    public String getPrimaryDestinationName() {
        return primaryDestinationName;
    }

    public void setPrimaryDestinationName(String primaryDestinationName) {
        this.primaryDestinationName = primaryDestinationName;
    }

    @Basic
    @Column(name = "thumbnail_URL")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Basic
    @Column(name = "product_Count")
    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    @Basic
    @Column(name = "rating")
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "attraction_Latitude")
    public BigDecimal getAttractionLatitude() {
        return attractionLatitude;
    }

    public void setAttractionLatitude(BigDecimal attractionLatitude) {
        this.attractionLatitude = attractionLatitude;
    }

    @Basic
    @Column(name = "attraction_Longitude")
    public BigDecimal getAttractionLongitude() {
        return attractionLongitude;
    }

    public void setAttractionLongitude(BigDecimal attractionLongitude) {
        this.attractionLongitude = attractionLongitude;
    }

    @Basic
    @Column(name = "attraction_Street_Address")
    public String getAttractionStreetAddress() {
        return attractionStreetAddress;
    }

    public void setAttractionStreetAddress(String attractionStreetAddress) {
        this.attractionStreetAddress = attractionStreetAddress;
    }

    @Basic
    @Column(name = "attraction_City")
    public String getAttractionCity() {
        return attractionCity;
    }

    public void setAttractionCity(String attractionCity) {
        this.attractionCity = attractionCity;
    }

    @Basic
    @Column(name = "attraction_State")
    public String getAttractionState() {
        return attractionState;
    }

    public void setAttractionState(String attractionState) {
        this.attractionState = attractionState;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViatorAttractionsBean that = (ViatorAttractionsBean) o;

        if (seoId != that.seoId) return false;
        if (editorsPick != that.editorsPick) return false;
        if (webUrl != null ? !webUrl.equals(that.webUrl) : that.webUrl != null) return false;
        if (pageUrlName != null ? !pageUrlName.equals(that.pageUrlName) : that.pageUrlName != null) return false;
        if (primaryDestinationUrlName != null ? !primaryDestinationUrlName.equals(that.primaryDestinationUrlName) : that.primaryDestinationUrlName != null)
            return false;
        if (publishedDate != null ? !publishedDate.equals(that.publishedDate) : that.publishedDate != null)
            return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (pageTitle != null ? !pageTitle.equals(that.pageTitle) : that.pageTitle != null) return false;
        if (descriptionIntro != null ? !descriptionIntro.equals(that.descriptionIntro) : that.descriptionIntro != null)
            return false;
        if (descriptionText != null ? !descriptionText.equals(that.descriptionText) : that.descriptionText != null)
            return false;
        if (overviewSummary != null ? !overviewSummary.equals(that.overviewSummary) : that.overviewSummary != null)
            return false;
        if (pagePrimaryLanguage != null ? !pagePrimaryLanguage.equals(that.pagePrimaryLanguage) : that.pagePrimaryLanguage != null)
            return false;
        if (destinationId != null ? !destinationId.equals(that.destinationId) : that.destinationId != null)
            return false;
        if (primaryDestinationId != null ? !primaryDestinationId.equals(that.primaryDestinationId) : that.primaryDestinationId != null)
            return false;
        if (thumbnailHiResUrl != null ? !thumbnailHiResUrl.equals(that.thumbnailHiResUrl) : that.thumbnailHiResUrl != null)
            return false;
        if (primaryDestinationName != null ? !primaryDestinationName.equals(that.primaryDestinationName) : that.primaryDestinationName != null)
            return false;
        if (thumbnailUrl != null ? !thumbnailUrl.equals(that.thumbnailUrl) : that.thumbnailUrl != null) return false;
        if (productCount != null ? !productCount.equals(that.productCount) : that.productCount != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (attractionLatitude != null ? !attractionLatitude.equals(that.attractionLatitude) : that.attractionLatitude != null)
            return false;
        if (attractionLongitude != null ? !attractionLongitude.equals(that.attractionLongitude) : that.attractionLongitude != null)
            return false;
        if (attractionStreetAddress != null ? !attractionStreetAddress.equals(that.attractionStreetAddress) : that.attractionStreetAddress != null)
            return false;
        if (attractionCity != null ? !attractionCity.equals(that.attractionCity) : that.attractionCity != null)
            return false;
        if (attractionState != null ? !attractionState.equals(that.attractionState) : that.attractionState != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seoId;
        result = 31 * result + (webUrl != null ? webUrl.hashCode() : 0);
        result = 31 * result + (pageUrlName != null ? pageUrlName.hashCode() : 0);
        result = 31 * result + (primaryDestinationUrlName != null ? primaryDestinationUrlName.hashCode() : 0);
        result = 31 * result + (publishedDate != null ? publishedDate.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (pageTitle != null ? pageTitle.hashCode() : 0);
        result = 31 * result + help(editorsPick);
        result = 31 * result + (descriptionIntro != null ? descriptionIntro.hashCode() : 0);
        result = 31 * result + (descriptionText != null ? descriptionText.hashCode() : 0);
        result = 31 * result + (overviewSummary != null ? overviewSummary.hashCode() : 0);
        result = 31 * result + (pagePrimaryLanguage != null ? pagePrimaryLanguage.hashCode() : 0);
        result = 31 * result + (destinationId != null ? destinationId.hashCode() : 0);
        result = 31 * result + (primaryDestinationId != null ? primaryDestinationId.hashCode() : 0);
        result = 31 * result + (thumbnailHiResUrl != null ? thumbnailHiResUrl.hashCode() : 0);
        result = 31 * result + (primaryDestinationName != null ? primaryDestinationName.hashCode() : 0);
        result = 31 * result + (thumbnailUrl != null ? thumbnailUrl.hashCode() : 0);
        result = 31 * result + (productCount != null ? productCount.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (attractionLatitude != null ? attractionLatitude.hashCode() : 0);
        result = 31 * result + (attractionLongitude != null ? attractionLongitude.hashCode() : 0);
        result = 31 * result + (attractionStreetAddress != null ? attractionStreetAddress.hashCode() : 0);
        result = 31 * result + (attractionCity != null ? attractionCity.hashCode() : 0);
        result = 31 * result + (attractionState != null ? attractionState.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    private int help(boolean attribute){
        if(attribute){return 1;}else{return 0;}
    }
}
