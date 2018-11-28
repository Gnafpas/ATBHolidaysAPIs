
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CheckAvailResults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CheckAvailResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="CruiseResult" type="{http://www.juniper.es/webservice/2007/}JP_CruiseCheckAvailResult" minOccurs="0"/>
 *           &lt;element name="FlightResult" type="{http://www.juniper.es/webservice/2007/}JP_FlightCheckAvailResult" minOccurs="0"/>
 *           &lt;element name="HotelResult" type="{http://www.juniper.es/webservice/2007/}JP_HotelCheckAvailResult" minOccurs="0"/>
 *           &lt;element name="InsuranceResult" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceCheckAvailResult" minOccurs="0"/>
 *           &lt;element name="PackageResult" type="{http://www.juniper.es/webservice/2007/}JP_PackageResult" minOccurs="0"/>
 *           &lt;element name="RentacarResult" type="{http://www.juniper.es/webservice/2007/}JP_RentacarCheckAvailResult" minOccurs="0"/>
 *           &lt;element name="ServiceResult" type="{http://www.juniper.es/webservice/2007/}JP_ServiceCheckAvailResult" minOccurs="0"/>
 *           &lt;element name="TransferResult" type="{http://www.juniper.es/webservice/2007/}JP_TransferCheckAvailResult" minOccurs="0"/>
 *           &lt;element name="VisaResult" type="{http://www.juniper.es/webservice/2007/}JP_VisaCheckAvailResult" minOccurs="0"/>
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
@XmlType(name = "JP_CheckAvailResults", propOrder = {
    "cruiseResultOrFlightResultOrHotelResult"
})
public class JPCheckAvailResults {

    @XmlElements({
        @XmlElement(name = "CruiseResult", type = JPCruiseCheckAvailResult.class),
        @XmlElement(name = "FlightResult", type = JPFlightCheckAvailResult.class),
        @XmlElement(name = "HotelResult", type = JPHotelCheckAvailResult.class),
        @XmlElement(name = "InsuranceResult", type = JPInsuranceCheckAvailResult.class),
        @XmlElement(name = "PackageResult", type = JPPackageResult.class),
        @XmlElement(name = "RentacarResult", type = JPRentacarCheckAvailResult.class),
        @XmlElement(name = "ServiceResult", type = JPServiceCheckAvailResult.class),
        @XmlElement(name = "TransferResult", type = JPTransferCheckAvailResult.class),
        @XmlElement(name = "VisaResult", type = JPVisaCheckAvailResult.class)
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
     * {@link JPCruiseCheckAvailResult }
     * {@link JPFlightCheckAvailResult }
     * {@link JPHotelCheckAvailResult }
     * {@link JPInsuranceCheckAvailResult }
     * {@link JPPackageResult }
     * {@link JPRentacarCheckAvailResult }
     * {@link JPServiceCheckAvailResult }
     * {@link JPTransferCheckAvailResult }
     * {@link JPVisaCheckAvailResult }
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
