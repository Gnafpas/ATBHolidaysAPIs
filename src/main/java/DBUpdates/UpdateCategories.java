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

import java.time.ZoneOffset;
import java.time.ZonedDateTime;


/**
 * Created by George on 19/06/17.
 */
public class UpdateCategories {

    public InfoJSON updateCategories() {

        ViatorCategoriesBean viatorCategoriesBean=new ViatorCategoriesBean();
        ViatorSubcategoriesBean viatorsubcategoriesBean=new ViatorSubcategoriesBean();
        TaxonomyAPIDAO taxonomyAPIDAO = new TaxonomyAPIDAO();
        TaxonomyCategoriesAPIJSON taxonomyCategoriesAPIJSON= taxonomyAPIDAO.retrieve_categories();
        ViatorCategoriesDAO viatorCategoriesDAO = new ViatorCategoriesDAO();
        ViatorSubcategoriesDAO viatorSubcategoriesDAO=new ViatorSubcategoriesDAO();

        /**
         * Statistic Values/Information/Results in JSON for Admin.
         */
        InfoJSON infoJason=new InfoJSON();
        infoJason.setViatorError(false);
        infoJason.setDbCommError(false);
        infoJason.setDbCommErrorCounter(0);

        if (taxonomyCategoriesAPIJSON.isSuccess() && taxonomyCategoriesAPIJSON.getData()!=null){
            for(TaxonomyCategoriesData cat:taxonomyCategoriesAPIJSON.getData()) {
                viatorCategoriesBean.setGroupname(cat.getGroupName());
                viatorCategoriesBean.setGroupUrlname(cat.getGroupUrlName());
                viatorCategoriesBean.setId(cat.getId());
                viatorCategoriesBean.setProductCount(cat.getProductCount());
                viatorCategoriesBean.setSortOrder(cat.getSortOrder());
                viatorCategoriesBean.setThumbnailHiResUrl(cat.getThumbnailHiResURL());
                viatorCategoriesBean.setThumbnailUrl(cat.getThumbnailURL());
                viatorCategoriesBean.setUpdatedAt(ZonedDateTime.now(ZoneOffset.UTC));

                if(viatorCategoriesDAO.deleteCategory(viatorCategoriesBean.getId())){
                    infoJason.setDbCommErrorCounter(infoJason.getDbCommErrorCounter()+1);
                    infoJason.setDbCommError(true);
                }

                if(viatorCategoriesDAO.addcategory(viatorCategoriesBean)){
                    infoJason.setDbCommErrorCounter(infoJason.getDbCommErrorCounter()+1);
                    infoJason.setDbCommError(true);
                }

                for(TaxonomySubcategory subcat:cat.getSubcategories()){
                    viatorsubcategoriesBean.setCategoryId(subcat.getCategoryId());
                    viatorsubcategoriesBean.setId(subcat.getSubcategoryId());
                    viatorsubcategoriesBean.setSortOrder(subcat.getSortOrder());
                    viatorsubcategoriesBean.setSubcategoryName(subcat.getSubcategoryName());
                    viatorsubcategoriesBean.setSubcategoryUrlName(subcat.getSubcategoryUrlName());


                    if(viatorSubcategoriesDAO.deleteSubcategory(viatorsubcategoriesBean.getId(),viatorsubcategoriesBean.getCategoryId())){
                        infoJason.setDbCommErrorCounter(infoJason.getDbCommErrorCounter()+1);
                        infoJason.setDbCommError(true);
                    }


                    if(viatorSubcategoriesDAO.addsubcategory(viatorsubcategoriesBean)){
                        infoJason.setDbCommErrorCounter(infoJason.getDbCommErrorCounter()+1);
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

