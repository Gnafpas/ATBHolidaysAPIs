package Beans.ViatorAPIBeans.SearchFreetext;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George on 31/05/17.
 */
public class SearchFreetextProductData {

    private int sortOrder;
    private String supplierName;
    private String currencyCode;
    private List<Integer> catIds;
    private List<Integer> subCatIds;
    private String webURL;
    private String specialReservationDetails;
    private int panoramaCount;
    private boolean merchantCancellable;
    private String bookingEngineId;
    private int onRequestPeriod;
    private int primaryGroupId;
    private String pas;//todo Put correct type of atribute/
    private boolean available;
    private String productUrlName;
    private String primaryDestinationUrlName;
    private String title;
    private String shortDescription;
    private String admission;
    private BigDecimal price;
    private String supplierCode;
    private int translationLevel;
    private int photoCount;
    private int reviewCount;
    private int videoCount;
    private double rating;
    private int primaryDestinationId;
    private String primaryDestinationName;
    private String thumbnailURL;
    private String priceFormatted;
    private BigDecimal rrp;
    private String rrpformatted;
    private boolean onSale;
    private String thumbnailHiResURL;
    private String shortTitle;
    private String uniqueShortDescription;
    private BigDecimal merchantNetPriceFrom;
    private String merchantNetPriceFromFormatted;
    private BigDecimal savingAmount;
    private String savingAmountFormated;
    private boolean specialOfferAvailable;
    private String essential;
    private boolean specialReservation;
    private String duration;
    private String code;

    public int getPrimaryGroupId() {
        return primaryGroupId;
    }

    public void setPrimaryGroupId(int primaryGroupId) {
        this.primaryGroupId = primaryGroupId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public BigDecimal getRrp() {
        return rrp;
    }

    public void setRrp(BigDecimal rrp) {
        this.rrp = rrp;
    }

    public BigDecimal getMerchantNetPriceFrom() {
        return merchantNetPriceFrom;
    }


    public void setMerchantNetPriceFrom(BigDecimal merchantNetPriceFrom) {
        this.merchantNetPriceFrom = merchantNetPriceFrom;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<Integer> getCatIds() {
        return catIds;
    }

    public void setCatIds(List<Integer> catIds) {
        this.catIds = catIds;
    }

    public List<Integer> getSubCatIds() {
        return subCatIds;
    }

    public void setSubCatIds(List<Integer> subCatIds) {
        this.subCatIds = subCatIds;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public String getSpecialReservationDetails() {
        return specialReservationDetails;
    }

    public void setSpecialReservationDetails(String specialReservationDetails) {
        this.specialReservationDetails = specialReservationDetails;
    }

    public int getPanoramaCount() {
        return panoramaCount;
    }

    public void setPanoramaCount(int panoramaCount) {
        this.panoramaCount = panoramaCount;
    }

    public boolean isMerchantCancellable() {
        return merchantCancellable;
    }

    public void setMerchantCancellable(boolean merchantCancellable) {
        this.merchantCancellable = merchantCancellable;
    }

    public String getBookingEngineId() {
        return bookingEngineId;
    }

    public void setBookingEngineId(String bookingEngineId) {
        this.bookingEngineId = bookingEngineId;
    }

    public int getOnRequestPeriod() {
        return onRequestPeriod;
    }

    public void setOnRequestPeriod(int onRequestPeriod) {
        this.onRequestPeriod = onRequestPeriod;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getProductUrlName() {
        return productUrlName;
    }

    public void setProductUrlName(String productUrlName) {
        this.productUrlName = productUrlName;
    }

    public String getPrimaryDestinationUrlName() {
        return primaryDestinationUrlName;
    }

    public void setPrimaryDestinationUrlName(String primaryDestinationUrlName) {
        this.primaryDestinationUrlName = primaryDestinationUrlName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public int getTranslationLevel() {
        return translationLevel;
    }

    public void setTranslationLevel(int translationLevel) {
        this.translationLevel = translationLevel;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public int getPrimaryDestinationId() {
        return primaryDestinationId;
    }

    public void setPrimaryDestinationId(int primaryDestinationId) {
        this.primaryDestinationId = primaryDestinationId;
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

    public String getPriceFormatted() {
        return priceFormatted;
    }

    public void setPriceFormatted(String priceFormatted) {
        this.priceFormatted = priceFormatted;
    }

    public String getRrpformatted() {
        return rrpformatted;
    }

    public void setRrpformatted(String rrpformatted) {
        this.rrpformatted = rrpformatted;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public String getThumbnailHiResURL() {
        return thumbnailHiResURL;
    }

    public void setThumbnailHiResURL(String thumbnailHiResURL) {
        this.thumbnailHiResURL = thumbnailHiResURL;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getUniqueShortDescription() {
        return uniqueShortDescription;
    }

    public void setUniqueShortDescription(String uniqueShortDescription) {
        this.uniqueShortDescription = uniqueShortDescription;
    }

    public String getMerchantNetPriceFromFormatted() {
        return merchantNetPriceFromFormatted;
    }

    public void setMerchantNetPriceFromFormatted(String merchantNetPriceFromFormatted) {
        this.merchantNetPriceFromFormatted = merchantNetPriceFromFormatted;
    }

    public BigDecimal getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(BigDecimal savingAmount) {
        this.savingAmount = savingAmount;
    }

    public String getSavingAmountFormated() {
        return savingAmountFormated;
    }

    public void setSavingAmountFormated(String savingAmountFormated) {
        this.savingAmountFormated = savingAmountFormated;
    }

    public boolean isSpecialOfferAvailable() {
        return specialOfferAvailable;
    }

    public void setSpecialOfferAvailable(boolean specialOfferAvailable) {
        this.specialOfferAvailable = specialOfferAvailable;
    }

    public String getEssential() {
        return essential;
    }

    public void setEssential(String essential) {
        this.essential = essential;
    }

    public boolean isSpecialReservation() {
        return specialReservation;
    }

    public void setSpecialReservation(boolean specialReservation) {
        this.specialReservation = specialReservation;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
