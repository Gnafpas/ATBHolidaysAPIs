
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelRatePlanRestriction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelRatePlanRestriction">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_BaseSupleOfferRest">
 *       &lt;sequence>
 *         &lt;element name="ApplicationRules" type="{http://www.juniper.es/webservice/2007/}JPSOAP_ApplicationRules" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}JPSOAP_RestrictionType" />
 *       &lt;attribute name="Packaged" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelRatePlanRestriction", propOrder = {
    "applicationRules"
})
public class JPSOAPHotelRatePlanRestriction
    extends JPSOAPBaseSupleOfferRest
{

    @XmlElement(name = "ApplicationRules")
    protected JPSOAPApplicationRules applicationRules;
    @XmlAttribute(name = "Type", required = true)
    protected JPSOAPRestrictionType type;
    @XmlAttribute(name = "Packaged", required = true)
    protected boolean packaged;

    /**
     * Gets the value of the applicationRules property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPApplicationRules }
     *     
     */
    public JPSOAPApplicationRules getApplicationRules() {
        return applicationRules;
    }

    /**
     * Sets the value of the applicationRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPApplicationRules }
     *     
     */
    public void setApplicationRules(JPSOAPApplicationRules value) {
        this.applicationRules = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPRestrictionType }
     *     
     */
    public JPSOAPRestrictionType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPRestrictionType }
     *     
     */
    public void setType(JPSOAPRestrictionType value) {
        this.type = value;
    }

    /**
     * Gets the value of the packaged property.
     * 
     */
    public boolean isPackaged() {
        return packaged;
    }

    /**
     * Sets the value of the packaged property.
     * 
     */
    public void setPackaged(boolean value) {
        this.packaged = value;
    }

}
