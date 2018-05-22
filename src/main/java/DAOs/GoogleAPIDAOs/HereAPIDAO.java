package DAOs.GoogleAPIDAOs;

import Beans.HereAPIBeans.ReverseGeocodeResponse;
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
public class HereAPIDAO {
    public static ReverseGeocodeResponse getReverseGeoCode(String latitude,String longtitude){


        final String url ="https://reverse.geocoder.cit.api.here.com/6.2/reversegeocode.json?prox="+latitude+","+longtitude+"&language=ENG&mode=retrieveAreas&maxresults=1&gen=8&app_id=TzNHOfRnLmlmRbJJn75v&app_code=MW-xlrHXap1CKJANXZR9uw";
        ReverseGeocodeResponse reverseGeocodeResponse =new ReverseGeocodeResponse();
        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            reverseGeocodeResponse = restTemplate.getForObject(url, ReverseGeocodeResponse.class);
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

        return reverseGeocodeResponse;
    }

}
