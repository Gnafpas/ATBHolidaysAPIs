
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleVendorAvailabilityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleVendorAvailabilityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Vendor" type="{http://www.opentravel.org/OTA/2003/05}CompanyNameType" minOccurs="0"/>
 *         &lt;element name="VehAvails" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="VehAvail" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="VehAvailCore" type="{http://www.opentravel.org/OTA/2003/05}VehicleAvailCoreType" minOccurs="0"/>
 *                             &lt;element name="VehAvailInfo" type="{http://www.opentravel.org/OTA/2003/05}VehicleAvailAdditionalInfoType" minOccurs="0"/>
 *                             &lt;element name="AdvanceBooking" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="AbsoluteDeadline" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="OffsetTimeUnit" type="{http://www.opentravel.org/OTA/2003/05}TimeUnitType" />
 *                                     &lt;attribute name="OffsetUnitMultiplier" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                                     &lt;attribute name="OffsetDropTime">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;enumeration value="BeforeArrival"/>
 *                                           &lt;enumeration value="AfterBooking"/>
 *                                           &lt;enumeration value="AfterConfirmation"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="RulesApplyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="RateCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}VehicleAvailVendorInfoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleVendorAvailabilityType", propOrder = {
    "vendor",
    "vehAvails",
    "info"
})
public class VehicleVendorAvailabilityType {

