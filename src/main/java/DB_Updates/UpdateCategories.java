package DB_Updates;

import APIBeans.Taxonomy.Taxonomy_Categories_APIJSON;
import APIBeans.Taxonomy.Taxonomy_Categories_Data;
import APIBeans.Taxonomy.Taxonomy_Subcategory;
import DAOs.API_DAOs.Taxonomy_API_DAO;
import DAOs.DB_DAOs.Viator_Categories_DAO;
import DAOs.DB_DAOs.Viator_Subcategories_DAO;
import DB_Beans.ViatorCategoriesBean;
import DB_Beans.ViatorSubcategoriesBean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by George on 19/06/17.
 */
public class UpdateCategories {

    public void updateCategories() {

        ViatorCategoriesBean viatorcategoriesBean=new ViatorCategoriesBean();
        ViatorSubcategoriesBean viatorsubcategoriesBean=new ViatorSubcategoriesBean();
        Taxonomy_API_DAO taxonomy_API_DAO = new Taxonomy_API_DAO();
        Taxonomy_Categories_APIJSON taxonomy_categories_APIJSON=taxonomy_API_DAO.retrieve_categories();
        Viator_Categories_DAO viator_categories_DAO = new Viator_Categories_DAO();
        Viator_Subcategories_DAO viator_subcategories_DAO=new Viator_Subcategories_DAO();
        Date date=new Date();//todo

        if (taxonomy_categories_APIJSON.isSuccess()){

            for(Taxonomy_Categories_Data cat:taxonomy_categories_APIJSON.getData()) {

                viator_categories_DAO.deleteCategory(cat.getId());
                viatorcategoriesBean.setGroupname(cat.getGroupName());
                viatorcategoriesBean.setGroupUrlname(cat.getGroupUrlName());
                viatorcategoriesBean.setId(cat.getId());
                viatorcategoriesBean.setProductCount(cat.getProductCount());
                viatorcategoriesBean.setSortOrder(cat.getSortOrder());
                viatorcategoriesBean.setThumbnailHiResUrl(cat.getThumbnailHiResURL());
                viatorcategoriesBean.setThumbnailUrl(cat.getThumbnailURL());
                viatorcategoriesBean.setCreatedAt(new Timestamp(date.getTime()));
                viatorcategoriesBean.setUpdatedAt(new Timestamp(date.getTime()));
                for(Taxonomy_Subcategory subcat:cat.getSubcategories()){
                    viator_subcategories_DAO.deleteSubcategory(subcat.getId());
                    viatorsubcategoriesBean.setCategoryId(subcat.getCategoryId());
                    viatorsubcategoriesBean.setId(subcat.getId());
                    viatorsubcategoriesBean.setSortOrder(subcat.getSortOrder());
                    viatorsubcategoriesBean.setSubcategoryName(subcat.getSubcategoryName());
                    viatorsubcategoriesBean.setSubcategoryUrlName(subcat.getSubcategoryUrlName());

                    viator_subcategories_DAO.addsubcategory(viatorsubcategoriesBean);
                }

                viator_categories_DAO.addcategory(viatorcategoriesBean);
            }
        }

    }
}

