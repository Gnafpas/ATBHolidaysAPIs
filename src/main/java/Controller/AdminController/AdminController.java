package Controller.AdminController;

import Beans.ATBDBBeans.KalitaonSystem.CityCodeBean;
import Beans.ATBDBBeans.KalitaonSystem.CountryCodeBean;
import Beans.ViatorDBBeans.ViatorDestinationsBean;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CityCodeDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CountryCodeDAO;
import DAOs.CarnectAPIDAOs.DestinationsDAOs.*;
import DAOs.CarnectAPIDAOs.DestinationsDAOs.Destination;
import DAOs.CarnectAPIDAOs.ServiceDAOs.*;
import DAOs.SunHotelsDAOs.*;
import DAOs.ViatorDBDAOs.ViatorDestinationsDAO;
import Updates.ATBDBUpdates.UpdateATBDBTimerTask;
import Updates.ATBDBUpdates.UpdateATBProducts;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.SubAgencyDAO;
import Updates.ViatorDBUpdates.*;
import Helper.APIKeyGeneration;
import Helper.ProjectProperties;
import Beans.ViatorDBBeans.UpdateDBBeans.InfoJSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by George on 29/05/17.
 */
@RestController
public class AdminController {

    private Timer viatorTimer;
    private boolean viatortimerRuns = false;
    private Timer atbTimer;
    private boolean atbTimerRuns = false;

    /**
     * All functions return results about the update.If there were errors in communication with viator server or DB
     * How many products added/updated  to DB,which products failed  due to communication with
     * viator or communication with DB.When update started and when lasted.Also returns
     * the destinations of the products that failed to run the update again for that specific destinations.
     * @RequestParam StartingDestId :From which destination to start the update.
     * @RequestParam StopDestId :At which destination to last the update.
     * All destinations are stored in DB with a sort order.
     * All destinations are stored in DB with a sort order.
     * If StartingDestId=0 and  StopDestId=0 the update runs for all destinations.
     * Updates categories and destinations also.
     */
    @RequestMapping("/startViatorDBUpdate")
    public String startViatorDBUpdate(@RequestParam(value="StartingDestId", defaultValue="0") Integer StartingDestId,
                                      @RequestParam(value="StopDestId", defaultValue="0") Integer StopDestId ,
                                      @RequestParam(value="firstProductCode", defaultValue="") String firstProductCode,
                                      @RequestParam(value="lastProductCode", defaultValue="") String lastProductCode) {
        if(!viatortimerRuns) {
            /**
             * Update products with timer every X hours.
             */
            TimerTask timerTask = new UpdateViatorDBTimerTask(StartingDestId,StopDestId,firstProductCode,lastProductCode);
            viatorTimer = new Timer(true);
            viatorTimer.scheduleAtFixedRate(timerTask, 0, Helper.ProjectProperties.runDBUpdateEveryXMillisecs);
            viatortimerRuns=true;
            return "Update timer task started.Runs every "+ ProjectProperties.runDBUpdateEveryXMillisecs /60 /60 /1000+" hours." ;
        }
        else
            return "Update timer task runs already.";
    }

    @RequestMapping("/stopViatorDBUpdate")
    public String stopViatorDBUpdate(){
        if(viatortimerRuns) {
            viatorTimer.cancel();
            viatorTimer.purge();
            viatortimerRuns = false;
            return "Update timer task  stopped. ";
        }else
            return "Update timer task isn't running. ";
    }

    @RequestMapping("/isViatorDBUpdateTimertaskEnabled")
    public String isViatorDBUpdateTimertaskEnabled(){
        if(viatortimerRuns)
            return "True";
        else
            return "False";
    }

    @RequestMapping("/deleteCorruptedProducts")
    public String deleteCorruptedProducts(){
        Logger logger=Logger.getLogger("");
        if(DeleteCorruptedProducts.deleteCorruptedProducts(logger))
            return "There was an DB error while deleting corupted products.";
        else
            return "Corupted products deleted.";
    }

