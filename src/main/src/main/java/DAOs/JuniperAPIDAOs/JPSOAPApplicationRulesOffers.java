
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_ApplicationRulesOffers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_ApplicationRulesOffers">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_ApplicationRules">
 *       &lt;sequence>
 *         &lt;element name="ApplyWithOffers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IntCodeAttr4" minOccurs="0"/>
 *         &lt;element name="AlternateWithOffers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IntCodeAttr4" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ApplyAdditionals" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ApplyChildren" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="NonRefundable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="MinAge" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_ApplicationRulesOffers", propOrder = {
    "applyWithOffers",
    "alternateWithOffers"
})
public class JPSOAPApplicationRulesOffers
    extends JPSOAPApplicationRules
{

    @XmlElement(name = "ApplyWithOffers")
    protected ArrayOfJPSOAPIntCodeAttr4 applyWithOffers;
    @XmlElement(name = "AlternateWithOffers")
    protected ArrayOfJPSOAPIntCodeAttr4 alternateWithOffers;
    @XmlAttribute(name = "ApplyAdditionals", required = true)
    protected boolean applyAdditionals;
    @XmlAttribute(name = "ApplyChildren", required = true)
    protected boolean applyChildren;
    @XmlAttribute(name = "NonRefundable", required = true)
    protected boolean nonRefundable;
    @XmlAttribute(name = "MinAge")
    protected Integer minAge;

    /**
     * Gets the value of the applyWithOffers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIntCodeAttr4 }
     *     
     */
    public ArrayOfJPSOAPIntCodeAttr4 getApplyWithOffers() {
        return applyWithOffers;
    }

    /**
     * Sets the value of the applyWithOffers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIntCodeAttr4 }
     *     
     */
    public void setApplyWithOffers(ArrayOfJPSOAPIntCodeAttr4 value) {
        this.applyWithOffers = value;
    }

    /**
     * Gets the value of the alternateWithOffers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIntCodeAttr4 }
     *     
     */
    public ArrayOfJPSOAPIntCodeAttr4 getAlternateWithOffers() {
        return alternateWithOffers;
    }

    /**
     * Sets the value of the alternateWithOffers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIntCodeAttr4 }
     *     
     */
    public void setAlternateWithOffers(ArrayOfJPSOAPIntCodeAttr4 value) {
        this.alternateWithOffers = value;
    }

    /**
     * Gets the value of the applyAdditionals property.
     * 
     */
    public boolean isApplyAdditionals() {
        return applyAdditionals;
    }

    /**
     * Sets the value of the applyAdditionals property.
     * 
     */
    public void setApplyAdditionals(boolean value) {
        this.applyAdditionals = value;
    }

    /**
     * Gets the value of the applyChildren property.
     * 
     */
    public boolean isApplyChildren() {
        return applyChildren;
    }

    /**
     * Sets the value of the applyChildren property.
     * 
     */
    public void setApplyChildren(boolean value) {
        this.applyChildren = value;
    }

    /**
     * Gets the value of the nonRefundable property.
     * 
     */
    public boolean isNonRefundable() {
        return nonRefundable;
    }

    /**
     * Sets the value of the nonRefundable property.
     * 
     */
    public void setNonRefundable(boolean value) {
        this.nonRefundable = value;
    }

    /**
     * Gets the value of the minAge property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinAge() {
        return minAge;
    }

    /**
     * Sets the value of the minAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinAge(Integer value) {
        this.minAge = value;
    }

}
