package Controller;

import APIBeans.*;
import DAOs.Product_Search;
import DAOs.Taxonomy;
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

    @RequestMapping("/search_freetext")
    public Search_Freetext_JSON search_freetext(@RequestParam(value="textbox", defaultValue="") String textbox) {
        Search_Freetext_JSON search_freetext_JSON=new Search_Freetext_JSON();
        if(!textbox.isEmpty() && textbox.length()>=2) {
            Products_Search productsSearch_ = products(textbox);
            Attractions_Search search_attractions_JSON = attractions(textbox);
            Destinations_Search _destinations_Search = destinations(textbox);
            if (_destinations_Search.isViator_error() || search_attractions_JSON.isViator_error() || productsSearch_.isViator_error())
                search_freetext_JSON.setViator_error(true);
            search_freetext_JSON.setProducts(productsSearch_);
            search_freetext_JSON.setAttractions(search_attractions_JSON);
            search_freetext_JSON.setDestinations(_destinations_Search);
        }
        return search_freetext_JSON;

    }


    public Products_Search products(String textbox) {

        Products_Search productsSearch_ =new Products_Search();
        Product_Search productSearch = new Product_Search();
        Post_To_Search_Freetext post_to_search_freetext = new Post_To_Search_Freetext();
        Product_Search_Freetext_APIJSON product_search_freetext_APIJSON;
        Product product;
        List<Product> products=new ArrayList<>();
        post_to_search_freetext.setTopX("1-5");
        post_to_search_freetext.setText(textbox);
        product_search_freetext_APIJSON = productSearch.product_searchfreetext(post_to_search_freetext);
        if (product_search_freetext_APIJSON.isSuccess()){
            for (int i = 0; i < product_search_freetext_APIJSON.getData().size(); i++) {
                product = new Product();
                product.setTitle(product_search_freetext_APIJSON.getData().get(i).getData().getTitle());
                product.setRating(product_search_freetext_APIJSON.getData().get(i).getData().getRating());
                product.setDestination(product_search_freetext_APIJSON.getData().get(i).getData().getPrimaryDestinationName());
                products.add(product);
            }
            productsSearch_.setProducts(products);
        }else
            productsSearch_.setViator_error(true);
        return productsSearch_;
    }


    public Attractions_Search attractions(String textbox) {
        Attractions_Search search_attractions_JSON=new Attractions_Search();
        Product_Search productSearch = new Product_Search();
        Post_To_Search_Freetext post_to_search_freetext = new Post_To_Search_Freetext();
        Attractions_Search_Freetext_APIJSON attractions_search_freetext_APIJSON;
        Attraction attraction;
        List<Attraction> attractions=new ArrayList<>();
        post_to_search_freetext.setTopX("1-5");
        post_to_search_freetext.setText(textbox);
        attractions_search_freetext_APIJSON = productSearch.attraction_searchfreetext(post_to_search_freetext);
        if (attractions_search_freetext_APIJSON.isSuccess()){
            for (int i = 0; i < attractions_search_freetext_APIJSON.getData().size(); i++) {
                attraction = new Attraction();
                attraction.setTitle(attractions_search_freetext_APIJSON.getData().get(i).getData().getTitle());
                attraction.setRating(attractions_search_freetext_APIJSON.getData().get(i).getData().getRating());
                attraction.setState(attractions_search_freetext_APIJSON.getData().get(i).getData().getAttractionState());
                attraction.setCity(attractions_search_freetext_APIJSON.getData().get(i).getData().getPrimaryDestinationName());
                attractions.add(attraction);
            }
            search_attractions_JSON.setAtractions(attractions);
        }else
            search_attractions_JSON.setViator_error(true);
        return search_attractions_JSON;

    }



    public Destinations_Search destinations(String textbox) {
        Destinations_Search _destinations_Search =new Destinations_Search();
        Product_Search productSearch = new Product_Search();
        Post_To_Search_Freetext post_to_search_freetext = new Post_To_Search_Freetext();
        Destination_Search_Freetext_APIJSON destination_search_freetext_APIJSON;
        Destinations_Taxonomy_APIJSON destinations_taxonomy_APIJSON;
        List<String> countries = new ArrayList<>();
        List<City> cities = new ArrayList<>();
        City city;
        List<Region> regions = new ArrayList<>();
        Region region;
        Taxonomy taxonomy = new Taxonomy();
        String[] split_lookupid;
        post_to_search_freetext.setTopX("1-5");
        post_to_search_freetext.setText(textbox);
        destination_search_freetext_APIJSON = productSearch.destination_searchfreetext(post_to_search_freetext);
        if (destination_search_freetext_APIJSON.isSuccess()){
            for (int i = 0; i < destination_search_freetext_APIJSON.getData().size(); i++) {
                if (destination_search_freetext_APIJSON.getData().get(i).getData().getDestinationType().equals("COUNTRY"))
                    countries.add(destination_search_freetext_APIJSON.getData().get(i).getData().getDestinationName());
                if (destination_search_freetext_APIJSON.getData().get(i).getData().getDestinationType().equals("CITY")) {
                    city = new City();
                    city.setCountry(destination_search_freetext_APIJSON.getData().get(i).getData().getDestinationName());
                    city.setCity(destination_search_freetext_APIJSON.getData().get(i).getData().getDestinationName());
                    cities.add(city);
                }
                if (destination_search_freetext_APIJSON.getData().get(i).getData().getDestinationType().equals("REGION")) {
                    region = new Region();
                    region.setRegion(destination_search_freetext_APIJSON.getData().get(i).getData().getDestinationName());

                    destinations_taxonomy_APIJSON = taxonomy.retrieve_destinations();
                    if(destinations_taxonomy_APIJSON.isSuccess()) {
                        split_lookupid = destination_search_freetext_APIJSON.getData().get(i).getData().getLookupId().split(Pattern.quote("."));
                        for (int j = 0; j < destinations_taxonomy_APIJSON.getData().size(); j++) {
                            if (destinations_taxonomy_APIJSON.getData().get(j).getDestinationId() == Integer.parseInt(split_lookupid[1])) {
                                region.setCountry(destinations_taxonomy_APIJSON.getData().get(j).getDestinationName());
                                break;
                            }
                        }
                    }
                    else {
                        _destinations_Search.setViator_error(true);
                        return _destinations_Search;
                    }
                    regions.add(region);
                }
            }
            _destinations_Search.setCities(cities);
            _destinations_Search.setCountries(countries);
            _destinations_Search.setRegions(regions);
        }else
            _destinations_Search.setViator_error(true);
        return _destinations_Search;
    }
}
