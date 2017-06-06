package DAOs;

import APIBeans.Attractions_Taxonomy_APIJSON;
import APIBeans.Destinations_Taxonomy_APIJSON;
import APIBeans.Post_To_Attractions_Taxonomy;
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

    /**
     *
     * Retrives Data from /service/taxonomy/attractions (A list of avaliable attractions
     * based on destinationId.Sortorder can be
     * SEO_PUBLISHED_DATE_D - Publish Date (Descending)
     * SEO_PUBLISHED_DATE_A - Publish Date (Ascending)
     * SEO_REVIEW_AVG_RATING_D - Traveler Rating (high→low)
     * SEO_REVIEW_AVG_RATING_A - Traveler Rating (low→high)
     * SEO_ALPHABETICAL - Alphabetical (A→Z).TopX is the size of the list)
     * API's web service and returns them within a JSON Object.If fails to
     * retrieve or something else went wrong it returns the object with property
     * success=false.
     */
    public Attractions_Taxonomy_APIJSON retrieve_attractions(int destinationId,String topX,String sortOrder){
        Post_To_Attractions_Taxonomy post_to_attractions_taxonomy=new Post_To_Attractions_Taxonomy();
        post_to_attractions_taxonomy.setDestId(destinationId);
        post_to_attractions_taxonomy.setSortOrder(sortOrder);
        post_to_attractions_taxonomy.setTopX(topX);
        final String url =Controller.Application.apiURL+ "/service/taxonomy/attractions?apiKey=" + Controller.Application.apiKey;
        Attractions_Taxonomy_APIJSON attractions_taxonomy_APIJSON=new Attractions_Taxonomy_APIJSON();
        attractions_taxonomy_APIJSON.setSuccess(false);
        try {
            restTemplate = new RestTemplate();
            attractions_taxonomy_APIJSON = restTemplate.postForObject(url,post_to_attractions_taxonomy,Attractions_Taxonomy_APIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
        }

        return attractions_taxonomy_APIJSON;
    }
}
