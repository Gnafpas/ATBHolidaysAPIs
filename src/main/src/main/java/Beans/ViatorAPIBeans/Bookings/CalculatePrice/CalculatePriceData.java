package Beans.ViatorAPIBeans.Bookings.CalculatePrice;

import Beans.ViatorAPIBeans.Bookings.Book.BookData;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George on 03/08/2017.
 */
public class CalculatePriceData {

    private List<String> rulesApplied;//todo correct type
    private String promoCode;
    private BookData itinerary;
    private boolean promoCodeValid;
    private boolean promoCodeExpired;
    private boolean hasPromoCode;
    private BigDecimal itineraryFromPrice;
    private String itineraryFromPriceFormatted;
    private BigDecimal itineraryNewPrice;
    private String itineraryNewPriceFormatted;
    private BigDecimal itinerarySaving;
    private String itinerarySavingFormatted;
    private String currencyCode;

    public List<String> getRulesApplied() {
        return rulesApplied;
    }

    public void setRulesApplied(List<String> rulesApplied) {
        this.rulesApplied = rulesApplied;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public BookData getItinerary() {
        return itinerary;
    }

    public void setItinerary(BookData itinerary) {
        this.itinerary = itinerary;
    }

    public boolean isPromoCodeValid() {
        return promoCodeValid;
    }

    public void setPromoCodeValid(boolean promoCodeValid) {
        this.promoCodeValid = promoCodeValid;
    }

    public boolean isPromoCodeExpired() {
        return promoCodeExpired;
    }

    public void setPromoCodeExpired(boolean promoCodeExpired) {
        this.promoCodeExpired = promoCodeExpired;
    }

    public boolean isHasPromoCode() {
        return hasPromoCode;
    }

    public void setHasPromoCode(boolean hasPromoCode) {
        this.hasPromoCode = hasPromoCode;
    }

    public BigDecimal getItineraryFromPrice() {
        return itineraryFromPrice;
    }

    public void setItineraryFromPrice(BigDecimal itineraryFromPrice) {
        this.itineraryFromPrice = itineraryFromPrice;
    }

    public String getItineraryFromPriceFormatted() {
        return itineraryFromPriceFormatted;
    }

    public void setItineraryFromPriceFormatted(String itineraryFromPriceFormatted) {
        this.itineraryFromPriceFormatted = itineraryFromPriceFormatted;
    }

    public BigDecimal getItineraryNewPrice() {
        return itineraryNewPrice;
    }

    public void setItineraryNewPrice(BigDecimal itineraryNewPrice) {
        this.itineraryNewPrice = itineraryNewPrice;
    }

    public String getItineraryNewPriceFormatted() {
        return itineraryNewPriceFormatted;
    }

    public void setItineraryNewPriceFormatted(String itineraryNewPriceFormatted) {
        this.itineraryNewPriceFormatted = itineraryNewPriceFormatted;
    }

    public BigDecimal getItinerarySaving() {
        return itinerarySaving;
    }

    public void setItinerarySaving(BigDecimal itinerarySaving) {
        this.itinerarySaving = itinerarySaving;
    }

    public String getItinerarySavingFormatted() {
        return itinerarySavingFormatted;
    }

    public void setItinerarySavingFormatted(String itinerarySavingFormatted) {
        this.itinerarySavingFormatted = itinerarySavingFormatted;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
