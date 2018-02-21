
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleRentalRateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleRentalRateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RateDistance" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Unlimited" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *                 &lt;attribute name="DistUnitName" type="{http://www.opentravel.org/OTA/2003/05}DistanceUnitNameType" />
 *                 &lt;attribute name="VehiclePeriodUnitName" type="{http://www.opentravel.org/OTA/2003/05}VehiclePeriodUnitNameType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="VehicleCharges" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleChargePurposeType" minOccurs="0"/>
 *         &lt;element name="RateQualifier" type="{http://www.opentravel.org/OTA/2003/05}RateQualifierType" minOccurs="0"/>
 *         &lt;element name="RateRestrictions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MinimumAge" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="MaximumAge" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="NoShowFeeInd" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="ArriveByFlight" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                 &lt;attribute name="MinimumDayInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="MaximumDayInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="AdvancedBookingInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="RestrictedMileageInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="CorporateRateInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="GuaranteeReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="MaximumVehiclesAllowed" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="OvernightInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="OneWayPolicy">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="OneWayAllowed"/>
 *                       &lt;enumeration value="OneWayNotAllowed"/>
 *                       &lt;enumeration value="RestrictedOneWay"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="CancellationPenaltyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="ModificationPenaltyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RateGuarantee" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Description" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextTextType" minOccurs="0"/>
 *                 &lt;/sequence>
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
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PickupReturnRule" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="DayOfWeek" type="{http://www.opentravel.org/OTA/2003/05}DayOfWeekType" />
 *                 &lt;attribute name="Time" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RuleType">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="EarliestPickup"/>
 *                       &lt;enumeration value="LatestPickup"/>
 *                       &lt;enumeration value="LatestReturn"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
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
@XmlType(name = "VehicleRentalRateType", propOrder = {
    "rateDistance",
    "vehicleCharges",
    "rateQualifier",
    "rateRestrictions",
    "rateGuarantee",
    "pickupReturnRule"
})
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehRateRuleRS.RentalRate.class
})
public class VehicleRentalRateType {

    @XmlElement(name = "RateDistance")
    protected List<VehicleRentalRateType.RateDistance> rateDistance;
    @XmlElement(name = "VehicleCharges")
    protected ArrayOfVehicleChargePurposeType vehicleCharges;
    @XmlElement(name = "RateQualifier")
    protected RateQualifierType rateQualifier;
    @XmlElement(name = "RateRestrictions")
    protected VehicleRentalRateType.RateRestrictions rateRestrictions;
    @XmlElement(name = "RateGuarantee")
    protected VehicleRentalRateType.RateGuarantee rateGuarantee;
    @XmlElement(name = "PickupReturnRule")
    protected List<VehicleRentalRateType.PickupReturnRule> pickupReturnRule;

    /**
     * Gets the value of the rateDistance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rateDistance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRateDistance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleRentalRateType.RateDistance }
     * 
     * 
     */
    public List<VehicleRentalRateType.RateDistance> getRateDistance() {
        if (rateDistance == null) {
            rateDistance = new ArrayList<VehicleRentalRateType.RateDistance>();
        }
        return this.rateDistance;
    }

    /**
     * Gets the value of the vehicleCharges property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleChargePurposeType }
     *     
     */
    public ArrayOfVehicleChargePurposeType getVehicleCharges() {
        return vehicleCharges;
    }

    /**
     * Sets the value of the vehicleCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleChargePurposeType }
     *     
     */
    public void setVehicleCharges(ArrayOfVehicleChargePurposeType value) {
        this.vehicleCharges = value;
    }

    /**
     * Gets the value of the rateQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link RateQualifierType }
     *     
     */
    public RateQualifierType getRateQualifier() {
        return rateQualifier;
    }

    /**
     * Sets the value of the rateQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateQualifierType }
     *     
     */
    public void setRateQualifier(RateQualifierType value) {
        this.rateQualifier = value;
    }

    /**
     * Gets the value of the rateRestrictions property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleRentalRateType.RateRestrictions }
     *     
     */
    public VehicleRentalRateType.RateRestrictions getRateRestrictions() {
        return rateRestrictions;
    }

