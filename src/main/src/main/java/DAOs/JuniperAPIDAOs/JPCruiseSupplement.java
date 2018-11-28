
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseSupplement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseSupplement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RelPaxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseExtendedRelPax" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Units" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}SuplementsType" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseSupplement", propOrder = {
    "name",
    "description",
    "relPaxes",
    "prices"
})
public class JPCruiseSupplement {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "RelPaxes")
    protected ArrayOfJPCruiseExtendedRelPax relPaxes;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlAttribute(name = "Units", required = true)
    protected int units;
    @XmlAttribute(name = "Type", required = true)
    protected SuplementsType type;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;

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
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the relPaxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseExtendedRelPax }
     *     
     */
    public ArrayOfJPCruiseExtendedRelPax getRelPaxes() {
        return relPaxes;
    }

    /**
     * Sets the value of the relPaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseExtendedRelPax }
     *     
     */
    public void setRelPaxes(ArrayOfJPCruiseExtendedRelPax value) {
        this.relPaxes = value;
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

    /**
     * Gets the value of the units property.
     * 
     */
    public int getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     */
    public void setUnits(int value) {
        this.units = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link SuplementsType }
     *     
     */
    public SuplementsType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link SuplementsType }
     *     
     */
    public void setType(SuplementsType value) {
        this.type = value;
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
