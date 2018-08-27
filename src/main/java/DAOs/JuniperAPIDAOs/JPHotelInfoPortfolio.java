
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelInfoPortfolio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelInfoPortfolio">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_ExtendedHotelInfo">
 *       &lt;sequence>
 *         &lt;element name="City" type="{http://www.juniper.es/webservice/2007/}JP_City" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelInfoPortfolio", propOrder = {
    "city"
})
public class JPHotelInfoPortfolio
    extends JPExtendedHotelInfo
{

    @XmlElement(name = "City")
    protected JPCity city;

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link JPCity }
     *     
     */
    public JPCity getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCity }
     *     
     */
    public void setCity(JPCity value) {
        this.city = value;
    }

}
