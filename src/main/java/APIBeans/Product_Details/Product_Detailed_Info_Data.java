package APIBeans.Product_Details;

import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * Created by George on 10/06/17.
 */
public class Product_Detailed_Info_Data {

    private String supplierName;
    private String currencyCode;
    private List<Integer> catIds;
    private List<Integer> subCatIds;
    private URL webURL;
    private Object specialReservationDetails;//todo Put correct type of atribute/
    private int panoramaCount;
    private boolean merchantCancellable;
    private String bookingEngineId;
    private int onRequestPeriod;
    private int primaryGroupId;
    private Object pas;//todo Put correct type of atribute/
    private boolean available;
    private String productUrlName;
    private String primaryDestinationUrlName;
    private String voucherRequirements;
    private boolean tourGradesAvailable;
    private boolean hotelPickup;
    private Object userPhotos;//todo Put correct type of atribute/
    private Object reviews;//todo Put correct type of atribute/
    private Object videos;//todo Put correct type of atribute/
    private List<Product_Detail_tourGrades> tourGrades;//todo Put correct type of atribute/
    private List<Product_Detail_ageBands> ageBands;//todo Put correct type of atribute/
    private List<Object> bookingQuestions;//todo Put correct type of atribute/
    private Object passengerAttributes;//todo Put correct type of atribute/
    private Object highlights;//todo Put correct type of atribute/
    private List<String> salesPoints;
    private HashMap ratingCounts;//todo Put correct type of atribute/
    private Object termsAndConditions;//todo Put correct type of atribute/
    private int maxTravellerCount;
    private String operates;
    private boolean allTravellerNamesRequired;
    private boolean applePassSupported;
    private String itinerary;
    private int destinationId;
    private List<String> inclusions;
    private String voucherOption;
    private List<String> additionalInfo;
    private List<Product_Detail_productPhotos> productPhotos;//todo Put correct type of atribute/
    private String departureTime;
    private String departurePoint;
    private String departureTimeComments;
    private String city;
    private URL mapURL;
    private String specialOffer;
    private String returnDetails;
    private List<String> exclusions;
    private String description;
    private String location;
    private String country;
    private String region;
    private String duration;
    private String title;
    private String shortDescription;
    private double price;
    private String supplierCode;
    private boolean specialReservation;
    private int translationLevel;//todo Put correct type of atribute/
    private String priceFormatted;
    private double rrp;
    private String rrpformatted;
    private boolean onSale;
    private int videoCount;
    private double rating;
    private URL thumbnailHiResURL;
    private int photoCount;
    private int reviewCount;
    private int primaryDestinationId;
    private String primaryDestinationName;
    private URL thumbnailURL;
    private double merchantNetPriceFrom;
    private String merchantNetPriceFromFormatted;
    private String savingAmountFormated;
    private boolean specialOfferAvailable;
    private Object essential;//todo Put correct type of atribute/
    private Object admission;//todo Put correct type of atribute/
    private String shortTitle;
    private double savingAmount;
    private String code;

    public Object getSpecialReservationDetails() {
        return specialReservationDetails;
    }

    public void setSpecialReservationDetails(Object specialReservationDetails) {
        this.specialReservationDetails = specialReservationDetails;
    }

    public Object getPas() {
        return pas;
    }

    public void setPas(Object pas) {
        this.pas = pas;
    }

    public Object getUserPhotos() {
        return userPhotos;
    }

    public void setUserPhotos(Object userPhotos) {
        this.userPhotos = userPhotos;
    }

    public Object getReviews() {
        return reviews;
    }

    public void setReviews(Object reviews) {
        this.reviews = reviews;
    }

    public Object getVideos() {
        return videos;
    }

    public void setVideos(Object videos) {
        this.videos = videos;
    }

    public List<Product_Detail_tourGrades> getTourGrades() {
        return tourGrades;
    }

    public void setTourGrades(List<Product_Detail_tourGrades> tourGrades) {
        this.tourGrades = tourGrades;
    }

    public List<Product_Detail_ageBands> getAgeBands() {
        return ageBands;
    }

    public void setAgeBands(List<Product_Detail_ageBands> ageBands) {
        this.ageBands = ageBands;
    }

    public List<Object> getBookingQuestions() {
        return bookingQuestions;
    }

    public void setBookingQuestions(List<Object> bookingQuestions) {
        this.bookingQuestions = bookingQuestions;
    }

    public Object getPassengerAttributes() {
        return passengerAttributes;
    }

    public void setPassengerAttributes(Object passengerAttributes) {
        this.passengerAttributes = passengerAttributes;
    }

    public Object getHighlights() {
        return highlights;
    }

    public void setHighlights(Object highlights) {
        this.highlights = highlights;
    }

    public HashMap getRatingCounts() {
        return ratingCounts;
    }

    public void setRatingCounts(HashMap ratingCounts) {
        this.ratingCounts = ratingCounts;
    }

