
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.juniper.es/webservice/2007/}JP_Description" minOccurs="0"/>
 *         &lt;element name="LongDescription" type="{http://www.juniper.es/webservice/2007/}JP_Description" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfString1" minOccurs="0"/>
 *         &lt;element name="ImagesLong" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ImageLong" minOccurs="0"/>
 *         &lt;element name="Ship" type="{http://www.juniper.es/webservice/2007/}JP_Ship" minOccurs="0"/>
 *         &lt;element name="Categories" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseCategory" minOccurs="0"/>
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
@XmlType(name = "JP_CruiseData", propOrder = {
    "name",
    "description",
    "longDescription",
    "images",
    "imagesLong",
    "ship",
    "categories"
})
public class JPCruiseData {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected JPDescription description;
    @XmlElement(name = "LongDescription")
    protected JPDescription longDescription;
    @XmlElement(name = "Images")
    protected ArrayOfString1 images;
    @XmlElement(name = "ImagesLong")
    protected ArrayOfJPImageLong imagesLong;
    @XmlElement(name = "Ship")
    protected JPShip ship;
    @XmlElement(name = "Categories")
    protected ArrayOfJPCruiseCategory categories;
    @XmlAttribute(name = "Code")
    protected String code;

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JPDescription }
     *     
     */
    public JPDescription getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPDescription }
     *     
     */
    public void setDescription(JPDescription value) {
        this.description = value;
    }

    /**
     * Gets the value of the longDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JPDescription }
     *     
     */
    public JPDescription getLongDescription() {
        return longDescription;
    }

    /**
     * Sets the value of the longDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPDescription }
     *     
     */
    public void setLongDescription(JPDescription value) {
        this.longDescription = value;
    }

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString1 }
     *     
     */
    public ArrayOfString1 getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString1 }
     *     
     */
    public void setImages(ArrayOfString1 value) {
        this.images = value;
    }

    /**
     * Gets the value of the imagesLong property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPImageLong }
     *     
     */
    public ArrayOfJPImageLong getImagesLong() {
        return imagesLong;
    }

    /**
     * Sets the value of the imagesLong property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPImageLong }
     *     
     */
    public void setImagesLong(ArrayOfJPImageLong value) {
        this.imagesLong = value;
    }

    /**
     * Gets the value of the ship property.
     * 
     * @return
     *     possible object is
     *     {@link JPShip }
     *     
     */
    public JPShip getShip() {
        return ship;
    }

    /**
     * Sets the value of the ship property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPShip }
     *     
     */
    public void setShip(JPShip value) {
        this.ship = value;
    }

    /**
     * Gets the value of the categories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseCategory }
     *     
     */
    public ArrayOfJPCruiseCategory getCategories() {
        return categories;
    }

    /**
     * Sets the value of the categories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseCategory }
     *     
     */
    public void setCategories(ArrayOfJPCruiseCategory value) {
        this.categories = value;
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
