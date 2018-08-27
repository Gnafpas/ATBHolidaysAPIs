
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_HotelElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_HotelElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelElement" type="{http://www.juniper.es/webservice/2007/}JP_HotelElement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_HotelElement", propOrder = {
    "hotelElement"
})
public class ArrayOfJPHotelElement {

    @XmlElement(name = "HotelElement")
    protected List<JPHotelElement> hotelElement;

    /**
     * Gets the value of the hotelElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPHotelElement }
     * 
     * 
     */
    public List<JPHotelElement> getHotelElement() {
        if (hotelElement == null) {
            hotelElement = new ArrayList<JPHotelElement>();
        }
        return this.hotelElement;
    }

}
