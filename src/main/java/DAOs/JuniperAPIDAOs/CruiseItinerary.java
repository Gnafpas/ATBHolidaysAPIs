
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
 *         &lt;element name="CruiseItineraryRQ" type="{http://www.juniper.es/webservice/2007/}JP_CruiseItineraryRQ" minOccurs="0"/>
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
    "cruiseItineraryRQ"
})
@XmlRootElement(name = "CruiseItinerary")
public class CruiseItinerary {

    @XmlElement(name = "CruiseItineraryRQ")
    protected JPCruiseItineraryRQ cruiseItineraryRQ;

    /**
     * Gets the value of the cruiseItineraryRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseItineraryRQ }
     *     
     */
    public JPCruiseItineraryRQ getCruiseItineraryRQ() {
        return cruiseItineraryRQ;
    }

    /**
     * Sets the value of the cruiseItineraryRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseItineraryRQ }
     *     
     */
    public void setCruiseItineraryRQ(JPCruiseItineraryRQ value) {
        this.cruiseItineraryRQ = value;
    }

}
