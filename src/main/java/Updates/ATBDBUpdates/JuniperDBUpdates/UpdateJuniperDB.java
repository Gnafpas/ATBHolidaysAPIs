package Updates.ATBDBUpdates.JuniperDBUpdates;

import Beans.ATBDBBeans.KalitaonHotel.DestinationBean;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.DestinationDAO;
import DAOs.JuniperAPIDAOs.*;

import javax.jws.WebService;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;
import java.util.*;

import static Helper.ProjectProperties.hotelBedsProviderId;


/**
 * Created by George on 15/06/2018.
 */
public class UpdateJuniperDB {

    public List<String> test() {

        WebServiceJP WebServiceJP = new WebServiceJP();
        Map<String, List<String>> httpHeaders = new HashMap<String, List<String>>();
        httpHeaders.put("Accept-Encoding", Collections.singletonList("gzip, deflate"));
        StaticDataTransactions staticDataTransactions = WebServiceJP.getStaticDataTransactions();
        ((BindingProvider)staticDataTransactions).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS,httpHeaders);
        JPZoneListRQ jPZoneListRQ=new JPZoneListRQ();
        jPZoneListRQ.setLanguage("en");
        JPLogin jpLogin=new JPLogin();
        jpLogin.setEmail("XmlAtbHolidays");
        jpLogin.setPassword("eDBU2w7K");
        jPZoneListRQ.setLogin(jpLogin);
        jPZoneListRQ.setVersion("1.1");
        JPZoneListRequest jPZoneListRequest=new JPZoneListRequest();
        jPZoneListRequest.setProductType(JPProductType.HOT);
        jPZoneListRQ.setZoneListRequest(jPZoneListRequest);
        JPStaticDataRS jpStaticDataRS=staticDataTransactions.zoneList(jPZoneListRQ);

