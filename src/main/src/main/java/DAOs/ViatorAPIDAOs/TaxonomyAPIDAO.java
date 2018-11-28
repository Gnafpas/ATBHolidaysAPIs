package DAOs.ViatorAPIDAOs;

import Beans.ViatorAPIBeans.Taxonomy.TaxonomyAttractionsAPIJSON;
import Beans.ViatorAPIBeans.Taxonomy.TaxonomyCategoriesAPIJSON;
import Beans.ViatorAPIBeans.Taxonomy.TaxonomyDestinationsAPIJSON;
import Beans.ViatorAPIBeans.Taxonomy.TaxonomyAttractionsPOST;
import Helper.ProjectProperties;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static Controller.Application.errLogger;


/**
 * Created by George on 04/06/17.
 */
public class TaxonomyAPIDAO {

    /**
     *
     * Retrieves Data from /service/taxonomy/destinations (Complete list of all available destinations)
     * API's web service and returns them within a JSON Object.If fails to
     * retrieve or something else went wrong it returns the object with property
     * success=false.
     */
    public static TaxonomyDestinationsAPIJSON retrieveDestinations(){

        final String url =Helper.ProjectProperties.apiURL+ "/service/taxonomy/destinations?apiKey=" + Helper.ProjectProperties.apiKey;
        TaxonomyDestinationsAPIJSON taxonomyDestinationsAPIJSON =new TaxonomyDestinationsAPIJSON();
        taxonomyDestinationsAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            taxonomyDestinationsAPIJSON = restTemplate.getForObject(url,TaxonomyDestinationsAPIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            errLogger.info("*****************"+e.getStatusCode()+"*****************");
            errLogger.info("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch ( HttpServerErrorException e) {
            errLogger.info("*****************"+e.getStatusCode()+"*****************");
            errLogger.info("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            errLogger.info("*****************"+e2.getMessage()+"*****************");
        }

        return taxonomyDestinationsAPIJSON;
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
    public static TaxonomyAttractionsAPIJSON retrieveAttractions(int destinationId, String topX, String sortOrder){

        final String url =Helper.ProjectProperties.apiURL+ "/service/taxonomy/attractions?apiKey=" + Helper.ProjectProperties.apiKey;
        TaxonomyAttractionsPOST taxonomyAttractionsPOST =new TaxonomyAttractionsPOST();
        taxonomyAttractionsPOST.setDestId(destinationId);
        taxonomyAttractionsPOST.setSortOrder(sortOrder);
        taxonomyAttractionsPOST.setTopX(topX);
        TaxonomyAttractionsAPIJSON taxonomyAttractionsAPIJSON =new TaxonomyAttractionsAPIJSON();
        taxonomyAttractionsAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            taxonomyAttractionsAPIJSON = restTemplate.postForObject(url, taxonomyAttractionsPOST,TaxonomyAttractionsAPIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            errLogger.info("*****************"+e.getStatusCode()+"*****************");
            errLogger.info("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch ( HttpServerErrorException e) {
            errLogger.info("*****************"+e.getStatusCode()+"*****************");
            errLogger.info("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            errLogger.info("*****************"+e2.getMessage()+"*****************");
        }

        return taxonomyAttractionsAPIJSON;
    }

    /**
     *
     * Retrieves Data from /service/taxonomy/categories (Complete list of all available categories)
     * API's web service and returns them within a JSON Object.If fails to
     * retrieve or something else went wrong it returns the object with property
     * success=false.
     */
    public static TaxonomyCategoriesAPIJSON retrieve_categories(){

        final String url =Helper.ProjectProperties.apiURL+ "/service/taxonomy/categories?apiKey=" + Helper.ProjectProperties.apiKey;
        TaxonomyCategoriesAPIJSON taxonomyCategoriesAPIJSON =new TaxonomyCategoriesAPIJSON();
        taxonomyCategoriesAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            taxonomyCategoriesAPIJSON = restTemplate.getForObject(url,TaxonomyCategoriesAPIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            errLogger.info("*****************"+e.getStatusCode()+"*****************");
            errLogger.info("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch ( HttpServerErrorException e) {
            errLogger.info("*****************"+e.getStatusCode()+"*****************");
            errLogger.info("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            errLogger.info("*****************"+e2.getMessage()+"*****************");
        }

        return taxonomyCategoriesAPIJSON;
    }
}
