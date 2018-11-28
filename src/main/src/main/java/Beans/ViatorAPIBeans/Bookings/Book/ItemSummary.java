package Beans.ViatorAPIBeans.Bookings.Book;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George on 02/08/2017.
 */
public class ItemSummary {
    private int sortOrder;
    private List<String> rulesApplied;//todo correct type
    private BookingStatus bookingStatus;
    private List<TravellerAgeBand> travellerAgeBands;
    private String voucherKey;
    private String voucherURL;
    private String voucherRequirements;
    private boolean productPulledDown;
    private boolean merchantCancellable;
    private List<String> productWidgetList;//todo correct type
    private BigDecimal savingAmount;
    private boolean applePassSupported;
    private String supplierName;
    private String supplierPhoneNumber;
   // private vouchers;
   // private passbooks;
   // private termsAndConditions;
    private long itineraryId;
    private String productCode;
    private String tourGradeCode;
    private String distributorItemRef;
    private String languageServicesLanguageCode;
    private String travelDate;
    private BigDecimal price;
    private String leadTravellerSurname;
    private String productTitle;
    private int destId;
    private String voucherOption;
    private long itemId;
    private String priceFormatted;
    private String barcodeOption;
    private String barcodeType;
    private String departurePoint;
    private String departurePointAddress;
    private String departurePointDirections;
    private int obfsId;
    private String bookingEngineId;
    private String savingAmountFormated;
    private BigDecimal merchantNetPrice;
    private String merchantNetPriceFormatted;
    private String tourGradeDescription;
    private String leadTravellerFirstname;
    private String leadTravellerTitle;
    private BigDecimal lastRetailPrice;
    private String currencyCode;
    private String lastRetailPriceFormatted;
    private String departsFrom;
    private String pickupHotelId;
    private String pickupHotelName;
    private int hoursConfirmed;
    private BigDecimal priceUSD;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public List<String> getRulesApplied() {
        return rulesApplied;
    }

