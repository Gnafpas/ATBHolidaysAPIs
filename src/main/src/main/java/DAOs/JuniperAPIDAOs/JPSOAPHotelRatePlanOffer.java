
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelRatePlanOffer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelRatePlanOffer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_BaseSupleOfferRest">
 *       &lt;sequence>
 *         &lt;element name="ApplicationRules" type="{http://www.juniper.es/webservice/2007/}JPSOAP_ApplicationRulesOffers" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}JPSOAP_SuppleOfferPrices" minOccurs="0"/>
 *         &lt;element name="Allotment" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_Allotment" minOccurs="0"/>
 *         &lt;element name="FreeNights" type="{http://www.juniper.es/webservice/2007/}JPSOAP_HotelRatePlanFreeNightsOffer" minOccurs="0"/>
 *         &lt;element name="FreePaxes" type="{http://www.juniper.es/webservice/2007/}JPSOAP_HotelRatePlanFreePaxesOffer" minOccurs="0"/>
 *         &lt;element name="BoardUpgrade" type="{http://www.juniper.es/webservice/2007/}JPSOAP_HotelRatePlanBoardUpgradeOffer" minOccurs="0"/>
 *         &lt;element name="RoomUpgrade" type="{http://www.juniper.es/webservice/2007/}JPSOAP_HotelRatePlanRoomUpgradeOffer" minOccurs="0"/>
 *         &lt;element name="PaymentConditions" type="{http://www.juniper.es/webservice/2007/}JPSOAP_HotelRatePlanOfferPaymentConditions" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_OfferType" />
 *       &lt;attribute name="Priority" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="PromoCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MandatoryPromoCode" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="BaseBoardCode" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelRatePlanOffer", propOrder = {
    "applicationRules",
    "prices",
    "allotment",
    "freeNights",
    "freePaxes",
    "boardUpgrade",
    "roomUpgrade",
    "paymentConditions"
})
public class JPSOAPHotelRatePlanOffer
    extends JPSOAPBaseSupleOfferRest
{

    @XmlElement(name = "ApplicationRules")
    protected JPSOAPApplicationRulesOffers applicationRules;
    @XmlElement(name = "Prices")
    protected JPSOAPSuppleOfferPrices prices;
    @XmlElement(name = "Allotment")
    protected ArrayOfJPSOAPAllotment allotment;
    @XmlElement(name = "FreeNights")
    protected JPSOAPHotelRatePlanFreeNightsOffer freeNights;
    @XmlElement(name = "FreePaxes")
    protected JPSOAPHotelRatePlanFreePaxesOffer freePaxes;
    @XmlElement(name = "BoardUpgrade")
    protected JPSOAPHotelRatePlanBoardUpgradeOffer boardUpgrade;
    @XmlElement(name = "RoomUpgrade")
    protected JPSOAPHotelRatePlanRoomUpgradeOffer roomUpgrade;
    @XmlElement(name = "PaymentConditions")
    protected JPSOAPHotelRatePlanOfferPaymentConditions paymentConditions;
    @XmlAttribute(name = "Type", required = true)
    protected JPSOAPOfferType type;
    @XmlAttribute(name = "Priority", required = true)
    protected int priority;
    @XmlAttribute(name = "PromoCode")
    protected String promoCode;
    @XmlAttribute(name = "MandatoryPromoCode")
    protected Boolean mandatoryPromoCode;
    @XmlAttribute(name = "BaseBoardCode")
    protected Integer baseBoardCode;

    /**
     * Gets the value of the applicationRules property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPApplicationRulesOffers }
     *     
     */
    public JPSOAPApplicationRulesOffers getApplicationRules() {
        return applicationRules;
    }

    /**
     * Sets the value of the applicationRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPApplicationRulesOffers }
     *     
     */
    public void setApplicationRules(JPSOAPApplicationRulesOffers value) {
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
     * Gets the value of the allotment property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPAllotment }
     *     
     */
    public ArrayOfJPSOAPAllotment getAllotment() {
        return allotment;
    }

    /**
     * Sets the value of the allotment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPAllotment }
     *     
     */
    public void setAllotment(ArrayOfJPSOAPAllotment value) {
        this.allotment = value;
    }

    /**
     * Gets the value of the freeNights property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPHotelRatePlanFreeNightsOffer }
     *     
     */
    public JPSOAPHotelRatePlanFreeNightsOffer getFreeNights() {
        return freeNights;
    }

    /**
     * Sets the value of the freeNights property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPHotelRatePlanFreeNightsOffer }
     *     
     */
    public void setFreeNights(JPSOAPHotelRatePlanFreeNightsOffer value) {
        this.freeNights = value;
    }

    /**
     * Gets the value of the freePaxes property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPHotelRatePlanFreePaxesOffer }
     *     
     */
    public JPSOAPHotelRatePlanFreePaxesOffer getFreePaxes() {
        return freePaxes;
    }

    /**
     * Sets the value of the freePaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPHotelRatePlanFreePaxesOffer }
     *     
     */
    public void setFreePaxes(JPSOAPHotelRatePlanFreePaxesOffer value) {
        this.freePaxes = value;
    }

    /**
     * Gets the value of the boardUpgrade property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPHotelRatePlanBoardUpgradeOffer }
     *     
     */
    public JPSOAPHotelRatePlanBoardUpgradeOffer getBoardUpgrade() {
        return boardUpgrade;
    }

    /**
     * Sets the value of the boardUpgrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPHotelRatePlanBoardUpgradeOffer }
     *     
     */
    public void setBoardUpgrade(JPSOAPHotelRatePlanBoardUpgradeOffer value) {
        this.boardUpgrade = value;
    }

    /**
     * Gets the value of the roomUpgrade property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPHotelRatePlanRoomUpgradeOffer }
     *     
     */
    public JPSOAPHotelRatePlanRoomUpgradeOffer getRoomUpgrade() {
        return roomUpgrade;
    }

    /**
     * Sets the value of the roomUpgrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPHotelRatePlanRoomUpgradeOffer }
     *     
     */
    public void setRoomUpgrade(JPSOAPHotelRatePlanRoomUpgradeOffer value) {
        this.roomUpgrade = value;
    }

    /**
     * Gets the value of the paymentConditions property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPHotelRatePlanOfferPaymentConditions }
     *     
     */
    public JPSOAPHotelRatePlanOfferPaymentConditions getPaymentConditions() {
        return paymentConditions;
    }

    /**
     * Sets the value of the paymentConditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPHotelRatePlanOfferPaymentConditions }
     *     
     */
    public void setPaymentConditions(JPSOAPHotelRatePlanOfferPaymentConditions value) {
        this.paymentConditions = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPOfferType }
     *     
     */
    public JPSOAPOfferType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPOfferType }
     *     
     */
    public void setType(JPSOAPOfferType value) {
        this.type = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     */
    public void setPriority(int value) {
        this.priority = value;
    }

    /**
     * Gets the value of the promoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoCode() {
        return promoCode;
    }

    /**
     * Sets the value of the promoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoCode(String value) {
        this.promoCode = value;
    }

    /**
     * Gets the value of the mandatoryPromoCode property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMandatoryPromoCode() {
        return mandatoryPromoCode;
    }

    /**
     * Sets the value of the mandatoryPromoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMandatoryPromoCode(Boolean value) {
        this.mandatoryPromoCode = value;
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

}
