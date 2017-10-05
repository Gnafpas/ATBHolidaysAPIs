package APIJSONs.MyViatorAPIJSONs.Suggestions;

import Beans.ViatorDBBeans.ViatorNoneAvailableDatesBean;

/**
 * Created by George on 27/07/2017.
 */
public class LastMonthWithAvailabilityInfoJSON {

    private boolean DBError=false;
    private ViatorNoneAvailableDatesBean lastMonthWithAvailabilityInfo;

    public boolean isDBError() {
        return DBError;
    }

    public void setDBError(boolean DBError) {
        this.DBError = DBError;
    }

    public ViatorNoneAvailableDatesBean getLastMonthWithAvailabilityInfo() {
        return lastMonthWithAvailabilityInfo;
    }

    public void setLastMonthWithAvailabilityInfo(ViatorNoneAvailableDatesBean lastMonthWithAvailabilityInfo) {
        this.lastMonthWithAvailabilityInfo = lastMonthWithAvailabilityInfo;
    }
}
