
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleLocationRequirementsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleLocationRequirementsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Age" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AgeSurcharge" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="Age" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="AgeInfos" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationRequirementsTypeAgeAgeInfo" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="MinimumAge" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                 &lt;attribute name="MaximumAge" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AdditionalDriver" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AddlDriverInfos" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PaymentOptions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CreditCard" type="{http://www.opentravel.org/OTA/2003/05}AcceptablePaymentCardsInfoType" minOccurs="0"/>
 *                   &lt;element name="DebitCard" type="{http://www.opentravel.org/OTA/2003/05}AcceptablePaymentCardsInfoType" minOccurs="0"/>
 *                   &lt;element name="Cash" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Voucher" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="BankAcct" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="DirectBill" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="LoyaltyRedemption" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="MiscChargeOrder" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Deposit" type="{http://www.opentravel.org/OTA/2003/05}AcceptablePaymentCardsInfoType" minOccurs="0"/>
 *                   &lt;element name="Guarantee" type="{http://www.opentravel.org/OTA/2003/05}AcceptablePaymentCardsInfoType" minOccurs="0"/>
 *                   &lt;element name="PrePayment" type="{http://www.opentravel.org/OTA/2003/05}AcceptablePaymentCardsInfoType" minOccurs="0"/>
 *                   &lt;element name="PaymentOptionsInfo" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RequirementInfos" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationRequirementsTypeRequirementInfo" minOccurs="0"/>
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
@XmlType(name = "VehicleLocationRequirementsType", propOrder = {
    "age",
    "additionalDriver",
    "paymentOptions",
    "requirementInfos",
    "tpaExtensions"
})
public class VehicleLocationRequirementsType {

