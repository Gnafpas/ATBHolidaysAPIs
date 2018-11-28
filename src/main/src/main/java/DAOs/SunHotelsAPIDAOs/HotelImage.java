
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelImage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HotelImage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fullSizeImage" type="{http://xml.sunhotels.net/15/}Image" minOccurs="0"/>
 *         &lt;element name="smallImage" type="{http://xml.sunhotels.net/15/}Image" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelImage", propOrder = {
    "fullSizeImage",
    "smallImage"
})
public class HotelImage {

    protected Image fullSizeImage;
    protected Image smallImage;
    @XmlAttribute(name = "id", required = true)
    protected int id;

    /**
     * Gets the value of the fullSizeImage property.
     * 
     * @return
     *     possible object is
     *     {@link Image }
     *     
     */
    public Image getFullSizeImage() {
        return fullSizeImage;
    }

    /**
     * Sets the value of the fullSizeImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Image }
     *     
     */
    public void setFullSizeImage(Image value) {
        this.fullSizeImage = value;
    }

    /**
     * Gets the value of the smallImage property.
     * 
     * @return
     *     possible object is
     *     {@link Image }
     *     
     */
    public Image getSmallImage() {
        return smallImage;
    }

    /**
     * Sets the value of the smallImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Image }
     *     
     */
    public void setSmallImage(Image value) {
        this.smallImage = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

}
