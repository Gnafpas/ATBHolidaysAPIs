
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelFutureRatesResults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelFutureRatesResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelFutureRatesResult" type="{http://www.juniper.es/webservice/2007/}JP_HotelFutureRatesResult" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="WarningDetails" type="{http://www.juniper.es/webservice/2007/}JP_WarningDetails" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelFutureRatesResults", propOrder = {
    "hotelFutureRatesResult",
    "warningDetails"
})
public class JPHotelFutureRatesResults {

    @XmlElement(name = "HotelFutureRatesResult")
    protected List<JPHotelFutureRatesResult> hotelFutureRatesResult;
    @XmlElement(name = "WarningDetails")
    protected JPWarningDetails warningDetails;

    /**
     * Gets the value of the hotelFutureRatesResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelFutureRatesResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelFutureRatesResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPHotelFutureRatesResult }
     * 
     * 
     */
    public List<JPHotelFutureRatesResult> getHotelFutureRatesResult() {
        if (hotelFutureRatesResult == null) {
            hotelFutureRatesResult = new ArrayList<JPHotelFutureRatesResult>();
        }
        return this.hotelFutureRatesResult;
    }

    /**
     * Gets the value of the warningDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JPWarningDetails }
     *     
     */
    public JPWarningDetails getWarningDetails() {
        return warningDetails;
    }

    /**
     * Sets the value of the warningDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPWarningDetails }
     *     
     */
    public void setWarningDetails(JPWarningDetails value) {
        this.warningDetails = value;
    }

}
