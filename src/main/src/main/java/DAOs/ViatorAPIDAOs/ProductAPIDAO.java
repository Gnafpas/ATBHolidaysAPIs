package DAOs.ViatorAPIDAOs;

import Beans.ViatorAPIBeans.ProductsByCodes.ProductsByCodesAPIJSON;
import Beans.ViatorAPIBeans.ProductsByCodes.ProductsByCodesPOST;
import Beans.ViatorAPIBeans.ProductsByDestIDSeoID.ProductsByAttractionPOST;
import Beans.ViatorAPIBeans.ProductsByDestIDSeoID.ProductsByDestIdSeoIdAPIJSON;
import Beans.ViatorAPIBeans.ProductsByDestIDSeoID.ProductsByDestinationPOST;
import Beans.ViatorAPIBeans.SearchFreetext.*;
import Beans.ViatorAPIBeans.ProductDetails.ProductDetailedInfoAPIJSON;
import Helper.ProjectProperties;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static Controller.Application.errLogger;


/**
 * Created by George on 29/05/17.
 */
public class ProductAPIDAO {
    /**
     *
     * Retrieves Data from /service/search/freetext (Searching for Products)
     * API's web service and returns them within a JSON Object.If fails to
     * retrieve or something else went wrong it returns the object with property
     * success=false.
     */
    public static ProductsByDestIdSeoIdAPIJSON searchProducts(ProductsByDestinationPOST productsByDestinationPOST, ProductsByAttractionPOST productsByAttractionPOST, boolean isDestIdPost){

        final String url =Helper.ProjectProperties.apiURL+ "/service/search/products?apiKey=" + Helper.ProjectProperties.apiKey;
        ProductsByDestIdSeoIdAPIJSON productsByDestIdSeoIdAPIJSON =new ProductsByDestIdSeoIdAPIJSON();
        productsByDestIdSeoIdAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            if(isDestIdPost)
                productsByDestIdSeoIdAPIJSON = restTemplate.postForObject(url, productsByDestinationPOST, ProductsByDestIdSeoIdAPIJSON.class);
            else
                productsByDestIdSeoIdAPIJSON = restTemplate.postForObject(url, productsByAttractionPOST, ProductsByDestIdSeoIdAPIJSON.class);
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

        return productsByDestIdSeoIdAPIJSON;
    }

    /**
     *
     * Retrieves Data from /service/search/freetext (Searching for Products)
     * API's web service and returns them within a JSON Object.If fails to
     * retrieve or something else went wrong it returns the object with property
     * success=false.
     */
    public static SearchFreetextProductsAPIJSON searchFreeTextProduct(SearchFreetextPOST searchFreetextPOST){

        final String url =Helper.ProjectProperties.apiURL+ "/service/search/freetext?apiKey=" + Helper.ProjectProperties.apiKey;
        SearchFreetextProductsAPIJSON searchFreetextProductsAPIJSON =new SearchFreetextProductsAPIJSON();
        searchFreetextProductsAPIJSON.setSuccess(false);
        List<String> searchtypes=new ArrayList<>();
        searchtypes.add("PRODUCT");
        searchFreetextPOST.setSearchTypes(searchtypes);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            searchFreetextProductsAPIJSON = restTemplate.postForObject(url, searchFreetextPOST, SearchFreetextProductsAPIJSON.class);
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

        return searchFreetextProductsAPIJSON;
    }


    /**
     *
     * Retrieves Data from /service/search/freetext (Searching for Destinations)
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public static SearchFreetextDestinationsAPIJSON searchFreeTextDestination(SearchFreetextPOST searchFreetextPOST){

        final String url =Helper.ProjectProperties.apiURL+ "/service/search/freetext?apiKey=" + Helper.ProjectProperties.apiKey;
        SearchFreetextDestinationsAPIJSON searchFreetextDestinationsAPIJSON =new SearchFreetextDestinationsAPIJSON();
        searchFreetextDestinationsAPIJSON.setSuccess(false);
        List<String> searchtypes=new ArrayList<>();
        searchtypes.add("DESTINATION");
        searchFreetextPOST.setSearchTypes(searchtypes);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            searchFreetextDestinationsAPIJSON = restTemplate.postForObject(url, searchFreetextPOST, SearchFreetextDestinationsAPIJSON.class);
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

        return searchFreetextDestinationsAPIJSON;
    }


    /**
     *
     * Retrives Data from /service/search/freetext (Searching for SuggestedAttractionsList)
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public static SearchFreetextAttractionsAPIJSON searchFreeTextAttraction(SearchFreetextPOST searchFreetextPOST){

        final String url =Helper.ProjectProperties.apiURL+ "/service/search/freetext?apiKey=" + Helper.ProjectProperties.apiKey;
        SearchFreetextAttractionsAPIJSON searcFreetextAttractionsAPIJSON =new SearchFreetextAttractionsAPIJSON();
        searcFreetextAttractionsAPIJSON.setSuccess(false);
        List<String> searchtypes=new ArrayList<>();
        searchtypes.add("ATTRACTION");
        searchFreetextPOST.setSearchTypes(searchtypes);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            searcFreetextAttractionsAPIJSON = restTemplate.postForObject(url, searchFreetextPOST, SearchFreetextAttractionsAPIJSON.class);
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

        return searcFreetextAttractionsAPIJSON;
    }


    /**
     *
     * Retrives Data from /service/product (Details of a unique product identified by product code)
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public  static ProductDetailedInfoAPIJSON productDetailedInfo(String code, String currencyCode, boolean excludeTourGradeAvailability, boolean showUnavailable){

        final String url =Helper.ProjectProperties.apiURL + "/service/product?" + "code=" + code + "&currencyCode=" + currencyCode +
                          "&excludeTourGradeAvailability=" + excludeTourGradeAvailability + "&showUnavailable=" + showUnavailable +
                          "&apiKey=" + Helper.ProjectProperties.apiKey;
        ProductDetailedInfoAPIJSON productDetailedInfoAPIJSON =new ProductDetailedInfoAPIJSON();
        productDetailedInfoAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            productDetailedInfoAPIJSON = restTemplate.getForObject(url, ProductDetailedInfoAPIJSON.class);
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

        return productDetailedInfoAPIJSON;
    }

    /**
     *
     * Retrives Data from /service/search/products/codes
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public static ProductsByCodesAPIJSON getproductsByCodes(ProductsByCodesPOST productsByCodesPOST){

        final String url =Helper.ProjectProperties.apiURL + "/service/search/products/codes?apiKey=" + Helper.ProjectProperties.apiKey;
        ProductsByCodesAPIJSON productsByCodesAPIJSON =new ProductsByCodesAPIJSON();
        productsByCodesAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            productsByCodesAPIJSON = restTemplate.postForObject(url, productsByCodesPOST, ProductsByCodesAPIJSON.class);
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

        return productsByCodesAPIJSON;
    }
}
