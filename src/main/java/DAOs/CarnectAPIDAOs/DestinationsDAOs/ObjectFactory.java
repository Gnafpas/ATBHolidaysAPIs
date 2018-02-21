
package DAOs.CarnectAPIDAOs.DestinationsDAOs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.opentravel.ota._2003._05 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _VehicleCityRequest_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "VehicleCityRequest");
    private final static QName _VehicleAirportRequest_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "VehicleAirportRequest");
    private final static QName _InformationHeader_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "informationHeader");
    private final static QName _VehicleRegionRequest_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "VehicleRegionRequest");
    private final static QName _VehicleCountryRequest_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "VehicleCountryRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.opentravel.ota._2003._05
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VehicleCityResponse }
     * 
     */
    public VehicleCityResponse createVehicleCityResponse() {
        return new VehicleCityResponse();
    }

    /**
     * Create an instance of {@link ArrayOfErrorMessage }
     * 
     */
    public ArrayOfErrorMessage createArrayOfErrorMessage() {
        return new ArrayOfErrorMessage();
    }

    /**
     * Create an instance of {@link ArrayOfCity }
     * 
     */
    public ArrayOfCity createArrayOfCity() {
        return new ArrayOfCity();
    }

    /**
     * Create an instance of {@link VehicleCityRequest }
     * 
     */
    public VehicleCityRequest createVehicleCityRequest() {
        return new VehicleCityRequest();
    }

    /**
     * Create an instance of {@link VehicleAirportResponse }
     * 
     */
    public VehicleAirportResponse createVehicleAirportResponse() {
        return new VehicleAirportResponse();
    }

    /**
     * Create an instance of {@link ArrayOfAirport }
     * 
     */
    public ArrayOfAirport createArrayOfAirport() {
        return new ArrayOfAirport();
    }

    /**
     * Create an instance of {@link VehicleRegionRequest }
     * 
     */
    public VehicleRegionRequest createVehicleRegionRequest() {
        return new VehicleRegionRequest();
    }

    /**
     * Create an instance of {@link VehicleRegionResponse }
     * 
     */
    public VehicleRegionResponse createVehicleRegionResponse() {
        return new VehicleRegionResponse();
    }

    /**
     * Create an instance of {@link ArrayOfRegion }
     * 
     */
    public ArrayOfRegion createArrayOfRegion() {
        return new ArrayOfRegion();
    }

    /**
     * Create an instance of {@link VehicleCountryRequest }
     * 
     */
    public VehicleCountryRequest createVehicleCountryRequest() {
        return new VehicleCountryRequest();
    }

    /**
     * Create an instance of {@link VehicleAirportRequest }
     * 
     */
    public VehicleAirportRequest createVehicleAirportRequest() {
        return new VehicleAirportRequest();
    }

    /**
     * Create an instance of {@link InformationHeader }
     * 
     */
    public InformationHeader createInformationHeader() {
        return new InformationHeader();
    }

    /**
     * Create an instance of {@link VehicleCountryResponse }
     * 
     */
    public VehicleCountryResponse createVehicleCountryResponse() {
        return new VehicleCountryResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCountry }
     * 
     */
    public ArrayOfCountry createArrayOfCountry() {
        return new ArrayOfCountry();
    }

    /**
     * Create an instance of {@link City }
     * 
     */
    public City createCity() {
        return new City();
    }

    /**
     * Create an instance of {@link Airport }
     * 
     */
    public Airport createAirport() {
        return new Airport();
    }

    /**
     * Create an instance of {@link Region }
     * 
     */
    public Region createRegion() {
        return new Region();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link ErrorMessage }
     * 
     */
    public ErrorMessage createErrorMessage() {
        return new ErrorMessage();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VehicleCityRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "VehicleCityRequest")
    public JAXBElement<VehicleCityRequest> createVehicleCityRequest(VehicleCityRequest value) {
        return new JAXBElement<VehicleCityRequest>(_VehicleCityRequest_QNAME, VehicleCityRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VehicleAirportRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "VehicleAirportRequest")
    public JAXBElement<VehicleAirportRequest> createVehicleAirportRequest(VehicleAirportRequest value) {
        return new JAXBElement<VehicleAirportRequest>(_VehicleAirportRequest_QNAME, VehicleAirportRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InformationHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "informationHeader")
    public JAXBElement<InformationHeader> createInformationHeader(InformationHeader value) {
        return new JAXBElement<InformationHeader>(_InformationHeader_QNAME, InformationHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VehicleRegionRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "VehicleRegionRequest")
    public JAXBElement<VehicleRegionRequest> createVehicleRegionRequest(VehicleRegionRequest value) {
        return new JAXBElement<VehicleRegionRequest>(_VehicleRegionRequest_QNAME, VehicleRegionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VehicleCountryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "VehicleCountryRequest")
    public JAXBElement<VehicleCountryRequest> createVehicleCountryRequest(VehicleCountryRequest value) {
        return new JAXBElement<VehicleCountryRequest>(_VehicleCountryRequest_QNAME, VehicleCountryRequest.class, null, value);
    }

}
