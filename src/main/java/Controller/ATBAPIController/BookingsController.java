package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.Availability;
import APIJSONs.ATBAPIJSONs.AvailabilityJSON;
import APIJSONs.ATBAPIJSONs.Pricingmatrix;
import APIJSONs.ATBAPIJSONs.PricingmatrixJSON;
import Beans.ATBDBBeans.KalitaonProduct.*;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by George on 23/10/2017.
 */
@RestController
public class BookingsController {

    @RequestMapping("/booking/availability")
    public AvailabilityJSON availability(@RequestParam(value = "productId", defaultValue = "") String productId,
                                         @RequestParam(value = "planId", defaultValue = "") String planId) {

        AvailabilityJSON availabilityJSON = new AvailabilityJSON();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        availabilityJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");

        List<HAvailableDateBean> availableDates=HAvailableDateDAO.gethAvailableDatesByProductId(productId,planId);
        List<HSpecialDateBean> specialDates=HSpecialDateDAO.getSpecialDatesByProductId(productId,planId);
        List<HStopsaleDateBean> stopsaleDates=HStopsaleDateDAO.gethStopsaleDatesByProductId(productId,planId);
        List<IAvailableTimeBean> availableTime=IAvailableTimeDAO.getiAvailableTimesByProductId(productId,planId);

        Availability availability;
        boolean planIdExists;
        if(availableDates!=null) {
            for(HAvailableDateBean ad:availableDates) {
                planIdExists=false;
                for(Availability a:availabilityJSON.getData()){
                    if(a.getPlanId().equals(ad.getPlanId())) {
                        a.getAvailableDates().add(ad);
                        planIdExists=true;
                        break;
                    }
                }
                if(!planIdExists) {
                    availability = new Availability();
                    availability.getAvailableDates().add(ad);
                    availability.setPlanId(ad.getPlanId());
                    availabilityJSON.getData().add(availability);
                }
            }
        }

        if(specialDates!=null) {
            for(HSpecialDateBean sd:specialDates) {
                planIdExists=false;
                for(Availability a:availabilityJSON.getData()){
                    if(a.getPlanId().equals(sd.getPlanId())) {
                        a.getSpecialDates().add(sd);
                        planIdExists=true;
                        break;
                    }
                }
                if(!planIdExists) {
                    availability = new Availability();
                    availability.getSpecialDates().add(sd);
                    availability.setPlanId(sd.getPlanId());
                    availabilityJSON.getData().add(availability);
                }
            }
        }

        if(stopsaleDates!=null) {
            for(HStopsaleDateBean sd:stopsaleDates) {
                planIdExists=false;
                for(Availability a:availabilityJSON.getData()){
                    if(a.getPlanId().equals(sd.getPlanId())) {
                        a.getStopsaleDates().add(sd);
                        planIdExists=true;
                        break;
                    }
                }
                if(!planIdExists) {
                    availability = new Availability();
                    availability.getStopsaleDates().add(sd);
                    availability.setPlanId(sd.getPlanId());
                    availabilityJSON.getData().add(availability);
                }
            }
        }

        if(availableTime!=null) {
            for(IAvailableTimeBean at:availableTime) {
                planIdExists=false;
                for(Availability a:availabilityJSON.getData()){
                    if(a.getPlanId().equals(at.getPlanId())) {
                        a.getAvailableTime().add(at);
                        planIdExists=true;
                        break;
                    }
                }
                if(!planIdExists) {
                    availability = new Availability();
                    availability.getAvailableTime().add(at);
                    availability.setPlanId(at.getPlanId());
                    availabilityJSON.getData().add(availability);
                }
            }
        }

        availabilityJSON.setTotalCount(availabilityJSON.getData().size());
        if (availableTime== null || stopsaleDates == null ||
            specialDates == null || availableDates == null ) {
              availabilityJSON.setSuccess(false);
              availabilityJSON.setErrorMessageText("Database Communication Error.");
        }

        return availabilityJSON;
    }

    @RequestMapping("/booking/pricingmatrix")
    public PricingmatrixJSON pricingmatrix(@RequestParam(value = "productId", defaultValue = "") String productId,
                                           @RequestParam(value = "planId", defaultValue = "") String planId) {

        PricingmatrixJSON pricingmatrixJSON = new PricingmatrixJSON();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        pricingmatrixJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");

        List<GPriceMatrixBean> priceMatrixes=GPriceMatrixDAO.getgPriceMatrixesByProductId(productId,planId);
        boolean planIdExists;
        Pricingmatrix pricingmatrix;
        if(priceMatrixes!=null) {
            for(GPriceMatrixBean pm:priceMatrixes) {
                planIdExists=false;
                for(Pricingmatrix p:pricingmatrixJSON.getData()){
                    if(p.getPlanId().equals(pm.getPlanId())) {
                        p.getPriceMatrix().add(pm);
                        planIdExists=true;
                        break;
                    }
                }
                if(!planIdExists) {
                    pricingmatrix = new Pricingmatrix();
                    pricingmatrix.getPriceMatrix().add(pm);
                    pricingmatrix.setPlanId(pm.getPlanId());
                    pricingmatrixJSON.getData().add(pricingmatrix);
                }
            }
        }
        pricingmatrixJSON.setTotalCount(pricingmatrixJSON.getData().size());
        if (priceMatrixes== null ) {
            pricingmatrixJSON.setSuccess(false);
            pricingmatrixJSON.setErrorMessageText("Database Communication Error.");
        }
        return pricingmatrixJSON;
    }

}
