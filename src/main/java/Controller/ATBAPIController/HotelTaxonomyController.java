package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.Hotel.Destination;
import APIJSONs.ATBAPIJSONs.Hotel.DestinationJSON;
import Beans.ATBDBBeans.KalitaonHotel.DestinationBean;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.DestinationDAO;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 09/12/2017.
 */
@RestController
public class HotelTaxonomyController {

    @RequestMapping("/hotel/taxonomy/destinations")
    public DestinationJSON getAllDestinations(){
        List<Destination> atbDestinations=new ArrayList<>();
        Destination atbDestination;
        List<DestinationBean> destinations;
        DestinationJSON destinationJSON=new DestinationJSON();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        destinationJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");
        destinations= DestinationDAO.getAllDestinations();
        if(destinations!=null) {
            for(DestinationBean destination:destinations){
                atbDestination=new Destination();
                atbDestination.setCountry(destination.getCountryName());
                atbDestination.setCountryCode(destination.getCountryCode());
                atbDestination.setDestinationId(destination.getId());
                atbDestination.setName(destination.getName());
                atbDestinations.add(atbDestination);
            }
            destinationJSON.setData(atbDestinations);
            destinationJSON.setTotalCount(destinations.size());
        }else{
            destinationJSON.setSuccess(false);
            destinationJSON.setErrorMessageText("Database Communication Error.");
        }
        return destinationJSON;
    }

}
