
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Flight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Flight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Routes" type="{http://www.juniper.es/webservice/2007/}JP_Routes" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_AdditionalElements" minOccurs="0"/>
 *         &lt;element name="Rules" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_FlightRule" minOccurs="0"/>
 *         &lt;element name="InfoExtra" type="{http://www.juniper.es/webservice/2007/}JP_InfoExtra" minOccurs="0"/>
 *         &lt;element name="OptionalFares" type="{http://www.juniper.es/webservice/2007/}JP_OptionalFares" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="FareType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AvailableSeats" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Number" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Direction" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LowCost" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" />
 *       &lt;attribute name="ICode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SearchMore" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Order" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Source" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BrandedCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Flight", propOrder = {
    "routes",
    "prices",
    "additionalElements",
    "rules",
    "infoExtra",
    "optionalFares"
})
public class JPFlight {

    @XmlElement(name = "Routes")
    protected JPRoutes routes;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "AdditionalElements")
    protected JPAdditionalElements additionalElements;
    @XmlElement(name = "Rules")
    protected ArrayOfJPFlightRule rules;
    @XmlElement(name = "InfoExtra")
    protected JPInfoExtra infoExtra;
    @XmlElement(name = "OptionalFares")
    protected JPOptionalFares optionalFares;
    @XmlAttribute(name = "FareType")
    protected String fareType;
    @XmlAttribute(name = "AvailableSeats")
    protected Integer availableSeats;
    @XmlAttribute(name = "Number")
    protected String number;
    @XmlAttribute(name = "Direction")
    protected String direction;
    @XmlAttribute(name = "LowCost")
    protected Boolean lowCost;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlAttribute(name = "Status")
    protected JPAvailStatus status;
    @XmlAttribute(name = "ICode")
    protected String iCode;
    @XmlAttribute(name = "SearchMore")
    protected Boolean searchMore;
    @XmlAttribute(name = "Order")
    protected Integer order;
    @XmlAttribute(name = "Source")
    protected String source;
    @XmlAttribute(name = "BrandedCode")
    protected String brandedCode;

    /**
     * Gets the value of the routes property.
     * 
     * @return
     *     possible object is
     *     {@link JPRoutes }
     *     
     */
    public JPRoutes getRoutes() {
        return routes;
    }

    /**
     * Sets the value of the routes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRoutes }
     *     
     */
    public void setRoutes(JPRoutes value) {
        this.routes = value;
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
     * Gets the value of the additionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPAdditionalElements }
     *     
     */
    public JPAdditionalElements getAdditionalElements() {
        return additionalElements;
    }

    /**
     * Sets the value of the additionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAdditionalElements }
     *     
     */
    public void setAdditionalElements(JPAdditionalElements value) {
        this.additionalElements = value;
    }

    /**
     * Gets the value of the rules property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFlightRule }
     *     
     */
    public ArrayOfJPFlightRule getRules() {
        return rules;
    }

    /**
     * Sets the value of the rules property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFlightRule }
     *     
     */
    public void setRules(ArrayOfJPFlightRule value) {
        this.rules = value;
    }

    /**
     * Gets the value of the infoExtra property.
     * 
     * @return
     *     possible object is
     *     {@link JPInfoExtra }
     *     
     */
    public JPInfoExtra getInfoExtra() {
        return infoExtra;
    }

    /**
     * Sets the value of the infoExtra property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPInfoExtra }
     *     
     */
    public void setInfoExtra(JPInfoExtra value) {
        this.infoExtra = value;
    }

    /**
     * Gets the value of the optionalFares property.
     * 
     * @return
     *     possible object is
     *     {@link JPOptionalFares }
     *     
     */
    public JPOptionalFares getOptionalFares() {
        return optionalFares;
    }

    /**
     * Sets the value of the optionalFares property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPOptionalFares }
     *     
     */
    public void setOptionalFares(JPOptionalFares value) {
        this.optionalFares = value;
    }

    /**
     * Gets the value of the fareType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFareType() {
        return fareType;
    }

    /**
     * Sets the value of the fareType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFareType(String value) {
        this.fareType = value;
    }

    /**
     * Gets the value of the availableSeats property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAvailableSeats() {
        return availableSeats;
    }

    /**
     * Sets the value of the availableSeats property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAvailableSeats(Integer value) {
        this.availableSeats = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

    /**
     * Gets the value of the lowCost property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLowCost() {
        return lowCost;
    }

    /**
     * Sets the value of the lowCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLowCost(Boolean value) {
        this.lowCost = value;
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

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JPAvailStatus }
     *     
     */
    public JPAvailStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPAvailStatus }
     *     
     */
    public void setStatus(JPAvailStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the iCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICode() {
        return iCode;
    }

    /**
     * Sets the value of the iCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICode(String value) {
        this.iCode = value;
    }

    /**
     * Gets the value of the searchMore property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSearchMore() {
        return searchMore;
    }

    /**
     * Sets the value of the searchMore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearchMore(Boolean value) {
        this.searchMore = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrder(Integer value) {
        this.order = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the brandedCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrandedCode() {
        return brandedCode;
    }

    /**
     * Sets the value of the brandedCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrandedCode(String value) {
        this.brandedCode = value;
    }

}
