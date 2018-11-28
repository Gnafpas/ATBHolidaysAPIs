
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseFlightRoute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseFlightRoute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Segments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseSegment" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseFlightRoute", propOrder = {
    "segments"
})
public class JPCruiseFlightRoute {

    @XmlElement(name = "Segments")
    protected ArrayOfJPCruiseSegment segments;

    /**
     * Gets the value of the segments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseSegment }
     *     
     */
    public ArrayOfJPCruiseSegment getSegments() {
        return segments;
    }

    /**
     * Sets the value of the segments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseSegment }
     *     
     */
    public void setSegments(ArrayOfJPCruiseSegment value) {
        this.segments = value;
    }

}
