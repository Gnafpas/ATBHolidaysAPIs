
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
 *         &lt;element name="CruisePreAvailRQ" type="{http://www.juniper.es/webservice/2007/}JP_CruisePreAvail" minOccurs="0"/>
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
    "cruisePreAvailRQ"
})
@XmlRootElement(name = "CruisePreAvail")
public class CruisePreAvail {

    @XmlElement(name = "CruisePreAvailRQ")
    protected JPCruisePreAvail cruisePreAvailRQ;

    /**
     * Gets the value of the cruisePreAvailRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruisePreAvail }
     *     
     */
    public JPCruisePreAvail getCruisePreAvailRQ() {
        return cruisePreAvailRQ;
    }

    /**
     * Sets the value of the cruisePreAvailRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruisePreAvail }
     *     
     */
    public void setCruisePreAvailRQ(JPCruisePreAvail value) {
        this.cruisePreAvailRQ = value;
    }

}
