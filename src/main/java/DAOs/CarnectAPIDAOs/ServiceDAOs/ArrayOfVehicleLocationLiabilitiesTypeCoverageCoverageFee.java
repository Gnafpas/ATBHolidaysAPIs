
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
 * <p>Java class for ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CoverageFee" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Charge" type="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType" minOccurs="0"/>
 *                   &lt;element name="Vehicles" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle" minOccurs="0"/>
 *                   &lt;element name="Deductible" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                           &lt;attribute name="LiabilityAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
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
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee", propOrder = {
    "coverageFee"
})
public class ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee {

    @XmlElement(name = "CoverageFee")
    protected List<ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee.CoverageFee> coverageFee;

    /**
     * Gets the value of the coverageFee property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coverageFee property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoverageFee().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee.CoverageFee }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee.CoverageFee> getCoverageFee() {
        if (coverageFee == null) {
            coverageFee = new ArrayList<ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee.CoverageFee>();
        }
        return this.coverageFee;
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
     *         &lt;element name="Charge" type="{http://www.opentravel.org/OTA/2003/05}VehicleChargeType" minOccurs="0"/>
     *         &lt;element name="Vehicles" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle" minOccurs="0"/>
     *         &lt;element name="Deductible" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *                 &lt;attribute name="LiabilityAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
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
        "charge",
        "vehicles",
        "deductible"
    })
    public static class CoverageFee {

        @XmlElement(name = "Charge")
        protected VehicleChargeType charge;
        @XmlElement(name = "Vehicles")
        protected ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle vehicles;
        @XmlElement(name = "Deductible")
        protected ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee.CoverageFee.Deductible deductible;

        /**
         * Gets the value of the charge property.
         * 
         * @return
         *     possible object is
         *     {@link VehicleChargeType }
         *     
         */
        public VehicleChargeType getCharge() {
            return charge;
        }

        /**
         * Sets the value of the charge property.
         * 
         * @param value
         *     allowed object is
         *     {@link VehicleChargeType }
         *     
         */
        public void setCharge(VehicleChargeType value) {
            this.charge = value;
        }

        /**
         * Gets the value of the vehicles property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle }
         *     
         */
        public ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle getVehicles() {
            return vehicles;
        }

        /**
         * Sets the value of the vehicles property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle }
         *     
         */
        public void setVehicles(ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle value) {
            this.vehicles = value;
        }

        /**
         * Gets the value of the deductible property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee.CoverageFee.Deductible }
         *     
         */
        public ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee.CoverageFee.Deductible getDeductible() {
            return deductible;
        }

        /**
         * Sets the value of the deductible property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee.CoverageFee.Deductible }
         *     
         */
        public void setDeductible(ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee.CoverageFee.Deductible value) {
            this.deductible = value;
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
         *       &lt;attribute name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
         *       &lt;attribute name="LiabilityAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Deductible {

            @XmlAttribute(name = "Amount")
            protected BigDecimal amount;
            @XmlAttribute(name = "LiabilityAmount")
            protected BigDecimal liabilityAmount;

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
             * Gets the value of the liabilityAmount property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getLiabilityAmount() {
                return liabilityAmount;
            }

            /**
             * Sets the value of the liabilityAmount property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setLiabilityAmount(BigDecimal value) {
                this.liabilityAmount = value;
            }

        }

    }

}
