
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_StayRestrictions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_StayRestrictions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LengthOfStay" type="{http://www.juniper.es/webservice/2007/}JPSOAP_LengthOfStay" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Application" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_StayRestrictionsApplication" />
 *       &lt;attribute name="MinNights" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxNights" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ApplyToLengthStayOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_StayRestrictions", propOrder = {
    "lengthOfStay"
})
public class JPSOAPStayRestrictions {

    @XmlElement(name = "LengthOfStay")
    protected List<JPSOAPLengthOfStay> lengthOfStay;
    @XmlAttribute(name = "Application", required = true)
    protected JPSOAPStayRestrictionsApplication application;
    @XmlAttribute(name = "MinNights")
    protected Integer minNights;
    @XmlAttribute(name = "MaxNights")
    protected Integer maxNights;
    @XmlAttribute(name = "ApplyToLengthStayOnly")
    protected Boolean applyToLengthStayOnly;

    /**
     * Gets the value of the lengthOfStay property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lengthOfStay property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLengthOfStay().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPLengthOfStay }
     * 
     * 
     */
    public List<JPSOAPLengthOfStay> getLengthOfStay() {
        if (lengthOfStay == null) {
            lengthOfStay = new ArrayList<JPSOAPLengthOfStay>();
        }
        return this.lengthOfStay;
    }

    /**
     * Gets the value of the application property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPStayRestrictionsApplication }
     *     
     */
    public JPSOAPStayRestrictionsApplication getApplication() {
        return application;
    }

    /**
     * Sets the value of the application property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPStayRestrictionsApplication }
     *     
     */
    public void setApplication(JPSOAPStayRestrictionsApplication value) {
        this.application = value;
    }

    /**
     * Gets the value of the minNights property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinNights() {
        return minNights;
    }

    /**
     * Sets the value of the minNights property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinNights(Integer value) {
        this.minNights = value;
    }

    /**
     * Gets the value of the maxNights property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxNights() {
        return maxNights;
    }

    /**
     * Sets the value of the maxNights property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxNights(Integer value) {
        this.maxNights = value;
    }

    /**
     * Gets the value of the applyToLengthStayOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isApplyToLengthStayOnly() {
        return applyToLengthStayOnly;
    }

    /**
     * Sets the value of the applyToLengthStayOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setApplyToLengthStayOnly(Boolean value) {
        this.applyToLengthStayOnly = value;
    }

}
