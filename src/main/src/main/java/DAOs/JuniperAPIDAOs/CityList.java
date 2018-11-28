
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
 *         &lt;element name="CityListRQ" type="{http://www.juniper.es/webservice/2007/}JP_CityListRQ" minOccurs="0"/>
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
    "cityListRQ"
})
@XmlRootElement(name = "CityList")
public class CityList {

    @XmlElement(name = "CityListRQ")
    protected JPCityListRQ cityListRQ;

    /**
     * Gets the value of the cityListRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPCityListRQ }
     *     
     */
    public JPCityListRQ getCityListRQ() {
        return cityListRQ;
    }

    /**
     * Sets the value of the cityListRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCityListRQ }
     *     
     */
    public void setCityListRQ(JPCityListRQ value) {
        this.cityListRQ = value;
    }

}
