
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for JP_HotelRoomSize complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelRoomSize">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>double">
 *       &lt;attribute name="Unit" use="required" type="{http://www.juniper.es/webservice/2007/}JP_HotelRoomSizeUnitType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelRoomSize", propOrder = {
    "value"
})
public class JPHotelRoomSize {

    @XmlValue
    protected double value;
    @XmlAttribute(name = "Unit", required = true)
    protected JPHotelRoomSizeUnitType unit;

    /**
     * Gets the value of the value property.
     * 
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelRoomSizeUnitType }
     *     
     */
    public JPHotelRoomSizeUnitType getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelRoomSizeUnitType }
     *     
     */
    public void setUnit(JPHotelRoomSizeUnitType value) {
        this.unit = value;
    }

}
