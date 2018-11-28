
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CruiseElement" type="{http://www.juniper.es/webservice/2007/}JP_CruiseElement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseElements", propOrder = {
    "cruiseElement"
})
public class JPCruiseElements {

    @XmlElement(name = "CruiseElement")
    protected JPCruiseElement cruiseElement;

    /**
     * Gets the value of the cruiseElement property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseElement }
     *     
     */
    public JPCruiseElement getCruiseElement() {
        return cruiseElement;
    }

    /**
     * Sets the value of the cruiseElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseElement }
     *     
     */
    public void setCruiseElement(JPCruiseElement value) {
        this.cruiseElement = value;
    }

}
