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

    public static long lastupdateForEUR;
    public static long lastupdateForUSD;
    public static long lastupdateForTRY;
    public static CurrencyJSON lastcurrencyJSONForEUR;
    public static CurrencyJSON lastcurrencyJSONForUSD;
    public static CurrencyJSON lastcurrencyJSONForTRY;

    public static BigDecimal findExchangeRateAndConvert(String from, String to, double amount) {


        if(from.equals(to))
            return new BigDecimal(amount);

        final String url ="https://data.fixer.io/api/latest?access_key=053fe954f02ec01ee0a467fb84c76cdd&base="+ from;
        CurrencyJSON currencyJSON =new CurrencyJSON();

        if(from.equals("EUR")) {
            if (System.currentTimeMillis() - lastupdateForEUR >  1000*60 || lastcurrencyJSONForEUR == null) {
                try {
                    RestTemplate restTemplate = new RestTemplate();
                    ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
                    ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
                    currencyJSON = restTemplate.getForObject(url, CurrencyJSON.class);
                } catch (HttpClientErrorException e) {
                    errLogger.info("*****************" + e.getStatusCode() + "*****************");
                    errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
                } catch (HttpServerErrorException e) {
                    errLogger.info("*****************" + e.getStatusCode() + "*****************");
                    errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
                } catch (ResourceAccessException e2) {
                    errLogger.info("*****************" + e2.getMessage() + "*****************");
                }
                lastupdateForEUR = System.currentTimeMillis();
                lastcurrencyJSONForEUR = currencyJSON;
            }
            if (lastcurrencyJSONForEUR != null && lastcurrencyJSONForEUR.getRates() != null) {
                Double exhangeRate = (Double) lastcurrencyJSONForEUR.getRates().get(to);
                if (exhangeRate != null)
                    return new BigDecimal(exhangeRate * amount);
            }
        }else if(from.equals("USD")){
            if (System.currentTimeMillis() - lastupdateForUSD >  1000*60 || lastcurrencyJSONForUSD == null) {
                try {
                    RestTemplate restTemplate = new RestTemplate();
                    ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
                    ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
                    currencyJSON = restTemplate.getForObject(url, CurrencyJSON.class);
                } catch (HttpClientErrorException e) {
                    errLogger.info("*****************" + e.getStatusCode() + "*****************");
                    errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
                } catch (HttpServerErrorException e) {
                    errLogger.info("*****************" + e.getStatusCode() + "*****************");
                    errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
                } catch (ResourceAccessException e2) {
                    errLogger.info("*****************" + e2.getMessage() + "*****************");
                }
                lastupdateForUSD = System.currentTimeMillis();
                lastcurrencyJSONForUSD = currencyJSON;
            }
            if (lastcurrencyJSONForUSD != null && lastcurrencyJSONForUSD.getRates() != null) {
                Double exhangeRate = (Double) lastcurrencyJSONForUSD.getRates().get(to);
                if (exhangeRate != null)
                    return new BigDecimal(exhangeRate * amount);
            }
        }else if(from.equals("TRY")){
            if (System.currentTimeMillis() - lastupdateForTRY >  1000*60 || lastcurrencyJSONForTRY == null) {
                try {
                    RestTemplate restTemplate = new RestTemplate();
                    ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
                    ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
                    currencyJSON = restTemplate.getForObject(url, CurrencyJSON.class);
                } catch (HttpClientErrorException e) {
                    errLogger.info("*****************" + e.getStatusCode() + "*****************");
                    errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
                } catch (HttpServerErrorException e) {
                    errLogger.info("*****************" + e.getStatusCode() + "*****************");
                    errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
                } catch (ResourceAccessException e2) {
                    errLogger.info("*****************" + e2.getMessage() + "*****************");
                }
                lastupdateForTRY = System.currentTimeMillis();
                lastcurrencyJSONForTRY = currencyJSON;
            }
            if (lastcurrencyJSONForTRY != null && lastcurrencyJSONForTRY.getRates() != null) {
                Double exhangeRate = (Double) lastcurrencyJSONForTRY.getRates().get(to);
                if (exhangeRate != null)
                    return new BigDecimal(exhangeRate * amount);
            }
        }else{
            try {
                RestTemplate restTemplate = new RestTemplate();
                ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(ProjectProperties.requestTimeOut);
                ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(ProjectProperties.requestTimeOut);
                currencyJSON = restTemplate.getForObject(url, CurrencyJSON.class);
            } catch (HttpClientErrorException e) {
                errLogger.info("*****************" + e.getStatusCode() + "*****************");
                errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
            } catch (HttpServerErrorException e) {
                errLogger.info("*****************" + e.getStatusCode() + "*****************");
                errLogger.info("*****************" + e.getResponseBodyAsString() + "*****************");
            } catch (ResourceAccessException e2) {
                errLogger.info("*****************" + e2.getMessage() + "*****************");
            }
            if (currencyJSON != null && currencyJSON.getRates() != null) {
                Double exhangeRate = (Double) currencyJSON.getRates().get(to);
                if (exhangeRate != null)
                    return new BigDecimal(exhangeRate * amount);
            }
        }

        return  null;
    }
}
