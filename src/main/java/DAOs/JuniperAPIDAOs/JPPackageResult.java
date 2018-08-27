
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_PackageResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageInfo" type="{http://www.juniper.es/webservice/2007/}JP_PackageInfo" minOccurs="0"/>
 *         &lt;element name="AFIPInformation" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageInfoAFIPAmount" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="Stays" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageStay" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_PackageAdditionalElements" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Recommended" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="BestDeal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="LastMinute" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Start" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="OriginZone" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="DestinationZone" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" use="required" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageResult", propOrder = {
    "packageInfo",
    "afipInformation",
    "prices",
    "stays",
    "additionalElements"
})
public class JPPackageResult {

    @XmlElement(name = "PackageInfo")
    protected JPPackageInfo packageInfo;
    @XmlElement(name = "AFIPInformation")
    protected ArrayOfJPPackageInfoAFIPAmount afipInformation;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "Stays")
    protected ArrayOfJPPackageStay stays;
    @XmlElement(name = "AdditionalElements")
    protected JPPackageAdditionalElements additionalElements;
    @XmlAttribute(name = "Recommended")
    protected Boolean recommended;
    @XmlAttribute(name = "BestDeal")
    protected Boolean bestDeal;
    @XmlAttribute(name = "LastMinute")
    protected Boolean lastMinute;
    @XmlAttribute(name = "Start", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;
    @XmlAttribute(name = "OriginZone")
    protected Integer originZone;
    @XmlAttribute(name = "DestinationZone", required = true)
    protected int destinationZone;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Status", required = true)
    protected JPAvailStatus status;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;

    /**
     * Gets the value of the packageInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageInfo }
     *     
     */
    public JPPackageInfo getPackageInfo() {
        return packageInfo;
    }

    /**
     * Sets the value of the packageInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageInfo }
     *     
     */
    public void setPackageInfo(JPPackageInfo value) {
        this.packageInfo = value;
    }

    /**
     * Gets the value of the afipInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageInfoAFIPAmount }
     *     
     */
    public ArrayOfJPPackageInfoAFIPAmount getAFIPInformation() {
        return afipInformation;
    }

    /**
     * Sets the value of the afipInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageInfoAFIPAmount }
     *     
     */
    public void setAFIPInformation(ArrayOfJPPackageInfoAFIPAmount value) {
        this.afipInformation = value;
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
     * Gets the value of the stays property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageStay }
     *     
     */
    public ArrayOfJPPackageStay getStays() {
        return stays;
    }

    /**
     * Sets the value of the stays property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageStay }
     *     
     */
    public void setStays(ArrayOfJPPackageStay value) {
        this.stays = value;
    }

    /**
     * Gets the value of the additionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageAdditionalElements }
     *     
     */
    public JPPackageAdditionalElements getAdditionalElements() {
        return additionalElements;
    }

    /**
     * Sets the value of the additionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageAdditionalElements }
     *     
     */
    public void setAdditionalElements(JPPackageAdditionalElements value) {
        this.additionalElements = value;
    }

    /**
     * Gets the value of the recommended property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecommended() {
        return recommended;
    }

    /**
     * Sets the value of the recommended property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecommended(Boolean value) {
        this.recommended = value;
    }

    /**
     * Gets the value of the bestDeal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBestDeal() {
        return bestDeal;
    }

    /**
     * Sets the value of the bestDeal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBestDeal(Boolean value) {
        this.bestDeal = value;
    }

    /**
     * Gets the value of the lastMinute property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLastMinute() {
        return lastMinute;
    }

    /**
     * Sets the value of the lastMinute property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLastMinute(Boolean value) {
        this.lastMinute = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStart(XMLGregorianCalendar value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnd(XMLGregorianCalendar value) {
        this.end = value;
    }

    /**
     * Gets the value of the originZone property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOriginZone() {
        return originZone;
    }

    /**
     * Sets the value of the originZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOriginZone(Integer value) {
        this.originZone = value;
    }

    /**
     * Gets the value of the destinationZone property.
     * 
     */
    public int getDestinationZone() {
        return destinationZone;
    }

    /**
     * Sets the value of the destinationZone property.
     * 
     */
    public void setDestinationZone(int value) {
        this.destinationZone = value;
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
