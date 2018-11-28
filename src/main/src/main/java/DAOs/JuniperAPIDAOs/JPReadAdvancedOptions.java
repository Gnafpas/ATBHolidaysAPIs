
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ReadAdvancedOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ReadAdvancedOptions">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseAdvancedOptions">
 *       &lt;sequence>
 *         &lt;element name="ShowBreakdownPrice" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ReadAdvancedOptions", propOrder = {
    "showBreakdownPrice"
})
public class JPReadAdvancedOptions
    extends JPBaseAdvancedOptions
{

    @XmlElement(name = "ShowBreakdownPrice")
    protected Boolean showBreakdownPrice;

    /**
     * Gets the value of the showBreakdownPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowBreakdownPrice() {
        return showBreakdownPrice;
    }

    /**
     * Sets the value of the showBreakdownPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowBreakdownPrice(Boolean value) {
        this.showBreakdownPrice = value;
    }

}
