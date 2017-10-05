package Controller.MyViatorAPIController;

import Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix.AvailabilityAndPricingMatrixAPIJSON;
import Beans.ViatorAPIBeans.Bookings.Book.*;
import Beans.ViatorAPIBeans.Bookings.CalculatePrice.CalculatePriceAPIJSON;
import Beans.ViatorAPIBeans.Bookings.CalculatePrice.CalculatePricePOST;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelAPIJSON;
import Beans.ViatorAPIBeans.Bookings.Cancel.CancelPOST;
import Beans.ViatorAPIBeans.Bookings.PastBooking.PastBookingAPIJSON;
import DAOs.ViatorAPIDAOs.BookingsAPIDAO;
import org.springframework.web.bind.annotation.*;

/**
 * Created by George on 02/08/2017.
 */
@RestController
public class BookingsController {

    @RequestMapping(value ="/book", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public BookAPIJSON book(@RequestBody  BookPOST params){

        return BookingsAPIDAO.book(params);
    }

    @RequestMapping(value ="/calculateprice", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public CalculatePriceAPIJSON book(@RequestBody CalculatePricePOST params){
        return BookingsAPIDAO.calculateprice(params);
    }

    @RequestMapping(value ="/cancelBooking", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public CancelAPIJSON cancelBooking(@RequestBody CancelPOST params){

        return BookingsAPIDAO.cancellation(params);
    }

    @RequestMapping("/getAvailabityDatesAndPricematrix")
    public AvailabilityAndPricingMatrixAPIJSON getAvailabityDatesAndPricematrix(@RequestParam (value="productCode", defaultValue="") String productCode,
                                                                                @RequestParam (value="month", defaultValue="") String month,
                                                                                @RequestParam (value="year", defaultValue="") String year){
        AvailabilityAndPricingMatrixAPIJSON availabilityAndPricingMatrixAPIJSON=BookingsAPIDAO.productAvailabilityAndPricingMatrix(productCode,month,year);
        return availabilityAndPricingMatrixAPIJSON;
    }

    @RequestMapping("/pastBooking")
    public PastBookingAPIJSON pastBooking(@RequestParam (value="email", defaultValue="") String email,
                                         @RequestParam (value="itineraryId", defaultValue="") int itineraryId){
        PastBookingAPIJSON pastBookingAPIJSON=BookingsAPIDAO.pastbooking(email,itineraryId);
        return pastBookingAPIJSON;
    }
}
