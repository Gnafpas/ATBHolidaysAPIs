
package DAOs.JuniperAPIDAOs;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "InventoryTransactions", targetNamespace = "http://www.juniper.es/webservice/2007/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InventoryTransactions {


    /**
     * Hotel Allotment
     * 
     * @param hotelAllotmentRQ
     * @return
     *     returns DAOs.JuniperAPIDAOs.JPInventoryRS
     */
    @WebMethod(operationName = "HotelAllotment", action = "http://www.juniper.es/webservice/2007/HotelAllotment")
    @WebResult(name = "InventoryRS", targetNamespace = "http://www.juniper.es/webservice/2007/")
    @RequestWrapper(localName = "HotelAllotment", targetNamespace = "http://www.juniper.es/webservice/2007/", className = "DAOs.JuniperAPIDAOs.HotelAllotment")
    @ResponseWrapper(localName = "HotelAllotmentResponse", targetNamespace = "http://www.juniper.es/webservice/2007/", className = "DAOs.JuniperAPIDAOs.HotelAllotmentResponse")
    public JPInventoryRS hotelAllotment(
        @WebParam(name = "HotelAllotmentRQ", targetNamespace = "http://www.juniper.es/webservice/2007/")
        JPHotelAllotmentRQ hotelAllotmentRQ);

    /**
     * Hotel Rates
     * 
     * @param hotelRatesRQ
     * @return
     *     returns DAOs.JuniperAPIDAOs.JPInventoryRS
     */
    @WebMethod(operationName = "HotelRates", action = "http://www.juniper.es/webservice/2007/HotelRates")
    @WebResult(name = "InventoryRS", targetNamespace = "http://www.juniper.es/webservice/2007/")
    @RequestWrapper(localName = "HotelRates", targetNamespace = "http://www.juniper.es/webservice/2007/", className = "DAOs.JuniperAPIDAOs.HotelRates")
    @ResponseWrapper(localName = "HotelRatesResponse", targetNamespace = "http://www.juniper.es/webservice/2007/", className = "DAOs.JuniperAPIDAOs.HotelRatesResponse")
    public JPInventoryRS hotelRates(
        @WebParam(name = "HotelRatesRQ", targetNamespace = "http://www.juniper.es/webservice/2007/")
        JPHotelRatesRQ hotelRatesRQ);

    /**
     * Hotel Specifications
     * 
     * @param hotelSpecificationsRQ
     * @return
     *     returns DAOs.JuniperAPIDAOs.JPInventoryRS
     */
    @WebMethod(operationName = "HotelSpecifications", action = "http://www.juniper.es/webservice/2007/HotelSpecifications")
    @WebResult(name = "InventoryRS", targetNamespace = "http://www.juniper.es/webservice/2007/")
    @RequestWrapper(localName = "HotelSpecifications", targetNamespace = "http://www.juniper.es/webservice/2007/", className = "DAOs.JuniperAPIDAOs.HotelSpecifications")
    @ResponseWrapper(localName = "HotelSpecificationsResponse", targetNamespace = "http://www.juniper.es/webservice/2007/", className = "DAOs.JuniperAPIDAOs.HotelSpecificationsResponse")
    public JPInventoryRS hotelSpecifications(
        @WebParam(name = "HotelSpecificationsRQ", targetNamespace = "http://www.juniper.es/webservice/2007/")
        JPHotelSpecificationsRQ hotelSpecificationsRQ);

    /**
     * Hotel List Inventory
     * 
     * @param hotelListInventoryRQ
     * @return
     *     returns DAOs.JuniperAPIDAOs.JPInventoryRS
     */
    @WebMethod(operationName = "HotelListInventory", action = "http://www.juniper.es/webservice/2007/HotelListInventory")
    @WebResult(name = "InventoryRS", targetNamespace = "http://www.juniper.es/webservice/2007/")
    @RequestWrapper(localName = "HotelListInventory", targetNamespace = "http://www.juniper.es/webservice/2007/", className = "DAOs.JuniperAPIDAOs.HotelListInventory")
    @ResponseWrapper(localName = "HotelListInventoryResponse", targetNamespace = "http://www.juniper.es/webservice/2007/", className = "DAOs.JuniperAPIDAOs.HotelListInventoryResponse")
    public JPInventoryRS hotelListInventory(
        @WebParam(name = "HotelListInventoryRQ", targetNamespace = "http://www.juniper.es/webservice/2007/")
        JPHotelListInventoryRQ hotelListInventoryRQ);

}