    @RequestMapping("/startATBDBUpdate")
    public String startATBDBUpdate(@RequestParam(value="firstProductCode", defaultValue="") String firstProductCode,
                                   @RequestParam(value="lastProductCode", defaultValue="") String lastProductCode) {
        if(!atbTimerRuns) {
            /**
             * Update products with timer every X hours.
             */
            TimerTask timerTask = new UpdateATBDBTimerTask(firstProductCode,lastProductCode);
            atbTimer = new Timer(true);
            atbTimer.scheduleAtFixedRate(timerTask, 0, Helper.ProjectProperties.runDBUpdateEveryXMillisecs);
            atbTimerRuns=true;
            return "Update timer task started.Runs every "+ ProjectProperties.runDBUpdateEveryXMillisecs /60 /60 /1000+" hours." ;
        }
        else
            return "Update timer task runs already.";
        //todo combine atb and viator update to run serialized
    }

    @RequestMapping("/stopATBDBUpdate")
    public String stopATBDBUpdate(){
        if(atbTimerRuns) {
            atbTimer.cancel();
            atbTimer.purge();
            atbTimerRuns = false;
            return "Update timer task  stopped. ";
        }else
            return "Update timer task isn't running. ";
    }

    @RequestMapping("/isATBDBUpdateTimertaskEnabled")
    public String isATBDBUpdateTimertaskEnabled(){
        if(atbTimerRuns)
            return "True";
        else
            return "False";
    }

    @RequestMapping("/updateCategories")
    public InfoJSON updateCategories() {
        return UpdateCategories.updateCategories();
    }

    @RequestMapping("/updateDestinations")
    public InfoJSON updateDestinations() {
        return UpdateDestinations.updateDestinations();
    }

    @RequestMapping("/updateAttractions")
    public InfoJSON updateAttractions(@RequestParam(value="StartingDestId", defaultValue="0") Integer StartingDestId,
                                      @RequestParam(value="StopDestId", defaultValue="0") Integer StopDestId) {
        return UpdateAttractions.UpdateAttractions(StartingDestId,StopDestId);
    }


    @RequestMapping("/newAPIClient")
    public String newAPIClient(@RequestParam(value="agentName", defaultValue="") String agentName) {
        String key = null;
        try {
            key = APIKeyGeneration.generate(128);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception caught");
            e.printStackTrace();
        }
        String saltedPassword = Helper.ProjectProperties.SALTForKeyGeneration + key;
        String hashedPassword = Helper.APIKeyGeneration.generateHash(saltedPassword);
        SubAgencyDAO.storeAgentAPIKey(agentName,hashedPassword);
        return key;
    }

    @RequestMapping("/carnectTest")
    public String carnectTest() {
//        Destination destination=new Destination();
//        destination.setHandlerResolver(new JaxWsHandlerResolver());
//        DestinationSoap destinationSoap = destination.getDestinationSoap();
//        VehicleCountryRequest vehicleCountryRequest=new VehicleCountryRequest();
//        vehicleCountryRequest.setLanguage("EN");
//        VehicleCountryResponse response =destinationSoap.getCountries(vehicleCountryRequest);



        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        XMLGregorianCalendar date2;
        try {
             date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

        NonStaticXMLAPI nonStaticXMLAPI=new NonStaticXMLAPI();
        NonStaticXMLAPISoap nonStaticXMLAPISoap=nonStaticXMLAPI.getNonStaticXMLAPISoap();
        PreBookV2 preBook=new PreBookV2();
        PreBookResult preBookResult=nonStaticXMLAPISoap.preBookV2 ("ATBHols","Shisane123","USD","eng",date2,date2,1,2,0,"",1,1,"US","","","7673130","137159","","","");
        GetLanguagesResult  getLanguagesResult=  nonStaticXMLAPISoap.getLanguages("ATBHols","Shisane123");

        System.out.println(getLanguagesResult.getLanguages().getLanguage().get(0).getName()+"  "+" "+preBookResult.getPreBookCode()+" "+preBookResult.getRoomId()+" "+preBookResult.getCancellationPolicies()+" "+preBookResult.getNotes());
        }catch(DatatypeConfigurationException e){}
//        Service service=new Service();
//        service.setHandlerResolver(new JaxWsHandlerResolver());
//        ServiceSoap serviceSoap=service.getServiceSoap();
//        VehAvailRateRQ vehAvailRateRQ=new VehAvailRateRQ();
//        VehicleAvailRQCoreType vehicleAvailRQCoreType=new VehicleAvailRQCoreType();
//        vehicleAvailRQCoreType.setRateQueryParameterType();
//
//        VehRateRuleRS.VehRentalCore vehRentalCore=new VehRateRuleRS.VehRentalCore();
//        VehicleRentalCoreType.ReturnLocation returnLocation=new VehicleRentalCoreType.ReturnLocation();
//        returnLocation.setLocationCode("51");
//        returnLocation.setCodeContext("1");
//        vehRentalCore.setReturnLocation(returnLocation);
//
//        vehicleAvailRQCoreType.setVehRentalCore(vehRentalCore);
//
//        ArrayOfSourceType arrayOfSourceType=new ArrayOfSourceType();
//        arrayOfSourceType.getSource();
//        vehAvailRateRQ.setPOS(arrayOfSourceType);
//        vehAvailRateRQ.setVehAvailRQCore(vehicleAvailCoreType);
//        VehAvailRateRS vehAvailRateRS=serviceSoap.getVehAvailRate(vehAvailRateRQ);

return "ok";
     //   return response.getCountries().getCountry().get(0).getName();
    }

