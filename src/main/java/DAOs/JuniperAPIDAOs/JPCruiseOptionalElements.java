
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseOptionalElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseOptionalElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CruiseSupplements" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseSupplement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseOptionalElements", propOrder = {
    "cruiseSupplements"
})
public class JPCruiseOptionalElements {

    @XmlElement(name = "CruiseSupplements")
    protected ArrayOfJPCruiseSupplement cruiseSupplements;

    /**
     * Gets the value of the cruiseSupplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseSupplement }
     *     
     */
    public ArrayOfJPCruiseSupplement getCruiseSupplements() {
        return cruiseSupplements;
    }

    /**
     * Sets the value of the cruiseSupplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseSupplement }
     *     
     */
    public void setCruiseSupplements(ArrayOfJPCruiseSupplement value) {
        this.cruiseSupplements = value;
    }

}
