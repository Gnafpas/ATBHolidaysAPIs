
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_CruiseAdditionalElements" minOccurs="0"/>
 *         &lt;element name="Cabins" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseCabin" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.juniper.es/webservice/2007/}JP_Description" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfString1" minOccurs="0"/>
 *         &lt;element name="ImagesLong" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ImageLong" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DeckLoc" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SelectionCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseCategory", propOrder = {
    "prices",
    "additionalElements",
    "cabins",
    "name",
    "description",
    "images",
    "imagesLong"
})
public class JPCruiseCategory {

    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "AdditionalElements")
    protected JPCruiseAdditionalElements additionalElements;
    @XmlElement(name = "Cabins")
    protected ArrayOfJPCruiseCabin cabins;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected JPDescription description;
    @XmlElement(name = "Images")
    protected ArrayOfString1 images;
    @XmlElement(name = "ImagesLong")
    protected ArrayOfJPImageLong imagesLong;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "DeckLoc")
    protected String deckLoc;
    @XmlAttribute(name = "SelectionCode")
    protected String selectionCode;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;

    /**
     * Gets the value of the prices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPrice }
     *     
     */
    public ArrayOfJPPrice getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPrice }
     *     
     */
    public void setPrices(ArrayOfJPPrice value) {
        this.prices = value;
    }

    /**
     * Gets the value of the additionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseAdditionalElements }
     *     
     */
    public JPCruiseAdditionalElements getAdditionalElements() {
        return additionalElements;
    }

    /**
     * Sets the value of the additionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseAdditionalElements }
     *     
     */
    public void setAdditionalElements(JPCruiseAdditionalElements value) {
        this.additionalElements = value;
    }

    /**
     * Gets the value of the cabins property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseCabin }
     *     
     */
    public ArrayOfJPCruiseCabin getCabins() {
        return cabins;
    }

    /**
     * Sets the value of the cabins property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseCabin }
     *     
     */
    public void setCabins(ArrayOfJPCruiseCabin value) {
        this.cabins = value;
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

    /**
     * Gets the value of the deckLoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeckLoc() {
        return deckLoc;
    }

    /**
     * Sets the value of the deckLoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeckLoc(String value) {
        this.deckLoc = value;
    }

    /**
     * Gets the value of the selectionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectionCode() {
        return selectionCode;
    }

    /**
     * Sets the value of the selectionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectionCode(String value) {
        this.selectionCode = value;
    }

    /**
     * Gets the value of the ratePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    /**
     * Sets the value of the ratePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatePlanCode(String value) {
        this.ratePlanCode = value;
    }

}