    @XmlElement(name = "Vendor")
    protected CompanyNameType vendor;
    @XmlElement(name = "VehAvails")
    protected VehicleVendorAvailabilityType.VehAvails vehAvails;
    @XmlElement(name = "Info")
    protected VehicleAvailVendorInfoType info;

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
     * Gets the value of the vehAvails property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleVendorAvailabilityType.VehAvails }
     *     
     */
    public VehicleVendorAvailabilityType.VehAvails getVehAvails() {
        return vehAvails;
    }

    /**
     * Sets the value of the vehAvails property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleVendorAvailabilityType.VehAvails }
     *     
     */
    public void setVehAvails(VehicleVendorAvailabilityType.VehAvails value) {
        this.vehAvails = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleAvailVendorInfoType }
     *     
     */
    public VehicleAvailVendorInfoType getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleAvailVendorInfoType }
     *     
     */
    public void setInfo(VehicleAvailVendorInfoType value) {
        this.info = value;
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
     *         &lt;element name="VehAvail" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="VehAvailCore" type="{http://www.opentravel.org/OTA/2003/05}VehicleAvailCoreType" minOccurs="0"/>
     *                   &lt;element name="VehAvailInfo" type="{http://www.opentravel.org/OTA/2003/05}VehicleAvailAdditionalInfoType" minOccurs="0"/>
     *                   &lt;element name="AdvanceBooking" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="AbsoluteDeadline" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="OffsetTimeUnit" type="{http://www.opentravel.org/OTA/2003/05}TimeUnitType" />
     *                           &lt;attribute name="OffsetUnitMultiplier" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *                           &lt;attribute name="OffsetDropTime">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;enumeration value="BeforeArrival"/>
     *                                 &lt;enumeration value="AfterBooking"/>
     *                                 &lt;enumeration value="AfterConfirmation"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="RulesApplyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="RateCategory" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "vehAvail"
    })
    public static class VehAvails {

        @XmlElement(name = "VehAvail")
        protected List<VehicleVendorAvailabilityType.VehAvails.VehAvail> vehAvail;
        @XmlAttribute(name = "RateCategory")
        protected String rateCategory;

        /**
         * Gets the value of the vehAvail property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the vehAvail property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVehAvail().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VehicleVendorAvailabilityType.VehAvails.VehAvail }
         * 
         * 
         */
        public List<VehicleVendorAvailabilityType.VehAvails.VehAvail> getVehAvail() {
            if (vehAvail == null) {
                vehAvail = new ArrayList<VehicleVendorAvailabilityType.VehAvails.VehAvail>();
            }
            return this.vehAvail;
        }

        /**
         * Gets the value of the rateCategory property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRateCategory() {
            return rateCategory;
        }

        /**
         * Sets the value of the rateCategory property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRateCategory(String value) {
            this.rateCategory = value;
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
         *         &lt;element name="VehAvailCore" type="{http://www.opentravel.org/OTA/2003/05}VehicleAvailCoreType" minOccurs="0"/>
         *         &lt;element name="VehAvailInfo" type="{http://www.opentravel.org/OTA/2003/05}VehicleAvailAdditionalInfoType" minOccurs="0"/>
         *         &lt;element name="AdvanceBooking" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="AbsoluteDeadline" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="OffsetTimeUnit" type="{http://www.opentravel.org/OTA/2003/05}TimeUnitType" />
         *                 &lt;attribute name="OffsetUnitMultiplier" type="{http://www.w3.org/2001/XMLSchema}integer" />
         *                 &lt;attribute name="OffsetDropTime">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;enumeration value="BeforeArrival"/>
         *                       &lt;enumeration value="AfterBooking"/>
         *                       &lt;enumeration value="AfterConfirmation"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="RulesApplyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "vehAvailCore",
            "vehAvailInfo",
            "advanceBooking"
        })
        public static class VehAvail {

            @XmlElement(name = "VehAvailCore")
            protected VehicleAvailCoreType vehAvailCore;
            @XmlElement(name = "VehAvailInfo")
            protected VehicleAvailAdditionalInfoType vehAvailInfo;
            @XmlElement(name = "AdvanceBooking")
            protected VehicleVendorAvailabilityType.VehAvails.VehAvail.AdvanceBooking advanceBooking;

            /**
             * Gets the value of the vehAvailCore property.
             * 
             * @return
             *     possible object is
             *     {@link VehicleAvailCoreType }
             *     
             */
            public VehicleAvailCoreType getVehAvailCore() {
                return vehAvailCore;
            }

            /**
             * Sets the value of the vehAvailCore property.
             * 
             * @param value
             *     allowed object is
             *     {@link VehicleAvailCoreType }
             *     
             */
            public void setVehAvailCore(VehicleAvailCoreType value) {
                this.vehAvailCore = value;
            }

            /**
             * Gets the value of the vehAvailInfo property.
             * 
             * @return
             *     possible object is
             *     {@link VehicleAvailAdditionalInfoType }
             *     
             */
            public VehicleAvailAdditionalInfoType getVehAvailInfo() {
                return vehAvailInfo;
            }

            /**
             * Sets the value of the vehAvailInfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link VehicleAvailAdditionalInfoType }
             *     
             */
            public void setVehAvailInfo(VehicleAvailAdditionalInfoType value) {
                this.vehAvailInfo = value;
            }

            /**
             * Gets the value of the advanceBooking property.
             * 
             * @return
             *     possible object is
             *     {@link VehicleVendorAvailabilityType.VehAvails.VehAvail.AdvanceBooking }
             *     
             */
            public VehicleVendorAvailabilityType.VehAvails.VehAvail.AdvanceBooking getAdvanceBooking() {
                return advanceBooking;
            }

            /**
             * Sets the value of the advanceBooking property.
             * 
             * @param value
             *     allowed object is
             *     {@link VehicleVendorAvailabilityType.VehAvails.VehAvail.AdvanceBooking }
             *     
             */
            public void setAdvanceBooking(VehicleVendorAvailabilityType.VehAvails.VehAvail.AdvanceBooking value) {
                this.advanceBooking = value;
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
             *       &lt;attribute name="AbsoluteDeadline" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="OffsetTimeUnit" type="{http://www.opentravel.org/OTA/2003/05}TimeUnitType" />
             *       &lt;attribute name="OffsetUnitMultiplier" type="{http://www.w3.org/2001/XMLSchema}integer" />
             *       &lt;attribute name="OffsetDropTime">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;enumeration value="BeforeArrival"/>
             *             &lt;enumeration value="AfterBooking"/>
             *             &lt;enumeration value="AfterConfirmation"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="RulesApplyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class AdvanceBooking {

                @XmlAttribute(name = "AbsoluteDeadline")
                protected String absoluteDeadline;
                @XmlAttribute(name = "OffsetTimeUnit")
                protected TimeUnitType offsetTimeUnit;
                @XmlAttribute(name = "OffsetUnitMultiplier")
                protected BigInteger offsetUnitMultiplier;
                @XmlAttribute(name = "OffsetDropTime")
                protected String offsetDropTime;
                @XmlAttribute(name = "RulesApplyInd")
                protected Boolean rulesApplyInd;

                /**
                 * Gets the value of the absoluteDeadline property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAbsoluteDeadline() {
                    return absoluteDeadline;
                }

                /**
                 * Sets the value of the absoluteDeadline property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAbsoluteDeadline(String value) {
                    this.absoluteDeadline = value;
                }

                /**
                 * Gets the value of the offsetTimeUnit property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link TimeUnitType }
                 *     
                 */
                public TimeUnitType getOffsetTimeUnit() {
                    return offsetTimeUnit;
                }

                /**
                 * Sets the value of the offsetTimeUnit property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link TimeUnitType }
                 *     
                 */
                public void setOffsetTimeUnit(TimeUnitType value) {
                    this.offsetTimeUnit = value;
                }

                /**
                 * Gets the value of the offsetUnitMultiplier property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getOffsetUnitMultiplier() {
                    return offsetUnitMultiplier;
                }

                /**
                 * Sets the value of the offsetUnitMultiplier property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setOffsetUnitMultiplier(BigInteger value) {
                    this.offsetUnitMultiplier = value;
                }

                /**
                 * Gets the value of the offsetDropTime property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOffsetDropTime() {
                    return offsetDropTime;
                }

                /**
                 * Sets the value of the offsetDropTime property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOffsetDropTime(String value) {
                    this.offsetDropTime = value;
                }

                /**
                 * Gets the value of the rulesApplyInd property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Boolean }
                 *     
                 */
                public Boolean isRulesApplyInd() {
                    return rulesApplyInd;
                }

                /**
                 * Sets the value of the rulesApplyInd property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Boolean }
                 *     
                 */
                public void setRulesApplyInd(Boolean value) {
                    this.rulesApplyInd = value;
                }

            }

        }

    }

}
