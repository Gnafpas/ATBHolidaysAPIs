
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelInfoRSType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelInfoRSType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CancelRules" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfCancelRuleType" minOccurs="0"/>
 *         &lt;element name="UniqueID" type="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelInfoRSType", propOrder = {
    "cancelRules",
    "uniqueID"
})
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehCancelResRS.VehCancelRSCore.class
})
public class CancelInfoRSType {

    @XmlElement(name = "CancelRules")
    protected ArrayOfCancelRuleType cancelRules;
    @XmlElement(name = "UniqueID")
    protected UniqueIDType uniqueID;

    /**
     * Gets the value of the cancelRules property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCancelRuleType }
     *     
     */
    public ArrayOfCancelRuleType getCancelRules() {
        return cancelRules;
    }

    /**
     * Sets the value of the cancelRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCancelRuleType }
     *     
     */
    public void setCancelRules(ArrayOfCancelRuleType value) {
        this.cancelRules = value;
    }

    /**
     * Gets the value of the uniqueID property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueIDType }
     *     
     */
    public UniqueIDType getUniqueID() {
        return uniqueID;
    }

    /**
     * Sets the value of the uniqueID property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueIDType }
     *     
     */
    public void setUniqueID(UniqueIDType value) {
        this.uniqueID = value;
    }

}
