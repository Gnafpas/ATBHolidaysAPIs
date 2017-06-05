package Controller;

import APIBeans.Destinations_Taxonomy_Data;
import APIBeans.Destinations_Taxonomy_APIJSON;
import APIBeans.Post_To_Search_Freetext;
import APIBeans.Product_Search_Freetext_APIJSON;
import DAOs.Product;
import DAOs.Taxonomy;
import WebServicesBeans.Search_Destinations_JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

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
        Destinations_Taxonomy_APIJSON destinations_taxonomy_APIJSON;
        Search_Destinations_JSON destinations_JSON=new Search_Destinations_JSON();
        List<String> cities=new ArrayList<>();
        List<String> countries=new ArrayList<>();
        List<String> regions=new ArrayList<>();
        int max_length_dest_list=5;
        int cities_counter=0;
        int countries_counter=0;
        int regions_counter=0;
        String dest_name_substring;
        if(!textbox.isEmpty() && textbox.length()>=2) {
            Taxonomy taxonomy = new Taxonomy();
            destinations_taxonomy_APIJSON = taxonomy.retrieve_destinations();
            for(int i=0;i<destinations_taxonomy_APIJSON.getData().size();i++) {
                 dest_name_substring=destinations_taxonomy_APIJSON.getData().get(i).getDestinationName();
                 if(textbox.length()<dest_name_substring.length())
                     dest_name_substring=dest_name_substring.substring(0,textbox.length());
                 if(textbox.equalsIgnoreCase(dest_name_substring)){
                    if(destinations_taxonomy_APIJSON.getData().get(i).getDestinationType().equals("CITY") && cities_counter<max_length_dest_list) {
                        cities.add(destinations_taxonomy_APIJSON.getData().get(i).getDestinationName());
                        cities_counter++;
                    }
                    if(destinations_taxonomy_APIJSON.getData().get(i).getDestinationType().equals("COUNTRY") && countries_counter<max_length_dest_list) {
                        countries.add(destinations_taxonomy_APIJSON.getData().get(i).getDestinationName());
                        countries_counter++;
                    }
                    if(destinations_taxonomy_APIJSON.getData().get(i).getDestinationType().equals("REGION") && regions_counter<max_length_dest_list) {
                        regions.add(destinations_taxonomy_APIJSON.getData().get(i).getDestinationName());
                        regions_counter++;
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


}
