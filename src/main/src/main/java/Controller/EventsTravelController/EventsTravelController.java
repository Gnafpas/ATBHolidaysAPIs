package Controller.EventsTravelController;

import Beans.EventsTravelAPIBeans.EventsTravelCreateOrderResponse;
import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;

import DAOs.ATBDBDAOs.KalitaonProductDAOs.AProductTitleDAO;
import DAOs.EventsTravelAPIDAO.EventsTravelProductsAPIDAO;
import Beans.EventsTravelAPIBeans.EventsTravelCreateOrderRequest;
import Beans.EventsTravelAPIBeans.EventsTravelProductsRespone;
import Beans.EventsTravelAPIBeans.OrderProduct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsTravelController {

    private static final Logger logger = Logger.getLogger(EventsTravelController.class);
    private InitialContext initialContext;
    private String eventsTravelAPIkey;
    private static String apiKeyJNDI = "java:comp/env/string/EventsTravelAPIkey";
    public static final String EVENTS_TRAVEL = "EVENTS TRAVEL";
    public static final String PHOTO_PATH ="http://www.eventstravel.eu/uploads/images/";

    @RequestMapping(value = "/eventsTravel/getProducts", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public EventsTravelProductsRespone getProducts(@RequestParam("token") String token,
                                                   @RequestParam(value = "outputType", required = false) String outputType,
                                                   @RequestParam(value = "language", required = false) String language,
                                                   @RequestParam(value = "test", required = false) String test,
                                                   @RequestParam(value = "event", required = false) String event,
                                                   @RequestParam(value = "eventId", required = false) String eventId,
                                                   @RequestParam(value = "dateFrom", required = false) String dateFrom,
                                                   @RequestParam(value = "dateUntil", required = false) String dateUntil,
                                                   @RequestParam(value = "category", required = false) String category,
                                                   @RequestParam(value = "sub_category", required = false) String subCategory,
                                                   @RequestParam(value = "location", required = false) String location,
                                                   @RequestParam(value = "city", required = false) String city) {

        logger.debug("/eventsTravel/getProducts" + "token: " + token + "outputType: " + outputType + "language: "
                + language + "test: " + test + "event: " + event + "eventId: " + eventId + "dateFrom: " + dateFrom
                + "dateUntil: " + dateUntil + "category: " + category + "sub_category: " + subCategory + "location: "
                + location + "city: " + city);

        EventsTravelProductsRespone response;
        StringBuilder request= new StringBuilder("?");
        try {
            initialContext = new InitialContext();
            eventsTravelAPIkey = (String) initialContext.lookup(apiKeyJNDI);
        } catch (NamingException e) {
            logger.info("API key retrieval failed" + e.getMessage());
            e.printStackTrace();
        }
        logger.debug("API key " + eventsTravelAPIkey);
        /* Build Request */
        if (token != null && !"".equals(token))
            request.append("token="+token);
        if (outputType != null && !"".equals(outputType))
            request.append("&outputType="+outputType);
        if (language != null && !"".equals(language))
            request.append("&language="+language);
        if (test != null && !"".equals(test))
            request.append("&test="+test);
        if (event != null && !"".equals(event))
            request.append("&event="+event);
        if (eventId != null && !"".equals(eventId))
            request.append("&eventId="+eventId);
        if (dateFrom != null && !"".equals(dateFrom))
            request.append("&dateFrom="+dateFrom);
        if (dateUntil != null && !"".equals(dateUntil))
            request.append("&dateUntil="+dateUntil);
        if (outputType != null && !"".equals(outputType))
            request.append("&outputType="+outputType);
        if (category != null && !"".equals(category))
            request.append("&category="+category);
        if (subCategory != null && !"".equals(subCategory))
            request.append("&sub_category="+subCategory);
        if (location != null && !"".equals(location))
            request.append("&location="+location);
        if (city != null && !"".equals(city))
            request.append("&city="+city);

        /* Callout */
        response = EventsTravelProductsAPIDAO.getProducts(request.toString());
        return response;
    }

//    @RequestMapping(value = "/eventsTravel/orders/create", method = RequestMethod.POST, consumes = "application/json")
//    @ResponseBody
//    public void createOrder(@RequestParam(value = "test", required = false) String test,
//                            @RequestBody EventsTravelCreateOrderRequest body) {
//        //Request Data Validation
//        EventsTravelBookPOST[] products;
//        AProductTitleBean atbProductTitle;
//        EventsTravelCreateOrderResponse response = null;
//        StringBuilder request= new StringBuilder("?");
//        try {
//            initialContext = new InitialContext();
//            eventsTravelAPIkey = (String) initialContext.lookup(apiKeyJNDI);
//        } catch (NamingException e) {
//            logger.info("API key retrieval failed" + e.getMessage());
//            e.printStackTrace();
//        }
//        logger.debug("API key " + eventsTravelAPIkey);
//        /* Build Request */
//        if (eventsTravelAPIkey != null && !"".equals(eventsTravelAPIkey))
//            request.append("token="+eventsTravelAPIkey);
//        if (test != null && !"".equals(test))
//            request.append("test="+test);
//
//
//        if (body.getProducts() == null || body.getProducts().length == 0)
//            logger.info("No products given");
//        else {
//            products = body.getProducts();
//            for (EventsTravelBookPOST product : products){
//                if ((product.getAmount()== 0)||(product.getSku() == null || "".equals(product.getSku())))
//                    logger.info("Amount and Sku are mandatory");
//                atbProductTitle = AProductTitleDAO.getProductById(product.getSku());
//                product.setSku(String.valueOf(atbProductTitle.getProductCode()));
//                if (product.getAmount() > Double.parseDouble(atbProductTitle.getStock()))
//                    logger.info("Available stock is: "+atbProductTitle.getStock());
//
//            }
//            response = EventsTravelProductsAPIDAO.createOrder(request.toString(), body);
//        }
//        logger.info(body.toString() +"\n"+ response.toString());
//
//    }

}
