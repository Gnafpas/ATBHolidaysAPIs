package DAOs;

import APIBeans.Post_To_Search_Freetext;
import APIBeans.Search_Freetext_APIJSON;
import org.springframework.web.client.RestTemplate;


/**
 * Created by George on 29/05/17.
 */
public class Product {

    RestTemplate restTemplate;


    public Search_Freetext_APIJSON searchfreetext(Post_To_Search_Freetext post_To_Search_Freetext){
        final String url = "http://prelive.viatorapi.viator.com/service/search/freetext?apiKey=3491840412405367";
        restTemplate = new RestTemplate();
        Search_Freetext_APIJSON result = restTemplate.postForObject( url, post_To_Search_Freetext, Search_Freetext_APIJSON.class);

        return result;
    }
}
