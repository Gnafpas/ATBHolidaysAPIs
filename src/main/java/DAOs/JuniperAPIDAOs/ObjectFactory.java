
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the DAOs.JuniperAPIDAOs package. 
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

    private final static QName _JPVisaItemVisaInfo_QNAME = new QName("http://www.juniper.es/webservice/2007/", "VisaInfo");
    private final static QName _JPVisaItemVisaOptions_QNAME = new QName("http://www.juniper.es/webservice/2007/", "VisaOptions");
    private final static QName _JPVisaItemCancellationPolicy_QNAME = new QName("", "CancellationPolicy");
    private final static QName _JPVisaItemAdditionalElements_QNAME = new QName("http://www.juniper.es/webservice/2007/", "AdditionalElements");
    private final static QName _JPVisaItemRelPaxes_QNAME = new QName("http://www.juniper.es/webservice/2007/", "RelPaxes");
    private final static QName _JPServiceItemServiceOptions_QNAME = new QName("http://www.juniper.es/webservice/2007/", "ServiceOptions");
    private final static QName _JPServiceItemServiceInfo_QNAME = new QName("http://www.juniper.es/webservice/2007/", "ServiceInfo");
    private final static QName _JPPackageItemPackageInfo_QNAME = new QName("http://www.juniper.es/webservice/2007/", "PackageInfo");
    private final static QName _JPPackageItemStays_QNAME = new QName("http://www.juniper.es/webservice/2007/", "Stays");
    private final static QName _JPPackageItemAFIPInformation_QNAME = new QName("http://www.juniper.es/webservice/2007/", "AFIPInformation");
    private final static QName _JPTransferItemTransferOptions_QNAME = new QName("http://www.juniper.es/webservice/2007/", "TransferOptions");
    private final static QName _JPTransferItemTransferInfo_QNAME = new QName("http://www.juniper.es/webservice/2007/", "TransferInfo");
    private final static QName _JPPaxAge_QNAME = new QName("http://www.juniper.es/webservice/2007/", "Age");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: DAOs.JuniperAPIDAOs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArrayOfJPBookingListRSReservation }
     * 
     */
    public ArrayOfJPBookingListRSReservation createArrayOfJPBookingListRSReservation() {
        return new ArrayOfJPBookingListRSReservation();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelInventorySpecialNotesNote }
     * 
     */
    public ArrayOfJPSOAPHotelInventorySpecialNotesNote createArrayOfJPSOAPHotelInventorySpecialNotesNote() {
        return new ArrayOfJPSOAPHotelInventorySpecialNotesNote();
    }

    /**
     * Create an instance of {@link JPBookingListRequest }
     * 
     */
    public JPBookingListRequest createJPBookingListRequest() {
        return new JPBookingListRequest();
    }

    /**
     * Create an instance of {@link FlightBookingResponse }
     * 
     */
    public FlightBookingResponse createFlightBookingResponse() {
        return new FlightBookingResponse();
    }

    /**
     * Create an instance of {@link JPBookingRS }
     * 
     */
    public JPBookingRS createJPBookingRS() {
        return new JPBookingRS();
    }

    /**
     * Create an instance of {@link RentacarLocationListResponse }
     * 
     */
    public RentacarLocationListResponse createRentacarLocationListResponse() {
        return new RentacarLocationListResponse();
    }

    /**
     * Create an instance of {@link JPStaticDataRS }
     * 
     */
    public JPStaticDataRS createJPStaticDataRS() {
        return new JPStaticDataRS();
    }

    /**
     * Create an instance of {@link ServiceBookingRules }
     * 
     */
    public ServiceBookingRules createServiceBookingRules() {
        return new ServiceBookingRules();
    }

    /**
     * Create an instance of {@link JPServiceBookingRulesRQ }
     * 
     */
    public JPServiceBookingRulesRQ createJPServiceBookingRulesRQ() {
        return new JPServiceBookingRulesRQ();
    }

    /**
     * Create an instance of {@link ServicePortfolioResponse }
     * 
     */
    public ServicePortfolioResponse createServicePortfolioResponse() {
        return new ServicePortfolioResponse();
    }

    /**
     * Create an instance of {@link PackageCheckAvail }
     * 
     */
    public PackageCheckAvail createPackageCheckAvail() {
        return new PackageCheckAvail();
    }

    /**
     * Create an instance of {@link JPPackageCheckAvailRQ }
     * 
     */
    public JPPackageCheckAvailRQ createJPPackageCheckAvailRQ() {
        return new JPPackageCheckAvailRQ();
    }

    /**
     * Create an instance of {@link CancelBooking }
     * 
     */
    public CancelBooking createCancelBooking() {
        return new CancelBooking();
    }

    /**
     * Create an instance of {@link JPCancelRQ }
     * 
     */
    public JPCancelRQ createJPCancelRQ() {
        return new JPCancelRQ();
    }

    /**
     * Create an instance of {@link FlightBookingRulesResponse }
     * 
     */
    public FlightBookingRulesResponse createFlightBookingRulesResponse() {
        return new FlightBookingRulesResponse();
    }

    /**
     * Create an instance of {@link JPBookingRulesRS }
     * 
     */
    public JPBookingRulesRS createJPBookingRulesRS() {
        return new JPBookingRulesRS();
    }

    /**
     * Create an instance of {@link PackageBookingRules }
     * 
     */
    public PackageBookingRules createPackageBookingRules() {
        return new PackageBookingRules();
    }

    /**
     * Create an instance of {@link JPPackageBookingRulesRQ }
     * 
     */
    public JPPackageBookingRulesRQ createJPPackageBookingRulesRQ() {
        return new JPPackageBookingRulesRQ();
    }

    /**
     * Create an instance of {@link CancelBookingResponse }
     * 
     */
    public CancelBookingResponse createCancelBookingResponse() {
        return new CancelBookingResponse();
    }

    /**
     * Create an instance of {@link CheckPaymentResponse }
     * 
     */
    public CheckPaymentResponse createCheckPaymentResponse() {
        return new CheckPaymentResponse();
    }

    /**
     * Create an instance of {@link JPCheckPaymentRS }
     * 
     */
    public JPCheckPaymentRS createJPCheckPaymentRS() {
        return new JPCheckPaymentRS();
    }

    /**
     * Create an instance of {@link HotelCatalogueData }
     * 
     */
    public HotelCatalogueData createHotelCatalogueData() {
        return new HotelCatalogueData();
    }

    /**
     * Create an instance of {@link JPHotelCatalogueDataRQ }
     * 
     */
    public JPHotelCatalogueDataRQ createJPHotelCatalogueDataRQ() {
        return new JPHotelCatalogueDataRQ();
    }

    /**
     * Create an instance of {@link HotelListInventoryResponse }
     * 
     */
    public HotelListInventoryResponse createHotelListInventoryResponse() {
        return new HotelListInventoryResponse();
    }

    /**
     * Create an instance of {@link JPInventoryRS }
     * 
     */
    public JPInventoryRS createJPInventoryRS() {
        return new JPInventoryRS();
    }

    /**
     * Create an instance of {@link HotelContent }
     * 
     */
    public HotelContent createHotelContent() {
        return new HotelContent();
    }

    /**
     * Create an instance of {@link JPHotelContentRQ }
     * 
     */
    public JPHotelContentRQ createJPHotelContentRQ() {
        return new JPHotelContentRQ();
    }

    /**
     * Create an instance of {@link HotelSpecificationsResponse }
     * 
     */
    public HotelSpecificationsResponse createHotelSpecificationsResponse() {
        return new HotelSpecificationsResponse();
    }

    /**
     * Create an instance of {@link PackageContent }
     * 
     */
    public PackageContent createPackageContent() {
        return new PackageContent();
    }

    /**
     * Create an instance of {@link JPPackageContentRQ }
     * 
     */
    public JPPackageContentRQ createJPPackageContentRQ() {
        return new JPPackageContentRQ();
    }

    /**
     * Create an instance of {@link CruiseCheckAvailResponse }
     * 
     */
    public CruiseCheckAvailResponse createCruiseCheckAvailResponse() {
        return new CruiseCheckAvailResponse();
    }

    /**
     * Create an instance of {@link JPCheckAvailRS }
     * 
     */
    public JPCheckAvailRS createJPCheckAvailRS() {
        return new JPCheckAvailRS();
    }

    /**
     * Create an instance of {@link TransferPortfolioResponse }
     * 
     */
    public TransferPortfolioResponse createTransferPortfolioResponse() {
        return new TransferPortfolioResponse();
    }

    /**
     * Create an instance of {@link TransferBookingRulesResponse }
     * 
     */
    public TransferBookingRulesResponse createTransferBookingRulesResponse() {
        return new TransferBookingRulesResponse();
    }

    /**
     * Create an instance of {@link FinalCustomerSaveResponse }
     * 
     */
    public FinalCustomerSaveResponse createFinalCustomerSaveResponse() {
        return new FinalCustomerSaveResponse();
    }

    /**
     * Create an instance of {@link JPFinalCustomerSaveResult }
     * 
     */
    public JPFinalCustomerSaveResult createJPFinalCustomerSaveResult() {
        return new JPFinalCustomerSaveResult();
    }

    /**
     * Create an instance of {@link HotelAllotment }
     * 
     */
    public HotelAllotment createHotelAllotment() {
        return new HotelAllotment();
    }

    /**
     * Create an instance of {@link JPHotelAllotmentRQ }
     * 
     */
    public JPHotelAllotmentRQ createJPHotelAllotmentRQ() {
        return new JPHotelAllotmentRQ();
    }

    /**
     * Create an instance of {@link HotelBookingRulesResponse }
     * 
     */
    public HotelBookingRulesResponse createHotelBookingRulesResponse() {
        return new HotelBookingRulesResponse();
    }

    /**
     * Create an instance of {@link CruiseBooking }
     * 
     */
    public CruiseBooking createCruiseBooking() {
        return new CruiseBooking();
    }

    /**
     * Create an instance of {@link JPCruiseBooking }
     * 
     */
    public JPCruiseBooking createJPCruiseBooking() {
        return new JPCruiseBooking();
    }

    /**
     * Create an instance of {@link PackageSearcher }
     * 
     */
    public PackageSearcher createPackageSearcher() {
        return new PackageSearcher();
    }

    /**
     * Create an instance of {@link JPPackageSearcherRQ }
     * 
     */
    public JPPackageSearcherRQ createJPPackageSearcherRQ() {
        return new JPPackageSearcherRQ();
    }

    /**
     * Create an instance of {@link TransferBookingResponse }
     * 
     */
    public TransferBookingResponse createTransferBookingResponse() {
        return new TransferBookingResponse();
    }

    /**
     * Create an instance of {@link VisaAvail }
     * 
     */
    public VisaAvail createVisaAvail() {
        return new VisaAvail();
    }

    /**
     * Create an instance of {@link JPVisaAvailabilityRQ }
     * 
     */
    public JPVisaAvailabilityRQ createJPVisaAvailabilityRQ() {
        return new JPVisaAvailabilityRQ();
    }

    /**
     * Create an instance of {@link HotelAllotmentResponse }
     * 
     */
    public HotelAllotmentResponse createHotelAllotmentResponse() {
        return new HotelAllotmentResponse();
    }

    /**
     * Create an instance of {@link PackageListResponse }
     * 
     */
    public PackageListResponse createPackageListResponse() {
        return new PackageListResponse();
    }

    /**
     * Create an instance of {@link HotelPortfolio }
     * 
     */
    public HotelPortfolio createHotelPortfolio() {
        return new HotelPortfolio();
    }

    /**
     * Create an instance of {@link JPHotelPortfolioRQ }
     * 
     */
    public JPHotelPortfolioRQ createJPHotelPortfolioRQ() {
        return new JPHotelPortfolioRQ();
    }

    /**
     * Create an instance of {@link HotelAvailCalendarResponse }
     * 
     */
    public HotelAvailCalendarResponse createHotelAvailCalendarResponse() {
        return new HotelAvailCalendarResponse();
    }

    /**
     * Create an instance of {@link JPAvailResponseRS }
     * 
     */
    public JPAvailResponseRS createJPAvailResponseRS() {
        return new JPAvailResponseRS();
    }

    /**
     * Create an instance of {@link CruiseItineraryResponse }
     * 
     */
    public CruiseItineraryResponse createCruiseItineraryResponse() {
        return new CruiseItineraryResponse();
    }

    /**
     * Create an instance of {@link VisaPortfolio }
     * 
     */
    public VisaPortfolio createVisaPortfolio() {
        return new VisaPortfolio();
    }

    /**
     * Create an instance of {@link JPVisaPortfolioRQ }
     * 
     */
    public JPVisaPortfolioRQ createJPVisaPortfolioRQ() {
        return new JPVisaPortfolioRQ();
    }

    /**
     * Create an instance of {@link TransferCheckAvail }
     * 
     */
    public TransferCheckAvail createTransferCheckAvail() {
        return new TransferCheckAvail();
    }

    /**
     * Create an instance of {@link JPTransferCheckAvailRQ }
     * 
     */
    public JPTransferCheckAvailRQ createJPTransferCheckAvailRQ() {
        return new JPTransferCheckAvailRQ();
    }

    /**
     * Create an instance of {@link InsuranceBooking }
     * 
     */
    public InsuranceBooking createInsuranceBooking() {
        return new InsuranceBooking();
    }

    /**
     * Create an instance of {@link JPInsuranceBooking }
     * 
     */
    public JPInsuranceBooking createJPInsuranceBooking() {
        return new JPInsuranceBooking();
    }

    /**
     * Create an instance of {@link InsuranceBookingResponse }
     * 
     */
    public InsuranceBookingResponse createInsuranceBookingResponse() {
        return new InsuranceBookingResponse();
    }

    /**
     * Create an instance of {@link CruiseShip }
     * 
     */
    public CruiseShip createCruiseShip() {
        return new CruiseShip();
    }

    /**
     * Create an instance of {@link JPCruiseShipRQ }
     * 
     */
    public JPCruiseShipRQ createJPCruiseShipRQ() {
        return new JPCruiseShipRQ();
    }

    /**
     * Create an instance of {@link PackageAvail }
     * 
     */
    public PackageAvail createPackageAvail() {
        return new PackageAvail();
    }

    /**
     * Create an instance of {@link JPPackageAvailabilityRQ }
     * 
     */
    public JPPackageAvailabilityRQ createJPPackageAvailabilityRQ() {
        return new JPPackageAvailabilityRQ();
    }

    /**
     * Create an instance of {@link TransferAvailByHotel }
     * 
     */
    public TransferAvailByHotel createTransferAvailByHotel() {
        return new TransferAvailByHotel();
    }

    /**
     * Create an instance of {@link JPTransferAvailabilityRQByHotel }
     * 
     */
    public JPTransferAvailabilityRQByHotel createJPTransferAvailabilityRQByHotel() {
        return new JPTransferAvailabilityRQByHotel();
    }

    /**
     * Create an instance of {@link CruisePreAvailResponse }
     * 
     */
    public CruisePreAvailResponse createCruisePreAvailResponse() {
        return new CruisePreAvailResponse();
    }

    /**
     * Create an instance of {@link RentacarBookingResponse }
     * 
     */
    public RentacarBookingResponse createRentacarBookingResponse() {
        return new RentacarBookingResponse();
    }

    /**
     * Create an instance of {@link CruiseAvailResponse }
     * 
     */
    public CruiseAvailResponse createCruiseAvailResponse() {
        return new CruiseAvailResponse();
    }

    /**
     * Create an instance of {@link CheckPaymentRequiredFieldResponse }
     * 
     */
    public CheckPaymentRequiredFieldResponse createCheckPaymentRequiredFieldResponse() {
        return new CheckPaymentRequiredFieldResponse();
    }

    /**
     * Create an instance of {@link JPCheckPaymentRequiredFieldsRS }
     * 
     */
    public JPCheckPaymentRequiredFieldsRS createJPCheckPaymentRequiredFieldsRS() {
        return new JPCheckPaymentRequiredFieldsRS();
    }

    /**
     * Create an instance of {@link BookingListResponse }
     * 
     */
    public BookingListResponse createBookingListResponse() {
        return new BookingListResponse();
    }

    /**
     * Create an instance of {@link JPBookingListRS }
     * 
     */
    public JPBookingListRS createJPBookingListRS() {
        return new JPBookingListRS();
    }

    /**
     * Create an instance of {@link RentacarAvailResponse }
     * 
     */
    public RentacarAvailResponse createRentacarAvailResponse() {
        return new RentacarAvailResponse();
    }

    /**
     * Create an instance of {@link TransferAvailByHotelResponse }
     * 
     */
    public TransferAvailByHotelResponse createTransferAvailByHotelResponse() {
        return new TransferAvailByHotelResponse();
    }

    /**
     * Create an instance of {@link CruiseAvail }
     * 
     */
    public CruiseAvail createCruiseAvail() {
        return new CruiseAvail();
    }

    /**
     * Create an instance of {@link JPCruiseAvail }
     * 
     */
    public JPCruiseAvail createJPCruiseAvail() {
        return new JPCruiseAvail();
    }

    /**
     * Create an instance of {@link RentacarLocationList }
     * 
     */
    public RentacarLocationList createRentacarLocationList() {
        return new RentacarLocationList();
    }

    /**
     * Create an instance of {@link JPRentacarLocationListRQ }
     * 
     */
    public JPRentacarLocationListRQ createJPRentacarLocationListRQ() {
        return new JPRentacarLocationListRQ();
    }

    /**
     * Create an instance of {@link InsuranceAvail }
     * 
     */
    public InsuranceAvail createInsuranceAvail() {
        return new InsuranceAvail();
    }

    /**
     * Create an instance of {@link JPInsuranceAvail }
     * 
     */
    public JPInsuranceAvail createJPInsuranceAvail() {
        return new JPInsuranceAvail();
    }

    /**
     * Create an instance of {@link ServiceAvailResponse }
     * 
     */
    public ServiceAvailResponse createServiceAvailResponse() {
        return new ServiceAvailResponse();
    }

    /**
     * Create an instance of {@link GenericDataCatalogue }
     * 
     */
    public GenericDataCatalogue createGenericDataCatalogue() {
        return new GenericDataCatalogue();
    }

    /**
     * Create an instance of {@link JPGenericDataCatalogueRQ }
     * 
     */
    public JPGenericDataCatalogueRQ createJPGenericDataCatalogueRQ() {
        return new JPGenericDataCatalogueRQ();
    }

    /**
     * Create an instance of {@link PackageAvailResponse }
     * 
     */
    public PackageAvailResponse createPackageAvailResponse() {
        return new PackageAvailResponse();
    }

    /**
     * Create an instance of {@link GetPermissionListResponse }
     * 
     */
    public GetPermissionListResponse createGetPermissionListResponse() {
        return new GetPermissionListResponse();
    }

    /**
     * Create an instance of {@link TransferCatalogueDataResponse }
     * 
     */
    public TransferCatalogueDataResponse createTransferCatalogueDataResponse() {
        return new TransferCatalogueDataResponse();
    }

    /**
     * Create an instance of {@link PackageCalendarPrice }
     * 
     */
    public PackageCalendarPrice createPackageCalendarPrice() {
        return new PackageCalendarPrice();
    }

    /**
     * Create an instance of {@link JPPackageCalendarPriceRQ }
     * 
     */
    public JPPackageCalendarPriceRQ createJPPackageCalendarPriceRQ() {
        return new JPPackageCalendarPriceRQ();
    }

    /**
     * Create an instance of {@link FlightCheckAvail }
     * 
     */
    public FlightCheckAvail createFlightCheckAvail() {
        return new FlightCheckAvail();
    }

    /**
     * Create an instance of {@link JPFlightCheckAvailRQ }
     * 
     */
    public JPFlightCheckAvailRQ createJPFlightCheckAvailRQ() {
        return new JPFlightCheckAvailRQ();
    }

    /**
     * Create an instance of {@link GetPermissionList }
     * 
     */
    public GetPermissionList createGetPermissionList() {
        return new GetPermissionList();
    }

    /**
     * Create an instance of {@link JPUserPermissionsRQ }
     * 
     */
    public JPUserPermissionsRQ createJPUserPermissionsRQ() {
        return new JPUserPermissionsRQ();
    }

    /**
     * Create an instance of {@link CruisePreAvail }
     * 
     */
    public CruisePreAvail createCruisePreAvail() {
        return new CruisePreAvail();
    }

    /**
     * Create an instance of {@link JPCruisePreAvail }
     * 
     */
    public JPCruisePreAvail createJPCruisePreAvail() {
        return new JPCruisePreAvail();
    }

    /**
     * Create an instance of {@link TransferAvail }
     * 
     */
    public TransferAvail createTransferAvail() {
        return new TransferAvail();
    }

    /**
     * Create an instance of {@link JPTransferAvailabilityRQ }
     * 
     */
    public JPTransferAvailabilityRQ createJPTransferAvailabilityRQ() {
        return new JPTransferAvailabilityRQ();
    }

    /**
     * Create an instance of {@link FlightAvail }
     * 
     */
    public FlightAvail createFlightAvail() {
        return new FlightAvail();
    }

    /**
     * Create an instance of {@link JPFlightAvail }
     * 
     */
    public JPFlightAvail createJPFlightAvail() {
        return new JPFlightAvail();
    }

    /**
     * Create an instance of {@link PackageBookingResponse }
     * 
     */
    public PackageBookingResponse createPackageBookingResponse() {
        return new PackageBookingResponse();
    }

    /**
     * Create an instance of {@link CruiseBookingRules }
     * 
     */
    public CruiseBookingRules createCruiseBookingRules() {
        return new CruiseBookingRules();
    }

    /**
     * Create an instance of {@link JPCruiseBookingRulesRQ }
     * 
     */
    public JPCruiseBookingRulesRQ createJPCruiseBookingRulesRQ() {
        return new JPCruiseBookingRulesRQ();
    }

    /**
     * Create an instance of {@link InsuranceCheckAvailResponse }
     * 
     */
    public InsuranceCheckAvailResponse createInsuranceCheckAvailResponse() {
        return new InsuranceCheckAvailResponse();
    }

    /**
     * Create an instance of {@link FinalCustomerRead }
     * 
     */
    public FinalCustomerRead createFinalCustomerRead() {
        return new FinalCustomerRead();
    }

    /**
     * Create an instance of {@link JPFinalCustomerRead }
     * 
     */
    public JPFinalCustomerRead createJPFinalCustomerRead() {
        return new JPFinalCustomerRead();
    }

    /**
     * Create an instance of {@link PaymentBooking }
     * 
     */
    public PaymentBooking createPaymentBooking() {
        return new PaymentBooking();
    }

    /**
     * Create an instance of {@link JPPaymentRQ }
     * 
     */
    public JPPaymentRQ createJPPaymentRQ() {
        return new JPPaymentRQ();
    }

    /**
     * Create an instance of {@link PaymentBookingResponse }
     * 
     */
    public PaymentBookingResponse createPaymentBookingResponse() {
        return new PaymentBookingResponse();
    }

    /**
     * Create an instance of {@link JPPaymentRS }
     * 
     */
    public JPPaymentRS createJPPaymentRS() {
        return new JPPaymentRS();
    }

    /**
     * Create an instance of {@link HotelAvailResponse }
     * 
     */
    public HotelAvailResponse createHotelAvailResponse() {
        return new HotelAvailResponse();
    }

    /**
     * Create an instance of {@link PackageCheckAvailResponse }
     * 
     */
    public PackageCheckAvailResponse createPackageCheckAvailResponse() {
        return new PackageCheckAvailResponse();
    }

    /**
     * Create an instance of {@link HotelBooking }
     * 
     */
    public HotelBooking createHotelBooking() {
        return new HotelBooking();
    }

    /**
     * Create an instance of {@link JPHotelBooking }
     * 
     */
    public JPHotelBooking createJPHotelBooking() {
        return new JPHotelBooking();
    }

    /**
     * Create an instance of {@link InsuranceCheckAvail }
     * 
     */
    public InsuranceCheckAvail createInsuranceCheckAvail() {
        return new InsuranceCheckAvail();
    }

    /**
     * Create an instance of {@link JPInsuranceCheckAvail }
     * 
     */
    public JPInsuranceCheckAvail createJPInsuranceCheckAvail() {
        return new JPInsuranceCheckAvail();
    }

    /**
     * Create an instance of {@link HotelSpecifications }
     * 
     */
    public HotelSpecifications createHotelSpecifications() {
        return new HotelSpecifications();
    }

    /**
     * Create an instance of {@link JPHotelSpecificationsRQ }
     * 
     */
    public JPHotelSpecificationsRQ createJPHotelSpecificationsRQ() {
        return new JPHotelSpecificationsRQ();
    }

    /**
     * Create an instance of {@link RentacarCheckAvail }
     * 
     */
    public RentacarCheckAvail createRentacarCheckAvail() {
        return new RentacarCheckAvail();
    }

    /**
     * Create an instance of {@link JPRentacarCheckAvailRQ }
     * 
     */
    public JPRentacarCheckAvailRQ createJPRentacarCheckAvailRQ() {
        return new JPRentacarCheckAvailRQ();
    }

    /**
     * Create an instance of {@link VisaBookingRules }
     * 
     */
    public VisaBookingRules createVisaBookingRules() {
        return new VisaBookingRules();
    }

    /**
     * Create an instance of {@link JPVisaBookingRulesRQ }
     * 
     */
    public JPVisaBookingRulesRQ createJPVisaBookingRulesRQ() {
        return new JPVisaBookingRulesRQ();
    }

    /**
     * Create an instance of {@link HotelContentResponse }
     * 
     */
    public HotelContentResponse createHotelContentResponse() {
        return new HotelContentResponse();
    }

    /**
     * Create an instance of {@link JPContentRS }
     * 
     */
    public JPContentRS createJPContentRS() {
        return new JPContentRS();
    }

    /**
     * Create an instance of {@link ServiceCatalogueDataResponse }
     * 
     */
    public ServiceCatalogueDataResponse createServiceCatalogueDataResponse() {
        return new ServiceCatalogueDataResponse();
    }

    /**
     * Create an instance of {@link HotelCheckAvail }
     * 
     */
    public HotelCheckAvail createHotelCheckAvail() {
        return new HotelCheckAvail();
    }

    /**
     * Create an instance of {@link JPHotelCheckAvail }
     * 
     */
    public JPHotelCheckAvail createJPHotelCheckAvail() {
        return new JPHotelCheckAvail();
    }

    /**
     * Create an instance of {@link ZoneListResponse }
     * 
     */
    public ZoneListResponse createZoneListResponse() {
        return new ZoneListResponse();
    }

    /**
     * Create an instance of {@link HotelRates }
     * 
     */
    public HotelRates createHotelRates() {
        return new HotelRates();
    }

    /**
     * Create an instance of {@link JPHotelRatesRQ }
     * 
     */
    public JPHotelRatesRQ createJPHotelRatesRQ() {
        return new JPHotelRatesRQ();
    }

    /**
     * Create an instance of {@link ServiceBookingRulesResponse }
     * 
     */
    public ServiceBookingRulesResponse createServiceBookingRulesResponse() {
        return new ServiceBookingRulesResponse();
    }

    /**
     * Create an instance of {@link RoomListResponse }
     * 
     */
    public RoomListResponse createRoomListResponse() {
        return new RoomListResponse();
    }

    /**
     * Create an instance of {@link PackageList }
     * 
     */
    public PackageList createPackageList() {
        return new PackageList();
    }

    /**
     * Create an instance of {@link JPPackageListRQ }
     * 
     */
    public JPPackageListRQ createJPPackageListRQ() {
        return new JPPackageListRQ();
    }

    /**
     * Create an instance of {@link CruiseDataListResponse }
     * 
     */
    public CruiseDataListResponse createCruiseDataListResponse() {
        return new CruiseDataListResponse();
    }

    /**
     * Create an instance of {@link VisaPortfolioResponse }
     * 
     */
    public VisaPortfolioResponse createVisaPortfolioResponse() {
        return new VisaPortfolioResponse();
    }

    /**
     * Create an instance of {@link PackageChangeProductResponse }
     * 
     */
    public PackageChangeProductResponse createPackageChangeProductResponse() {
        return new PackageChangeProductResponse();
    }

    /**
     * Create an instance of {@link HotelCheckAvailResponse }
     * 
     */
    public HotelCheckAvailResponse createHotelCheckAvailResponse() {
        return new HotelCheckAvailResponse();
    }

    /**
     * Create an instance of {@link TransferPortfolio }
     * 
     */
    public TransferPortfolio createTransferPortfolio() {
        return new TransferPortfolio();
    }

    /**
     * Create an instance of {@link JPTransferPortfolioRQ }
     * 
     */
    public JPTransferPortfolioRQ createJPTransferPortfolioRQ() {
        return new JPTransferPortfolioRQ();
    }

    /**
     * Create an instance of {@link FlightCheckAvailResponse }
     * 
     */
    public FlightCheckAvailResponse createFlightCheckAvailResponse() {
        return new FlightCheckAvailResponse();
    }

    /**
     * Create an instance of {@link VisaBookingRulesResponse }
     * 
     */
    public VisaBookingRulesResponse createVisaBookingRulesResponse() {
        return new VisaBookingRulesResponse();
    }

    /**
     * Create an instance of {@link RentacarCheckAvailResponse }
     * 
     */
    public RentacarCheckAvailResponse createRentacarCheckAvailResponse() {
        return new RentacarCheckAvailResponse();
    }

    /**
     * Create an instance of {@link PackageCalendarPriceResponse }
     * 
     */
    public PackageCalendarPriceResponse createPackageCalendarPriceResponse() {
        return new PackageCalendarPriceResponse();
    }

    /**
     * Create an instance of {@link FlightTicketing }
     * 
     */
    public FlightTicketing createFlightTicketing() {
        return new FlightTicketing();
    }

    /**
     * Create an instance of {@link JPFlightTicketingRQ }
     * 
     */
    public JPFlightTicketingRQ createJPFlightTicketingRQ() {
        return new JPFlightTicketingRQ();
    }

    /**
     * Create an instance of {@link TransferCheckAvailResponse }
     * 
     */
    public TransferCheckAvailResponse createTransferCheckAvailResponse() {
        return new TransferCheckAvailResponse();
    }

    /**
     * Create an instance of {@link RentacarBookingRules }
     * 
     */
    public RentacarBookingRules createRentacarBookingRules() {
        return new RentacarBookingRules();
    }

    /**
     * Create an instance of {@link JPRentacarBookingRulesRQ }
     * 
     */
    public JPRentacarBookingRulesRQ createJPRentacarBookingRulesRQ() {
        return new JPRentacarBookingRulesRQ();
    }

    /**
     * Create an instance of {@link RentacarAvail }
     * 
     */
    public RentacarAvail createRentacarAvail() {
        return new RentacarAvail();
    }

    /**
     * Create an instance of {@link JPRentacarAvail }
     * 
     */
    public JPRentacarAvail createJPRentacarAvail() {
        return new JPRentacarAvail();
    }

    /**
     * Create an instance of {@link CruiseItinerary }
     * 
     */
    public CruiseItinerary createCruiseItinerary() {
        return new CruiseItinerary();
    }

    /**
     * Create an instance of {@link JPCruiseItineraryRQ }
     * 
     */
    public JPCruiseItineraryRQ createJPCruiseItineraryRQ() {
        return new JPCruiseItineraryRQ();
    }

    /**
     * Create an instance of {@link AgencyReadResponse }
     * 
     */
    public AgencyReadResponse createAgencyReadResponse() {
        return new AgencyReadResponse();
    }

    /**
     * Create an instance of {@link InsuranceAvailResponse }
     * 
     */
    public InsuranceAvailResponse createInsuranceAvailResponse() {
        return new InsuranceAvailResponse();
    }

    /**
     * Create an instance of {@link CheckPaymentRequiredField }
     * 
     */
    public CheckPaymentRequiredField createCheckPaymentRequiredField() {
        return new CheckPaymentRequiredField();
    }

    /**
     * Create an instance of {@link JPCheckPaymentRequiredFieldsRQ }
     * 
     */
    public JPCheckPaymentRequiredFieldsRQ createJPCheckPaymentRequiredFieldsRQ() {
        return new JPCheckPaymentRequiredFieldsRQ();
    }

    /**
     * Create an instance of {@link HotelCatalogueDataResponse }
     * 
     */
    public HotelCatalogueDataResponse createHotelCatalogueDataResponse() {
        return new HotelCatalogueDataResponse();
    }

    /**
     * Create an instance of {@link GetZoneInfoListResponse }
     * 
     */
    public GetZoneInfoListResponse createGetZoneInfoListResponse() {
        return new GetZoneInfoListResponse();
    }

    /**
     * Create an instance of {@link HotelListInventory }
     * 
     */
    public HotelListInventory createHotelListInventory() {
        return new HotelListInventory();
    }

    /**
     * Create an instance of {@link JPHotelListInventoryRQ }
     * 
     */
    public JPHotelListInventoryRQ createJPHotelListInventoryRQ() {
        return new JPHotelListInventoryRQ();
    }

    /**
     * Create an instance of {@link ReadBookingResponse }
     * 
     */
    public ReadBookingResponse createReadBookingResponse() {
        return new ReadBookingResponse();
    }

    /**
     * Create an instance of {@link CityListResponse }
     * 
     */
    public CityListResponse createCityListResponse() {
        return new CityListResponse();
    }

    /**
     * Create an instance of {@link FlightBookingRules }
     * 
     */
    public FlightBookingRules createFlightBookingRules() {
        return new FlightBookingRules();
    }

    /**
     * Create an instance of {@link JPFlightBookingRulesRQ }
     * 
     */
    public JPFlightBookingRulesRQ createJPFlightBookingRulesRQ() {
        return new JPFlightBookingRulesRQ();
    }

    /**
     * Create an instance of {@link FlightBooking }
     * 
     */
    public FlightBooking createFlightBooking() {
        return new FlightBooking();
    }

    /**
     * Create an instance of {@link JPFlightBooking }
     * 
     */
    public JPFlightBooking createJPFlightBooking() {
        return new JPFlightBooking();
    }

    /**
     * Create an instance of {@link FinalCustomerSave }
     * 
     */
    public FinalCustomerSave createFinalCustomerSave() {
        return new FinalCustomerSave();
    }

    /**
     * Create an instance of {@link JPFinalCustomerSave }
     * 
     */
    public JPFinalCustomerSave createJPFinalCustomerSave() {
        return new JPFinalCustomerSave();
    }

    /**
     * Create an instance of {@link TransferCatalogueData }
     * 
     */
    public TransferCatalogueData createTransferCatalogueData() {
        return new TransferCatalogueData();
    }

    /**
     * Create an instance of {@link JPTransferCatalogueDataRQ }
     * 
     */
    public JPTransferCatalogueDataRQ createJPTransferCatalogueDataRQ() {
        return new JPTransferCatalogueDataRQ();
    }

    /**
     * Create an instance of {@link PackageContentResponse }
     * 
     */
    public PackageContentResponse createPackageContentResponse() {
        return new PackageContentResponse();
    }

    /**
     * Create an instance of {@link ServiceBooking }
     * 
     */
    public ServiceBooking createServiceBooking() {
        return new ServiceBooking();
    }

    /**
     * Create an instance of {@link JPServiceBooking }
     * 
     */
    public JPServiceBooking createJPServiceBooking() {
        return new JPServiceBooking();
    }

    /**
     * Create an instance of {@link CruiseDataList }
     * 
     */
    public CruiseDataList createCruiseDataList() {
        return new CruiseDataList();
    }

    /**
     * Create an instance of {@link JPCruiseDataRQ }
     * 
     */
    public JPCruiseDataRQ createJPCruiseDataRQ() {
        return new JPCruiseDataRQ();
    }

    /**
     * Create an instance of {@link TransferAvailResponse }
     * 
     */
    public TransferAvailResponse createTransferAvailResponse() {
        return new TransferAvailResponse();
    }

    /**
     * Create an instance of {@link ShoppingBasketReadResponse }
     * 
     */
    public ShoppingBasketReadResponse createShoppingBasketReadResponse() {
        return new ShoppingBasketReadResponse();
    }

    /**
     * Create an instance of {@link JPShoppingBasketResult }
     * 
     */
    public JPShoppingBasketResult createJPShoppingBasketResult() {
        return new JPShoppingBasketResult();
    }

    /**
     * Create an instance of {@link ServicePortfolio }
     * 
     */
    public ServicePortfolio createServicePortfolio() {
        return new ServicePortfolio();
    }

    /**
     * Create an instance of {@link JPServicePortfolioRQ }
     * 
     */
    public JPServicePortfolioRQ createJPServicePortfolioRQ() {
        return new JPServicePortfolioRQ();
    }

    /**
     * Create an instance of {@link ServiceCheckAvailResponse }
     * 
     */
    public ServiceCheckAvailResponse createServiceCheckAvailResponse() {
        return new ServiceCheckAvailResponse();
    }

    /**
     * Create an instance of {@link RentacarBookingRulesResponse }
     * 
     */
    public RentacarBookingRulesResponse createRentacarBookingRulesResponse() {
        return new RentacarBookingRulesResponse();
    }

    /**
     * Create an instance of {@link MeetingPointListResponse }
     * 
     */
    public MeetingPointListResponse createMeetingPointListResponse() {
        return new MeetingPointListResponse();
    }

    /**
     * Create an instance of {@link VisaBooking }
     * 
     */
    public VisaBooking createVisaBooking() {
        return new VisaBooking();
    }

    /**
     * Create an instance of {@link JPVisaBooking }
     * 
     */
    public JPVisaBooking createJPVisaBooking() {
        return new JPVisaBooking();
    }

    /**
     * Create an instance of {@link VisaAvailResponse }
     * 
     */
    public VisaAvailResponse createVisaAvailResponse() {
        return new VisaAvailResponse();
    }

    /**
     * Create an instance of {@link ServiceCatalogueData }
     * 
     */
    public ServiceCatalogueData createServiceCatalogueData() {
        return new ServiceCatalogueData();
    }

    /**
     * Create an instance of {@link JPServiceCatalogueDataRQ }
     * 
     */
    public JPServiceCatalogueDataRQ createJPServiceCatalogueDataRQ() {
        return new JPServiceCatalogueDataRQ();
    }

    /**
     * Create an instance of {@link FinalCustomerReadResponse }
     * 
     */
    public FinalCustomerReadResponse createFinalCustomerReadResponse() {
        return new FinalCustomerReadResponse();
    }

    /**
     * Create an instance of {@link InsuranceBookingRulesResponse }
     * 
     */
    public InsuranceBookingRulesResponse createInsuranceBookingRulesResponse() {
        return new InsuranceBookingRulesResponse();
    }

    /**
     * Create an instance of {@link CheckPayment }
     * 
     */
    public CheckPayment createCheckPayment() {
        return new CheckPayment();
    }

    /**
     * Create an instance of {@link JPCheckPaymentRQ }
     * 
     */
    public JPCheckPaymentRQ createJPCheckPaymentRQ() {
        return new JPCheckPaymentRQ();
    }

    /**
     * Create an instance of {@link HotelConfirmModify }
     * 
     */
    public HotelConfirmModify createHotelConfirmModify() {
        return new HotelConfirmModify();
    }

    /**
     * Create an instance of {@link JPHotelConfirmModify }
     * 
     */
    public JPHotelConfirmModify createJPHotelConfirmModify() {
        return new JPHotelConfirmModify();
    }

    /**
     * Create an instance of {@link VisaCatalogueDataResponse }
     * 
     */
    public VisaCatalogueDataResponse createVisaCatalogueDataResponse() {
        return new VisaCatalogueDataResponse();
    }

    /**
     * Create an instance of {@link HotelModify }
     * 
     */
    public HotelModify createHotelModify() {
        return new HotelModify();
    }

    /**
     * Create an instance of {@link JPHotelModify }
     * 
     */
    public JPHotelModify createJPHotelModify() {
        return new JPHotelModify();
    }

    /**
     * Create an instance of {@link HotelBookingRules }
     * 
     */
    public HotelBookingRules createHotelBookingRules() {
        return new HotelBookingRules();
    }

    /**
     * Create an instance of {@link JPHotelBookingRuleRQ }
     * 
     */
    public JPHotelBookingRuleRQ createJPHotelBookingRuleRQ() {
        return new JPHotelBookingRuleRQ();
    }

    /**
     * Create an instance of {@link RoomList }
     * 
     */
    public RoomList createRoomList() {
        return new RoomList();
    }

    /**
     * Create an instance of {@link JPRoomListRQ }
     * 
     */
    public JPRoomListRQ createJPRoomListRQ() {
        return new JPRoomListRQ();
    }

    /**
     * Create an instance of {@link ServiceCheckAvail }
     * 
     */
    public ServiceCheckAvail createServiceCheckAvail() {
        return new ServiceCheckAvail();
    }

    /**
     * Create an instance of {@link JPServiceCheckAvailRQ }
     * 
     */
    public JPServiceCheckAvailRQ createJPServiceCheckAvailRQ() {
        return new JPServiceCheckAvailRQ();
    }

    /**
     * Create an instance of {@link HotelFutureRates }
     * 
     */
    public HotelFutureRates createHotelFutureRates() {
        return new HotelFutureRates();
    }

    /**
     * Create an instance of {@link JPHotelFutureRates }
     * 
     */
    public JPHotelFutureRates createJPHotelFutureRates() {
        return new JPHotelFutureRates();
    }

    /**
     * Create an instance of {@link ServiceAvail }
     * 
     */
    public ServiceAvail createServiceAvail() {
        return new ServiceAvail();
    }

    /**
     * Create an instance of {@link JPServiceAvailabilityRQ }
     * 
     */
    public JPServiceAvailabilityRQ createJPServiceAvailabilityRQ() {
        return new JPServiceAvailabilityRQ();
    }

    /**
     * Create an instance of {@link CruiseShipResponse }
     * 
     */
    public CruiseShipResponse createCruiseShipResponse() {
        return new CruiseShipResponse();
    }

    /**
     * Create an instance of {@link ShoppingBasketSave }
     * 
     */
    public ShoppingBasketSave createShoppingBasketSave() {
        return new ShoppingBasketSave();
    }

    /**
     * Create an instance of {@link JPShoppingBasketSave }
     * 
     */
    public JPShoppingBasketSave createJPShoppingBasketSave() {
        return new JPShoppingBasketSave();
    }

    /**
     * Create an instance of {@link ServiceBookingResponse }
     * 
     */
    public ServiceBookingResponse createServiceBookingResponse() {
        return new ServiceBookingResponse();
    }

    /**
     * Create an instance of {@link HotelBookingResponse }
     * 
     */
    public HotelBookingResponse createHotelBookingResponse() {
        return new HotelBookingResponse();
    }

    /**
     * Create an instance of {@link HotelFutureRatesResponse }
     * 
     */
    public HotelFutureRatesResponse createHotelFutureRatesResponse() {
        return new HotelFutureRatesResponse();
    }

    /**
     * Create an instance of {@link SupplierList }
     * 
     */
    public SupplierList createSupplierList() {
        return new SupplierList();
    }

    /**
     * Create an instance of {@link JPSupplierListRQ }
     * 
     */
    public JPSupplierListRQ createJPSupplierListRQ() {
        return new JPSupplierListRQ();
    }

    /**
     * Create an instance of {@link InsuranceBookingRules }
     * 
     */
    public InsuranceBookingRules createInsuranceBookingRules() {
        return new InsuranceBookingRules();
    }

    /**
     * Create an instance of {@link JPInsuranceBookingRulesRQ }
     * 
     */
    public JPInsuranceBookingRulesRQ createJPInsuranceBookingRulesRQ() {
        return new JPInsuranceBookingRulesRQ();
    }

    /**
     * Create an instance of {@link RentacarLocationContentResponse }
     * 
     */
    public RentacarLocationContentResponse createRentacarLocationContentResponse() {
        return new RentacarLocationContentResponse();
    }

    /**
     * Create an instance of {@link HotelPortfolioResponse }
     * 
     */
    public HotelPortfolioResponse createHotelPortfolioResponse() {
        return new HotelPortfolioResponse();
    }

    /**
     * Create an instance of {@link CityList }
     * 
     */
    public CityList createCityList() {
        return new CityList();
    }

    /**
     * Create an instance of {@link JPCityListRQ }
     * 
     */
    public JPCityListRQ createJPCityListRQ() {
        return new JPCityListRQ();
    }

    /**
     * Create an instance of {@link VisaCatalogueData }
     * 
     */
    public VisaCatalogueData createVisaCatalogueData() {
        return new VisaCatalogueData();
    }

    /**
     * Create an instance of {@link JPVisaCatalogueDataRQ }
     * 
     */
    public JPVisaCatalogueDataRQ createJPVisaCatalogueDataRQ() {
        return new JPVisaCatalogueDataRQ();
    }

    /**
     * Create an instance of {@link PackageBookingRulesResponse }
     * 
     */
    public PackageBookingRulesResponse createPackageBookingRulesResponse() {
        return new PackageBookingRulesResponse();
    }

    /**
     * Create an instance of {@link PackageBooking }
     * 
     */
    public PackageBooking createPackageBooking() {
        return new PackageBooking();
    }

    /**
     * Create an instance of {@link JPPackageBooking }
     * 
     */
    public JPPackageBooking createJPPackageBooking() {
        return new JPPackageBooking();
    }

    /**
     * Create an instance of {@link CruiseCheckAvail }
     * 
     */
    public CruiseCheckAvail createCruiseCheckAvail() {
        return new CruiseCheckAvail();
    }

    /**
     * Create an instance of {@link JPCruiseCheckAvail }
     * 
     */
    public JPCruiseCheckAvail createJPCruiseCheckAvail() {
        return new JPCruiseCheckAvail();
    }

    /**
     * Create an instance of {@link GetZoneInfoList }
     * 
     */
    public GetZoneInfoList createGetZoneInfoList() {
        return new GetZoneInfoList();
    }

    /**
     * Create an instance of {@link JPZoneInfoRQ }
     * 
     */
    public JPZoneInfoRQ createJPZoneInfoRQ() {
        return new JPZoneInfoRQ();
    }

    /**
     * Create an instance of {@link TransferBooking }
     * 
     */
    public TransferBooking createTransferBooking() {
        return new TransferBooking();
    }

    /**
     * Create an instance of {@link JPTransferBooking }
     * 
     */
    public JPTransferBooking createJPTransferBooking() {
        return new JPTransferBooking();
    }

    /**
     * Create an instance of {@link HotelRatesResponse }
     * 
     */
    public HotelRatesResponse createHotelRatesResponse() {
        return new HotelRatesResponse();
    }

    /**
     * Create an instance of {@link MeetingPointList }
     * 
     */
    public MeetingPointList createMeetingPointList() {
        return new MeetingPointList();
    }

    /**
     * Create an instance of {@link JPMeetingPointListRQ }
     * 
     */
    public JPMeetingPointListRQ createJPMeetingPointListRQ() {
        return new JPMeetingPointListRQ();
    }

    /**
     * Create an instance of {@link RentacarLocationContent }
     * 
     */
    public RentacarLocationContent createRentacarLocationContent() {
        return new RentacarLocationContent();
    }

    /**
     * Create an instance of {@link JPRentacarLocationContentRQ }
     * 
     */
    public JPRentacarLocationContentRQ createJPRentacarLocationContentRQ() {
        return new JPRentacarLocationContentRQ();
    }

    /**
     * Create an instance of {@link FlightAvailResponse }
     * 
     */
    public FlightAvailResponse createFlightAvailResponse() {
        return new FlightAvailResponse();
    }

    /**
     * Create an instance of {@link HotelListResponse }
     * 
     */
    public HotelListResponse createHotelListResponse() {
        return new HotelListResponse();
    }

    /**
     * Create an instance of {@link PackageSearcherResponse }
     * 
     */
    public PackageSearcherResponse createPackageSearcherResponse() {
        return new PackageSearcherResponse();
    }

    /**
     * Create an instance of {@link ShoppingBasketSaveResponse }
     * 
     */
    public ShoppingBasketSaveResponse createShoppingBasketSaveResponse() {
        return new ShoppingBasketSaveResponse();
    }

    /**
     * Create an instance of {@link RentacarBooking }
     * 
     */
    public RentacarBooking createRentacarBooking() {
        return new RentacarBooking();
    }

    /**
     * Create an instance of {@link JPRentacarBooking }
     * 
     */
    public JPRentacarBooking createJPRentacarBooking() {
        return new JPRentacarBooking();
    }

    /**
     * Create an instance of {@link CruiseBookingRulesResponse }
     * 
     */
    public CruiseBookingRulesResponse createCruiseBookingRulesResponse() {
        return new CruiseBookingRulesResponse();
    }

    /**
     * Create an instance of {@link ShoppingBasketRead }
     * 
     */
    public ShoppingBasketRead createShoppingBasketRead() {
        return new ShoppingBasketRead();
    }

    /**
     * Create an instance of {@link JPShoppingBasketRead }
     * 
     */
    public JPShoppingBasketRead createJPShoppingBasketRead() {
        return new JPShoppingBasketRead();
    }

    /**
     * Create an instance of {@link HotelModifyResponse }
     * 
     */
    public HotelModifyResponse createHotelModifyResponse() {
        return new HotelModifyResponse();
    }

    /**
     * Create an instance of {@link JPModifyRS }
     * 
     */
    public JPModifyRS createJPModifyRS() {
        return new JPModifyRS();
    }

    /**
     * Create an instance of {@link AgencyRead }
     * 
     */
    public AgencyRead createAgencyRead() {
        return new AgencyRead();
    }

    /**
     * Create an instance of {@link JPAgencyRead }
     * 
     */
    public JPAgencyRead createJPAgencyRead() {
        return new JPAgencyRead();
    }

    /**
     * Create an instance of {@link FlightTicketingResponse }
     * 
     */
    public FlightTicketingResponse createFlightTicketingResponse() {
        return new FlightTicketingResponse();
    }

    /**
     * Create an instance of {@link JPFlightTicketingRS }
     * 
     */
    public JPFlightTicketingRS createJPFlightTicketingRS() {
        return new JPFlightTicketingRS();
    }

    /**
     * Create an instance of {@link CruiseBookingResponse }
     * 
     */
    public CruiseBookingResponse createCruiseBookingResponse() {
        return new CruiseBookingResponse();
    }

    /**
     * Create an instance of {@link ZoneList }
     * 
     */
    public ZoneList createZoneList() {
        return new ZoneList();
    }

    /**
     * Create an instance of {@link JPZoneListRQ }
     * 
     */
    public JPZoneListRQ createJPZoneListRQ() {
        return new JPZoneListRQ();
    }

    /**
     * Create an instance of {@link TransferBookingRules }
     * 
     */
    public TransferBookingRules createTransferBookingRules() {
        return new TransferBookingRules();
    }

    /**
     * Create an instance of {@link JPTransferBookingRulesRQ }
     * 
     */
    public JPTransferBookingRulesRQ createJPTransferBookingRulesRQ() {
        return new JPTransferBookingRulesRQ();
    }

    /**
     * Create an instance of {@link VisaBookingResponse }
     * 
     */
    public VisaBookingResponse createVisaBookingResponse() {
        return new VisaBookingResponse();
    }

    /**
     * Create an instance of {@link ReadBooking }
     * 
     */
    public ReadBooking createReadBooking() {
        return new ReadBooking();
    }

    /**
     * Create an instance of {@link JPReadRQ }
     * 
     */
    public JPReadRQ createJPReadRQ() {
        return new JPReadRQ();
    }

    /**
     * Create an instance of {@link PackageChangeProduct }
     * 
     */
    public PackageChangeProduct createPackageChangeProduct() {
        return new PackageChangeProduct();
    }

    /**
     * Create an instance of {@link JPPackageChangeProductRQ }
     * 
     */
    public JPPackageChangeProductRQ createJPPackageChangeProductRQ() {
        return new JPPackageChangeProductRQ();
    }

    /**
     * Create an instance of {@link HotelAvail }
     * 
     */
    public HotelAvail createHotelAvail() {
        return new HotelAvail();
    }

    /**
     * Create an instance of {@link JPHotelAvail }
     * 
     */
    public JPHotelAvail createJPHotelAvail() {
        return new JPHotelAvail();
    }

    /**
     * Create an instance of {@link SupplierListResponse }
     * 
     */
    public SupplierListResponse createSupplierListResponse() {
        return new SupplierListResponse();
    }

    /**
     * Create an instance of {@link VisaCheckAvail }
     * 
     */
    public VisaCheckAvail createVisaCheckAvail() {
        return new VisaCheckAvail();
    }

    /**
     * Create an instance of {@link JPVisaCheckAvailRQ }
     * 
     */
    public JPVisaCheckAvailRQ createJPVisaCheckAvailRQ() {
        return new JPVisaCheckAvailRQ();
    }

    /**
     * Create an instance of {@link HotelAvailCalendar }
     * 
     */
    public HotelAvailCalendar createHotelAvailCalendar() {
        return new HotelAvailCalendar();
    }

    /**
     * Create an instance of {@link JPHotelAvailCalendar }
     * 
     */
    public JPHotelAvailCalendar createJPHotelAvailCalendar() {
        return new JPHotelAvailCalendar();
    }

    /**
     * Create an instance of {@link HotelList }
     * 
     */
    public HotelList createHotelList() {
        return new HotelList();
    }

    /**
     * Create an instance of {@link JPHotelListRQ }
     * 
     */
    public JPHotelListRQ createJPHotelListRQ() {
        return new JPHotelListRQ();
    }

    /**
     * Create an instance of {@link HotelConfirmModifyResponse }
     * 
     */
    public HotelConfirmModifyResponse createHotelConfirmModifyResponse() {
        return new HotelConfirmModifyResponse();
    }

    /**
     * Create an instance of {@link BookingList }
     * 
     */
    public BookingList createBookingList() {
        return new BookingList();
    }

    /**
     * Create an instance of {@link JPBookingListRQ }
     * 
     */
    public JPBookingListRQ createJPBookingListRQ() {
        return new JPBookingListRQ();
    }

    /**
     * Create an instance of {@link VisaCheckAvailResponse }
     * 
     */
    public VisaCheckAvailResponse createVisaCheckAvailResponse() {
        return new VisaCheckAvailResponse();
    }

    /**
     * Create an instance of {@link GenericDataCatalogueResponse }
     * 
     */
    public GenericDataCatalogueResponse createGenericDataCatalogueResponse() {
        return new GenericDataCatalogueResponse();
    }

    /**
     * Create an instance of {@link JPServiceElement }
     * 
     */
    public JPServiceElement createJPServiceElement() {
        return new JPServiceElement();
    }

    /**
     * Create an instance of {@link JPServiceDate }
     * 
     */
    public JPServiceDate createJPServiceDate() {
        return new JPServiceDate();
    }

    /**
     * Create an instance of {@link JPCruiseBookingAdvancedOptions }
     * 
     */
    public JPCruiseBookingAdvancedOptions createJPCruiseBookingAdvancedOptions() {
        return new JPCruiseBookingAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPAgencyList }
     * 
     */
    public JPAgencyList createJPAgencyList() {
        return new JPAgencyList();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPRatePrice }
     * 
     */
    public ArrayOfJPSOAPRatePrice createArrayOfJPSOAPRatePrice() {
        return new ArrayOfJPSOAPRatePrice();
    }

    /**
     * Create an instance of {@link JPExtendedRelPaxBag }
     * 
     */
    public JPExtendedRelPaxBag createJPExtendedRelPaxBag() {
        return new JPExtendedRelPaxBag();
    }

    /**
     * Create an instance of {@link JPPackageBookingRulesAdvancedOptions }
     * 
     */
    public JPPackageBookingRulesAdvancedOptions createJPPackageBookingRulesAdvancedOptions() {
        return new JPPackageBookingRulesAdvancedOptions();
    }

    /**
     * Create an instance of {@link ArrayOfJPReservation }
     * 
     */
    public ArrayOfJPReservation createArrayOfJPReservation() {
        return new ArrayOfJPReservation();
    }

    /**
     * Create an instance of {@link JPRoom }
     * 
     */
    public JPRoom createJPRoom() {
        return new JPRoom();
    }

    /**
     * Create an instance of {@link JPBreakdownPrice }
     * 
     */
    public JPBreakdownPrice createJPBreakdownPrice() {
        return new JPBreakdownPrice();
    }

    /**
     * Create an instance of {@link ArrayOfJPImageLong }
     * 
     */
    public ArrayOfJPImageLong createArrayOfJPImageLong() {
        return new ArrayOfJPImageLong();
    }

    /**
     * Create an instance of {@link JPLargeFamilyDiscount }
     * 
     */
    public JPLargeFamilyDiscount createJPLargeFamilyDiscount() {
        return new JPLargeFamilyDiscount();
    }

    /**
     * Create an instance of {@link ArrayOfJPCarFee }
     * 
     */
    public ArrayOfJPCarFee createArrayOfJPCarFee() {
        return new ArrayOfJPCarFee();
    }

    /**
     * Create an instance of {@link JPRentacarResultsBookingRules }
     * 
     */
    public JPRentacarResultsBookingRules createJPRentacarResultsBookingRules() {
        return new JPRentacarResultsBookingRules();
    }

    /**
     * Create an instance of {@link JPInsuranceBookingRulesRequest }
     * 
     */
    public JPInsuranceBookingRulesRequest createJPInsuranceBookingRulesRequest() {
        return new JPInsuranceBookingRulesRequest();
    }

    /**
     * Create an instance of {@link JPService }
     * 
     */
    public JPService createJPService() {
        return new JPService();
    }

    /**
     * Create an instance of {@link ArrayOfJPServiceBookingInfo }
     * 
     */
    public ArrayOfJPServiceBookingInfo createArrayOfJPServiceBookingInfo() {
        return new ArrayOfJPServiceBookingInfo();
    }

    /**
     * Create an instance of {@link JPRestrictedOptions }
     * 
     */
    public JPRestrictedOptions createJPRestrictedOptions() {
        return new JPRestrictedOptions();
    }

    /**
     * Create an instance of {@link ArrayOfArrayOfJPFlightTicketInfo }
     * 
     */
    public ArrayOfArrayOfJPFlightTicketInfo createArrayOfArrayOfJPFlightTicketInfo() {
        return new ArrayOfArrayOfJPFlightTicketInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPDailyHotelContract }
     * 
     */
    public ArrayOfJPDailyHotelContract createArrayOfJPDailyHotelContract() {
        return new ArrayOfJPDailyHotelContract();
    }

    /**
     * Create an instance of {@link JPInsuranceElement }
     * 
     */
    public JPInsuranceElement createJPInsuranceElement() {
        return new JPInsuranceElement();
    }

    /**
     * Create an instance of {@link JPHotelCheckAvailAdvancedOptions }
     * 
     */
    public JPHotelCheckAvailAdvancedOptions createJPHotelCheckAvailAdvancedOptions() {
        return new JPHotelCheckAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPFlightTicketInfo }
     * 
     */
    public JPFlightTicketInfo createJPFlightTicketInfo() {
        return new JPFlightTicketInfo();
    }

    /**
     * Create an instance of {@link JPSearchSegmentShip }
     * 
     */
    public JPSearchSegmentShip createJPSearchSegmentShip() {
        return new JPSearchSegmentShip();
    }

    /**
     * Create an instance of {@link JPCheckAvailResults }
     * 
     */
    public JPCheckAvailResults createJPCheckAvailResults() {
        return new JPCheckAvailResults();
    }

    /**
     * Create an instance of {@link JPProductSupplier }
     * 
     */
    public JPProductSupplier createJPProductSupplier() {
        return new JPProductSupplier();
    }

    /**
     * Create an instance of {@link JPFinalCustomerContactData }
     * 
     */
    public JPFinalCustomerContactData createJPFinalCustomerContactData() {
        return new JPFinalCustomerContactData();
    }

    /**
     * Create an instance of {@link ArrayOfJPZone }
     * 
     */
    public ArrayOfJPZone createArrayOfJPZone() {
        return new ArrayOfJPZone();
    }

    /**
     * Create an instance of {@link ArrayOfJPServiceProduct }
     * 
     */
    public ArrayOfJPServiceProduct createArrayOfJPServiceProduct() {
        return new ArrayOfJPServiceProduct();
    }

    /**
     * Create an instance of {@link ArrayOfJPCar }
     * 
     */
    public ArrayOfJPCar createArrayOfJPCar() {
        return new ArrayOfJPCar();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelPreference }
     * 
     */
    public ArrayOfJPHotelPreference createArrayOfJPHotelPreference() {
        return new ArrayOfJPHotelPreference();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsServices }
     * 
     */
    public JPSearchSegmentsServices createJPSearchSegmentsServices() {
        return new JPSearchSegmentsServices();
    }

    /**
     * Create an instance of {@link JPSOAPContract }
     * 
     */
    public JPSOAPContract createJPSOAPContract() {
        return new JPSOAPContract();
    }

    /**
     * Create an instance of {@link JPServiceElements }
     * 
     */
    public JPServiceElements createJPServiceElements() {
        return new JPServiceElements();
    }

    /**
     * Create an instance of {@link ArrayOfJPGenericCatalogueItem }
     * 
     */
    public ArrayOfJPGenericCatalogueItem createArrayOfJPGenericCatalogueItem() {
        return new ArrayOfJPGenericCatalogueItem();
    }

    /**
     * Create an instance of {@link ArrayOfJPItemBreakdown }
     * 
     */
    public ArrayOfJPItemBreakdown createArrayOfJPItemBreakdown() {
        return new ArrayOfJPItemBreakdown();
    }

    /**
     * Create an instance of {@link JPOperationSchedule }
     * 
     */
    public JPOperationSchedule createJPOperationSchedule() {
        return new JPOperationSchedule();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseSupplier }
     * 
     */
    public ArrayOfJPCruiseSupplier createArrayOfJPCruiseSupplier() {
        return new ArrayOfJPCruiseSupplier();
    }

    /**
     * Create an instance of {@link JPSearchSegmentRentacarRules }
     * 
     */
    public JPSearchSegmentRentacarRules createJPSearchSegmentRentacarRules() {
        return new JPSearchSegmentRentacarRules();
    }

    /**
     * Create an instance of {@link JPPayment }
     * 
     */
    public JPPayment createJPPayment() {
        return new JPPayment();
    }

    /**
     * Create an instance of {@link JPRentacarBookingAdvancedOptions }
     * 
     */
    public JPRentacarBookingAdvancedOptions createJPRentacarBookingAdvancedOptions() {
        return new JPRentacarBookingAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPHotelRoom }
     * 
     */
    public JPHotelRoom createJPHotelRoom() {
        return new JPHotelRoom();
    }

    /**
     * Create an instance of {@link JPSOAPApplicationRulesSupplement }
     * 
     */
    public JPSOAPApplicationRulesSupplement createJPSOAPApplicationRulesSupplement() {
        return new JPSOAPApplicationRulesSupplement();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsInsurance }
     * 
     */
    public JPSearchSegmentsInsurance createJPSearchSegmentsInsurance() {
        return new JPSearchSegmentsInsurance();
    }

    /**
     * Create an instance of {@link JPResidentDiscount }
     * 
     */
    public JPResidentDiscount createJPResidentDiscount() {
        return new JPResidentDiscount();
    }

    /**
     * Create an instance of {@link JPTransferElements }
     * 
     */
    public JPTransferElements createJPTransferElements() {
        return new JPTransferElements();
    }

    /**
     * Create an instance of {@link JPRentacarOption }
     * 
     */
    public JPRentacarOption createJPRentacarOption() {
        return new JPRentacarOption();
    }

    /**
     * Create an instance of {@link JPCruiseItemStaticData }
     * 
     */
    public JPCruiseItemStaticData createJPCruiseItemStaticData() {
        return new JPCruiseItemStaticData();
    }

    /**
     * Create an instance of {@link JPFlightBookingAdvancedOptions }
     * 
     */
    public JPFlightBookingAdvancedOptions createJPFlightBookingAdvancedOptions() {
        return new JPFlightBookingAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPPackageCalendarPriceItem }
     * 
     */
    public JPPackageCalendarPriceItem createJPPackageCalendarPriceItem() {
        return new JPPackageCalendarPriceItem();
    }

    /**
     * Create an instance of {@link JPFlight }
     * 
     */
    public JPFlight createJPFlight() {
        return new JPFlight();
    }

    /**
     * Create an instance of {@link JPPackageSearcherRequest }
     * 
     */
    public JPPackageSearcherRequest createJPPackageSearcherRequest() {
        return new JPPackageSearcherRequest();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelRatePlanRestriction }
     * 
     */
    public ArrayOfJPSOAPHotelRatePlanRestriction createArrayOfJPSOAPHotelRatePlanRestriction() {
        return new ArrayOfJPSOAPHotelRatePlanRestriction();
    }

    /**
     * Create an instance of {@link JPRentacarRequest }
     * 
     */
    public JPRentacarRequest createJPRentacarRequest() {
        return new JPRentacarRequest();
    }

    /**
     * Create an instance of {@link JPCity }
     * 
     */
    public JPCity createJPCity() {
        return new JPCity();
    }

    /**
     * Create an instance of {@link JPTransferBookingInfo }
     * 
     */
    public JPTransferBookingInfo createJPTransferBookingInfo() {
        return new JPTransferBookingInfo();
    }

    /**
     * Create an instance of {@link JPHotelAdditionalElements }
     * 
     */
    public JPHotelAdditionalElements createJPHotelAdditionalElements() {
        return new JPHotelAdditionalElements();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelDailyContracts }
     * 
     */
    public ArrayOfJPHotelDailyContracts createArrayOfJPHotelDailyContracts() {
        return new ArrayOfJPHotelDailyContracts();
    }

    /**
     * Create an instance of {@link JPContactInfo }
     * 
     */
    public JPContactInfo createJPContactInfo() {
        return new JPContactInfo();
    }

    /**
     * Create an instance of {@link JPModifyAdvancedOptions }
     * 
     */
    public JPModifyAdvancedOptions createJPModifyAdvancedOptions() {
        return new JPModifyAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPTotalFixAmounts }
     * 
     */
    public JPTotalFixAmounts createJPTotalFixAmounts() {
        return new JPTotalFixAmounts();
    }

    /**
     * Create an instance of {@link JPHotelRatesRS }
     * 
     */
    public JPHotelRatesRS createJPHotelRatesRS() {
        return new JPHotelRatesRS();
    }

    /**
     * Create an instance of {@link JPPackageElement }
     * 
     */
    public JPPackageElement createJPPackageElement() {
        return new JPPackageElement();
    }

    /**
     * Create an instance of {@link JPCruiseBookingRulesAdvancedOptions }
     * 
     */
    public JPCruiseBookingRulesAdvancedOptions createJPCruiseBookingRulesAdvancedOptions() {
        return new JPCruiseBookingRulesAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPCruiseExtendedRelPax }
     * 
     */
    public JPCruiseExtendedRelPax createJPCruiseExtendedRelPax() {
        return new JPCruiseExtendedRelPax();
    }

    /**
     * Create an instance of {@link ArrayOfJPRelPax }
     * 
     */
    public ArrayOfJPRelPax createArrayOfJPRelPax() {
        return new ArrayOfJPRelPax();
    }

    /**
     * Create an instance of {@link JPWarnings }
     * 
     */
    public JPWarnings createJPWarnings() {
        return new JPWarnings();
    }

    /**
     * Create an instance of {@link JPInsuranceBookingRulesAdvancedOptions }
     * 
     */
    public JPInsuranceBookingRulesAdvancedOptions createJPInsuranceBookingRulesAdvancedOptions() {
        return new JPInsuranceBookingRulesAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPFlightOptionRequest }
     * 
     */
    public JPFlightOptionRequest createJPFlightOptionRequest() {
        return new JPFlightOptionRequest();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackageHotel }
     * 
     */
    public ArrayOfJPPackageHotel createArrayOfJPPackageHotel() {
        return new ArrayOfJPPackageHotel();
    }

    /**
     * Create an instance of {@link JPHotelBookingAdvancedOptions }
     * 
     */
    public JPHotelBookingAdvancedOptions createJPHotelBookingAdvancedOptions() {
        return new JPHotelBookingAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPPaymentRequest }
     * 
     */
    public JPPaymentRequest createJPPaymentRequest() {
        return new JPPaymentRequest();
    }

    /**
     * Create an instance of {@link ArrayOfJPPhoneNumber }
     * 
     */
    public ArrayOfJPPhoneNumber createArrayOfJPPhoneNumber() {
        return new ArrayOfJPPhoneNumber();
    }

    /**
     * Create an instance of {@link JPSearchPreSegmentCruise }
     * 
     */
    public JPSearchPreSegmentCruise createJPSearchPreSegmentCruise() {
        return new JPSearchPreSegmentCruise();
    }

    /**
     * Create an instance of {@link JPMeetingPointList }
     * 
     */
    public JPMeetingPointList createJPMeetingPointList() {
        return new JPMeetingPointList();
    }

    /**
     * Create an instance of {@link JPOptionalFares }
     * 
     */
    public JPOptionalFares createJPOptionalFares() {
        return new JPOptionalFares();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanSupplement }
     * 
     */
    public JPSOAPHotelRatePlanSupplement createJPSOAPHotelRatePlanSupplement() {
        return new JPSOAPHotelRatePlanSupplement();
    }

    /**
     * Create an instance of {@link JPCruiseSegment }
     * 
     */
    public JPCruiseSegment createJPCruiseSegment() {
        return new JPCruiseSegment();
    }

    /**
     * Create an instance of {@link JPEmergencyContact }
     * 
     */
    public JPEmergencyContact createJPEmergencyContact() {
        return new JPEmergencyContact();
    }

    /**
     * Create an instance of {@link JPCruiseResult }
     * 
     */
    public JPCruiseResult createJPCruiseResult() {
        return new JPCruiseResult();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPDateIntervals }
     * 
     */
    public ArrayOfJPSOAPDateIntervals createArrayOfJPSOAPDateIntervals() {
        return new ArrayOfJPSOAPDateIntervals();
    }

    /**
     * Create an instance of {@link JPZoneListRequest }
     * 
     */
    public JPZoneListRequest createJPZoneListRequest() {
        return new JPZoneListRequest();
    }

    /**
     * Create an instance of {@link JPInsuranceCheckAvailAdvancedOptions }
     * 
     */
    public JPInsuranceCheckAvailAdvancedOptions createJPInsuranceCheckAvailAdvancedOptions() {
        return new JPInsuranceCheckAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanRoomUpgradeOffer }
     * 
     */
    public JPSOAPHotelRatePlanRoomUpgradeOffer createJPSOAPHotelRatePlanRoomUpgradeOffer() {
        return new JPSOAPHotelRatePlanRoomUpgradeOffer();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelResult }
     * 
     */
    public ArrayOfJPHotelResult createArrayOfJPHotelResult() {
        return new ArrayOfJPHotelResult();
    }

    /**
     * Create an instance of {@link JPTransferDestination }
     * 
     */
    public JPTransferDestination createJPTransferDestination() {
        return new JPTransferDestination();
    }

    /**
     * Create an instance of {@link JPRoomInfo }
     * 
     */
    public JPRoomInfo createJPRoomInfo() {
        return new JPRoomInfo();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanSpecialNoteText }
     * 
     */
    public JPSOAPHotelRatePlanSpecialNoteText createJPSOAPHotelRatePlanSpecialNoteText() {
        return new JPSOAPHotelRatePlanSpecialNoteText();
    }

    /**
     * Create an instance of {@link JPCruiseData }
     * 
     */
    public JPCruiseData createJPCruiseData() {
        return new JPCruiseData();
    }

    /**
     * Create an instance of {@link JPFlightSupplier }
     * 
     */
    public JPFlightSupplier createJPFlightSupplier() {
        return new JPFlightSupplier();
    }

    /**
     * Create an instance of {@link JPRentacarElement }
     * 
     */
    public JPRentacarElement createJPRentacarElement() {
        return new JPRentacarElement();
    }

    /**
     * Create an instance of {@link JPCruisePromotion }
     * 
     */
    public JPCruisePromotion createJPCruisePromotion() {
        return new JPCruisePromotion();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPOrderedPrice }
     * 
     */
    public ArrayOfJPSOAPOrderedPrice createArrayOfJPSOAPOrderedPrice() {
        return new ArrayOfJPSOAPOrderedPrice();
    }

    /**
     * Create an instance of {@link JPSOAPBookingInAdvance }
     * 
     */
    public JPSOAPBookingInAdvance createJPSOAPBookingInAdvance() {
        return new JPSOAPBookingInAdvance();
    }

    /**
     * Create an instance of {@link JPAgencyData }
     * 
     */
    public JPAgencyData createJPAgencyData() {
        return new JPAgencyData();
    }

    /**
     * Create an instance of {@link JPServiceCategory }
     * 
     */
    public JPServiceCategory createJPServiceCategory() {
        return new JPServiceCategory();
    }

    /**
     * Create an instance of {@link ArrayOfJPAirline }
     * 
     */
    public ArrayOfJPAirline createArrayOfJPAirline() {
        return new ArrayOfJPAirline();
    }

    /**
     * Create an instance of {@link JPDebug }
     * 
     */
    public JPDebug createJPDebug() {
        return new JPDebug();
    }

    /**
     * Create an instance of {@link ArrayOfJPOfferSupplementType }
     * 
     */
    public ArrayOfJPOfferSupplementType createArrayOfJPOfferSupplementType() {
        return new ArrayOfJPOfferSupplementType();
    }

    /**
     * Create an instance of {@link ArrayOfJPWarningDistribution }
     * 
     */
    public ArrayOfJPWarningDistribution createArrayOfJPWarningDistribution() {
        return new ArrayOfJPWarningDistribution();
    }

    /**
     * Create an instance of {@link JPRentacarSupplier }
     * 
     */
    public JPRentacarSupplier createJPRentacarSupplier() {
        return new JPRentacarSupplier();
    }

    /**
     * Create an instance of {@link JPPackageZone }
     * 
     */
    public JPPackageZone createJPPackageZone() {
        return new JPPackageZone();
    }

    /**
     * Create an instance of {@link JPTransferRuleOptionRQ }
     * 
     */
    public JPTransferRuleOptionRQ createJPTransferRuleOptionRQ() {
        return new JPTransferRuleOptionRQ();
    }

    /**
     * Create an instance of {@link JPSOAPApplicationRules }
     * 
     */
    public JPSOAPApplicationRules createJPSOAPApplicationRules() {
        return new JPSOAPApplicationRules();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelRoom }
     * 
     */
    public ArrayOfJPHotelRoom createArrayOfJPHotelRoom() {
        return new ArrayOfJPHotelRoom();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelInventoryCode }
     * 
     */
    public ArrayOfJPHotelInventoryCode createArrayOfJPHotelInventoryCode() {
        return new ArrayOfJPHotelInventoryCode();
    }

    /**
     * Create an instance of {@link JPRentacarBookingRulesOption }
     * 
     */
    public JPRentacarBookingRulesOption createJPRentacarBookingRulesOption() {
        return new JPRentacarBookingRulesOption();
    }

    /**
     * Create an instance of {@link JPDescription }
     * 
     */
    public JPDescription createJPDescription() {
        return new JPDescription();
    }

    /**
     * Create an instance of {@link JPServicesCheckAvailAdvancedOptions }
     * 
     */
    public JPServicesCheckAvailAdvancedOptions createJPServicesCheckAvailAdvancedOptions() {
        return new JPServicesCheckAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsCruise }
     * 
     */
    public JPSearchSegmentsCruise createJPSearchSegmentsCruise() {
        return new JPSearchSegmentsCruise();
    }

    /**
     * Create an instance of {@link JPFareGroup }
     * 
     */
    public JPFareGroup createJPFareGroup() {
        return new JPFareGroup();
    }

    /**
     * Create an instance of {@link JPPackageCheckAvailAdvancedOptions }
     * 
     */
    public JPPackageCheckAvailAdvancedOptions createJPPackageCheckAvailAdvancedOptions() {
        return new JPPackageCheckAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPSegmentHotel }
     * 
     */
    public JPSegmentHotel createJPSegmentHotel() {
        return new JPSegmentHotel();
    }

    /**
     * Create an instance of {@link ArrayOfJPInternalSupplier1 }
     * 
     */
    public ArrayOfJPInternalSupplier1 createArrayOfJPInternalSupplier1() {
        return new ArrayOfJPInternalSupplier1();
    }

    /**
     * Create an instance of {@link JPGenericCatalogueItem }
     * 
     */
    public JPGenericCatalogueItem createJPGenericCatalogueItem() {
        return new JPGenericCatalogueItem();
    }

    /**
     * Create an instance of {@link JPCreditCard }
     * 
     */
    public JPCreditCard createJPCreditCard() {
        return new JPCreditCard();
    }

    /**
     * Create an instance of {@link JPSearchPreSegmentsCruise }
     * 
     */
    public JPSearchPreSegmentsCruise createJPSearchPreSegmentsCruise() {
        return new JPSearchPreSegmentsCruise();
    }

    /**
     * Create an instance of {@link JPSOAPIdName }
     * 
     */
    public JPSOAPIdName createJPSOAPIdName() {
        return new JPSOAPIdName();
    }

    /**
     * Create an instance of {@link ArrayOfJPCityComplex }
     * 
     */
    public ArrayOfJPCityComplex createArrayOfJPCityComplex() {
        return new ArrayOfJPCityComplex();
    }

    /**
     * Create an instance of {@link JPFinalCustomerData }
     * 
     */
    public JPFinalCustomerData createJPFinalCustomerData() {
        return new JPFinalCustomerData();
    }

    /**
     * Create an instance of {@link JPPackageInsurance }
     * 
     */
    public JPPackageInsurance createJPPackageInsurance() {
        return new JPPackageInsurance();
    }

    /**
     * Create an instance of {@link JPTransferCheckAvailResult }
     * 
     */
    public JPTransferCheckAvailResult createJPTransferCheckAvailResult() {
        return new JPTransferCheckAvailResult();
    }

    /**
     * Create an instance of {@link JPFlightRate }
     * 
     */
    public JPFlightRate createJPFlightRate() {
        return new JPFlightRate();
    }

    /**
     * Create an instance of {@link JPTransferBookingRuleRequest }
     * 
     */
    public JPTransferBookingRuleRequest createJPTransferBookingRuleRequest() {
        return new JPTransferBookingRuleRequest();
    }

    /**
     * Create an instance of {@link JPPackageChangeProductRequest }
     * 
     */
    public JPPackageChangeProductRequest createJPPackageChangeProductRequest() {
        return new JPPackageChangeProductRequest();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPPickUpPoint }
     * 
     */
    public ArrayOfJPSOAPPickUpPoint createArrayOfJPSOAPPickUpPoint() {
        return new ArrayOfJPSOAPPickUpPoint();
    }

    /**
     * Create an instance of {@link ArrayOfJPRentacarLocationSimpleInfo }
     * 
     */
    public ArrayOfJPRentacarLocationSimpleInfo createArrayOfJPRentacarLocationSimpleInfo() {
        return new ArrayOfJPRentacarLocationSimpleInfo();
    }

    /**
     * Create an instance of {@link JPSearchSegmentFlight }
     * 
     */
    public JPSearchSegmentFlight createJPSearchSegmentFlight() {
        return new JPSearchSegmentFlight();
    }

    /**
     * Create an instance of {@link JPSOAPContractRestrictions }
     * 
     */
    public JPSOAPContractRestrictions createJPSOAPContractRestrictions() {
        return new JPSOAPContractRestrictions();
    }

    /**
     * Create an instance of {@link JPPackageCalendarPriceParameter }
     * 
     */
    public JPPackageCalendarPriceParameter createJPPackageCalendarPriceParameter() {
        return new JPPackageCalendarPriceParameter();
    }

    /**
     * Create an instance of {@link JPSOAPDateIntervalsGroups }
     * 
     */
    public JPSOAPDateIntervalsGroups createJPSOAPDateIntervalsGroups() {
        return new JPSOAPDateIntervalsGroups();
    }

    /**
     * Create an instance of {@link JPSOAPHotelAvailStopSale }
     * 
     */
    public JPSOAPHotelAvailStopSale createJPSOAPHotelAvailStopSale() {
        return new JPSOAPHotelAvailStopSale();
    }

    /**
     * Create an instance of {@link JPItemBreakdown }
     * 
     */
    public JPItemBreakdown createJPItemBreakdown() {
        return new JPItemBreakdown();
    }

    /**
     * Create an instance of {@link ArrayOfJPMeetingPoint }
     * 
     */
    public ArrayOfJPMeetingPoint createArrayOfJPMeetingPoint() {
        return new ArrayOfJPMeetingPoint();
    }

    /**
     * Create an instance of {@link ArrayOfJPFareGroupPriceApplication }
     * 
     */
    public ArrayOfJPFareGroupPriceApplication createArrayOfJPFareGroupPriceApplication() {
        return new ArrayOfJPFareGroupPriceApplication();
    }

    /**
     * Create an instance of {@link JPServiceContract }
     * 
     */
    public JPServiceContract createJPServiceContract() {
        return new JPServiceContract();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanRestriction }
     * 
     */
    public JPSOAPHotelRatePlanRestriction createJPSOAPHotelRatePlanRestriction() {
        return new JPSOAPHotelRatePlanRestriction();
    }

    /**
     * Create an instance of {@link JPRoutes }
     * 
     */
    public JPRoutes createJPRoutes() {
        return new JPRoutes();
    }

    /**
     * Create an instance of {@link ArrayOfJPBoard }
     * 
     */
    public ArrayOfJPBoard createArrayOfJPBoard() {
        return new ArrayOfJPBoard();
    }

    /**
     * Create an instance of {@link ArrayOfJPConceptBreakdown }
     * 
     */
    public ArrayOfJPConceptBreakdown createArrayOfJPConceptBreakdown() {
        return new ArrayOfJPConceptBreakdown();
    }

    /**
     * Create an instance of {@link JPVisaOption }
     * 
     */
    public JPVisaOption createJPVisaOption() {
        return new JPVisaOption();
    }

    /**
     * Create an instance of {@link JPRentacarAvailAdvancedOptions }
     * 
     */
    public JPRentacarAvailAdvancedOptions createJPRentacarAvailAdvancedOptions() {
        return new JPRentacarAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseSegment }
     * 
     */
    public ArrayOfJPCruiseSegment createArrayOfJPCruiseSegment() {
        return new ArrayOfJPCruiseSegment();
    }

    /**
     * Create an instance of {@link ArrayOfJPProductType }
     * 
     */
    public ArrayOfJPProductType createArrayOfJPProductType() {
        return new ArrayOfJPProductType();
    }

    /**
     * Create an instance of {@link JPServiceRequest }
     * 
     */
    public JPServiceRequest createJPServiceRequest() {
        return new JPServiceRequest();
    }

    /**
     * Create an instance of {@link JPHotelBookingRulesRequest }
     * 
     */
    public JPHotelBookingRulesRequest createJPHotelBookingRulesRequest() {
        return new JPHotelBookingRulesRequest();
    }

    /**
     * Create an instance of {@link JPFlightAvailAdvancedOptions }
     * 
     */
    public JPFlightAvailAdvancedOptions createJPFlightAvailAdvancedOptions() {
        return new JPFlightAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPPackageItem }
     * 
     */
    public JPPackageItem createJPPackageItem() {
        return new JPPackageItem();
    }

    /**
     * Create an instance of {@link JPAirline }
     * 
     */
    public JPAirline createJPAirline() {
        return new JPAirline();
    }

    /**
     * Create an instance of {@link JPMultiLanguageText }
     * 
     */
    public JPMultiLanguageText createJPMultiLanguageText() {
        return new JPMultiLanguageText();
    }

    /**
     * Create an instance of {@link JPSOAPIdTypeName }
     * 
     */
    public JPSOAPIdTypeName createJPSOAPIdTypeName() {
        return new JPSOAPIdTypeName();
    }

    /**
     * Create an instance of {@link ArrayOfJPInternalSupplier2 }
     * 
     */
    public ArrayOfJPInternalSupplier2 createArrayOfJPInternalSupplier2() {
        return new ArrayOfJPInternalSupplier2();
    }

    /**
     * Create an instance of {@link JPFlightCheckAvailRequest }
     * 
     */
    public JPFlightCheckAvailRequest createJPFlightCheckAvailRequest() {
        return new JPFlightCheckAvailRequest();
    }

    /**
     * Create an instance of {@link JPSOAPImage }
     * 
     */
    public JPSOAPImage createJPSOAPImage() {
        return new JPSOAPImage();
    }

    /**
     * Create an instance of {@link ArrayOfJPServiceCategory }
     * 
     */
    public ArrayOfJPServiceCategory createArrayOfJPServiceCategory() {
        return new ArrayOfJPServiceCategory();
    }

    /**
     * Create an instance of {@link JPRentacarCheckAvailAdvancedOptions }
     * 
     */
    public JPRentacarCheckAvailAdvancedOptions createJPRentacarCheckAvailAdvancedOptions() {
        return new JPRentacarCheckAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsVisa }
     * 
     */
    public JPSearchSegmentsVisa createJPSearchSegmentsVisa() {
        return new JPSearchSegmentsVisa();
    }

    /**
     * Create an instance of {@link ArrayOfJPMeetingPointsZone }
     * 
     */
    public ArrayOfJPMeetingPointsZone createArrayOfJPMeetingPointsZone() {
        return new ArrayOfJPMeetingPointsZone();
    }

    /**
     * Create an instance of {@link JPCruiseStation }
     * 
     */
    public JPCruiseStation createJPCruiseStation() {
        return new JPCruiseStation();
    }

    /**
     * Create an instance of {@link JPCruiseRequest }
     * 
     */
    public JPCruiseRequest createJPCruiseRequest() {
        return new JPCruiseRequest();
    }

    /**
     * Create an instance of {@link JPHotelRatesRequest }
     * 
     */
    public JPHotelRatesRequest createJPHotelRatesRequest() {
        return new JPHotelRatesRequest();
    }

    /**
     * Create an instance of {@link JPOverview }
     * 
     */
    public JPOverview createJPOverview() {
        return new JPOverview();
    }

    /**
     * Create an instance of {@link JPHotelOptionCheckAvail }
     * 
     */
    public JPHotelOptionCheckAvail createJPHotelOptionCheckAvail() {
        return new JPHotelOptionCheckAvail();
    }

    /**
     * Create an instance of {@link JPSearchSegmentInsurance }
     * 
     */
    public JPSearchSegmentInsurance createJPSearchSegmentInsurance() {
        return new JPSearchSegmentInsurance();
    }

    /**
     * Create an instance of {@link JPSOAPDateIntervalsGroupsStayDates }
     * 
     */
    public JPSOAPDateIntervalsGroupsStayDates createJPSOAPDateIntervalsGroupsStayDates() {
        return new JPSOAPDateIntervalsGroupsStayDates();
    }

    /**
     * Create an instance of {@link JPHandlingFees }
     * 
     */
    public JPHandlingFees createJPHandlingFees() {
        return new JPHandlingFees();
    }

    /**
     * Create an instance of {@link JPRentacarRequestCheckAvailOption }
     * 
     */
    public JPRentacarRequestCheckAvailOption createJPRentacarRequestCheckAvailOption() {
        return new JPRentacarRequestCheckAvailOption();
    }

    /**
     * Create an instance of {@link JPTour }
     * 
     */
    public JPTour createJPTour() {
        return new JPTour();
    }

    /**
     * Create an instance of {@link JPServiceTaxes }
     * 
     */
    public JPServiceTaxes createJPServiceTaxes() {
        return new JPServiceTaxes();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsPackages }
     * 
     */
    public JPSearchSegmentsPackages createJPSearchSegmentsPackages() {
        return new JPSearchSegmentsPackages();
    }

    /**
     * Create an instance of {@link JPHotelListInventoryRequest }
     * 
     */
    public JPHotelListInventoryRequest createJPHotelListInventoryRequest() {
        return new JPHotelListInventoryRequest();
    }

    /**
     * Create an instance of {@link JPSOAPPrice }
     * 
     */
    public JPSOAPPrice createJPSOAPPrice() {
        return new JPSOAPPrice();
    }

    /**
     * Create an instance of {@link JPPackageBookingAdvancedOptions }
     * 
     */
    public JPPackageBookingAdvancedOptions createJPPackageBookingAdvancedOptions() {
        return new JPPackageBookingAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPUserPermission }
     * 
     */
    public JPUserPermission createJPUserPermission() {
        return new JPUserPermission();
    }

    /**
     * Create an instance of {@link ArrayOfJPRentacarLocationDetail }
     * 
     */
    public ArrayOfJPRentacarLocationDetail createArrayOfJPRentacarLocationDetail() {
        return new ArrayOfJPRentacarLocationDetail();
    }

    /**
     * Create an instance of {@link JPImageLong }
     * 
     */
    public JPImageLong createJPImageLong() {
        return new JPImageLong();
    }

    /**
     * Create an instance of {@link ArrayOfJPWarningDate }
     * 
     */
    public ArrayOfJPWarningDate createArrayOfJPWarningDate() {
        return new ArrayOfJPWarningDate();
    }

    /**
     * Create an instance of {@link ArrayOfJPOrigin }
     * 
     */
    public ArrayOfJPOrigin createArrayOfJPOrigin() {
        return new ArrayOfJPOrigin();
    }

    /**
     * Create an instance of {@link JPRentacarCheckAvailOption }
     * 
     */
    public JPRentacarCheckAvailOption createJPRentacarCheckAvailOption() {
        return new JPRentacarCheckAvailOption();
    }

    /**
     * Create an instance of {@link JPDocument }
     * 
     */
    public JPDocument createJPDocument() {
        return new JPDocument();
    }

    /**
     * Create an instance of {@link JPPackageCalendarPriceItems }
     * 
     */
    public JPPackageCalendarPriceItems createJPPackageCalendarPriceItems() {
        return new JPPackageCalendarPriceItems();
    }

    /**
     * Create an instance of {@link JPShip }
     * 
     */
    public JPShip createJPShip() {
        return new JPShip();
    }

    /**
     * Create an instance of {@link JPSearchSegmentServices }
     * 
     */
    public JPSearchSegmentServices createJPSearchSegmentServices() {
        return new JPSearchSegmentServices();
    }

    /**
     * Create an instance of {@link JPCruiseElement }
     * 
     */
    public JPCruiseElement createJPCruiseElement() {
        return new JPCruiseElement();
    }

    /**
     * Create an instance of {@link JPBookingCode }
     * 
     */
    public JPBookingCode createJPBookingCode() {
        return new JPBookingCode();
    }

    /**
     * Create an instance of {@link JPVisaElements }
     * 
     */
    public JPVisaElements createJPVisaElements() {
        return new JPVisaElements();
    }

    /**
     * Create an instance of {@link JPSpecialSupplementType }
     * 
     */
    public JPSpecialSupplementType createJPSpecialSupplementType() {
        return new JPSpecialSupplementType();
    }

    /**
     * Create an instance of {@link ArrayOfJPFlightRule }
     * 
     */
    public ArrayOfJPFlightRule createArrayOfJPFlightRule() {
        return new ArrayOfJPFlightRule();
    }

    /**
     * Create an instance of {@link JPInsuranceItem }
     * 
     */
    public JPInsuranceItem createJPInsuranceItem() {
        return new JPInsuranceItem();
    }

    /**
     * Create an instance of {@link JPSOAPHotelInventoryContactInfo }
     * 
     */
    public JPSOAPHotelInventoryContactInfo createJPSOAPHotelInventoryContactInfo() {
        return new JPSOAPHotelInventoryContactInfo();
    }

    /**
     * Create an instance of {@link JPVisaRuleOptionRQ }
     * 
     */
    public JPVisaRuleOptionRQ createJPVisaRuleOptionRQ() {
        return new JPVisaRuleOptionRQ();
    }

    /**
     * Create an instance of {@link JPCruisesBookingRulesRequest }
     * 
     */
    public JPCruisesBookingRulesRequest createJPCruisesBookingRulesRequest() {
        return new JPCruisesBookingRulesRequest();
    }

    /**
     * Create an instance of {@link JPRestrictedOption }
     * 
     */
    public JPRestrictedOption createJPRestrictedOption() {
        return new JPRestrictedOption();
    }

    /**
     * Create an instance of {@link JPTransferByHotelElement }
     * 
     */
    public JPTransferByHotelElement createJPTransferByHotelElement() {
        return new JPTransferByHotelElement();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelSimpleContent }
     * 
     */
    public ArrayOfJPHotelSimpleContent createArrayOfJPHotelSimpleContent() {
        return new ArrayOfJPHotelSimpleContent();
    }

    /**
     * Create an instance of {@link ArrayOfJPServiceType }
     * 
     */
    public ArrayOfJPServiceType createArrayOfJPServiceType() {
        return new ArrayOfJPServiceType();
    }

    /**
     * Create an instance of {@link JPHotelAvailAdvancedOptions }
     * 
     */
    public JPHotelAvailAdvancedOptions createJPHotelAvailAdvancedOptions() {
        return new JPHotelAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link ArrayOfJPCompartment }
     * 
     */
    public ArrayOfJPCompartment createArrayOfJPCompartment() {
        return new ArrayOfJPCompartment();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseItinerary }
     * 
     */
    public ArrayOfJPCruiseItinerary createArrayOfJPCruiseItinerary() {
        return new ArrayOfJPCruiseItinerary();
    }

    /**
     * Create an instance of {@link JPSOAPLengthOfStay }
     * 
     */
    public JPSOAPLengthOfStay createJPSOAPLengthOfStay() {
        return new JPSOAPLengthOfStay();
    }

    /**
     * Create an instance of {@link JPCruiseList }
     * 
     */
    public JPCruiseList createJPCruiseList() {
        return new JPCruiseList();
    }

    /**
     * Create an instance of {@link JPVisaRequest }
     * 
     */
    public JPVisaRequest createJPVisaRequest() {
        return new JPVisaRequest();
    }

    /**
     * Create an instance of {@link JPPackageContent }
     * 
     */
    public JPPackageContent createJPPackageContent() {
        return new JPPackageContent();
    }

    /**
     * Create an instance of {@link JPRefund }
     * 
     */
    public JPRefund createJPRefund() {
        return new JPRefund();
    }

    /**
     * Create an instance of {@link JPHotelItemStaticData }
     * 
     */
    public JPHotelItemStaticData createJPHotelItemStaticData() {
        return new JPHotelItemStaticData();
    }

    /**
     * Create an instance of {@link ArrayOfJPPropertyType }
     * 
     */
    public ArrayOfJPPropertyType createArrayOfJPPropertyType() {
        return new ArrayOfJPPropertyType();
    }

    /**
     * Create an instance of {@link JPHotelFutureRatesResult }
     * 
     */
    public JPHotelFutureRatesResult createJPHotelFutureRatesResult() {
        return new JPHotelFutureRatesResult();
    }

    /**
     * Create an instance of {@link ArrayOfJPCommonPriceBreakdown }
     * 
     */
    public ArrayOfJPCommonPriceBreakdown createArrayOfJPCommonPriceBreakdown() {
        return new ArrayOfJPCommonPriceBreakdown();
    }

    /**
     * Create an instance of {@link JPVisaElement }
     * 
     */
    public JPVisaElement createJPVisaElement() {
        return new JPVisaElement();
    }

    /**
     * Create an instance of {@link JPInsuranceElements }
     * 
     */
    public JPInsuranceElements createJPInsuranceElements() {
        return new JPInsuranceElements();
    }

    /**
     * Create an instance of {@link JPRentacarCheckAvailRequest }
     * 
     */
    public JPRentacarCheckAvailRequest createJPRentacarCheckAvailRequest() {
        return new JPRentacarCheckAvailRequest();
    }

    /**
     * Create an instance of {@link JPFlightInfoService }
     * 
     */
    public JPFlightInfoService createJPFlightInfoService() {
        return new JPFlightInfoService();
    }

    /**
     * Create an instance of {@link ArrayOfJPCard }
     * 
     */
    public ArrayOfJPCard createArrayOfJPCard() {
        return new ArrayOfJPCard();
    }

    /**
     * Create an instance of {@link JPHotelConfirmElement }
     * 
     */
    public JPHotelConfirmElement createJPHotelConfirmElement() {
        return new JPHotelConfirmElement();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelRatePlanCancellationPolicy }
     * 
     */
    public ArrayOfJPSOAPHotelRatePlanCancellationPolicy createArrayOfJPSOAPHotelRatePlanCancellationPolicy() {
        return new ArrayOfJPSOAPHotelRatePlanCancellationPolicy();
    }

    /**
     * Create an instance of {@link JPInsuranceCheckAvailResult }
     * 
     */
    public JPInsuranceCheckAvailResult createJPInsuranceCheckAvailResult() {
        return new JPInsuranceCheckAvailResult();
    }

    /**
     * Create an instance of {@link JPCountry }
     * 
     */
    public JPCountry createJPCountry() {
        return new JPCountry();
    }

    /**
     * Create an instance of {@link JPItems }
     * 
     */
    public JPItems createJPItems() {
        return new JPItems();
    }

    /**
     * Create an instance of {@link JPCruiseServices }
     * 
     */
    public JPCruiseServices createJPCruiseServices() {
        return new JPCruiseServices();
    }

    /**
     * Create an instance of {@link JPOptionalElements }
     * 
     */
    public JPOptionalElements createJPOptionalElements() {
        return new JPOptionalElements();
    }

    /**
     * Create an instance of {@link JPSearchSegmentTransfers }
     * 
     */
    public JPSearchSegmentTransfers createJPSearchSegmentTransfers() {
        return new JPSearchSegmentTransfers();
    }

    /**
     * Create an instance of {@link JPSOAPHotelInventoryRoomType }
     * 
     */
    public JPSOAPHotelInventoryRoomType createJPSOAPHotelInventoryRoomType() {
        return new JPSOAPHotelInventoryRoomType();
    }

    /**
     * Create an instance of {@link JPSOAPOccupancy }
     * 
     */
    public JPSOAPOccupancy createJPSOAPOccupancy() {
        return new JPSOAPOccupancy();
    }

    /**
     * Create an instance of {@link JPHotelRoomSize }
     * 
     */
    public JPHotelRoomSize createJPHotelRoomSize() {
        return new JPHotelRoomSize();
    }

    /**
     * Create an instance of {@link JPRentacarRulesResult }
     * 
     */
    public JPRentacarRulesResult createJPRentacarRulesResult() {
        return new JPRentacarRulesResult();
    }

    /**
     * Create an instance of {@link JPCruiseCheckAvailAdvancedOptions }
     * 
     */
    public JPCruiseCheckAvailAdvancedOptions createJPCruiseCheckAvailAdvancedOptions() {
        return new JPCruiseCheckAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link ArrayOfJPRentacarSupplier }
     * 
     */
    public ArrayOfJPRentacarSupplier createArrayOfJPRentacarSupplier() {
        return new ArrayOfJPRentacarSupplier();
    }

    /**
     * Create an instance of {@link JPGroupDetail }
     * 
     */
    public JPGroupDetail createJPGroupDetail() {
        return new JPGroupDetail();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelRatePlanOffer }
     * 
     */
    public ArrayOfJPSOAPHotelRatePlanOffer createArrayOfJPSOAPHotelRatePlanOffer() {
        return new ArrayOfJPSOAPHotelRatePlanOffer();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelAvailStopSale }
     * 
     */
    public ArrayOfJPSOAPHotelAvailStopSale createArrayOfJPSOAPHotelAvailStopSale() {
        return new ArrayOfJPSOAPHotelAvailStopSale();
    }

    /**
     * Create an instance of {@link JPSeatingMap }
     * 
     */
    public JPSeatingMap createJPSeatingMap() {
        return new JPSeatingMap();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackageDate }
     * 
     */
    public ArrayOfJPPackageDate createArrayOfJPPackageDate() {
        return new ArrayOfJPPackageDate();
    }

    /**
     * Create an instance of {@link JPSearchSegmentRentacar }
     * 
     */
    public JPSearchSegmentRentacar createJPSearchSegmentRentacar() {
        return new JPSearchSegmentRentacar();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelElement }
     * 
     */
    public ArrayOfJPHotelElement createArrayOfJPHotelElement() {
        return new ArrayOfJPHotelElement();
    }

    /**
     * Create an instance of {@link JPTransferBookingRules }
     * 
     */
    public JPTransferBookingRules createJPTransferBookingRules() {
        return new JPTransferBookingRules();
    }

    /**
     * Create an instance of {@link JPCommonPriceBreakdown }
     * 
     */
    public JPCommonPriceBreakdown createJPCommonPriceBreakdown() {
        return new JPCommonPriceBreakdown();
    }

    /**
     * Create an instance of {@link JPRentacarContract }
     * 
     */
    public JPRentacarContract createJPRentacarContract() {
        return new JPRentacarContract();
    }

    /**
     * Create an instance of {@link JPHotelRequiredFields }
     * 
     */
    public JPHotelRequiredFields createJPHotelRequiredFields() {
        return new JPHotelRequiredFields();
    }

    /**
     * Create an instance of {@link JPPackageAdditionalElement }
     * 
     */
    public JPPackageAdditionalElement createJPPackageAdditionalElement() {
        return new JPPackageAdditionalElement();
    }

    /**
     * Create an instance of {@link JPCruiseOptionalElements }
     * 
     */
    public JPCruiseOptionalElements createJPCruiseOptionalElements() {
        return new JPCruiseOptionalElements();
    }

    /**
     * Create an instance of {@link JPPaxSeat }
     * 
     */
    public JPPaxSeat createJPPaxSeat() {
        return new JPPaxSeat();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsHotelFutureRates }
     * 
     */
    public JPSearchSegmentsHotelFutureRates createJPSearchSegmentsHotelFutureRates() {
        return new JPSearchSegmentsHotelFutureRates();
    }

    /**
     * Create an instance of {@link ArrayOfJPExtendedRelPaxBag }
     * 
     */
    public ArrayOfJPExtendedRelPaxBag createArrayOfJPExtendedRelPaxBag() {
        return new ArrayOfJPExtendedRelPaxBag();
    }

    /**
     * Create an instance of {@link JPHotelAllotmentRS }
     * 
     */
    public JPHotelAllotmentRS createJPHotelAllotmentRS() {
        return new JPHotelAllotmentRS();
    }

    /**
     * Create an instance of {@link JPRentacarRequestBookingRulesOption }
     * 
     */
    public JPRentacarRequestBookingRulesOption createJPRentacarRequestBookingRulesOption() {
        return new JPRentacarRequestBookingRulesOption();
    }

    /**
     * Create an instance of {@link JPFax }
     * 
     */
    public JPFax createJPFax() {
        return new JPFax();
    }

    /**
     * Create an instance of {@link ArrayOfJPServiceOption }
     * 
     */
    public ArrayOfJPServiceOption createArrayOfJPServiceOption() {
        return new ArrayOfJPServiceOption();
    }

    /**
     * Create an instance of {@link JPPackageDailyProductType }
     * 
     */
    public JPPackageDailyProductType createJPPackageDailyProductType() {
        return new JPPackageDailyProductType();
    }

    /**
     * Create an instance of {@link JPFutureRatesResultInfo }
     * 
     */
    public JPFutureRatesResultInfo createJPFutureRatesResultInfo() {
        return new JPFutureRatesResultInfo();
    }

    /**
     * Create an instance of {@link JPFlightSupplement }
     * 
     */
    public JPFlightSupplement createJPFlightSupplement() {
        return new JPFlightSupplement();
    }

    /**
     * Create an instance of {@link JPCruisePriceInformation }
     * 
     */
    public JPCruisePriceInformation createJPCruisePriceInformation() {
        return new JPCruisePriceInformation();
    }

    /**
     * Create an instance of {@link JPHotelRoomContract }
     * 
     */
    public JPHotelRoomContract createJPHotelRoomContract() {
        return new JPHotelRoomContract();
    }

    /**
     * Create an instance of {@link JPBoard }
     * 
     */
    public JPBoard createJPBoard() {
        return new JPBoard();
    }

    /**
     * Create an instance of {@link JPSOAPStayRestrictions }
     * 
     */
    public JPSOAPStayRestrictions createJPSOAPStayRestrictions() {
        return new JPSOAPStayRestrictions();
    }

    /**
     * Create an instance of {@link ArrayOfInt }
     * 
     */
    public ArrayOfInt createArrayOfInt() {
        return new ArrayOfInt();
    }

    /**
     * Create an instance of {@link ArrayOfJPInternalSupplier }
     * 
     */
    public ArrayOfJPInternalSupplier createArrayOfJPInternalSupplier() {
        return new ArrayOfJPInternalSupplier();
    }

    /**
     * Create an instance of {@link JPPackageOptionRQ }
     * 
     */
    public JPPackageOptionRQ createJPPackageOptionRQ() {
        return new JPPackageOptionRQ();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanFreeNightsOffer }
     * 
     */
    public JPSOAPHotelRatePlanFreeNightsOffer createJPSOAPHotelRatePlanFreeNightsOffer() {
        return new JPSOAPHotelRatePlanFreeNightsOffer();
    }

    /**
     * Create an instance of {@link JPSOAPRateDiscounts }
     * 
     */
    public JPSOAPRateDiscounts createJPSOAPRateDiscounts() {
        return new JPSOAPRateDiscounts();
    }

    /**
     * Create an instance of {@link JPPaxes }
     * 
     */
    public JPPaxes createJPPaxes() {
        return new JPPaxes();
    }

    /**
     * Create an instance of {@link JPHotelResult }
     * 
     */
    public JPHotelResult createJPHotelResult() {
        return new JPHotelResult();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPImage }
     * 
     */
    public ArrayOfJPSOAPImage createArrayOfJPSOAPImage() {
        return new ArrayOfJPSOAPImage();
    }

    /**
     * Create an instance of {@link ArrayOfJPTour }
     * 
     */
    public ArrayOfJPTour createArrayOfJPTour() {
        return new ArrayOfJPTour();
    }

    /**
     * Create an instance of {@link ArrayOfJPEquipment }
     * 
     */
    public ArrayOfJPEquipment createArrayOfJPEquipment() {
        return new ArrayOfJPEquipment();
    }

    /**
     * Create an instance of {@link ArrayOfJPRelPaxDist }
     * 
     */
    public ArrayOfJPRelPaxDist createArrayOfJPRelPaxDist() {
        return new ArrayOfJPRelPaxDist();
    }

    /**
     * Create an instance of {@link JPHotelPreference }
     * 
     */
    public JPHotelPreference createJPHotelPreference() {
        return new JPHotelPreference();
    }

    /**
     * Create an instance of {@link JPInventory }
     * 
     */
    public JPInventory createJPInventory() {
        return new JPInventory();
    }

    /**
     * Create an instance of {@link JPLogin }
     * 
     */
    public JPLogin createJPLogin() {
        return new JPLogin();
    }

    /**
     * Create an instance of {@link JPShoppingBasketItems }
     * 
     */
    public JPShoppingBasketItems createJPShoppingBasketItems() {
        return new JPShoppingBasketItems();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackageInfoAFIPAmount }
     * 
     */
    public ArrayOfJPPackageInfoAFIPAmount createArrayOfJPPackageInfoAFIPAmount() {
        return new ArrayOfJPPackageInfoAFIPAmount();
    }

    /**
     * Create an instance of {@link JPPackageListRequest }
     * 
     */
    public JPPackageListRequest createJPPackageListRequest() {
        return new JPPackageListRequest();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelAvailAllotment }
     * 
     */
    public ArrayOfJPSOAPHotelAvailAllotment createArrayOfJPSOAPHotelAvailAllotment() {
        return new ArrayOfJPSOAPHotelAvailAllotment();
    }

    /**
     * Create an instance of {@link JPFlightAssignSeats }
     * 
     */
    public JPFlightAssignSeats createJPFlightAssignSeats() {
        return new JPFlightAssignSeats();
    }

    /**
     * Create an instance of {@link JPDiscount }
     * 
     */
    public JPDiscount createJPDiscount() {
        return new JPDiscount();
    }

    /**
     * Create an instance of {@link JPVisaBookingRules }
     * 
     */
    public JPVisaBookingRules createJPVisaBookingRules() {
        return new JPVisaBookingRules();
    }

    /**
     * Create an instance of {@link ArrayOfJPShip }
     * 
     */
    public ArrayOfJPShip createArrayOfJPShip() {
        return new ArrayOfJPShip();
    }

    /**
     * Create an instance of {@link ArrayOfJPInsuranceRelPaxDist }
     * 
     */
    public ArrayOfJPInsuranceRelPaxDist createArrayOfJPInsuranceRelPaxDist() {
        return new ArrayOfJPInsuranceRelPaxDist();
    }

    /**
     * Create an instance of {@link JPCruiseCabin }
     * 
     */
    public JPCruiseCabin createJPCruiseCabin() {
        return new JPCruiseCabin();
    }

    /**
     * Create an instance of {@link JPRentacarBookingRulesAdvancedOptions }
     * 
     */
    public JPRentacarBookingRulesAdvancedOptions createJPRentacarBookingRulesAdvancedOptions() {
        return new JPRentacarBookingRulesAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPPropertyType }
     * 
     */
    public JPPropertyType createJPPropertyType() {
        return new JPPropertyType();
    }

    /**
     * Create an instance of {@link ArrayOfJPFareGroupType }
     * 
     */
    public ArrayOfJPFareGroupType createArrayOfJPFareGroupType() {
        return new ArrayOfJPFareGroupType();
    }

    /**
     * Create an instance of {@link JPCancellationPolicyRules }
     * 
     */
    public JPCancellationPolicyRules createJPCancellationPolicyRules() {
        return new JPCancellationPolicyRules();
    }

    /**
     * Create an instance of {@link ArrayOfInt1 }
     * 
     */
    public ArrayOfInt1 createArrayOfInt1() {
        return new ArrayOfInt1();
    }

    /**
     * Create an instance of {@link ArrayOfJPExtendedRelPax }
     * 
     */
    public ArrayOfJPExtendedRelPax createArrayOfJPExtendedRelPax() {
        return new ArrayOfJPExtendedRelPax();
    }

    /**
     * Create an instance of {@link JPFlightInfo }
     * 
     */
    public JPFlightInfo createJPFlightInfo() {
        return new JPFlightInfo();
    }

    /**
     * Create an instance of {@link JPFinalCustomerContactStaticData }
     * 
     */
    public JPFinalCustomerContactStaticData createJPFinalCustomerContactStaticData() {
        return new JPFinalCustomerContactStaticData();
    }

    /**
     * Create an instance of {@link JPInsuranceAvailAdvancedOptions }
     * 
     */
    public JPInsuranceAvailAdvancedOptions createJPInsuranceAvailAdvancedOptions() {
        return new JPInsuranceAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPPackageResult }
     * 
     */
    public JPPackageResult createJPPackageResult() {
        return new JPPackageResult();
    }

    /**
     * Create an instance of {@link ArrayOfJPPointOfInterest }
     * 
     */
    public ArrayOfJPPointOfInterest createArrayOfJPPointOfInterest() {
        return new ArrayOfJPPointOfInterest();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPDiscount }
     * 
     */
    public ArrayOfJPSOAPDiscount createArrayOfJPSOAPDiscount() {
        return new ArrayOfJPSOAPDiscount();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPContactNumber }
     * 
     */
    public ArrayOfJPSOAPContactNumber createArrayOfJPSOAPContactNumber() {
        return new ArrayOfJPSOAPContactNumber();
    }

    /**
     * Create an instance of {@link JPCard }
     * 
     */
    public JPCard createJPCard() {
        return new JPCard();
    }

    /**
     * Create an instance of {@link JPSOAPOrderedPrice }
     * 
     */
    public JPSOAPOrderedPrice createJPSOAPOrderedPrice() {
        return new JPSOAPOrderedPrice();
    }

    /**
     * Create an instance of {@link ArrayOfJPServiceContract }
     * 
     */
    public ArrayOfJPServiceContract createArrayOfJPServiceContract() {
        return new ArrayOfJPServiceContract();
    }

    /**
     * Create an instance of {@link JPTransferOption }
     * 
     */
    public JPTransferOption createJPTransferOption() {
        return new JPTransferOption();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelAdditionalElement }
     * 
     */
    public ArrayOfJPHotelAdditionalElement createArrayOfJPHotelAdditionalElement() {
        return new ArrayOfJPHotelAdditionalElement();
    }

    /**
     * Create an instance of {@link JPTransferInfo }
     * 
     */
    public JPTransferInfo createJPTransferInfo() {
        return new JPTransferInfo();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanRate }
     * 
     */
    public JPSOAPHotelRatePlanRate createJPSOAPHotelRatePlanRate() {
        return new JPSOAPHotelRatePlanRate();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelAdditionalElement1 }
     * 
     */
    public ArrayOfJPHotelAdditionalElement1 createArrayOfJPHotelAdditionalElement1() {
        return new ArrayOfJPHotelAdditionalElement1();
    }

    /**
     * Create an instance of {@link JPPhoneNumber }
     * 
     */
    public JPPhoneNumber createJPPhoneNumber() {
        return new JPPhoneNumber();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseFlightRoute }
     * 
     */
    public ArrayOfJPCruiseFlightRoute createArrayOfJPCruiseFlightRoute() {
        return new ArrayOfJPCruiseFlightRoute();
    }

    /**
     * Create an instance of {@link JPSOAPDateIntervals }
     * 
     */
    public JPSOAPDateIntervals createJPSOAPDateIntervals() {
        return new JPSOAPDateIntervals();
    }

    /**
     * Create an instance of {@link JPZoneNameByLanguage }
     * 
     */
    public JPZoneNameByLanguage createJPZoneNameByLanguage() {
        return new JPZoneNameByLanguage();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseExtendedRelPax }
     * 
     */
    public ArrayOfJPCruiseExtendedRelPax createArrayOfJPCruiseExtendedRelPax() {
        return new ArrayOfJPCruiseExtendedRelPax();
    }

    /**
     * Create an instance of {@link ArrayOfJPPrice }
     * 
     */
    public ArrayOfJPPrice createArrayOfJPPrice() {
        return new ArrayOfJPPrice();
    }

    /**
     * Create an instance of {@link JPExtendedHotelInfo }
     * 
     */
    public JPExtendedHotelInfo createJPExtendedHotelInfo() {
        return new JPExtendedHotelInfo();
    }

    /**
     * Create an instance of {@link JPFlightPriceInformation }
     * 
     */
    public JPFlightPriceInformation createJPFlightPriceInformation() {
        return new JPFlightPriceInformation();
    }

    /**
     * Create an instance of {@link JPInsuranceCheckAvailRequest }
     * 
     */
    public JPInsuranceCheckAvailRequest createJPInsuranceCheckAvailRequest() {
        return new JPInsuranceCheckAvailRequest();
    }

    /**
     * Create an instance of {@link JPTransferCheckAvailRequest }
     * 
     */
    public JPTransferCheckAvailRequest createJPTransferCheckAvailRequest() {
        return new JPTransferCheckAvailRequest();
    }

    /**
     * Create an instance of {@link JPAgencyStaticData }
     * 
     */
    public JPAgencyStaticData createJPAgencyStaticData() {
        return new JPAgencyStaticData();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelType }
     * 
     */
    public ArrayOfJPHotelType createArrayOfJPHotelType() {
        return new ArrayOfJPHotelType();
    }

    /**
     * Create an instance of {@link JPServicesBookingAdvancedOptions }
     * 
     */
    public JPServicesBookingAdvancedOptions createJPServicesBookingAdvancedOptions() {
        return new JPServicesBookingAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPSOAPAges }
     * 
     */
    public JPSOAPAges createJPSOAPAges() {
        return new JPSOAPAges();
    }

    /**
     * Create an instance of {@link JPInsuranceInfo }
     * 
     */
    public JPInsuranceInfo createJPInsuranceInfo() {
        return new JPInsuranceInfo();
    }

    /**
     * Create an instance of {@link JPFreeNights }
     * 
     */
    public JPFreeNights createJPFreeNights() {
        return new JPFreeNights();
    }

    /**
     * Create an instance of {@link JPShipping }
     * 
     */
    public JPShipping createJPShipping() {
        return new JPShipping();
    }

    /**
     * Create an instance of {@link JPMeetingPointListRequest }
     * 
     */
    public JPMeetingPointListRequest createJPMeetingPointListRequest() {
        return new JPMeetingPointListRequest();
    }

    /**
     * Create an instance of {@link JPTransferOptionRQ }
     * 
     */
    public JPTransferOptionRQ createJPTransferOptionRQ() {
        return new JPTransferOptionRQ();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPOrder }
     * 
     */
    public ArrayOfJPSOAPOrder createArrayOfJPSOAPOrder() {
        return new ArrayOfJPSOAPOrder();
    }

    /**
     * Create an instance of {@link JPCruiseSportServices }
     * 
     */
    public JPCruiseSportServices createJPCruiseSportServices() {
        return new JPCruiseSportServices();
    }

    /**
     * Create an instance of {@link ArrayOfJPFinalCustomerStaticData }
     * 
     */
    public ArrayOfJPFinalCustomerStaticData createArrayOfJPFinalCustomerStaticData() {
        return new ArrayOfJPFinalCustomerStaticData();
    }

    /**
     * Create an instance of {@link JPFlightBookingRulesAdvancedOptions }
     * 
     */
    public JPFlightBookingRulesAdvancedOptions createJPFlightBookingRulesAdvancedOptions() {
        return new JPFlightBookingRulesAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPHotelOptionalElements }
     * 
     */
    public JPHotelOptionalElements createJPHotelOptionalElements() {
        return new JPHotelOptionalElements();
    }

    /**
     * Create an instance of {@link JPSupplierListRequest }
     * 
     */
    public JPSupplierListRequest createJPSupplierListRequest() {
        return new JPSupplierListRequest();
    }

    /**
     * Create an instance of {@link ArrayOfJPVisaOption }
     * 
     */
    public ArrayOfJPVisaOption createArrayOfJPVisaOption() {
        return new ArrayOfJPVisaOption();
    }

    /**
     * Create an instance of {@link JPCarFee }
     * 
     */
    public JPCarFee createJPCarFee() {
        return new JPCarFee();
    }

    /**
     * Create an instance of {@link JPSOAPOccupanciesRules }
     * 
     */
    public JPSOAPOccupanciesRules createJPSOAPOccupanciesRules() {
        return new JPSOAPOccupanciesRules();
    }

    /**
     * Create an instance of {@link ArrayOfJPRouteDispo }
     * 
     */
    public ArrayOfJPRouteDispo createArrayOfJPRouteDispo() {
        return new ArrayOfJPRouteDispo();
    }

    /**
     * Create an instance of {@link JPTransferItem }
     * 
     */
    public JPTransferItem createJPTransferItem() {
        return new JPTransferItem();
    }

    /**
     * Create an instance of {@link JPComment }
     * 
     */
    public JPComment createJPComment() {
        return new JPComment();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPIdName }
     * 
     */
    public ArrayOfJPSOAPIdName createArrayOfJPSOAPIdName() {
        return new ArrayOfJPSOAPIdName();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackageStay }
     * 
     */
    public ArrayOfJPPackageStay createArrayOfJPPackageStay() {
        return new ArrayOfJPPackageStay();
    }

    /**
     * Create an instance of {@link JPVisaCheckAvailResult }
     * 
     */
    public JPVisaCheckAvailResult createJPVisaCheckAvailResult() {
        return new JPVisaCheckAvailResult();
    }

    /**
     * Create an instance of {@link JPZone }
     * 
     */
    public JPZone createJPZone() {
        return new JPZone();
    }

    /**
     * Create an instance of {@link JPInsurancePriceInformation }
     * 
     */
    public JPInsurancePriceInformation createJPInsurancePriceInformation() {
        return new JPInsurancePriceInformation();
    }

    /**
     * Create an instance of {@link JPCancelAdvancedOptions }
     * 
     */
    public JPCancelAdvancedOptions createJPCancelAdvancedOptions() {
        return new JPCancelAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPFlightItem }
     * 
     */
    public JPFlightItem createJPFlightItem() {
        return new JPFlightItem();
    }

    /**
     * Create an instance of {@link JPTicketCommission }
     * 
     */
    public JPTicketCommission createJPTicketCommission() {
        return new JPTicketCommission();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackageInsurance }
     * 
     */
    public ArrayOfJPPackageInsurance createArrayOfJPPackageInsurance() {
        return new ArrayOfJPPackageInsurance();
    }

    /**
     * Create an instance of {@link JPPackageInfoAFIPAmount }
     * 
     */
    public JPPackageInfoAFIPAmount createJPPackageInfoAFIPAmount() {
        return new JPPackageInfoAFIPAmount();
    }

    /**
     * Create an instance of {@link JPShipInfo }
     * 
     */
    public JPShipInfo createJPShipInfo() {
        return new JPShipInfo();
    }

    /**
     * Create an instance of {@link JPPackagesCodeList }
     * 
     */
    public JPPackagesCodeList createJPPackagesCodeList() {
        return new JPPackagesCodeList();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelCategory }
     * 
     */
    public ArrayOfJPHotelCategory createArrayOfJPHotelCategory() {
        return new ArrayOfJPHotelCategory();
    }

    /**
     * Create an instance of {@link ArrayOfJPRequiredField }
     * 
     */
    public ArrayOfJPRequiredField createArrayOfJPRequiredField() {
        return new ArrayOfJPRequiredField();
    }

    /**
     * Create an instance of {@link ArrayOfJPMultimediaContent }
     * 
     */
    public ArrayOfJPMultimediaContent createArrayOfJPMultimediaContent() {
        return new ArrayOfJPMultimediaContent();
    }

    /**
     * Create an instance of {@link JPPaymentReservation }
     * 
     */
    public JPPaymentReservation createJPPaymentReservation() {
        return new JPPaymentReservation();
    }

    /**
     * Create an instance of {@link JPInsuranceResult }
     * 
     */
    public JPInsuranceResult createJPInsuranceResult() {
        return new JPInsuranceResult();
    }

    /**
     * Create an instance of {@link JPServiceType }
     * 
     */
    public JPServiceType createJPServiceType() {
        return new JPServiceType();
    }

    /**
     * Create an instance of {@link JPInsuranceRelPaxDist }
     * 
     */
    public JPInsuranceRelPaxDist createJPInsuranceRelPaxDist() {
        return new JPInsuranceRelPaxDist();
    }

    /**
     * Create an instance of {@link JPItemHotelRoom }
     * 
     */
    public JPItemHotelRoom createJPItemHotelRoom() {
        return new JPItemHotelRoom();
    }

    /**
     * Create an instance of {@link JPRequiredFieldValue }
     * 
     */
    public JPRequiredFieldValue createJPRequiredFieldValue() {
        return new JPRequiredFieldValue();
    }

    /**
     * Create an instance of {@link JPServicesBookingRulesAdvancedOptions }
     * 
     */
    public JPServicesBookingRulesAdvancedOptions createJPServicesBookingRulesAdvancedOptions() {
        return new JPServicesBookingRulesAdvancedOptions();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelRatePlanRate }
     * 
     */
    public ArrayOfJPSOAPHotelRatePlanRate createArrayOfJPSOAPHotelRatePlanRate() {
        return new ArrayOfJPSOAPHotelRatePlanRate();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelInventoryDescription }
     * 
     */
    public ArrayOfJPSOAPHotelInventoryDescription createArrayOfJPSOAPHotelInventoryDescription() {
        return new ArrayOfJPSOAPHotelInventoryDescription();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseComponent }
     * 
     */
    public ArrayOfJPCruiseComponent createArrayOfJPCruiseComponent() {
        return new ArrayOfJPCruiseComponent();
    }

    /**
     * Create an instance of {@link JPServiceCheckAvailResult }
     * 
     */
    public JPServiceCheckAvailResult createJPServiceCheckAvailResult() {
        return new JPServiceCheckAvailResult();
    }

    /**
     * Create an instance of {@link JPHotelBookingRulesAdvancedOptions }
     * 
     */
    public JPHotelBookingRulesAdvancedOptions createJPHotelBookingRulesAdvancedOptions() {
        return new JPHotelBookingRulesAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPVisaItemStaticData }
     * 
     */
    public JPVisaItemStaticData createJPVisaItemStaticData() {
        return new JPVisaItemStaticData();
    }

    /**
     * Create an instance of {@link JPCruiseDataRequest }
     * 
     */
    public JPCruiseDataRequest createJPCruiseDataRequest() {
        return new JPCruiseDataRequest();
    }

    /**
     * Create an instance of {@link JPExtendedRelPaxDist }
     * 
     */
    public JPExtendedRelPaxDist createJPExtendedRelPaxDist() {
        return new JPExtendedRelPaxDist();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelSimpleInfo }
     * 
     */
    public ArrayOfJPHotelSimpleInfo createArrayOfJPHotelSimpleInfo() {
        return new ArrayOfJPHotelSimpleInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelOptionBookingRules }
     * 
     */
    public ArrayOfJPHotelOptionBookingRules createArrayOfJPHotelOptionBookingRules() {
        return new ArrayOfJPHotelOptionBookingRules();
    }

    /**
     * Create an instance of {@link JPPaymentInfo }
     * 
     */
    public JPPaymentInfo createJPPaymentInfo() {
        return new JPPaymentInfo();
    }

    /**
     * Create an instance of {@link JPBag }
     * 
     */
    public JPBag createJPBag() {
        return new JPBag();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPIdTypeIntName }
     * 
     */
    public ArrayOfJPSOAPIdTypeIntName createArrayOfJPSOAPIdTypeIntName() {
        return new ArrayOfJPSOAPIdTypeIntName();
    }

    /**
     * Create an instance of {@link JPHotelChain }
     * 
     */
    public JPHotelChain createJPHotelChain() {
        return new JPHotelChain();
    }

    /**
     * Create an instance of {@link JPHotelItem }
     * 
     */
    public JPHotelItem createJPHotelItem() {
        return new JPHotelItem();
    }

    /**
     * Create an instance of {@link JPCruiseAvailAdvancedOptions }
     * 
     */
    public JPCruiseAvailAdvancedOptions createJPCruiseAvailAdvancedOptions() {
        return new JPCruiseAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link ArrayOfJPRentacarContract }
     * 
     */
    public ArrayOfJPRentacarContract createArrayOfJPRentacarContract() {
        return new ArrayOfJPRentacarContract();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsHotels }
     * 
     */
    public JPSearchSegmentsHotels createJPSearchSegmentsHotels() {
        return new JPSearchSegmentsHotels();
    }

    /**
     * Create an instance of {@link JPRentacarPriceInformation }
     * 
     */
    public JPRentacarPriceInformation createJPRentacarPriceInformation() {
        return new JPRentacarPriceInformation();
    }

    /**
     * Create an instance of {@link JPFlightLocator }
     * 
     */
    public JPFlightLocator createJPFlightLocator() {
        return new JPFlightLocator();
    }

    /**
     * Create an instance of {@link ArrayOfJPRentacarLocationSimpleContent }
     * 
     */
    public ArrayOfJPRentacarLocationSimpleContent createArrayOfJPRentacarLocationSimpleContent() {
        return new ArrayOfJPRentacarLocationSimpleContent();
    }

    /**
     * Create an instance of {@link JPDay }
     * 
     */
    public JPDay createJPDay() {
        return new JPDay();
    }

    /**
     * Create an instance of {@link JPPriceInformationVisa }
     * 
     */
    public JPPriceInformationVisa createJPPriceInformationVisa() {
        return new JPPriceInformationVisa();
    }

    /**
     * Create an instance of {@link JPTicketElement }
     * 
     */
    public JPTicketElement createJPTicketElement() {
        return new JPTicketElement();
    }

    /**
     * Create an instance of {@link JPServiceProduct }
     * 
     */
    public JPServiceProduct createJPServiceProduct() {
        return new JPServiceProduct();
    }

    /**
     * Create an instance of {@link ArrayOfJPErrorType }
     * 
     */
    public ArrayOfJPErrorType createArrayOfJPErrorType() {
        return new ArrayOfJPErrorType();
    }

    /**
     * Create an instance of {@link JPOfferSupplementType }
     * 
     */
    public JPOfferSupplementType createJPOfferSupplementType() {
        return new JPOfferSupplementType();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackageSearcherItem }
     * 
     */
    public ArrayOfJPPackageSearcherItem createArrayOfJPPackageSearcherItem() {
        return new ArrayOfJPPackageSearcherItem();
    }

    /**
     * Create an instance of {@link JPCruiseRequiredFields }
     * 
     */
    public JPCruiseRequiredFields createJPCruiseRequiredFields() {
        return new JPCruiseRequiredFields();
    }

    /**
     * Create an instance of {@link JPPackageList }
     * 
     */
    public JPPackageList createJPPackageList() {
        return new JPPackageList();
    }

    /**
     * Create an instance of {@link JPFlightDiscount }
     * 
     */
    public JPFlightDiscount createJPFlightDiscount() {
        return new JPFlightDiscount();
    }

    /**
     * Create an instance of {@link JPRentacarAdditionalElements }
     * 
     */
    public JPRentacarAdditionalElements createJPRentacarAdditionalElements() {
        return new JPRentacarAdditionalElements();
    }

    /**
     * Create an instance of {@link JPSupplier }
     * 
     */
    public JPSupplier createJPSupplier() {
        return new JPSupplier();
    }

    /**
     * Create an instance of {@link JPCruiseBookingInfo }
     * 
     */
    public JPCruiseBookingInfo createJPCruiseBookingInfo() {
        return new JPCruiseBookingInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPOrder1 }
     * 
     */
    public ArrayOfJPSOAPOrder1 createArrayOfJPSOAPOrder1() {
        return new ArrayOfJPSOAPOrder1();
    }

    /**
     * Create an instance of {@link JPRentacarSaleContract }
     * 
     */
    public JPRentacarSaleContract createJPRentacarSaleContract() {
        return new JPRentacarSaleContract();
    }

    /**
     * Create an instance of {@link JPHotelBookingInfo }
     * 
     */
    public JPHotelBookingInfo createJPHotelBookingInfo() {
        return new JPHotelBookingInfo();
    }

    /**
     * Create an instance of {@link JPGroupFee }
     * 
     */
    public JPGroupFee createJPGroupFee() {
        return new JPGroupFee();
    }

    /**
     * Create an instance of {@link ArrayOfJPRentacarBookingRulesOption }
     * 
     */
    public ArrayOfJPRentacarBookingRulesOption createArrayOfJPRentacarBookingRulesOption() {
        return new ArrayOfJPRentacarBookingRulesOption();
    }

    /**
     * Create an instance of {@link JPHotelContractType }
     * 
     */
    public JPHotelContractType createJPHotelContractType() {
        return new JPHotelContractType();
    }

    /**
     * Create an instance of {@link JPHotelRoomCode }
     * 
     */
    public JPHotelRoomCode createJPHotelRoomCode() {
        return new JPHotelRoomCode();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPEmail }
     * 
     */
    public ArrayOfJPSOAPEmail createArrayOfJPSOAPEmail() {
        return new ArrayOfJPSOAPEmail();
    }

    /**
     * Create an instance of {@link JPHotelCheckAvailRequest }
     * 
     */
    public JPHotelCheckAvailRequest createJPHotelCheckAvailRequest() {
        return new JPHotelCheckAvailRequest();
    }

    /**
     * Create an instance of {@link JPPackageAvailAdvancedOptions }
     * 
     */
    public JPPackageAvailAdvancedOptions createJPPackageAvailAdvancedOptions() {
        return new JPPackageAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link ArrayOfJPRentacarCheckAvailOption }
     * 
     */
    public ArrayOfJPRentacarCheckAvailOption createArrayOfJPRentacarCheckAvailOption() {
        return new ArrayOfJPRentacarCheckAvailOption();
    }

    /**
     * Create an instance of {@link ArrayOfJPFlightSupplement }
     * 
     */
    public ArrayOfJPFlightSupplement createArrayOfJPFlightSupplement() {
        return new ArrayOfJPFlightSupplement();
    }

    /**
     * Create an instance of {@link JPSOAPSuppleOfferPrice }
     * 
     */
    public JPSOAPSuppleOfferPrice createJPSOAPSuppleOfferPrice() {
        return new JPSOAPSuppleOfferPrice();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackageDailyProductType }
     * 
     */
    public ArrayOfJPPackageDailyProductType createArrayOfJPPackageDailyProductType() {
        return new ArrayOfJPPackageDailyProductType();
    }

    /**
     * Create an instance of {@link ArrayOfJPGenericCatalogueItemContent }
     * 
     */
    public ArrayOfJPGenericCatalogueItemContent createArrayOfJPGenericCatalogueItemContent() {
        return new ArrayOfJPGenericCatalogueItemContent();
    }

    /**
     * Create an instance of {@link JPInternalSupplier }
     * 
     */
    public JPInternalSupplier createJPInternalSupplier() {
        return new JPInternalSupplier();
    }

    /**
     * Create an instance of {@link JPCruiseShipRequest }
     * 
     */
    public JPCruiseShipRequest createJPCruiseShipRequest() {
        return new JPCruiseShipRequest();
    }

    /**
     * Create an instance of {@link JPHotelInfo }
     * 
     */
    public JPHotelInfo createJPHotelInfo() {
        return new JPHotelInfo();
    }

    /**
     * Create an instance of {@link JPReadRequest }
     * 
     */
    public JPReadRequest createJPReadRequest() {
        return new JPReadRequest();
    }

    /**
     * Create an instance of {@link JPHotelRelPaxDist }
     * 
     */
    public JPHotelRelPaxDist createJPHotelRelPaxDist() {
        return new JPHotelRelPaxDist();
    }

    /**
     * Create an instance of {@link JPServiceResult }
     * 
     */
    public JPServiceResult createJPServiceResult() {
        return new JPServiceResult();
    }

    /**
     * Create an instance of {@link ArrayOfJPExtendedRelPaxDist }
     * 
     */
    public ArrayOfJPExtendedRelPaxDist createArrayOfJPExtendedRelPaxDist() {
        return new ArrayOfJPExtendedRelPaxDist();
    }

    /**
     * Create an instance of {@link ArrayOfJPZoneInfo }
     * 
     */
    public ArrayOfJPZoneInfo createArrayOfJPZoneInfo() {
        return new ArrayOfJPZoneInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPBag }
     * 
     */
    public ArrayOfJPBag createArrayOfJPBag() {
        return new ArrayOfJPBag();
    }

    /**
     * Create an instance of {@link JPMeetingPoint }
     * 
     */
    public JPMeetingPoint createJPMeetingPoint() {
        return new JPMeetingPoint();
    }

    /**
     * Create an instance of {@link JPGenericCatalogueItemContent }
     * 
     */
    public JPGenericCatalogueItemContent createJPGenericCatalogueItemContent() {
        return new JPGenericCatalogueItemContent();
    }

    /**
     * Create an instance of {@link JPCancelInformation }
     * 
     */
    public JPCancelInformation createJPCancelInformation() {
        return new JPCancelInformation();
    }

    /**
     * Create an instance of {@link JPRoute }
     * 
     */
    public JPRoute createJPRoute() {
        return new JPRoute();
    }

    /**
     * Create an instance of {@link JPSOAPCountryOfResidence }
     * 
     */
    public JPSOAPCountryOfResidence createJPSOAPCountryOfResidence() {
        return new JPSOAPCountryOfResidence();
    }

    /**
     * Create an instance of {@link ArrayOfString9 }
     * 
     */
    public ArrayOfString9 createArrayOfString9() {
        return new ArrayOfString9();
    }

    /**
     * Create an instance of {@link JPFlightBookingRules }
     * 
     */
    public JPFlightBookingRules createJPFlightBookingRules() {
        return new JPFlightBookingRules();
    }

    /**
     * Create an instance of {@link JPRentacarLocationDetail }
     * 
     */
    public JPRentacarLocationDetail createJPRentacarLocationDetail() {
        return new JPRentacarLocationDetail();
    }

    /**
     * Create an instance of {@link ArrayOfString1 }
     * 
     */
    public ArrayOfString1 createArrayOfString1() {
        return new ArrayOfString1();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseFlight }
     * 
     */
    public ArrayOfJPCruiseFlight createArrayOfJPCruiseFlight() {
        return new ArrayOfJPCruiseFlight();
    }

    /**
     * Create an instance of {@link ArrayOfString2 }
     * 
     */
    public ArrayOfString2 createArrayOfString2() {
        return new ArrayOfString2();
    }

    /**
     * Create an instance of {@link ArrayOfString3 }
     * 
     */
    public ArrayOfString3 createArrayOfString3() {
        return new ArrayOfString3();
    }

    /**
     * Create an instance of {@link ArrayOfString4 }
     * 
     */
    public ArrayOfString4 createArrayOfString4() {
        return new ArrayOfString4();
    }

    /**
     * Create an instance of {@link ArrayOfString5 }
     * 
     */
    public ArrayOfString5 createArrayOfString5() {
        return new ArrayOfString5();
    }

    /**
     * Create an instance of {@link ArrayOfString6 }
     * 
     */
    public ArrayOfString6 createArrayOfString6() {
        return new ArrayOfString6();
    }

    /**
     * Create an instance of {@link ArrayOfString7 }
     * 
     */
    public ArrayOfString7 createArrayOfString7() {
        return new ArrayOfString7();
    }

    /**
     * Create an instance of {@link ArrayOfString8 }
     * 
     */
    public ArrayOfString8 createArrayOfString8() {
        return new ArrayOfString8();
    }

    /**
     * Create an instance of {@link JPCruiseResultsBookingRules }
     * 
     */
    public JPCruiseResultsBookingRules createJPCruiseResultsBookingRules() {
        return new JPCruiseResultsBookingRules();
    }

    /**
     * Create an instance of {@link JPTransfer }
     * 
     */
    public JPTransfer createJPTransfer() {
        return new JPTransfer();
    }

    /**
     * Create an instance of {@link JPSearchSegmentHotels }
     * 
     */
    public JPSearchSegmentHotels createJPSearchSegmentHotels() {
        return new JPSearchSegmentHotels();
    }

    /**
     * Create an instance of {@link JPZoneIdName }
     * 
     */
    public JPZoneIdName createJPZoneIdName() {
        return new JPZoneIdName();
    }

    /**
     * Create an instance of {@link JPHotelCalendarResult }
     * 
     */
    public JPHotelCalendarResult createJPHotelCalendarResult() {
        return new JPHotelCalendarResult();
    }

    /**
     * Create an instance of {@link ArrayOfJPSeatEquipment }
     * 
     */
    public ArrayOfJPSeatEquipment createArrayOfJPSeatEquipment() {
        return new ArrayOfJPSeatEquipment();
    }

    /**
     * Create an instance of {@link JPTransferRequestByHotel }
     * 
     */
    public JPTransferRequestByHotel createJPTransferRequestByHotel() {
        return new JPTransferRequestByHotel();
    }

    /**
     * Create an instance of {@link JPHotelInventoryCode }
     * 
     */
    public JPHotelInventoryCode createJPHotelInventoryCode() {
        return new JPHotelInventoryCode();
    }

    /**
     * Create an instance of {@link JPInsuranceOptionRequest }
     * 
     */
    public JPInsuranceOptionRequest createJPInsuranceOptionRequest() {
        return new JPInsuranceOptionRequest();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsRentacarRules }
     * 
     */
    public JPSearchSegmentsRentacarRules createJPSearchSegmentsRentacarRules() {
        return new JPSearchSegmentsRentacarRules();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPOrderedPrice2 }
     * 
     */
    public ArrayOfJPSOAPOrderedPrice2 createArrayOfJPSOAPOrderedPrice2() {
        return new ArrayOfJPSOAPOrderedPrice2();
    }

    /**
     * Create an instance of {@link JPReadAdvancedOptions }
     * 
     */
    public JPReadAdvancedOptions createJPReadAdvancedOptions() {
        return new JPReadAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanBoardUpgradeOffer }
     * 
     */
    public JPSOAPHotelRatePlanBoardUpgradeOffer createJPSOAPHotelRatePlanBoardUpgradeOffer() {
        return new JPSOAPHotelRatePlanBoardUpgradeOffer();
    }

    /**
     * Create an instance of {@link JPRentacarCheckAvailResult }
     * 
     */
    public JPRentacarCheckAvailResult createJPRentacarCheckAvailResult() {
        return new JPRentacarCheckAvailResult();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPOrderedPrice1 }
     * 
     */
    public ArrayOfJPSOAPOrderedPrice1 createArrayOfJPSOAPOrderedPrice1() {
        return new ArrayOfJPSOAPOrderedPrice1();
    }

    /**
     * Create an instance of {@link JPFlightCheckAvailResult }
     * 
     */
    public JPFlightCheckAvailResult createJPFlightCheckAvailResult() {
        return new JPFlightCheckAvailResult();
    }

    /**
     * Create an instance of {@link JPRentacarItem }
     * 
     */
    public JPRentacarItem createJPRentacarItem() {
        return new JPRentacarItem();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseStarDay }
     * 
     */
    public ArrayOfJPCruiseStarDay createArrayOfJPCruiseStarDay() {
        return new ArrayOfJPCruiseStarDay();
    }

    /**
     * Create an instance of {@link JPPriceFrom }
     * 
     */
    public JPPriceFrom createJPPriceFrom() {
        return new JPPriceFrom();
    }

    /**
     * Create an instance of {@link JPSOAPEmail }
     * 
     */
    public JPSOAPEmail createJPSOAPEmail() {
        return new JPSOAPEmail();
    }

    /**
     * Create an instance of {@link JPTechnicalStop }
     * 
     */
    public JPTechnicalStop createJPTechnicalStop() {
        return new JPTechnicalStop();
    }

    /**
     * Create an instance of {@link JPInsuranceBookingRules }
     * 
     */
    public JPInsuranceBookingRules createJPInsuranceBookingRules() {
        return new JPInsuranceBookingRules();
    }

    /**
     * Create an instance of {@link JPFareGroupType }
     * 
     */
    public JPFareGroupType createJPFareGroupType() {
        return new JPFareGroupType();
    }

    /**
     * Create an instance of {@link JPPackageCheckAvailRequest }
     * 
     */
    public JPPackageCheckAvailRequest createJPPackageCheckAvailRequest() {
        return new JPPackageCheckAvailRequest();
    }

    /**
     * Create an instance of {@link JPCruiseItem }
     * 
     */
    public JPCruiseItem createJPCruiseItem() {
        return new JPCruiseItem();
    }

    /**
     * Create an instance of {@link ArrayOfJPEmail }
     * 
     */
    public ArrayOfJPEmail createArrayOfJPEmail() {
        return new ArrayOfJPEmail();
    }

    /**
     * Create an instance of {@link JPOrigin }
     * 
     */
    public JPOrigin createJPOrigin() {
        return new JPOrigin();
    }

    /**
     * Create an instance of {@link JPHotelModifyAdvancedOptions }
     * 
     */
    public JPHotelModifyAdvancedOptions createJPHotelModifyAdvancedOptions() {
        return new JPHotelModifyAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPPackageSearcherRS }
     * 
     */
    public JPPackageSearcherRS createJPPackageSearcherRS() {
        return new JPPackageSearcherRS();
    }

    /**
     * Create an instance of {@link JPWarningDetails }
     * 
     */
    public JPWarningDetails createJPWarningDetails() {
        return new JPWarningDetails();
    }

    /**
     * Create an instance of {@link JPCruiseChildServices }
     * 
     */
    public JPCruiseChildServices createJPCruiseChildServices() {
        return new JPCruiseChildServices();
    }

    /**
     * Create an instance of {@link ArrayOfJPFlightSegment }
     * 
     */
    public ArrayOfJPFlightSegment createArrayOfJPFlightSegment() {
        return new ArrayOfJPFlightSegment();
    }

    /**
     * Create an instance of {@link JPPackageSearcherItem }
     * 
     */
    public JPPackageSearcherItem createJPPackageSearcherItem() {
        return new JPPackageSearcherItem();
    }

    /**
     * Create an instance of {@link ArrayOfJPOperationTime }
     * 
     */
    public ArrayOfJPOperationTime createArrayOfJPOperationTime() {
        return new ArrayOfJPOperationTime();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackageItinerary }
     * 
     */
    public ArrayOfJPPackageItinerary createArrayOfJPPackageItinerary() {
        return new ArrayOfJPPackageItinerary();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsFlight }
     * 
     */
    public JPSearchSegmentsFlight createJPSearchSegmentsFlight() {
        return new JPSearchSegmentsFlight();
    }

    /**
     * Create an instance of {@link JPSOAPHotelAvailAllotment }
     * 
     */
    public JPSOAPHotelAvailAllotment createJPSOAPHotelAvailAllotment() {
        return new JPSOAPHotelAvailAllotment();
    }

    /**
     * Create an instance of {@link JPRentacarElements }
     * 
     */
    public JPRentacarElements createJPRentacarElements() {
        return new JPRentacarElements();
    }

    /**
     * Create an instance of {@link JPRentacarResult }
     * 
     */
    public JPRentacarResult createJPRentacarResult() {
        return new JPRentacarResult();
    }

    /**
     * Create an instance of {@link JPCruisePreRequest }
     * 
     */
    public JPCruisePreRequest createJPCruisePreRequest() {
        return new JPCruisePreRequest();
    }

    /**
     * Create an instance of {@link JPPackageOptionChangeProduct }
     * 
     */
    public JPPackageOptionChangeProduct createJPPackageOptionChangeProduct() {
        return new JPPackageOptionChangeProduct();
    }

    /**
     * Create an instance of {@link JPRentacarLocationSimpleInfo }
     * 
     */
    public JPRentacarLocationSimpleInfo createJPRentacarLocationSimpleInfo() {
        return new JPRentacarLocationSimpleInfo();
    }

    /**
     * Create an instance of {@link JPOptionalDescriptions }
     * 
     */
    public JPOptionalDescriptions createJPOptionalDescriptions() {
        return new JPOptionalDescriptions();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelOption }
     * 
     */
    public ArrayOfJPHotelOption createArrayOfJPHotelOption() {
        return new ArrayOfJPHotelOption();
    }

    /**
     * Create an instance of {@link JPHotelTimeInformation }
     * 
     */
    public JPHotelTimeInformation createJPHotelTimeInformation() {
        return new JPHotelTimeInformation();
    }

    /**
     * Create an instance of {@link JPSeatGroup }
     * 
     */
    public JPSeatGroup createJPSeatGroup() {
        return new JPSeatGroup();
    }

    /**
     * Create an instance of {@link JPDailyHotelContract }
     * 
     */
    public JPDailyHotelContract createJPDailyHotelContract() {
        return new JPDailyHotelContract();
    }

    /**
     * Create an instance of {@link JPModifyResults }
     * 
     */
    public JPModifyResults createJPModifyResults() {
        return new JPModifyResults();
    }

    /**
     * Create an instance of {@link JPCruiseSupplier }
     * 
     */
    public JPCruiseSupplier createJPCruiseSupplier() {
        return new JPCruiseSupplier();
    }

    /**
     * Create an instance of {@link JPHotelListRequest }
     * 
     */
    public JPHotelListRequest createJPHotelListRequest() {
        return new JPHotelListRequest();
    }

    /**
     * Create an instance of {@link JPRentacarOptionalElements }
     * 
     */
    public JPRentacarOptionalElements createJPRentacarOptionalElements() {
        return new JPRentacarOptionalElements();
    }

    /**
     * Create an instance of {@link JPServiceRequiredFields }
     * 
     */
    public JPServiceRequiredFields createJPServiceRequiredFields() {
        return new JPServiceRequiredFields();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPIntCodeAttr }
     * 
     */
    public ArrayOfJPSOAPIntCodeAttr createArrayOfJPSOAPIntCodeAttr() {
        return new ArrayOfJPSOAPIntCodeAttr();
    }

    /**
     * Create an instance of {@link JPMeetingPointInfo }
     * 
     */
    public JPMeetingPointInfo createJPMeetingPointInfo() {
        return new JPMeetingPointInfo();
    }

    /**
     * Create an instance of {@link JPSearchSegmentCruise }
     * 
     */
    public JPSearchSegmentCruise createJPSearchSegmentCruise() {
        return new JPSearchSegmentCruise();
    }

    /**
     * Create an instance of {@link JPPax }
     * 
     */
    public JPPax createJPPax() {
        return new JPPax();
    }

    /**
     * Create an instance of {@link JPFeature }
     * 
     */
    public JPFeature createJPFeature() {
        return new JPFeature();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanTax }
     * 
     */
    public JPSOAPHotelRatePlanTax createJPSOAPHotelRatePlanTax() {
        return new JPSOAPHotelRatePlanTax();
    }

    /**
     * Create an instance of {@link JPServiceBookingInfo }
     * 
     */
    public JPServiceBookingInfo createJPServiceBookingInfo() {
        return new JPServiceBookingInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPOccupancy }
     * 
     */
    public ArrayOfJPSOAPOccupancy createArrayOfJPSOAPOccupancy() {
        return new ArrayOfJPSOAPOccupancy();
    }

    /**
     * Create an instance of {@link ArrayOfJPPriceFrom }
     * 
     */
    public ArrayOfJPPriceFrom createArrayOfJPPriceFrom() {
        return new ArrayOfJPPriceFrom();
    }

    /**
     * Create an instance of {@link JPFlightCheckAvailAdvancedOptions }
     * 
     */
    public JPFlightCheckAvailAdvancedOptions createJPFlightCheckAvailAdvancedOptions() {
        return new JPFlightCheckAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPRoomList }
     * 
     */
    public JPRoomList createJPRoomList() {
        return new JPRoomList();
    }

    /**
     * Create an instance of {@link JPCruiseItineraryRequest }
     * 
     */
    public JPCruiseItineraryRequest createJPCruiseItineraryRequest() {
        return new JPCruiseItineraryRequest();
    }

    /**
     * Create an instance of {@link JPSOAPContactNumber }
     * 
     */
    public JPSOAPContactNumber createJPSOAPContactNumber() {
        return new JPSOAPContactNumber();
    }

    /**
     * Create an instance of {@link JPCruiseFlightRoute }
     * 
     */
    public JPCruiseFlightRoute createJPCruiseFlightRoute() {
        return new JPCruiseFlightRoute();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelOptionCheckAvail }
     * 
     */
    public ArrayOfJPHotelOptionCheckAvail createArrayOfJPHotelOptionCheckAvail() {
        return new ArrayOfJPHotelOptionCheckAvail();
    }

    /**
     * Create an instance of {@link JPStateProv }
     * 
     */
    public JPStateProv createJPStateProv() {
        return new JPStateProv();
    }

    /**
     * Create an instance of {@link JPPackageDate }
     * 
     */
    public JPPackageDate createJPPackageDate() {
        return new JPPackageDate();
    }

    /**
     * Create an instance of {@link JPAddressType }
     * 
     */
    public JPAddressType createJPAddressType() {
        return new JPAddressType();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseCabin }
     * 
     */
    public ArrayOfJPCruiseCabin createArrayOfJPCruiseCabin() {
        return new ArrayOfJPCruiseCabin();
    }

    /**
     * Create an instance of {@link JPSearchSegmentPackages }
     * 
     */
    public JPSearchSegmentPackages createJPSearchSegmentPackages() {
        return new JPSearchSegmentPackages();
    }

    /**
     * Create an instance of {@link JPHotelElement }
     * 
     */
    public JPHotelElement createJPHotelElement() {
        return new JPHotelElement();
    }

    /**
     * Create an instance of {@link ArrayOfJPFlightSupplier }
     * 
     */
    public ArrayOfJPFlightSupplier createArrayOfJPFlightSupplier() {
        return new ArrayOfJPFlightSupplier();
    }

    /**
     * Create an instance of {@link JPSOAPPriceTyped }
     * 
     */
    public JPSOAPPriceTyped createJPSOAPPriceTyped() {
        return new JPSOAPPriceTyped();
    }

    /**
     * Create an instance of {@link JPFinalCustomerStaticData }
     * 
     */
    public JPFinalCustomerStaticData createJPFinalCustomerStaticData() {
        return new JPFinalCustomerStaticData();
    }

    /**
     * Create an instance of {@link ArrayOfJPFax }
     * 
     */
    public ArrayOfJPFax createArrayOfJPFax() {
        return new ArrayOfJPFax();
    }

    /**
     * Create an instance of {@link JPServiceInfo }
     * 
     */
    public JPServiceInfo createJPServiceInfo() {
        return new JPServiceInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPContentProvider }
     * 
     */
    public ArrayOfJPContentProvider createArrayOfJPContentProvider() {
        return new ArrayOfJPContentProvider();
    }

    /**
     * Create an instance of {@link JPSOAPHotelAvailRelease }
     * 
     */
    public JPSOAPHotelAvailRelease createJPSOAPHotelAvailRelease() {
        return new JPSOAPHotelAvailRelease();
    }

    /**
     * Create an instance of {@link JPSeat }
     * 
     */
    public JPSeat createJPSeat() {
        return new JPSeat();
    }

    /**
     * Create an instance of {@link JPStationInfo }
     * 
     */
    public JPStationInfo createJPStationInfo() {
        return new JPStationInfo();
    }

    /**
     * Create an instance of {@link JPServiceBookingRules }
     * 
     */
    public JPServiceBookingRules createJPServiceBookingRules() {
        return new JPServiceBookingRules();
    }

    /**
     * Create an instance of {@link JPAdditionalElements }
     * 
     */
    public JPAdditionalElements createJPAdditionalElements() {
        return new JPAdditionalElements();
    }

    /**
     * Create an instance of {@link JPOptionalFaresDescriptions }
     * 
     */
    public JPOptionalFaresDescriptions createJPOptionalFaresDescriptions() {
        return new JPOptionalFaresDescriptions();
    }

    /**
     * Create an instance of {@link JPExternalInfo }
     * 
     */
    public JPExternalInfo createJPExternalInfo() {
        return new JPExternalInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackagesCodeList }
     * 
     */
    public ArrayOfJPPackagesCodeList createArrayOfJPPackagesCodeList() {
        return new ArrayOfJPPackagesCodeList();
    }

    /**
     * Create an instance of {@link JPAgencyGroup }
     * 
     */
    public JPAgencyGroup createJPAgencyGroup() {
        return new JPAgencyGroup();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackageCalendarPriceItems }
     * 
     */
    public ArrayOfJPPackageCalendarPriceItems createArrayOfJPPackageCalendarPriceItems() {
        return new ArrayOfJPPackageCalendarPriceItems();
    }

    /**
     * Create an instance of {@link JPBookingRules }
     * 
     */
    public JPBookingRules createJPBookingRules() {
        return new JPBookingRules();
    }

    /**
     * Create an instance of {@link ArrayOfJPFareGroupService }
     * 
     */
    public ArrayOfJPFareGroupService createArrayOfJPFareGroupService() {
        return new ArrayOfJPFareGroupService();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseSupplement }
     * 
     */
    public ArrayOfJPCruiseSupplement createArrayOfJPCruiseSupplement() {
        return new ArrayOfJPCruiseSupplement();
    }

    /**
     * Create an instance of {@link JPHour }
     * 
     */
    public JPHour createJPHour() {
        return new JPHour();
    }

    /**
     * Create an instance of {@link JPPrice }
     * 
     */
    public JPPrice createJPPrice() {
        return new JPPrice();
    }

    /**
     * Create an instance of {@link ArrayOfJPTechnicalStop }
     * 
     */
    public ArrayOfJPTechnicalStop createArrayOfJPTechnicalStop() {
        return new ArrayOfJPTechnicalStop();
    }

    /**
     * Create an instance of {@link ArrayOfJPRentacarOption }
     * 
     */
    public ArrayOfJPRentacarOption createArrayOfJPRentacarOption() {
        return new ArrayOfJPRentacarOption();
    }

    /**
     * Create an instance of {@link JPWarningDistribution }
     * 
     */
    public JPWarningDistribution createJPWarningDistribution() {
        return new JPWarningDistribution();
    }

    /**
     * Create an instance of {@link JPVisaRequiredFields }
     * 
     */
    public JPVisaRequiredFields createJPVisaRequiredFields() {
        return new JPVisaRequiredFields();
    }

    /**
     * Create an instance of {@link JPBillingDataAFIP }
     * 
     */
    public JPBillingDataAFIP createJPBillingDataAFIP() {
        return new JPBillingDataAFIP();
    }

    /**
     * Create an instance of {@link ArrayOfJPSpecialSupplementType }
     * 
     */
    public ArrayOfJPSpecialSupplementType createArrayOfJPSpecialSupplementType() {
        return new ArrayOfJPSpecialSupplementType();
    }

    /**
     * Create an instance of {@link JPPackageBookingInfo }
     * 
     */
    public JPPackageBookingInfo createJPPackageBookingInfo() {
        return new JPPackageBookingInfo();
    }

    /**
     * Create an instance of {@link JPMultimediaContent }
     * 
     */
    public JPMultimediaContent createJPMultimediaContent() {
        return new JPMultimediaContent();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPIntCodeAttr3 }
     * 
     */
    public ArrayOfJPSOAPIntCodeAttr3 createArrayOfJPSOAPIntCodeAttr3() {
        return new ArrayOfJPSOAPIntCodeAttr3();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPIntCodeAttr4 }
     * 
     */
    public ArrayOfJPSOAPIntCodeAttr4 createArrayOfJPSOAPIntCodeAttr4() {
        return new ArrayOfJPSOAPIntCodeAttr4();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPIntCodeAttr1 }
     * 
     */
    public ArrayOfJPSOAPIntCodeAttr1 createArrayOfJPSOAPIntCodeAttr1() {
        return new ArrayOfJPSOAPIntCodeAttr1();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPIntCodeAttr2 }
     * 
     */
    public ArrayOfJPSOAPIntCodeAttr2 createArrayOfJPSOAPIntCodeAttr2() {
        return new ArrayOfJPSOAPIntCodeAttr2();
    }

    /**
     * Create an instance of {@link JPSOAPOccupancies }
     * 
     */
    public JPSOAPOccupancies createJPSOAPOccupancies() {
        return new JPSOAPOccupancies();
    }

    /**
     * Create an instance of {@link JPRelPaxesDist }
     * 
     */
    public JPRelPaxesDist createJPRelPaxesDist() {
        return new JPRelPaxesDist();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelRoomCode }
     * 
     */
    public ArrayOfJPHotelRoomCode createArrayOfJPHotelRoomCode() {
        return new ArrayOfJPHotelRoomCode();
    }

    /**
     * Create an instance of {@link ArrayOfJPSupplementRelPax }
     * 
     */
    public ArrayOfJPSupplementRelPax createArrayOfJPSupplementRelPax() {
        return new ArrayOfJPSupplementRelPax();
    }

    /**
     * Create an instance of {@link JPHotelOptionBookingRules }
     * 
     */
    public JPHotelOptionBookingRules createJPHotelOptionBookingRules() {
        return new JPHotelOptionBookingRules();
    }

    /**
     * Create an instance of {@link JPRentcarRequiredFields }
     * 
     */
    public JPRentcarRequiredFields createJPRentcarRequiredFields() {
        return new JPRentcarRequiredFields();
    }

    /**
     * Create an instance of {@link JPPackageRequiredFields }
     * 
     */
    public JPPackageRequiredFields createJPPackageRequiredFields() {
        return new JPPackageRequiredFields();
    }

    /**
     * Create an instance of {@link JPGenericDataCatalogueRequest }
     * 
     */
    public JPGenericDataCatalogueRequest createJPGenericDataCatalogueRequest() {
        return new JPGenericDataCatalogueRequest();
    }

    /**
     * Create an instance of {@link ArrayOfJPCommonPriceBreakdown1 }
     * 
     */
    public ArrayOfJPCommonPriceBreakdown1 createArrayOfJPCommonPriceBreakdown1() {
        return new ArrayOfJPCommonPriceBreakdown1();
    }

    /**
     * Create an instance of {@link JPHotelInventorySimpleInfo }
     * 
     */
    public JPHotelInventorySimpleInfo createJPHotelInventorySimpleInfo() {
        return new JPHotelInventorySimpleInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPCommonPriceBreakdown2 }
     * 
     */
    public ArrayOfJPCommonPriceBreakdown2 createArrayOfJPCommonPriceBreakdown2() {
        return new ArrayOfJPCommonPriceBreakdown2();
    }

    /**
     * Create an instance of {@link JPHotelFutureRatesResults }
     * 
     */
    public JPHotelFutureRatesResults createJPHotelFutureRatesResults() {
        return new JPHotelFutureRatesResults();
    }

    /**
     * Create an instance of {@link JPTransferRequiredFields }
     * 
     */
    public JPTransferRequiredFields createJPTransferRequiredFields() {
        return new JPTransferRequiredFields();
    }

    /**
     * Create an instance of {@link JPCreditCardFee }
     * 
     */
    public JPCreditCardFee createJPCreditCardFee() {
        return new JPCreditCardFee();
    }

    /**
     * Create an instance of {@link ArrayOfJPSeatGroup }
     * 
     */
    public ArrayOfJPSeatGroup createArrayOfJPSeatGroup() {
        return new ArrayOfJPSeatGroup();
    }

    /**
     * Create an instance of {@link ArrayOfJPRentacarLocation }
     * 
     */
    public ArrayOfJPRentacarLocation createArrayOfJPRentacarLocation() {
        return new ArrayOfJPRentacarLocation();
    }

    /**
     * Create an instance of {@link ArrayOfJPFareGroupPrice }
     * 
     */
    public ArrayOfJPFareGroupPrice createArrayOfJPFareGroupPrice() {
        return new ArrayOfJPFareGroupPrice();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelRelPaxDist }
     * 
     */
    public ArrayOfJPHotelRelPaxDist createArrayOfJPHotelRelPaxDist() {
        return new ArrayOfJPHotelRelPaxDist();
    }

    /**
     * Create an instance of {@link JPServiceRuleOptionRQ }
     * 
     */
    public JPServiceRuleOptionRQ createJPServiceRuleOptionRQ() {
        return new JPServiceRuleOptionRQ();
    }

    /**
     * Create an instance of {@link JPHotelDailyContracts }
     * 
     */
    public JPHotelDailyContracts createJPHotelDailyContracts() {
        return new JPHotelDailyContracts();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelOptionModify }
     * 
     */
    public ArrayOfJPHotelOptionModify createArrayOfJPHotelOptionModify() {
        return new ArrayOfJPHotelOptionModify();
    }

    /**
     * Create an instance of {@link JPSOAPIdTypeIntName }
     * 
     */
    public JPSOAPIdTypeIntName createJPSOAPIdTypeIntName() {
        return new JPSOAPIdTypeIntName();
    }

    /**
     * Create an instance of {@link JPRentacarInfo }
     * 
     */
    public JPRentacarInfo createJPRentacarInfo() {
        return new JPRentacarInfo();
    }

    /**
     * Create an instance of {@link JPBookingPrice }
     * 
     */
    public JPBookingPrice createJPBookingPrice() {
        return new JPBookingPrice();
    }

    /**
     * Create an instance of {@link ArrayOfJPDay }
     * 
     */
    public ArrayOfJPDay createArrayOfJPDay() {
        return new ArrayOfJPDay();
    }

    /**
     * Create an instance of {@link JPCruiseComponent }
     * 
     */
    public JPCruiseComponent createJPCruiseComponent() {
        return new JPCruiseComponent();
    }

    /**
     * Create an instance of {@link ArrayOfJPSupplementRelPaxDist }
     * 
     */
    public ArrayOfJPSupplementRelPaxDist createArrayOfJPSupplementRelPaxDist() {
        return new ArrayOfJPSupplementRelPaxDist();
    }

    /**
     * Create an instance of {@link ArrayOfJPTransfer }
     * 
     */
    public ArrayOfJPTransfer createArrayOfJPTransfer() {
        return new ArrayOfJPTransfer();
    }

    /**
     * Create an instance of {@link JPCruiseAdditionalElements }
     * 
     */
    public JPCruiseAdditionalElements createJPCruiseAdditionalElements() {
        return new JPCruiseAdditionalElements();
    }

    /**
     * Create an instance of {@link JPFirstDayCostCancellation }
     * 
     */
    public JPFirstDayCostCancellation createJPFirstDayCostCancellation() {
        return new JPFirstDayCostCancellation();
    }

    /**
     * Create an instance of {@link JPCheckPaymentRequiredFieldsResponse }
     * 
     */
    public JPCheckPaymentRequiredFieldsResponse createJPCheckPaymentRequiredFieldsResponse() {
        return new JPCheckPaymentRequiredFieldsResponse();
    }

    /**
     * Create an instance of {@link JPSOAPDiscount }
     * 
     */
    public JPSOAPDiscount createJPSOAPDiscount() {
        return new JPSOAPDiscount();
    }

    /**
     * Create an instance of {@link JPRentacarLocationListRequest }
     * 
     */
    public JPRentacarLocationListRequest createJPRentacarLocationListRequest() {
        return new JPRentacarLocationListRequest();
    }

    /**
     * Create an instance of {@link JPTransferOrigin }
     * 
     */
    public JPTransferOrigin createJPTransferOrigin() {
        return new JPTransferOrigin();
    }

    /**
     * Create an instance of {@link JPHotelSimpleContent }
     * 
     */
    public JPHotelSimpleContent createJPHotelSimpleContent() {
        return new JPHotelSimpleContent();
    }

    /**
     * Create an instance of {@link JPServicesAvailAdvancedOptions }
     * 
     */
    public JPServicesAvailAdvancedOptions createJPServicesAvailAdvancedOptions() {
        return new JPServicesAvailAdvancedOptions();
    }

    /**
     * Create an instance of {@link ArrayOfJPItemHotelRoom }
     * 
     */
    public ArrayOfJPItemHotelRoom createArrayOfJPItemHotelRoom() {
        return new ArrayOfJPItemHotelRoom();
    }

    /**
     * Create an instance of {@link JPVisaOptionRQ }
     * 
     */
    public JPVisaOptionRQ createJPVisaOptionRQ() {
        return new JPVisaOptionRQ();
    }

    /**
     * Create an instance of {@link JPZoneInfo }
     * 
     */
    public JPZoneInfo createJPZoneInfo() {
        return new JPZoneInfo();
    }

    /**
     * Create an instance of {@link JPCommissions }
     * 
     */
    public JPCommissions createJPCommissions() {
        return new JPCommissions();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPAllotment }
     * 
     */
    public ArrayOfJPSOAPAllotment createArrayOfJPSOAPAllotment() {
        return new ArrayOfJPSOAPAllotment();
    }

    /**
     * Create an instance of {@link JPSOAPIntCodeAttr }
     * 
     */
    public JPSOAPIntCodeAttr createJPSOAPIntCodeAttr() {
        return new JPSOAPIntCodeAttr();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseCategory }
     * 
     */
    public ArrayOfJPCruiseCategory createArrayOfJPCruiseCategory() {
        return new ArrayOfJPCruiseCategory();
    }

    /**
     * Create an instance of {@link JPCoverage }
     * 
     */
    public JPCoverage createJPCoverage() {
        return new JPCoverage();
    }

    /**
     * Create an instance of {@link JPPackageStay }
     * 
     */
    public JPPackageStay createJPPackageStay() {
        return new JPPackageStay();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanCancellationPolicyRule }
     * 
     */
    public JPSOAPHotelRatePlanCancellationPolicyRule createJPSOAPHotelRatePlanCancellationPolicyRule() {
        return new JPSOAPHotelRatePlanCancellationPolicyRule();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanOffer }
     * 
     */
    public JPSOAPHotelRatePlanOffer createJPSOAPHotelRatePlanOffer() {
        return new JPSOAPHotelRatePlanOffer();
    }

    /**
     * Create an instance of {@link JPInsuranceRequiredFields }
     * 
     */
    public JPInsuranceRequiredFields createJPInsuranceRequiredFields() {
        return new JPInsuranceRequiredFields();
    }

    /**
     * Create an instance of {@link JPHotelCheckAvailResult }
     * 
     */
    public JPHotelCheckAvailResult createJPHotelCheckAvailResult() {
        return new JPHotelCheckAvailResult();
    }

    /**
     * Create an instance of {@link JPVisaItem }
     * 
     */
    public JPVisaItem createJPVisaItem() {
        return new JPVisaItem();
    }

    /**
     * Create an instance of {@link JPServiceSimpleInfo }
     * 
     */
    public JPServiceSimpleInfo createJPServiceSimpleInfo() {
        return new JPServiceSimpleInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelContractType }
     * 
     */
    public ArrayOfJPHotelContractType createArrayOfJPHotelContractType() {
        return new ArrayOfJPHotelContractType();
    }

    /**
     * Create an instance of {@link JPExtendedRelPax }
     * 
     */
    public JPExtendedRelPax createJPExtendedRelPax() {
        return new JPExtendedRelPax();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsRentacar }
     * 
     */
    public JPSearchSegmentsRentacar createJPSearchSegmentsRentacar() {
        return new JPSearchSegmentsRentacar();
    }

    /**
     * Create an instance of {@link ArrayOfJPCarSupplement }
     * 
     */
    public ArrayOfJPCarSupplement createArrayOfJPCarSupplement() {
        return new ArrayOfJPCarSupplement();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsTransfers }
     * 
     */
    public JPSearchSegmentsTransfers createJPSearchSegmentsTransfers() {
        return new JPSearchSegmentsTransfers();
    }

    /**
     * Create an instance of {@link ArrayOfJPFlightElement }
     * 
     */
    public ArrayOfJPFlightElement createArrayOfJPFlightElement() {
        return new ArrayOfJPFlightElement();
    }

    /**
     * Create an instance of {@link ArrayOfJPRule }
     * 
     */
    public ArrayOfJPRule createArrayOfJPRule() {
        return new ArrayOfJPRule();
    }

    /**
     * Create an instance of {@link JPPaymentPrice }
     * 
     */
    public JPPaymentPrice createJPPaymentPrice() {
        return new JPPaymentPrice();
    }

    /**
     * Create an instance of {@link JPHotelCheckTime }
     * 
     */
    public JPHotelCheckTime createJPHotelCheckTime() {
        return new JPHotelCheckTime();
    }

    /**
     * Create an instance of {@link JPCruiseDeck }
     * 
     */
    public JPCruiseDeck createJPCruiseDeck() {
        return new JPCruiseDeck();
    }

    /**
     * Create an instance of {@link ArrayOfJPRoomCategory }
     * 
     */
    public ArrayOfJPRoomCategory createArrayOfJPRoomCategory() {
        return new ArrayOfJPRoomCategory();
    }

    /**
     * Create an instance of {@link JPCruiseSearch }
     * 
     */
    public JPCruiseSearch createJPCruiseSearch() {
        return new JPCruiseSearch();
    }

    /**
     * Create an instance of {@link ArrayOfJPExtendedHotelInfo }
     * 
     */
    public ArrayOfJPExtendedHotelInfo createArrayOfJPExtendedHotelInfo() {
        return new ArrayOfJPExtendedHotelInfo();
    }

    /**
     * Create an instance of {@link JPVisaBookingRuleRequest }
     * 
     */
    public JPVisaBookingRuleRequest createJPVisaBookingRuleRequest() {
        return new JPVisaBookingRuleRequest();
    }

    /**
     * Create an instance of {@link JPSOAPPickUpPoint }
     * 
     */
    public JPSOAPPickUpPoint createJPSOAPPickUpPoint() {
        return new JPSOAPPickUpPoint();
    }

    /**
     * Create an instance of {@link JPFareGroupPriceApplication }
     * 
     */
    public JPFareGroupPriceApplication createJPFareGroupPriceApplication() {
        return new JPFareGroupPriceApplication();
    }

    /**
     * Create an instance of {@link JPRule }
     * 
     */
    public JPRule createJPRule() {
        return new JPRule();
    }

    /**
     * Create an instance of {@link JPReservation }
     * 
     */
    public JPReservation createJPReservation() {
        return new JPReservation();
    }

    /**
     * Create an instance of {@link ArrayOfJPHour }
     * 
     */
    public ArrayOfJPHour createArrayOfJPHour() {
        return new ArrayOfJPHour();
    }

    /**
     * Create an instance of {@link JPResults }
     * 
     */
    public JPResults createJPResults() {
        return new JPResults();
    }

    /**
     * Create an instance of {@link JPHotelAdditionalElement }
     * 
     */
    public JPHotelAdditionalElement createJPHotelAdditionalElement() {
        return new JPHotelAdditionalElement();
    }

    /**
     * Create an instance of {@link JPSOAPApplicationRulesOffers }
     * 
     */
    public JPSOAPApplicationRulesOffers createJPSOAPApplicationRulesOffers() {
        return new JPSOAPApplicationRulesOffers();
    }

    /**
     * Create an instance of {@link JPEquipment }
     * 
     */
    public JPEquipment createJPEquipment() {
        return new JPEquipment();
    }

    /**
     * Create an instance of {@link JPInsuranceBookingAdvancedOptions }
     * 
     */
    public JPInsuranceBookingAdvancedOptions createJPInsuranceBookingAdvancedOptions() {
        return new JPInsuranceBookingAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPSOAPRequiredOptionalSupplements }
     * 
     */
    public JPSOAPRequiredOptionalSupplements createJPSOAPRequiredOptionalSupplements() {
        return new JPSOAPRequiredOptionalSupplements();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPDiscount1 }
     * 
     */
    public ArrayOfJPSOAPDiscount1 createArrayOfJPSOAPDiscount1() {
        return new ArrayOfJPSOAPDiscount1();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPDiscount2 }
     * 
     */
    public ArrayOfJPSOAPDiscount2 createArrayOfJPSOAPDiscount2() {
        return new ArrayOfJPSOAPDiscount2();
    }

    /**
     * Create an instance of {@link JPFlightRequest }
     * 
     */
    public JPFlightRequest createJPFlightRequest() {
        return new JPFlightRequest();
    }

    /**
     * Create an instance of {@link JPHolder }
     * 
     */
    public JPHolder createJPHolder() {
        return new JPHolder();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanCancellationPolicy }
     * 
     */
    public JPSOAPHotelRatePlanCancellationPolicy createJPSOAPHotelRatePlanCancellationPolicy() {
        return new JPSOAPHotelRatePlanCancellationPolicy();
    }

    /**
     * Create an instance of {@link JPSOAPHotelInventoryHotel }
     * 
     */
    public JPSOAPHotelInventoryHotel createJPSOAPHotelInventoryHotel() {
        return new JPSOAPHotelInventoryHotel();
    }

    /**
     * Create an instance of {@link ArrayOfJPDescription }
     * 
     */
    public ArrayOfJPDescription createArrayOfJPDescription() {
        return new ArrayOfJPDescription();
    }

    /**
     * Create an instance of {@link JPPackageElements }
     * 
     */
    public JPPackageElements createJPPackageElements() {
        return new JPPackageElements();
    }

    /**
     * Create an instance of {@link ArrayOfJPCreditCardFee }
     * 
     */
    public ArrayOfJPCreditCardFee createArrayOfJPCreditCardFee() {
        return new ArrayOfJPCreditCardFee();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackageZone }
     * 
     */
    public ArrayOfJPPackageZone createArrayOfJPPackageZone() {
        return new ArrayOfJPPackageZone();
    }

    /**
     * Create an instance of {@link JPRoomCategory }
     * 
     */
    public JPRoomCategory createJPRoomCategory() {
        return new JPRoomCategory();
    }

    /**
     * Create an instance of {@link JPHotelCategory }
     * 
     */
    public JPHotelCategory createJPHotelCategory() {
        return new JPHotelCategory();
    }

    /**
     * Create an instance of {@link JPRequiredField }
     * 
     */
    public JPRequiredField createJPRequiredField() {
        return new JPRequiredField();
    }

    /**
     * Create an instance of {@link JPFareGroupPrice }
     * 
     */
    public JPFareGroupPrice createJPFareGroupPrice() {
        return new JPFareGroupPrice();
    }

    /**
     * Create an instance of {@link JPHarbor }
     * 
     */
    public JPHarbor createJPHarbor() {
        return new JPHarbor();
    }

    /**
     * Create an instance of {@link ArrayOfJPSupplementHotelType }
     * 
     */
    public ArrayOfJPSupplementHotelType createArrayOfJPSupplementHotelType() {
        return new ArrayOfJPSupplementHotelType();
    }

    /**
     * Create an instance of {@link JPSearchSegmentItinerary }
     * 
     */
    public JPSearchSegmentItinerary createJPSearchSegmentItinerary() {
        return new JPSearchSegmentItinerary();
    }

    /**
     * Create an instance of {@link JPHotelAllotmentRequest }
     * 
     */
    public JPHotelAllotmentRequest createJPHotelAllotmentRequest() {
        return new JPHotelAllotmentRequest();
    }

    /**
     * Create an instance of {@link ArrayOfJPPaxSeat }
     * 
     */
    public ArrayOfJPPaxSeat createArrayOfJPPaxSeat() {
        return new ArrayOfJPPaxSeat();
    }

    /**
     * Create an instance of {@link JPRequestFutureRatesAvail }
     * 
     */
    public JPRequestFutureRatesAvail createJPRequestFutureRatesAvail() {
        return new JPRequestFutureRatesAvail();
    }

    /**
     * Create an instance of {@link JPAgent }
     * 
     */
    public JPAgent createJPAgent() {
        return new JPAgent();
    }

    /**
     * Create an instance of {@link ArrayOfJPFlightTicketInfo }
     * 
     */
    public ArrayOfJPFlightTicketInfo createArrayOfJPFlightTicketInfo() {
        return new ArrayOfJPFlightTicketInfo();
    }

    /**
     * Create an instance of {@link JPSOAPSuppleOfferPrices }
     * 
     */
    public JPSOAPSuppleOfferPrices createJPSOAPSuppleOfferPrices() {
        return new JPSOAPSuppleOfferPrices();
    }

    /**
     * Create an instance of {@link JPSearchSegmentVisa }
     * 
     */
    public JPSearchSegmentVisa createJPSearchSegmentVisa() {
        return new JPSearchSegmentVisa();
    }

    /**
     * Create an instance of {@link JPOperationTime }
     * 
     */
    public JPOperationTime createJPOperationTime() {
        return new JPOperationTime();
    }

    /**
     * Create an instance of {@link JPDestination }
     * 
     */
    public JPDestination createJPDestination() {
        return new JPDestination();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseData }
     * 
     */
    public ArrayOfJPCruiseData createArrayOfJPCruiseData() {
        return new ArrayOfJPCruiseData();
    }

    /**
     * Create an instance of {@link JPVisaResult }
     * 
     */
    public JPVisaResult createJPVisaResult() {
        return new JPVisaResult();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsTransfersByHotel }
     * 
     */
    public JPSearchSegmentsTransfersByHotel createJPSearchSegmentsTransfersByHotel() {
        return new JPSearchSegmentsTransfersByHotel();
    }

    /**
     * Create an instance of {@link JPEmail }
     * 
     */
    public JPEmail createJPEmail() {
        return new JPEmail();
    }

    /**
     * Create an instance of {@link ArrayOfJPServiceDate }
     * 
     */
    public ArrayOfJPServiceDate createArrayOfJPServiceDate() {
        return new ArrayOfJPServiceDate();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelRatePlanCancellationPolicyRule }
     * 
     */
    public ArrayOfJPSOAPHotelRatePlanCancellationPolicyRule createArrayOfJPSOAPHotelRatePlanCancellationPolicyRule() {
        return new ArrayOfJPSOAPHotelRatePlanCancellationPolicyRule();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelRatePlanTax }
     * 
     */
    public ArrayOfJPSOAPHotelRatePlanTax createArrayOfJPSOAPHotelRatePlanTax() {
        return new ArrayOfJPSOAPHotelRatePlanTax();
    }

    /**
     * Create an instance of {@link JPContents }
     * 
     */
    public JPContents createJPContents() {
        return new JPContents();
    }

    /**
     * Create an instance of {@link JPSupplementRelPaxDist }
     * 
     */
    public JPSupplementRelPaxDist createJPSupplementRelPaxDist() {
        return new JPSupplementRelPaxDist();
    }

    /**
     * Create an instance of {@link JPSOAPHotelAvailReleases }
     * 
     */
    public JPSOAPHotelAvailReleases createJPSOAPHotelAvailReleases() {
        return new JPSOAPHotelAvailReleases();
    }

    /**
     * Create an instance of {@link JPCruiseCheckAvailRequest }
     * 
     */
    public JPCruiseCheckAvailRequest createJPCruiseCheckAvailRequest() {
        return new JPCruiseCheckAvailRequest();
    }

    /**
     * Create an instance of {@link JPServiceItemStaticData }
     * 
     */
    public JPServiceItemStaticData createJPServiceItemStaticData() {
        return new JPServiceItemStaticData();
    }

    /**
     * Create an instance of {@link JPCruiseCategory }
     * 
     */
    public JPCruiseCategory createJPCruiseCategory() {
        return new JPCruiseCategory();
    }

    /**
     * Create an instance of {@link JPServicePortfolio }
     * 
     */
    public JPServicePortfolio createJPServicePortfolio() {
        return new JPServicePortfolio();
    }

    /**
     * Create an instance of {@link JPServiceCheckAvailRequest }
     * 
     */
    public JPServiceCheckAvailRequest createJPServiceCheckAvailRequest() {
        return new JPServiceCheckAvailRequest();
    }

    /**
     * Create an instance of {@link JPPackageHotel }
     * 
     */
    public JPPackageHotel createJPPackageHotel() {
        return new JPPackageHotel();
    }

    /**
     * Create an instance of {@link JPHotelPortfolio }
     * 
     */
    public JPHotelPortfolio createJPHotelPortfolio() {
        return new JPHotelPortfolio();
    }

    /**
     * Create an instance of {@link JPCarSupplement }
     * 
     */
    public JPCarSupplement createJPCarSupplement() {
        return new JPCarSupplement();
    }

    /**
     * Create an instance of {@link ArrayOfJPComment }
     * 
     */
    public ArrayOfJPComment createArrayOfJPComment() {
        return new ArrayOfJPComment();
    }

    /**
     * Create an instance of {@link JPCancelRequest }
     * 
     */
    public JPCancelRequest createJPCancelRequest() {
        return new JPCancelRequest();
    }

    /**
     * Create an instance of {@link JPTransferItemStaticData }
     * 
     */
    public JPTransferItemStaticData createJPTransferItemStaticData() {
        return new JPTransferItemStaticData();
    }

    /**
     * Create an instance of {@link JPCheckPaymentResponse }
     * 
     */
    public JPCheckPaymentResponse createJPCheckPaymentResponse() {
        return new JPCheckPaymentResponse();
    }

    /**
     * Create an instance of {@link JPHotelSimpleInfo }
     * 
     */
    public JPHotelSimpleInfo createJPHotelSimpleInfo() {
        return new JPHotelSimpleInfo();
    }

    /**
     * Create an instance of {@link JPShoppingBasket }
     * 
     */
    public JPShoppingBasket createJPShoppingBasket() {
        return new JPShoppingBasket();
    }

    /**
     * Create an instance of {@link JPSeatEquipment }
     * 
     */
    public JPSeatEquipment createJPSeatEquipment() {
        return new JPSeatEquipment();
    }

    /**
     * Create an instance of {@link JPVirtualCreditCardInfo }
     * 
     */
    public JPVirtualCreditCardInfo createJPVirtualCreditCardInfo() {
        return new JPVirtualCreditCardInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPFareGroup }
     * 
     */
    public ArrayOfJPFareGroup createArrayOfJPFareGroup() {
        return new ArrayOfJPFareGroup();
    }

    /**
     * Create an instance of {@link JPErrorType }
     * 
     */
    public JPErrorType createJPErrorType() {
        return new JPErrorType();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruiseStation }
     * 
     */
    public ArrayOfJPCruiseStation createArrayOfJPCruiseStation() {
        return new ArrayOfJPCruiseStation();
    }

    /**
     * Create an instance of {@link ArrayOfJPFlightLocator }
     * 
     */
    public ArrayOfJPFlightLocator createArrayOfJPFlightLocator() {
        return new ArrayOfJPFlightLocator();
    }

    /**
     * Create an instance of {@link JPHotelSpecificationsRequest }
     * 
     */
    public JPHotelSpecificationsRequest createJPHotelSpecificationsRequest() {
        return new JPHotelSpecificationsRequest();
    }

    /**
     * Create an instance of {@link JPPackageRequest }
     * 
     */
    public JPPackageRequest createJPPackageRequest() {
        return new JPPackageRequest();
    }

    /**
     * Create an instance of {@link JPSOAPDateIntervalsGroupsCheckInDates }
     * 
     */
    public JPSOAPDateIntervalsGroupsCheckInDates createJPSOAPDateIntervalsGroupsCheckInDates() {
        return new JPSOAPDateIntervalsGroupsCheckInDates();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanContract }
     * 
     */
    public JPSOAPHotelRatePlanContract createJPSOAPHotelRatePlanContract() {
        return new JPSOAPHotelRatePlanContract();
    }

    /**
     * Create an instance of {@link JPPackageItinerary }
     * 
     */
    public JPPackageItinerary createJPPackageItinerary() {
        return new JPPackageItinerary();
    }

    /**
     * Create an instance of {@link JPFinalCustomerAddressStaticData }
     * 
     */
    public JPFinalCustomerAddressStaticData createJPFinalCustomerAddressStaticData() {
        return new JPFinalCustomerAddressStaticData();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPContactNumber1 }
     * 
     */
    public ArrayOfJPSOAPContactNumber1 createArrayOfJPSOAPContactNumber1() {
        return new ArrayOfJPSOAPContactNumber1();
    }

    /**
     * Create an instance of {@link JPCruiseCheckAvailResult }
     * 
     */
    public JPCruiseCheckAvailResult createJPCruiseCheckAvailResult() {
        return new JPCruiseCheckAvailResult();
    }

    /**
     * Create an instance of {@link ArrayOfJPDebug }
     * 
     */
    public ArrayOfJPDebug createArrayOfJPDebug() {
        return new ArrayOfJPDebug();
    }

    /**
     * Create an instance of {@link ArrayOfJPCoverage }
     * 
     */
    public ArrayOfJPCoverage createArrayOfJPCoverage() {
        return new ArrayOfJPCoverage();
    }

    /**
     * Create an instance of {@link JPZoneInfoRequest }
     * 
     */
    public JPZoneInfoRequest createJPZoneInfoRequest() {
        return new JPZoneInfoRequest();
    }

    /**
     * Create an instance of {@link JPSearchSegmentHotelsModify }
     * 
     */
    public JPSearchSegmentHotelsModify createJPSearchSegmentHotelsModify() {
        return new JPSearchSegmentHotelsModify();
    }

    /**
     * Create an instance of {@link JPFlightBookingRulesRequest }
     * 
     */
    public JPFlightBookingRulesRequest createJPFlightBookingRulesRequest() {
        return new JPFlightBookingRulesRequest();
    }

    /**
     * Create an instance of {@link ArrayOfJPSeat }
     * 
     */
    public ArrayOfJPSeat createArrayOfJPSeat() {
        return new ArrayOfJPSeat();
    }

    /**
     * Create an instance of {@link JPCruiseItinerary }
     * 
     */
    public JPCruiseItinerary createJPCruiseItinerary() {
        return new JPCruiseItinerary();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPOrderedTypedPrice }
     * 
     */
    public ArrayOfJPSOAPOrderedTypedPrice createArrayOfJPSOAPOrderedTypedPrice() {
        return new ArrayOfJPSOAPOrderedTypedPrice();
    }

    /**
     * Create an instance of {@link JPRoomOccupancy }
     * 
     */
    public JPRoomOccupancy createJPRoomOccupancy() {
        return new JPRoomOccupancy();
    }

    /**
     * Create an instance of {@link JPBookingListAdvancedOptions }
     * 
     */
    public JPBookingListAdvancedOptions createJPBookingListAdvancedOptions() {
        return new JPBookingListAdvancedOptions();
    }

    /**
     * Create an instance of {@link JPSOAPAllotment }
     * 
     */
    public JPSOAPAllotment createJPSOAPAllotment() {
        return new JPSOAPAllotment();
    }

    /**
     * Create an instance of {@link JPCruiseElements }
     * 
     */
    public JPCruiseElements createJPCruiseElements() {
        return new JPCruiseElements();
    }

    /**
     * Create an instance of {@link ArrayOfJPUserPermission }
     * 
     */
    public ArrayOfJPUserPermission createArrayOfJPUserPermission() {
        return new ArrayOfJPUserPermission();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link JPCruiseFlight }
     * 
     */
    public JPCruiseFlight createJPCruiseFlight() {
        return new JPCruiseFlight();
    }

    /**
     * Create an instance of {@link JPHotelOption }
     * 
     */
    public JPHotelOption createJPHotelOption() {
        return new JPHotelOption();
    }

    /**
     * Create an instance of {@link JPContentProvider }
     * 
     */
    public JPContentProvider createJPContentProvider() {
        return new JPContentProvider();
    }

    /**
     * Create an instance of {@link JPTransferResult }
     * 
     */
    public JPTransferResult createJPTransferResult() {
        return new JPTransferResult();
    }

    /**
     * Create an instance of {@link JPRouteDispo }
     * 
     */
    public JPRouteDispo createJPRouteDispo() {
        return new JPRouteDispo();
    }

    /**
     * Create an instance of {@link JPSupplementHotelType }
     * 
     */
    public JPSupplementHotelType createJPSupplementHotelType() {
        return new JPSupplementHotelType();
    }

    /**
     * Create an instance of {@link JPFlightElement }
     * 
     */
    public JPFlightElement createJPFlightElement() {
        return new JPFlightElement();
    }

    /**
     * Create an instance of {@link JPCompartment }
     * 
     */
    public JPCompartment createJPCompartment() {
        return new JPCompartment();
    }

    /**
     * Create an instance of {@link JPFlightRequiredFields }
     * 
     */
    public JPFlightRequiredFields createJPFlightRequiredFields() {
        return new JPFlightRequiredFields();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelInventoryRoomType }
     * 
     */
    public ArrayOfJPSOAPHotelInventoryRoomType createArrayOfJPSOAPHotelInventoryRoomType() {
        return new ArrayOfJPSOAPHotelInventoryRoomType();
    }

    /**
     * Create an instance of {@link JPPackageBookingRules }
     * 
     */
    public JPPackageBookingRules createJPPackageBookingRules() {
        return new JPPackageBookingRules();
    }

    /**
     * Create an instance of {@link JPCruiseSupplement }
     * 
     */
    public JPCruiseSupplement createJPCruiseSupplement() {
        return new JPCruiseSupplement();
    }

    /**
     * Create an instance of {@link JPPointOfInterest }
     * 
     */
    public JPPointOfInterest createJPPointOfInterest() {
        return new JPPointOfInterest();
    }

    /**
     * Create an instance of {@link JPPackageAdditionalElements }
     * 
     */
    public JPPackageAdditionalElements createJPPackageAdditionalElements() {
        return new JPPackageAdditionalElements();
    }

    /**
     * Create an instance of {@link ArrayOfJPAgencyData }
     * 
     */
    public ArrayOfJPAgencyData createArrayOfJPAgencyData() {
        return new ArrayOfJPAgencyData();
    }

    /**
     * Create an instance of {@link JPSOAPHotelInventoryAddress }
     * 
     */
    public JPSOAPHotelInventoryAddress createJPSOAPHotelInventoryAddress() {
        return new JPSOAPHotelInventoryAddress();
    }

    /**
     * Create an instance of {@link JPSOAPHotelAvailContract }
     * 
     */
    public JPSOAPHotelAvailContract createJPSOAPHotelAvailContract() {
        return new JPSOAPHotelAvailContract();
    }

    /**
     * Create an instance of {@link JPHotelContent }
     * 
     */
    public JPHotelContent createJPHotelContent() {
        return new JPHotelContent();
    }

    /**
     * Create an instance of {@link JPPriceRange }
     * 
     */
    public JPPriceRange createJPPriceRange() {
        return new JPPriceRange();
    }

    /**
     * Create an instance of {@link JPCruiseStarDay }
     * 
     */
    public JPCruiseStarDay createJPCruiseStarDay() {
        return new JPCruiseStarDay();
    }

    /**
     * Create an instance of {@link ArrayOfJPRequiredFieldValue }
     * 
     */
    public ArrayOfJPRequiredFieldValue createArrayOfJPRequiredFieldValue() {
        return new ArrayOfJPRequiredFieldValue();
    }

    /**
     * Create an instance of {@link JPRelPaxDist }
     * 
     */
    public JPRelPaxDist createJPRelPaxDist() {
        return new JPRelPaxDist();
    }

    /**
     * Create an instance of {@link JPLabelType }
     * 
     */
    public JPLabelType createJPLabelType() {
        return new JPLabelType();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelRatePlanSupplement }
     * 
     */
    public ArrayOfJPSOAPHotelRatePlanSupplement createArrayOfJPSOAPHotelRatePlanSupplement() {
        return new ArrayOfJPSOAPHotelRatePlanSupplement();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanFreePaxesOffer }
     * 
     */
    public JPSOAPHotelRatePlanFreePaxesOffer createJPSOAPHotelRatePlanFreePaxesOffer() {
        return new JPSOAPHotelRatePlanFreePaxesOffer();
    }

    /**
     * Create an instance of {@link ArrayOfJPTransferOption }
     * 
     */
    public ArrayOfJPTransferOption createArrayOfJPTransferOption() {
        return new ArrayOfJPTransferOption();
    }

    /**
     * Create an instance of {@link JPServiceOption }
     * 
     */
    public JPServiceOption createJPServiceOption() {
        return new JPServiceOption();
    }

    /**
     * Create an instance of {@link JPPriceInformationTransfer }
     * 
     */
    public JPPriceInformationTransfer createJPPriceInformationTransfer() {
        return new JPPriceInformationTransfer();
    }

    /**
     * Create an instance of {@link JPSearchSegmentTransfersByHotel }
     * 
     */
    public JPSearchSegmentTransfersByHotel createJPSearchSegmentTransfersByHotel() {
        return new JPSearchSegmentTransfersByHotel();
    }

    /**
     * Create an instance of {@link JPItemHotelInfo }
     * 
     */
    public JPItemHotelInfo createJPItemHotelInfo() {
        return new JPItemHotelInfo();
    }

    /**
     * Create an instance of {@link JPHotelOptionModify }
     * 
     */
    public JPHotelOptionModify createJPHotelOptionModify() {
        return new JPHotelOptionModify();
    }

    /**
     * Create an instance of {@link JPCreditCardInfo }
     * 
     */
    public JPCreditCardInfo createJPCreditCardInfo() {
        return new JPCreditCardInfo();
    }

    /**
     * Create an instance of {@link JPSOAPRatePrice }
     * 
     */
    public JPSOAPRatePrice createJPSOAPRatePrice() {
        return new JPSOAPRatePrice();
    }

    /**
     * Create an instance of {@link JPReservationLocationModify }
     * 
     */
    public JPReservationLocationModify createJPReservationLocationModify() {
        return new JPReservationLocationModify();
    }

    /**
     * Create an instance of {@link JPRentacarLocation }
     * 
     */
    public JPRentacarLocation createJPRentacarLocation() {
        return new JPRentacarLocation();
    }

    /**
     * Create an instance of {@link JPSOAPOrderedTypedPrice }
     * 
     */
    public JPSOAPOrderedTypedPrice createJPSOAPOrderedTypedPrice() {
        return new JPSOAPOrderedTypedPrice();
    }

    /**
     * Create an instance of {@link JPWarningDate }
     * 
     */
    public JPWarningDate createJPWarningDate() {
        return new JPWarningDate();
    }

    /**
     * Create an instance of {@link JPSupplementRelPax }
     * 
     */
    public JPSupplementRelPax createJPSupplementRelPax() {
        return new JPSupplementRelPax();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelRoomContract }
     * 
     */
    public ArrayOfJPHotelRoomContract createArrayOfJPHotelRoomContract() {
        return new ArrayOfJPHotelRoomContract();
    }

    /**
     * Create an instance of {@link JPCityComplex }
     * 
     */
    public JPCityComplex createJPCityComplex() {
        return new JPCityComplex();
    }

    /**
     * Create an instance of {@link JPServiceBookingRuleRequest }
     * 
     */
    public JPServiceBookingRuleRequest createJPServiceBookingRuleRequest() {
        return new JPServiceBookingRuleRequest();
    }

    /**
     * Create an instance of {@link JPFlightRule }
     * 
     */
    public JPFlightRule createJPFlightRule() {
        return new JPFlightRule();
    }

    /**
     * Create an instance of {@link ArrayOfJPFeature }
     * 
     */
    public ArrayOfJPFeature createArrayOfJPFeature() {
        return new ArrayOfJPFeature();
    }

    /**
     * Create an instance of {@link JPHotelOptionRequest }
     * 
     */
    public JPHotelOptionRequest createJPHotelOptionRequest() {
        return new JPHotelOptionRequest();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsShip }
     * 
     */
    public JPSearchSegmentsShip createJPSearchSegmentsShip() {
        return new JPSearchSegmentsShip();
    }

    /**
     * Create an instance of {@link JPHotelInfoPortfolio }
     * 
     */
    public JPHotelInfoPortfolio createJPHotelInfoPortfolio() {
        return new JPHotelInfoPortfolio();
    }

    /**
     * Create an instance of {@link JPRequestInsurancesAvail }
     * 
     */
    public JPRequestInsurancesAvail createJPRequestInsurancesAvail() {
        return new JPRequestInsurancesAvail();
    }

    /**
     * Create an instance of {@link JPHotelResultsBookingRules }
     * 
     */
    public JPHotelResultsBookingRules createJPHotelResultsBookingRules() {
        return new JPHotelResultsBookingRules();
    }

    /**
     * Create an instance of {@link JPConceptBreakdown }
     * 
     */
    public JPConceptBreakdown createJPConceptBreakdown() {
        return new JPConceptBreakdown();
    }

    /**
     * Create an instance of {@link ArrayOfJPHotelInventorySimpleInfo }
     * 
     */
    public ArrayOfJPHotelInventorySimpleInfo createArrayOfJPHotelInventorySimpleInfo() {
        return new ArrayOfJPHotelInventorySimpleInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPTransferBookingInfo }
     * 
     */
    public ArrayOfJPTransferBookingInfo createArrayOfJPTransferBookingInfo() {
        return new ArrayOfJPTransferBookingInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPCruisePromotion }
     * 
     */
    public ArrayOfJPCruisePromotion createArrayOfJPCruisePromotion() {
        return new ArrayOfJPCruisePromotion();
    }

    /**
     * Create an instance of {@link JPHotelDailyContract }
     * 
     */
    public JPHotelDailyContract createJPHotelDailyContract() {
        return new JPHotelDailyContract();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelRatePlanSpecialNoteText }
     * 
     */
    public ArrayOfJPSOAPHotelRatePlanSpecialNoteText createArrayOfJPSOAPHotelRatePlanSpecialNoteText() {
        return new ArrayOfJPSOAPHotelRatePlanSpecialNoteText();
    }

    /**
     * Create an instance of {@link JPCommonPriceBreakdownReduced }
     * 
     */
    public JPCommonPriceBreakdownReduced createJPCommonPriceBreakdownReduced() {
        return new JPCommonPriceBreakdownReduced();
    }

    /**
     * Create an instance of {@link JPHotelType }
     * 
     */
    public JPHotelType createJPHotelType() {
        return new JPHotelType();
    }

    /**
     * Create an instance of {@link JPPriceInformationService }
     * 
     */
    public JPPriceInformationService createJPPriceInformationService() {
        return new JPPriceInformationService();
    }

    /**
     * Create an instance of {@link JPFlightSegment }
     * 
     */
    public JPFlightSegment createJPFlightSegment() {
        return new JPFlightSegment();
    }

    /**
     * Create an instance of {@link ArrayOfJPDestination }
     * 
     */
    public ArrayOfJPDestination createArrayOfJPDestination() {
        return new ArrayOfJPDestination();
    }

    /**
     * Create an instance of {@link ArrayOfJPFlight }
     * 
     */
    public ArrayOfJPFlight createArrayOfJPFlight() {
        return new ArrayOfJPFlight();
    }

    /**
     * Create an instance of {@link JPSearchSegmentsItinerary }
     * 
     */
    public JPSearchSegmentsItinerary createJPSearchSegmentsItinerary() {
        return new JPSearchSegmentsItinerary();
    }

    /**
     * Create an instance of {@link JPTrainInfo }
     * 
     */
    public JPTrainInfo createJPTrainInfo() {
        return new JPTrainInfo();
    }

    /**
     * Create an instance of {@link JPFlightBookingInfo }
     * 
     */
    public JPFlightBookingInfo createJPFlightBookingInfo() {
        return new JPFlightBookingInfo();
    }

    /**
     * Create an instance of {@link JPPriceInformationPackage }
     * 
     */
    public JPPriceInformationPackage createJPPriceInformationPackage() {
        return new JPPriceInformationPackage();
    }

    /**
     * Create an instance of {@link JPPackageBookingRuleRequest }
     * 
     */
    public JPPackageBookingRuleRequest createJPPackageBookingRuleRequest() {
        return new JPPackageBookingRuleRequest();
    }

    /**
     * Create an instance of {@link JPServiceItem }
     * 
     */
    public JPServiceItem createJPServiceItem() {
        return new JPServiceItem();
    }

    /**
     * Create an instance of {@link JPRentacarBookLocationDetails }
     * 
     */
    public JPRentacarBookLocationDetails createJPRentacarBookLocationDetails() {
        return new JPRentacarBookLocationDetails();
    }

    /**
     * Create an instance of {@link JPInfoExtra }
     * 
     */
    public JPInfoExtra createJPInfoExtra() {
        return new JPInfoExtra();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPOrderedTypedPrice3 }
     * 
     */
    public ArrayOfJPSOAPOrderedTypedPrice3 createArrayOfJPSOAPOrderedTypedPrice3() {
        return new ArrayOfJPSOAPOrderedTypedPrice3();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPOrderedTypedPrice2 }
     * 
     */
    public ArrayOfJPSOAPOrderedTypedPrice2 createArrayOfJPSOAPOrderedTypedPrice2() {
        return new ArrayOfJPSOAPOrderedTypedPrice2();
    }

    /**
     * Create an instance of {@link JPServiceOptionRQ }
     * 
     */
    public JPServiceOptionRQ createJPServiceOptionRQ() {
        return new JPServiceOptionRQ();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPOrderedTypedPrice1 }
     * 
     */
    public ArrayOfJPSOAPOrderedTypedPrice1 createArrayOfJPSOAPOrderedTypedPrice1() {
        return new ArrayOfJPSOAPOrderedTypedPrice1();
    }

    /**
     * Create an instance of {@link JPCruiseCabinServices }
     * 
     */
    public JPCruiseCabinServices createJPCruiseCabinServices() {
        return new JPCruiseCabinServices();
    }

    /**
     * Create an instance of {@link JPVisaInfo }
     * 
     */
    public JPVisaInfo createJPVisaInfo() {
        return new JPVisaInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJPFlightRate }
     * 
     */
    public ArrayOfJPFlightRate createArrayOfJPFlightRate() {
        return new ArrayOfJPFlightRate();
    }

    /**
     * Create an instance of {@link ArrayOfArrayOfJPSOAPHotelRatePlanSpecialNoteText }
     * 
     */
    public ArrayOfArrayOfJPSOAPHotelRatePlanSpecialNoteText createArrayOfArrayOfJPSOAPHotelRatePlanSpecialNoteText() {
        return new ArrayOfArrayOfJPSOAPHotelRatePlanSpecialNoteText();
    }

    /**
     * Create an instance of {@link JPMeetingPointsZone }
     * 
     */
    public JPMeetingPointsZone createJPMeetingPointsZone() {
        return new JPMeetingPointsZone();
    }

    /**
     * Create an instance of {@link JPRentacarBookingRulesRequest }
     * 
     */
    public JPRentacarBookingRulesRequest createJPRentacarBookingRulesRequest() {
        return new JPRentacarBookingRulesRequest();
    }

    /**
     * Create an instance of {@link JPRequest }
     * 
     */
    public JPRequest createJPRequest() {
        return new JPRequest();
    }

    /**
     * Create an instance of {@link JPRelPax }
     * 
     */
    public JPRelPax createJPRelPax() {
        return new JPRelPax();
    }

    /**
     * Create an instance of {@link JPVisaCheckAvailRequest }
     * 
     */
    public JPVisaCheckAvailRequest createJPVisaCheckAvailRequest() {
        return new JPVisaCheckAvailRequest();
    }

    /**
     * Create an instance of {@link JPSOAPOrder }
     * 
     */
    public JPSOAPOrder createJPSOAPOrder() {
        return new JPSOAPOrder();
    }

    /**
     * Create an instance of {@link ArrayOfJPCreditCard }
     * 
     */
    public ArrayOfJPCreditCard createArrayOfJPCreditCard() {
        return new ArrayOfJPCreditCard();
    }

    /**
     * Create an instance of {@link ArrayOfJPProductSupplier }
     * 
     */
    public ArrayOfJPProductSupplier createArrayOfJPProductSupplier() {
        return new ArrayOfJPProductSupplier();
    }

    /**
     * Create an instance of {@link JPTransferRequest }
     * 
     */
    public JPTransferRequest createJPTransferRequest() {
        return new JPTransferRequest();
    }

    /**
     * Create an instance of {@link JPCar }
     * 
     */
    public JPCar createJPCar() {
        return new JPCar();
    }

    /**
     * Create an instance of {@link JPFinalCustomerContactAddressData }
     * 
     */
    public JPFinalCustomerContactAddressData createJPFinalCustomerContactAddressData() {
        return new JPFinalCustomerContactAddressData();
    }

    /**
     * Create an instance of {@link JPWarningType }
     * 
     */
    public JPWarningType createJPWarningType() {
        return new JPWarningType();
    }

    /**
     * Create an instance of {@link JPHotelService }
     * 
     */
    public JPHotelService createJPHotelService() {
        return new JPHotelService();
    }

    /**
     * Create an instance of {@link JPFareGroupService }
     * 
     */
    public JPFareGroupService createJPFareGroupService() {
        return new JPFareGroupService();
    }

    /**
     * Create an instance of {@link JPRequestHotelsAvail }
     * 
     */
    public JPRequestHotelsAvail createJPRequestHotelsAvail() {
        return new JPRequestHotelsAvail();
    }

    /**
     * Create an instance of {@link JPRentacarLocationSimpleContent }
     * 
     */
    public JPRentacarLocationSimpleContent createJPRentacarLocationSimpleContent() {
        return new JPRentacarLocationSimpleContent();
    }

    /**
     * Create an instance of {@link JPSOAPHotelRatePlanOfferPaymentConditions }
     * 
     */
    public JPSOAPHotelRatePlanOfferPaymentConditions createJPSOAPHotelRatePlanOfferPaymentConditions() {
        return new JPSOAPHotelRatePlanOfferPaymentConditions();
    }

    /**
     * Create an instance of {@link ArrayOfJPRoomInfo }
     * 
     */
    public ArrayOfJPRoomInfo createArrayOfJPRoomInfo() {
        return new ArrayOfJPRoomInfo();
    }

    /**
     * Create an instance of {@link JPPackageInfo }
     * 
     */
    public JPPackageInfo createJPPackageInfo() {
        return new JPPackageInfo();
    }

    /**
     * Create an instance of {@link JPTransferElement }
     * 
     */
    public JPTransferElement createJPTransferElement() {
        return new JPTransferElement();
    }

    /**
     * Create an instance of {@link JPHotelResultModify }
     * 
     */
    public JPHotelResultModify createJPHotelResultModify() {
        return new JPHotelResultModify();
    }

    /**
     * Create an instance of {@link JPSOAPHotelInventoryDescription }
     * 
     */
    public JPSOAPHotelInventoryDescription createJPSOAPHotelInventoryDescription() {
        return new JPSOAPHotelInventoryDescription();
    }

    /**
     * Create an instance of {@link ArrayOfJPPackageAdditionalElement }
     * 
     */
    public ArrayOfJPPackageAdditionalElement createArrayOfJPPackageAdditionalElement() {
        return new ArrayOfJPPackageAdditionalElement();
    }

    /**
     * Create an instance of {@link ArrayOfJPBookingListRSReservation.Reservation }
     * 
     */
    public ArrayOfJPBookingListRSReservation.Reservation createArrayOfJPBookingListRSReservationReservation() {
        return new ArrayOfJPBookingListRSReservation.Reservation();
    }

    /**
     * Create an instance of {@link ArrayOfJPSOAPHotelInventorySpecialNotesNote.Note }
     * 
     */
    public ArrayOfJPSOAPHotelInventorySpecialNotesNote.Note createArrayOfJPSOAPHotelInventorySpecialNotesNoteNote() {
        return new ArrayOfJPSOAPHotelInventorySpecialNotesNote.Note();
    }

    /**
     * Create an instance of {@link JPBookingListRequest.StartingBookingDate }
     * 
     */
    public JPBookingListRequest.StartingBookingDate createJPBookingListRequestStartingBookingDate() {
        return new JPBookingListRequest.StartingBookingDate();
    }

    /**
     * Create an instance of {@link JPBookingListRequest.CancellationBookingDate }
     * 
     */
    public JPBookingListRequest.CancellationBookingDate createJPBookingListRequestCancellationBookingDate() {
        return new JPBookingListRequest.CancellationBookingDate();
    }

    /**
     * Create an instance of {@link JPBookingListRequest.ModificationBookingDate }
     * 
     */
    public JPBookingListRequest.ModificationBookingDate createJPBookingListRequestModificationBookingDate() {
        return new JPBookingListRequest.ModificationBookingDate();
    }

    /**
     * Create an instance of {@link JPBookingListRequest.BookingDate }
     * 
     */
    public JPBookingListRequest.BookingDate createJPBookingListRequestBookingDate() {
        return new JPBookingListRequest.BookingDate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPVisaInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "VisaInfo", scope = JPVisaItem.class)
    public JAXBElement<JPVisaInfo> createJPVisaItemVisaInfo(JPVisaInfo value) {
        return new JAXBElement<JPVisaInfo>(_JPVisaItemVisaInfo_QNAME, JPVisaInfo.class, JPVisaItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJPVisaOption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "VisaOptions", scope = JPVisaItem.class)
    public JAXBElement<ArrayOfJPVisaOption> createJPVisaItemVisaOptions(ArrayOfJPVisaOption value) {
        return new JAXBElement<ArrayOfJPVisaOption>(_JPVisaItemVisaOptions_QNAME, ArrayOfJPVisaOption.class, JPVisaItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPCancellationPolicyRules }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CancellationPolicy", scope = JPVisaItem.class)
    public JAXBElement<JPCancellationPolicyRules> createJPVisaItemCancellationPolicy(JPCancellationPolicyRules value) {
        return new JAXBElement<JPCancellationPolicyRules>(_JPVisaItemCancellationPolicy_QNAME, JPCancellationPolicyRules.class, JPVisaItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPPackageAdditionalElements }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "AdditionalElements", scope = JPVisaItem.class)
    public JAXBElement<JPPackageAdditionalElements> createJPVisaItemAdditionalElements(JPPackageAdditionalElements value) {
        return new JAXBElement<JPPackageAdditionalElements>(_JPVisaItemAdditionalElements_QNAME, JPPackageAdditionalElements.class, JPVisaItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJPRelPax }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "RelPaxes", scope = JPVisaItem.class)
    public JAXBElement<ArrayOfJPRelPax> createJPVisaItemRelPaxes(ArrayOfJPRelPax value) {
        return new JAXBElement<ArrayOfJPRelPax>(_JPVisaItemRelPaxes_QNAME, ArrayOfJPRelPax.class, JPVisaItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJPServiceOption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "ServiceOptions", scope = JPServiceItem.class)
    public JAXBElement<ArrayOfJPServiceOption> createJPServiceItemServiceOptions(ArrayOfJPServiceOption value) {
        return new JAXBElement<ArrayOfJPServiceOption>(_JPServiceItemServiceOptions_QNAME, ArrayOfJPServiceOption.class, JPServiceItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPServiceInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "ServiceInfo", scope = JPServiceItem.class)
    public JAXBElement<JPServiceInfo> createJPServiceItemServiceInfo(JPServiceInfo value) {
        return new JAXBElement<JPServiceInfo>(_JPServiceItemServiceInfo_QNAME, JPServiceInfo.class, JPServiceItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPCancellationPolicyRules }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CancellationPolicy", scope = JPServiceItem.class)
    public JAXBElement<JPCancellationPolicyRules> createJPServiceItemCancellationPolicy(JPCancellationPolicyRules value) {
        return new JAXBElement<JPCancellationPolicyRules>(_JPVisaItemCancellationPolicy_QNAME, JPCancellationPolicyRules.class, JPServiceItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPPackageAdditionalElements }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "AdditionalElements", scope = JPServiceItem.class)
    public JAXBElement<JPPackageAdditionalElements> createJPServiceItemAdditionalElements(JPPackageAdditionalElements value) {
        return new JAXBElement<JPPackageAdditionalElements>(_JPVisaItemAdditionalElements_QNAME, JPPackageAdditionalElements.class, JPServiceItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJPRelPax }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "RelPaxes", scope = JPServiceItem.class)
    public JAXBElement<ArrayOfJPRelPax> createJPServiceItemRelPaxes(ArrayOfJPRelPax value) {
        return new JAXBElement<ArrayOfJPRelPax>(_JPVisaItemRelPaxes_QNAME, ArrayOfJPRelPax.class, JPServiceItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPPackageInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "PackageInfo", scope = JPPackageItem.class)
    public JAXBElement<JPPackageInfo> createJPPackageItemPackageInfo(JPPackageInfo value) {
        return new JAXBElement<JPPackageInfo>(_JPPackageItemPackageInfo_QNAME, JPPackageInfo.class, JPPackageItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJPPackageStay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "Stays", scope = JPPackageItem.class)
    public JAXBElement<ArrayOfJPPackageStay> createJPPackageItemStays(ArrayOfJPPackageStay value) {
        return new JAXBElement<ArrayOfJPPackageStay>(_JPPackageItemStays_QNAME, ArrayOfJPPackageStay.class, JPPackageItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPCancellationPolicyRules }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CancellationPolicy", scope = JPPackageItem.class)
    public JAXBElement<JPCancellationPolicyRules> createJPPackageItemCancellationPolicy(JPCancellationPolicyRules value) {
        return new JAXBElement<JPCancellationPolicyRules>(_JPVisaItemCancellationPolicy_QNAME, JPCancellationPolicyRules.class, JPPackageItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPPackageAdditionalElements }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "AdditionalElements", scope = JPPackageItem.class)
    public JAXBElement<JPPackageAdditionalElements> createJPPackageItemAdditionalElements(JPPackageAdditionalElements value) {
        return new JAXBElement<JPPackageAdditionalElements>(_JPVisaItemAdditionalElements_QNAME, JPPackageAdditionalElements.class, JPPackageItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJPRelPax }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "RelPaxes", scope = JPPackageItem.class)
    public JAXBElement<ArrayOfJPRelPax> createJPPackageItemRelPaxes(ArrayOfJPRelPax value) {
        return new JAXBElement<ArrayOfJPRelPax>(_JPVisaItemRelPaxes_QNAME, ArrayOfJPRelPax.class, JPPackageItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJPPackageInfoAFIPAmount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "AFIPInformation", scope = JPPackageItem.class)
    public JAXBElement<ArrayOfJPPackageInfoAFIPAmount> createJPPackageItemAFIPInformation(ArrayOfJPPackageInfoAFIPAmount value) {
        return new JAXBElement<ArrayOfJPPackageInfoAFIPAmount>(_JPPackageItemAFIPInformation_QNAME, ArrayOfJPPackageInfoAFIPAmount.class, JPPackageItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJPTransferOption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "TransferOptions", scope = JPTransferItem.class)
    public JAXBElement<ArrayOfJPTransferOption> createJPTransferItemTransferOptions(ArrayOfJPTransferOption value) {
        return new JAXBElement<ArrayOfJPTransferOption>(_JPTransferItemTransferOptions_QNAME, ArrayOfJPTransferOption.class, JPTransferItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPCancellationPolicyRules }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CancellationPolicy", scope = JPTransferItem.class)
    public JAXBElement<JPCancellationPolicyRules> createJPTransferItemCancellationPolicy(JPCancellationPolicyRules value) {
        return new JAXBElement<JPCancellationPolicyRules>(_JPVisaItemCancellationPolicy_QNAME, JPCancellationPolicyRules.class, JPTransferItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPPackageAdditionalElements }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "AdditionalElements", scope = JPTransferItem.class)
    public JAXBElement<JPPackageAdditionalElements> createJPTransferItemAdditionalElements(JPPackageAdditionalElements value) {
        return new JAXBElement<JPPackageAdditionalElements>(_JPVisaItemAdditionalElements_QNAME, JPPackageAdditionalElements.class, JPTransferItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfJPRelPax }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "RelPaxes", scope = JPTransferItem.class)
    public JAXBElement<ArrayOfJPRelPax> createJPTransferItemRelPaxes(ArrayOfJPRelPax value) {
        return new JAXBElement<ArrayOfJPRelPax>(_JPVisaItemRelPaxes_QNAME, ArrayOfJPRelPax.class, JPTransferItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JPTransferInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "TransferInfo", scope = JPTransferItem.class)
    public JAXBElement<JPTransferInfo> createJPTransferItemTransferInfo(JPTransferInfo value) {
        return new JAXBElement<JPTransferInfo>(_JPTransferItemTransferInfo_QNAME, JPTransferInfo.class, JPTransferItem.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.juniper.es/webservice/2007/", name = "Age", scope = JPPax.class)
    public JAXBElement<Integer> createJPPaxAge(Integer value) {
        return new JAXBElement<Integer>(_JPPaxAge_QNAME, Integer.class, JPPax.class, value);
    }

}
