package Beans.HotelBedsAPIBeans.Hotels;

/**
 * Created by George on 12/01/2018.
 */
public class InterestPoint {

    private int facilityCode;
    private int facilityGroupCode;
    private int order;
    private String poiName;
    private boolean indFee;
    private int distance;

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

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

    public boolean isIndFee() {
        return indFee;
    }

    public void setIndFee(boolean indFee) {
        this.indFee = indFee;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
