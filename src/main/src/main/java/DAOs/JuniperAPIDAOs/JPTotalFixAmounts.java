
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_TotalFixAmounts complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_TotalFixAmounts">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Service" type="{http://www.juniper.es/webservice/2007/}JP_Service" minOccurs="0"/>
 *         &lt;element name="ServiceTaxes" type="{http://www.juniper.es/webservice/2007/}JP_ServiceTaxes" minOccurs="0"/>
 *         &lt;element name="Commissions" type="{http://www.juniper.es/webservice/2007/}JP_Commissions" minOccurs="0"/>
 *         &lt;element name="HandlingFees" type="{http://www.juniper.es/webservice/2007/}JP_HandlingFees" minOccurs="0"/>
 *         &lt;element name="Discount" type="{http://www.juniper.es/webservice/2007/}JP_Discount" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Recommended" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Gross" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="Nett" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_TotalFixAmounts", propOrder = {
    "service",
    "serviceTaxes",
    "commissions",
    "handlingFees",
    "discount"
})
public class JPTotalFixAmounts {

    @XmlElement(name = "Service")
    protected JPService service;
    @XmlElement(name = "ServiceTaxes")
    protected JPServiceTaxes serviceTaxes;
    @XmlElement(name = "Commissions")
    protected JPCommissions commissions;
    @XmlElement(name = "HandlingFees")
    protected JPHandlingFees handlingFees;
    @XmlElement(name = "Discount")
    protected JPDiscount discount;
    @XmlAttribute(name = "Recommended")
    protected Double recommended;
    @XmlAttribute(name = "Gross")
    protected Double gross;
    @XmlAttribute(name = "Nett")
    protected Double nett;

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link JPService }
     *     
     */
    public JPService getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPService }
     *     
     */
    public void setService(JPService value) {
        this.service = value;
    }

    /**
     * Gets the value of the serviceTaxes property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceTaxes }
     *     
     */
    public JPServiceTaxes getServiceTaxes() {
        return serviceTaxes;
    }

    /**
     * Sets the value of the serviceTaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceTaxes }
     *     
     */
    public void setServiceTaxes(JPServiceTaxes value) {
        this.serviceTaxes = value;
    }

    /**
     * Gets the value of the commissions property.
     * 
     * @return
     *     possible object is
     *     {@link JPCommissions }
     *     
     */
    public JPCommissions getCommissions() {
        return commissions;
    }

    /**
     * Sets the value of the commissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCommissions }
     *     
     */
    public void setCommissions(JPCommissions value) {
        this.commissions = value;
    }

    /**
     * Gets the value of the handlingFees property.
     * 
     * @return
     *     possible object is
     *     {@link JPHandlingFees }
     *     
     */
    public JPHandlingFees getHandlingFees() {
        return handlingFees;
    }

    /**
     * Sets the value of the handlingFees property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHandlingFees }
     *     
     */
    public void setHandlingFees(JPHandlingFees value) {
        this.handlingFees = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     * @return
     *     possible object is
     *     {@link JPDiscount }
     *     
     */
    public JPDiscount getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPDiscount }
     *     
     */
    public void setDiscount(JPDiscount value) {
        this.discount = value;
    }

    /**
     * Gets the value of the recommended property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRecommended() {
        return recommended;
    }

    /**
     * Sets the value of the recommended property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRecommended(Double value) {
        this.recommended = value;
    }

    /**
     * Gets the value of the gross property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGross() {
        return gross;
    }

    /**
     * Sets the value of the gross property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGross(Double value) {
        this.gross = value;
    }

    /**
     * Gets the value of the nett property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNett() {
        return nett;
    }

    /**
     * Sets the value of the nett property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNett(Double value) {
        this.nett = value;
    }

}
