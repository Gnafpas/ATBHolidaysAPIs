package DAOs.EventsTravelAPIDAO;

import
        Beans.EventsTravelAPIBeans.EventsTravelCreateOrderRequest;
import Beans.EventsTravelAPIBeans.EventsTravelCreateOrderResponse;
import Beans.EventsTravelAPIBeans.EventsTravelProductsRespone;
import Helper.ProjectProperties;
import org.apache.log4j.Logger;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import static Controller.Application.errLogger;
import static Helper.ProjectProperties.eventsTravelCreateOrderURL;
import static Helper.ProjectProperties.eventsTravelGetProductsURL;

public class EventsTravelProductsAPIDAO {
    private static final Logger logger = Logger.getLogger(EventsTravelProductsAPIDAO.class);

    public static EventsTravelProductsRespone getProducts(String request){

    EventsTravelProductsRespone resp = null;
    try{
        RestTemplate restTemplate = new RestTemplate();
        ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
        ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
        resp = restTemplate.getForObject(eventsTravelGetProductsURL + request, EventsTravelProductsRespone.class);
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
    return resp;
    }


    public static EventsTravelCreateOrderResponse createOrder(String apiToken, EventsTravelCreateOrderRequest body){

        EventsTravelCreateOrderResponse resp = null;
        try{
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            resp = restTemplate.postForObject(eventsTravelCreateOrderURL + apiToken, body, EventsTravelCreateOrderResponse.class);
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
        return resp;
    }
}