    @RequestMapping("/updatecitycodes")
    public String updatecitycodes() {
        List<ViatorDestinationsBean> viatorDestinations=ViatorDestinationsDAO.getAllDestinations();
        List<CityCodeBean> citiesCode=CityCodeDAO.getCities();
        for(ViatorDestinationsBean viatorDestination:viatorDestinations){
            if(viatorDestination.getDestinationType().equals("CITY")){
                for(CityCodeBean cityCode:citiesCode){
                    String split[]=cityCode.getAlternateNamesCsv().split(",");
                    if(cityCode.getOriginalName().equalsIgnoreCase(viatorDestination.getDestinationNameEn()) || cityCode.getSanitizedName().equalsIgnoreCase(viatorDestination.getDestinationNameEn()) || cityCode.getAlternateNamesCsv().toLowerCase().contains(","+viatorDestination.getDestinationNameEn().toLowerCase()+",") || (split.length>0 && split[0].equalsIgnoreCase(viatorDestination.getDestinationNameEn()))){
                        System.out.println("alt:   "+ cityCode.getAlternateNamesCsv().toLowerCase() + "  name: " + viatorDestination.getDestinationNameEn().toLowerCase() );
                        ViatorDestinationsBean country=new ViatorDestinationsBean();
                        country.setParentId(viatorDestination.getParentId());
                        for(int i=0;i<5;i++) {
                            country=ViatorDestinationsDAO.getDestinationsByDestinationId(country.getParentId());
                            if(country.getDestinationType().equals("COUNTRY"))
                                break;
                        }
                       // System.out.println("name:   "+ country.getDestinationNameEn() + "  code: " + cityCode.getCountryCodeIso() );
                        if(cityCode.getCountryCodeIso()!=null && !cityCode.getCountryCodeIso().equals("") ){

                            CountryCodeBean countryCod = CountryCodeDAO.getCountryByCodeIso(cityCode.getCountryCodeIso());
                            if(country.getDestinationNameEn().equals("USA"))
                                country.setDestinationNameEn("United States");
                            if(country.getDestinationNameEn().equals("US Virgin Islands"))
                                country.setDestinationNameEn("U.S. Virgin Islands");
                            if(country.getDestinationNameEn().equals("England"))
                                country.setDestinationNameEn("United Kingdom");
                            if(country.getDestinationNameEn().equals("St Maarten"))
                                country.setDestinationNameEn("Sint Maarten");
                            if(country.getDestinationNameEn().equals("Wales"))
                                country.setDestinationNameEn("United Kingdom");
                            if(countryCod!=null && countryCod.getCountryName().equalsIgnoreCase(country.getDestinationNameEn())){


                                if(cityCode.getLatitude()!=null &&  cityCode.getLongitude()!=null &&  viatorDestination.getLongitude()!=null && viatorDestination.getLatitude()!=null) {
                                    String vilongt = viatorDestination.getLongitude().toString();
                                    String vilat = viatorDestination.getLatitude().toString();
                                    String atlat =cityCode.getLatitude();
                                    String atlongt=cityCode.getLongitude();

                                    atlat=atlat.replace(".", "");
                                    atlongt=atlongt.replace(".", "");
                                    atlat=atlat.replace("-", "");
                                    atlongt=atlongt.replace("-", "");

                                    vilat=vilat.replace(".", "");
                                    vilat=vilat.replace("-", "");
                                    vilongt=vilongt.replace(".", "");
                                    vilongt=vilongt.replace("-", "");

                                    if(vilat.length()>1 && vilongt.length()>1 && atlat.length()>1 && atlongt.length()>1 ) {
                                        vilat = vilat.substring(0, 2);
                                        vilongt = vilongt.substring(0, 2);
                                        atlat = atlat.substring(0, 2);
                                        atlongt = atlongt.substring(0, 2);
                                        System.out.println("Viator lat:" + viatorDestination.getLatitude() + " , " + vilat + " Viator long:" + viatorDestination.getLongitude() + " , " + vilongt + " Atb lat:" + cityCode.getLatitude() + " , " + atlat + " Atb long:" + cityCode.getLongitude() + " , " + atlongt);
                                        if (cityCode.getViatorid() == 0) {
                                            if (vilat.equals(atlat) && vilongt.equals(atlongt)) {
                                                cityCode.setViatorid(viatorDestination.getDestinationId());
                                                CityCodeDAO.updatecity(cityCode);
                                            }
                                        }
                                    }else{
                                        if (cityCode.getViatorid() == 0) {
                                            cityCode.setViatorid(viatorDestination.getDestinationId());
                                            CityCodeDAO.updatecity(cityCode);
                                        }
                                    }
                                }else {
                                    if (cityCode.getViatorid() == 0) {
                                            cityCode.setViatorid(viatorDestination.getDestinationId());
                                            CityCodeDAO.updatecity(cityCode);
                                    }
                                }
                            }
                        }


                    }
                }
            }

        }
        return "Ok";
    }

