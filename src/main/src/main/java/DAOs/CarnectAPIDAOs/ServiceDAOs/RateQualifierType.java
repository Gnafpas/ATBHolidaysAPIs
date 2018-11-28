
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RateQualifierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RateQualifierType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PromoDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RateComments" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfRateQualifierTypeRateComment" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TravelPurpose" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RateCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CorpDiscountNmbr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RateQualifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RatePeriod" type="{http://www.opentravel.org/OTA/2003/05}RateQualifierTypeRatePeriod" />
 *       &lt;attribute name="GuaranteedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ArriveByFlight" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="RateAuthorizationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VendorRateID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RateQualifierType", propOrder = {
    "promoDesc",
    "rateComments"
})
public class RateQualifierType {

    @XmlElement(name = "PromoDesc")
    protected String promoDesc;
    @XmlElement(name = "RateComments")
    protected ArrayOfRateQualifierTypeRateComment rateComments;
    @XmlAttribute(name = "TravelPurpose")
    protected String travelPurpose;
    @XmlAttribute(name = "RateCategory")
    protected String rateCategory;
    @XmlAttribute(name = "CorpDiscountNmbr")
    protected String corpDiscountNmbr;
    @XmlAttribute(name = "RateQualifier")
    protected String rateQualifier;
    @XmlAttribute(name = "RatePeriod")
    protected RateQualifierTypeRatePeriod ratePeriod;
    @XmlAttribute(name = "GuaranteedInd")
    protected Boolean guaranteedInd;
    @XmlAttribute(name = "ArriveByFlight")
    protected Boolean arriveByFlight;
    @XmlAttribute(name = "RateAuthorizationCode")
    protected String rateAuthorizationCode;
    @XmlAttribute(name = "VendorRateID")
    protected String vendorRateID;

    /**
     * Gets the value of the promoDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoDesc() {
        return promoDesc;
    }

    /**
     * Sets the value of the promoDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoDesc(String value) {
        this.promoDesc = value;
    }

    /**
     * Gets the value of the rateComments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRateQualifierTypeRateComment }
     *     
     */
    public ArrayOfRateQualifierTypeRateComment getRateComments() {
        return rateComments;
    }

    /**
     * Sets the value of the rateComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRateQualifierTypeRateComment }
     *     
     */
    public void setRateComments(ArrayOfRateQualifierTypeRateComment value) {
        this.rateComments = value;
    }

    /**
     * Gets the value of the travelPurpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTravelPurpose() {
        return travelPurpose;
    }

    /**
     * Sets the value of the travelPurpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTravelPurpose(String value) {
        this.travelPurpose = value;
    }

    /**
     * Gets the value of the rateCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateCategory() {
        return rateCategory;
    }

    /**
     * Sets the value of the rateCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateCategory(String value) {
        this.rateCategory = value;
    }

    /**
     * Gets the value of the corpDiscountNmbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorpDiscountNmbr() {
        return corpDiscountNmbr;
    }

    /**
     * Sets the value of the corpDiscountNmbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorpDiscountNmbr(String value) {
        this.corpDiscountNmbr = value;
    }

    /**
     * Gets the value of the rateQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateQualifier() {
        return rateQualifier;
    }

    /**
     * Sets the value of the rateQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateQualifier(String value) {
        this.rateQualifier = value;
    }

    /**
     * Gets the value of the ratePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link RateQualifierTypeRatePeriod }
     *     
     */
    public RateQualifierTypeRatePeriod getRatePeriod() {
        return ratePeriod;
    }

    /**
     * Sets the value of the ratePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateQualifierTypeRatePeriod }
     *     
     */
    public void setRatePeriod(RateQualifierTypeRatePeriod value) {
        this.ratePeriod = value;
    }

    /**
     * Gets the value of the guaranteedInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGuaranteedInd() {
        return guaranteedInd;
    }

    /**
     * Sets the value of the guaranteedInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGuaranteedInd(Boolean value) {
        this.guaranteedInd = value;
    }

    /**
     * Gets the value of the arriveByFlight property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isArriveByFlight() {
        if (arriveByFlight == null) {
            return false;
        } else {
            return arriveByFlight;
        }
    }

    /**
     * Sets the value of the arriveByFlight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setArriveByFlight(Boolean value) {
        this.arriveByFlight = value;
    }

    /**
     * Gets the value of the rateAuthorizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateAuthorizationCode() {
        return rateAuthorizationCode;
    }

    /**
     * Sets the value of the rateAuthorizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateAuthorizationCode(String value) {
        this.rateAuthorizationCode = value;
    }

    /**
     * Gets the value of the vendorRateID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorRateID() {
        return vendorRateID;
    }

    /**
     * Sets the value of the vendorRateID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorRateID(String value) {
        this.vendorRateID = value;
    }

}