    public void setRulesApplied(List<String> rulesApplied) {
        this.rulesApplied = rulesApplied;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public List<TravellerAgeBand> getTravellerAgeBands() {
        return travellerAgeBands;
    }

    public void setTravellerAgeBands(List<TravellerAgeBand> travellerAgeBands) {
        this.travellerAgeBands = travellerAgeBands;
    }

    public String getVoucherKey() {
        return voucherKey;
    }

    public void setVoucherKey(String voucherKey) {
        this.voucherKey = voucherKey;
    }

    public String getVoucherURL() {
        return voucherURL;
    }

    public void setVoucherURL(String voucherURL) {
        this.voucherURL = voucherURL;
    }

    public String getVoucherRequirements() {
        return voucherRequirements;
    }

    public void setVoucherRequirements(String voucherRequirements) {
        this.voucherRequirements = voucherRequirements;
    }

    public boolean isProductPulledDown() {
        return productPulledDown;
    }

    public void setProductPulledDown(boolean productPulledDown) {
        this.productPulledDown = productPulledDown;
    }

    public boolean isMerchantCancellable() {
        return merchantCancellable;
    }

    public void setMerchantCancellable(boolean merchantCancellable) {
        this.merchantCancellable = merchantCancellable;
    }

    public List<String> getProductWidgetList() {
        return productWidgetList;
    }

    public void setProductWidgetList(List<String> productWidgetList) {
        this.productWidgetList = productWidgetList;
    }

    public BigDecimal getSavingAmount() {
        return savingAmount;
    }

    public void setSavingAmount(BigDecimal savingAmount) {
        this.savingAmount = savingAmount;
    }

    public boolean isApplePassSupported() {
        return applePassSupported;
    }

    public void setApplePassSupported(boolean applePassSupported) {
        this.applePassSupported = applePassSupported;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierPhoneNumber() {
        return supplierPhoneNumber;
    }

    public void setSupplierPhoneNumber(String supplierPhoneNumber) {
        this.supplierPhoneNumber = supplierPhoneNumber;
    }

    public long getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(long itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getTourGradeCode() {
        return tourGradeCode;
    }

    public void setTourGradeCode(String tourGradeCode) {
        this.tourGradeCode = tourGradeCode;
    }

    public String getDistributorItemRef() {
        return distributorItemRef;
    }

    public void setDistributorItemRef(String distributorItemRef) {
        this.distributorItemRef = distributorItemRef;
    }

    public String getLanguageServicesLanguageCode() {
        return languageServicesLanguageCode;
    }

    public void setLanguageServicesLanguageCode(String languageServicesLanguageCode) {
        this.languageServicesLanguageCode = languageServicesLanguageCode;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLeadTravellerSurname() {
        return leadTravellerSurname;
    }

    public void setLeadTravellerSurname(String leadTravellerSurname) {
        this.leadTravellerSurname = leadTravellerSurname;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getDestId() {
        return destId;
    }

    public void setDestId(int destId) {
        this.destId = destId;
    }

    public String getVoucherOption() {
        return voucherOption;
    }

    public void setVoucherOption(String voucherOption) {
        this.voucherOption = voucherOption;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getPriceFormatted() {
        return priceFormatted;
    }

    public void setPriceFormatted(String priceFormatted) {
        this.priceFormatted = priceFormatted;
    }

    public String getBarcodeOption() {
        return barcodeOption;
    }

    public void setBarcodeOption(String barcodeOption) {
        this.barcodeOption = barcodeOption;
    }

    public String getBarcodeType() {
        return barcodeType;
    }

    public void setBarcodeType(String barcodeType) {
        this.barcodeType = barcodeType;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getDeparturePointAddress() {
        return departurePointAddress;
    }

    public void setDeparturePointAddress(String departurePointAddress) {
        this.departurePointAddress = departurePointAddress;
    }

    public String getDeparturePointDirections() {
        return departurePointDirections;
    }

    public void setDeparturePointDirections(String departurePointDirections) {
        this.departurePointDirections = departurePointDirections;
    }

    public int getObfsId() {
        return obfsId;
    }

    public void setObfsId(int obfsId) {
        this.obfsId = obfsId;
    }

    public String getBookingEngineId() {
        return bookingEngineId;
    }

    public void setBookingEngineId(String bookingEngineId) {
        this.bookingEngineId = bookingEngineId;
    }

    public String getSavingAmountFormated() {
        return savingAmountFormated;
    }

    public void setSavingAmountFormated(String savingAmountFormated) {
        this.savingAmountFormated = savingAmountFormated;
    }

    public BigDecimal getMerchantNetPrice() {
        return merchantNetPrice;
    }

    public void setMerchantNetPrice(BigDecimal merchantNetPrice) {
        this.merchantNetPrice = merchantNetPrice;
    }

    public String getMerchantNetPriceFormatted() {
        return merchantNetPriceFormatted;
    }

    public void setMerchantNetPriceFormatted(String merchantNetPriceFormatted) {
        this.merchantNetPriceFormatted = merchantNetPriceFormatted;
    }

    public String getTourGradeDescription() {
        return tourGradeDescription;
    }

    public void setTourGradeDescription(String tourGradeDescription) {
        this.tourGradeDescription = tourGradeDescription;
    }

    public String getLeadTravellerFirstname() {
        return leadTravellerFirstname;
    }

    public void setLeadTravellerFirstname(String leadTravellerFirstname) {
        this.leadTravellerFirstname = leadTravellerFirstname;
    }

    public String getLeadTravellerTitle() {
        return leadTravellerTitle;
    }

    public void setLeadTravellerTitle(String leadTravellerTitle) {
        this.leadTravellerTitle = leadTravellerTitle;
    }

    public BigDecimal getLastRetailPrice() {
        return lastRetailPrice;
    }

    public void setLastRetailPrice(BigDecimal lastRetailPrice) {
        this.lastRetailPrice = lastRetailPrice;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getLastRetailPriceFormatted() {
        return lastRetailPriceFormatted;
    }

    public void setLastRetailPriceFormatted(String lastRetailPriceFormatted) {
        this.lastRetailPriceFormatted = lastRetailPriceFormatted;
    }

    public String getDepartsFrom() {
        return departsFrom;
    }

    public void setDepartsFrom(String departsFrom) {
        this.departsFrom = departsFrom;
    }

    public String getPickupHotelId() {
        return pickupHotelId;
    }

    public void setPickupHotelId(String pickupHotelId) {
        this.pickupHotelId = pickupHotelId;
    }

    public String getPickupHotelName() {
        return pickupHotelName;
    }

    public void setPickupHotelName(String pickupHotelName) {
        this.pickupHotelName = pickupHotelName;
    }

    public int getHoursConfirmed() {
        return hoursConfirmed;
    }

    public void setHoursConfirmed(int hoursConfirmed) {
        this.hoursConfirmed = hoursConfirmed;
    }

    public BigDecimal getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(BigDecimal priceUSD) {
        this.priceUSD = priceUSD;
    }
}
