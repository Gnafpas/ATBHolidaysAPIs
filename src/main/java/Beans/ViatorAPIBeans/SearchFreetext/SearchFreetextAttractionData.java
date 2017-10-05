package Beans.ViatorAPIBeans.SearchFreetext;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George on 07/06/17.
 */
public class SearchFreetextAttractionData {
    private int sortOrder;
    private String webURL;
    private String pageUrlName;
    private String primaryDestinationUrlName;
    private String publishedDate;
    private int panoramaCount;
    private String userName;
    private boolean showPhotos;
    private String descriptionIntro;
    private boolean showReviews;
    private String overviewSummary;
    private String pagePrimaryLanguage;
    private List<String> keywords;//todo Put correct type of atribute/
    private int reviewCount;
    private String seoType;
    private String pageTitle;
    private int keywordCount;
    private boolean editorsPick;
    private String descriptionText;
    private String tabTitle;
    private BigDecimal attractionLatitude;
    private BigDecimal attractionLongitude;
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
    private String thumbnailURL;
    private String thumbnailHiResURL;
    private String title=null;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
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

    public int getPanoramaCount() {
        return panoramaCount;
    }

    public void setPanoramaCount(int panoramaCount) {
        this.panoramaCount = panoramaCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isShowPhotos() {
        return showPhotos;
    }

    public void setShowPhotos(boolean showPhotos) {
        this.showPhotos = showPhotos;
    }

    public String getDescriptionIntro() {
        return descriptionIntro;
    }

    public void setDescriptionIntro(String descriptionIntro) {
        this.descriptionIntro = descriptionIntro;
    }

    public boolean isShowReviews() {
        return showReviews;
    }

    public void setShowReviews(boolean showReviews) {
        this.showReviews = showReviews;
    }

    public String getOverviewSummary() {
        return overviewSummary;
    }

    public void setOverviewSummary(String overviewSummary) {
        this.overviewSummary = overviewSummary;
    }

    public String getPagePrimaryLanguage() {
        return pagePrimaryLanguage;
    }

    public void setPagePrimaryLanguage(String pagePrimaryLanguage) {
        this.pagePrimaryLanguage = pagePrimaryLanguage;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getSeoType() {
        return seoType;
    }

    public void setSeoType(String seoType) {
        this.seoType = seoType;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public int getKeywordCount() {
        return keywordCount;
    }

    public void setKeywordCount(int keywordCount) {
        this.keywordCount = keywordCount;
    }

    public boolean isEditorsPick() {
        return editorsPick;
    }

    public void setEditorsPick(boolean editorsPick) {
        this.editorsPick = editorsPick;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public BigDecimal getAttractionLatitude() {
        return attractionLatitude;
    }

    public void setAttractionLatitude(BigDecimal attractionLatitude) {
        this.attractionLatitude = attractionLatitude;
    }

    public BigDecimal getAttractionLongitude() {
        return attractionLongitude;
    }

    public void setAttractionLongitude(BigDecimal attractionLongitude) {
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

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getThumbnailHiResURL() {
        return thumbnailHiResURL;
    }

    public void setThumbnailHiResURL(String thumbnailHiResURL) {
        this.thumbnailHiResURL = thumbnailHiResURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
