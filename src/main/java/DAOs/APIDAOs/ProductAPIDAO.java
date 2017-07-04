package DAOs.APIDAOs;

import APIBeans.ProductsByCodes.ProductsByCodesAPIJSON;
import APIBeans.ProductsByCodes.ProductsByCodesPOST;
import APIBeans.ProductsByDestIDSeoID.ProductsByAttractionPOST;
import APIBeans.ProductsByDestIDSeoID.ProductsByDestIdSeoIdAPIJSON;
import APIBeans.ProductsByDestIDSeoID.ProductsByDestinationPOST;
import APIBeans.SearchFreetext.*;
import APIBeans.ProductDetails.ProductDetailedInfoAPIJSON;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by George on 29/05/17.
 */
public class ProductAPIDAO {

    private RestTemplate restTemplate;

    /**
     *
     * Retrieves Data from /service/search/freetext (Searching for Products)
     * API's web service and returns them within a JSON Object.If fails to
     * retrieve or something else went wrong it returns the object with property
     * success=false.
     */
    public ProductsByDestIdSeoIdAPIJSON searchProducts(ProductsByDestinationPOST productsByDestinationPOST, ProductsByAttractionPOST productsByAttractionPOST, boolean isDestIdPost){

        final String url =Controller.Application.apiURL+ "/service/search/products?apiKey=" + Controller.Application.apiKey;
        ProductsByDestIdSeoIdAPIJSON productsByDestIdSeoIdAPIJSON =new ProductsByDestIdSeoIdAPIJSON();
        productsByDestIdSeoIdAPIJSON.setSuccess(false);
        try {
            restTemplate = new RestTemplate();
            if(isDestIdPost)
                productsByDestIdSeoIdAPIJSON = restTemplate.postForObject(url, productsByDestinationPOST, ProductsByDestIdSeoIdAPIJSON.class);
            else
                productsByDestIdSeoIdAPIJSON = restTemplate.postForObject(url, productsByAttractionPOST, ProductsByDestIdSeoIdAPIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch ( HttpServerErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
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
    public SearchFreetextProductsAPIJSON searchFreeTextProduct(SearchFreetextPOST searchFreetextPOST){

        final String url =Controller.Application.apiURL+ "/service/search/freetext?apiKey=" + Controller.Application.apiKey;
        SearchFreetextProductsAPIJSON searchFreetextProductsAPIJSON =new SearchFreetextProductsAPIJSON();
        searchFreetextProductsAPIJSON.setSuccess(false);
        List<String> searchtypes=new ArrayList<>();
        searchtypes.add("PRODUCT");
        searchFreetextPOST.setSearchTypes(searchtypes);
        try {
            restTemplate = new RestTemplate();
            searchFreetextProductsAPIJSON = restTemplate.postForObject(url, searchFreetextPOST, SearchFreetextProductsAPIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch ( HttpServerErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
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
    public SearchFreetextDestinationsAPIJSON searchFreeTextDestination(SearchFreetextPOST searchFreetextPOST){

        final String url =Controller.Application.apiURL+ "/service/search/freetext?apiKey=" + Controller.Application.apiKey;
        SearchFreetextDestinationsAPIJSON searchFreetextDestinationsAPIJSON =new SearchFreetextDestinationsAPIJSON();
        searchFreetextDestinationsAPIJSON.setSuccess(false);
        List<String> searchtypes=new ArrayList<>();
        searchtypes.add("DESTINATION");
        searchFreetextPOST.setSearchTypes(searchtypes);
        try {
            restTemplate = new RestTemplate();
            searchFreetextDestinationsAPIJSON = restTemplate.postForObject(url, searchFreetextPOST, SearchFreetextDestinationsAPIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch ( HttpServerErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
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
    public SearchFreetextAttractionsAPIJSON searchFreeTextAttraction(SearchFreetextPOST searchFreetextPOST){

        final String url =Controller.Application.apiURL+ "/service/search/freetext?apiKey=" + Controller.Application.apiKey;
        SearchFreetextAttractionsAPIJSON searcFreetextAttractionsAPIJSON =new SearchFreetextAttractionsAPIJSON();
        searcFreetextAttractionsAPIJSON.setSuccess(false);
        List<String> searchtypes=new ArrayList<>();
        searchtypes.add("ATTRACTION");
        searchFreetextPOST.setSearchTypes(searchtypes);
        try {
            restTemplate = new RestTemplate();
            searcFreetextAttractionsAPIJSON = restTemplate.postForObject(url, searchFreetextPOST, SearchFreetextAttractionsAPIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch ( HttpServerErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
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
    public ProductDetailedInfoAPIJSON productDetailedInfo(String code, String currencyCode, boolean excludeTourGradeAvailability, boolean showUnavailable){

        final String url =Controller.Application.apiURL + "/service/product?" + "code=" + code + "&currencyCode=" + currencyCode +
                          "&excludeTourGradeAvailability=" + excludeTourGradeAvailability + "&showUnavailable=" + showUnavailable +
                          "&apiKey=" + Controller.Application.apiKey;
        ProductDetailedInfoAPIJSON productDetailedInfoAPIJSON =new ProductDetailedInfoAPIJSON();
        productDetailedInfoAPIJSON.setSuccess(false);
        try {
            restTemplate = new RestTemplate();
            productDetailedInfoAPIJSON = restTemplate.getForObject(url, ProductDetailedInfoAPIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch ( HttpServerErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
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
    public ProductsByCodesAPIJSON getproductsByCodes(ProductsByCodesPOST productsByCcdesPOST){

        final String url =Controller.Application.apiURL + "/service/search/products/codes?apiKey=" + Controller.Application.apiKey;
        ProductsByCodesAPIJSON productsByCodesAPIJSON =new ProductsByCodesAPIJSON();
        productsByCodesAPIJSON.setSuccess(false);
        try {
            restTemplate = new RestTemplate();
            productsByCodesAPIJSON = restTemplate.postForObject(url, productsByCcdesPOST, ProductsByCodesAPIJSON.class);
        }
        catch ( HttpClientErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch ( HttpServerErrorException e) {
            System.out.println("*****************"+e.getStatusCode()+"*****************");
            System.out.println("*****************"+e.getResponseBodyAsString()+"*****************");
        }
        catch( ResourceAccessException e2) {
            System.out.println("*****************"+e2.getMessage()+"*****************");
        }

        return productsByCodesAPIJSON;
    }
}
