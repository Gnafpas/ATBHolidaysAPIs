package DBUpdates;

import APIBeans.Taxonomy.TaxonomyCategoriesAPIJSON;
import APIBeans.Taxonomy.TaxonomyCategoriesData;
import APIBeans.Taxonomy.TaxonomySubcategory;
import DAOs.APIDAOs.TaxonomyAPIDAO;
import DAOs.DBDAOs.ViatorCategoriesDAO;
import DAOs.DBDAOs.ViatorSubcategoriesDAO;
import DBBeans.ViatorCategoriesBean;
import DBBeans.ViatorSubcategoriesBean;
import WebServicesBeans.UpdateDBJSONs.InfoJSON;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;


/**
 * Created by George on 19/06/17.
 */
public class UpdateCategories {

    public InfoJSON updateCategories() {
        //todo the categories id are chenging be aware of dublications of ids in database
        ViatorCategoriesBean viatorCategoriesBean=new ViatorCategoriesBean();
        ViatorSubcategoriesBean viatorsubcategoriesBean=new ViatorSubcategoriesBean();
        TaxonomyAPIDAO taxonomyAPIDAO = new TaxonomyAPIDAO();
        TaxonomyCategoriesAPIJSON taxonomyCategoriesAPIJSON= taxonomyAPIDAO.retrieve_categories();
        ViatorCategoriesDAO viatorCategoriesDAO = new ViatorCategoriesDAO();
        ViatorSubcategoriesDAO viatorSubcategoriesDAO=new ViatorSubcategoriesDAO();
        DateTime dateTime;

        /**
         * Statistic Values/Information/Results in JSON for Admin.
         */
        InfoJSON infoJason=new InfoJSON();
        infoJason.setViatorError(false);
        infoJason.setDbCommError(false);
        infoJason.setDbCommErrorsCounter(0);

        if (taxonomyCategoriesAPIJSON.isSuccess() && taxonomyCategoriesAPIJSON.getData()!=null){
            for(TaxonomyCategoriesData cat:taxonomyCategoriesAPIJSON.getData()) {
                viatorCategoriesBean.setGroupname(cat.getGroupName());
                viatorCategoriesBean.setGroupUrlname(cat.getGroupUrlName());
                viatorCategoriesBean.setId(cat.getId());
                viatorCategoriesBean.setProductCount(cat.getProductCount());
                viatorCategoriesBean.setSortOrder(cat.getSortOrder());
                viatorCategoriesBean.setThumbnailHiResUrl(cat.getThumbnailHiResURL());
                viatorCategoriesBean.setThumbnailUrl(cat.getThumbnailURL());
                dateTime =new DateTime( DateTimeZone.UTC);
                viatorCategoriesBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                  dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                  dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));

                if(viatorCategoriesDAO.deleteCategory(viatorCategoriesBean.getId())){
                    infoJason.setDbCommErrorsCounter(infoJason.getDbCommErrorsCounter()+1);
                    infoJason.setDbCommError(true);
                }

                if(viatorCategoriesDAO.addcategory(viatorCategoriesBean)){
                    infoJason.setDbCommErrorsCounter(infoJason.getDbCommErrorsCounter()+1);
                    infoJason.setDbCommError(true);
                }

                for(TaxonomySubcategory subcat:cat.getSubcategories()){
                    viatorsubcategoriesBean.setCategoryId(subcat.getCategoryId());
                    viatorsubcategoriesBean.setId(subcat.getSubcategoryId());
                    viatorsubcategoriesBean.setSortOrder(subcat.getSortOrder());
                    viatorsubcategoriesBean.setSubcategoryName(subcat.getSubcategoryName());
                    viatorsubcategoriesBean.setSubcategoryUrlName(subcat.getSubcategoryUrlName());


                    if(viatorSubcategoriesDAO.deleteSubcategory(viatorsubcategoriesBean.getId(),viatorsubcategoriesBean.getCategoryId())){
                        infoJason.setDbCommErrorsCounter(infoJason.getDbCommErrorsCounter()+1);
                        infoJason.setDbCommError(true);
                    }


                    if(viatorSubcategoriesDAO.addsubcategory(viatorsubcategoriesBean)){
                        infoJason.setDbCommErrorsCounter(infoJason.getDbCommErrorsCounter()+1);
                        infoJason.setDbCommError(true);
                    }
                }

            }
        }else{
            System.out.println("********************** Communication ERROR.Did not received Categories **********************");
            infoJason.setViatorErrorInfo("Communication ERROR.Did not received Categories");
            infoJason.setViatorError(true);
        }

        return infoJason;
    }
}

