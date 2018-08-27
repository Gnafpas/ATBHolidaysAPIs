
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelTimeInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelTimeInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckTime" type="{http://www.juniper.es/webservice/2007/}JP_HotelCheckTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelTimeInformation", propOrder = {
    "checkTime"
})
public class JPHotelTimeInformation {

    @XmlElement(name = "CheckTime")
    protected JPHotelCheckTime checkTime;

    /**
     * Gets the value of the checkTime property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelCheckTime }
     *     
     */
    public JPHotelCheckTime getCheckTime() {
        return checkTime;
    }

    /**
     * Sets the value of the checkTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelCheckTime }
     *     
     */
    public void setCheckTime(JPHotelCheckTime value) {
        this.checkTime = value;
    }

}
