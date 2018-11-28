
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
 *         &lt;element name="ZoneListRQ" type="{http://www.juniper.es/webservice/2007/}JP_ZoneListRQ" minOccurs="0"/>
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
    "zoneListRQ"
})
@XmlRootElement(name = "ZoneList")
public class ZoneList {

    @XmlElement(name = "ZoneListRQ")
    protected JPZoneListRQ zoneListRQ;

    /**
     * Gets the value of the zoneListRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPZoneListRQ }
     *     
     */
    public JPZoneListRQ getZoneListRQ() {
        return zoneListRQ;
    }

    /**
     * Sets the value of the zoneListRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPZoneListRQ }
     *     
     */
    public void setZoneListRQ(JPZoneListRQ value) {
        this.zoneListRQ = value;
    }

}
