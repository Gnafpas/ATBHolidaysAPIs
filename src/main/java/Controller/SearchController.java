package Controller;

import APIBeans.*;
import DAOs.Product;
import DAOs.Taxonomy;
import WebServicesBeans.City;
import WebServicesBeans.Region;
import WebServicesBeans.Search_Attraction_JSON;
import WebServicesBeans.Search_Destinations_JSON;
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


    @RequestMapping("/search")
    public Product_Search_Freetext_APIJSON search() {
        List<String> searchTypes=new ArrayList<>();

        searchTypes.add("PRODUCT");
        Product product=new Product();
        Post_To_Search_Freetext post_To_Search_Freetext =new Post_To_Search_Freetext();
        post_To_Search_Freetext.setCurrencyCode("EUR");
        post_To_Search_Freetext.setDestId(684);
        post_To_Search_Freetext.setSearchTypes(searchTypes);
        post_To_Search_Freetext.setText("New York");
        post_To_Search_Freetext.setTopX("1-50");
        return product.product_searchfreetext(post_To_Search_Freetext);

    }

    @RequestMapping("/Destinations")
    public Search_Destinations_JSON destinations(@RequestParam(value="textbox", defaultValue="") String textbox) {
        Search_Destinations_JSON destinations_JSON=new Search_Destinations_JSON();
        if(!textbox.isEmpty() && textbox.length()>=2) {
            Destinations_Taxonomy_APIJSON destinations_taxonomy_APIJSON;
            List<City> cities=new ArrayList<>();
            List<String> countries=new ArrayList<>();
            List<Region> regions=new ArrayList<>();
            City city;
            Region region;
            String[] split_lookupid;
            int max_length_dest_list=5;
            int cities_counter=0;
            int countries_counter=0;
            int regions_counter=0;
            String dest_name;
            String[] dest_name_substrings;
            Taxonomy taxonomy = new Taxonomy();
            destinations_taxonomy_APIJSON = taxonomy.retrieve_destinations();
            for(int i=0;i<destinations_taxonomy_APIJSON.getData().size();i++) {
                 dest_name=destinations_taxonomy_APIJSON.getData().get(i).getDestinationName();
                 dest_name_substrings =dest_name.split("-|\\ +");
                 for ( String dest_name_substring : dest_name_substrings) {
                     if (textbox.length() < dest_name_substring.length())
                         dest_name_substring = dest_name_substring.substring(0, textbox.length());
                     if (textbox.equalsIgnoreCase(dest_name_substring)) {
                         if (destinations_taxonomy_APIJSON.getData().get(i).getDestinationType().equals("CITY") && cities_counter < max_length_dest_list) {
                             city = new City();
                             city.setCity(destinations_taxonomy_APIJSON.getData().get(i).getDestinationName());
                             split_lookupid = destinations_taxonomy_APIJSON.getData().get(i).getLookupId().split(Pattern.quote("."));
                             for (int j = 0; j < destinations_taxonomy_APIJSON.getData().size(); j++) {
                                 if (destinations_taxonomy_APIJSON.getData().get(j).getDestinationId() == Integer.parseInt(split_lookupid[1])) {
                                     city.setCountry(destinations_taxonomy_APIJSON.getData().get(j).getDestinationName());
                                     break;
                                 }
                             }
                             cities.add(city);
                             cities_counter++;
                         }
                         if (destinations_taxonomy_APIJSON.getData().get(i).getDestinationType().equals("COUNTRY") && countries_counter < max_length_dest_list) {
                             countries.add(destinations_taxonomy_APIJSON.getData().get(i).getDestinationName());
                             countries_counter++;
                         }
                         if (destinations_taxonomy_APIJSON.getData().get(i).getDestinationType().equals("REGION") && regions_counter < max_length_dest_list) {
                             region = new Region();
                             region.setRegion(destinations_taxonomy_APIJSON.getData().get(i).getDestinationName());
                             split_lookupid = destinations_taxonomy_APIJSON.getData().get(i).getLookupId().split(Pattern.quote("."));
                             for (int j = 0; j < destinations_taxonomy_APIJSON.getData().size(); j++) {
                                 if (destinations_taxonomy_APIJSON.getData().get(j).getDestinationId() == Integer.parseInt(split_lookupid[1])) {
                                     region.setCountry(destinations_taxonomy_APIJSON.getData().get(j).getDestinationName());
                                     break;
                                 }
                             }
                             regions.add(region);
                             regions_counter++;
                         }
                      break;
                     }
                 }
                 if(regions_counter>=max_length_dest_list && countries_counter>=max_length_dest_list && cities_counter>=max_length_dest_list)
                    break;
            }
            for(int i=0;i<countries.size();i++) {
                if(cities.size()>0)
                    cities.remove(cities.size() - 1);
                if(regions.size()>0)
                    regions.remove(regions.size() - 1);
            }
            for(int i=0;i<cities.size();i++) {
                if(regions.size()>0)
                    regions.remove(regions.size() - 1);
            }

            destinations_JSON.setCities(cities);
            destinations_JSON.setCountries(countries);
            destinations_JSON.setRegions(regions);

        }
        return destinations_JSON;

    }


    @RequestMapping("/Attractions")
    public List<Search_Attraction_JSON> attractions(@RequestParam(value="textbox", defaultValue="") String textbox) {
        List<Search_Attraction_JSON> search_attractions_JSON=new ArrayList<>();
        List<Search_Attraction_JSON> global_search_attractions_JSON=new ArrayList<>();
        if(!textbox.isEmpty() && textbox.length()>=2) {
            Attractions_Taxonomy_APIJSON attractions_taxonomy_APIJSON;
            Taxonomy taxonomy = new Taxonomy();
            int max_length_attr_list = 5;
            int attractions_counter = 0;
            Search_Attraction_JSON search_attraction_JSON;
            String attr_name;
            String[] attr_name_substrings;
            for(int j=0;j<10;j++) {
                attractions_counter=0;
                attractions_taxonomy_APIJSON = taxonomy.retrieve_attractions(j, "", "SEO_REVIEW_AVG_RATING_D");
                if (attractions_taxonomy_APIJSON.isSuccess()) {
                    for (int i = 0; i < attractions_taxonomy_APIJSON.getData().size(); i++) {
                        attr_name = attractions_taxonomy_APIJSON.getData().get(i).getPageUrlName();
                        attr_name_substrings = attr_name.split("-|\\ +");
                        for (String attr_name_substring : attr_name_substrings) {
                            if (textbox.length() < attr_name_substring.length())
                                attr_name_substring = attr_name_substring.substring(0, textbox.length());
                            if (textbox.equalsIgnoreCase(attr_name_substring)) {
                                search_attraction_JSON = new Search_Attraction_JSON();
                                search_attraction_JSON.setAtraction_name(attractions_taxonomy_APIJSON.getData().get(i).getPageUrlName());
                                search_attraction_JSON.setAtraction_city(attractions_taxonomy_APIJSON.getData().get(i).getAttractionCity());
                                search_attraction_JSON.setAtraction_state(attractions_taxonomy_APIJSON.getData().get(i).getAttractionState());
                                search_attraction_JSON.setAtraction_rating(attractions_taxonomy_APIJSON.getData().get(i).getRating());
                                search_attractions_JSON.add(search_attraction_JSON);
                                attractions_counter++;
                                break;
                            }
                        }
                        if (attractions_counter >= max_length_attr_list)
                            break;
                    }
                }
            }
        }
        return search_attractions_JSON;
    }
}
