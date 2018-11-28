
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_StaticDataRS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_StaticDataRS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Errors" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ErrorType" minOccurs="0"/>
 *         &lt;element name="Warnings" type="{http://www.juniper.es/webservice/2007/}JP_Warnings" minOccurs="0"/>
 *         &lt;element name="Debugs" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Debug" minOccurs="0"/>
 *         &lt;element name="CruiseStaticData" type="{http://www.juniper.es/webservice/2007/}JP_CruiseItemStaticData" minOccurs="0"/>
 *         &lt;element name="HotelStaticData" type="{http://www.juniper.es/webservice/2007/}JP_HotelItemStaticData" minOccurs="0"/>
 *         &lt;element name="ZoneList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Zone" minOccurs="0"/>
 *         &lt;element name="CityList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CityComplex" minOccurs="0"/>
 *         &lt;element name="FinalCustomerList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_FinalCustomerStaticData" minOccurs="0"/>
 *         &lt;element name="AgencyList" type="{http://www.juniper.es/webservice/2007/}JP_AgencyList" minOccurs="0"/>
 *         &lt;element name="GenericDataCatalogue" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_GenericCatalogueItem" minOccurs="0"/>
 *         &lt;element name="HotelList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelSimpleInfo" minOccurs="0"/>
 *         &lt;element name="ExtendedHotelList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ExtendedHotelInfo" minOccurs="0"/>
 *         &lt;element name="PackageList" type="{http://www.juniper.es/webservice/2007/}JP_PackageList" minOccurs="0"/>
 *         &lt;element name="RentacarLocationList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RentacarLocationSimpleInfo" minOccurs="0"/>
 *         &lt;element name="PackageSearcher" type="{http://www.juniper.es/webservice/2007/}JP_PackageSearcherRS" minOccurs="0"/>
 *         &lt;element name="SupplierListRS" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ProductSupplier" minOccurs="0"/>
 *         &lt;element name="ServiceStaticData" type="{http://www.juniper.es/webservice/2007/}JP_ServiceItemStaticData" minOccurs="0"/>
 *         &lt;element name="ServicePortfolio" type="{http://www.juniper.es/webservice/2007/}JP_ServicePortfolio" minOccurs="0"/>
 *         &lt;element name="TransferStaticData" type="{http://www.juniper.es/webservice/2007/}JP_TransferItemStaticData" minOccurs="0"/>
 *         &lt;element name="VisaStaticData" type="{http://www.juniper.es/webservice/2007/}JP_VisaItemStaticData" minOccurs="0"/>
 *         &lt;element name="MeetingPointList" type="{http://www.juniper.es/webservice/2007/}JP_MeetingPointList" minOccurs="0"/>
 *         &lt;element name="PackageCalendarPrice" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageCalendarPriceItems" minOccurs="0"/>
 *         &lt;element name="HotelPortfolio" type="{http://www.juniper.es/webservice/2007/}JP_HotelPortfolio" minOccurs="0"/>
 *         &lt;element name="RoomList" type="{http://www.juniper.es/webservice/2007/}JP_RoomList" minOccurs="0"/>
 *         &lt;element name="UserPermissions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_UserPermission" minOccurs="0"/>
 *         &lt;element name="ZoneInfolist" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ZoneInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Url" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="IntCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_StaticDataRS", propOrder = {
    "errors",
    "warnings",
    "debugs",
    "cruiseStaticData",
    "hotelStaticData",
    "zoneList",
    "cityList",
    "finalCustomerList",
    "agencyList",
    "genericDataCatalogue",
    "hotelList",
    "extendedHotelList",
    "packageList",
    "rentacarLocationList",
    "packageSearcher",
    "supplierListRS",
    "serviceStaticData",
    "servicePortfolio",
    "transferStaticData",
    "visaStaticData",
    "meetingPointList",
    "packageCalendarPrice",
    "hotelPortfolio",
    "roomList",
    "userPermissions",
    "zoneInfolist"
})
public class JPStaticDataRS {

