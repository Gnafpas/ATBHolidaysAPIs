
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelFutureRatesRQ" type="{http://www.juniper.es/webservice/2007/}JP_HotelFutureRates" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "hotelFutureRatesRQ"
})
@XmlRootElement(name = "HotelFutureRates")
public class HotelFutureRates {

    @XmlElement(name = "HotelFutureRatesRQ")
    protected JPHotelFutureRates hotelFutureRatesRQ;

    /**
     * Gets the value of the hotelFutureRatesRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelFutureRates }
     *     
     */
    public JPHotelFutureRates getHotelFutureRatesRQ() {
        return hotelFutureRatesRQ;
    }

    /**
     * Sets the value of the hotelFutureRatesRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelFutureRates }
     *     
     */
    public void setHotelFutureRatesRQ(JPHotelFutureRates value) {
        this.hotelFutureRatesRQ = value;
    }

}
