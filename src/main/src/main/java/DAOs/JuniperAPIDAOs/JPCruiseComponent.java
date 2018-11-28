
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseComponent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseComponent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Stations" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseStation" minOccurs="0"/>
 *         &lt;element name="Flights" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseFlight" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}ComponentsType" />
 *       &lt;attribute name="Mandatory" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseComponent", propOrder = {
    "stations",
    "flights"
})
public class JPCruiseComponent {

    @XmlElement(name = "Stations")
    protected ArrayOfJPCruiseStation stations;
    @XmlElement(name = "Flights")
    protected ArrayOfJPCruiseFlight flights;
    @XmlAttribute(name = "Type", required = true)
    protected ComponentsType type;
    @XmlAttribute(name = "Mandatory", required = true)
    protected boolean mandatory;

    /**
     * Gets the value of the stations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseStation }
     *     
     */
    public ArrayOfJPCruiseStation getStations() {
        return stations;
    }

    /**
     * Sets the value of the stations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseStation }
     *     
     */
    public void setStations(ArrayOfJPCruiseStation value) {
        this.stations = value;
    }

    /**
     * Gets the value of the flights property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseFlight }
     *     
     */
    public ArrayOfJPCruiseFlight getFlights() {
        return flights;
    }

    /**
     * Sets the value of the flights property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseFlight }
     *     
     */
    public void setFlights(ArrayOfJPCruiseFlight value) {
        this.flights = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ComponentsType }
     *     
     */
    public ComponentsType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentsType }
     *     
     */
    public void setType(ComponentsType value) {
        this.type = value;
    }

    /**
     * Gets the value of the mandatory property.
     * 
     */
    public boolean isMandatory() {
        return mandatory;
    }

    /**
     * Sets the value of the mandatory property.
     * 
     */
    public void setMandatory(boolean value) {
        this.mandatory = value;
    }

}
