package DAOs;

import APIBeans.Post_To_Search_Freetext;
import APIBeans.Destination_Search_Freetext_APIJSON;
import APIBeans.Product_Search_Freetext_APIJSON;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;



/**
 * Created by George on 29/05/17.
 */
public class Product {

    private RestTemplate restTemplate;

    /**
     *
     * Retrives Data from /service/search/freetext (Searching for Products)
     * API's web service and returns them within a JSON Object.If fails to
     * retrieve or something else went wrong it returns the object with property
     * success=false.
     */
    public Product_Search_Freetext_APIJSON product_searchfreetext(Post_To_Search_Freetext post_To_Search_Freetext){

        final String url =Controller.Application.apiURL+ "/service/search/freetext?apiKey=" + Controller.Application.apiKey;
        Product_Search_Freetext_APIJSON product_search_freetext_APIJSON=new Product_Search_Freetext_APIJSON();
        product_search_freetext_APIJSON.setSuccess(false);
        try {
            restTemplate = new RestTemplate();
            product_search_freetext_APIJSON = restTemplate.postForObject(url, post_To_Search_Freetext, Product_Search_Freetext_APIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
        }

        return product_search_freetext_APIJSON;
    }


    /**
     *
     * Retrives Data from /service/search/freetext (Searching for Destinations)
     * API's web serviceand returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public Destination_Search_Freetext_APIJSON destination_searchfreetext(Post_To_Search_Freetext post_To_Search_Freetext){

        final String url =Controller.Application.apiURL+ "/service/search/freetext?apiKey=" + Controller.Application.apiKey;
        Destination_Search_Freetext_APIJSON destination_Search_Freetext_APIJSON=new Destination_Search_Freetext_APIJSON();
        destination_Search_Freetext_APIJSON.setSuccess(false);
        try {
            restTemplate = new RestTemplate();
            destination_Search_Freetext_APIJSON = restTemplate.postForObject(url, post_To_Search_Freetext, Destination_Search_Freetext_APIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
        }

        return destination_Search_Freetext_APIJSON;
    }
}
