package APIJSONs.MyViatorAPIJSONs.ListingPage;

import Beans.ViatorDBBeans.ViatorAttractionsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 18/07/2017.
 */
public class AttractionsListingPageJSON {

    List<ViatorAttractionsBean> attractions=new ArrayList<>();
    private boolean DBError=false;

    public List<ViatorAttractionsBean> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<ViatorAttractionsBean> attractions) {
        this.attractions = attractions;
    }

    public boolean isDBError() {
        return DBError;
    }

    public void setDBError(boolean DBError) {
        this.DBError = DBError;
    }
}
