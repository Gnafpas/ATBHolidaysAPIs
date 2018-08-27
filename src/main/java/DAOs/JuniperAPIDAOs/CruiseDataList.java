
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
 *         &lt;element name="CruiseDataRQ" type="{http://www.juniper.es/webservice/2007/}JP_CruiseDataRQ" minOccurs="0"/>
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
    "cruiseDataRQ"
})
@XmlRootElement(name = "CruiseDataList")
public class CruiseDataList {

    @XmlElement(name = "CruiseDataRQ")
    protected JPCruiseDataRQ cruiseDataRQ;

    /**
     * Gets the value of the cruiseDataRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseDataRQ }
     *     
     */
    public JPCruiseDataRQ getCruiseDataRQ() {
        return cruiseDataRQ;
    }

    /**
     * Sets the value of the cruiseDataRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseDataRQ }
     *     
     */
    public void setCruiseDataRQ(JPCruiseDataRQ value) {
        this.cruiseDataRQ = value;
    }

}
