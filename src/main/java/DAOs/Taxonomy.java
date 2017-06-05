package DAOs;

import APIBeans.Destinations_Taxonomy_APIJSON;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by George on 04/06/17.
 */
public class Taxonomy {

    private RestTemplate restTemplate;

    /**
     *
     * Retrives Data from /service/taxonomy/destinations (A list of avaliable destinations)
     * API's web service and returns them within a JSON Object.If fails to
     * retrieve or something else went wrong it returns the object with property
     * success=false.
     */
    public Destinations_Taxonomy_APIJSON retrieve_destinations(){

        final String url =Controller.Application.apiURL+ "/service/taxonomy/destinations?apiKey=" + Controller.Application.apiKey;
        Destinations_Taxonomy_APIJSON destinations_taxonomy_APIJSON=new Destinations_Taxonomy_APIJSON();
        destinations_taxonomy_APIJSON.setSuccess(false);
        try {
            restTemplate = new RestTemplate();
            destinations_taxonomy_APIJSON = restTemplate.getForObject(url,Destinations_Taxonomy_APIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
        }

        return destinations_taxonomy_APIJSON;
    }
}
