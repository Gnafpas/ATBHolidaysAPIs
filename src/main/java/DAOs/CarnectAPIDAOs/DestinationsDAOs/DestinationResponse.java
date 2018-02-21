
package DAOs.CarnectAPIDAOs.DestinationsDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DestinationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DestinationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Errors" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfErrorMessage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DestinationResponse", propOrder = {
    "errors"
})
@XmlSeeAlso({
    VehicleCountryResponse.class,
    VehicleRegionResponse.class,
    VehicleAirportResponse.class,
    VehicleCityResponse.class
})
public abstract class DestinationResponse {

    @XmlElement(name = "Errors")
    protected ArrayOfErrorMessage errors;

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfErrorMessage }
     *     
     */
    public ArrayOfErrorMessage getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfErrorMessage }
     *     
     */
    public void setErrors(ArrayOfErrorMessage value) {
        this.errors = value;
    }

}
