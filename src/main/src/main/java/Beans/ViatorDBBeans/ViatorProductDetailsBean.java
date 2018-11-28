package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * Created by George on 03/07/2017.
 */
@Entity
@Table(name = "viator_product_details", schema = "develope_viator", catalog = "")
public class ViatorProductDetailsBean {
    private String code;
    private int primaryDestinationId;
    private Integer destinationId;
    private Integer primaryGroupId;
    private String supplierCode;
    private String bookingEngineId;
    private String titleEn;
    private String shortTitleEn;
    private String highlightsEn;
    private String primaryDestinationNameEn;
    private String locationEn;
    private String cityEn;
    private String countryEn;
    private String regionEn;
    private String departurePoint;
    private String operatesEn;
    private String returnDetails;
    private String shortDescriptionEn;
    private String descriptionEn;
    private String voucherRequirementsEn;
    private String duration;
    private String thumbnailUrl;
    private String thumbnailHiResUrl;
    private String webUrl;
    private String currencyCode;
    private BigDecimal price;
    private BigDecimal rrp;
    private BigDecimal merchantNetPriceFrom;
    private BigDecimal savingAmount;
    private Double rating;
    private String voucherOption;
    private String departureTimeEn;
    private String departureTimeCommentsEn;
    private Integer onRequestPeriod;
    private Integer sortOrder;
    private String supplierName;
    private boolean specialReservation;
    private String specialReservationDetails;
    private String itineraryEn;
    private String termsAndConditionsEn;
    private boolean merchantCancellable;
    private boolean onSale;
    private boolean specialOfferAvailable;
    private String specialOfferEn;
    private boolean tourGradesAvailable;
    private boolean hotelPickup;
    private Integer videoCount;
    private Integer panoramaCount;
    private Integer photoCount;
    private Integer reviewCount;
    private Integer translationLevel;
    private Integer rating1Count;
    private Integer rating2Count;
    private Integer rating3Count;
    private Integer rating4Count;
    private Integer rating5Count;
    private Timestamp updatedAt;

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "primary_destination_id")
    public int getPrimaryDestinationId() {
        return primaryDestinationId;
    }

    public void setPrimaryDestinationId(int primaryDestinationId) {
        this.primaryDestinationId = primaryDestinationId;
    }

    @Basic
    @Column(name = "destination_id")
    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    @Basic
    @Column(name = "primary_group_id")
    public Integer getPrimaryGroupId() {
        return primaryGroupId;
    }

    public void setPrimaryGroupId(Integer primaryCategoryId) {
        this.primaryGroupId = primaryCategoryId;
    }

    @Basic
    @Column(name = "supplier_code")
    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    @Basic
    @Column(name = "booking_engine_id")
    public String getBookingEngineId() {
        return bookingEngineId;
    }

    public void setBookingEngineId(String bookingEngineId) {
        this.bookingEngineId = bookingEngineId;
    }

    @Basic
    @Column(name = "title_EN")
    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    @Basic
    @Column(name = "short_title_EN")
    public String getShortTitleEn() {
        return shortTitleEn;
    }

    public void setShortTitleEn(String shortTitleEn) {
        this.shortTitleEn = shortTitleEn;
    }

    @Basic
    @Column(name = "highlights_EN")
    public String getHighlightsEn() {
        return highlightsEn;
    }

    public void setHighlightsEn(String highlightsEn) {
        this.highlightsEn = highlightsEn;
    }

    @Basic
    @Column(name = "primary_destination_name_EN")
    public String getPrimaryDestinationNameEn() {
        return primaryDestinationNameEn;
    }

    public void setPrimaryDestinationNameEn(String primaryDestinationNameEn) {
        this.primaryDestinationNameEn = primaryDestinationNameEn;
    }

    @Basic
    @Column(name = "location_EN")
    public String getLocationEn() {
        return locationEn;
    }

    public void setLocationEn(String locationEn) {
        this.locationEn = locationEn;
    }

    @Basic
    @Column(name = "city_EN")
    public String getCityEn() {
        return cityEn;
    }

    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }

    @Basic
    @Column(name = "country_EN")
    public String getCountryEn() {
        return countryEn;
    }

    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    @Basic
    @Column(name = "region_EN")
    public String getRegionEn() {
        return regionEn;
    }

    public void setRegionEn(String regionEn) {
        this.regionEn = regionEn;
    }

    @Basic
    @Column(name = "departure_point")
    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    @Basic
    @Column(name = "operates_EN")
    public String getOperatesEn() {
        return operatesEn;
    }

    public void setOperatesEn(String operatesEn) {
        this.operatesEn = operatesEn;
    }

    @Basic
    @Column(name = "return_details")
    public String getReturnDetails() {
        return returnDetails;
    }

    public void setReturnDetails(String returnDetails) {
        this.returnDetails = returnDetails;
    }

    @Basic
    @Column(name = "short_description_EN")
    public String getShortDescriptionEn() {
        return shortDescriptionEn;
    }

    public void setShortDescriptionEn(String shortDescriptionEn) {
        this.shortDescriptionEn = shortDescriptionEn;
    }

    @Basic
    @Column(name = "description_EN")
    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    @Basic
    @Column(name = "voucher_requirements_EN")
    public String getVoucherRequirementsEn() {
        return voucherRequirementsEn;
    }

    public void setVoucherRequirementsEn(String voucherRequirementsEn) {
        this.voucherRequirementsEn = voucherRequirementsEn;
    }

    @Basic
    @Column(name = "duration")
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
    @Column(name = "thumbnail_hi_res_URL")
    public String getThumbnailHiResUrl() {
        return thumbnailHiResUrl;
    }

    public void setThumbnailHiResUrl(String thumbnailHiResUrl) {
        this.thumbnailHiResUrl = thumbnailHiResUrl;
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
    @Column(name = "currency_code")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "rrp")
    public BigDecimal getRrp() {
        return rrp;
    }

    public void setRrp(BigDecimal rrp) {
        this.rrp = rrp;
    }

    @Basic
    @Column(name = "merchant_net_price_from")
    public BigDecimal getMerchantNetPriceFrom() {
        return merchantNetPriceFrom;
    }

    public void setMerchantNetPriceFrom(BigDecimal merchantNetPriceFrom) {
        this.merchantNetPriceFrom = merchantNetPriceFrom;
    }

    @Basic
    @Column(name = "saving_amount")
    public BigDecimal getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(BigDecimal savingAmount) {
        this.savingAmount = savingAmount;
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
    @Column(name = "voucher_option")
    public String getVoucherOption() {
        return voucherOption;
    }

    public void setVoucherOption(String voucherOption) {
        this.voucherOption = voucherOption;
    }

    @Basic
    @Column(name = "departure_time_EN")
    public String getDepartureTimeEn() {
        return departureTimeEn;
    }

    public void setDepartureTimeEn(String departureTimeEn) {
        this.departureTimeEn = departureTimeEn;
    }

    @Basic
    @Column(name = "departure_time_comments_EN")
    public String getDepartureTimeCommentsEn() {
        return departureTimeCommentsEn;
    }

    public void setDepartureTimeCommentsEn(String departureTimeCommentsEn) {
        this.departureTimeCommentsEn = departureTimeCommentsEn;
    }

    @Basic
    @Column(name = "on_request_period")
    public Integer getOnRequestPeriod() {
        return onRequestPeriod;
    }

    public void setOnRequestPeriod(Integer onRequestPeriod) {
        this.onRequestPeriod = onRequestPeriod;
    }

    @Basic
    @Column(name = "supplier_name")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "special_reservation")
    public boolean getSpecialReservation() {
        return specialReservation;
    }

    public void setSpecialReservation(boolean specialReservation) {
        this.specialReservation = specialReservation;
    }

    @Basic
    @Column(name = "special_reservation_details")
    public String getSpecialReservationDetails() {
        return specialReservationDetails;
    }

    public void setSpecialReservationDetails(String specialReservationDetails) {
        this.specialReservationDetails = specialReservationDetails;
    }

    @Basic
    @Column(name = "itinerary_EN")
    public String getItineraryEn() {
        return itineraryEn;
    }

    public void setItineraryEn(String itineraryEn) {
        this.itineraryEn = itineraryEn;
    }

    @Basic
    @Column(name = "terms_and_conditions_EN")
    public String getTermsAndConditionsEn() {
        return termsAndConditionsEn;
    }

    public void setTermsAndConditionsEn(String termsAndConditionsEn) {
        this.termsAndConditionsEn = termsAndConditionsEn;
    }

    @Basic
    @Column(name = "merchant_cancellable")
    public boolean getMerchantCancellable() {
        return merchantCancellable;
    }

    public void setMerchantCancellable(boolean merchantCancellable) {
        this.merchantCancellable = merchantCancellable;
    }

    @Basic
    @Column(name = "sort_order")
    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Basic
    @Column(name = "on_sale")
    public boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    @Basic
    @Column(name = "special_offer_available")
    public boolean getSpecialOfferAvailable() {
        return specialOfferAvailable;
    }

    public void setSpecialOfferAvailable(boolean specialOfferAvailable) {
        this.specialOfferAvailable = specialOfferAvailable;
    }

    @Basic
    @Column(name = "special_offer_EN")
    public String getSpecialOfferEn() {
        return specialOfferEn;
    }

    public void setSpecialOfferEn(String specialOfferEn) {
        this.specialOfferEn = specialOfferEn;
    }

    @Basic
    @Column(name = "tour_grades_available")
    public boolean getTourGradesAvailable() {
        return tourGradesAvailable;
    }

    public void setTourGradesAvailable(boolean tourGradesAvailable) {
        this.tourGradesAvailable = tourGradesAvailable;
    }

    @Basic
    @Column(name = "hotel_pickup")
    public boolean getHotelPickup() {
        return hotelPickup;
    }

    public void setHotelPickup(boolean hotelPickup) {
        this.hotelPickup = hotelPickup;
    }

    @Basic
    @Column(name = "video_count")
    public Integer getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Integer videoCount) {
        this.videoCount = videoCount;
    }

    @Basic
    @Column(name = "panorama_count")
    public Integer getPanoramaCount() {
        return panoramaCount;
    }

    public void setPanoramaCount(Integer panoramaCount) {
        this.panoramaCount = panoramaCount;
    }

    @Basic
    @Column(name = "photo_count")
    public Integer getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(Integer photoCount) {
        this.photoCount = photoCount;
    }

    @Basic
    @Column(name = "review_count")
    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    @Basic
    @Column(name = "translation_level")
    public Integer getTranslationLevel() {
        return translationLevel;
    }

    public void setTranslationLevel(Integer translationLevel) {
        this.translationLevel = translationLevel;
    }

    @Basic
    @Column(name = "rating_1_count")
    public Integer getRating1Count() {
        return rating1Count;
    }

    public void setRating1Count(Integer rating1Count) {
        this.rating1Count = rating1Count;
    }

    @Basic
    @Column(name = "rating_2_count")
    public Integer getRating2Count() {
        return rating2Count;
    }

    public void setRating2Count(Integer rating2Count) {
        this.rating2Count = rating2Count;
    }

    @Basic
    @Column(name = "rating_3_count")
    public Integer getRating3Count() {
        return rating3Count;
    }

    public void setRating3Count(Integer rating3Count) {
        this.rating3Count = rating3Count;
    }

    @Basic
    @Column(name = "rating_4_count")
    public Integer getRating4Count() {
        return rating4Count;
    }

    public void setRating4Count(Integer rating4Count) {
        this.rating4Count = rating4Count;
    }

    @Basic
    @Column(name = "rating_5_count")
    public Integer getRating5Count() {
        return rating5Count;
    }

    public void setRating5Count(Integer rating5Count) {
        this.rating5Count = rating5Count;
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

        ViatorProductDetailsBean that = (ViatorProductDetailsBean) o;

        if (primaryDestinationId != that.primaryDestinationId) return false;
        if (specialReservation != that.specialReservation) return false;
        if (merchantCancellable != that.merchantCancellable) return false;
        if (onSale != that.onSale) return false;
        if (specialOfferAvailable != that.specialOfferAvailable) return false;
        if (tourGradesAvailable != that.tourGradesAvailable) return false;
        if (hotelPickup != that.hotelPickup) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (destinationId != null ? !destinationId.equals(that.destinationId) : that.destinationId != null)
            return false;
        if (primaryGroupId != null ? !primaryGroupId.equals(that.primaryGroupId) : that.primaryGroupId != null)
            return false;
        if (supplierCode != null ? !supplierCode.equals(that.supplierCode) : that.supplierCode != null) return false;
        if (bookingEngineId != null ? !bookingEngineId.equals(that.bookingEngineId) : that.bookingEngineId != null)
            return false;
        if (titleEn != null ? !titleEn.equals(that.titleEn) : that.titleEn != null) return false;
        if (shortTitleEn != null ? !shortTitleEn.equals(that.shortTitleEn) : that.shortTitleEn != null) return false;
        if (highlightsEn != null ? !highlightsEn.equals(that.highlightsEn) : that.highlightsEn != null) return false;
        if (primaryDestinationNameEn != null ? !primaryDestinationNameEn.equals(that.primaryDestinationNameEn) : that.primaryDestinationNameEn != null)
            return false;
        if (locationEn != null ? !locationEn.equals(that.locationEn) : that.locationEn != null) return false;
        if (cityEn != null ? !cityEn.equals(that.cityEn) : that.cityEn != null) return false;
        if (countryEn != null ? !countryEn.equals(that.countryEn) : that.countryEn != null) return false;
        if (regionEn != null ? !regionEn.equals(that.regionEn) : that.regionEn != null) return false;
        if (departurePoint != null ? !departurePoint.equals(that.departurePoint) : that.departurePoint != null)
            return false;
        if (operatesEn != null ? !operatesEn.equals(that.operatesEn) : that.operatesEn != null) return false;
        if (returnDetails != null ? !returnDetails.equals(that.returnDetails) : that.returnDetails != null)
            return false;
        if (shortDescriptionEn != null ? !shortDescriptionEn.equals(that.shortDescriptionEn) : that.shortDescriptionEn != null)
            return false;
        if (descriptionEn != null ? !descriptionEn.equals(that.descriptionEn) : that.descriptionEn != null)
            return false;
        if (voucherRequirementsEn != null ? !voucherRequirementsEn.equals(that.voucherRequirementsEn) : that.voucherRequirementsEn != null)
            return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (thumbnailUrl != null ? !thumbnailUrl.equals(that.thumbnailUrl) : that.thumbnailUrl != null) return false;
        if (thumbnailHiResUrl != null ? !thumbnailHiResUrl.equals(that.thumbnailHiResUrl) : that.thumbnailHiResUrl != null)
            return false;
        if (webUrl != null ? !webUrl.equals(that.webUrl) : that.webUrl != null) return false;
        if (currencyCode != null ? !currencyCode.equals(that.currencyCode) : that.currencyCode != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (rrp != null ? !rrp.equals(that.rrp) : that.rrp != null) return false;
        if (merchantNetPriceFrom != null ? !merchantNetPriceFrom.equals(that.merchantNetPriceFrom) : that.merchantNetPriceFrom != null)
            return false;
        if (savingAmount != null ? !savingAmount.equals(that.savingAmount) : that.savingAmount != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (voucherOption != null ? !voucherOption.equals(that.voucherOption) : that.voucherOption != null)
            return false;
        if (departureTimeEn != null ? !departureTimeEn.equals(that.departureTimeEn) : that.departureTimeEn != null)
            return false;
        if (departureTimeCommentsEn != null ? !departureTimeCommentsEn.equals(that.departureTimeCommentsEn) : that.departureTimeCommentsEn != null)
            return false;
        if (onRequestPeriod != null ? !onRequestPeriod.equals(that.onRequestPeriod) : that.onRequestPeriod != null)
            return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null)
            return false;
        if (supplierName != null ? !supplierName.equals(that.supplierName) : that.supplierName != null) return false;
        if (specialReservationDetails != null ? !specialReservationDetails.equals(that.specialReservationDetails) : that.specialReservationDetails != null)
            return false;
        if (itineraryEn != null ? !itineraryEn.equals(that.itineraryEn) : that.itineraryEn != null) return false;
        if (termsAndConditionsEn != null ? !termsAndConditionsEn.equals(that.termsAndConditionsEn) : that.termsAndConditionsEn != null)
            return false;
        if (specialOfferEn != null ? !specialOfferEn.equals(that.specialOfferEn) : that.specialOfferEn != null)
            return false;
        if (videoCount != null ? !videoCount.equals(that.videoCount) : that.videoCount != null) return false;
        if (panoramaCount != null ? !panoramaCount.equals(that.panoramaCount) : that.panoramaCount != null)
            return false;
        if (photoCount != null ? !photoCount.equals(that.photoCount) : that.photoCount != null) return false;
        if (reviewCount != null ? !reviewCount.equals(that.reviewCount) : that.reviewCount != null) return false;
        if (translationLevel != null ? !translationLevel.equals(that.translationLevel) : that.translationLevel != null)
            return false;
        if (rating1Count != null ? !rating1Count.equals(that.rating1Count) : that.rating1Count != null) return false;
        if (rating2Count != null ? !rating2Count.equals(that.rating2Count) : that.rating2Count != null) return false;
        if (rating3Count != null ? !rating3Count.equals(that.rating3Count) : that.rating3Count != null) return false;
        if (rating4Count != null ? !rating4Count.equals(that.rating4Count) : that.rating4Count != null) return false;
        if (rating5Count != null ? !rating5Count.equals(that.rating5Count) : that.rating5Count != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + primaryDestinationId;
        result = 31 * result + (destinationId != null ? destinationId.hashCode() : 0);
        result = 31 * result + (primaryGroupId != null ? primaryGroupId.hashCode() : 0);
        result = 31 * result + (supplierCode != null ? supplierCode.hashCode() : 0);
        result = 31 * result + (bookingEngineId != null ? bookingEngineId.hashCode() : 0);
        result = 31 * result + (titleEn != null ? titleEn.hashCode() : 0);
        result = 31 * result + (shortTitleEn != null ? shortTitleEn.hashCode() : 0);
        result = 31 * result + (highlightsEn != null ? highlightsEn.hashCode() : 0);
        result = 31 * result + (primaryDestinationNameEn != null ? primaryDestinationNameEn.hashCode() : 0);
        result = 31 * result + (locationEn != null ? locationEn.hashCode() : 0);
        result = 31 * result + (cityEn != null ? cityEn.hashCode() : 0);
        result = 31 * result + (countryEn != null ? countryEn.hashCode() : 0);
        result = 31 * result + (regionEn != null ? regionEn.hashCode() : 0);
        result = 31 * result + (departurePoint != null ? departurePoint.hashCode() : 0);
        result = 31 * result + (operatesEn != null ? operatesEn.hashCode() : 0);
        result = 31 * result + (returnDetails != null ? returnDetails.hashCode() : 0);
        result = 31 * result + (shortDescriptionEn != null ? shortDescriptionEn.hashCode() : 0);
        result = 31 * result + (descriptionEn != null ? descriptionEn.hashCode() : 0);
        result = 31 * result + (voucherRequirementsEn != null ? voucherRequirementsEn.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (thumbnailUrl != null ? thumbnailUrl.hashCode() : 0);
        result = 31 * result + (thumbnailHiResUrl != null ? thumbnailHiResUrl.hashCode() : 0);
        result = 31 * result + (webUrl != null ? webUrl.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (rrp != null ? rrp.hashCode() : 0);
        result = 31 * result + (merchantNetPriceFrom != null ? merchantNetPriceFrom.hashCode() : 0);
        result = 31 * result + (savingAmount != null ? savingAmount.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (voucherOption != null ? voucherOption.hashCode() : 0);
        result = 31 * result + (departureTimeEn != null ? departureTimeEn.hashCode() : 0);
        result = 31 * result + (departureTimeCommentsEn != null ? departureTimeCommentsEn.hashCode() : 0);
        result = 31 * result + (onRequestPeriod != null ? onRequestPeriod.hashCode() : 0);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + (supplierName != null ? supplierName.hashCode() : 0);
        result = 31 * result + help(specialReservation);
        result = 31 * result + (specialReservationDetails != null ? specialReservationDetails.hashCode() : 0);
        result = 31 * result + (itineraryEn != null ? itineraryEn.hashCode() : 0);
        result = 31 * result + (termsAndConditionsEn != null ? termsAndConditionsEn.hashCode() : 0);
        result = 31 * result + help(merchantCancellable);
        result = 31 * result + help(onSale);
        result = 31 * result + help(specialOfferAvailable);
        result = 31 * result + (specialOfferEn != null ? specialOfferEn.hashCode() : 0);
        result = 31 * result + help(tourGradesAvailable);
        result = 31 * result + help(hotelPickup);
        result = 31 * result + (videoCount != null ? videoCount.hashCode() : 0);
        result = 31 * result + (panoramaCount != null ? panoramaCount.hashCode() : 0);
        result = 31 * result + (photoCount != null ? photoCount.hashCode() : 0);
        result = 31 * result + (reviewCount != null ? reviewCount.hashCode() : 0);
        result = 31 * result + (translationLevel != null ? translationLevel.hashCode() : 0);
        result = 31 * result + (rating1Count != null ? rating1Count.hashCode() : 0);
        result = 31 * result + (rating2Count != null ? rating2Count.hashCode() : 0);
        result = 31 * result + (rating3Count != null ? rating3Count.hashCode() : 0);
        result = 31 * result + (rating4Count != null ? rating4Count.hashCode() : 0);
        result = 31 * result + (rating5Count != null ? rating5Count.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    private int help(boolean attribute){
        if(attribute){return 1;}else{return 0;}
    }
}
