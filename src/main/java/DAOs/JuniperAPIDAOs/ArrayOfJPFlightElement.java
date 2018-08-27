
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_FlightElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_FlightElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FlightElement" type="{http://www.juniper.es/webservice/2007/}JP_FlightElement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_FlightElement", propOrder = {
    "flightElement"
})
public class ArrayOfJPFlightElement {

    @XmlElement(name = "FlightElement")
    protected List<JPFlightElement> flightElement;

    /**
     * Gets the value of the flightElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flightElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlightElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPFlightElement }
     * 
     * 
     */
    public List<JPFlightElement> getFlightElement() {
        if (flightElement == null) {
            flightElement = new ArrayList<JPFlightElement>();
        }
        return this.flightElement;
    }

}
