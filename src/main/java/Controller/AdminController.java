package Controller;

import DAOs.DBDAOs.ViatorProductDetailsDAO;
import DBBeans.ViatorProductDetailsBean;
import DBUpdates.UpdateCategories;
import DBUpdates.UpdateDestinations;
import DBUpdates.UpdateProducts;
import WebServicesBeans.UpdateDBJSONs.InfoJSON;
import WebServicesBeans.UpdateDBJSONs.UpdateProductsInfoJSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by George on 29/05/17.
 */
@RestController
public class AdminController {

    /**
     *All functions return results about the update.If there were errors in communication with viator server or DB
     * How many products added/updated  to DB,which products failed  due to communication with
     * viator or communication with DB.When update started and when lasted.Also returns
     * the destinations of the products that failed to run the update again for that specific destinations.
     * @RequestParam StartingDestId :From which destination to start the update.
     * @RequestParam StopDestId :At which destination to last the update.
     * All destinations are stored in DB with a sort order.
     * If StartingDestId=0 and  StopDestId=0 the update runs for all destinations.
     */
    @RequestMapping("/updateProducts")
    public UpdateProductsInfoJSON updateProducts(@RequestParam(value="StartingDestId", defaultValue="0") Integer StartingDestId,
                                                 @RequestParam(value="StopDestId", defaultValue="0") Integer StopDestId) {
        UpdateProducts updateProducts =new UpdateProducts();
        return updateProducts.updateProducts(StartingDestId,StopDestId);
    }

    @RequestMapping("/updateCategories")
    public InfoJSON updateCategories() {
        UpdateCategories updateCategories=new UpdateCategories();
        return updateCategories.updateCategories();
    }

    @RequestMapping("/updateDestinations")
    public InfoJSON updateDestinations() {
        UpdateDestinations updateDestinations=new UpdateDestinations();
        return updateDestinations.updateDestinations();
    }

}
