
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
 *         &lt;element name="FutureRatesRS" type="{http://www.juniper.es/webservice/2007/}JP_AvailResponseRS" minOccurs="0"/>
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
    "futureRatesRS"
})
@XmlRootElement(name = "HotelFutureRatesResponse")
public class HotelFutureRatesResponse {

    @XmlElement(name = "FutureRatesRS")
    protected JPAvailResponseRS futureRatesRS;

    /**
     * Gets the value of the futureRatesRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPAvailResponseRS }
     *     
     */
    public JPAvailResponseRS getFutureRatesRS() {
        return futureRatesRS;
    }

    /**
     * Sets the value of the futureRatesRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAvailResponseRS }
     *     
     */
    public void setFutureRatesRS(JPAvailResponseRS value) {
        this.futureRatesRS = value;
    }

}
