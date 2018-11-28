
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JPSOAP_HotelRatePlanContract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelRatePlanContract">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_Contract">
 *       &lt;sequence>
 *         &lt;element name="Ages" type="{http://www.juniper.es/webservice/2007/}JPSOAP_Ages" minOccurs="0"/>
 *         &lt;element name="ContractRestrictions" type="{http://www.juniper.es/webservice/2007/}JPSOAP_ContractRestrictions" minOccurs="0"/>
 *         &lt;element name="Rates" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_hotelRatePlanRate" minOccurs="0"/>
 *         &lt;element name="Taxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_hotelRatePlanTax" minOccurs="0"/>
 *         &lt;element name="CancellationPolicies" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_hotelRatePlanCancellationPolicy" minOccurs="0"/>
 *         &lt;element name="Supplements" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_HotelRatePlanSupplement" minOccurs="0"/>
 *         &lt;element name="Offers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_HotelRatePlanOffer" minOccurs="0"/>
 *         &lt;element name="Restrictions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_HotelRatePlanRestriction" minOccurs="0"/>
 *         &lt;element name="SpecialNotes" type="{http://www.juniper.es/webservice/2007/}ArrayOfArrayOfJPSOAP_HotelRatePlanSpecialNoteText" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ContractType" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_ContractType" />
 *       &lt;attribute name="Comissionable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ComissionPercent" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="ComissionTaxPercent" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RecommendedPrices" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="BookingFrom" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="BookingTo" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="DirectPayment" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ExtranetContract" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelRatePlanContract", propOrder = {
    "ages",
    "contractRestrictions",
    "rates",
    "taxes",
    "cancellationPolicies",
    "supplements",
    "offers",
    "restrictions",
    "specialNotes"
})
public class JPSOAPHotelRatePlanContract
    extends JPSOAPContract
{

    @XmlElement(name = "Ages")
    protected JPSOAPAges ages;
    @XmlElement(name = "ContractRestrictions")
    protected JPSOAPContractRestrictions contractRestrictions;
    @XmlElement(name = "Rates")
    protected ArrayOfJPSOAPHotelRatePlanRate rates;
    @XmlElement(name = "Taxes")
    protected ArrayOfJPSOAPHotelRatePlanTax taxes;
    @XmlElement(name = "CancellationPolicies")
    protected ArrayOfJPSOAPHotelRatePlanCancellationPolicy cancellationPolicies;
    @XmlElement(name = "Supplements")
    protected ArrayOfJPSOAPHotelRatePlanSupplement supplements;
    @XmlElement(name = "Offers")
    protected ArrayOfJPSOAPHotelRatePlanOffer offers;
    @XmlElement(name = "Restrictions")
    protected ArrayOfJPSOAPHotelRatePlanRestriction restrictions;
    @XmlElement(name = "SpecialNotes")
    protected ArrayOfArrayOfJPSOAPHotelRatePlanSpecialNoteText specialNotes;
    @XmlAttribute(name = "ContractType", required = true)
    protected JPSOAPContractType contractType;
    @XmlAttribute(name = "Comissionable", required = true)
    protected boolean comissionable;
    @XmlAttribute(name = "ComissionPercent")
    protected Double comissionPercent;
    @XmlAttribute(name = "ComissionTaxPercent")
    protected Double comissionTaxPercent;
    @XmlAttribute(name = "Currency")
    protected String currency;
    @XmlAttribute(name = "RecommendedPrices", required = true)
    protected boolean recommendedPrices;
    @XmlAttribute(name = "BookingFrom", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bookingFrom;
    @XmlAttribute(name = "BookingTo", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bookingTo;
    @XmlAttribute(name = "DirectPayment", required = true)
    protected boolean directPayment;
    @XmlAttribute(name = "ExtranetContract")
    protected Boolean extranetContract;

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
     * Gets the value of the contractRestrictions property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPContractRestrictions }
     *     
     */
    public JPSOAPContractRestrictions getContractRestrictions() {
        return contractRestrictions;
    }

    /**
     * Sets the value of the contractRestrictions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPContractRestrictions }
     *     
     */
    public void setContractRestrictions(JPSOAPContractRestrictions value) {
        this.contractRestrictions = value;
    }

    /**
     * Gets the value of the rates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelRatePlanRate }
     *     
     */
    public ArrayOfJPSOAPHotelRatePlanRate getRates() {
        return rates;
    }

    /**
     * Sets the value of the rates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelRatePlanRate }
     *     
     */
    public void setRates(ArrayOfJPSOAPHotelRatePlanRate value) {
        this.rates = value;
    }

    /**
     * Gets the value of the taxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelRatePlanTax }
     *     
     */
    public ArrayOfJPSOAPHotelRatePlanTax getTaxes() {
        return taxes;
    }

    /**
     * Sets the value of the taxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelRatePlanTax }
     *     
     */
    public void setTaxes(ArrayOfJPSOAPHotelRatePlanTax value) {
        this.taxes = value;
    }

    /**
     * Gets the value of the cancellationPolicies property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelRatePlanCancellationPolicy }
     *     
     */
    public ArrayOfJPSOAPHotelRatePlanCancellationPolicy getCancellationPolicies() {
        return cancellationPolicies;
    }

    /**
     * Sets the value of the cancellationPolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelRatePlanCancellationPolicy }
     *     
     */
    public void setCancellationPolicies(ArrayOfJPSOAPHotelRatePlanCancellationPolicy value) {
        this.cancellationPolicies = value;
    }

    /**
     * Gets the value of the supplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelRatePlanSupplement }
     *     
     */
    public ArrayOfJPSOAPHotelRatePlanSupplement getSupplements() {
        return supplements;
    }

    /**
     * Sets the value of the supplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelRatePlanSupplement }
     *     
     */
    public void setSupplements(ArrayOfJPSOAPHotelRatePlanSupplement value) {
        this.supplements = value;
    }

    /**
     * Gets the value of the offers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelRatePlanOffer }
     *     
     */
    public ArrayOfJPSOAPHotelRatePlanOffer getOffers() {
        return offers;
    }

    /**
     * Sets the value of the offers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelRatePlanOffer }
     *     
     */
    public void setOffers(ArrayOfJPSOAPHotelRatePlanOffer value) {
        this.offers = value;
    }

    /**
     * Gets the value of the restrictions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelRatePlanRestriction }
     *     
     */
    public ArrayOfJPSOAPHotelRatePlanRestriction getRestrictions() {
        return restrictions;
    }

    /**
     * Sets the value of the restrictions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelRatePlanRestriction }
     *     
     */
    public void setRestrictions(ArrayOfJPSOAPHotelRatePlanRestriction value) {
        this.restrictions = value;
    }

    /**
     * Gets the value of the specialNotes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArrayOfJPSOAPHotelRatePlanSpecialNoteText }
     *     
     */
    public ArrayOfArrayOfJPSOAPHotelRatePlanSpecialNoteText getSpecialNotes() {
        return specialNotes;
    }

    /**
     * Sets the value of the specialNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArrayOfJPSOAPHotelRatePlanSpecialNoteText }
     *     
     */
    public void setSpecialNotes(ArrayOfArrayOfJPSOAPHotelRatePlanSpecialNoteText value) {
        this.specialNotes = value;
    }

    /**
     * Gets the value of the contractType property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPContractType }
     *     
     */
    public JPSOAPContractType getContractType() {
        return contractType;
    }

    /**
     * Sets the value of the contractType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPContractType }
     *     
     */
    public void setContractType(JPSOAPContractType value) {
        this.contractType = value;
    }

    /**
     * Gets the value of the comissionable property.
     * 
     */
    public boolean isComissionable() {
        return comissionable;
    }

    /**
     * Sets the value of the comissionable property.
     * 
     */
    public void setComissionable(boolean value) {
        this.comissionable = value;
    }

    /**
     * Gets the value of the comissionPercent property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getComissionPercent() {
        return comissionPercent;
    }

    /**
     * Sets the value of the comissionPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setComissionPercent(Double value) {
        this.comissionPercent = value;
    }

    /**
     * Gets the value of the comissionTaxPercent property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getComissionTaxPercent() {
        return comissionTaxPercent;
    }

    /**
     * Sets the value of the comissionTaxPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setComissionTaxPercent(Double value) {
        this.comissionTaxPercent = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the recommendedPrices property.
     * 
     */
    public boolean isRecommendedPrices() {
        return recommendedPrices;
    }

    /**
     * Sets the value of the recommendedPrices property.
     * 
     */
    public void setRecommendedPrices(boolean value) {
        this.recommendedPrices = value;
    }

    /**
     * Gets the value of the bookingFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBookingFrom() {
        return bookingFrom;
    }

    /**
     * Sets the value of the bookingFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBookingFrom(XMLGregorianCalendar value) {
        this.bookingFrom = value;
    }

    /**
     * Gets the value of the bookingTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBookingTo() {
        return bookingTo;
    }

    /**
     * Sets the value of the bookingTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBookingTo(XMLGregorianCalendar value) {
        this.bookingTo = value;
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
     * Gets the value of the extranetContract property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExtranetContract() {
        return extranetContract;
    }

    /**
     * Sets the value of the extranetContract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExtranetContract(Boolean value) {
        this.extranetContract = value;
    }

}
