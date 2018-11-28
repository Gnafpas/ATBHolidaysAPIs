
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
 *         &lt;element name="HotelConfirmModifyRQ" type="{http://www.juniper.es/webservice/2007/}JP_HotelConfirmModify" minOccurs="0"/>
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
    "hotelConfirmModifyRQ"
})
@XmlRootElement(name = "HotelConfirmModify")
public class HotelConfirmModify {

    @XmlElement(name = "HotelConfirmModifyRQ")
    protected JPHotelConfirmModify hotelConfirmModifyRQ;

    /**
     * Gets the value of the hotelConfirmModifyRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelConfirmModify }
     *     
     */
    public JPHotelConfirmModify getHotelConfirmModifyRQ() {
        return hotelConfirmModifyRQ;
    }

    /**
     * Sets the value of the hotelConfirmModifyRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelConfirmModify }
     *     
     */
    public void setHotelConfirmModifyRQ(JPHotelConfirmModify value) {
        this.hotelConfirmModifyRQ = value;
    }

}
