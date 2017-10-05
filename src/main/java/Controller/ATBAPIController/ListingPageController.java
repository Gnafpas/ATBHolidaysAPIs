package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.*;
import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;
import Beans.ATBDBBeans.KalitaonSystem.CityCodeBean;
import Beans.ATBDBBeans.KalitaonSystem.CountryCodeBean;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.AProductTitleDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CityCodeDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CountryCodeDAO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 15/09/2017.
 */
@RestController
public class ListingPageController {

    /**
     * Retrieving products by code,title,country,city,region,destination id,primary destination id or
     * a combination of those attributes.Capability of filtering by categories and sort by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A, POPULARITY, PRICE_D, PRICE_a, DURATION_D, DURATION_A.Also filtering by dates.Returns
     * all categories and how many products has each category for the specific search.
     */
    @RequestMapping(value = "/getATBProductsAndCategories", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public ProductsCategoriesListingPageJSON getATBProductsAndCategories(@RequestBody GetProductsSrvcParams params){

        ProductsCategoriesListingPageJSON productsCategoriesListingPageJSON =new ProductsCategoriesListingPageJSON();
        List<Integer> catIds=new ArrayList<>();
        List <AProductTitleBean>  products;
        int i=0;

//        ZonedDateTime startDate;//todo remove dates
//        ZonedDateTime endDate;
//        endDate=ZonedDateTime.of ( LocalDate.of ( 2017 , 9 , 29 ) ,//todo remove this code
//                                   LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );
//        startDate=ZonedDateTime.of (LocalDate.of ( 2017 , 9 , 29 ) ,
//                                    LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );
//        params.setEndDate(endDate);
//        params.setStartDate(startDate);

        /**
         * Get products
         */
        productsCategoriesListingPageJSON.setProducts(AProductTitleDAO.getProducts(params));

        /**
         * Get all categories/subcategories and Find products count for each category
         */
        CategoriesJson categoriesJson=new CategoriesJson();
//        categoriesJson =getAllCategories();
//        for(Category cat: categoriesJson.getCategories()){
//            catIds.clear();
//            catIds.add(cat.getCategory().getId());
//            params.setCategories(catIds);
//            products=ViatorProductDetailsDAO.getProducts(params);
//            if(products!=null)
//                categoriesJson.getCategories().get(i).getCategory().setProductCount(products.size());
//            i++;
//        }
        productsCategoriesListingPageJSON.setCategories(categoriesJson);
        if(productsCategoriesListingPageJSON.getProducts()==null || productsCategoriesListingPageJSON.getCategories().isDBError())
            productsCategoriesListingPageJSON.setDBError(true);

        return productsCategoriesListingPageJSON;
    }

    @RequestMapping("/getAllCountries")
    public CountriesJSON getAllCountries(){
        List<CountryCodeBean> countries;
        CountriesJSON countriesJSON=new CountriesJSON();
        countries= CountryCodeDAO.getCountries();
        if(countries!=null) {
            countriesJSON.setCountries(countries);
        }else
            countriesJSON.setDBError(true);

        return countriesJSON;
    }

    @RequestMapping("/getAllCitiesofCountry")
    public CitiesJSON getAllCities(@RequestParam (value="countryCode", defaultValue="0") String countryCode){
        List<CityCodeBean> cities;
        CitiesJSON citiesJSON=new CitiesJSON();
        cities= CityCodeDAO.getCountryCities(countryCode);
        if(cities!=null) {
            citiesJSON.setCountries(cities);
        }else
            citiesJSON.setDBError(true);
        return citiesJSON;
    }

}
