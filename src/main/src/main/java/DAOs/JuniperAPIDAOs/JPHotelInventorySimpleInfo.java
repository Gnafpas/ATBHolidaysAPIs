
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelInventorySimpleInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelInventorySimpleInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_HotelSimpleInfo">
 *       &lt;attribute name="HotelCodeEncrypt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelInventorySimpleInfo")
public class JPHotelInventorySimpleInfo
    extends JPHotelSimpleInfo
{

    @XmlAttribute(name = "HotelCodeEncrypt")
    protected String hotelCodeEncrypt;

    /**
     * Gets the value of the hotelCodeEncrypt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCodeEncrypt() {
        return hotelCodeEncrypt;
    }

    /**
     * Sets the value of the hotelCodeEncrypt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCodeEncrypt(String value) {
        this.hotelCodeEncrypt = value;
    }

}
