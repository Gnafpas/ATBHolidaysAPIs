package WebServicesBeans.ListingPage;

import DBBeans.ViatorDestinationsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 17/07/2017.
 */
public class DestinationsJSON {
    List<ViatorDestinationsBean> destinations=new ArrayList<>();
    private boolean DBError=false;

    public List<ViatorDestinationsBean> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<ViatorDestinationsBean> destinations) {
        this.destinations = destinations;
    }

    public boolean isDBError() {
        return DBError;
    }

    public void setDBError(boolean DBError) {
        this.DBError = DBError;
    }
}
