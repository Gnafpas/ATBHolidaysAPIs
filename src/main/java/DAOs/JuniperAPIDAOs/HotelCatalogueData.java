
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
 *         &lt;element name="HotelCatalogueDataRQ" type="{http://www.juniper.es/webservice/2007/}JP_HotelCatalogueDataRQ" minOccurs="0"/>
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
    "hotelCatalogueDataRQ"
})
@XmlRootElement(name = "HotelCatalogueData")
public class HotelCatalogueData {

    @XmlElement(name = "HotelCatalogueDataRQ")
    protected JPHotelCatalogueDataRQ hotelCatalogueDataRQ;

    /**
     * Gets the value of the hotelCatalogueDataRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelCatalogueDataRQ }
     *     
     */
    public JPHotelCatalogueDataRQ getHotelCatalogueDataRQ() {
        return hotelCatalogueDataRQ;
    }

    /**
     * Sets the value of the hotelCatalogueDataRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelCatalogueDataRQ }
     *     
     */
    public void setHotelCatalogueDataRQ(JPHotelCatalogueDataRQ value) {
        this.hotelCatalogueDataRQ = value;
    }

}
