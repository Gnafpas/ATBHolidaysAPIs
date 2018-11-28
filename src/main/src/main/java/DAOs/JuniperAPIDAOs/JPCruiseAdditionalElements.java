
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseAdditionalElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseAdditionalElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fees" type="{http://www.juniper.es/webservice/2007/}ArrayOfString2" minOccurs="0"/>
 *         &lt;element name="Components" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseComponent" minOccurs="0"/>
 *         &lt;element name="Promotions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruisePromotion" minOccurs="0"/>
 *         &lt;element name="CruiseSupplements" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseSupplement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseAdditionalElements", propOrder = {
    "fees",
    "components",
    "promotions",
    "cruiseSupplements"
})
public class JPCruiseAdditionalElements {

    @XmlElement(name = "Fees")
    protected ArrayOfString2 fees;
    @XmlElement(name = "Components")
    protected ArrayOfJPCruiseComponent components;
    @XmlElement(name = "Promotions")
    protected ArrayOfJPCruisePromotion promotions;
    @XmlElement(name = "CruiseSupplements")
    protected ArrayOfJPCruiseSupplement cruiseSupplements;

    /**
     * Gets the value of the fees property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString2 }
     *     
     */
    public ArrayOfString2 getFees() {
        return fees;
    }

    /**
     * Sets the value of the fees property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString2 }
     *     
     */
    public void setFees(ArrayOfString2 value) {
        this.fees = value;
    }

    /**
     * Gets the value of the components property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseComponent }
     *     
     */
    public ArrayOfJPCruiseComponent getComponents() {
        return components;
    }

    /**
     * Sets the value of the components property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseComponent }
     *     
     */
    public void setComponents(ArrayOfJPCruiseComponent value) {
        this.components = value;
    }

    /**
     * Gets the value of the promotions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruisePromotion }
     *     
     */
    public ArrayOfJPCruisePromotion getPromotions() {
        return promotions;
    }

    /**
     * Sets the value of the promotions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruisePromotion }
     *     
     */
    public void setPromotions(ArrayOfJPCruisePromotion value) {
        this.promotions = value;
    }

    /**
     * Gets the value of the cruiseSupplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseSupplement }
     *     
     */
    public ArrayOfJPCruiseSupplement getCruiseSupplements() {
        return cruiseSupplements;
    }

    /**
     * Sets the value of the cruiseSupplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseSupplement }
     *     
     */
    public void setCruiseSupplements(ArrayOfJPCruiseSupplement value) {
        this.cruiseSupplements = value;
    }

}
