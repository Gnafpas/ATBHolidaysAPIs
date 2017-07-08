package Controller;

import DAOs.DBDAOs.ViatorProductDetailsDAO;
import DBBeans.ViatorProductDetailsBean;
import WebServicesBeans.PagingList.GetProductsControllerParams;
import org.springframework.web.bind.annotation.*;
import java.time.*;
import java.util.List;

/**
 * Created by George on 07/07/2017.
 */
@RestController
public class ListingPageController {


    /**
     * Retrieving products by code,title,country,city,region,destination id,primary destination id or
     * a combination of those attributes.Capability of filtering by categories and sort by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A, POPULARITY, PRICE_D, PRICE_a, DURATION_D, DURATION_A.Also filtering by dates.
     */
    @RequestMapping(value = "/getProducts", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public List<ViatorProductDetailsBean> getProducts(@RequestBody GetProductsControllerParams params){

        ViatorProductDetailsDAO productsDao=new ViatorProductDetailsDAO();
        ZonedDateTime startDate;//todo remove dates
        ZonedDateTime endDate;
        endDate=ZonedDateTime.of ( LocalDate.of ( 2017 , 7 , 20 ) , LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );
        startDate=ZonedDateTime.of (LocalDate.of ( 2017 , 7 , 8 ) , LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );

        return productsDao.getProducts(params.getCode(),params.getText(),params.getCountry(),params.getCity(),
                params.getRegion(),params.getDestId(),params.getPrimaryDestId(),params.getSortOrder(),
                params.getFirstProduct(),params.getLastProduct(),params.getCategories(),
                params.getSubcategories(),startDate,endDate);
    }

}
