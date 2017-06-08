package DAOs.API_DAOs;

import APIBeans.Taxonomy.Taxonomy_Attractions_APIJSON;
import APIBeans.Taxonomy.Taxonomy_Destinations_APIJSON;
import APIBeans.Taxonomy.Taxonomy_Attractions_POST;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by George on 04/06/17.
 */
public class Taxonomy_API_DAO {

    private RestTemplate restTemplate;

    /**
     *
     * Retrieves Data from /service/taxonomy/destinations (Complete list of all available destinations)
     * API's web service and returns them within a JSON Object.If fails to
     * retrieve or something else went wrong it returns the object with property
     * success=false.
     */
    public Taxonomy_Destinations_APIJSON retrieve_destinations(){

        final String url =Controller.Application.apiURL+ "/service/taxonomy/destinations?apiKey=" + Controller.Application.apiKey;
        Taxonomy_Destinations_APIJSON taxonomy_Ddstinations_APIJSON =new Taxonomy_Destinations_APIJSON();
        taxonomy_Ddstinations_APIJSON.setSuccess(false);
        try {
            restTemplate = new RestTemplate();
            taxonomy_Ddstinations_APIJSON = restTemplate.getForObject(url,Taxonomy_Destinations_APIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
        }

        return taxonomy_Ddstinations_APIJSON;
    }

    /**
     *
     * Retrieves Data from /service/taxonomy/attractions (A list of available attractions
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
    public Taxonomy_Attractions_APIJSON retrieve_attractions(int destinationId, String topX, String sortOrder){

        final String url =Controller.Application.apiURL+ "/service/taxonomy/attractions?apiKey=" + Controller.Application.apiKey;
        Taxonomy_Attractions_POST taxonomy_attractions_POST =new Taxonomy_Attractions_POST();
        taxonomy_attractions_POST.setDestId(destinationId);
        taxonomy_attractions_POST.setSortOrder(sortOrder);
        taxonomy_attractions_POST.setTopX(topX);
        Taxonomy_Attractions_APIJSON taxonomy_attractions_APIJSON =new Taxonomy_Attractions_APIJSON();
        taxonomy_attractions_APIJSON.setSuccess(false);
        try {
            restTemplate = new RestTemplate();
            taxonomy_attractions_APIJSON = restTemplate.postForObject(url, taxonomy_attractions_POST,Taxonomy_Attractions_APIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
        }

        return taxonomy_attractions_APIJSON;
    }
}
