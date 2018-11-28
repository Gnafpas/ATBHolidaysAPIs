
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Compartment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Compartment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Seats" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Seat" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Cabin" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Compartment", propOrder = {
    "seats"
})
public class JPCompartment {

    @XmlElement(name = "Seats")
    protected ArrayOfJPSeat seats;
    @XmlAttribute(name = "Cabin")
    protected String cabin;

    /**
     * Gets the value of the seats property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSeat }
     *     
     */
    public ArrayOfJPSeat getSeats() {
        return seats;
    }

    /**
     * Sets the value of the seats property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSeat }
     *     
     */
    public void setSeats(ArrayOfJPSeat value) {
        this.seats = value;
    }

    /**
     * Gets the value of the cabin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCabin() {
        return cabin;
    }

    /**
     * Sets the value of the cabin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCabin(String value) {
        this.cabin = value;
    }

}
