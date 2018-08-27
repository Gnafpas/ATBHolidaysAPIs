
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarCheckAvailOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarCheckAvailOption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentacarInfo" type="{http://www.juniper.es/webservice/2007/}JP_RentacarInfo" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="SaleContractName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CostContractName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_RentacarAdditionalElements" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PickUpCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DropOffCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AcrissCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RatePlanCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Status" type="{http://www.juniper.es/webservice/2007/}JP_AvailStatus" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarCheckAvailOption", propOrder = {
    "rentacarInfo",
    "prices",
    "saleContractName",
    "costContractName",
    "additionalElements"
})
public class JPRentacarCheckAvailOption {

    @XmlElement(name = "RentacarInfo")
    protected JPRentacarInfo rentacarInfo;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "SaleContractName")
    protected String saleContractName;
    @XmlElement(name = "CostContractName")
    protected String costContractName;
    @XmlElement(name = "AdditionalElements")
    protected JPRentacarAdditionalElements additionalElements;
    @XmlAttribute(name = "PickUpCode")
    protected String pickUpCode;
    @XmlAttribute(name = "DropOffCode")
    protected String dropOffCode;
    @XmlAttribute(name = "AcrissCode")
    protected String acrissCode;
    @XmlAttribute(name = "RatePlanCode")
    protected String ratePlanCode;
    @XmlAttribute(name = "Status")
    protected JPAvailStatus status;

    /**
     * Gets the value of the rentacarInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarInfo }
     *     
     */
    public JPRentacarInfo getRentacarInfo() {
        return rentacarInfo;
    }

    /**
     * Sets the value of the rentacarInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarInfo }
     *     
     */
    public void setRentacarInfo(JPRentacarInfo value) {
        this.rentacarInfo = value;
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
     * Gets the value of the saleContractName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaleContractName() {
        return saleContractName;
    }

    /**
     * Sets the value of the saleContractName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaleContractName(String value) {
        this.saleContractName = value;
    }

    /**
     * Gets the value of the costContractName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostContractName() {
        return costContractName;
    }

    /**
     * Sets the value of the costContractName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostContractName(String value) {
        this.costContractName = value;
    }

    /**
     * Gets the value of the additionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarAdditionalElements }
     *     
     */
    public JPRentacarAdditionalElements getAdditionalElements() {
        return additionalElements;
    }

    /**
     * Sets the value of the additionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarAdditionalElements }
     *     
     */
    public void setAdditionalElements(JPRentacarAdditionalElements value) {
        this.additionalElements = value;
    }

    /**
     * Gets the value of the pickUpCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPickUpCode() {
        return pickUpCode;
    }

    /**
     * Sets the value of the pickUpCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPickUpCode(String value) {
        this.pickUpCode = value;
    }

    /**
     * Gets the value of the dropOffCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDropOffCode() {
        return dropOffCode;
    }

    /**
     * Sets the value of the dropOffCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDropOffCode(String value) {
        this.dropOffCode = value;
    }

    /**
     * Gets the value of the acrissCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcrissCode() {
        return acrissCode;
    }

    /**
     * Sets the value of the acrissCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcrissCode(String value) {
        this.acrissCode = value;
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

}
