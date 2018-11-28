package Beans.HotelBedsAPIBeans.Types;

/**
 * Created by George on 11/03/2018.
 */
public class Facility {

    private String code;
    private String facilityGroupCode;
    private String facilityTypologyCode;
    private TypeMultiDescription description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFacilityGroupCode() {
        return facilityGroupCode;
    }

    public void setFacilityGroupCode(String facilityGroupCode) {
        this.facilityGroupCode = facilityGroupCode;
    }

    public String getFacilityTypologyCode() {
        return facilityTypologyCode;
    }

    public void setFacilityTypologyCode(String facilityTypologyCode) {
        this.facilityTypologyCode = facilityTypologyCode;
    }

    public TypeMultiDescription getDescription() {
        return description;
    }

    public void setDescription(TypeMultiDescription description) {
        this.description = description;
    }
}
