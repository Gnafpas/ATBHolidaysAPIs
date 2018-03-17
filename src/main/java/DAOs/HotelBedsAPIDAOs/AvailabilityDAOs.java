package DAOs.HotelBedsAPIDAOs;

import Beans.HotelBedsAPIBeans.Availability.AvailabilityAPIJSON;
import Beans.HotelBedsAPIBeans.Availability.AvailabilityPOST;
import Beans.ViatorAPIBeans.Bookings.Book.BookAPIJSON;
import Helper.ProjectProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.hotelBedsApiKey;
import static Helper.ProjectProperties.hotelBedsSecret;

/**
 * Created by George on 16/03/2018.
 */
public class AvailabilityDAOs {

    public static AvailabilityAPIJSON availability(AvailabilityPOST availabilityPOST) {
        AvailabilityAPIJSON availabilityAPIJSON=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-api/1.0/hotels";
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            String signature = org.apache.commons.codec.digest.DigestUtils.sha256Hex(hotelBedsApiKey + hotelBedsSecret + System.currentTimeMillis() / 1000);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("X-Signature", signature);
            requestHeaders.add("Api-Key", hotelBedsApiKey);
            requestHeaders.add("Accept", "application/json");
            HttpEntity<AvailabilityPOST> request = new HttpEntity<AvailabilityPOST>(availabilityPOST, requestHeaders);
            availabilityAPIJSON=restTemplate.postForObject(url, request, AvailabilityAPIJSON.class);
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
        }
        return availabilityAPIJSON;
    }
}
