
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseShipRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseShipRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentsShip" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentsShip" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseShipRequest", propOrder = {
    "searchSegmentsShip"
})
public class JPCruiseShipRequest {

    @XmlElement(name = "SearchSegmentsShip")
    protected JPSearchSegmentsShip searchSegmentsShip;

    /**
     * Gets the value of the searchSegmentsShip property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentsShip }
     *     
     */
    public JPSearchSegmentsShip getSearchSegmentsShip() {
        return searchSegmentsShip;
    }

    /**
     * Sets the value of the searchSegmentsShip property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentsShip }
     *     
     */
    public void setSearchSegmentsShip(JPSearchSegmentsShip value) {
        this.searchSegmentsShip = value;
    }

}
