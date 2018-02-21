
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleLocationAdditionalFeesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleLocationAdditionalFeesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Taxes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Tax" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="TaxCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="Percentage" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Duration" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Fees" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Fee" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType">
 *                           &lt;sequence>
 *                             &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Surcharges" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Surcharge" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType">
 *                           &lt;sequence>
 *                             &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Duration" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MiscellaneousCharges" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MiscellaneousCharge" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType">
 *                           &lt;sequence>
 *                             &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                 &lt;/sequence>
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
@XmlType(name = "VehicleLocationAdditionalFeesType", propOrder = {
    "taxes",
    "fees",
    "surcharges",
    "miscellaneousCharges",
    "tpaExtensions"
})
public class VehicleLocationAdditionalFeesType {

    @XmlElement(name = "Taxes")
    protected VehicleLocationAdditionalFeesType.Taxes taxes;
    @XmlElement(name = "Fees")
    protected VehicleLocationAdditionalFeesType.Fees fees;
    @XmlElement(name = "Surcharges")
    protected VehicleLocationAdditionalFeesType.Surcharges surcharges;
    @XmlElement(name = "MiscellaneousCharges")
    protected VehicleLocationAdditionalFeesType.MiscellaneousCharges miscellaneousCharges;
    @XmlElement(name = "TPA_Extensions")
    protected TPAExtensionsType tpaExtensions;

    /**
     * Gets the value of the taxes property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationAdditionalFeesType.Taxes }
     *     
     */
    public VehicleLocationAdditionalFeesType.Taxes getTaxes() {
        return taxes;
    }

    /**
     * Sets the value of the taxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationAdditionalFeesType.Taxes }
     *     
     */
    public void setTaxes(VehicleLocationAdditionalFeesType.Taxes value) {
        this.taxes = value;
    }

    /**
     * Gets the value of the fees property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationAdditionalFeesType.Fees }
     *     
     */
    public VehicleLocationAdditionalFeesType.Fees getFees() {
        return fees;
    }

    /**
     * Sets the value of the fees property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationAdditionalFeesType.Fees }
     *     
     */
    public void setFees(VehicleLocationAdditionalFeesType.Fees value) {
        this.fees = value;
    }

    /**
     * Gets the value of the surcharges property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationAdditionalFeesType.Surcharges }
     *     
     */
    public VehicleLocationAdditionalFeesType.Surcharges getSurcharges() {
        return surcharges;
    }

    /**
     * Sets the value of the surcharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationAdditionalFeesType.Surcharges }
     *     
     */
    public void setSurcharges(VehicleLocationAdditionalFeesType.Surcharges value) {
        this.surcharges = value;
    }

    /**
     * Gets the value of the miscellaneousCharges property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationAdditionalFeesType.MiscellaneousCharges }
     *     
     */
    public VehicleLocationAdditionalFeesType.MiscellaneousCharges getMiscellaneousCharges() {
        return miscellaneousCharges;
    }

