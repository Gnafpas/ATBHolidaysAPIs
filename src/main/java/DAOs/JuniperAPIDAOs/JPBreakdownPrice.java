
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_BreakdownPrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_BreakdownPrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Concepts" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ConceptBreakdown" minOccurs="0"/>
 *         &lt;element name="Taxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CommonPriceBreakdown" minOccurs="0"/>
 *         &lt;element name="Commissions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CommonPriceBreakdown1" minOccurs="0"/>
 *         &lt;element name="Discounts" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CommonPriceBreakdown2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_BreakdownPrice", propOrder = {
    "concepts",
    "taxes",
    "commissions",
    "discounts"
})
public class JPBreakdownPrice {

    @XmlElement(name = "Concepts")
    protected ArrayOfJPConceptBreakdown concepts;
    @XmlElement(name = "Taxes")
    protected ArrayOfJPCommonPriceBreakdown taxes;
    @XmlElement(name = "Commissions")
    protected ArrayOfJPCommonPriceBreakdown1 commissions;
    @XmlElement(name = "Discounts")
    protected ArrayOfJPCommonPriceBreakdown2 discounts;

    /**
     * Gets the value of the concepts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPConceptBreakdown }
     *     
     */
    public ArrayOfJPConceptBreakdown getConcepts() {
        return concepts;
    }

    /**
     * Sets the value of the concepts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPConceptBreakdown }
     *     
     */
    public void setConcepts(ArrayOfJPConceptBreakdown value) {
        this.concepts = value;
    }

    /**
     * Gets the value of the taxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCommonPriceBreakdown }
     *     
     */
    public ArrayOfJPCommonPriceBreakdown getTaxes() {
        return taxes;
    }

    /**
     * Sets the value of the taxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCommonPriceBreakdown }
     *     
     */
    public void setTaxes(ArrayOfJPCommonPriceBreakdown value) {
        this.taxes = value;
    }

    /**
     * Gets the value of the commissions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCommonPriceBreakdown1 }
     *     
     */
    public ArrayOfJPCommonPriceBreakdown1 getCommissions() {
        return commissions;
    }

    /**
     * Sets the value of the commissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCommonPriceBreakdown1 }
     *     
     */
    public void setCommissions(ArrayOfJPCommonPriceBreakdown1 value) {
        this.commissions = value;
    }

    /**
     * Gets the value of the discounts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCommonPriceBreakdown2 }
     *     
     */
    public ArrayOfJPCommonPriceBreakdown2 getDiscounts() {
        return discounts;
    }

    /**
     * Sets the value of the discounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCommonPriceBreakdown2 }
     *     
     */
    public void setDiscounts(ArrayOfJPCommonPriceBreakdown2 value) {
        this.discounts = value;
    }

}
