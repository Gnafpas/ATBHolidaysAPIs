
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Results complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Results">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="CruiseResult" type="{http://www.juniper.es/webservice/2007/}JP_CruiseResult" minOccurs="0"/>
 *           &lt;element name="ExtraInfo" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *           &lt;element name="FlightResult" type="{http://www.juniper.es/webservice/2007/}JP_Flight" minOccurs="0"/>
 *           &lt;element name="HotelCalendarResult" type="{http://www.juniper.es/webservice/2007/}JP_HotelCalendarResult" minOccurs="0"/>
 *           &lt;element name="HotelFutureRatesResults" type="{http://www.juniper.es/webservice/2007/}JP_HotelFutureRatesResults" minOccurs="0"/>
 *           &lt;element name="HotelResult" type="{http://www.juniper.es/webservice/2007/}JP_HotelResult" minOccurs="0"/>
 *           &lt;element name="InsuranceResult" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceResult" minOccurs="0"/>
 *           &lt;element name="PackageResult" type="{http://www.juniper.es/webservice/2007/}JP_PackageResult" minOccurs="0"/>
 *           &lt;element name="RentCarResult" type="{http://www.juniper.es/webservice/2007/}JP_RentacarResult" minOccurs="0"/>
 *           &lt;element name="ServiceResult" type="{http://www.juniper.es/webservice/2007/}JP_ServiceResult" minOccurs="0"/>
 *           &lt;element name="TransferResult" type="{http://www.juniper.es/webservice/2007/}JP_TransferResult" minOccurs="0"/>
 *           &lt;element name="VisaResult" type="{http://www.juniper.es/webservice/2007/}JP_VisaResult" minOccurs="0"/>
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
@XmlType(name = "JP_Results", propOrder = {
    "cruiseResultOrExtraInfoOrFlightResult"
})
public class JPResults {

    @XmlElements({
        @XmlElement(name = "CruiseResult", type = JPCruiseResult.class),
        @XmlElement(name = "ExtraInfo"),
        @XmlElement(name = "FlightResult", type = JPFlight.class),
        @XmlElement(name = "HotelCalendarResult", type = JPHotelCalendarResult.class),
        @XmlElement(name = "HotelFutureRatesResults", type = JPHotelFutureRatesResults.class),
        @XmlElement(name = "HotelResult", type = JPHotelResult.class),
        @XmlElement(name = "InsuranceResult", type = JPInsuranceResult.class),
        @XmlElement(name = "PackageResult", type = JPPackageResult.class),
        @XmlElement(name = "RentCarResult", type = JPRentacarResult.class),
        @XmlElement(name = "ServiceResult", type = JPServiceResult.class),
        @XmlElement(name = "TransferResult", type = JPTransferResult.class),
        @XmlElement(name = "VisaResult", type = JPVisaResult.class)
    })
    protected List<Object> cruiseResultOrExtraInfoOrFlightResult;

    /**
     * Gets the value of the cruiseResultOrExtraInfoOrFlightResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cruiseResultOrExtraInfoOrFlightResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCruiseResultOrExtraInfoOrFlightResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPCruiseResult }
     * {@link Object }
     * {@link JPFlight }
     * {@link JPHotelCalendarResult }
     * {@link JPHotelFutureRatesResults }
     * {@link JPHotelResult }
     * {@link JPInsuranceResult }
     * {@link JPPackageResult }
     * {@link JPRentacarResult }
     * {@link JPServiceResult }
     * {@link JPTransferResult }
     * {@link JPVisaResult }
     * 
     * 
     */
    public List<Object> getCruiseResultOrExtraInfoOrFlightResult() {
        if (cruiseResultOrExtraInfoOrFlightResult == null) {
            cruiseResultOrExtraInfoOrFlightResult = new ArrayList<Object>();
        }
        return this.cruiseResultOrExtraInfoOrFlightResult;
    }

}
