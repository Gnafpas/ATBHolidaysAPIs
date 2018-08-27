
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_RateDiscounts complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_RateDiscounts">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdultAdditionals" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_Discount" minOccurs="0"/>
 *         &lt;element name="ChildrenA" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_Discount1" minOccurs="0"/>
 *         &lt;element name="ChildrenB" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_Discount2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_RateDiscounts", propOrder = {
    "adultAdditionals",
    "childrenA",
    "childrenB"
})
public class JPSOAPRateDiscounts {

    @XmlElement(name = "AdultAdditionals")
    protected ArrayOfJPSOAPDiscount adultAdditionals;
    @XmlElement(name = "ChildrenA")
    protected ArrayOfJPSOAPDiscount1 childrenA;
    @XmlElement(name = "ChildrenB")
    protected ArrayOfJPSOAPDiscount2 childrenB;

    /**
     * Gets the value of the adultAdditionals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPDiscount }
     *     
     */
    public ArrayOfJPSOAPDiscount getAdultAdditionals() {
        return adultAdditionals;
    }

    /**
     * Sets the value of the adultAdditionals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPDiscount }
     *     
     */
    public void setAdultAdditionals(ArrayOfJPSOAPDiscount value) {
        this.adultAdditionals = value;
    }

    /**
     * Gets the value of the childrenA property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPDiscount1 }
     *     
     */
    public ArrayOfJPSOAPDiscount1 getChildrenA() {
        return childrenA;
    }

    /**
     * Sets the value of the childrenA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPDiscount1 }
     *     
     */
    public void setChildrenA(ArrayOfJPSOAPDiscount1 value) {
        this.childrenA = value;
    }

    /**
     * Gets the value of the childrenB property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPDiscount2 }
     *     
     */
    public ArrayOfJPSOAPDiscount2 getChildrenB() {
        return childrenB;
    }

    /**
     * Sets the value of the childrenB property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPDiscount2 }
     *     
     */
    public void setChildrenB(ArrayOfJPSOAPDiscount2 value) {
        this.childrenB = value;
    }

}
