
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelRatePlanSupplement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelRatePlanSupplement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_BaseSupleOfferRest">
 *       &lt;sequence>
 *         &lt;element name="ApplicationRules" type="{http://www.juniper.es/webservice/2007/}JPSOAP_ApplicationRulesSupplement" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}JPSOAP_SuppleOfferPrices" minOccurs="0"/>
 *         &lt;element name="PickUpPoints" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_PickUpPoint" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_SupplementType" />
 *       &lt;attribute name="BaseBoardCode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="BaseRoomTypeCode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Mandatory" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Packaged" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="RateCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DirectPayment" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Duration" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelRatePlanSupplement", propOrder = {
    "applicationRules",
    "prices",
    "pickUpPoints"
})
public class JPSOAPHotelRatePlanSupplement
    extends JPSOAPBaseSupleOfferRest
{

    @XmlElement(name = "ApplicationRules")
    protected JPSOAPApplicationRulesSupplement applicationRules;
    @XmlElement(name = "Prices")
    protected JPSOAPSuppleOfferPrices prices;
    @XmlElement(name = "PickUpPoints")
    protected ArrayOfJPSOAPPickUpPoint pickUpPoints;
    @XmlAttribute(name = "Type", required = true)
    protected JPSOAPSupplementType type;
    @XmlAttribute(name = "BaseBoardCode")
    protected Integer baseBoardCode;
    @XmlAttribute(name = "BaseRoomTypeCode")
    protected Integer baseRoomTypeCode;
    @XmlAttribute(name = "Mandatory", required = true)
    protected boolean mandatory;
    @XmlAttribute(name = "Packaged", required = true)
    protected boolean packaged;
    @XmlAttribute(name = "RateCode")
    protected String rateCode;
    @XmlAttribute(name = "DirectPayment", required = true)
    protected boolean directPayment;
    @XmlAttribute(name = "Duration")
    protected Integer duration;

    /**
     * Gets the value of the applicationRules property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPApplicationRulesSupplement }
     *     
     */
    public JPSOAPApplicationRulesSupplement getApplicationRules() {
        return applicationRules;
    }

    /**
     * Sets the value of the applicationRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPApplicationRulesSupplement }
     *     
     */
    public void setApplicationRules(JPSOAPApplicationRulesSupplement value) {
        this.applicationRules = value;
    }

    /**
     * Gets the value of the prices property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPSuppleOfferPrices }
     *     
     */
    public JPSOAPSuppleOfferPrices getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPSuppleOfferPrices }
     *     
     */
    public void setPrices(JPSOAPSuppleOfferPrices value) {
        this.prices = value;
    }

    /**
     * Gets the value of the pickUpPoints property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPPickUpPoint }
     *     
     */
    public ArrayOfJPSOAPPickUpPoint getPickUpPoints() {
        return pickUpPoints;
    }

    /**
     * Sets the value of the pickUpPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPPickUpPoint }
     *     
     */
    public void setPickUpPoints(ArrayOfJPSOAPPickUpPoint value) {
        this.pickUpPoints = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPSupplementType }
     *     
     */
    public JPSOAPSupplementType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPSupplementType }
     *     
     */
    public void setType(JPSOAPSupplementType value) {
        this.type = value;
    }

    /**
     * Gets the value of the baseBoardCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBaseBoardCode() {
        return baseBoardCode;
    }

    /**
     * Sets the value of the baseBoardCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBaseBoardCode(Integer value) {
        this.baseBoardCode = value;
    }

    /**
     * Gets the value of the baseRoomTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBaseRoomTypeCode() {
        return baseRoomTypeCode;
    }

    /**
     * Sets the value of the baseRoomTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBaseRoomTypeCode(Integer value) {
        this.baseRoomTypeCode = value;
    }

    /**
     * Gets the value of the mandatory property.
     * 
     */
    public boolean isMandatory() {
        return mandatory;
    }

    /**
     * Sets the value of the mandatory property.
     * 
     */
    public void setMandatory(boolean value) {
        this.mandatory = value;
    }

    /**
     * Gets the value of the packaged property.
     * 
     */
    public boolean isPackaged() {
        return packaged;
    }

    /**
     * Sets the value of the packaged property.
     * 
     */
    public void setPackaged(boolean value) {
        this.packaged = value;
    }

    /**
     * Gets the value of the rateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateCode() {
        return rateCode;
    }

    /**
     * Sets the value of the rateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateCode(String value) {
        this.rateCode = value;
    }

    /**
     * Gets the value of the directPayment property.
     * 
     */
    public boolean isDirectPayment() {
        return directPayment;
    }

    /**
     * Sets the value of the directPayment property.
     * 
     */
    public void setDirectPayment(boolean value) {
        this.directPayment = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDuration(Integer value) {
        this.duration = value;
    }

}