        List<String> bla=new ArrayList<>();
        if(jpStaticDataRS!=null) {
            if(jpStaticDataRS.getErrors()!=null) {

                for (JPErrorType err : jpStaticDataRS.getErrors().getError()) {
                    bla.add( err.getText());
                }
            }
            if(jpStaticDataRS.getZoneList()!=null) {

                //totalresults = destinationsAPIJSON.getTotal();
                for (JPZone zone : jpStaticDataRS.getZoneList().getZone()) {

//                            destExists = false;
//                            if (allDestinationBeans != null) {
//                                for (DestinationBean destBean : allDestinationBeans) {
//                                    if (destBean.getHotelBedsCode() != null && destBean.getHotelBedsCode().equals(dest.getCode())) {
//                                        destExists = true;
//                                        break;
//                                    }
//                                    if (!destExists) {
//                                        String[] dbDestName = null;
//                                        String[] hotelBedsDestName = null;
//                                        if (destBean.getName() != null)
//                                            dbDestName = destBean.getName().split("( )|(\\()|(\\))|(-)");
//                                        if (dest.getName() != null && dest.getName().getContent() != null)
//                                            hotelBedsDestName = dest.getName().getContent().split("( )|(\\()|(\\))|(-)");
//
//                                        boolean wordExists = false;
//                                        if (dbDestName != null && hotelBedsDestName != null) {
//                                            for (int k = 0; k < dbDestName.length; k++) {
//                                                if (dbDestName.equals(""))
//                                                    continue;
//                                                wordExists = false;
//                                                for (int j = 0; j < hotelBedsDestName.length; j++) {
//
//                                                    if (dbDestName[k].equals(hotelBedsDestName[j]))
//                                                        wordExists = true;
//                                                }
//                                                if (!wordExists)
//                                                    break;
//                                            }
//                                            if (wordExists && destBean.getCountryCode().equals(dest.getIsoCode())) {
//                                                destBean.setHotelBedsCode(dest.getCode());
//                                                if (DestinationDAO.updateDestinationBean(destBean))
//                                                    atbDBErrCommCounter++;
//                                                else
//                                                    entityCounter++;
//                                                destExists = true;
//                                                break;
//                                            }
//                                        } else {
//                                            destExists = true;
//                                            break;
//                                        }
//                                    }
//                                }
//                                if (!destExists) {
//                                    destinationBean = new DestinationBean();
//                                    destinationBean.setDestinationId(0);
//                                    destinationBean.setCountryName(dest.getCountryCode());
//                                    destinationBean.setName(dest.getName().getContent());
//                                    destinationBean.setProviderId(hotelBedsProviderId);
//                                    destinationBean.setProviderRef(0);
//                                    destinationBean.setTimezone("");
//                                    destinationBean.setCountryCode(dest.getCountryCode());
//                                    destinationBean.setHotelBedsCode(dest.getCode());
//                                    if (DestinationDAO.addDestinationBean(destinationBean))
//                                        atbDBErrCommCounter++;
//                                    else
//                                        entityCounter++;
//                                }
//                            }



//                    if(zone.isSearchable()) {
//                        JPHotelListRQ jpHotelListRQ=new JPHotelListRQ();
//                        jpHotelListRQ.setLanguage("en");
//                        jpHotelListRQ.setLogin(jpLogin);
//                        jpHotelListRQ.setVersion("1.1");
//                        JPHotelListRequest jpHotelListRequest=new JPHotelListRequest();
//                        jpHotelListRequest.setZoneCode(zone.getCode());
//                        jpHotelListRequest.setShowBasicInfo(true);
//                        jpHotelListRQ.setHotelListRequest(jpHotelListRequest);
//                        JPStaticDataRS hotelList =staticDataTransactions.hotelList(jpHotelListRQ);
//                        if(hotelList!=null) {
//                            if (hotelList.getErrors() != null) {
//
//                                for (JPErrorType err : hotelList.getErrors().getError()) {
//                                    bla.add(err.getText());
//                                }
//                            }
//
//                            if(hotelList.getHotelList()!=null) {
//                                List<JPHotelSimpleContent> hotelCodesRQ=new ArrayList<>();
//                                for (JPHotelSimpleInfo hotel : hotelList.getHotelList().getHotel()) {
//                                    JPHotelSimpleContent jpHotelSimpleContent=new JPHotelSimpleContent();
//                                    jpHotelSimpleContent.setCode(hotel.getCode()hotel);
//                                    hotelCodesRQ.add(jpHotelSimpleContent);
//                                    if(hotelCodesRQ.size()>24){
//                                        JPHotelContentRQ jpHotelContentRQ=new JPHotelContentRQ();
//                                        jpHotelContentRQ.setLanguage("en");
//                                        jpHotelContentRQ.setLogin(jpLogin);
//                                        jpHotelContentRQ.setVersion("1.1");
//                                        ArrayOfJPHotelSimpleContent arrayOfJPHotelSimpleContent=new ArrayOfJPHotelSimpleContent();
//                                        arrayOfJPHotelSimpleContent.getHotel().addAll(hotelCodesRQ);
//                                        jpHotelContentRQ.setHotelContentList(arrayOfJPHotelSimpleContent);
//                                        JPContentRS jpContentRS= staticDataTransactions.hotelContent(jpHotelContentRQ);
//                                        if(jpContentRS!=null){
//                                            if (jpContentRS.getErrors() != null) {
//
//                                                for (JPErrorType err : jpContentRS.getErrors().getError()) {
//                                                    bla.add(err.getText());
//                                                }
//                                            }
//                                            if(jpContentRS.getContents()!=null && jpContentRS.getContents().getHotelContent()!=null){
//                                                for(JPHotelContent hotelContent:jpContentRS.getContents().getHotelContent()){
//                                                    hotelContent.getHotelRooms().getHotelRoom().get(0).
//                                                }
//                                            }
//                                        }
//                                        hotelCodesRQ.clear();
//                                    }
//
//                                }
//                            }
//
//                        }
//                    }
                    bla.add(zone.getName()+" code"+zone.getCode() +" "+zone.isSearchable()+" "+zone.getAreaType()+" "+zone.getIATA()+" "+zone.getParentCode());
                }
            }
        }
        return bla;
    }
}
