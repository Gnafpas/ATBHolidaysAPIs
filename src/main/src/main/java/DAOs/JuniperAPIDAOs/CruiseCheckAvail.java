
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
 *         &lt;element name="CruiseCheckAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_CruiseCheckAvail" minOccurs="0"/>
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
    "cruiseCheckAvailRQ"
})
@XmlRootElement(name = "CruiseCheckAvail")
public class CruiseCheckAvail {

    @XmlElement(name = "CruiseCheckAvailRQ")
    protected JPCruiseCheckAvail cruiseCheckAvailRQ;

    /**
     * Gets the value of the cruiseCheckAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseCheckAvail }
     *     
     */
    public JPCruiseCheckAvail getCruiseCheckAvailRQ() {
        return cruiseCheckAvailRQ;
    }

    /**
     * Sets the value of the cruiseCheckAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseCheckAvail }
     *     
     */
    public void setCruiseCheckAvailRQ(JPCruiseCheckAvail value) {
        this.cruiseCheckAvailRQ = value;
    }

}