    public Object getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(Object termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public List<Product_Detail_productPhotos> getProductPhotos() {
        return productPhotos;
    }

    public void setProductPhotos(List<Product_Detail_productPhotos> productPhotos) {
        this.productPhotos = productPhotos;
    }

    public int getTranslationLevel() {
        return translationLevel;
    }

    public void setTranslationLevel(int translationLevel) {
        this.translationLevel = translationLevel;
    }

    public Object getEssential() {
        return essential;
    }

    public void setEssential(Object essential) {
        this.essential = essential;
    }

    public Object getAdmission() {
        return admission;
    }

    public void setAdmission(Object admission) {
        this.admission = admission;
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


    public URL getWebURL() {
        return webURL;
    }

    public void setWebURL(URL webURL) {
        this.webURL = webURL;
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

    public int getPrimaryGroupId() {
        return primaryGroupId;
    }

    public void setPrimaryGroupId(int primaryGroupId) {
        this.primaryGroupId = primaryGroupId;
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

    public String getVoucherRequirements() {
        return voucherRequirements;
    }

    public void setVoucherRequirements(String voucherRequirements) {
        this.voucherRequirements = voucherRequirements;
    }

    public boolean isTourGradesAvailable() {
        return tourGradesAvailable;
    }

    public void setTourGradesAvailable(boolean tourGradesAvailable) {
        this.tourGradesAvailable = tourGradesAvailable;
    }

    public boolean isHotelPickup() {
        return hotelPickup;
    }

    public void setHotelPickup(boolean hotelPickup) {
        this.hotelPickup = hotelPickup;
    }

    public List<String> getSalesPoints() {
        return salesPoints;
    }

    public void setSalesPoints(List<String> salesPoints) {
        this.salesPoints = salesPoints;
    }

    public int getMaxTravellerCount() {
        return maxTravellerCount;
    }

    public void setMaxTravellerCount(int maxTravellerCount) {
        this.maxTravellerCount = maxTravellerCount;
    }

    public String getOperates() {
        return operates;
    }

    public void setOperates(String operates) {
        this.operates = operates;
    }

    public boolean isAllTravellerNamesRequired() {
        return allTravellerNamesRequired;
    }

    public void setAllTravellerNamesRequired(boolean allTravellerNamesRequired) {
        this.allTravellerNamesRequired = allTravellerNamesRequired;
    }

    public boolean isApplePassSupported() {
        return applePassSupported;
    }

    public void setApplePassSupported(boolean applePassSupported) {
        this.applePassSupported = applePassSupported;
    }

    public String getItinerary() {
        return itinerary;
    }

    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public List<String> getInclusions() {
        return inclusions;
    }

    public void setInclusions(List<String> inclusions) {
        this.inclusions = inclusions;
    }

    public String getVoucherOption() {
        return voucherOption;
    }

    public void setVoucherOption(String voucherOption) {
        this.voucherOption = voucherOption;
    }

    public List<String> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(List<String> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getDepartureTimeComments() {
        return departureTimeComments;
    }

    public void setDepartureTimeComments(String departureTimeComments) {
        this.departureTimeComments = departureTimeComments;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public URL getMapURL() {
        return mapURL;
    }

    public void setMapURL(URL mapURL) {
        this.mapURL = mapURL;
    }

    public String getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(String specialOffer) {
        this.specialOffer = specialOffer;
    }

    public String getReturnDetails() {
        return returnDetails;
    }

    public void setReturnDetails(String returnDetails) {
        this.returnDetails = returnDetails;
    }

    public List<String> getExclusions() {
        return exclusions;
    }

    public void setExclusions(List<String> exclusions) {
        this.exclusions = exclusions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public boolean isSpecialReservation() {
        return specialReservation;
    }

    public void setSpecialReservation(boolean specialReservation) {
        this.specialReservation = specialReservation;
    }

    public String getPriceFormatted() {
        return priceFormatted;
    }

    public void setPriceFormatted(String priceFormatted) {
        this.priceFormatted = priceFormatted;
    }

    public double getRrp() {
        return rrp;
    }

    public void setRrp(double rrp) {
        this.rrp = rrp;
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

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public URL getThumbnailHiResURL() {
        return thumbnailHiResURL;
    }

    public void setThumbnailHiResURL(URL thumbnailHiResURL) {
        this.thumbnailHiResURL = thumbnailHiResURL;
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

    public URL getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(URL thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public double getMerchantNetPriceFrom() {
        return merchantNetPriceFrom;
    }

    public void setMerchantNetPriceFrom(double merchantNetPriceFrom) {
        this.merchantNetPriceFrom = merchantNetPriceFrom;
    }

    public String getMerchantNetPriceFromFormatted() {
        return merchantNetPriceFromFormatted;
    }

    public void setMerchantNetPriceFromFormatted(String merchantNetPriceFromFormatted) {
        this.merchantNetPriceFromFormatted = merchantNetPriceFromFormatted;
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

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public double getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(double savingAmount) {
        this.savingAmount = savingAmount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
