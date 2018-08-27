
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_OptionalFaresDescriptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_OptionalFaresDescriptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FareGroupTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_FareGroupType" minOccurs="0"/>
 *         &lt;element name="FareGroupPriceApplications" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_FareGroupPriceApplication" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_OptionalFaresDescriptions", propOrder = {
    "fareGroupTypes",
    "fareGroupPriceApplications"
})
public class JPOptionalFaresDescriptions {

    @XmlElement(name = "FareGroupTypes")
    protected ArrayOfJPFareGroupType fareGroupTypes;
    @XmlElement(name = "FareGroupPriceApplications")
    protected ArrayOfJPFareGroupPriceApplication fareGroupPriceApplications;

    /**
     * Gets the value of the fareGroupTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFareGroupType }
     *     
     */
    public ArrayOfJPFareGroupType getFareGroupTypes() {
        return fareGroupTypes;
    }

    /**
     * Sets the value of the fareGroupTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFareGroupType }
     *     
     */
    public void setFareGroupTypes(ArrayOfJPFareGroupType value) {
        this.fareGroupTypes = value;
    }

    /**
     * Gets the value of the fareGroupPriceApplications property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPFareGroupPriceApplication }
     *     
     */
    public ArrayOfJPFareGroupPriceApplication getFareGroupPriceApplications() {
        return fareGroupPriceApplications;
    }

    /**
     * Sets the value of the fareGroupPriceApplications property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPFareGroupPriceApplication }
     *     
     */
    public void setFareGroupPriceApplications(ArrayOfJPFareGroupPriceApplication value) {
        this.fareGroupPriceApplications = value;
    }

}
