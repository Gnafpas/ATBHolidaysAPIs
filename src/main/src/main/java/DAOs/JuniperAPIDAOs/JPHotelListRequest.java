
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Suppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfString5" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ZoneCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ShowBasicInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelListRequest", propOrder = {
    "suppliers"
})
public class JPHotelListRequest {

    @XmlElement(name = "Suppliers")
    protected ArrayOfString5 suppliers;
    @XmlAttribute(name = "ZoneCode")
    protected String zoneCode;
    @XmlAttribute(name = "ShowBasicInfo")
    protected Boolean showBasicInfo;

    /**
     * Gets the value of the suppliers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString5 }
     *     
     */
    public ArrayOfString5 getSuppliers() {
        return suppliers;
    }

    /**
     * Sets the value of the suppliers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString5 }
     *     
     */
    public void setSuppliers(ArrayOfString5 value) {
        this.suppliers = value;
    }

    /**
     * Gets the value of the zoneCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZoneCode() {
        return zoneCode;
    }

    /**
     * Sets the value of the zoneCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZoneCode(String value) {
        this.zoneCode = value;
    }

    /**
     * Gets the value of the showBasicInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowBasicInfo() {
        return showBasicInfo;
    }

    /**
     * Sets the value of the showBasicInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowBasicInfo(Boolean value) {
        this.showBasicInfo = value;
    }

}
