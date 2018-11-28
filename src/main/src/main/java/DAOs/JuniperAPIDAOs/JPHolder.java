
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Holder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Holder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RelPax" type="{http://www.juniper.es/webservice/2007/}JP_RelPax" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Holder", propOrder = {
    "relPax"
})
public class JPHolder {

    @XmlElement(name = "RelPax")
    protected JPRelPax relPax;

    /**
     * Gets the value of the relPax property.
     * 
     * @return
     *     possible object is
     *     {@link JPRelPax }
     *     
     */
    public JPRelPax getRelPax() {
        return relPax;
    }

    /**
     * Sets the value of the relPax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRelPax }
     *     
     */
    public void setRelPax(JPRelPax value) {
        this.relPax = value;
    }

}
