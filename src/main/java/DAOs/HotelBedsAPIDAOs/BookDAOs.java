package DAOs.HotelBedsAPIDAOs;

import Beans.HotelBedsAPIBeans.Availability.AvailabilityAPIJSON;
import Beans.HotelBedsAPIBeans.Book.BookAPIJSON;
import Beans.HotelBedsAPIBeans.Book.BookPost;
import Beans.HotelBedsAPIBeans.Book.CheckRateAPIJSON;
import Beans.HotelBedsAPIBeans.Book.CheckRatePost;
import Helper.ProjectProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.hotelBedsApiKey;
import static Helper.ProjectProperties.hotelBedsSecret;

/**
 * Created by George on 22/03/2018.
 */
public class BookDAOs {

    public static CheckRateAPIJSON checkRate(CheckRatePost checkRatePost) {
        CheckRateAPIJSON checkRateAPIJSON=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-api/1.0/checkrates";
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            String signature = org.apache.commons.codec.digest.DigestUtils.sha256Hex(hotelBedsApiKey + hotelBedsSecret + System.currentTimeMillis() / 1000);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("X-Signature", signature);
            requestHeaders.add("Api-Key", hotelBedsApiKey);
            requestHeaders.add("Accept", "application/json");
            HttpEntity<CheckRatePost> request = new HttpEntity<CheckRatePost>(checkRatePost, requestHeaders);
            checkRateAPIJSON=restTemplate.postForObject(url, request, CheckRateAPIJSON.class);
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
            checkRateAPIJSON=new CheckRateAPIJSON();
            Beans.HotelBedsAPIBeans.Error err=new Beans.HotelBedsAPIBeans.Error();
            err.setMessage(e.getResponseBodyAsString());
            checkRateAPIJSON.setError(err);
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
            checkRateAPIJSON=new CheckRateAPIJSON();
            Beans.HotelBedsAPIBeans.Error err=new Beans.HotelBedsAPIBeans.Error();
            err.setMessage(e.getResponseBodyAsString());
            checkRateAPIJSON.setError(err);
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
            checkRateAPIJSON=new CheckRateAPIJSON();
            Beans.HotelBedsAPIBeans.Error err=new Beans.HotelBedsAPIBeans.Error();
            err.setMessage(e2.getMessage());
            checkRateAPIJSON.setError(err);
        }
        return checkRateAPIJSON;
    }

    public static BookAPIJSON book(BookPost bookPost) {
        BookAPIJSON bookAPIJSON=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-api/1.2/bookings";
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            String signature = org.apache.commons.codec.digest.DigestUtils.sha256Hex(hotelBedsApiKey + hotelBedsSecret + System.currentTimeMillis() / 1000);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("X-Signature", signature);
            requestHeaders.add("Api-Key", hotelBedsApiKey);
            requestHeaders.add("Accept", "application/json");
            HttpEntity<BookPost> request = new HttpEntity<BookPost>(bookPost, requestHeaders);
            bookAPIJSON=restTemplate.postForObject(url, request, BookAPIJSON.class);
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
            bookAPIJSON=new BookAPIJSON();
            Beans.HotelBedsAPIBeans.Error err=new Beans.HotelBedsAPIBeans.Error();
            err.setMessage(e.getResponseBodyAsString());
            bookAPIJSON.setError(err);
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
            bookAPIJSON=new BookAPIJSON();
            Beans.HotelBedsAPIBeans.Error err=new Beans.HotelBedsAPIBeans.Error();
            err.setMessage(e.getResponseBodyAsString());
            bookAPIJSON.setError(err);
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
            bookAPIJSON=new BookAPIJSON();
            Beans.HotelBedsAPIBeans.Error err=new Beans.HotelBedsAPIBeans.Error();
            err.setMessage(e2.getMessage());
            bookAPIJSON.setError(err);
        }
        return bookAPIJSON;
    }


}
