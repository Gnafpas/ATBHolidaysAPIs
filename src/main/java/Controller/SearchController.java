package Controller;

import APIBeans.Products_By_DestID_SeoID.Products_By_Attraction_POST;
import APIBeans.Products_By_DestID_SeoID.Products_By_DestID_SeoID_APIJSON;
import APIBeans.Products_By_DestID_SeoID.Products_By_Destination_POST;
import APIBeans.Search_Freetext.*;
import APIBeans.Product_Details.Product_Detailed_Info_APIJSON;
import APIBeans.Taxonomy.Taxonomy_Destinations_APIJSON;
import DAOs.API_DAOs.Product_API_DAO;
import DAOs.API_DAOs.Taxonomy_API_DAO;
import DB_Updates.Update;
import WebServicesBeans.Paging_List.*;
import WebServicesBeans.Suggestions.*;
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

    @RequestMapping("/get_categories_by_destination")
    public List<Destination_Category> get_categories_by_destination(@RequestParam(value="destId", defaultValue="0")Integer destId){
        List<Destination_Category> destination_categories =new ArrayList<>();
        Destination_Category destination_category;
        Products_By_DestID_SeoID_APIJSON products_by_destIDSeoID_APIJSON;
        Product_API_DAO product_API_DAO = new Product_API_DAO();
        Products_By_Destination_POST products_by_destination_POST= new Products_By_Destination_POST();
        Products_By_Attraction_POST products_by_attraction_POST=new Products_By_Attraction_POST();
        products_by_destination_POST.setCatId(0);
        products_by_destination_POST.setCurrencyCode("EUR");
        products_by_destination_POST.setDealsOnly(false);
        products_by_destination_POST.setDestId(destId);
        products_by_destination_POST.setEndDate("");
        products_by_destination_POST.setStartDate("");
        products_by_destination_POST.setSortOrder("TOP_SELLERS");
        products_by_destination_POST.setTopX("");
        products_by_destination_POST.setSubCatId(0);
        products_by_destIDSeoID_APIJSON = product_API_DAO.search_products(products_by_destination_POST,products_by_attraction_POST,true);
        if (products_by_destIDSeoID_APIJSON.isSuccess()) {
            for (int i = 0; i < products_by_destIDSeoID_APIJSON.getData().size(); i++) {
                for(int j=0;j<products_by_destIDSeoID_APIJSON.getData().get(i).getCatIds().size();j++){
                    boolean exists=false;
                    for(int x=0;x<destination_categories.size();x++) {
                        if(destination_categories.get(x).getId()==products_by_destIDSeoID_APIJSON.getData().get(i).getCatIds().get(j)) {
                            destination_categories.get(x).setCount(destination_categories.get(x).getCount() + 1);
                            exists=true;
                        }
                    }
                    if(!exists) {
                        destination_category=new Destination_Category();
                        destination_category.setCount(0);
                        destination_category.setId(products_by_destIDSeoID_APIJSON.getData().get(i).getCatIds().get(j));
                        destination_categories.add(destination_category);
                        //todo set name
                    }
                }

            }
        }
        Update update=new Update();
        update.updateProducts();
        return destination_categories;
    }


    @RequestMapping("/get_products_by_destId_seoId")
    public Products_Paging_List_JSON get_products_by_destId_seoId(@RequestParam(value="destId", defaultValue="0") Integer destId,
                                                                 @RequestParam(value="topX", defaultValue="") String topX,
                                                                 @RequestParam(value="currencyCode", defaultValue="EUR") String currencyCode,
                                                                 @RequestParam(value="startDate", defaultValue="") String startDate,
                                                                 @RequestParam(value="endDate", defaultValue="") String endDate,
                                                                 @RequestParam(value="catId", defaultValue="0") Integer catId,
                                                                 @RequestParam(value="subCatId", defaultValue="0") Integer subCatId,
                                                                 @RequestParam(value="dealsOnly", defaultValue="false") boolean dealsOnly,
                                                                 @RequestParam(value="sortOrder", defaultValue="TOP_SELLERS") String sortOrder,
                                                                 @RequestParam(value="seoId", defaultValue="0") Integer seoId){

        Products_Paging_List_JSON products =new Products_Paging_List_JSON();
        Products_By_DestID_SeoID_APIJSON products_by_destIDSeoID_APIJSON;
        Product_API_DAO product_API_DAO = new Product_API_DAO();
        Products_By_Attraction_POST products_by_attraction_POST=new Products_By_Attraction_POST();
        Products_By_Destination_POST products_by_destination_POST= new Products_By_Destination_POST();
        Product_Summary product_summary;
        List<Product_Summary> products_summaries = new ArrayList<>();

        if(seoId==0) {
            products_by_destination_POST.setCatId(catId);
            products_by_destination_POST.setCurrencyCode(currencyCode);
            products_by_destination_POST.setDealsOnly(dealsOnly);
            products_by_destination_POST.setDestId(destId);
            products_by_destination_POST.setEndDate(endDate);
            products_by_destination_POST.setStartDate(startDate);
            products_by_destination_POST.setSortOrder(sortOrder);
            products_by_destination_POST.setTopX(topX);
            products_by_destination_POST.setSubCatId(subCatId);
            products_by_destIDSeoID_APIJSON = product_API_DAO.search_products(products_by_destination_POST,products_by_attraction_POST,true);
        }else{
            products_by_attraction_POST.setCatId(catId);
            products_by_attraction_POST.setCurrencyCode(currencyCode);
            products_by_attraction_POST.setDealsOnly(dealsOnly);
            products_by_attraction_POST.setSeoId(seoId);
            products_by_attraction_POST.setEndDate(endDate);
            products_by_attraction_POST.setStartDate(startDate);
            products_by_attraction_POST.setSortOrder(sortOrder);
            products_by_attraction_POST.setTopX(topX);
            products_by_attraction_POST.setSubCatId(subCatId);
            products_by_destIDSeoID_APIJSON = product_API_DAO.search_products(products_by_destination_POST,products_by_attraction_POST,false);
        }

        if (products_by_destIDSeoID_APIJSON.isSuccess()) {
            for (int i = 0; i < products_by_destIDSeoID_APIJSON.getData().size(); i++) {
                product_summary = new Product_Summary();
                product_summary.setTitle(products_by_destIDSeoID_APIJSON.getData().get(i).getTitle());
                product_summary.setRating(products_by_destIDSeoID_APIJSON.getData().get(i).getRating());
                product_summary.setLocation(products_by_destIDSeoID_APIJSON.getData().get(i).getPrimaryDestinationName());
                product_summary.setCode(products_by_destIDSeoID_APIJSON.getData().get(i).getCode());
                product_summary.setCurrencyCode(products_by_destIDSeoID_APIJSON.getData().get(i).getCurrencyCode());
                product_summary.setDuration(products_by_destIDSeoID_APIJSON.getData().get(i).getDuration());
                product_summary.setPriceFormatted(products_by_destIDSeoID_APIJSON.getData().get(i).getPriceFormatted());
                product_summary.setPrice(products_by_destIDSeoID_APIJSON.getData().get(i).getPrice());
                product_summary.setShortDescription(products_by_destIDSeoID_APIJSON.getData().get(i).getShortDescription());
                product_summary.setReviewCount(products_by_destIDSeoID_APIJSON.getData().get(i).getReviewCount());
                product_summary.setSpecialOfferAvailable(products_by_destIDSeoID_APIJSON.getData().get(i).isSpecialOfferAvailable());
                product_summary.setThumbnailHiResURL(products_by_destIDSeoID_APIJSON.getData().get(i).getThumbnailHiResURL());
                product_summary.setThumbnailURL(products_by_destIDSeoID_APIJSON.getData().get(i).getThumbnailURL());
                //todo Find country
                //todo Likely to sell out and New on viator
                //todo Short order by duration and filters by duration and filters by price
                /**
                 * If product has special offer,retrieve the price from /service/product (Poduct's details) sevice.
                 */
                if (product_summary.isSpecialOfferAvailable()) {
                    Product_Detailed_Info_APIJSON product_detailed_info_APIJSON;
                    product_detailed_info_APIJSON = product_API_DAO.product_detailed_info(product_summary.getCode(),
                            product_summary.getCurrencyCode(),
                            false,
                            false);
                    product_summary.setRrp(product_detailed_info_APIJSON.getData().getRrp());
                }

                products_summaries.add(product_summary);
            }

                products.setProducts(products_summaries);
                products.setTotalCount(products_by_destIDSeoID_APIJSON.getTotalCount());
        } else
            products.setViator_error(true);

        return products;
    
    }
    /**
     * Returns a List(Size depends on topX parameter) of Products
     * based on what user had type to the searchbox.
     * If something goes wrong at API's side the boolean
     * Viator_error will be set to true.
     */                                               //todo Return also results from isolated words of textbox
    @RequestMapping("/get_searchbox_products_results")//todo Put also language parameter
    public Products_Paging_List_JSON get_searchbox_products_results(@RequestParam(value="textbox", defaultValue="") String textbox,
                                                                    @RequestParam(value="topX", defaultValue="") String topX,
                                                                    @RequestParam(value="currencyCode", defaultValue="EUR") String currencyCode) {

        Products_Paging_List_JSON products =new Products_Paging_List_JSON();
        if(!textbox.isEmpty()) {
            Product_API_DAO product_API_DAO = new Product_API_DAO();
            Search_Freetext_POST search_freetext_POST = new Search_Freetext_POST();
            Search_Freetext_Products_APIJSON search_freetext_products_APIJSON;
            Product_Summary product_summary;
            List<Product_Summary> products_summaries = new ArrayList<>();
            search_freetext_POST.setTopX(topX);
            search_freetext_POST.setText(textbox);
            search_freetext_POST.setCurrencyCode(currencyCode);
            search_freetext_products_APIJSON = product_API_DAO.searchfreetext_product(search_freetext_POST);
            if (search_freetext_products_APIJSON.isSuccess()) {
                for (int i = 0; i < search_freetext_products_APIJSON.getData().size(); i++) {
                    product_summary = new Product_Summary();
                    product_summary.setTitle(search_freetext_products_APIJSON.getData().get(i).getData().getTitle());
                    product_summary.setRating(search_freetext_products_APIJSON.getData().get(i).getData().getRating());
                    product_summary.setLocation(search_freetext_products_APIJSON.getData().get(i).getData().getPrimaryDestinationName());
                    product_summary.setCode(search_freetext_products_APIJSON.getData().get(i).getData().getCode());
                    product_summary.setCurrencyCode(search_freetext_products_APIJSON.getData().get(i).getData().getCurrencyCode());
                    product_summary.setDuration(search_freetext_products_APIJSON.getData().get(i).getData().getDuration());
                    product_summary.setPriceFormatted(search_freetext_products_APIJSON.getData().get(i).getData().getPriceFormatted());
                    product_summary.setPrice(search_freetext_products_APIJSON.getData().get(i).getData().getPrice());
                    product_summary.setShortDescription(search_freetext_products_APIJSON.getData().get(i).getData().getShortDescription());
                    product_summary.setReviewCount(search_freetext_products_APIJSON.getData().get(i).getData().getReviewCount());
                    product_summary.setSpecialOfferAvailable(search_freetext_products_APIJSON.getData().get(i).getData().isSpecialOfferAvailable());
                    product_summary.setThumbnailHiResURL(search_freetext_products_APIJSON.getData().get(i).getData().getThumbnailHiResURL());
                    product_summary.setThumbnailURL(search_freetext_products_APIJSON.getData().get(i).getData().getThumbnailURL());
                    //todo Find country
                    //todo Likely to sell out and New on viator
                    /**
                     * If product has special offer,retrieve the price from /service/product (Poduct's details) sevice.
                     */
                    if (product_summary.isSpecialOfferAvailable()) {
                        Product_Detailed_Info_APIJSON product_detailed_info_APIJSON;
                        product_detailed_info_APIJSON = product_API_DAO.product_detailed_info(product_summary.getCode(),
                                product_summary.getCurrencyCode(),
                                false,
                                false);
                        product_summary.setRrp(product_detailed_info_APIJSON.getData().getRrp());
                    }

                    products_summaries.add(product_summary);
                }
                products.setProducts(products_summaries);
                products.setTotalCount(search_freetext_products_APIJSON.getTotalCount());
            } else
                products.setViator_error(true);
        }
        return products;

    }


    /**
     * Returns a List(Size depends on topX parameter) of Attractions
     * based on what user had type to the searchbox.
     * If something goes wrong at API's side the boolean
     * Viator_error will be set to true.
     */
    @RequestMapping("/get_searchbox_atractions_results")//todo Put also language parameter
    public Attractions_Paging_List_JSON get_searchbox_attractions_results(@RequestParam(value="textbox", defaultValue="") String textbox,
                                                                         @RequestParam(value="topX", defaultValue="") String topX) {

        Attractions_Paging_List_JSON attractions =new Attractions_Paging_List_JSON();
        if(!textbox.isEmpty()) {
            Product_API_DAO product_API_DAO = new Product_API_DAO();
            Search_Freetext_POST search_freetext_POST = new Search_Freetext_POST();
            Search_Freetext_Attractions_APIJSON search_freetext_attractions_APIJSON;
            Attraction_Summary attraction_summary;
            List<Attraction_Summary> attractions_summaries = new ArrayList<>();
            search_freetext_POST.setTopX(topX);
            search_freetext_POST.setText(textbox);
            search_freetext_attractions_APIJSON = product_API_DAO.searchfreetext_attraction(search_freetext_POST);
            if (search_freetext_attractions_APIJSON.isSuccess()) {
                for (int i = 0; i < search_freetext_attractions_APIJSON.getData().size(); i++) {
                    attraction_summary = new Attraction_Summary();
                    attraction_summary.setTitle(search_freetext_attractions_APIJSON.getData().get(i).getData().getTitle());
                    attraction_summary.setRating(search_freetext_attractions_APIJSON.getData().get(i).getData().getRating());
                    attraction_summary.setAttractionCity(search_freetext_attractions_APIJSON.getData().get(i).getData().getAttractionCity());
                    attraction_summary.setReviewCount(search_freetext_attractions_APIJSON.getData().get(i).getData().getReviewCount());
                    attraction_summary.setAttractionState(search_freetext_attractions_APIJSON.getData().get(i).getData().getAttractionState());
                    attraction_summary.setThumbnailHiResURL(search_freetext_attractions_APIJSON.getData().get(i).getData().getThumbnailHiResURL());
                    attraction_summary.setThumbnailURL(search_freetext_attractions_APIJSON.getData().get(i).getData().getThumbnailURL());
                    attraction_summary.setSeoId(search_freetext_attractions_APIJSON.getData().get(i).getData().getSeoId());
                    attraction_summary.setDescriptionText(search_freetext_attractions_APIJSON.getData().get(i).getData().getDescriptionText());
                    attraction_summary.setPagePrimaryLanguage(search_freetext_attractions_APIJSON.getData().get(i).getData().getPagePrimaryLanguage());
                    attraction_summary.setPrimaryDestinationName(search_freetext_attractions_APIJSON.getData().get(i).getData().getPrimaryDestinationName());

                    attractions_summaries.add(attraction_summary);
                }
                attractions.setAtractions(attractions_summaries);
                attractions.setTotalCount(search_freetext_attractions_APIJSON.getTotalCount());
            } else
                attractions.setViator_error(true);
        }
        return attractions;

    }



    /**
     * Returns a List of suggested Destinations/Attractions/Products
     * based on what user had type to the searchbox.
     * If something goes wrong at API's side the boolean
     * Viator_error will be set to true. //todo Return Top Destinations Attractions if textbox=""
     */                                //todo Return also results from isolated words of textbox
    @RequestMapping("/get_searchbox_suggestions_results")//todo Put also language parameter
    public Search_Freetext_Suggestions_JSON get_searchbox_suggestions_results(@RequestParam(value="textbox", defaultValue="") String textbox) {

        Search_Freetext_Suggestions_JSON search_freetext_Suggestions_JSON =new Search_Freetext_Suggestions_JSON();
        if(!textbox.isEmpty() && textbox.length()>=2) {
            Suggested_Products_List products = products(textbox,"1-5");
            Suggested_Attractions_List attractions = attractions(textbox,"1-5");
            Suggested_Destinations_List destinations = destinations(textbox,"1-5");
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
    public Suggested_Products_List products(String textbox, String Topx) {

        Suggested_Products_List products =new Suggested_Products_List();
        Product_API_DAO product_API_DAO = new Product_API_DAO();
        Search_Freetext_POST search_freetext_POST = new Search_Freetext_POST();
        Search_Freetext_Products_APIJSON search_freetext_products_APIJSON;
        Suggested_Product suggested_product;
        List<Suggested_Product> suggested_products =new ArrayList<>();
        search_freetext_POST.setTopX(Topx);
        search_freetext_POST.setText(textbox);
        search_freetext_products_APIJSON = product_API_DAO.searchfreetext_product(search_freetext_POST);
        if (search_freetext_products_APIJSON.isSuccess()){
            for (int i = 0; i < search_freetext_products_APIJSON.getData().size(); i++) {
                suggested_product = new Suggested_Product();
                suggested_product.setTitle(search_freetext_products_APIJSON.getData().get(i).getData().getTitle());
                suggested_product.setRating(search_freetext_products_APIJSON.getData().get(i).getData().getRating());
                suggested_product.setDestination(search_freetext_products_APIJSON.getData().get(i).getData().getPrimaryDestinationName());
                suggested_product.setCode(search_freetext_products_APIJSON.getData().get(i).getData().getCode());
                suggested_products.add(suggested_product);
            }
            products.setProducts(suggested_products);
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
    public Suggested_Attractions_List attractions(String textbox, String Topx) {

        Suggested_Attractions_List attractions =new Suggested_Attractions_List();
        Product_API_DAO productSearch = new Product_API_DAO();
        Search_Freetext_POST search_freetext_POST = new Search_Freetext_POST();
        Search_Freetext_Attractions_APIJSON search_freetext_attractions_APIJSON;
        Suggested_Attraction suggested_attraction;
        List<Suggested_Attraction> suggested_attractions =new ArrayList<>();
        search_freetext_POST.setTopX(Topx);
        search_freetext_POST.setText(textbox);
        search_freetext_attractions_APIJSON = productSearch.searchfreetext_attraction(search_freetext_POST);
        if (search_freetext_attractions_APIJSON.isSuccess()){
            for (int i = 0; i < search_freetext_attractions_APIJSON.getData().size(); i++) {
                suggested_attraction = new Suggested_Attraction();
                suggested_attraction.setTitle(search_freetext_attractions_APIJSON.getData().get(i).getData().getTitle());
                suggested_attraction.setRating(search_freetext_attractions_APIJSON.getData().get(i).getData().getRating());
                suggested_attraction.setState(search_freetext_attractions_APIJSON.getData().get(i).getData().getAttractionState());
                suggested_attraction.setCity(search_freetext_attractions_APIJSON.getData().get(i).getData().getPrimaryDestinationName());
                suggested_attraction.setSeoId(search_freetext_attractions_APIJSON.getData().get(i).getData().getSeoId());
                suggested_attractions.add(suggested_attraction);
            }
            attractions.setAtractions(suggested_attractions);
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
    public Suggested_Destinations_List destinations(String textbox, String Topx) {

        Suggested_Destinations_List destinations =new Suggested_Destinations_List();
        Product_API_DAO product_API_DAO = new Product_API_DAO();
        Search_Freetext_POST search_freetext_POST = new Search_Freetext_POST();
        Search_Freetext_Destinations_APIJSON search_freetext_destinations_APIJSON;
        Taxonomy_Destinations_APIJSON taxonomy_destinations_APIJSON;
        List<Country> countries = new ArrayList<>();
        List<City> cities = new ArrayList<>();
        List<Region> regions = new ArrayList<>();
        Country country;
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
                if (search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationType().equals("COUNTRY")) {
                    country=new Country();
                    country.setName(search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationName());
                    country.setDestinationId(search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationId());
                    countries.add(country);
                }
                if (search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationType().equals("CITY")) {
                    city = new City();
                    city.setName(search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationName());
                    city.setDestinationId(search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationId());

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
                    region.setDestinationId(search_freetext_destinations_APIJSON.getData().get(i).getData().getDestinationId());

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
