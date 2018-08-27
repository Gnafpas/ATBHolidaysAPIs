
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightSupplier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightSupplier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FlightRates" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_FlightRate" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightSupplier", propOrder = {
    "flightRates"
})
public class JPFlightSupplier {

    @XmlElement(name = "FlightRates")
    protected ArrayOfJPFlightRate flightRates;
    @XmlAttribute(name = "Code")
    protected String code;

    /**
     * Gets the value of the flightRates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFlightRate }
     *     
     */
    public ArrayOfJPFlightRate getFlightRates() {
        return flightRates;
    }

    /**
     * Sets the value of the flightRates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFlightRate }
     *     
     */
    public void setFlightRates(ArrayOfJPFlightRate value) {
        this.flightRates = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

}
