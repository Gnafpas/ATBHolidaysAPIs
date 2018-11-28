
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ModifyResults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ModifyResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelModifyResult" type="{http://www.juniper.es/webservice/2007/}JP_HotelResultModify" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ModifyResults", propOrder = {
    "hotelModifyResult"
})
public class JPModifyResults {

    @XmlElement(name = "HotelModifyResult")
    protected JPHotelResultModify hotelModifyResult;

    /**
     * Gets the value of the hotelModifyResult property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelResultModify }
     *     
     */
    public JPHotelResultModify getHotelModifyResult() {
        return hotelModifyResult;
    }

    /**
     * Sets the value of the hotelModifyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelResultModify }
     *     
     */
    public void setHotelModifyResult(JPHotelResultModify value) {
        this.hotelModifyResult = value;
    }

}
