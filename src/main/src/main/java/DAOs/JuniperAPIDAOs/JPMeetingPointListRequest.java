
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_MeetingPointListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_MeetingPointListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ZoneCode" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ProductType" type="{http://www.juniper.es/webservice/2007/}JP_ProductType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_MeetingPointListRequest")
public class JPMeetingPointListRequest {

    @XmlAttribute(name = "ZoneCode", required = true)
    protected int zoneCode;
    @XmlAttribute(name = "ProductType")
    protected JPProductType productType;

    /**
     * Gets the value of the zoneCode property.
     * 
     */
    public int getZoneCode() {
        return zoneCode;
    }

    /**
     * Sets the value of the zoneCode property.
     * 
     */
    public void setZoneCode(int value) {
        this.zoneCode = value;
    }

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link JPProductType }
     *     
     */
    public JPProductType getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPProductType }
     *     
     */
    public void setProductType(JPProductType value) {
        this.productType = value;
    }

}
