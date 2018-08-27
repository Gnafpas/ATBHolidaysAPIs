
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarPriceInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarPriceInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="SaleContractName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CostContractName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_RentacarAdditionalElements" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarPriceInformation", propOrder = {
    "prices",
    "saleContractName",
    "costContractName",
    "additionalElements"
})
public class JPRentacarPriceInformation {

    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "SaleContractName")
    protected String saleContractName;
    @XmlElement(name = "CostContractName")
    protected String costContractName;
    @XmlElement(name = "AdditionalElements")
    protected JPRentacarAdditionalElements additionalElements;

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

}
