package DB_Updates;

import APIBeans.Products_By_DestID_SeoID.Products_By_Attraction_POST;
import APIBeans.Products_By_DestID_SeoID.Products_By_DestID_SeoID_APIJSON;
import APIBeans.Products_By_DestID_SeoID.Products_By_Destination_POST;
import DAOs.API_DAOs.Product_API_DAO;
import DAOs.DB_DAOs.Viator_Product_Details_DAO;
import DB_Beans.ViatorProductDetailsBean;

import java.util.Date;
import java.sql.Timestamp;

/**
 * Created by George on 15/06/2017.
 */
public class Update {



    public void updateProducts() {
        Products_By_DestID_SeoID_APIJSON products_by_destIDSeoID_APIJSON;
        Product_API_DAO product_API_DAO = new Product_API_DAO();
        Products_By_Attraction_POST products_by_attraction_POST = new Products_By_Attraction_POST();
        Products_By_Destination_POST products_by_destination_POST = new Products_By_Destination_POST();

        int destId = 496;
        String topX = "";
        String currencyCode = "EUR";
        String startDate = "";
        String endDate = "";
        int catId = 0;
        int subCatId = 0;
        boolean dealsOnly = false;
        String sortOrder = "TOP_SELLERS";
        int seoId = 0;


        Byte b=0;
        Date date = new Date();

        if (seoId == 0) {
            products_by_destination_POST.setCatId(catId);
            products_by_destination_POST.setCurrencyCode(currencyCode);
            products_by_destination_POST.setDealsOnly(dealsOnly);
            products_by_destination_POST.setDestId(destId);
            products_by_destination_POST.setEndDate(endDate);
            products_by_destination_POST.setStartDate(startDate);
            products_by_destination_POST.setSortOrder(sortOrder);
            products_by_destination_POST.setTopX(topX);
            products_by_destination_POST.setSubCatId(subCatId);
            products_by_destIDSeoID_APIJSON = product_API_DAO.search_products(products_by_destination_POST, products_by_attraction_POST, true);
        } else {
            products_by_attraction_POST.setCatId(catId);
            products_by_attraction_POST.setCurrencyCode(currencyCode);
            products_by_attraction_POST.setDealsOnly(dealsOnly);
            products_by_attraction_POST.setSeoId(seoId);
            products_by_attraction_POST.setEndDate(endDate);
            products_by_attraction_POST.setStartDate(startDate);
            products_by_attraction_POST.setSortOrder(sortOrder);
            products_by_attraction_POST.setTopX(topX);
            products_by_attraction_POST.setSubCatId(subCatId);
            products_by_destIDSeoID_APIJSON = product_API_DAO.search_products(products_by_destination_POST, products_by_attraction_POST, false);
        }
        if (products_by_destIDSeoID_APIJSON.isSuccess()) {
            for (int i = 0; i < products_by_destIDSeoID_APIJSON.getData().size(); i++) {
                ViatorProductDetailsBean productDetailsBean = new ViatorProductDetailsBean();
                productDetailsBean.setTitleEn(products_by_destIDSeoID_APIJSON.getData().get(i).getTitle());
                productDetailsBean.setCode(products_by_destIDSeoID_APIJSON.getData().get(i).getCode());
                productDetailsBean.setCurrencyCode(products_by_destIDSeoID_APIJSON.getData().get(i).getCurrencyCode());
                productDetailsBean.setPrice(products_by_destIDSeoID_APIJSON.getData().get(i).getPrice());
                productDetailsBean.setPrimaryDestinationId(products_by_destIDSeoID_APIJSON.getData().get(i).getPrimaryDestinationId());
                productDetailsBean.setSpecialReservation(b);
                productDetailsBean.setMerchantCancellable(b);
                productDetailsBean.setOnSale(b);
                productDetailsBean.setSpecialOfferAvailable(b);
                productDetailsBean.setTourGradesAvailable(b);
                productDetailsBean.setHotelPickup(b);
                productDetailsBean.setCreatedAt(new Timestamp(date.getTime()));
                productDetailsBean.setUpdatedAt(new Timestamp(date.getTime()));

                Viator_Product_Details_DAO Viator_Product_Details_DAO=new Viator_Product_Details_DAO();
                Viator_Product_Details_DAO.addproduct(productDetailsBean);
            }
        }
    }
}
