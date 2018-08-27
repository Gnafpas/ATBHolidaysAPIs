
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_hotelRatePlanRate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_hotelRatePlanRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StayDates" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_DateIntervals" minOccurs="0"/>
 *         &lt;element name="RateDiscounts" type="{http://www.juniper.es/webservice/2007/}JPSOAP_RateDiscounts" minOccurs="0"/>
 *         &lt;element name="RatePrices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_RatePrice" minOccurs="0"/>
 *         &lt;element name="Ages" type="{http://www.juniper.es/webservice/2007/}JPSOAP_Ages" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_hotelRatePlanRate", propOrder = {
    "stayDates",
    "rateDiscounts",
    "ratePrices",
    "ages"
})
public class JPSOAPHotelRatePlanRate {

    @XmlElement(name = "StayDates")
    protected ArrayOfJPSOAPDateIntervals stayDates;
    @XmlElement(name = "RateDiscounts")
    protected JPSOAPRateDiscounts rateDiscounts;
    @XmlElement(name = "RatePrices")
    protected ArrayOfJPSOAPRatePrice ratePrices;
    @XmlElement(name = "Ages")
    protected JPSOAPAges ages;
    @XmlAttribute(name = "Code")
    protected String code;

    /**
     * Gets the value of the stayDates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPDateIntervals }
     *     
     */
    public ArrayOfJPSOAPDateIntervals getStayDates() {
        return stayDates;
    }

    /**
     * Sets the value of the stayDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPDateIntervals }
     *     
     */
    public void setStayDates(ArrayOfJPSOAPDateIntervals value) {
        this.stayDates = value;
    }

    /**
     * Gets the value of the rateDiscounts property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPRateDiscounts }
     *     
     */
    public JPSOAPRateDiscounts getRateDiscounts() {
        return rateDiscounts;
    }

    /**
     * Sets the value of the rateDiscounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPRateDiscounts }
     *     
     */
    public void setRateDiscounts(JPSOAPRateDiscounts value) {
        this.rateDiscounts = value;
    }

    /**
     * Gets the value of the ratePrices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPRatePrice }
     *     
     */
    public ArrayOfJPSOAPRatePrice getRatePrices() {
        return ratePrices;
    }

    /**
     * Sets the value of the ratePrices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPRatePrice }
     *     
     */
    public void setRatePrices(ArrayOfJPSOAPRatePrice value) {
        this.ratePrices = value;
    }

    /**
     * Gets the value of the ages property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPAges }
     *     
     */
    public JPSOAPAges getAges() {
        return ages;
    }

    /**
     * Sets the value of the ages property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPAges }
     *     
     */
    public void setAges(JPSOAPAges value) {
        this.ages = value;
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

}
