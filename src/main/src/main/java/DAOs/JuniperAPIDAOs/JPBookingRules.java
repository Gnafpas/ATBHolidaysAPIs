
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_BookingRules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_BookingRules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="CruiseResult" type="{http://www.juniper.es/webservice/2007/}JP_CruiseResultsBookingRules" minOccurs="0"/>
 *           &lt;element name="FlightResult" type="{http://www.juniper.es/webservice/2007/}JP_FlightBookingRules" minOccurs="0"/>
 *           &lt;element name="HotelResult" type="{http://www.juniper.es/webservice/2007/}JP_HotelResultsBookingRules" minOccurs="0"/>
 *           &lt;element name="InsuranceResult" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceBookingRules" minOccurs="0"/>
 *           &lt;element name="PackageResult" type="{http://www.juniper.es/webservice/2007/}JP_PackageBookingRules" minOccurs="0"/>
 *           &lt;element name="RentacarResult" type="{http://www.juniper.es/webservice/2007/}JP_RentacarResultsBookingRules" minOccurs="0"/>
 *           &lt;element name="ServiceResult" type="{http://www.juniper.es/webservice/2007/}JP_ServiceBookingRules" minOccurs="0"/>
 *           &lt;element name="TransferResult" type="{http://www.juniper.es/webservice/2007/}JP_TransferBookingRules" minOccurs="0"/>
 *           &lt;element name="VisaResult" type="{http://www.juniper.es/webservice/2007/}JP_VisaBookingRules" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_BookingRules", propOrder = {
    "cruiseResultOrFlightResultOrHotelResult"
})
public class JPBookingRules {

    @XmlElements({
        @XmlElement(name = "CruiseResult", type = JPCruiseResultsBookingRules.class),
        @XmlElement(name = "FlightResult", type = JPFlightBookingRules.class),
        @XmlElement(name = "HotelResult", type = JPHotelResultsBookingRules.class),
        @XmlElement(name = "InsuranceResult", type = JPInsuranceBookingRules.class),
        @XmlElement(name = "PackageResult", type = JPPackageBookingRules.class),
        @XmlElement(name = "RentacarResult", type = JPRentacarResultsBookingRules.class),
        @XmlElement(name = "ServiceResult", type = JPServiceBookingRules.class),
        @XmlElement(name = "TransferResult", type = JPTransferBookingRules.class),
        @XmlElement(name = "VisaResult", type = JPVisaBookingRules.class)
    })
    protected List<Object> cruiseResultOrFlightResultOrHotelResult;

    /**
     * Gets the value of the cruiseResultOrFlightResultOrHotelResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cruiseResultOrFlightResultOrHotelResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCruiseResultOrFlightResultOrHotelResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPCruiseResultsBookingRules }
     * {@link JPFlightBookingRules }
     * {@link JPHotelResultsBookingRules }
     * {@link JPInsuranceBookingRules }
     * {@link JPPackageBookingRules }
     * {@link JPRentacarResultsBookingRules }
     * {@link JPServiceBookingRules }
     * {@link JPTransferBookingRules }
     * {@link JPVisaBookingRules }
     * 
     * 
     */
    public List<Object> getCruiseResultOrFlightResultOrHotelResult() {
        if (cruiseResultOrFlightResultOrHotelResult == null) {
            cruiseResultOrFlightResultOrHotelResult = new ArrayList<Object>();
        }
        return this.cruiseResultOrFlightResultOrHotelResult;
    }

}
