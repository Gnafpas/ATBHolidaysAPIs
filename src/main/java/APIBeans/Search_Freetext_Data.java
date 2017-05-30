package APIBeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by George on 30/05/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Search_Freetext_Data {

//    private int sortOrder;
//    private String supplierName;
//    private String currencyCode;
//    private List<Integer> catIds=new ArrayList();
//    private List<Integer> subCatIds=new ArrayList();
//    private URL webURL;
//    private String specialReservationDetails;
//    private int panoramaCount;
//    private boolean merchantCancellable;
//    private String bookingEngineId;
//    private String onRequestPeriod;
//    private String primaryGroupId;
//    private String pas;
//    private boolean available;
//    private String productUrlName;
//    private String primaryDestinationUrlName;
//    private String title;
//    private String shortDescription;
//    private String admission;
//    private double price;
//    private String supplierCode;
//    private int translationLevel;
//    private int photoCount;
//    private int reviewCount;
//    private int videoCount;
//    private int rating;
//    private int primaryDestinationId;
//    private String primaryDestinationName;
//    private URL thumbnailURL;
//    private double priceFormatted;
//    private int rrp;
//    private String rrpformatted;
//    private boolean onSale;
//    private URL thumbnailHiResURL;
//    private String shortTitle;
//    private String uniqueShortDescription;
//    private boolean merchantNetPriceFrom;
//    private String merchantNetPriceFromFormatted;
//    private int savingAmount;
//    private String savingAmountFormated;
//    private boolean specialOfferAvailable;
//    private String essential;
//    private boolean specialReservation;
//    private String duration;
//    private String code;
//
//
//    public int getSortOrder() {
//        return sortOrder;
//    }
//
//    public void setSortOrder(int sortOrder) {
//        this.sortOrder = sortOrder;
//    }
//
//    public String getSupplierName() {
//        return supplierName;
//    }
//
//    public void setSupplierName(String supplierName) {
//        this.supplierName = supplierName;
//    }
//
//    public String getCurrencyCode() {
//        return currencyCode;
//    }
//
//    public void setCurrencyCode(String currencyCode) {
//        this.currencyCode = currencyCode;
//    }
//
//    public List<Integer> getCatIds() {
//        return catIds;
//    }
//
//    public void setCatIds(List<Integer> catIds) {
//        this.catIds = catIds;
//    }
//
//    public List<Integer> getSubCatIds() {
//        return subCatIds;
//    }
//
//    public void setSubCatIds(List<Integer> subCatIds) {
//        this.subCatIds = subCatIds;
//    }
//
//    public URL getWebURL() {
//        return webURL;
//    }
//
//    public void setWebURL(URL webURL) {
//        this.webURL = webURL;
//    }
//
//    public String getSpecialReservationDetails() {
//        return specialReservationDetails;
//    }
//
//    public void setSpecialReservationDetails(String specialReservationDetails) {
//        this.specialReservationDetails = specialReservationDetails;
//    }
//
//    public int getPanoramaCount() {
//        return panoramaCount;
//    }
//
//    public void setPanoramaCount(int panoramaCount) {
//        this.panoramaCount = panoramaCount;
//    }
//
//    public boolean isMerchantCancellable() {
//        return merchantCancellable;
//    }
//
//    public void setMerchantCancellable(boolean merchantCancellable) {
//        this.merchantCancellable = merchantCancellable;
//    }
//
//    public String getBookingEngineId() {
//        return bookingEngineId;
//    }
//
//    public void setBookingEngineId(String bookingEngineId) {
//        this.bookingEngineId = bookingEngineId;
//    }
//
//    public String getOnRequestPeriod() {
//        return onRequestPeriod;
//    }
//
//    public void setOnRequestPeriod(String onRequestPeriod) {
//        this.onRequestPeriod = onRequestPeriod;
//    }
//
//    public String getPrimaryGroupId() {
//        return primaryGroupId;
//    }
//
//    public void setPrimaryGroupId(String primaryGroupId) {
//        this.primaryGroupId = primaryGroupId;
//    }
//
//    public String getPas() {
//        return pas;
//    }
//
//    public void setPas(String pas) {
//        this.pas = pas;
//    }
//
//    public boolean isAvailable() {
//        return available;
//    }
//
//    public void setAvailable(boolean available) {
//        this.available = available;
//    }
//
//    public String getProductUrlName() {
//        return productUrlName;
//    }
//
//    public void setProductUrlName(String productUrlName) {
//        this.productUrlName = productUrlName;
//    }
//
//    public String getPrimaryDestinationUrlName() {
//        return primaryDestinationUrlName;
//    }
//
//    public void setPrimaryDestinationUrlName(String primaryDestinationUrlName) {
//        this.primaryDestinationUrlName = primaryDestinationUrlName;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getShortDescription() {
//        return shortDescription;
//    }
//
//    public void setShortDescription(String shortDescription) {
//        this.shortDescription = shortDescription;
//    }
//
//    public String getAdmission() {
//        return admission;
//    }
//
//    public void setAdmission(String admission) {
//        this.admission = admission;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getSupplierCode() {
//        return supplierCode;
//    }
//
//    public void setSupplierCode(String supplierCode) {
//        this.supplierCode = supplierCode;
//    }
//
//    public int getTranslationLevel() {
//        return translationLevel;
//    }
//
//    public void setTranslationLevel(int translationLevel) {
//        this.translationLevel = translationLevel;
//    }
//
//    public int getPhotoCount() {
//        return photoCount;
//    }
//
//    public void setPhotoCount(int photoCount) {
//        this.photoCount = photoCount;
//    }
//
//    public int getReviewCount() {
//        return reviewCount;
//    }
//
//    public void setReviewCount(int reviewCount) {
//        this.reviewCount = reviewCount;
//    }
//
//    public int getVideoCount() {
//        return videoCount;
//    }
//
//    public void setVideoCount(int videoCount) {
//        this.videoCount = videoCount;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public int getPrimaryDestinationId() {
//        return primaryDestinationId;
//    }
//
//    public void setPrimaryDestinationId(int primaryDestinationId) {
//        this.primaryDestinationId = primaryDestinationId;
//    }
//
//    public String getPrimaryDestinationName() {
//        return primaryDestinationName;
//    }
//
//    public void setPrimaryDestinationName(String primaryDestinationName) {
//        this.primaryDestinationName = primaryDestinationName;
//    }
//
//    public URL getThumbnailURL() {
//        return thumbnailURL;
//    }
//
//    public void setThumbnailURL(URL thumbnailURL) {
//        this.thumbnailURL = thumbnailURL;
//    }
//
//    public double getPriceFormatted() {
//        return priceFormatted;
//    }
//
//    public void setPriceFormatted(double priceFormatted) {
//        this.priceFormatted = priceFormatted;
//    }
//
//    public int getRrp() {
//        return rrp;
//    }
//
//    public void setRrp(int rrp) {
//        this.rrp = rrp;
//    }
//
//    public String getRrpformatted() {
//        return rrpformatted;
//    }
//
//    public void setRrpformatted(String rrpformatted) {
//        this.rrpformatted = rrpformatted;
//    }
//
//    public boolean isOnSale() {
//        return onSale;
//    }
//
//    public void setOnSale(boolean onSale) {
//        this.onSale = onSale;
//    }
//
//    public URL getThumbnailHiResURL() {
//        return thumbnailHiResURL;
//    }
//
//    public void setThumbnailHiResURL(URL thumbnailHiResURL) {
//        this.thumbnailHiResURL = thumbnailHiResURL;
//    }
//
//    public String getShortTitle() {
//        return shortTitle;
//    }
//
//    public void setShortTitle(String shortTitle) {
//        this.shortTitle = shortTitle;
//    }
//
//    public String getUniqueShortDescription() {
//        return uniqueShortDescription;
//    }
//
//    public void setUniqueShortDescription(String uniqueShortDescription) {
//        this.uniqueShortDescription = uniqueShortDescription;
//    }
//
//    public boolean isMerchantNetPriceFrom() {
//        return merchantNetPriceFrom;
//    }
//
//    public void setMerchantNetPriceFrom(boolean merchantNetPriceFrom) {
//        this.merchantNetPriceFrom = merchantNetPriceFrom;
//    }
//
//    public String getMerchantNetPriceFromFormatted() {
//        return merchantNetPriceFromFormatted;
//    }
//
//    public void setMerchantNetPriceFromFormatted(String merchantNetPriceFromFormatted) {
//        this.merchantNetPriceFromFormatted = merchantNetPriceFromFormatted;
//    }
//
//    public int getSavingAmount() {
//        return savingAmount;
//    }
//
//    public void setSavingAmount(int savingAmount) {
//        this.savingAmount = savingAmount;
//    }
//
//    public String getSavingAmountFormated() {
//        return savingAmountFormated;
//    }
//
//    public void setSavingAmountFormated(String savingAmountFormated) {
//        this.savingAmountFormated = savingAmountFormated;
//    }
//
//    public boolean isSpecialOfferAvailable() {
//        return specialOfferAvailable;
//    }
//
//    public void setSpecialOfferAvailable(boolean specialOfferAvailable) {
//        this.specialOfferAvailable = specialOfferAvailable;
//    }
//
//    public String getEssential() {
//        return essential;
//    }
//
//    public void setEssential(String essential) {
//        this.essential = essential;
//    }
//
//    public boolean isSpecialReservation() {
//        return specialReservation;
//    }
//
//    public void setSpecialReservation(boolean specialReservation) {
//        this.specialReservation = specialReservation;
//    }
//
//    public String getDuration() {
//        return duration;
//    }
//
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }


    private int sortOrder;
    private boolean selectable;
    private String destinationUrlName;
    private String defaultCurrencyCode;
    private String lookupId;
    private int parentId;
    private String timeZone;
    private String iataCode;
    private int destinationId;
    private String destinationType;
    private String destinationName;
    private double latitude;
    private double longitude;


    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public String getDestinationUrlName() {
        return destinationUrlName;
    }

    public void setDestinationUrlName(String destinationUrlName) {
        this.destinationUrlName = destinationUrlName;
    }

    public String getDefaultCurrencyCode() {
        return defaultCurrencyCode;
    }

    public void setDefaultCurrencyCode(String defaultCurrencyCode) {
        this.defaultCurrencyCode = defaultCurrencyCode;
    }

    public String getLookupId() {
        return lookupId;
    }

    public void setLookupId(String lookupId) {
        this.lookupId = lookupId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(String destinationType) {
        this.destinationType = destinationType;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}


