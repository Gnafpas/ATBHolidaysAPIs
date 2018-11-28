
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FlightCheckAvailResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FlightCheckAvailResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PriceInformation" type="{http://www.juniper.es/webservice/2007/}JP_FlightPriceInformation" minOccurs="0"/>
 *         &lt;element name="OptionalElements" type="{http://www.juniper.es/webservice/2007/}JP_OptionalElements" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Status" use="required" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" />
 *       &lt;attribute name="Direction" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LowCost" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FlightCheckAvailResult", propOrder = {
    "priceInformation",
    "optionalElements"
})
public class JPFlightCheckAvailResult {

    @XmlElement(name = "PriceInformation")
    protected JPFlightPriceInformation priceInformation;
    @XmlElement(name = "OptionalElements")
    protected JPOptionalElements optionalElements;
    @XmlAttribute(name = "Status", required = true)
    protected JPAvailStatus status;
    @XmlAttribute(name = "Direction")
    protected String direction;
    @XmlAttribute(name = "LowCost", required = true)
    protected boolean lowCost;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;

    /**
     * Gets the value of the priceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link JPFlightPriceInformation }
     *     
     */
    public JPFlightPriceInformation getPriceInformation() {
        return priceInformation;
    }

    /**
     * Sets the value of the priceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFlightPriceInformation }
     *     
     */
    public void setPriceInformation(JPFlightPriceInformation value) {
        this.priceInformation = value;
    }

    /**
     * Gets the value of the optionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPOptionalElements }
     *     
     */
    public JPOptionalElements getOptionalElements() {
        return optionalElements;
    }

    /**
     * Sets the value of the optionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPOptionalElements }
     *     
     */
    public void setOptionalElements(JPOptionalElements value) {
        this.optionalElements = value;
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
     */
    public boolean isLowCost() {
        return lowCost;
    }

    /**
     * Sets the value of the lowCost property.
     * 
     */
    public void setLowCost(boolean value) {
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

}
