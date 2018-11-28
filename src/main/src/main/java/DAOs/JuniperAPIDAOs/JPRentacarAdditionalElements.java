
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarAdditionalElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarAdditionalElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CarSupplements" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CarSupplement" minOccurs="0"/>
 *         &lt;element name="CarFees" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CarFee" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarAdditionalElements", propOrder = {
    "carSupplements",
    "carFees"
})
public class JPRentacarAdditionalElements {

    @XmlElement(name = "CarSupplements")
    protected ArrayOfJPCarSupplement carSupplements;
    @XmlElement(name = "CarFees")
    protected ArrayOfJPCarFee carFees;

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

    /**
     * Gets the value of the carFees property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCarFee }
     *     
     */
    public ArrayOfJPCarFee getCarFees() {
        return carFees;
    }

    /**
     * Sets the value of the carFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCarFee }
     *     
     */
    public void setCarFees(ArrayOfJPCarFee value) {
        this.carFees = value;
    }

}