    @RequestMapping("/blankid")
    public String blankid() {
        List<CityCodeBean> cities;
        List<ViatorDestinationsBean> viatorDestinations=ViatorDestinationsDAO.getAllDestinations();
        int nomatchcounter=0;
        int doublicationscounter=0;
        int counter=0;
        for(ViatorDestinationsBean viatorDestination:viatorDestinations){
            if(viatorDestination.getDestinationType().equals("CITY")){
                cities=CityCodeDAO.getCityByDetintationId(viatorDestination.getDestinationId());
                ViatorDestinationsBean country=new ViatorDestinationsBean();
                country.setParentId(viatorDestination.getParentId());
                for(int i=0;i<5;i++) {
                    country=ViatorDestinationsDAO.getDestinationsByDestinationId(country.getParentId());
                    if(country.getDestinationType().equals("COUNTRY"))
                        break;
                }
                if(cities==null)
                    System.out.println(" Via Name: "+viatorDestination.getDestinationNameEn()+ " id: "+viatorDestination.getDestinationId() +" Country: "+ country.getDestinationNameEn()+" iata code: " + viatorDestination.getIataCode());
                if(cities!=null && cities.size()!=1 )
                    System.out.println(" Via Name: "+viatorDestination.getDestinationNameEn()+ " id: "+viatorDestination.getDestinationId() +" Country: "+ country.getDestinationNameEn()+" iata code: " + viatorDestination.getIataCode());
                if(cities.size()>1){
                    doublicationscounter++;
                }
                if(cities!=null && cities.size()>1){
                   for(CityCodeBean city:cities) {
                       CountryCodeBean countryCod = CountryCodeDAO.getCountryByCodeIso(city.getCountryCodeIso());
                       System.out.println(" ATB Name: " + city.getOriginalName() + " id: " + city.getViatorid() + " Country: " + countryCod.getCountryName()+ " geoid: " + city.getGeonameid() + " , Alternatives: " + city.getAlternateNamesCsv());
                   }
                    System.out.println(counter);
                    System.out.println("");
                    counter++;
                }

                if(cities!=null && cities.size()==0){
                    System.out.println(" no match");
                    nomatchcounter++;
                    System.out.println(counter);
                    System.out.println("");
                    counter++;
                }
                if(cities==null){
                    System.out.println(" no match");
                    nomatchcounter++;
                    System.out.println(counter);
                    System.out.println("");
                    counter++;
                }


            }


        }

        return "nomatchcounter:"+nomatchcounter+"  doublicationscounter:"+doublicationscounter;
    }


    @RequestMapping("/temp")
    public String temp() {
        String a="bla";
        System.out.println(a);
        a=a.replace(".","");
        a=a.replace("-","");
        a=a.substring(0,3);
        System.out.println(a);

        return "ok";
    }

}

