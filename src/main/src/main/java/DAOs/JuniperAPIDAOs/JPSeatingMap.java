
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SeatingMap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SeatingMap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SeatEquipments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_SeatEquipment" minOccurs="0"/>
 *         &lt;element name="SeatGroups" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_SeatGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SeatingMap", propOrder = {
    "seatEquipments",
    "seatGroups"
})
public class JPSeatingMap {

    @XmlElement(name = "SeatEquipments")
    protected ArrayOfJPSeatEquipment seatEquipments;
    @XmlElement(name = "SeatGroups")
    protected ArrayOfJPSeatGroup seatGroups;

    /**
     * Gets the value of the seatEquipments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSeatEquipment }
     *     
     */
    public ArrayOfJPSeatEquipment getSeatEquipments() {
        return seatEquipments;
    }

    /**
     * Sets the value of the seatEquipments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSeatEquipment }
     *     
     */
    public void setSeatEquipments(ArrayOfJPSeatEquipment value) {
        this.seatEquipments = value;
    }

    /**
     * Gets the value of the seatGroups property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSeatGroup }
     *     
     */
    public ArrayOfJPSeatGroup getSeatGroups() {
        return seatGroups;
    }

    /**
     * Sets the value of the seatGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSeatGroup }
     *     
     */
    public void setSeatGroups(ArrayOfJPSeatGroup value) {
        this.seatGroups = value;
    }

}
