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
        Destinations_Taxonomy_APIJSON destinations_taxonomy_APIJSON=new Destinations_Taxonomy_APIJSON();
        Search_Destinations_JSON destinations_JSON=new Search_Destinations_JSON();
        List<String> cities=new ArrayList<>();
        List<String> countries=new ArrayList<>();
        List<String> regions=new ArrayList<>();
        String dest_name_substring;
        if(!textbox.isEmpty() && textbox.length()>=2) {
            Taxonomy taxonomy = new Taxonomy();
            destinations_taxonomy_APIJSON = taxonomy.retrieve_destinations();
            for(int i=0;i<destinations_taxonomy_APIJSON.getData().size();i++) {
                 dest_name_substring=destinations_taxonomy_APIJSON.getData().get(i).getDestinationName();
                 if(textbox.length()<dest_name_substring.length())
                     dest_name_substring=dest_name_substring.substring(0,textbox.length());
                System.out.println("*****************************************"+dest_name_substring+"*****************");
                 if(textbox.equalsIgnoreCase(dest_name_substring)){
                    if(destinations_taxonomy_APIJSON.getData().get(i).getDestinationType().equals("CITY"))
                        cities.add(destinations_taxonomy_APIJSON.getData().get(i).getDestinationName());
                    if(destinations_taxonomy_APIJSON.getData().get(i).getDestinationType().equals("COUNTRY"))
                        countries.add(destinations_taxonomy_APIJSON.getData().get(i).getDestinationName());
                    if(destinations_taxonomy_APIJSON.getData().get(i).getDestinationType().equals("REGION"))
                        regions.add(destinations_taxonomy_APIJSON.getData().get(i).getDestinationName());


                }
            }
            destinations_JSON.setCities(cities);
            destinations_JSON.setCountries(countries);
            destinations_JSON.setRegions(regions);

        }
        return destinations_JSON;

    }


}
