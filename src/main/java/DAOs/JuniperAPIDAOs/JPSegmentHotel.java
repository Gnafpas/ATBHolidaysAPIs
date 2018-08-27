
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SegmentHotel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SegmentHotel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}JP_SegmentHotelType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SegmentHotel")
public class JPSegmentHotel {

    @XmlAttribute(name = "Type", required = true)
    protected JPSegmentHotelType type;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPSegmentHotelType }
     *     
     */
    public JPSegmentHotelType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSegmentHotelType }
     *     
     */
    public void setType(JPSegmentHotelType value) {
        this.type = value;
    }

}
