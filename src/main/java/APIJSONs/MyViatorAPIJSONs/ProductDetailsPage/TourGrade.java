package APIJSONs.MyViatorAPIJSONs.ProductDetailsPage;

import Beans.ViatorDBBeans.ViatorProductTourGradeLanguageServicesBean;
import Beans.ViatorDBBeans.ViatorProductTourGradesBean;

import java.util.List;

/**
 * Created by George on 13/07/2017.
 */
public class TourGrade {

    ViatorProductTourGradesBean tourGrade;
    List<ViatorProductTourGradeLanguageServicesBean> languageServices;


    public ViatorProductTourGradesBean getTourGrade() {
        return tourGrade;
    }

    public void setTourGrade(ViatorProductTourGradesBean tourGrade) {
        this.tourGrade = tourGrade;
    }

    public List<ViatorProductTourGradeLanguageServicesBean> getLanguageServices() {
        return languageServices;
    }

    public void setLanguageServices(List<ViatorProductTourGradeLanguageServicesBean> languageServices) {
        this.languageServices = languageServices;
    }
}
