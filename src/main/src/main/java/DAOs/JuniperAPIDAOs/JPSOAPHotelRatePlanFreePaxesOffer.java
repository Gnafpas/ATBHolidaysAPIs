
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelRatePlanFreePaxesOffer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelRatePlanFreePaxesOffer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdultAdditionals" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_Order" minOccurs="0"/>
 *         &lt;element name="ChildrenA" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_Order1" minOccurs="0"/>
 *         &lt;element name="ChildrenB" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_Order1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelRatePlanFreePaxesOffer", propOrder = {
    "adultAdditionals",
    "childrenA",
    "childrenB"
})
public class JPSOAPHotelRatePlanFreePaxesOffer {

    @XmlElement(name = "AdultAdditionals")
    protected ArrayOfJPSOAPOrder adultAdditionals;
    @XmlElement(name = "ChildrenA")
    protected ArrayOfJPSOAPOrder1 childrenA;
    @XmlElement(name = "ChildrenB")
    protected ArrayOfJPSOAPOrder1 childrenB;

    /**
     * Gets the value of the adultAdditionals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPOrder }
     *     
     */
    public ArrayOfJPSOAPOrder getAdultAdditionals() {
        return adultAdditionals;
    }

    /**
     * Sets the value of the adultAdditionals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPOrder }
     *     
     */
    public void setAdultAdditionals(ArrayOfJPSOAPOrder value) {
        this.adultAdditionals = value;
    }

    /**
     * Gets the value of the childrenA property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPOrder1 }
     *     
     */
    public ArrayOfJPSOAPOrder1 getChildrenA() {
        return childrenA;
    }

    /**
     * Sets the value of the childrenA property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPOrder1 }
     *     
     */
    public void setChildrenA(ArrayOfJPSOAPOrder1 value) {
        this.childrenA = value;
    }

    /**
     * Gets the value of the childrenB property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPOrder1 }
     *     
     */
    public ArrayOfJPSOAPOrder1 getChildrenB() {
        return childrenB;
    }

    /**
     * Sets the value of the childrenB property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPOrder1 }
     *     
     */
    public void setChildrenB(ArrayOfJPSOAPOrder1 value) {
        this.childrenB = value;
    }

}
