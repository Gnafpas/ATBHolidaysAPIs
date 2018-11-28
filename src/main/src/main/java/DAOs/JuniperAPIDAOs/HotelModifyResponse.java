
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
 *         &lt;element name="ModifyRS" type="{http://www.juniper.es/webservice/2007/}JP_ModifyRS" minOccurs="0"/>
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
    "modifyRS"
})
@XmlRootElement(name = "HotelModifyResponse")
public class HotelModifyResponse {

    @XmlElement(name = "ModifyRS")
    protected JPModifyRS modifyRS;

    /**
     * Gets the value of the modifyRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPModifyRS }
     *     
     */
    public JPModifyRS getModifyRS() {
        return modifyRS;
    }

    /**
     * Sets the value of the modifyRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPModifyRS }
     *     
     */
    public void setModifyRS(JPModifyRS value) {
        this.modifyRS = value;
    }

}