    @XmlElement(name = "Errors")
    protected ArrayOfJPErrorType errors;
    @XmlElement(name = "Warnings")
    protected JPWarnings warnings;
    @XmlElement(name = "Debugs")
    protected ArrayOfJPDebug debugs;
    @XmlElement(name = "CruiseStaticData")
    protected JPCruiseItemStaticData cruiseStaticData;
    @XmlElement(name = "HotelStaticData")
    protected JPHotelItemStaticData hotelStaticData;
    @XmlElement(name = "ZoneList")
    protected ArrayOfJPZone zoneList;
    @XmlElement(name = "CityList")
    protected ArrayOfJPCityComplex cityList;
    @XmlElement(name = "FinalCustomerList")
    protected ArrayOfJPFinalCustomerStaticData finalCustomerList;
    @XmlElement(name = "AgencyList")
    protected JPAgencyList agencyList;
    @XmlElement(name = "GenericDataCatalogue")
    protected ArrayOfJPGenericCatalogueItem genericDataCatalogue;
    @XmlElement(name = "HotelList")
    protected ArrayOfJPHotelSimpleInfo hotelList;
    @XmlElement(name = "ExtendedHotelList")
    protected ArrayOfJPExtendedHotelInfo extendedHotelList;
    @XmlElement(name = "PackageList")
    protected JPPackageList packageList;
    @XmlElement(name = "RentacarLocationList")
    protected ArrayOfJPRentacarLocationSimpleInfo rentacarLocationList;
    @XmlElement(name = "PackageSearcher")
    protected JPPackageSearcherRS packageSearcher;
    @XmlElement(name = "SupplierListRS")
    protected ArrayOfJPProductSupplier supplierListRS;
    @XmlElement(name = "ServiceStaticData")
    protected JPServiceItemStaticData serviceStaticData;
    @XmlElement(name = "ServicePortfolio")
    protected JPServicePortfolio servicePortfolio;
    @XmlElement(name = "TransferStaticData")
    protected JPTransferItemStaticData transferStaticData;
    @XmlElement(name = "VisaStaticData")
    protected JPVisaItemStaticData visaStaticData;
    @XmlElement(name = "MeetingPointList")
    protected JPMeetingPointList meetingPointList;
    @XmlElement(name = "PackageCalendarPrice")
    protected ArrayOfJPPackageCalendarPriceItems packageCalendarPrice;
    @XmlElement(name = "HotelPortfolio")
    protected JPHotelPortfolio hotelPortfolio;
    @XmlElement(name = "RoomList")
    protected JPRoomList roomList;
    @XmlElement(name = "UserPermissions")
    protected ArrayOfJPUserPermission userPermissions;
    @XmlElement(name = "ZoneInfolist")
    protected ArrayOfJPZoneInfo zoneInfolist;
    @XmlAttribute(name = "Url")
    protected String url;
    @XmlAttribute(name = "TimeStamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp;
    @XmlAttribute(name = "IntCode")
    protected String intCode;

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPErrorType }
     *     
     */
    public ArrayOfJPErrorType getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPErrorType }
     *     
     */
    public void setErrors(ArrayOfJPErrorType value) {
        this.errors = value;
    }

    /**
     * Gets the value of the warnings property.
     * 
     * @return
     *     possible object is
     *     {@link JPWarnings }
     *     
     */
    public JPWarnings getWarnings() {
        return warnings;
    }

    /**
     * Sets the value of the warnings property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPWarnings }
     *     
     */
    public void setWarnings(JPWarnings value) {
        this.warnings = value;
    }

    /**
     * Gets the value of the debugs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPDebug }
     *     
     */
    public ArrayOfJPDebug getDebugs() {
        return debugs;
    }

    /**
     * Sets the value of the debugs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPDebug }
     *     
     */
    public void setDebugs(ArrayOfJPDebug value) {
        this.debugs = value;
    }

    /**
     * Gets the value of the cruiseStaticData property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseItemStaticData }
     *     
     */
    public JPCruiseItemStaticData getCruiseStaticData() {
        return cruiseStaticData;
    }

    /**
     * Sets the value of the cruiseStaticData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseItemStaticData }
     *     
     */
    public void setCruiseStaticData(JPCruiseItemStaticData value) {
        this.cruiseStaticData = value;
    }

    /**
     * Gets the value of the hotelStaticData property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelItemStaticData }
     *     
     */
    public JPHotelItemStaticData getHotelStaticData() {
        return hotelStaticData;
    }

    /**
     * Sets the value of the hotelStaticData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelItemStaticData }
     *     
     */
    public void setHotelStaticData(JPHotelItemStaticData value) {
        this.hotelStaticData = value;
    }

    /**
     * Gets the value of the zoneList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPZone }
     *     
     */
    public ArrayOfJPZone getZoneList() {
        return zoneList;
    }

    /**
     * Sets the value of the zoneList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPZone }
     *     
     */
    public void setZoneList(ArrayOfJPZone value) {
        this.zoneList = value;
    }

    /**
     * Gets the value of the cityList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCityComplex }
     *     
     */
    public ArrayOfJPCityComplex getCityList() {
        return cityList;
    }

    /**
     * Sets the value of the cityList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCityComplex }
     *     
     */
    public void setCityList(ArrayOfJPCityComplex value) {
        this.cityList = value;
    }

    /**
     * Gets the value of the finalCustomerList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFinalCustomerStaticData }
     *     
     */
    public ArrayOfJPFinalCustomerStaticData getFinalCustomerList() {
        return finalCustomerList;
    }

    /**
     * Sets the value of the finalCustomerList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFinalCustomerStaticData }
     *     
     */
    public void setFinalCustomerList(ArrayOfJPFinalCustomerStaticData value) {
        this.finalCustomerList = value;
    }

    /**
     * Gets the value of the agencyList property.
     * 
     * @return
     *     possible object is
     *     {@link JPAgencyList }
     *     
     */
    public JPAgencyList getAgencyList() {
        return agencyList;
    }

    /**
     * Sets the value of the agencyList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAgencyList }
     *     
     */
    public void setAgencyList(JPAgencyList value) {
        this.agencyList = value;
    }

    /**
     * Gets the value of the genericDataCatalogue property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPGenericCatalogueItem }
     *     
     */
    public ArrayOfJPGenericCatalogueItem getGenericDataCatalogue() {
        return genericDataCatalogue;
    }

    /**
     * Sets the value of the genericDataCatalogue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPGenericCatalogueItem }
     *     
     */
    public void setGenericDataCatalogue(ArrayOfJPGenericCatalogueItem value) {
        this.genericDataCatalogue = value;
    }

    /**
     * Gets the value of the hotelList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelSimpleInfo }
     *     
     */
    public ArrayOfJPHotelSimpleInfo getHotelList() {
        return hotelList;
    }

    /**
     * Sets the value of the hotelList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelSimpleInfo }
     *     
     */
    public void setHotelList(ArrayOfJPHotelSimpleInfo value) {
        this.hotelList = value;
    }

    /**
     * Gets the value of the extendedHotelList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPExtendedHotelInfo }
     *     
     */
    public ArrayOfJPExtendedHotelInfo getExtendedHotelList() {
        return extendedHotelList;
    }

    /**
     * Sets the value of the extendedHotelList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPExtendedHotelInfo }
     *     
     */
    public void setExtendedHotelList(ArrayOfJPExtendedHotelInfo value) {
        this.extendedHotelList = value;
    }

    /**
     * Gets the value of the packageList property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageList }
     *     
     */
    public JPPackageList getPackageList() {
        return packageList;
    }

    /**
     * Sets the value of the packageList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageList }
     *     
     */
    public void setPackageList(JPPackageList value) {
        this.packageList = value;
    }

    /**
     * Gets the value of the rentacarLocationList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRentacarLocationSimpleInfo }
     *     
     */
    public ArrayOfJPRentacarLocationSimpleInfo getRentacarLocationList() {
        return rentacarLocationList;
    }

    /**
     * Sets the value of the rentacarLocationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRentacarLocationSimpleInfo }
     *     
     */
    public void setRentacarLocationList(ArrayOfJPRentacarLocationSimpleInfo value) {
        this.rentacarLocationList = value;
    }

    /**
     * Gets the value of the packageSearcher property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageSearcherRS }
     *     
     */
    public JPPackageSearcherRS getPackageSearcher() {
        return packageSearcher;
    }

    /**
     * Sets the value of the packageSearcher property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageSearcherRS }
     *     
     */
    public void setPackageSearcher(JPPackageSearcherRS value) {
        this.packageSearcher = value;
    }

    /**
     * Gets the value of the supplierListRS property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPProductSupplier }
     *     
     */
    public ArrayOfJPProductSupplier getSupplierListRS() {
        return supplierListRS;
    }

    /**
     * Sets the value of the supplierListRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPProductSupplier }
     *     
     */
    public void setSupplierListRS(ArrayOfJPProductSupplier value) {
        this.supplierListRS = value;
    }

    /**
     * Gets the value of the serviceStaticData property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceItemStaticData }
     *     
     */
    public JPServiceItemStaticData getServiceStaticData() {
        return serviceStaticData;
    }

    /**
     * Sets the value of the serviceStaticData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceItemStaticData }
     *     
     */
    public void setServiceStaticData(JPServiceItemStaticData value) {
        this.serviceStaticData = value;
    }

    /**
     * Gets the value of the servicePortfolio property.
     * 
     * @return
     *     possible object is
     *     {@link JPServicePortfolio }
     *     
     */
    public JPServicePortfolio getServicePortfolio() {
        return servicePortfolio;
    }

    /**
     * Sets the value of the servicePortfolio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServicePortfolio }
     *     
     */
    public void setServicePortfolio(JPServicePortfolio value) {
        this.servicePortfolio = value;
    }

    /**
     * Gets the value of the transferStaticData property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferItemStaticData }
     *     
     */
    public JPTransferItemStaticData getTransferStaticData() {
        return transferStaticData;
    }

    /**
     * Sets the value of the transferStaticData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferItemStaticData }
     *     
     */
    public void setTransferStaticData(JPTransferItemStaticData value) {
        this.transferStaticData = value;
    }

    /**
     * Gets the value of the visaStaticData property.
     * 
     * @return
     *     possible object is
     *     {@link JPVisaItemStaticData }
     *     
     */
    public JPVisaItemStaticData getVisaStaticData() {
        return visaStaticData;
    }

    /**
     * Sets the value of the visaStaticData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPVisaItemStaticData }
     *     
     */
    public void setVisaStaticData(JPVisaItemStaticData value) {
        this.visaStaticData = value;
    }

    /**
     * Gets the value of the meetingPointList property.
     * 
     * @return
     *     possible object is
     *     {@link JPMeetingPointList }
     *     
     */
    public JPMeetingPointList getMeetingPointList() {
        return meetingPointList;
    }

    /**
     * Sets the value of the meetingPointList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPMeetingPointList }
     *     
     */
    public void setMeetingPointList(JPMeetingPointList value) {
        this.meetingPointList = value;
    }

    /**
     * Gets the value of the packageCalendarPrice property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageCalendarPriceItems }
     *     
     */
    public ArrayOfJPPackageCalendarPriceItems getPackageCalendarPrice() {
        return packageCalendarPrice;
    }

    /**
     * Sets the value of the packageCalendarPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageCalendarPriceItems }
     *     
     */
    public void setPackageCalendarPrice(ArrayOfJPPackageCalendarPriceItems value) {
        this.packageCalendarPrice = value;
    }

    /**
     * Gets the value of the hotelPortfolio property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelPortfolio }
     *     
     */
    public JPHotelPortfolio getHotelPortfolio() {
        return hotelPortfolio;
    }

    /**
     * Sets the value of the hotelPortfolio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelPortfolio }
     *     
     */
    public void setHotelPortfolio(JPHotelPortfolio value) {
        this.hotelPortfolio = value;
    }

    /**
     * Gets the value of the roomList property.
     * 
     * @return
     *     possible object is
     *     {@link JPRoomList }
     *     
     */
    public JPRoomList getRoomList() {
        return roomList;
    }

    /**
     * Sets the value of the roomList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRoomList }
     *     
     */
    public void setRoomList(JPRoomList value) {
        this.roomList = value;
    }

    /**
     * Gets the value of the userPermissions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPUserPermission }
     *     
     */
    public ArrayOfJPUserPermission getUserPermissions() {
        return userPermissions;
    }

    /**
     * Sets the value of the userPermissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPUserPermission }
     *     
     */
    public void setUserPermissions(ArrayOfJPUserPermission value) {
        this.userPermissions = value;
    }

    /**
     * Gets the value of the zoneInfolist property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPZoneInfo }
     *     
     */
    public ArrayOfJPZoneInfo getZoneInfolist() {
        return zoneInfolist;
    }

    /**
     * Sets the value of the zoneInfolist property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPZoneInfo }
     *     
     */
    public void setZoneInfolist(ArrayOfJPZoneInfo value) {
        this.zoneInfolist = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp(XMLGregorianCalendar value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the intCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntCode() {
        return intCode;
    }

    /**
     * Sets the value of the intCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntCode(String value) {
        this.intCode = value;
    }

}
