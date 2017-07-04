package DBUpdates;

import APIBeans.Taxonomy.*;
import DAOs.APIDAOs.TaxonomyAPIDAO;
import DAOs.DBDAOs.ViatorDestinationsDAO;
import DBBeans.ViatorDestinationsBean;
import WebServicesBeans.UpdateDBJSONs.InfoJSON;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Created by George on 23/06/17.
 */
public class UpdateDestinations {

    public InfoJSON updateDestinations() {

        ViatorDestinationsBean viatorDestinationsBean=new ViatorDestinationsBean();
        TaxonomyAPIDAO taxonomyAPIDAO = new TaxonomyAPIDAO();
        TaxonomyDestinationsAPIJSON taxonomyDestinationsAPIJSON= taxonomyAPIDAO.retrieveDestinations();
        ViatorDestinationsDAO viatorDestinationsDAO = new ViatorDestinationsDAO();

        /**
         * Statistic Values/Information/Results in JSON for Admin.
         */
        InfoJSON infoJason=new InfoJSON();
        infoJason.setViatorError(false);
        infoJason.setDbCommError(false);
        infoJason.setDbCommErrorCounter(0);

        if (taxonomyDestinationsAPIJSON.isSuccess() && taxonomyDestinationsAPIJSON.getData()!=null){
            for(TaxonomyDestinationsData dest:taxonomyDestinationsAPIJSON.getData()) {
                viatorDestinationsBean.setDefaultCurrencyCode(dest.getDefaultCurrencyCode());
                viatorDestinationsBean.setDestinationId(dest.getDestinationId());
                viatorDestinationsBean.setDestinationNameEn(dest.getDestinationName());
                viatorDestinationsBean.setDestinationType(dest.getDestinationType());
                viatorDestinationsBean.setDestinationUrlName(dest.getDestinationUrlName());
                viatorDestinationsBean.setIataCode(dest.getIataCode());
                viatorDestinationsBean.setLatitude(dest.getLatitude());
                viatorDestinationsBean.setLongitude(dest.getLongitude());
                viatorDestinationsBean.setLookupId(dest.getLookupId());
                viatorDestinationsBean.setParentId(dest.getParentId());
                viatorDestinationsBean.setSelectable(dest.isSelectable());
                viatorDestinationsBean.setSortOrder(dest.getSortOrder());
                viatorDestinationsBean.setTimeZone(dest.getTimeZone());
                viatorDestinationsBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                if(viatorDestinationsDAO.deleteDestination(viatorDestinationsBean.getDestinationId())){
                    infoJason.setDbCommErrorCounter(infoJason.getDbCommErrorCounter()+1);
                    infoJason.setDbCommError(true);
                }
                if(viatorDestinationsDAO.adddestination(viatorDestinationsBean)){
                    infoJason.setDbCommErrorCounter(infoJason.getDbCommErrorCounter()+1);
                    infoJason.setDbCommError(true);
                }
            }
        }else{
            System.out.println("********************** Communication ERROR.Did not received Destinations **********************");
            infoJason.setViatorErrorInfo("Communication ERROR.Did not received Destinations");
            infoJason.setViatorError(true);
        }
        return infoJason;

    }
}
