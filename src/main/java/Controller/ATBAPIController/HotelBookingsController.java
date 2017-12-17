package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.Hotel.PrebookJSON;
import APIJSONs.ATBAPIJSONs.Hotel.PrebookPOST;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.RoomDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.RoomtypeDAO;
import DAOs.SunHotelsAPIDAOs.NonStaticXMLAPI;
import DAOs.SunHotelsAPIDAOs.NonStaticXMLAPISoap;
import DAOs.SunHotelsAPIDAOs.PreBookResult;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

import static Helper.ProjectProperties.sunhotelsUsername;
import static Helper.ProjectProperties.sunhotelspass;

/**
 * Created by George on 03/12/2017.
 */
@RestController
public class HotelBookingsController {

    @RequestMapping(value = "/hotelBookingsController/Prebook", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public PrebookJSON hotelPrebook(@RequestBody PrebookPOST params){

        ZonedDateTime checkin=null;
        ZonedDateTime checkout=null;
        PreBookResult result=null;
        PrebookJSON  prebookJSON=new PrebookJSON();
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

        String childrenAges="";
        if(params.getChildrenAges()!=null && params.getChildrenAges().size()>0) {
            childrenAges=""+params.getChildrenAges().get(0);
            for (int childrenage : params.getChildrenAges())
                childrenAges = childrenAges + "," + childrenage;
        }


        int originalRoomTypeId;
        if(params.getRoomtypeId()==null){
            prebookJSON.setSuccess(false);
            prebookJSON.setErrorMessageText("Wrong roomtypeId");
            return prebookJSON;
        }else{
            originalRoomTypeId=RoomtypeDAO.getOriginalRoomtypeId(params.getRoomtypeId());
            if(originalRoomTypeId==0){
                prebookJSON.setSuccess(false);
                prebookJSON.setErrorMessageText("Wrong roomtypeId");
                return prebookJSON;
            }
        }



        try {
            GregorianCalendar gregorianCheckin = GregorianCalendar.from(checkin);
            GregorianCalendar gregorianCheckout = GregorianCalendar.from(checkout);

            XMLGregorianCalendar xmlCheckin = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckin);
            XMLGregorianCalendar xmlCheckout = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCheckout);
            NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
            NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();
            result=nonStaticXMLAPISoap.preBookV2(sunhotelsUsername,sunhotelspass,params.getCurrency(),"English",
                    xmlCheckin,xmlCheckout,params.getRooms(),params.getAdults(),params.getChildren(),
                    childrenAges,params.getInfant(),params.getMealId(),params.getCustomerCountry(),"",
                    params.getSearchPrice(),params.getRoomId(),"","",params.getBlockSuperDeal(),
                    params.getShowPriceBreakdown());
        }catch(DatatypeConfigurationException e){}catch(NullPointerException e){}

        if(result.getError()!=null) {
            prebookJSON.setErrorMessageText(result.getError().getMessage());
            prebookJSON.setSuccess(false);
        }
        else{
            prebookJSON.setCancelationPolicies(result.getCancellationPolicies());
            prebookJSON.setNotes(result.getNotes());
            prebookJSON.setPrice(result.getPrice());
            prebookJSON.setPriceBreakDown(result.getPriceBreakdown());
            prebookJSON.setRoomId(result.getRoomId());
            prebookJSON.setSuccess(true);
        }

        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        prebookJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");
        return prebookJSON;

    }

}
