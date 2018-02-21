
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for VehicleCancelRQAdditionalInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleCancelRQAdditionalInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustLoyalty" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="ProgramID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="MembershipID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="TravelSector" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RPH" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="VendorCode">
 *                   &lt;simpleType>
 *                     &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Telephone" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Vendor" type="{http://www.opentravel.org/OTA/2003/05}CompanyNameType" minOccurs="0"/>
 *         &lt;element name="RentalInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PickUpLocation" type="{http://www.opentravel.org/OTA/2003/05}LocationType" minOccurs="0"/>
 *                   &lt;element name="ReturnLocation" type="{http://www.opentravel.org/OTA/2003/05}LocationType" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="PickUpDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                 &lt;attribute name="ReturnDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
@XmlType(name = "VehicleCancelRQAdditionalInfoType", propOrder = {
    "custLoyalty",
    "telephone",
    "vendor",
    "rentalInfo",
    "tpaExtensions"
})
public class VehicleCancelRQAdditionalInfoType {

    @XmlElement(name = "CustLoyalty")
    protected VehicleCancelRQAdditionalInfoType.CustLoyalty custLoyalty;
    @XmlElement(name = "Telephone")
    protected VehicleCancelRQAdditionalInfoType.Telephone telephone;
    @XmlElement(name = "Vendor")
    protected CompanyNameType vendor;
    @XmlElement(name = "RentalInfo")
    protected VehicleCancelRQAdditionalInfoType.RentalInfo rentalInfo;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;

    /**
     * Gets the value of the custLoyalty property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleCancelRQAdditionalInfoType.CustLoyalty }
     *     
     */
    public VehicleCancelRQAdditionalInfoType.CustLoyalty getCustLoyalty() {
        return custLoyalty;
    }

    /**
     * Sets the value of the custLoyalty property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleCancelRQAdditionalInfoType.CustLoyalty }
     *     
     */
    public void setCustLoyalty(VehicleCancelRQAdditionalInfoType.CustLoyalty value) {
        this.custLoyalty = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleCancelRQAdditionalInfoType.Telephone }
     *     
     */
    public VehicleCancelRQAdditionalInfoType.Telephone getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleCancelRQAdditionalInfoType.Telephone }
     *     
     */
    public void setTelephone(VehicleCancelRQAdditionalInfoType.Telephone value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the vendor property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyNameType }
     *     
     */
    public CompanyNameType getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyNameType }
     *     
     */
    public void setVendor(CompanyNameType value) {
        this.vendor = value;
    }

    /**
     * Gets the value of the rentalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleCancelRQAdditionalInfoType.RentalInfo }
     *     
     */
    public VehicleCancelRQAdditionalInfoType.RentalInfo getRentalInfo() {
        return rentalInfo;
    }

    /**
     * Sets the value of the rentalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleCancelRQAdditionalInfoType.RentalInfo }
     *     
     */
    public void setRentalInfo(VehicleCancelRQAdditionalInfoType.RentalInfo value) {
        this.rentalInfo = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="ProgramID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="MembershipID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="TravelSector" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RPH" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="VendorCode">
     *         &lt;simpleType>
     *           &lt;list itemType="{http://www.w3.org/2001/XMLSchema}string" />
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CustLoyalty {

        @XmlAttribute(name = "ProgramID")
        protected String programID;
        @XmlAttribute(name = "MembershipID")
        protected String membershipID;
        @XmlAttribute(name = "TravelSector")
        protected String travelSector;
        @XmlAttribute(name = "RPH")
        protected String rph;
        @XmlAttribute(name = "VendorCode")
        protected List<String> vendorCode;

        /**
         * Gets the value of the programID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProgramID() {
            return programID;
        }

        /**
         * Sets the value of the programID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProgramID(String value) {
            this.programID = value;
        }

        /**
         * Gets the value of the membershipID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMembershipID() {
            return membershipID;
        }

        /**
         * Sets the value of the membershipID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMembershipID(String value) {
            this.membershipID = value;
        }

        /**
         * Gets the value of the travelSector property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTravelSector() {
            return travelSector;
        }

        /**
         * Sets the value of the travelSector property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTravelSector(String value) {
            this.travelSector = value;
        }

        /**
         * Gets the value of the rph property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRPH() {
            return rph;
        }

        /**
         * Sets the value of the rph property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRPH(String value) {
            this.rph = value;
        }

        /**
         * Gets the value of the vendorCode property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the vendorCode property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVendorCode().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getVendorCode() {
            if (vendorCode == null) {
                vendorCode = new ArrayList<String>();
            }
            return this.vendorCode;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="PickUpLocation" type="{http://www.opentravel.org/OTA/2003/05}LocationType" minOccurs="0"/>
     *         &lt;element name="ReturnLocation" type="{http://www.opentravel.org/OTA/2003/05}LocationType" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="PickUpDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *       &lt;attribute name="ReturnDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "pickUpLocation",
        "returnLocation"
    })
    public static class RentalInfo {

        @XmlElement(name = "PickUpLocation")
        protected LocationType pickUpLocation;
        @XmlElement(name = "ReturnLocation")
        protected LocationType returnLocation;
        @XmlAttribute(name = "PickUpDateTime")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar pickUpDateTime;
        @XmlAttribute(name = "ReturnDateTime")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar returnDateTime;

        /**
         * Gets the value of the pickUpLocation property.
         * 
         * @return
         *     possible object is
         *     {@link LocationType }
         *     
         */
        public LocationType getPickUpLocation() {
            return pickUpLocation;
        }

        /**
         * Sets the value of the pickUpLocation property.
         * 
         * @param value
         *     allowed object is
         *     {@link LocationType }
         *     
         */
        public void setPickUpLocation(LocationType value) {
            this.pickUpLocation = value;
        }

        /**
         * Gets the value of the returnLocation property.
         * 
         * @return
         *     possible object is
         *     {@link LocationType }
         *     
         */
        public LocationType getReturnLocation() {
            return returnLocation;
        }

        /**
         * Sets the value of the returnLocation property.
         * 
         * @param value
         *     allowed object is
         *     {@link LocationType }
         *     
         */
        public void setReturnLocation(LocationType value) {
            this.returnLocation = value;
        }

        /**
         * Gets the value of the pickUpDateTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getPickUpDateTime() {
            return pickUpDateTime;
        }

        /**
         * Sets the value of the pickUpDateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setPickUpDateTime(XMLGregorianCalendar value) {
            this.pickUpDateTime = value;
        }

        /**
         * Gets the value of the returnDateTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getReturnDateTime() {
            return returnDateTime;
        }

        /**
         * Sets the value of the returnDateTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setReturnDateTime(XMLGregorianCalendar value) {
            this.returnDateTime = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Telephone {


    }

}
