
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseCabin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseCabin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfString1" minOccurs="0"/>
 *         &lt;element name="Deck" type="{http://www.juniper.es/webservice/2007/}JP_CruiseDeck" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Capacity" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Beds" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="CabinNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseCabin", propOrder = {
    "images",
    "deck"
})
public class JPCruiseCabin {

    @XmlElement(name = "Images")
    protected ArrayOfString1 images;
    @XmlElement(name = "Deck")
    protected JPCruiseDeck deck;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Capacity", required = true)
    protected int capacity;
    @XmlAttribute(name = "Beds")
    protected Integer beds;
    @XmlAttribute(name = "CabinNumber")
    protected String cabinNumber;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;

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
     * Gets the value of the deck property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseDeck }
     *     
     */
    public JPCruiseDeck getDeck() {
        return deck;
    }

    /**
     * Sets the value of the deck property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseDeck }
     *     
     */
    public void setDeck(JPCruiseDeck value) {
        this.deck = value;
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
     * Gets the value of the capacity property.
     * 
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     */
    public void setCapacity(int value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the beds property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBeds() {
        return beds;
    }

    /**
     * Sets the value of the beds property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBeds(Integer value) {
        this.beds = value;
    }

    /**
     * Gets the value of the cabinNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCabinNumber() {
        return cabinNumber;
    }

    /**
     * Sets the value of the cabinNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCabinNumber(String value) {
        this.cabinNumber = value;
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
