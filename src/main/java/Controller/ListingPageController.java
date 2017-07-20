package Controller;

import APIBeans.Taxonomy.TaxonomyDestinationsAPIJSON;
import DAOs.APIDAOs.TaxonomyAPIDAO;
import DAOs.DBDAOs.*;
import DBBeans.ViatorCategoriesBean;
import DBBeans.ViatorDestinationsBean;
import DBBeans.ViatorProductDetailsBean;
import WebServicesBeans.ListingPage.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by George on 07/07/2017.
 */
@RestController
public class ListingPageController {



    @RequestMapping("/dest")
    public TaxonomyDestinationsAPIJSON dest(){
        TaxonomyAPIDAO taxonomyAPIDAO=new TaxonomyAPIDAO();
        return taxonomyAPIDAO.retrieveDestinations();
    }

    /**
     * Retrieving attractions by seoId,title,city,destination id or
     * a combination of those attributes.Capability of sorting by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A,ALPHABETICAL.
     */
    @RequestMapping(value = "/getAttractions", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public AttractionsListingPageJSON getAttractions(@RequestBody GetAttractionsDAOParams params){

        AttractionsListingPageJSON attractionsListingPageJSON =new AttractionsListingPageJSON();
        ViatorAttractionsDAO attractionsDAO=new ViatorAttractionsDAO();

        /**
         * Get Attractions
         */
        attractionsListingPageJSON.setAttractions(attractionsDAO.getAttractions(params));
        if(attractionsListingPageJSON.getAttractions()==null)
            attractionsListingPageJSON.setDBError(true);

        return attractionsListingPageJSON;
    }


    /**
     * Retrieving products by code,title,country,city,region,destination id,primary destination id or
     * a combination of those attributes.Capability of filtering by categories and sort by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A, POPULARITY, PRICE_D, PRICE_a, DURATION_D, DURATION_A.Also filtering by dates.Returns
     * all categories and how many products has each category for the specific search.
     */
    @RequestMapping(value = "/getProductsAndCategories", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public ProductsCategoriesListingPageJSON getProductsAndCategories(@RequestBody GetProductsDAOParams params){

        ProductsCategoriesListingPageJSON productsCategoriesListingPageJSON =new ProductsCategoriesListingPageJSON();
        ViatorProductDetailsDAO productsDao=new ViatorProductDetailsDAO();
        List<Integer> catIds=new ArrayList<>();
        List <ViatorProductDetailsBean>  products;
        int i=0;

//        ZonedDateTime startDate;//todo remove dates
//        ZonedDateTime endDate;
//        endDate=ZonedDateTime.of ( LocalDate.of ( 2017 , 10 , 2 ) ,//todo remove this code
//                                   LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );
//        startDate=ZonedDateTime.of (LocalDate.of ( 2017 , 9 , 30 ) ,
//                                    LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );
//        params.setEndDate(endDate);
//        params.setStartDate(startDate);

        /**
         * Get products
         */
        productsCategoriesListingPageJSON.setProducts(productsDao.getProducts(params));

        /**
         * Get all categories/subcategories and Find products count for each category
         */
        CategoriesJson categoriesJson;
        categoriesJson =getAllCategories();
        for(Category cat: categoriesJson.getCategories()){
            catIds.clear();
            catIds.add(cat.getCategory().getId());
            params.setCategories(catIds);
            products=productsDao.getProducts(params);
            if(products!=null)
               categoriesJson.getCategories().get(i).getCategory().setProductCount(products.size());
            i++;
        }
        productsCategoriesListingPageJSON.setCategories(categoriesJson);
        if(productsCategoriesListingPageJSON.getProducts()==null || productsCategoriesListingPageJSON.getCategories().isDBError())
            productsCategoriesListingPageJSON.setDBError(true);

        return productsCategoriesListingPageJSON;
    }

    @RequestMapping("/getAllCategories")
    public CategoriesJson getAllCategories(){
        ViatorCategoriesDAO viatorCategoriesDAO=new ViatorCategoriesDAO();
        ViatorSubcategoriesDAO viatorSubcategoriesDAO=new ViatorSubcategoriesDAO();
        CategoriesJson categoriesJson =new CategoriesJson();
        Category category;
        List<ViatorCategoriesBean> categories=viatorCategoriesDAO.getAllCategories();
        if(categories!=null) {
            for (ViatorCategoriesBean cat : categories) {
                category = new Category();
                category.setCategory(cat);
                category.setSubcategories(viatorSubcategoriesDAO.getSubcategoriesByCategoriId(cat.getId()));
                categoriesJson.getCategories().add(category);
            }
        }else
            categoriesJson.setDBError(true);
        return categoriesJson;
    }

    @RequestMapping("/getAllCountries")
    public DestinationsJSON getAllCountries(){
        List<ViatorDestinationsBean> countries=new ArrayList<>();
        List<ViatorDestinationsBean> destinations;
        ViatorDestinationsDAO destinationsDAO=new ViatorDestinationsDAO();
        DestinationsJSON destinationsJSON=new DestinationsJSON();
        destinations=destinationsDAO.getAllDestinations();
        if(destinations!=null) {
            for (ViatorDestinationsBean destination : destinations) {
                if (destination.getDestinationType().equals("COUNTRY"))
                    countries.add(destination);
            }
            destinationsJSON.setDestinations(countries);
        }else
            destinationsJSON.setDBError(true);
        return destinationsJSON;
    }

    @RequestMapping("/getRegionsOfCountry")
    public  DestinationsJSON getRegionsOfCountry(@RequestParam (value="countryId", defaultValue="0") int destId){
        List<ViatorDestinationsBean> regions=new ArrayList<>();
        List<ViatorDestinationsBean> destinations;
        ViatorDestinationsDAO destinationsDAO=new ViatorDestinationsDAO();
        DestinationsJSON destinationsJSON=new DestinationsJSON();
        String[] split;
        destinations=destinationsDAO.getAllDestinations();
        if(destinations!=null) {
            for (ViatorDestinationsBean destination : destinations) {
                split = destination.getLookupId().split(Pattern.quote("."));
                if (split[1].equals(Integer.toString(destId)) && destination.getDestinationType().equals("REGION"))
                    regions.add(destination);
            }
            destinationsJSON.setDestinations(regions);
        }else
            destinationsJSON.setDBError(true);
        return destinationsJSON;
    }

    @RequestMapping("/getCitiesOfCountry")
    public  DestinationsJSON getCitiesOfCountry(@RequestParam (value="countryId", defaultValue="0") int destId){
        List<ViatorDestinationsBean> cities=new ArrayList<>();
        List<ViatorDestinationsBean> destinations;
        ViatorDestinationsDAO destinationsDAO=new ViatorDestinationsDAO();
        DestinationsJSON destinationsJSON=new DestinationsJSON();
        String[] split;
        destinations=destinationsDAO.getAllDestinations();
        if(destinations!=null) {
            for (ViatorDestinationsBean destination : destinations) {
                split = destination.getLookupId().split(Pattern.quote("."));
                if (split[1].equals(Integer.toString(destId)) && destination.getDestinationType().equals("CITY"))
                    cities.add(destination);
            }
            destinationsJSON.setDestinations(cities);
        }else
            destinationsJSON.setDBError(true);
        return destinationsJSON;
    }

//    @RequestMapping(value = "/getLastDateWithAvailbilityInfo", method = RequestMethod.POST,consumes = "application/json")
//    @ResponseBody
//    public List<CustomDate>  getLastDateWithAvailbilityInfo(@RequestBody GetProductsDAOParams params){
//
//        ViatorNoneAvailableDatesDAO viatorNoneAvailableDatesDAO =new ViatorNoneAvailableDatesDAO();
//        List<CustomDate> dates;
//
//        params.setStartDate(null);
//        params.setEndDate(null);
//        ProductsCategoriesListingPageJSON productsCategoriesListingPageJSON=getProductsAndCategories( params);
//        System.out.print(productsCategoriesListingPageJSON.getProducts().get(0).getCode());
//        dates= viatorNoneAvailableDatesDAO.getNoneAvailDatesOfProducts(productsCategoriesListingPageJSON.getProducts());
//        return dates;
//    }

}
