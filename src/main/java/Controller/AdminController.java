package Controller;

import DB_Updates.UpdateCategories;
import DB_Updates.UpdateDestinations;
import DB_Updates.UpdateProducts;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by George on 29/05/17.
 */
@RestController
public class AdminController {

    @RequestMapping("/updateProducts")
    public void updateProducts() {
        UpdateProducts updateProducts =new UpdateProducts();
        updateProducts.updateProducts();
    }

    @RequestMapping("/updateCategories")
    public void updateCategories() {
        UpdateCategories updateCategories=new UpdateCategories();
        updateCategories.updateCategories();
    }

    @RequestMapping("/updateDestinations")
    public void updateDestinations() {
        UpdateDestinations updateDestinations=new UpdateDestinations();
        updateDestinations.updateDestinations();
    }
}
