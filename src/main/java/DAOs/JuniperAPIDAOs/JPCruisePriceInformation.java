
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruisePriceInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruisePriceInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Components" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseComponent" minOccurs="0"/>
 *         &lt;element name="Category" type="{http://www.juniper.es/webservice/2007/}JP_CruiseCategory" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_CruiseAdditionalElements" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruisePriceInformation", propOrder = {
    "components",
    "category",
    "additionalElements",
    "prices"
})
public class JPCruisePriceInformation {

    @XmlElement(name = "Components")
    protected ArrayOfJPCruiseComponent components;
    @XmlElement(name = "Category")
    protected JPCruiseCategory category;
    @XmlElement(name = "AdditionalElements")
    protected JPCruiseAdditionalElements additionalElements;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;

    /**
     * Gets the value of the components property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseComponent }
     *     
     */
    public ArrayOfJPCruiseComponent getComponents() {
        return components;
    }

    /**
     * Sets the value of the components property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseComponent }
     *     
     */
    public void setComponents(ArrayOfJPCruiseComponent value) {
        this.components = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseCategory }
     *     
     */
    public JPCruiseCategory getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseCategory }
     *     
     */
    public void setCategory(JPCruiseCategory value) {
        this.category = value;
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

}