    @XmlElement(name = "Age")
    protected VehicleLocationRequirementsType.Age age;
    @XmlElement(name = "AdditionalDriver")
    protected VehicleLocationRequirementsType.AdditionalDriver additionalDriver;
    @XmlElement(name = "PaymentOptions")
    protected VehicleLocationRequirementsType.PaymentOptions paymentOptions;
    @XmlElement(name = "RequirementInfos")
    protected ArrayOfVehicleLocationRequirementsTypeRequirementInfo requirementInfos;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationRequirementsType.Age }
     *     
     */
    public VehicleLocationRequirementsType.Age getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationRequirementsType.Age }
     *     
     */
    public void setAge(VehicleLocationRequirementsType.Age value) {
        this.age = value;
    }

    /**
     * Gets the value of the additionalDriver property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationRequirementsType.AdditionalDriver }
     *     
     */
    public VehicleLocationRequirementsType.AdditionalDriver getAdditionalDriver() {
        return additionalDriver;
    }

    /**
     * Sets the value of the additionalDriver property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationRequirementsType.AdditionalDriver }
     *     
     */
    public void setAdditionalDriver(VehicleLocationRequirementsType.AdditionalDriver value) {
        this.additionalDriver = value;
    }

    /**
     * Gets the value of the paymentOptions property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationRequirementsType.PaymentOptions }
     *     
     */
    public VehicleLocationRequirementsType.PaymentOptions getPaymentOptions() {
        return paymentOptions;
    }

    /**
     * Sets the value of the paymentOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationRequirementsType.PaymentOptions }
     *     
     */
    public void setPaymentOptions(VehicleLocationRequirementsType.PaymentOptions value) {
        this.paymentOptions = value;
    }

    /**
     * Gets the value of the requirementInfos property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleLocationRequirementsTypeRequirementInfo }
     *     
     */
    public ArrayOfVehicleLocationRequirementsTypeRequirementInfo getRequirementInfos() {
        return requirementInfos;
    }

    /**
     * Sets the value of the requirementInfos property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleLocationRequirementsTypeRequirementInfo }
     *     
     */
    public void setRequirementInfos(ArrayOfVehicleLocationRequirementsTypeRequirementInfo value) {
        this.requirementInfos = value;
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
     *       &lt;sequence>
     *         &lt;element name="AddlDriverInfos" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo" minOccurs="0"/>
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
        "addlDriverInfos"
    })
    public static class AdditionalDriver {

        @XmlElement(name = "AddlDriverInfos")
        protected ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo addlDriverInfos;

        /**
         * Gets the value of the addlDriverInfos property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo }
         *     
         */
        public ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo getAddlDriverInfos() {
            return addlDriverInfos;
        }

        /**
         * Sets the value of the addlDriverInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo }
         *     
         */
        public void setAddlDriverInfos(ArrayOfVehicleLocationRequirementsTypeAdditionalDriverAddlDriverInfo value) {
            this.addlDriverInfos = value;
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
     *         &lt;element name="AgeSurcharge" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="Age" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="AgeInfos" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationRequirementsTypeAgeAgeInfo" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="MinimumAge" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *       &lt;attribute name="MaximumAge" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ageSurcharge",
        "ageInfos"
    })
    public static class Age {

        @XmlElement(name = "AgeSurcharge")
        protected List<VehicleLocationRequirementsType.Age.AgeSurcharge> ageSurcharge;
        @XmlElement(name = "AgeInfos")
        protected ArrayOfVehicleLocationRequirementsTypeAgeAgeInfo ageInfos;
        @XmlAttribute(name = "MinimumAge")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger minimumAge;
        @XmlAttribute(name = "MaximumAge")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger maximumAge;

        /**
         * Gets the value of the ageSurcharge property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ageSurcharge property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAgeSurcharge().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VehicleLocationRequirementsType.Age.AgeSurcharge }
         * 
         * 
         */
        public List<VehicleLocationRequirementsType.Age.AgeSurcharge> getAgeSurcharge() {
            if (ageSurcharge == null) {
                ageSurcharge = new ArrayList<VehicleLocationRequirementsType.Age.AgeSurcharge>();
            }
            return this.ageSurcharge;
        }

        /**
         * Gets the value of the ageInfos property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfVehicleLocationRequirementsTypeAgeAgeInfo }
         *     
         */
        public ArrayOfVehicleLocationRequirementsTypeAgeAgeInfo getAgeInfos() {
            return ageInfos;
        }

        /**
         * Sets the value of the ageInfos property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfVehicleLocationRequirementsTypeAgeAgeInfo }
         *     
         */
        public void setAgeInfos(ArrayOfVehicleLocationRequirementsTypeAgeAgeInfo value) {
            this.ageInfos = value;
        }

        /**
         * Gets the value of the minimumAge property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMinimumAge() {
            return minimumAge;
        }

        /**
         * Sets the value of the minimumAge property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMinimumAge(BigInteger value) {
            this.minimumAge = value;
        }

        /**
         * Gets the value of the maximumAge property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaximumAge() {
            return maximumAge;
        }

        /**
         * Sets the value of the maximumAge property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaximumAge(BigInteger value) {
            this.maximumAge = value;
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
         *       &lt;attribute name="Age" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class AgeSurcharge {

            @XmlAttribute(name = "Age")
            protected String age;
            @XmlAttribute(name = "Amount")
            protected BigDecimal amount;

            /**
             * Gets the value of the age property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAge() {
                return age;
            }

            /**
             * Sets the value of the age property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAge(String value) {
                this.age = value;
            }

            /**
             * Gets the value of the amount property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmount() {
                return amount;
            }

            /**
             * Sets the value of the amount property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmount(BigDecimal value) {
                this.amount = value;
            }

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
     *         &lt;element name="CreditCard" type="{http://www.opentravel.org/OTA/2003/05}AcceptablePaymentCardsInfoType" minOccurs="0"/>
     *         &lt;element name="DebitCard" type="{http://www.opentravel.org/OTA/2003/05}AcceptablePaymentCardsInfoType" minOccurs="0"/>
     *         &lt;element name="Cash" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Voucher" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="BankAcct" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="DirectBill" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="LoyaltyRedemption" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="MiscChargeOrder" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Deposit" type="{http://www.opentravel.org/OTA/2003/05}AcceptablePaymentCardsInfoType" minOccurs="0"/>
     *         &lt;element name="Guarantee" type="{http://www.opentravel.org/OTA/2003/05}AcceptablePaymentCardsInfoType" minOccurs="0"/>
     *         &lt;element name="PrePayment" type="{http://www.opentravel.org/OTA/2003/05}AcceptablePaymentCardsInfoType" minOccurs="0"/>
     *         &lt;element name="PaymentOptionsInfo" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
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
        "creditCard",
        "debitCard",
        "cash",
        "voucher",
        "bankAcct",
        "directBill",
        "loyaltyRedemption",
        "miscChargeOrder",
        "deposit",
        "guarantee",
        "prePayment",
        "paymentOptionsInfo"
    })
    public static class PaymentOptions {

        @XmlElement(name = "CreditCard")
        protected AcceptablePaymentCardsInfoType creditCard;
        @XmlElement(name = "DebitCard")
        protected AcceptablePaymentCardsInfoType debitCard;
        @XmlElement(name = "Cash")
        protected VehicleLocationRequirementsType.PaymentOptions.Cash cash;
        @XmlElement(name = "Voucher")
        protected VehicleLocationRequirementsType.PaymentOptions.Voucher voucher;
        @XmlElement(name = "BankAcct")
        protected VehicleLocationRequirementsType.PaymentOptions.BankAcct bankAcct;
        @XmlElement(name = "DirectBill")
        protected VehicleLocationRequirementsType.PaymentOptions.DirectBill directBill;
        @XmlElement(name = "LoyaltyRedemption")
        protected VehicleLocationRequirementsType.PaymentOptions.LoyaltyRedemption loyaltyRedemption;
        @XmlElement(name = "MiscChargeOrder")
        protected VehicleLocationRequirementsType.PaymentOptions.MiscChargeOrder miscChargeOrder;
        @XmlElement(name = "Deposit")
        protected AcceptablePaymentCardsInfoType deposit;
        @XmlElement(name = "Guarantee")
        protected AcceptablePaymentCardsInfoType guarantee;
        @XmlElement(name = "PrePayment")
        protected AcceptablePaymentCardsInfoType prePayment;
        @XmlElement(name = "PaymentOptionsInfo")
        protected FormattedTextType paymentOptionsInfo;

        /**
         * Gets the value of the creditCard property.
         * 
         * @return
         *     possible object is
         *     {@link AcceptablePaymentCardsInfoType }
         *     
         */
        public AcceptablePaymentCardsInfoType getCreditCard() {
            return creditCard;
        }

        /**
         * Sets the value of the creditCard property.
         * 
         * @param value
         *     allowed object is
         *     {@link AcceptablePaymentCardsInfoType }
         *     
         */
        public void setCreditCard(AcceptablePaymentCardsInfoType value) {
            this.creditCard = value;
        }

        /**
         * Gets the value of the debitCard property.
         * 
         * @return
         *     possible object is
         *     {@link AcceptablePaymentCardsInfoType }
         *     
         */
        public AcceptablePaymentCardsInfoType getDebitCard() {
            return debitCard;
        }

        /**
         * Sets the value of the debitCard property.
         * 
         * @param value
         *     allowed object is
         *     {@link AcceptablePaymentCardsInfoType }
         *     
         */
        public void setDebitCard(AcceptablePaymentCardsInfoType value) {
            this.debitCard = value;
        }

        /**
         * Gets the value of the cash property.
         * 
         * @return
         *     possible object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.Cash }
         *     
         */
        public VehicleLocationRequirementsType.PaymentOptions.Cash getCash() {
            return cash;
        }

        /**
         * Sets the value of the cash property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.Cash }
         *     
         */
        public void setCash(VehicleLocationRequirementsType.PaymentOptions.Cash value) {
            this.cash = value;
        }

        /**
         * Gets the value of the voucher property.
         * 
         * @return
         *     possible object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.Voucher }
         *     
         */
        public VehicleLocationRequirementsType.PaymentOptions.Voucher getVoucher() {
            return voucher;
        }

        /**
         * Sets the value of the voucher property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.Voucher }
         *     
         */
        public void setVoucher(VehicleLocationRequirementsType.PaymentOptions.Voucher value) {
            this.voucher = value;
        }

        /**
         * Gets the value of the bankAcct property.
         * 
         * @return
         *     possible object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.BankAcct }
         *     
         */
        public VehicleLocationRequirementsType.PaymentOptions.BankAcct getBankAcct() {
            return bankAcct;
        }

        /**
         * Sets the value of the bankAcct property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.BankAcct }
         *     
         */
        public void setBankAcct(VehicleLocationRequirementsType.PaymentOptions.BankAcct value) {
            this.bankAcct = value;
        }

        /**
         * Gets the value of the directBill property.
         * 
         * @return
         *     possible object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.DirectBill }
         *     
         */
        public VehicleLocationRequirementsType.PaymentOptions.DirectBill getDirectBill() {
            return directBill;
        }

        /**
         * Sets the value of the directBill property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.DirectBill }
         *     
         */
        public void setDirectBill(VehicleLocationRequirementsType.PaymentOptions.DirectBill value) {
            this.directBill = value;
        }

        /**
         * Gets the value of the loyaltyRedemption property.
         * 
         * @return
         *     possible object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.LoyaltyRedemption }
         *     
         */
        public VehicleLocationRequirementsType.PaymentOptions.LoyaltyRedemption getLoyaltyRedemption() {
            return loyaltyRedemption;
        }

        /**
         * Sets the value of the loyaltyRedemption property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.LoyaltyRedemption }
         *     
         */
        public void setLoyaltyRedemption(VehicleLocationRequirementsType.PaymentOptions.LoyaltyRedemption value) {
            this.loyaltyRedemption = value;
        }

        /**
         * Gets the value of the miscChargeOrder property.
         * 
         * @return
         *     possible object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.MiscChargeOrder }
         *     
         */
        public VehicleLocationRequirementsType.PaymentOptions.MiscChargeOrder getMiscChargeOrder() {
            return miscChargeOrder;
        }

        /**
         * Sets the value of the miscChargeOrder property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehicleLocationRequirementsType.PaymentOptions.MiscChargeOrder }
         *     
         */
        public void setMiscChargeOrder(VehicleLocationRequirementsType.PaymentOptions.MiscChargeOrder value) {
            this.miscChargeOrder = value;
        }

        /**
         * Gets the value of the deposit property.
         * 
         * @return
         *     possible object is
         *     {@link AcceptablePaymentCardsInfoType }
         *     
         */
        public AcceptablePaymentCardsInfoType getDeposit() {
            return deposit;
        }

        /**
         * Sets the value of the deposit property.
         * 
         * @param value
         *     allowed object is
         *     {@link AcceptablePaymentCardsInfoType }
         *     
         */
        public void setDeposit(AcceptablePaymentCardsInfoType value) {
            this.deposit = value;
        }

        /**
         * Gets the value of the guarantee property.
         * 
         * @return
         *     possible object is
         *     {@link AcceptablePaymentCardsInfoType }
         *     
         */
        public AcceptablePaymentCardsInfoType getGuarantee() {
            return guarantee;
        }

        /**
         * Sets the value of the guarantee property.
         * 
         * @param value
         *     allowed object is
         *     {@link AcceptablePaymentCardsInfoType }
         *     
         */
        public void setGuarantee(AcceptablePaymentCardsInfoType value) {
            this.guarantee = value;
        }

        /**
         * Gets the value of the prePayment property.
         * 
         * @return
         *     possible object is
         *     {@link AcceptablePaymentCardsInfoType }
         *     
         */
        public AcceptablePaymentCardsInfoType getPrePayment() {
            return prePayment;
        }

        /**
         * Sets the value of the prePayment property.
         * 
         * @param value
         *     allowed object is
         *     {@link AcceptablePaymentCardsInfoType }
         *     
         */
        public void setPrePayment(AcceptablePaymentCardsInfoType value) {
            this.prePayment = value;
        }

        /**
         * Gets the value of the paymentOptionsInfo property.
         * 
         * @return
         *     possible object is
         *     {@link FormattedTextType }
         *     
         */
        public FormattedTextType getPaymentOptionsInfo() {
            return paymentOptionsInfo;
        }

        /**
         * Sets the value of the paymentOptionsInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link FormattedTextType }
         *     
         */
        public void setPaymentOptionsInfo(FormattedTextType value) {
            this.paymentOptionsInfo = value;
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
         *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
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
            "info"
        })
        public static class BankAcct {

            @XmlElement(name = "Info")
            protected FormattedTextType info;

            /**
             * Gets the value of the info property.
             * 
             * @return
             *     possible object is
             *     {@link FormattedTextType }
             *     
             */
            public FormattedTextType getInfo() {
                return info;
            }

            /**
             * Sets the value of the info property.
             * 
             * @param value
             *     allowed object is
             *     {@link FormattedTextType }
             *     
             */
            public void setInfo(FormattedTextType value) {
                this.info = value;
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
         *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
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
            "info"
        })
        public static class Cash {

            @XmlElement(name = "Info")
            protected FormattedTextType info;

            /**
             * Gets the value of the info property.
             * 
             * @return
             *     possible object is
             *     {@link FormattedTextType }
             *     
             */
            public FormattedTextType getInfo() {
                return info;
            }

            /**
             * Sets the value of the info property.
             * 
             * @param value
             *     allowed object is
             *     {@link FormattedTextType }
             *     
             */
            public void setInfo(FormattedTextType value) {
                this.info = value;
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
         *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
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
            "info"
        })
        public static class DirectBill {

            @XmlElement(name = "Info")
            protected FormattedTextType info;

            /**
             * Gets the value of the info property.
             * 
             * @return
             *     possible object is
             *     {@link FormattedTextType }
             *     
             */
            public FormattedTextType getInfo() {
                return info;
            }

            /**
             * Sets the value of the info property.
             * 
             * @param value
             *     allowed object is
             *     {@link FormattedTextType }
             *     
             */
            public void setInfo(FormattedTextType value) {
                this.info = value;
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
         *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
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
            "info"
        })
        public static class LoyaltyRedemption {

            @XmlElement(name = "Info")
            protected FormattedTextType info;

            /**
             * Gets the value of the info property.
             * 
             * @return
             *     possible object is
             *     {@link FormattedTextType }
             *     
             */
            public FormattedTextType getInfo() {
                return info;
            }

            /**
             * Sets the value of the info property.
             * 
             * @param value
             *     allowed object is
             *     {@link FormattedTextType }
             *     
             */
            public void setInfo(FormattedTextType value) {
                this.info = value;
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
         *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
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
            "info"
        })
        public static class MiscChargeOrder {

            @XmlElement(name = "Info")
            protected FormattedTextType info;

            /**
             * Gets the value of the info property.
             * 
             * @return
             *     possible object is
             *     {@link FormattedTextType }
             *     
             */
            public FormattedTextType getInfo() {
                return info;
            }

            /**
             * Sets the value of the info property.
             * 
             * @param value
             *     allowed object is
             *     {@link FormattedTextType }
             *     
             */
            public void setInfo(FormattedTextType value) {
                this.info = value;
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
         *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
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
            "info"
        })
        public static class Voucher {

            @XmlElement(name = "Info")
            protected FormattedTextType info;

            /**
             * Gets the value of the info property.
             * 
             * @return
             *     possible object is
             *     {@link FormattedTextType }
             *     
             */
            public FormattedTextType getInfo() {
                return info;
            }

            /**
             * Sets the value of the info property.
             * 
             * @param value
             *     allowed object is
             *     {@link FormattedTextType }
             *     
             */
            public void setInfo(FormattedTextType value) {
                this.info = value;
            }

        }

    }

}
