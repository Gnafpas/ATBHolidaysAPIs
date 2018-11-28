package DAOs.HotelBedsAPIDAOs;

import Beans.HotelBedsAPIBeans.Destiantions.CountriesAPIJSON;
import Beans.HotelBedsAPIBeans.Destiantions.DestinationsAPIJSON;
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
 * Created by George on 15/01/2018.
 */
public class DestinationsAPIDAO {

    public static DestinationsAPIJSON destinations(int from,int to) {
        DestinationsAPIJSON destinationsAPIJSON=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-content-api/1.0/locations/destinations?fields=all&language=ENG&from="+from+"&to="+to+"&useSecondaryLanguage=false";
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
            destinationsAPIJSON = restTemplate.exchange(url, HttpMethod.GET, httpEntity, DestinationsAPIJSON.class).getBody();
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
        }
        return destinationsAPIJSON;
    }

    public static CountriesAPIJSON countries() {
        CountriesAPIJSON countriesAPIJSON=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-content-api/1.0/locations/countries?fields=isoCode&countryIds=US&language=ENG&from=1&to=100";
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
            countriesAPIJSON = restTemplate.exchange(url, HttpMethod.GET, httpEntity, CountriesAPIJSON.class).getBody();
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
        }
        return countriesAPIJSON;
    }
}
