
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarSupplier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarSupplier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentacarContracts" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RentacarContract" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarSupplier", propOrder = {
    "rentacarContracts"
})
public class JPRentacarSupplier {

    @XmlElement(name = "RentacarContracts")
    protected ArrayOfJPRentacarContract rentacarContracts;
    @XmlAttribute(name = "Type")
    protected String type;

    /**
     * Gets the value of the rentacarContracts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRentacarContract }
     *     
     */
    public ArrayOfJPRentacarContract getRentacarContracts() {
        return rentacarContracts;
    }

    /**
     * Sets the value of the rentacarContracts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRentacarContract }
     *     
     */
    public void setRentacarContracts(ArrayOfJPRentacarContract value) {
        this.rentacarContracts = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
