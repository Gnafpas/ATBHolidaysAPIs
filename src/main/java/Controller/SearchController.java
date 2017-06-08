package Controller;

import APIBeans.Product.Search_Freetext_POST;
import APIBeans.Product.Search_Freetext_Attractions_APIJSON;
import APIBeans.Product.Search_Freetext_Destinations_APIJSON;
import APIBeans.Product.Search_Freetext_Products_APIJSON;
import APIBeans.Taxonomy.Taxonomy_Destinations_APIJSON;
import DAOs.API_DAOs.Product_API_DAO;
import DAOs.API_DAOs.Taxonomy_API_DAO;
import WebServicesBeans.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by George on 29/05/17.
 */
@RestController
public class SearchController {



    /**
     * Returns a List of suggested Destinations/Attractions/Products
     * based on what user had type to the searchbox.
     * If something goes wrong at API's side the boolean
     * Viator_error will be set to true.
     */
    @RequestMapping("/search_freetext")
    public Search_Freetext_Suggestions_JSON search_freetext(@RequestParam(value="textbox", defaultValue="") String textbox) {

        Search_Freetext_Suggestions_JSON search_freetext_Suggestions_JSON =new Search_Freetext_Suggestions_JSON();
        if(!textbox.isEmpty() && textbox.length()>=2) {
            Products_List products = products(textbox,"1-5");
            Attractions_List attractions = attractions(textbox,"1-5");
            Destinations_List destinations = destinations(textbox,"1-5");
            if (destinations.isViator_error() || attractions.isViator_error() || products.isViator_error())
                search_freetext_Suggestions_JSON.setViator_error(true);
            search_freetext_Suggestions_JSON.setProducts(products);
            search_freetext_Suggestions_JSON.setAttractionsList(attractions);
            search_freetext_Suggestions_JSON.setDestinations(destinations);
        }
        return search_freetext_Suggestions_JSON;

    }


    /**
     * Returns a List of Products
     * based on what user had type to the searchbox.
     * If something goes wrong at API's side the boolean
     * Viator_error will be set to true.
     */
    public Products_List products(String textbox,String Topx) {

        Products_List products =new Products_List();
        Product_API_DAO product_API_DAO = new Product_API_DAO();
        Search_Freetext_POST search_freetext_POST = new Search_Freetext_POST();
        Search_Freetext_Products_APIJSON search_freetext_products_APIJSON;
        Product_Summary productSummary;
        List<Product_Summary> productsSum =new ArrayList<>();
        search_freetext_POST.setTopX(Topx);
        search_freetext_POST.setText(textbox);
        search_freetext_products_APIJSON = product_API_DAO.searchfreetext_product(search_freetext_POST);
        if (search_freetext_products_APIJSON.isSuccess()){
            for (int i = 0; i < search_freetext_products_APIJSON.getData().size(); i++) {
                productSummary = new Product_Summary();
                productSummary.setTitle(search_freetext_products_APIJSON.getData().get(i).getData().getTitle());
                productSummary.setRating(search_freetext_products_APIJSON.getData().get(i).getData().getRating());
                productSummary.setDestination(search_freetext_products_APIJSON.getData().get(i).getData().getPrimaryDestinationName());
                productsSum.add(productSummary);
            }
            products.setProducts(productsSum);
        }else
            products.setViator_error(true);
        return products;
    }


