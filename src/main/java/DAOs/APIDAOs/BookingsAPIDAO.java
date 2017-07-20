package DAOs.APIDAOs;

import APIBeans.Bookings.AvailabilityDatesAPIJSON;
import APIBeans.Bookings.PickupHotelsAPIJSON;
import Helper.ProjectProperties;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by George on 07/07/2017.
 */
public class BookingsAPIDAO {

    private RestTemplate restTemplate;

    /**
     *
     * Retrives Data from service/booking/availability/dates (Available dates for specific product identified by product code)
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public AvailabilityDatesAPIJSON productAvailabilityDates(String productCode){

        final String url =Helper.ProjectProperties.apiURL + "/service/booking/availability/dates?" + "productCode=" + productCode
                                                          + "&apiKey=" + Helper.ProjectProperties.apiKey;
        AvailabilityDatesAPIJSON availabilityDatesAPIJSON =new AvailabilityDatesAPIJSON();
        availabilityDatesAPIJSON.setSuccess(false);
        try {
            restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            availabilityDatesAPIJSON = restTemplate.getForObject(url, AvailabilityDatesAPIJSON.class);
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

        return availabilityDatesAPIJSON;
    }

    /**
     *
     * Retrives Data from service/booking/hotels (Pickup Hotels for product with given productCode)
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public PickupHotelsAPIJSON productPickupHotels(String product_code){

        final String url =Helper.ProjectProperties.apiURL + "/service/booking/hotels?" + "productCode=" + product_code
                + "&apiKey=" + Helper.ProjectProperties.apiKey;
        PickupHotelsAPIJSON pickupHotelsAPIJSON =new PickupHotelsAPIJSON();
        pickupHotelsAPIJSON.setSuccess(false);
        try {
            restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            pickupHotelsAPIJSON = restTemplate.getForObject(url, PickupHotelsAPIJSON.class);
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

        return pickupHotelsAPIJSON;
    }
}
