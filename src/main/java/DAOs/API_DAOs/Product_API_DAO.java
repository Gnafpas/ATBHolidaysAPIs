package DAOs.API_DAOs;

import APIBeans.Product.Search_Freetext_Attractions_APIJSON;
import APIBeans.Product.Search_Freetext_POST;
import APIBeans.Product.Search_Freetext_Destinations_APIJSON;
import APIBeans.Product.Search_Freetext_Products_APIJSON;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by George on 29/05/17.
 */
public class Product_API_DAO {

    private RestTemplate restTemplate;

    /**
     *
     * Retrieves Data from /service/search/freetext (Searching for Products)
     * API's web service and returns them within a JSON Object.If fails to
     * retrieve or something else went wrong it returns the object with property
     * success=false.
     */
    public Search_Freetext_Products_APIJSON searchfreetext_product(Search_Freetext_POST search_freetext_POST){

        final String url =Controller.Application.apiURL+ "/service/search/freetext?apiKey=" + Controller.Application.apiKey;
        Search_Freetext_Products_APIJSON search_freetext_products_APIJSON =new Search_Freetext_Products_APIJSON();
        search_freetext_products_APIJSON.setSuccess(false);
        List<String> searchtypes=new ArrayList<>();
        searchtypes.add("PRODUCT");
        search_freetext_POST.setSearchTypes(searchtypes);
        try {
            restTemplate = new RestTemplate();
            search_freetext_products_APIJSON = restTemplate.postForObject(url, search_freetext_POST, Search_Freetext_Products_APIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
        }

        return search_freetext_products_APIJSON;
    }


    /**
     *
     * Retrieves Data from /service/search/freetext (Searching for Destinations)
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public Search_Freetext_Destinations_APIJSON searchfreetext_destination(Search_Freetext_POST search_freetext_POST){

        final String url =Controller.Application.apiURL+ "/service/search/freetext?apiKey=" + Controller.Application.apiKey;
        Search_Freetext_Destinations_APIJSON search_freetext_destinations_APIJSON =new Search_Freetext_Destinations_APIJSON();
        search_freetext_destinations_APIJSON.setSuccess(false);
        List<String> searchtypes=new ArrayList<>();
        searchtypes.add("DESTINATION");
        search_freetext_POST.setSearchTypes(searchtypes);
        try {
            restTemplate = new RestTemplate();
            search_freetext_destinations_APIJSON = restTemplate.postForObject(url, search_freetext_POST, Search_Freetext_Destinations_APIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
        }

        return search_freetext_destinations_APIJSON;
    }


    /**
     *
     * Retrives Data from /service/search/freetext (Searching for Attractions_List)
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public Search_Freetext_Attractions_APIJSON searchfreetext_attraction(Search_Freetext_POST search_freetext_POST){

        final String url =Controller.Application.apiURL+ "/service/search/freetext?apiKey=" + Controller.Application.apiKey;
        Search_Freetext_Attractions_APIJSON search_freetext_attractions_APIJSON =new Search_Freetext_Attractions_APIJSON();
        search_freetext_attractions_APIJSON.setSuccess(false);
        List<String> searchtypes=new ArrayList<>();
        searchtypes.add("ATTRACTION");
        search_freetext_POST.setSearchTypes(searchtypes);
        try {
            restTemplate = new RestTemplate();
            search_freetext_attractions_APIJSON = restTemplate.postForObject(url, search_freetext_POST, Search_Freetext_Attractions_APIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
        }

        return search_freetext_attractions_APIJSON;
    }
}