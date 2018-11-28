
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleChargeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleChargeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TaxAmounts" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleChargeTypeTaxAmount" minOccurs="0"/>
 *         &lt;element name="MinMax" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="MaxCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="MinCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="MaxChargeDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Calculation" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="UnitCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="UnitName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="Percentage" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="Applicability">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="FromPickupLocation"/>
 *                       &lt;enumeration value="FromDropoffLocation"/>
 *                       &lt;enumeration value="BeforePickup"/>
 *                       &lt;enumeration value="AfterDropoff"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="MaxQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="TaxInclusive" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="GuaranteedInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="IncludedInRate" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="IncludedInEstTotalInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleChargeType", propOrder = {
    "taxAmounts",
    "minMax",
    "calculation"
})
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehicleLocationAdditionalFeesType.Fees.Fee.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehicleLocationAdditionalFeesType.Surcharges.Surcharge.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehicleLocationAdditionalFeesType.MiscellaneousCharges.MiscellaneousCharge.class,
    VehicleChargePurposeType.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge.OffLocServiceCharge.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleLocationServicesOfferedTypeOnLocationServiceOnLocServiceCharge.OnLocServiceCharge.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge.EquipCharge.class
})
public class VehicleChargeType {

    @XmlElement(name = "TaxAmounts")
    protected ArrayOfVehicleChargeTypeTaxAmount taxAmounts;
    @XmlElement(name = "MinMax")
    protected VehicleChargeType.MinMax minMax;
    @XmlElement(name = "Calculation")
    protected List<VehicleChargeType.Calculation> calculation;
    @XmlAttribute(name = "CurrencyCode")
    protected String currencyCode;
    @XmlAttribute(name = "Amount")
    protected BigDecimal amount;
    @XmlAttribute(name = "TaxInclusive")
    protected Boolean taxInclusive;
    @XmlAttribute(name = "Description")
    protected String description;
    @XmlAttribute(name = "GuaranteedInd")
    protected Boolean guaranteedInd;
    @XmlAttribute(name = "IncludedInRate")
    protected Boolean includedInRate;
    @XmlAttribute(name = "IncludedInEstTotalInd")
    protected Boolean includedInEstTotalInd;

    /**
     * Gets the value of the taxAmounts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVehicleChargeTypeTaxAmount }
     *     
     */
    public ArrayOfVehicleChargeTypeTaxAmount getTaxAmounts() {
        return taxAmounts;
    }

    /**
     * Sets the value of the taxAmounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVehicleChargeTypeTaxAmount }
     *     
     */
    public void setTaxAmounts(ArrayOfVehicleChargeTypeTaxAmount value) {
        this.taxAmounts = value;
    }

    /**
     * Gets the value of the minMax property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleChargeType.MinMax }
     *     
     */
    public VehicleChargeType.MinMax getMinMax() {
        return minMax;
    }

    /**
     * Sets the value of the minMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleChargeType.MinMax }
     *     
     */
    public void setMinMax(VehicleChargeType.MinMax value) {
        this.minMax = value;
    }

    /**
     * Gets the value of the calculation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calculation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalculation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleChargeType.Calculation }
     * 
     * 
     */
    public List<VehicleChargeType.Calculation> getCalculation() {
        if (calculation == null) {
            calculation = new ArrayList<VehicleChargeType.Calculation>();
        }
        return this.calculation;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
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

    /**
     * Gets the value of the taxInclusive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTaxInclusive() {
        return taxInclusive;
    }

    /**
     * Sets the value of the taxInclusive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTaxInclusive(Boolean value) {
        this.taxInclusive = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the guaranteedInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGuaranteedInd() {
        return guaranteedInd;
    }

    /**
     * Sets the value of the guaranteedInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGuaranteedInd(Boolean value) {
        this.guaranteedInd = value;
    }

    /**
     * Gets the value of the includedInRate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIncludedInRate() {
        if (includedInRate == null) {
            return false;
        } else {
            return includedInRate;
        }
    }

    /**
     * Sets the value of the includedInRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludedInRate(Boolean value) {
        this.includedInRate = value;
    }

    /**
     * Gets the value of the includedInEstTotalInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludedInEstTotalInd() {
        return includedInEstTotalInd;
    }

    /**
     * Sets the value of the includedInEstTotalInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludedInEstTotalInd(Boolean value) {
        this.includedInEstTotalInd = value;
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
     *       &lt;attribute name="UnitCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="UnitName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Quantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="Percentage" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="Applicability">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="FromPickupLocation"/>
     *             &lt;enumeration value="FromDropoffLocation"/>
     *             &lt;enumeration value="BeforePickup"/>
     *             &lt;enumeration value="AfterDropoff"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="MaxQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Calculation {

        @XmlAttribute(name = "UnitCharge")
        protected BigDecimal unitCharge;
        @XmlAttribute(name = "UnitName")
        protected String unitName;
        @XmlAttribute(name = "Quantity")
        protected BigInteger quantity;
        @XmlAttribute(name = "Percentage")
        protected BigDecimal percentage;
        @XmlAttribute(name = "Applicability")
        protected String applicability;
        @XmlAttribute(name = "MaxQuantity")
        protected BigInteger maxQuantity;

        /**
         * Gets the value of the unitCharge property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getUnitCharge() {
            return unitCharge;
        }

        /**
         * Sets the value of the unitCharge property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setUnitCharge(BigDecimal value) {
            this.unitCharge = value;
        }

        /**
         * Gets the value of the unitName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnitName() {
            return unitName;
        }

        /**
         * Sets the value of the unitName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnitName(String value) {
            this.unitName = value;
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

        /**
         * Gets the value of the applicability property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApplicability() {
            return applicability;
        }

        /**
         * Sets the value of the applicability property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApplicability(String value) {
            this.applicability = value;
        }

        /**
         * Gets the value of the maxQuantity property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaxQuantity() {
            return maxQuantity;
        }

        /**
         * Sets the value of the maxQuantity property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaxQuantity(BigInteger value) {
            this.maxQuantity = value;
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
     *       &lt;attribute name="MaxCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="MinCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="MaxChargeDays" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MinMax {

        @XmlAttribute(name = "MaxCharge")
        protected BigDecimal maxCharge;
        @XmlAttribute(name = "MinCharge")
        protected BigDecimal minCharge;
        @XmlAttribute(name = "MaxChargeDays")
        protected BigInteger maxChargeDays;

        /**
         * Gets the value of the maxCharge property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMaxCharge() {
            return maxCharge;
        }

        /**
         * Sets the value of the maxCharge property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMaxCharge(BigDecimal value) {
            this.maxCharge = value;
        }

        /**
         * Gets the value of the minCharge property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getMinCharge() {
            return minCharge;
        }

        /**
         * Sets the value of the minCharge property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setMinCharge(BigDecimal value) {
            this.minCharge = value;
        }

        /**
         * Gets the value of the maxChargeDays property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMaxChargeDays() {
            return maxChargeDays;
        }

        /**
         * Sets the value of the maxChargeDays property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMaxChargeDays(BigInteger value) {
            this.maxChargeDays = value;
        }

    }

}
