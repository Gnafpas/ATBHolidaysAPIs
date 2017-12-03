package Controller.ATBAPIController;

import APIJSONs.FrontEndHelpAPIJSONs.SunHotelsPrebookPost;
import APIJSONs.FrontEndHelpAPIJSONs.SunHotelsPriceAvailabilityPost;
import DAOs.SunHotelsAPIDAOs.NonStaticXMLAPI;
import DAOs.SunHotelsAPIDAOs.NonStaticXMLAPISoap;
import DAOs.SunHotelsAPIDAOs.PreBookResult;
import DAOs.SunHotelsAPIDAOs.SearchResult;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

/**
 * Created by George on 03/12/2017.
 */
@RestController
public class FrontEndHelpController {

    @RequestMapping(value = "/frontEndHelpController/sunHotelsPrebook", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public PreBookResult hotelPrebook(@RequestBody SunHotelsPrebookPost params){

        ZonedDateTime checkin=null;
        ZonedDateTime checkout=null;
        PreBookResult result=null;
        if(!params.getCheckInDate().equals("") && !params.getCheckOutDate().equals("")) {
            String checkIndate[]=params.getCheckInDate().split("-");
            String checkOutdate[]=params.getCheckOutDate().split("-");
            if(checkIndate.length==3 && checkOutdate.length==3) {
                try {
                    checkin = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkIndate[0]), Integer.parseInt(checkIndate[1]), Integer.parseInt(checkIndate[2])),
                            LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                    checkout = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkOutdate[0]), Integer.parseInt(checkOutdate[1]), Integer.parseInt(checkOutdate[2])),
                            LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                }catch(NumberFormatException e){}
            }

        }

        try {
            GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
            GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);

            XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
            XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
            NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
            NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();
            result=nonStaticXMLAPISoap.preBookV2(params.getUserName(),params.getPassword(),params.getCurrency(),params.getLanguage(),
                    xmlCheckin,xmlCheckout,params.getRooms(),params.getAdults(),params.getChildren(),
                    params.getChildrenAges(),params.getInfant(),params.getMealId(),params.getCustomerCountry(),params.getB2C(),
                    params.getSearchPrice(),params.getRoomId(),params.getHotelId(),params.getRoomtypeId(),params.getBlockSuperDeal(),
                    params.getShowPriceBreakdown());
        }catch(DatatypeConfigurationException e){}



        return result;

    }

    @RequestMapping(value = "/frontEndHelpController/sunHotelsPriceAvailabilitySearch", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public SearchResult sunhotelsPriceAvailabilitySearch(@RequestBody SunHotelsPriceAvailabilityPost params){
        ZonedDateTime checkin=null;
        ZonedDateTime checkout=null;
        SearchResult result=null;
        if(!params.getCheckInDate().equals("") && !params.getCheckOutDate().equals("")) {
            String checkIndate[]=params.getCheckInDate().split("-");
            String checkOutdate[]=params.getCheckOutDate().split("-");
            if(checkIndate.length==3 && checkOutdate.length==3) {
                try {
                    checkin = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkIndate[0]), Integer.parseInt(checkIndate[1]), Integer.parseInt(checkIndate[2])),
                            LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                    checkout = ZonedDateTime.of(LocalDate.of(Integer.parseInt(checkOutdate[0]), Integer.parseInt(checkOutdate[1]), Integer.parseInt(checkOutdate[2])),
                            LocalTime.of(9, 30), ZoneId.of("America/New_York"));
                }catch(NumberFormatException e){}
            }

        }

        try {
            GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
            GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);

            XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
            XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
            NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
            NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();
            result=nonStaticXMLAPISoap.searchV2(params.getUserName(),params.getPassword(),params.getLanguage(),params.getCurrencies(),
                    xmlCheckin,xmlCheckout, params.getNumberOfRooms(),params.getDestination(),params.getDestinationID(),
                    params.getHotelIDs(),params.getResortIDs(),params.getAccommodationTypes(),params.getNumberOfAdults(),
                    params.getNumberOfChildren(), params.getChildrenAges(),params.getInfant(),params.getSortBy(),params.getSortOrder(),
                    params.getExactDestinationMatch(), params.getBlockSuperdeal(),params.getMealIds(),params.getShowCoordinates(),
                    params.getShowReviews(),params.getReferencePointLatitude(),params.getReferencePointLongitude(), params.getMaxDistanceFromReferencePoint(),
                    params.getMinStarRating(),params.getMaxStarRating(),params.getFeatureIds(),params.getMinPrice(),params.getMaxPrice(),params.getThemeIds(),
                    params.getExcludeSharedRooms(),params.getExcludeSharedFacilities(),params.getPrioritizedHotelIds(),params.getTotalRoomsInBatch(),
                    params.getPaymentMethodId(), params.getCustomerCountry(),params.getB2c());
        }catch(DatatypeConfigurationException e){}



        return result;

    }


}
