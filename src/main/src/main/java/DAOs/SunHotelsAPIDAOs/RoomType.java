
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoomType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sharedRoom" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sharedFacilities" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomType", propOrder = {
    "id",
    "name",
    "sharedRoom",
    "sharedFacilities"
})
public class RoomType {

    protected int id;
    protected String name;
    protected int sharedRoom;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer sharedFacilities;

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

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the sharedRoom property.
     * 
     */
    public int getSharedRoom() {
        return sharedRoom;
    }

    /**
     * Sets the value of the sharedRoom property.
     * 
     */
    public void setSharedRoom(int value) {
        this.sharedRoom = value;
    }

    /**
     * Gets the value of the sharedFacilities property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSharedFacilities() {
        return sharedFacilities;
    }

    /**
     * Sets the value of the sharedFacilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSharedFacilities(Integer value) {
        this.sharedFacilities = value;
    }

}