    /**
     * Sets the value of the miscellaneousCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationAdditionalFeesType.MiscellaneousCharges }
     *     
     */
    public void setMiscellaneousCharges(VehicleLocationAdditionalFeesType.MiscellaneousCharges value) {
        this.miscellaneousCharges = value;
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
     *         &lt;element name="Fee" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType">
     *                 &lt;sequence>
     *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "fee",
        "info"
    })
    public static class Fees {

        @XmlElement(name = "Fee")
        protected List<VehicleLocationAdditionalFeesType.Fees.Fee> fee;
        @XmlElement(name = "Info")
        protected FormattedTextType info;

        /**
         * Gets the value of the fee property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fee property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFee().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VehicleLocationAdditionalFeesType.Fees.Fee }
         * 
         * 
         */
        public List<VehicleLocationAdditionalFeesType.Fees.Fee> getFee() {
            if (fee == null) {
                fee = new ArrayList<VehicleLocationAdditionalFeesType.Fees.Fee>();
            }
            return this.fee;
        }

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


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType">
         *       &lt;sequence>
         *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/extension>
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
        public static class Fee
            extends VehicleChargeType
        {

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
     *         &lt;element name="MiscellaneousCharge" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType">
     *                 &lt;sequence>
     *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "miscellaneousCharge",
        "info"
    })
    public static class MiscellaneousCharges {

        @XmlElement(name = "MiscellaneousCharge")
        protected List<VehicleLocationAdditionalFeesType.MiscellaneousCharges.MiscellaneousCharge> miscellaneousCharge;
        @XmlElement(name = "Info")
        protected FormattedTextType info;

        /**
         * Gets the value of the miscellaneousCharge property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the miscellaneousCharge property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMiscellaneousCharge().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VehicleLocationAdditionalFeesType.MiscellaneousCharges.MiscellaneousCharge }
         * 
         * 
         */
        public List<VehicleLocationAdditionalFeesType.MiscellaneousCharges.MiscellaneousCharge> getMiscellaneousCharge() {
            if (miscellaneousCharge == null) {
                miscellaneousCharge = new ArrayList<VehicleLocationAdditionalFeesType.MiscellaneousCharges.MiscellaneousCharge>();
            }
            return this.miscellaneousCharge;
        }

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


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType">
         *       &lt;sequence>
         *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/extension>
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
        public static class MiscellaneousCharge
            extends VehicleChargeType
        {

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
     *         &lt;element name="Surcharge" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType">
     *                 &lt;sequence>
     *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Duration" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "surcharge",
        "info"
    })
    public static class Surcharges {

        @XmlElement(name = "Surcharge")
        protected List<VehicleLocationAdditionalFeesType.Surcharges.Surcharge> surcharge;
        @XmlElement(name = "Info")
        protected FormattedTextType info;
        @XmlAttribute(name = "Start")
        protected String start;
        @XmlAttribute(name = "Duration")
        protected String duration;
        @XmlAttribute(name = "End")
        protected String end;

        /**
         * Gets the value of the surcharge property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the surcharge property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSurcharge().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VehicleLocationAdditionalFeesType.Surcharges.Surcharge }
         * 
         * 
         */
        public List<VehicleLocationAdditionalFeesType.Surcharges.Surcharge> getSurcharge() {
            if (surcharge == null) {
                surcharge = new ArrayList<VehicleLocationAdditionalFeesType.Surcharges.Surcharge>();
            }
            return this.surcharge;
        }

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

        /**
         * Gets the value of the start property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStart() {
            return start;
        }

        /**
         * Sets the value of the start property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStart(String value) {
            this.start = value;
        }

        /**
         * Gets the value of the duration property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDuration() {
            return duration;
        }

        /**
         * Sets the value of the duration property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDuration(String value) {
            this.duration = value;
        }

        /**
         * Gets the value of the end property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEnd() {
            return end;
        }

        /**
         * Sets the value of the end property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEnd(String value) {
            this.end = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType">
         *       &lt;sequence>
         *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/extension>
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
        public static class Surcharge
            extends VehicleChargeType
        {

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
     *         &lt;element name="Tax" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="TaxCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="Percentage" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Info" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Duration" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "tax",
        "info"
    })
    public static class Taxes {

        @XmlElement(name = "Tax")
        protected List<VehicleLocationAdditionalFeesType.Taxes.Tax> tax;
        @XmlElement(name = "Info")
        protected FormattedTextType info;
        @XmlAttribute(name = "Start")
        protected String start;
        @XmlAttribute(name = "Duration")
        protected String duration;
        @XmlAttribute(name = "End")
        protected String end;

        /**
         * Gets the value of the tax property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tax property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTax().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VehicleLocationAdditionalFeesType.Taxes.Tax }
         * 
         * 
         */
        public List<VehicleLocationAdditionalFeesType.Taxes.Tax> getTax() {
            if (tax == null) {
                tax = new ArrayList<VehicleLocationAdditionalFeesType.Taxes.Tax>();
            }
            return this.tax;
        }

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

        /**
         * Gets the value of the start property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStart() {
            return start;
        }

        /**
         * Sets the value of the start property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStart(String value) {
            this.start = value;
        }

        /**
         * Gets the value of the duration property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDuration() {
            return duration;
        }

        /**
         * Sets the value of the duration property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDuration(String value) {
            this.duration = value;
        }

        /**
         * Gets the value of the end property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEnd() {
            return end;
        }

        /**
         * Sets the value of the end property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEnd(String value) {
            this.end = value;
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
         *       &lt;attribute name="TaxCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="Percentage" type="{http://www.w3.org/2001/XMLSchema}decimal" />
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
        public static class Tax {

            @XmlElement(name = "Info")
            protected FormattedTextType info;
            @XmlAttribute(name = "TaxCode")
            protected String taxCode;
            @XmlAttribute(name = "Percentage")
            protected BigDecimal percentage;

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

            /**
             * Gets the value of the taxCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxCode() {
                return taxCode;
            }

            /**
             * Sets the value of the taxCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxCode(String value) {
                this.taxCode = value;
            }

            /**
             * Gets the value of the percentage property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPercentage() {
                return percentage;
            }

            /**
             * Sets the value of the percentage property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPercentage(BigDecimal value) {
                this.percentage = value;
            }

        }

    }

}
