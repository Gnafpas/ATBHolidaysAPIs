
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_TransferResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_TransferResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransferInfo" type="{http://www.juniper.es/webservice/2007/}JP_TransferInfo" minOccurs="0"/>
 *         &lt;element name="TransferOptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_TransferOption" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="Origins" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Origin" minOccurs="0"/>
 *         &lt;element name="Destinations" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Destination" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Start" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="OriginZone" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="DestinationZone" type="{http://www.w3.org/2001/XMLSchema}int" />
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
@XmlType(name = "JP_TransferResult", propOrder = {
    "transferInfo",
    "transferOptions",
    "prices",
    "origins",
    "destinations"
})
public class JPTransferResult {

    @XmlElement(name = "TransferInfo")
    protected JPTransferInfo transferInfo;
    @XmlElement(name = "TransferOptions")
    protected ArrayOfJPTransferOption transferOptions;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "Origins")
    protected ArrayOfJPOrigin origins;
    @XmlElement(name = "Destinations")
    protected ArrayOfJPDestination destinations;
    @XmlAttribute(name = "Start", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;
    @XmlAttribute(name = "OriginZone")
    protected Integer originZone;
    @XmlAttribute(name = "DestinationZone")
    protected Integer destinationZone;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Status", required = true)
    protected JPAvailStatus status;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;

    /**
     * Gets the value of the transferInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferInfo }
     *     
     */
    public JPTransferInfo getTransferInfo() {
        return transferInfo;
    }

    /**
     * Sets the value of the transferInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferInfo }
     *     
     */
    public void setTransferInfo(JPTransferInfo value) {
        this.transferInfo = value;
    }

    /**
     * Gets the value of the transferOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPTransferOption }
     *     
     */
    public ArrayOfJPTransferOption getTransferOptions() {
        return transferOptions;
    }

    /**
     * Sets the value of the transferOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPTransferOption }
     *     
     */
    public void setTransferOptions(ArrayOfJPTransferOption value) {
        this.transferOptions = value;
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
     * Gets the value of the origins property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPOrigin }
     *     
     */
    public ArrayOfJPOrigin getOrigins() {
        return origins;
    }

    /**
     * Sets the value of the origins property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPOrigin }
     *     
     */
    public void setOrigins(ArrayOfJPOrigin value) {
        this.origins = value;
    }

    /**
     * Gets the value of the destinations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPDestination }
     *     
     */
    public ArrayOfJPDestination getDestinations() {
        return destinations;
    }

    /**
     * Sets the value of the destinations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPDestination }
     *     
     */
    public void setDestinations(ArrayOfJPDestination value) {
        this.destinations = value;
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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDestinationZone() {
        return destinationZone;
    }

    /**
     * Sets the value of the destinationZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDestinationZone(Integer value) {
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
