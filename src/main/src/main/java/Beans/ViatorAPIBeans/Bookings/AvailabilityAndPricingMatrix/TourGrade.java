package Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 26/07/2017.
 */
public class TourGrade {

    private int sortOrder;
    private String gradeCode;
    private String gradeTitle;
    private List<PricingMatrix> pricingMatrix= new ArrayList();

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getGradeTitle() {
        return gradeTitle;
    }

    public void setGradeTitle(String gradeTitle) {
        this.gradeTitle = gradeTitle;
    }

    public List<PricingMatrix> getPricingMatrix() {
        return pricingMatrix;
    }

    public void setPricingMatrix(List<PricingMatrix> pricingMatrix) {
        this.pricingMatrix = pricingMatrix;
    }
}
