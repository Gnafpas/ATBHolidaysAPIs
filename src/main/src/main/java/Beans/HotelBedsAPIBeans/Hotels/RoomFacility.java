package Beans.HotelBedsAPIBeans.Hotels;

/**
 * Created by George on 12/01/2018.
 */
public class RoomFacility {

    private int facilityCode;
    private int facilityGroupCode;
    private int order;
    private String number;
    private boolean indYesOrNo;
    private boolean indLogic;
    private boolean indFee;
    private String amount;
    private String currency;
    private String applicationType;

    public int getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(int facilityCode) {
        this.facilityCode = facilityCode;
    }

    public int getFacilityGroupCode() {
        return facilityGroupCode;
    }

    public void setFacilityGroupCode(int facilityGroupCode) {
        this.facilityGroupCode = facilityGroupCode;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isIndYesOrNo() {
        return indYesOrNo;
    }

    public void setIndYesOrNo(boolean indYesOrNo) {
        this.indYesOrNo = indYesOrNo;
    }

    public boolean isIndLogic() {
        return indLogic;
    }

    public void setIndLogic(boolean indLogic) {
        this.indLogic = indLogic;
    }

    public boolean isIndFee() {
        return indFee;
    }

    public void setIndFee(boolean indFee) {
        this.indFee = indFee;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }
}
