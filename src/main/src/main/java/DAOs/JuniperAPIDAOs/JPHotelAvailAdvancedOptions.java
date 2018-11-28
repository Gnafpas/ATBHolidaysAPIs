
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelAvailAdvancedOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelAvailAdvancedOptions">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_AvailAdvancedOptions">
 *       &lt;sequence>
 *         &lt;element name="ShowHotelInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowOnlyAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowAllCombinations" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowOnlyBestPriceCombination" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowAllRates" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowAllPortfolio" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowAllChildrenCombinations" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowCancellationPolicies" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ExcludeNonRefundable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowDynamicInventory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowCompleteInfo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HideRatePlanCode" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TimeOut" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelAvailAdvancedOptions", propOrder = {
    "showHotelInfo",
    "showOnlyAvailable",
    "showAllCombinations",
    "showOnlyBestPriceCombination",
    "showAllRates",
    "showAllPortfolio",
    "showAllChildrenCombinations",
    "showCancellationPolicies",
    "excludeNonRefundable",
    "showDynamicInventory",
    "showCompleteInfo",
    "hideRatePlanCode",
    "timeOut"
})
public class JPHotelAvailAdvancedOptions
    extends JPAvailAdvancedOptions
{

    @XmlElement(name = "ShowHotelInfo")
    protected Boolean showHotelInfo;
    @XmlElement(name = "ShowOnlyAvailable")
    protected Boolean showOnlyAvailable;
    @XmlElement(name = "ShowAllCombinations")
    protected Boolean showAllCombinations;
    @XmlElement(name = "ShowOnlyBestPriceCombination")
    protected Boolean showOnlyBestPriceCombination;
    @XmlElement(name = "ShowAllRates")
    protected Boolean showAllRates;
    @XmlElement(name = "ShowAllPortfolio")
    protected Boolean showAllPortfolio;
    @XmlElement(name = "ShowAllChildrenCombinations")
    protected Boolean showAllChildrenCombinations;
    @XmlElement(name = "ShowCancellationPolicies")
    protected Boolean showCancellationPolicies;
    @XmlElement(name = "ExcludeNonRefundable")
    protected Boolean excludeNonRefundable;
    @XmlElement(name = "ShowDynamicInventory")
    protected Boolean showDynamicInventory;
    @XmlElement(name = "ShowCompleteInfo")
    protected Boolean showCompleteInfo;
    @XmlElement(name = "HideRatePlanCode")
    protected Boolean hideRatePlanCode;
    @XmlElement(name = "TimeOut")
    protected Integer timeOut;

    /**
     * Gets the value of the showHotelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowHotelInfo() {
        return showHotelInfo;
    }

    /**
     * Sets the value of the showHotelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowHotelInfo(Boolean value) {
        this.showHotelInfo = value;
    }

    /**
     * Gets the value of the showOnlyAvailable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowOnlyAvailable() {
        return showOnlyAvailable;
    }

    /**
     * Sets the value of the showOnlyAvailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowOnlyAvailable(Boolean value) {
        this.showOnlyAvailable = value;
    }

    /**
     * Gets the value of the showAllCombinations property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowAllCombinations() {
        return showAllCombinations;
    }

    /**
     * Sets the value of the showAllCombinations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowAllCombinations(Boolean value) {
        this.showAllCombinations = value;
    }

    /**
     * Gets the value of the showOnlyBestPriceCombination property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowOnlyBestPriceCombination() {
        return showOnlyBestPriceCombination;
    }

    /**
     * Sets the value of the showOnlyBestPriceCombination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowOnlyBestPriceCombination(Boolean value) {
        this.showOnlyBestPriceCombination = value;
    }

    /**
     * Gets the value of the showAllRates property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowAllRates() {
        return showAllRates;
    }

    /**
     * Sets the value of the showAllRates property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowAllRates(Boolean value) {
        this.showAllRates = value;
    }

    /**
     * Gets the value of the showAllPortfolio property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowAllPortfolio() {
        return showAllPortfolio;
    }

    /**
     * Sets the value of the showAllPortfolio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowAllPortfolio(Boolean value) {
        this.showAllPortfolio = value;
    }

    /**
     * Gets the value of the showAllChildrenCombinations property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowAllChildrenCombinations() {
        return showAllChildrenCombinations;
    }

    /**
     * Sets the value of the showAllChildrenCombinations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowAllChildrenCombinations(Boolean value) {
        this.showAllChildrenCombinations = value;
    }

    /**
     * Gets the value of the showCancellationPolicies property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowCancellationPolicies() {
        return showCancellationPolicies;
    }

    /**
     * Sets the value of the showCancellationPolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowCancellationPolicies(Boolean value) {
        this.showCancellationPolicies = value;
    }

    /**
     * Gets the value of the excludeNonRefundable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExcludeNonRefundable() {
        return excludeNonRefundable;
    }

    /**
     * Sets the value of the excludeNonRefundable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExcludeNonRefundable(Boolean value) {
        this.excludeNonRefundable = value;
    }

    /**
     * Gets the value of the showDynamicInventory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowDynamicInventory() {
        return showDynamicInventory;
    }

    /**
     * Sets the value of the showDynamicInventory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowDynamicInventory(Boolean value) {
        this.showDynamicInventory = value;
    }

    /**
     * Gets the value of the showCompleteInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowCompleteInfo() {
        return showCompleteInfo;
    }

    /**
     * Sets the value of the showCompleteInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowCompleteInfo(Boolean value) {
        this.showCompleteInfo = value;
    }

    /**
     * Gets the value of the hideRatePlanCode property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHideRatePlanCode() {
        return hideRatePlanCode;
    }

    /**
     * Sets the value of the hideRatePlanCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHideRatePlanCode(Boolean value) {
        this.hideRatePlanCode = value;
    }

    /**
     * Gets the value of the timeOut property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTimeOut() {
        return timeOut;
    }

    /**
     * Sets the value of the timeOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTimeOut(Integer value) {
        this.timeOut = value;
    }

}
