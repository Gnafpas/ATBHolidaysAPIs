
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleAvailVendorInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleAvailVendorInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VendorMessages" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVendorMessageType" minOccurs="0"/>
 *         &lt;element name="OffLocServices" type="{http://www.opentravel.org/OTA/2003/05}OffLocationServiceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PaymentRules" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfMonetaryRuleType" minOccurs="0"/>
 *         &lt;element name="LocationDetails" type="{http://www.opentravel.org/OTA/2003/05}VehicleLocationDetailsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TourInfo" type="{http://www.opentravel.org/OTA/2003/05}VehicleTourInfoType" minOccurs="0"/>
 *         &lt;element name="TPA_Extensions" type="{http://www.opentravel.org/OTA/2003/05}TPA_ExtensionsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleAvailVendorInfoType", propOrder = {
    "vendorMessages",
    "offLocServices",
    "paymentRules",
    "locationDetails",
    "tourInfo",
    "tpaExtensions"
})
public class VehicleAvailVendorInfoType {

    @XmlElement(name = "VendorMessages")
    protected ArrayOfVendorMessageType vendorMessages;
    @XmlElement(name = "OffLocServices")
    protected List<OffLocationServiceType> offLocServices;
    @XmlElement(name = "PaymentRules")
    protected ArrayOfMonetaryRuleType paymentRules;
    @XmlElement(name = "LocationDetails")
    protected List<VehicleLocationDetailsType> locationDetails;
    @XmlElement(name = "TourInfo")
    protected VehicleTourInfoType tourInfo;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;

    /**
     * Gets the value of the vendorMessages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVendorMessageType }
     *     
     */
    public ArrayOfVendorMessageType getVendorMessages() {
        return vendorMessages;
    }

    /**
     * Sets the value of the vendorMessages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVendorMessageType }
     *     
     */
    public void setVendorMessages(ArrayOfVendorMessageType value) {
        this.vendorMessages = value;
    }

    /**
     * Gets the value of the offLocServices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offLocServices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffLocServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OffLocationServiceType }
     * 
     * 
     */
    public List<OffLocationServiceType> getOffLocServices() {
        if (offLocServices == null) {
            offLocServices = new ArrayList<OffLocationServiceType>();
        }
        return this.offLocServices;
    }

    /**
     * Gets the value of the paymentRules property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMonetaryRuleType }
     *     
     */
    public ArrayOfMonetaryRuleType getPaymentRules() {
        return paymentRules;
    }

    /**
     * Sets the value of the paymentRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMonetaryRuleType }
     *     
     */
    public void setPaymentRules(ArrayOfMonetaryRuleType value) {
        this.paymentRules = value;
    }

    /**
     * Gets the value of the locationDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locationDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocationDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleLocationDetailsType }
     * 
     * 
     */
    public List<VehicleLocationDetailsType> getLocationDetails() {
        if (locationDetails == null) {
            locationDetails = new ArrayList<VehicleLocationDetailsType>();
        }
        return this.locationDetails;
    }

    /**
     * Gets the value of the tourInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleTourInfoType }
     *     
     */
    public VehicleTourInfoType getTourInfo() {
        return tourInfo;
    }

    /**
     * Sets the value of the tourInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleTourInfoType }
     *     
     */
    public void setTourInfo(VehicleTourInfoType value) {
        this.tourInfo = value;
    }

    /**
     * Gets the value of the tpaExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link TPAExtensionsType }
     *     
     */
    public TPAExtensionsType getTPAExtensions() {
        return tpaExtensions;
    }

    /**
     * Sets the value of the tpaExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPAExtensionsType }
     *     
     */
    public void setTPAExtensions(TPAExtensionsType value) {
        this.tpaExtensions = value;
    }

}
