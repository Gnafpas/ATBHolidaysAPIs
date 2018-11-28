package DAOs.HotelBedsAPIDAOs;

import Beans.HotelBedsAPIBeans.Hotels.HotelsAPIJSON;
import Beans.HotelBedsAPIBeans.StatusBean;
import Helper.ProjectProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.hotelBedsApiKey;
import static Helper.ProjectProperties.hotelBedsSecret;

/**
 * Created by George on 11/01/2018.
 */
public class HotelAPIDAO {


    public static StatusBean status() {
        StatusBean status=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-api/1.0/status";
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            String signature = org.apache.commons.codec.digest.DigestUtils.sha256Hex(hotelBedsApiKey + hotelBedsSecret + System.currentTimeMillis() / 1000);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("X-Signature", signature);
            requestHeaders.add("Api-Key", hotelBedsApiKey);
            requestHeaders.add("Accept", "application/json");
            HttpEntity<?> httpEntity = new HttpEntity<>( requestHeaders);
            System.out.println(" sdasd "+ signature);
            status = restTemplate.exchange(url, HttpMethod.GET, httpEntity, StatusBean.class).getBody();
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
        }

        return status;
    }

    public static HotelsAPIJSON hotels(int from,int to) {
        HotelsAPIJSON hotelsAPIJSON=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-content-api/1.0/hotels?fields=all&language=ENG&from="+from+"&to="+to+"&useSecondaryLanguage=false";
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            String signature = org.apache.commons.codec.digest.DigestUtils.sha256Hex(hotelBedsApiKey + hotelBedsSecret + System.currentTimeMillis() / 1000);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("X-Signature", signature);
            requestHeaders.add("Api-Key", hotelBedsApiKey);
            requestHeaders.add("Accept", "application/json");
            HttpEntity<?> httpEntity = new HttpEntity<>( requestHeaders);
            hotelsAPIJSON = restTemplate.exchange(url, HttpMethod.GET, httpEntity, HotelsAPIJSON.class).getBody();
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
        }
        return hotelsAPIJSON;
    }

    public static HotelsAPIJSON activeHotels(String hotelCodes) {
        HotelsAPIJSON hotelsAPIJSON=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-content-api/1.0/hotels?codes="+hotelCodes+"&to=402";
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            String signature = org.apache.commons.codec.digest.DigestUtils.sha256Hex(hotelBedsApiKey + hotelBedsSecret + System.currentTimeMillis() / 1000);
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.add("X-Signature", signature);
            requestHeaders.add("Api-Key", hotelBedsApiKey);
            requestHeaders.add("Accept", "application/json");
            HttpEntity<?> httpEntity = new HttpEntity<>( requestHeaders);
            hotelsAPIJSON = restTemplate.exchange(url, HttpMethod.GET, httpEntity, HotelsAPIJSON.class).getBody();
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
        }
        return hotelsAPIJSON;
    }



}
