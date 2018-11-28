package Updates.ViatorDBUpdates;

import Beans.ViatorAPIBeans.Taxonomy.*;
import DAOs.ViatorAPIDAOs.TaxonomyAPIDAO;
import DAOs.ViatorDBDAOs.ViatorDestinationsDAO;
import DAOs.ViatorDBDAOs.ViatorUpdateDestinationsInfoDAO;
import Beans.ViatorDBBeans.ViatorDestinationsBean;
import Beans.ViatorDBBeans.ViatorUpdateDestinationsInfoBean;
import Beans.ViatorDBBeans.UpdateDBBeans.InfoJSON;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import java.sql.Timestamp;


/**
 * Created by George on 23/06/17.
 */
public class UpdateDestinations {

    public static InfoJSON updateDestinations() {

        ViatorDestinationsBean viatorDestinationsBean=new ViatorDestinationsBean();
        TaxonomyDestinationsAPIJSON taxonomyDestinationsAPIJSON= TaxonomyAPIDAO.retrieveDestinations();
        ViatorUpdateDestinationsInfoBean viatorUpdateDestinationsInfoBean=new ViatorUpdateDestinationsInfoBean();
        DateTime dateTime;

        /**
         * Statistic Values/Information/Results in JSON for Admin.
         */
        InfoJSON infoJason=new InfoJSON();
        infoJason.setViatorError(false);
        infoJason.setDbCommError(false);
        infoJason.setDbCommErrorsCounter(0);

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
                dateTime =new DateTime( DateTimeZone.UTC);
                viatorDestinationsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                    dateTime.getHourOfDay(),dateTime.getMinuteOfHour())) );

                if(ViatorDestinationsDAO.deleteDestination(viatorDestinationsBean.getDestinationId())){
                    infoJason.setDbCommErrorsCounter(infoJason.getDbCommErrorsCounter()+1);
                    infoJason.setDbCommError(true);
                }
                if(ViatorDestinationsDAO.adddestination(viatorDestinationsBean)){
                    infoJason.setDbCommErrorsCounter(infoJason.getDbCommErrorsCounter()+1);
                    infoJason.setDbCommError(true);
                }
            }
        }else{
            infoJason.setViatorErrorInfo("Communication ERROR.Did not received Destinations");
            infoJason.setViatorError(true);
        }

        dateTime =new DateTime( DateTimeZone.UTC);
        viatorUpdateDestinationsInfoBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));
        viatorUpdateDestinationsInfoBean.setDbCommError(infoJason.isDbCommError());
        viatorUpdateDestinationsInfoBean.setDbCommErrorsCounter(infoJason.getDbCommErrorsCounter());
        viatorUpdateDestinationsInfoBean.setViatoErrorInfo(infoJason.getViatorErrorInfo());
        viatorUpdateDestinationsInfoBean.setViatorError(infoJason.isViatorError());
        ViatorUpdateDestinationsInfoDAO.addViatorUpdateDestinationsInfo(viatorUpdateDestinationsInfoBean);

        return infoJason;

    }
}
