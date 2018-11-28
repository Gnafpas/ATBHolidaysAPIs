package Updates.ViatorDBUpdates;

import Beans.ViatorAPIBeans.Taxonomy.TaxonomyCategoriesAPIJSON;
import Beans.ViatorAPIBeans.Taxonomy.TaxonomyCategoriesData;
import Beans.ViatorAPIBeans.Taxonomy.TaxonomySubcategory;
import DAOs.ViatorAPIDAOs.TaxonomyAPIDAO;
import DAOs.ViatorDBDAOs.ViatorCategoriesDAO;
import DAOs.ViatorDBDAOs.ViatorSubcategoriesDAO;
import DAOs.ViatorDBDAOs.ViatorUpdateCategoriesInfoDAO;
import Beans.ViatorDBBeans.ViatorCategoriesBean;
import Beans.ViatorDBBeans.ViatorSubcategoriesBean;
import Beans.ViatorDBBeans.ViatorUpdateCategoriesInfoBean;
import Beans.ViatorDBBeans.UpdateDBBeans.InfoJSON;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import java.sql.Timestamp;


/**
 * Created by George on 19/06/17.
 */
public class UpdateCategories {
//todo inform with email or some notification when categories or subcategories changed
    public static InfoJSON updateCategories() {
        ViatorCategoriesBean viatorCategoriesBean=new ViatorCategoriesBean();
        ViatorSubcategoriesBean viatorsubcategoriesBean=new ViatorSubcategoriesBean();
        TaxonomyCategoriesAPIJSON taxonomyCategoriesAPIJSON= TaxonomyAPIDAO.retrieve_categories();
        ViatorUpdateCategoriesInfoBean viatorUpdateCategoriesInfoBean=new ViatorUpdateCategoriesInfoBean();
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

                if(ViatorCategoriesDAO.deleteCategory(viatorCategoriesBean.getId())){
                    infoJason.setDbCommErrorsCounter(infoJason.getDbCommErrorsCounter()+1);
                    infoJason.setDbCommError(true);
                }

                if(ViatorCategoriesDAO.addcategory(viatorCategoriesBean)){
                    infoJason.setDbCommErrorsCounter(infoJason.getDbCommErrorsCounter()+1);
                    infoJason.setDbCommError(true);
                }

                for(TaxonomySubcategory subcat:cat.getSubcategories()){
                    viatorsubcategoriesBean.setCategoryId(subcat.getCategoryId());
                    viatorsubcategoriesBean.setId(subcat.getSubcategoryId());
                    viatorsubcategoriesBean.setSortOrder(subcat.getSortOrder());
                    viatorsubcategoriesBean.setSubcategoryName(subcat.getSubcategoryName());
                    viatorsubcategoriesBean.setSubcategoryUrlName(subcat.getSubcategoryUrlName());

                    if(ViatorSubcategoriesDAO.deleteSubcategory(viatorsubcategoriesBean.getId())){
                        infoJason.setDbCommErrorsCounter(infoJason.getDbCommErrorsCounter()+1);
                        infoJason.setDbCommError(true);
                    }

                    if(ViatorSubcategoriesDAO.addsubcategory(viatorsubcategoriesBean)){
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

        dateTime =new DateTime( DateTimeZone.UTC);
        viatorUpdateCategoriesInfoBean.setDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                   dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                   dateTime.getHourOfDay(),dateTime.getMinuteOfHour())));
        viatorUpdateCategoriesInfoBean.setDbCommError(infoJason.isDbCommError());
        viatorUpdateCategoriesInfoBean.setDbCommErrorsCounter(infoJason.getDbCommErrorsCounter());
        viatorUpdateCategoriesInfoBean.setViatoErrorInfo(infoJason.getViatorErrorInfo());
        viatorUpdateCategoriesInfoBean.setViatorError(infoJason.isViatorError());
        ViatorUpdateCategoriesInfoDAO.addViatorUpdateCategoriesInfo(viatorUpdateCategoriesInfoBean);

        return infoJason;
    }
}

