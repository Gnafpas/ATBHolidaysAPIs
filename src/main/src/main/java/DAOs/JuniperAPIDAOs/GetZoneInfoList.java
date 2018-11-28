
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
 *         &lt;element name="ZoneInfoRQ" type="{http://www.juniper.es/webservice/2007/}JP_ZoneInfoRQ" minOccurs="0"/>
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
    "zoneInfoRQ"
})
@XmlRootElement(name = "GetZoneInfoList")
public class GetZoneInfoList {

    @XmlElement(name = "ZoneInfoRQ")
    protected JPZoneInfoRQ zoneInfoRQ;

    /**
     * Gets the value of the zoneInfoRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPZoneInfoRQ }
     *     
     */
    public JPZoneInfoRQ getZoneInfoRQ() {
        return zoneInfoRQ;
    }

    /**
     * Sets the value of the zoneInfoRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPZoneInfoRQ }
     *     
     */
    public void setZoneInfoRQ(JPZoneInfoRQ value) {
        this.zoneInfoRQ = value;
    }

}