    /**
     * Sets the value of the rateRestrictions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleRentalRateType.RateRestrictions }
     *     
     */
    public void setRateRestrictions(VehicleRentalRateType.RateRestrictions value) {
        this.rateRestrictions = value;
    }

    /**
     * Gets the value of the rateGuarantee property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleRentalRateType.RateGuarantee }
     *     
     */
    public VehicleRentalRateType.RateGuarantee getRateGuarantee() {
        return rateGuarantee;
    }

    /**
     * Sets the value of the rateGuarantee property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleRentalRateType.RateGuarantee }
     *     
     */
    public void setRateGuarantee(VehicleRentalRateType.RateGuarantee value) {
        this.rateGuarantee = value;
    }

    /**
     * Gets the value of the pickupReturnRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pickupReturnRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPickupReturnRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleRentalRateType.PickupReturnRule }
     * 
     * 
     */
    public List<VehicleRentalRateType.PickupReturnRule> getPickupReturnRule() {
        if (pickupReturnRule == null) {
            pickupReturnRule = new ArrayList<VehicleRentalRateType.PickupReturnRule>();
        }
        return this.pickupReturnRule;
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
     *       &lt;attribute name="DayOfWeek" type="{http://www.opentravel.org/OTA/2003/05}DayOfWeekType" />
     *       &lt;attribute name="Time" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RuleType">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="EarliestPickup"/>
     *             &lt;enumeration value="LatestPickup"/>
     *             &lt;enumeration value="LatestReturn"/>
     *           &lt;/restriction>
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
    public static class PickupReturnRule {

        @XmlAttribute(name = "DayOfWeek")
        protected DayOfWeekType dayOfWeek;
        @XmlAttribute(name = "Time")
        protected String time;
        @XmlAttribute(name = "RuleType")
        protected String ruleType;

        /**
         * Gets the value of the dayOfWeek property.
         * 
         * @return
         *     possible object is
         *     {@link DayOfWeekType }
         *     
         */
        public DayOfWeekType getDayOfWeek() {
            return dayOfWeek;
        }

        /**
         * Sets the value of the dayOfWeek property.
         * 
         * @param value
         *     allowed object is
         *     {@link DayOfWeekType }
         *     
         */
        public void setDayOfWeek(DayOfWeekType value) {
            this.dayOfWeek = value;
        }

        /**
         * Gets the value of the time property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTime() {
            return time;
        }

        /**
         * Sets the value of the time property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTime(String value) {
            this.time = value;
        }

        /**
         * Gets the value of the ruleType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRuleType() {
            return ruleType;
        }

        /**
         * Sets the value of the ruleType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRuleType(String value) {
            this.ruleType = value;
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
     *       &lt;attribute name="Unlimited" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
     *       &lt;attribute name="DistUnitName" type="{http://www.opentravel.org/OTA/2003/05}DistanceUnitNameType" />
     *       &lt;attribute name="VehiclePeriodUnitName" type="{http://www.opentravel.org/OTA/2003/05}VehiclePeriodUnitNameType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RateDistance {

        @XmlAttribute(name = "Unlimited", required = true)
        protected boolean unlimited;
        @XmlAttribute(name = "Quantity")
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger quantity;
        @XmlAttribute(name = "DistUnitName")
        protected DistanceUnitNameType distUnitName;
        @XmlAttribute(name = "VehiclePeriodUnitName")
        protected VehiclePeriodUnitNameType vehiclePeriodUnitName;

        /**
         * Gets the value of the unlimited property.
         * 
         */
        public boolean isUnlimited() {
            return unlimited;
        }

        /**
         * Sets the value of the unlimited property.
         * 
         */
        public void setUnlimited(boolean value) {
            this.unlimited = value;
        }

        /**
         * Gets the value of the quantity property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getQuantity() {
            return quantity;
        }

        /**
         * Sets the value of the quantity property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setQuantity(BigInteger value) {
            this.quantity = value;
        }

        /**
         * Gets the value of the distUnitName property.
         * 
         * @return
         *     possible object is
         *     {@link DistanceUnitNameType }
         *     
         */
        public DistanceUnitNameType getDistUnitName() {
            return distUnitName;
        }

        /**
         * Sets the value of the distUnitName property.
         * 
         * @param value
         *     allowed object is
         *     {@link DistanceUnitNameType }
         *     
         */
        public void setDistUnitName(DistanceUnitNameType value) {
            this.distUnitName = value;
        }

        /**
         * Gets the value of the vehiclePeriodUnitName property.
         * 
         * @return
         *     possible object is
         *     {@link VehiclePeriodUnitNameType }
         *     
         */
        public VehiclePeriodUnitNameType getVehiclePeriodUnitName() {
            return vehiclePeriodUnitName;
        }

        /**
         * Sets the value of the vehiclePeriodUnitName property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehiclePeriodUnitNameType }
         *     
         */
        public void setVehiclePeriodUnitName(VehiclePeriodUnitNameType value) {
            this.vehiclePeriodUnitName = value;
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
     *         &lt;element name="Description" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextTextType" minOccurs="0"/>
     *       &lt;/sequence>
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
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "description"
    })
    public static class RateGuarantee {

        @XmlElement(name = "Description")
        protected FormattedTextTextType description;
        @XmlAttribute(name = "AbsoluteDeadline")
        protected String absoluteDeadline;
        @XmlAttribute(name = "OffsetTimeUnit")
        protected TimeUnitType offsetTimeUnit;
        @XmlAttribute(name = "OffsetUnitMultiplier")
        protected BigInteger offsetUnitMultiplier;
        @XmlAttribute(name = "OffsetDropTime")
        protected String offsetDropTime;

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link FormattedTextTextType }
         *     
         */
        public FormattedTextTextType getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link FormattedTextTextType }
         *     
         */
        public void setDescription(FormattedTextTextType value) {
            this.description = value;
        }

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
     *         &lt;element name="MinimumAge" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="MaximumAge" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="NoShowFeeInd" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *       &lt;/sequence>
     *       &lt;attribute name="ArriveByFlight" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *       &lt;attribute name="MinimumDayInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="MaximumDayInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="AdvancedBookingInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="RestrictedMileageInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="CorporateRateInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="GuaranteeReqInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="MaximumVehiclesAllowed" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="OvernightInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="OneWayPolicy">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="OneWayAllowed"/>
     *             &lt;enumeration value="OneWayNotAllowed"/>
     *             &lt;enumeration value="RestrictedOneWay"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="CancellationPenaltyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="ModificationPenaltyInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "minimumAge",
        "maximumAge",
        "noShowFeeInd"
    })
    public static class RateRestrictions {

        @XmlElement(name = "MinimumAge")
        protected int minimumAge;
        @XmlElement(name = "MaximumAge")
        protected int maximumAge;
        @XmlElement(name = "NoShowFeeInd")
        protected boolean noShowFeeInd;
        @XmlAttribute(name = "ArriveByFlight")
        protected Boolean arriveByFlight;
        @XmlAttribute(name = "MinimumDayInd")
        protected Boolean minimumDayInd;
        @XmlAttribute(name = "MaximumDayInd")
        protected Boolean maximumDayInd;
        @XmlAttribute(name = "AdvancedBookingInd")
        protected Boolean advancedBookingInd;
        @XmlAttribute(name = "RestrictedMileageInd")
        protected Boolean restrictedMileageInd;
        @XmlAttribute(name = "CorporateRateInd")
        protected Boolean corporateRateInd;
        @XmlAttribute(name = "GuaranteeReqInd")
        protected Boolean guaranteeReqInd;
        @XmlAttribute(name = "MaximumVehiclesAllowed")
        protected BigInteger maximumVehiclesAllowed;
        @XmlAttribute(name = "OvernightInd")
        protected Boolean overnightInd;
        @XmlAttribute(name = "OneWayPolicy")
        protected String oneWayPolicy;
        @XmlAttribute(name = "CancellationPenaltyInd")
        protected Boolean cancellationPenaltyInd;
        @XmlAttribute(name = "ModificationPenaltyInd")
        protected Boolean modificationPenaltyInd;

        /**
         * Gets the value of the minimumAge property.
         * 
         */
        public int getMinimumAge() {
            return minimumAge;
        }

        /**
         * Sets the value of the minimumAge property.
         * 
         */
        public void setMinimumAge(int value) {
            this.minimumAge = value;
        }

        /**
         * Gets the value of the maximumAge property.
         * 
         */
        public int getMaximumAge() {
            return maximumAge;
        }

        /**
         * Sets the value of the maximumAge property.
         * 
         */
        public void setMaximumAge(int value) {
            this.maximumAge = value;
        }

        /**
         * Gets the value of the noShowFeeInd property.
         * 
         */
        public boolean isNoShowFeeInd() {
            return noShowFeeInd;
        }

        /**
         * Sets the value of the noShowFeeInd property.
         * 
         */
        public void setNoShowFeeInd(boolean value) {
            this.noShowFeeInd = value;
        }

        /**
         * Gets the value of the arriveByFlight property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public boolean isArriveByFlight() {
            if (arriveByFlight == null) {
                return false;
            } else {
                return arriveByFlight;
            }
        }

        /**
         * Sets the value of the arriveByFlight property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setArriveByFlight(Boolean value) {
            this.arriveByFlight = value;
        }

        /**
         * Gets the value of the minimumDayInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isMinimumDayInd() {
            return minimumDayInd;
        }

        /**
         * Sets the value of the minimumDayInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setMinimumDayInd(Boolean value) {
            this.minimumDayInd = value;
        }

        /**
         * Gets the value of the maximumDayInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isMaximumDayInd() {
            return maximumDayInd;
        }

        /**
         * Sets the value of the maximumDayInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setMaximumDayInd(Boolean value) {
            this.maximumDayInd = value;
        }

        /**
         * Gets the value of the advancedBookingInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isAdvancedBookingInd() {
            return advancedBookingInd;
        }

        /**
         * Sets the value of the advancedBookingInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAdvancedBookingInd(Boolean value) {
            this.advancedBookingInd = value;
        }

        /**
         * Gets the value of the restrictedMileageInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isRestrictedMileageInd() {
            return restrictedMileageInd;
        }

        /**
         * Sets the value of the restrictedMileageInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setRestrictedMileageInd(Boolean value) {
            this.restrictedMileageInd = value;
        }

        /**
         * Gets the value of the corporateRateInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCorporateRateInd() {
            return corporateRateInd;
        }

        /**
         * Sets the value of the corporateRateInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCorporateRateInd(Boolean value) {
            this.corporateRateInd = value;
        }

        /**
         * Gets the value of the guaranteeReqInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isGuaranteeReqInd() {
            return guaranteeReqInd;
        }

        /**
         * Sets the value of the guaranteeReqInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setGuaranteeReqInd(Boolean value) {
            this.guaranteeReqInd = value;
        }

        /**
         * Gets the value of the maximumVehiclesAllowed property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaximumVehiclesAllowed() {
            return maximumVehiclesAllowed;
        }

        /**
         * Sets the value of the maximumVehiclesAllowed property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaximumVehiclesAllowed(BigInteger value) {
            this.maximumVehiclesAllowed = value;
        }

        /**
         * Gets the value of the overnightInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isOvernightInd() {
            return overnightInd;
        }

        /**
         * Sets the value of the overnightInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setOvernightInd(Boolean value) {
            this.overnightInd = value;
        }

        /**
         * Gets the value of the oneWayPolicy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOneWayPolicy() {
            return oneWayPolicy;
        }

        /**
         * Sets the value of the oneWayPolicy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOneWayPolicy(String value) {
            this.oneWayPolicy = value;
        }

        /**
         * Gets the value of the cancellationPenaltyInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isCancellationPenaltyInd() {
            return cancellationPenaltyInd;
        }

        /**
         * Sets the value of the cancellationPenaltyInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setCancellationPenaltyInd(Boolean value) {
            this.cancellationPenaltyInd = value;
        }

        /**
         * Gets the value of the modificationPenaltyInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isModificationPenaltyInd() {
            return modificationPenaltyInd;
        }

        /**
         * Sets the value of the modificationPenaltyInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setModificationPenaltyInd(Boolean value) {
            this.modificationPenaltyInd = value;
        }

    }

}