    /**
     * Returns a List of Attractions
     * based on what user had type to the searchbox.
     * If something goes wrong at API's side the boolean
     * Viator_error will be set to true.
     */
    public Attractions_List attractions(String textbox,String Topx) {

        Attractions_List attractions =new Attractions_List();
        Product_API_DAO productSearch = new Product_API_DAO();
        Search_Freetext_POST _search_freetextPOST = new Search_Freetext_POST();
        Search_Freetext_Attractions_APIJSON _search_freetext_Attractions_APIJSON;
        Attraction_Summary attractionSummary;
        List<Attraction_Summary> attractionSummaries =new ArrayList<>();
        _search_freetextPOST.setTopX(Topx);
        _search_freetextPOST.setText(textbox);
        _search_freetext_Attractions_APIJSON = productSearch.searchfreetext_attraction(_search_freetextPOST);
        if (_search_freetext_Attractions_APIJSON.isSuccess()){
            for (int i = 0; i < _search_freetext_Attractions_APIJSON.getData().size(); i++) {
                attractionSummary = new Attraction_Summary();
                attractionSummary.setTitle(_search_freetext_Attractions_APIJSON.getData().get(i).getData().getTitle());
                attractionSummary.setRating(_search_freetext_Attractions_APIJSON.getData().get(i).getData().getRating());
                attractionSummary.setState(_search_freetext_Attractions_APIJSON.getData().get(i).getData().getAttractionState());
                attractionSummary.setCity(_search_freetext_Attractions_APIJSON.getData().get(i).getData().getPrimaryDestinationName());
                attractionSummaries.add(attractionSummary);
            }
            attractions.setAtractions(attractionSummaries);
        }else
            attractions.setViator_error(true);
        return attractions;

    }


    /**
     * Returns a List of Destinations(Countries,Cities,Regions)
     * based on what user had type to the searchbox.
     * If something goes wrong at API's side the boolean
     * Viator_error will be set to true.
     */
    public Destinations_List destinations(String textbox,String Topx) {

        Destinations_List destinations =new Destinations_List();
        Product_API_DAO product_API_DAO = new Product_API_DAO();
        Search_Freetext_POST search_freetext_POST = new Search_Freetext_POST();
        Search_Freetext_Destinations_APIJSON search_freetext_destinations_APIJSON;
        Taxonomy_Destinations_APIJSON taxonomy_destinations_APIJSON;
        List<String> countries = new ArrayList<>();
        List<City> cities = new ArrayList<>();
        List<Region> regions = new ArrayList<>();
        City city;
        Region region;
        Taxonomy_API_DAO taxonomy_API_DAO = new Taxonomy_API_DAO();
        String[] split_lookupid;
        search_freetext_POST.setTopX(Topx);
        search_freetext_POST.setText(textbox);
        search_freetext_destinations_APIJSON = product_API_DAO.searchfreetext_destination(search_freetext_POST);
        taxonomy_destinations_APIJSON = taxonomy_API_DAO.retrieve_destinations();
        if (search_freetext_destinations_APIJSON.isSuccess() && taxonomy_destinations_APIJSON.isSuccess()){
            for (int i = 0; i < search_freetext_destinations_APIJSON.getData().size(); i++) {
                if (search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationType().equals("COUNTRY"))
                    countries.add(search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationName());
                if (search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationType().equals("CITY")) {
                    city = new City();
                    city.setName(search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationName());


                    /**
                     * Code for finding city's Country from Taxonomy/Destinations API Service
                     */
                    split_lookupid = search_freetext_destinations_APIJSON.getData().get(i).getData().getLookupId().split(Pattern.quote("."));
                    for (int j = 0; j < taxonomy_destinations_APIJSON.getData().size(); j++) {
                        if (taxonomy_destinations_APIJSON.getData().get(j).getDestinationId() == Integer.parseInt(split_lookupid[1])) {
                            city.setCountry(taxonomy_destinations_APIJSON.getData().get(j).getDestinationName());
                            break;
                        }
                    }
                    cities.add(city);
                }
                if (search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationType().equals("REGION")) {
                    region = new Region();
                    region.setName(search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationName());


                    /**
                     * Code for finding region's Country from Taxonomy/Destinations API Service
                     */
                    split_lookupid = search_freetext_destinations_APIJSON.getData().get(i).getData().getLookupId().split(Pattern.quote("."));
                    for (int j = 0; j < taxonomy_destinations_APIJSON.getData().size(); j++) {
                        if (taxonomy_destinations_APIJSON.getData().get(j).getDestinationId() == Integer.parseInt(split_lookupid[1])) {
                            region.setCountry(taxonomy_destinations_APIJSON.getData().get(j).getDestinationName());
                            break;
                        }
                    }
                    regions.add(region);


                }
            }
            destinations.setCities(cities);
            destinations.setCountries(countries);
            destinations.setRegions(regions);
        }else
            destinations.setViator_error(true);
        return destinations;

    }
}
