package APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book;

import java.util.List;

/**
 * Created by George on 02/08/2017.
 */
public class BookData {
    private int sortOrder;
    private List<String> rulesApplied;//todo correct type
    private List<String> omniPreRuleList;//todo correct type
    private BookingStatus bookingStatus;
    private List<ItemSummary> itemSummaries;
    private String voucherURL;
    private String securityToken;
    private String paypalRedirectURL;
    private long itineraryId;
    private int exchangeRate;
    private String bookingDate;
    private String voucherKey;
    private String bookerEmail;
    private String distributorRef;
    private double totalPrice;
    private String totalPriceFormatted;
    private double totalPriceUSD;
    private boolean hasVoucher;
    private int userId;//todo correct type
    private String currencyCode;

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

    public List<String> getOmniPreRuleList() {
        return omniPreRuleList;
    }

    public void setOmniPreRuleList(List<String> omniPreRuleList) {
        this.omniPreRuleList = omniPreRuleList;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public List<ItemSummary> getItemSummaries() {
        return itemSummaries;
    }

    public void setItemSummaries(List<ItemSummary> itemSummaries) {
        this.itemSummaries = itemSummaries;
    }

    public String getVoucherURL() {
        return voucherURL;
    }

    public void setVoucherURL(String voucherURL) {
        this.voucherURL = voucherURL;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public String getPaypalRedirectURL() {
        return paypalRedirectURL;
    }

    public void setPaypalRedirectURL(String paypalRedirectURL) {
        this.paypalRedirectURL = paypalRedirectURL;
    }

    public long getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(long itineraryId) {
        this.itineraryId = itineraryId;
    }

    public int getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(int exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getVoucherKey() {
        return voucherKey;
    }

    public void setVoucherKey(String voucherKey) {
        this.voucherKey = voucherKey;
    }

    public String getBookerEmail() {
        return bookerEmail;
    }

    public void setBookerEmail(String bookerEmail) {
        this.bookerEmail = bookerEmail;
    }

    public String getDistributorRef() {
        return distributorRef;
    }

    public void setDistributorRef(String distributorRef) {
        this.distributorRef = distributorRef;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTotalPriceFormatted() {
        return totalPriceFormatted;
    }

    public void setTotalPriceFormatted(String totalPriceFormatted) {
        this.totalPriceFormatted = totalPriceFormatted;
    }

    public double getTotalPriceUSD() {
        return totalPriceUSD;
    }

    public void setTotalPriceUSD(double totalPriceUSD) {
        this.totalPriceUSD = totalPriceUSD;
    }

    public boolean isHasVoucher() {
        return hasVoucher;
    }

    public void setHasVoucher(boolean hasVoucher) {
        this.hasVoucher = hasVoucher;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
