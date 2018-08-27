
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseRequiredFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseRequiredFields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CruiseBooking" type="{http://www.juniper.es/webservice/2007/}JP_CruiseBooking" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseRequiredFields", propOrder = {
    "cruiseBooking"
})
public class JPCruiseRequiredFields {

    @XmlElement(name = "CruiseBooking")
    protected JPCruiseBooking cruiseBooking;

    /**
     * Gets the value of the cruiseBooking property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseBooking }
     *     
     */
    public JPCruiseBooking getCruiseBooking() {
        return cruiseBooking;
    }

    /**
     * Sets the value of the cruiseBooking property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseBooking }
     *     
     */
    public void setCruiseBooking(JPCruiseBooking value) {
        this.cruiseBooking = value;
    }

}
