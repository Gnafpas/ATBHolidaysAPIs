package Controller;

import APIBeans.Search_Freetext_APIJSON;
import APIBeans.Post_To_Search_Freetext;
import DAOs.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 29/05/17.
 */


@RestController
public class SearchController {


//    private final AtomicLong counter = new AtomicLong();
//
//
//
//    @RequestMapping("/greeting")
//    public Data_Incoming_JSON greeting(@RequestParam(value="name", defaultValue="World") String name) {
////		return new Greeting(counter.incrementAndGet(),name);

    @RequestMapping("/search")
    public Search_Freetext_APIJSON search() {
        List<String> searchTypes=new ArrayList<>();
        searchTypes.add("DESTINATION");
        Product product=new Product();
        Post_To_Search_Freetext post_To_Search_Freetext =new Post_To_Search_Freetext();
        post_To_Search_Freetext.setCurrencyCode("EUR");
        post_To_Search_Freetext.setDestId(684);
        post_To_Search_Freetext.setSearchTypes(searchTypes);
        post_To_Search_Freetext.setText("Athens");
        post_To_Search_Freetext.setTopX("1-15");
        return product.searchfreetext(post_To_Search_Freetext);

    }


}
