
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelRatePlanFreeNightsOffer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelRatePlanFreeNightsOffer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Nights" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Free" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Quote" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_FreeNightsOfferQuotation" />
 *       &lt;attribute name="ApplyOnce" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelRatePlanFreeNightsOffer")
public class JPSOAPHotelRatePlanFreeNightsOffer {

    @XmlAttribute(name = "Nights", required = true)
    protected int nights;
    @XmlAttribute(name = "Free", required = true)
    protected int free;
    @XmlAttribute(name = "Quote", required = true)
    protected JPSOAPFreeNightsOfferQuotation quote;
    @XmlAttribute(name = "ApplyOnce", required = true)
    protected boolean applyOnce;

    /**
     * Gets the value of the nights property.
     * 
     */
    public int getNights() {
        return nights;
    }

    /**
     * Sets the value of the nights property.
     * 
     */
    public void setNights(int value) {
        this.nights = value;
    }

    /**
     * Gets the value of the free property.
     * 
     */
    public int getFree() {
        return free;
    }

    /**
     * Sets the value of the free property.
     * 
     */
    public void setFree(int value) {
        this.free = value;
    }

    /**
     * Gets the value of the quote property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPFreeNightsOfferQuotation }
     *     
     */
    public JPSOAPFreeNightsOfferQuotation getQuote() {
        return quote;
    }

    /**
     * Sets the value of the quote property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPFreeNightsOfferQuotation }
     *     
     */
    public void setQuote(JPSOAPFreeNightsOfferQuotation value) {
        this.quote = value;
    }

    /**
     * Gets the value of the applyOnce property.
     * 
     */
    public boolean isApplyOnce() {
        return applyOnce;
    }

    /**
     * Sets the value of the applyOnce property.
     * 
     */
    public void setApplyOnce(boolean value) {
        this.applyOnce = value;
    }

}
