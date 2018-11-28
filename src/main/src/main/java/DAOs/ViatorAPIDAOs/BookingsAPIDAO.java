package DAOs.ViatorAPIDAOs;

import Beans.ViatorAPIBeans.Bookings.*;
import Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix.AvailabilityAndPricingMatrixAPIJSON;
import Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix.AvailabilityAndPricingMatrixPOST;
import Beans.ViatorAPIBeans.Bookings.Book.BookAPIJSON;
import Beans.ViatorAPIBeans.Bookings.Book.BookPOST;
import Beans.ViatorAPIBeans.Bookings.CalculatePrice.CalculatePriceAPIJSON;
import Beans.ViatorAPIBeans.Bookings.CalculatePrice.CalculatePricePOST;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelAPIJSON;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelPOST;
import Beans.ViatorAPIBeans.Bookings.PastBooking.PastBookingAPIJSON;
import Beans.ViatorAPIBeans.Bookings.PickupHotel.PickupHotelsAPIJSON;
import Helper.ProjectProperties;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static Controller.Application.errLogger;

/**
 * Created by George on 07/07/2017.
 */
public class BookingsAPIDAO {

    /**
     *
     * Retrives Data from service/booking/availability/dates (Available dates for specific product identified by product code)
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public static AvailabilityDatesAPIJSON productAvailabilityDates(String productCode){

        final String url =Helper.ProjectProperties.apiURL + "/service/booking/availability/dates?" + "productCode=" + productCode
                                                          + "&apiKey=" + Helper.ProjectProperties.apiKey;
        AvailabilityDatesAPIJSON availabilityDatesAPIJSON =new AvailabilityDatesAPIJSON();
        availabilityDatesAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            availabilityDatesAPIJSON = restTemplate.getForObject(url, AvailabilityDatesAPIJSON.class);
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

        return availabilityDatesAPIJSON;
    }

    /**
     *
     * Retrives Data from service/booking/hotels (Pickup Hotels for product with given productCode)
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public static PickupHotelsAPIJSON productPickupHotels(String product_code){

        final String url =Helper.ProjectProperties.apiURL + "/service/booking/hotels?" + "productCode=" + product_code
                + "&apiKey=" + Helper.ProjectProperties.apiKey;
        PickupHotelsAPIJSON pickupHotelsAPIJSON =new PickupHotelsAPIJSON();
        pickupHotelsAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            pickupHotelsAPIJSON = restTemplate.getForObject(url, PickupHotelsAPIJSON.class);
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

        return pickupHotelsAPIJSON;
    }

    /**
     *
     * Retrives Data from /service/booking/availability/tourgrades/pricingmatrix (Pickup Hotels for product with given productCode)
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public static AvailabilityAndPricingMatrixAPIJSON productAvailabilityAndPricingMatrix(String product_code, String month, String year){

        final String url =Helper.ProjectProperties.apiURL + "/service/booking/availability/tourgrades/pricingmatrix?apiKey=" + Helper.ProjectProperties.apiKey;
        AvailabilityAndPricingMatrixAPIJSON availabilityAndPricingMatrixAPIJSON =new AvailabilityAndPricingMatrixAPIJSON();
        AvailabilityAndPricingMatrixPOST availabilityAndPricingMatrixPOST=new AvailabilityAndPricingMatrixPOST();
        availabilityAndPricingMatrixPOST.setProductCode(product_code);
        availabilityAndPricingMatrixPOST.setMonth(month);
        availabilityAndPricingMatrixPOST.setYear(year);
        availabilityAndPricingMatrixAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            availabilityAndPricingMatrixAPIJSON = restTemplate.postForObject(url, availabilityAndPricingMatrixPOST, AvailabilityAndPricingMatrixAPIJSON.class);
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

        return availabilityAndPricingMatrixAPIJSON;
    }


    /**
     *
     * Executes a book , receives the response Data from /service/booking/book
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public static BookAPIJSON book(BookPOST bookPOST){

        final String url =Helper.ProjectProperties.apiURL + "/service/booking/book?apiKey=" + Helper.ProjectProperties.apiKey;
        BookAPIJSON bookAPIJSON =new BookAPIJSON();
        bookAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            bookAPIJSON = restTemplate.postForObject(url, bookPOST, BookAPIJSON.class);
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

        return bookAPIJSON;
    }

    /**
     *
     * Retrives Data from from /service/booking/calculateprice
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public static CalculatePriceAPIJSON calculateprice(CalculatePricePOST calculatePricePOST){

        final String url =Helper.ProjectProperties.apiURL + "/service/booking/calculateprice?apiKey=" + Helper.ProjectProperties.apiKey;
        CalculatePriceAPIJSON calculatePriceAPIJSON =new CalculatePriceAPIJSON();
        calculatePriceAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            calculatePriceAPIJSON = restTemplate.postForObject(url, calculatePricePOST, CalculatePriceAPIJSON.class);
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

        return calculatePriceAPIJSON;
    }

    /**
     *
     * Retrives Data from from /service/merchant/cancellation
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public static CancelAPIJSON cancellation(CancelPOST cancelPOST){

        final String url =Helper.ProjectProperties.apiURL + "/service/merchant/cancellation?apiKey=" + Helper.ProjectProperties.apiKey;
        CancelAPIJSON cancelAPIJSON =new CancelAPIJSON();
        cancelAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            cancelAPIJSON = restTemplate.postForObject(url, cancelPOST, CancelAPIJSON.class);
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

        return cancelAPIJSON;
    }

    /**
     *
     * Retrives Data from from /service/booking/pastbooking
     * API's web service and returns them within a JSON Object.If fails to retrieve or
     * something else went wrong it returns the object with property
     * success=false.
     */
    public static PastBookingAPIJSON pastbooking(String email,int itineraryId){

        final String url =Helper.ProjectProperties.apiURL + "/service/booking/pastbooking?email="+email+"&itineraryId="+itineraryId+"&apiKey=" + Helper.ProjectProperties.apiKey;
        PastBookingAPIJSON pastBookingAPIJSON =new PastBookingAPIJSON();
        pastBookingAPIJSON.setSuccess(false);
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            pastBookingAPIJSON = restTemplate.getForObject(url, PastBookingAPIJSON.class);
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

        return pastBookingAPIJSON;
    }

}
