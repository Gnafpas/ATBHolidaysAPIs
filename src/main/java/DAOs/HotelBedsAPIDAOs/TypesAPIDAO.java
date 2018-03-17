package DAOs.HotelBedsAPIDAOs;

import Beans.HotelBedsAPIBeans.Types.AccommodationsAPIJSON;
import Beans.HotelBedsAPIBeans.Types.BoardsAPIJSON;
import Beans.HotelBedsAPIBeans.Types.FacilitiesAPIJSON;
import Beans.HotelBedsAPIBeans.Types.RoomAPIJSON;
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
 * Created by George on 10/03/2018.
 */
public class TypesAPIDAO {

    public static AccommodationsAPIJSON accommodations(int from, int to) {
        AccommodationsAPIJSON accommodationsAPIJSON=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-content-api/1.0/types/accommodations?fields=all&language=ENG&from="+from+"&to="+to+"&useSecondaryLanguage=false";
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
            accommodationsAPIJSON = restTemplate.exchange(url, HttpMethod.GET, httpEntity, AccommodationsAPIJSON.class).getBody();
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
        }
        return accommodationsAPIJSON;
    }

    public static BoardsAPIJSON boards(int from, int to) {
        BoardsAPIJSON boardsAPIJSON=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-content-api/1.0/types/boards?fields=all&language=ENG&from="+from+"&to="+to+"&useSecondaryLanguage=false";
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
            boardsAPIJSON = restTemplate.exchange(url, HttpMethod.GET, httpEntity, BoardsAPIJSON.class).getBody();
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
        }
        return boardsAPIJSON;
    }

    public static RoomAPIJSON rooms(int from, int to) {
        RoomAPIJSON roomAPIJSON=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-content-api/1.0/types/rooms?fields=all&language=ENG&from="+from+"&to="+to+"&useSecondaryLanguage=false";
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
            roomAPIJSON = restTemplate.exchange(url, HttpMethod.GET, httpEntity, RoomAPIJSON.class).getBody();
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
        }
        return roomAPIJSON;
    }

    public static FacilitiesAPIJSON facilities(int from, int to) {
        FacilitiesAPIJSON facilitiesAPIJSON=null ;
        final String url = "https://api.test.hotelbeds.com/hotel-content-api/1.0/types/facilities?fields=all&language=ENG&from="+from+"&to="+to+"&useSecondaryLanguage=false";
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
            facilitiesAPIJSON = restTemplate.exchange(url, HttpMethod.GET, httpEntity, FacilitiesAPIJSON.class).getBody();
        } catch (HttpClientErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (HttpServerErrorException e) {
            errLogger.info("*****************" + e.getStatusCode() + "*****************");
            errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
        } catch (ResourceAccessException e2) {
            errLogger.info("*****************" + e2.getMessage() + "*****************");
        }
        return facilitiesAPIJSON;
    }
}
