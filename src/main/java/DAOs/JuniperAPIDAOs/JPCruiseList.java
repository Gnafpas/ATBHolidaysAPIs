
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cruise" type="{http://www.juniper.es/webservice/2007/}JP_CruiseResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseList", propOrder = {
    "cruise"
})
public class JPCruiseList {

    @XmlElement(name = "Cruise")
    protected JPCruiseResult cruise;

    /**
     * Gets the value of the cruise property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseResult }
     *     
     */
    public JPCruiseResult getCruise() {
        return cruise;
    }

    /**
     * Sets the value of the cruise property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseResult }
     *     
     */
    public void setCruise(JPCruiseResult value) {
        this.cruise = value;
    }

}
