
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_OptionalFares complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_OptionalFares">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FareGroupPrices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_FareGroupPrice" minOccurs="0"/>
 *         &lt;element name="FareGroups" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_FareGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_OptionalFares", propOrder = {
    "fareGroupPrices",
    "fareGroups"
})
public class JPOptionalFares {

    @XmlElement(name = "FareGroupPrices")
    protected ArrayOfJPFareGroupPrice fareGroupPrices;
    @XmlElement(name = "FareGroups")
    protected ArrayOfJPFareGroup fareGroups;

    /**
     * Gets the value of the fareGroupPrices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFareGroupPrice }
     *     
     */
    public ArrayOfJPFareGroupPrice getFareGroupPrices() {
        return fareGroupPrices;
    }

    /**
     * Sets the value of the fareGroupPrices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFareGroupPrice }
     *     
     */
    public void setFareGroupPrices(ArrayOfJPFareGroupPrice value) {
        this.fareGroupPrices = value;
    }

    /**
     * Gets the value of the fareGroups property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFareGroup }
     *     
     */
    public ArrayOfJPFareGroup getFareGroups() {
        return fareGroups;
    }

    /**
     * Sets the value of the fareGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFareGroup }
     *     
     */
    public void setFareGroups(ArrayOfJPFareGroup value) {
        this.fareGroups = value;
    }

}
