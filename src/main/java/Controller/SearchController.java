package Controller;

import APIBeans.Post_To_Search_Freetext;
import APIBeans.Product_Search_Freetext_APIJSON;
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
    public Product_Search_Freetext_APIJSON search() {
        List<String> searchTypes=new ArrayList<>();

        searchTypes.add("PRODUCT");
        Product product=new Product();
        Post_To_Search_Freetext post_To_Search_Freetext =new Post_To_Search_Freetext();
        post_To_Search_Freetext.setCurrencyCode("EUR");
        post_To_Search_Freetext.setDestId(684);
        post_To_Search_Freetext.setSearchTypes(searchTypes);
        post_To_Search_Freetext.setText("New York");
        post_To_Search_Freetext.setTopX("1-50");
        return product.product_searchfreetext(post_To_Search_Freetext);

    }


}
