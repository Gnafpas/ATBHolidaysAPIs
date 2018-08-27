
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelModifyAdvancedOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelModifyAdvancedOptions">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_ModifyAdvancedOptions">
 *       &lt;sequence>
 *         &lt;element name="ShowHotelInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelModifyAdvancedOptions", propOrder = {
    "showHotelInfo"
})
public class JPHotelModifyAdvancedOptions
    extends JPModifyAdvancedOptions
{

    @XmlElement(name = "ShowHotelInfo")
    protected Boolean showHotelInfo;

    /**
     * Gets the value of the showHotelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowHotelInfo() {
        return showHotelInfo;
    }

    /**
     * Sets the value of the showHotelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowHotelInfo(Boolean value) {
        this.showHotelInfo = value;
    }

}
