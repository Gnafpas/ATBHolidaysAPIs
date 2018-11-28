
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarOptionalElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarOptionalElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CarSupplements" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CarSupplement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarOptionalElements", propOrder = {
    "carSupplements"
})
public class JPRentacarOptionalElements {

    @XmlElement(name = "CarSupplements")
    protected ArrayOfJPCarSupplement carSupplements;

    /**
     * Gets the value of the carSupplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCarSupplement }
     *     
     */
    public ArrayOfJPCarSupplement getCarSupplements() {
        return carSupplements;
    }

    /**
     * Sets the value of the carSupplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCarSupplement }
     *     
     */
    public void setCarSupplements(ArrayOfJPCarSupplement value) {
        this.carSupplements = value;
    }

}
