
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_OptionalDescriptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_OptionalDescriptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OptionalFaresDescription" type="{http://www.juniper.es/webservice/2007/}JP_OptionalFaresDescriptions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_OptionalDescriptions", propOrder = {
    "optionalFaresDescription"
})
public class JPOptionalDescriptions {

    @XmlElement(name = "OptionalFaresDescription")
    protected JPOptionalFaresDescriptions optionalFaresDescription;

    /**
     * Gets the value of the optionalFaresDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JPOptionalFaresDescriptions }
     *     
     */
    public JPOptionalFaresDescriptions getOptionalFaresDescription() {
        return optionalFaresDescription;
    }

    /**
     * Sets the value of the optionalFaresDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPOptionalFaresDescriptions }
     *     
     */
    public void setOptionalFaresDescription(JPOptionalFaresDescriptions value) {
        this.optionalFaresDescription = value;
    }

}
