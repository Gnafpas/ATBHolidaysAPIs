package Helper;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

import static Controller.Application.errLogger;

/**
 * Created by George on 28/02/2018.
 */
public class CurrencyConverter {
    public static BigDecimal findExchangeRateAndConvert(String from, String to, double amount) {


        if(from.equals(to))
            return new BigDecimal(amount);

        final String url ="https://api.fixer.io/latest?base="+ from;
        CurrencyJSON currencyJSON =new CurrencyJSON();

        try {
            RestTemplate restTemplate = new RestTemplate();
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
            ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
            currencyJSON = restTemplate.getForObject(url,CurrencyJSON.class);
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

        if(currencyJSON!=null && currencyJSON.getRates()!=null ) {
            Double exhangeRate = (Double) currencyJSON.getRates().get(to);
            if(exhangeRate!=null)
                return new BigDecimal(exhangeRate * amount);
        }

        return  null;
    }
}
