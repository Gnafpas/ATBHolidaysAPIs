package DB_Updates;

import APIBeans.Taxonomy.*;
import DAOs.API_DAOs.Taxonomy_API_DAO;
import DAOs.DB_DAOs.Viator_Categories_DAO;
import DAOs.DB_DAOs.Viator_Destinations_DAO;
import DAOs.DB_DAOs.Viator_Subcategories_DAO;
import DB_Beans.ViatorCategoriesBean;
import DB_Beans.ViatorDestinationsBean;
import DB_Beans.ViatorSubcategoriesBean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by George on 23/06/17.
 */
public class UpdateDestinations {

    public void updateDestinations() {

        ViatorDestinationsBean viatordestinationsBean=new ViatorDestinationsBean();
        Taxonomy_API_DAO taxonomy_API_DAO = new Taxonomy_API_DAO();
        Taxonomy_Destinations_APIJSON taxonomy_destinations_APIJSON=taxonomy_API_DAO.retrieve_destinations();
        Viator_Destinations_DAO viator_destinations_DAO = new Viator_Destinations_DAO();
        Date date=new Date();//todo

        if (taxonomy_destinations_APIJSON.isSuccess()){
            for(Taxonomy_Destinations_Data dest:taxonomy_destinations_APIJSON.getData()) {

                viator_destinations_DAO.deleteDestination(dest.getDestinationId());

                viatordestinationsBean.setDefaultCurrencyCode(dest.getDefaultCurrencyCode());
                viatordestinationsBean.setDestinationId(dest.getDestinationId());
                viatordestinationsBean.setDestinationNameEn(dest.getDestinationName());
                viatordestinationsBean.setDestinationType(dest.getDestinationType());
                viatordestinationsBean.setDestinationUrlName(dest.getDestinationUrlName());
                viatordestinationsBean.setIataCode(dest.getIataCode());
                viatordestinationsBean.setLatitude(dest.getLatitude());
                viatordestinationsBean.setLongitude(dest.getLongitude());
                viatordestinationsBean.setLookupId(dest.getLookupId());
                viatordestinationsBean.setParentId(dest.getParentId());
                viatordestinationsBean.setSelectable(dest.isSelectable());
                viatordestinationsBean.setSortOrder(dest.getSortOrder());
                viatordestinationsBean.setTimeZone(dest.getTimeZone());
                viatordestinationsBean.setUpdatedAt(new Timestamp(date.getTime()));
                viatordestinationsBean.setCreatedAt(new Timestamp(date.getTime()));

                viator_destinations_DAO.adddestination(viatordestinationsBean);
            }
        }

    }
}
