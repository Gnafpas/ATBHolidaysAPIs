
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SeatEquipment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SeatEquipment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Compartments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Compartment" minOccurs="0"/>
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
@XmlType(name = "JP_SeatEquipment", propOrder = {
    "compartments"
})
public class JPSeatEquipment {

    @XmlElement(name = "Compartments")
    protected ArrayOfJPCompartment compartments;
    @XmlAttribute(name = "Type")
    protected String type;

    /**
     * Gets the value of the compartments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCompartment }
     *     
     */
    public ArrayOfJPCompartment getCompartments() {
        return compartments;
    }

    /**
     * Sets the value of the compartments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCompartment }
     *     
     */
    public void setCompartments(ArrayOfJPCompartment value) {
        this.compartments = value;
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
