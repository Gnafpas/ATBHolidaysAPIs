
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
 *         &lt;element name="HotelPortfolioRS" type="{http://www.juniper.es/webservice/2007/}JP_StaticDataRS" minOccurs="0"/>
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
    "hotelPortfolioRS"
})
@XmlRootElement(name = "HotelPortfolioResponse")
public class HotelPortfolioResponse {

    @XmlElement(name = "HotelPortfolioRS")
    protected JPStaticDataRS hotelPortfolioRS;

    /**
     * Gets the value of the hotelPortfolioRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPStaticDataRS }
     *     
     */
    public JPStaticDataRS getHotelPortfolioRS() {
        return hotelPortfolioRS;
    }

    /**
     * Sets the value of the hotelPortfolioRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPStaticDataRS }
     *     
     */
    public void setHotelPortfolioRS(JPStaticDataRS value) {
        this.hotelPortfolioRS = value;
    }

}
