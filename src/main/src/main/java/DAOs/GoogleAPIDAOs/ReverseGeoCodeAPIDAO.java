package DAOs.GoogleAPIDAOs;

import Beans.GoogleAPIBeans.ReverseGeoCodeResponse;
import Helper.ProjectProperties;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static Controller.Application.errLogger;

/**
 * Created by George on 13/05/2018.
 */
public class ReverseGeoCodeAPIDAO {

    public static ReverseGeoCodeResponse getReverseGeoCode(String latitude,String longtitude){


        final String url ="https://maps.googleapis.com/maps/api/geocode/json?latlng="+latitude+","+longtitude+"&key=AIzaSyBkfC2gCEmTdhqWahVaDYkmCbpSlo0wjwA";
        ReverseGeoCodeResponse reverseGeoCodeResponse =new ReverseGeoCodeResponse();
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            reverseGeoCodeResponse = restTemplate.getForObject(url, ReverseGeoCodeResponse.class);
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

        return reverseGeoCodeResponse;
    }
}
