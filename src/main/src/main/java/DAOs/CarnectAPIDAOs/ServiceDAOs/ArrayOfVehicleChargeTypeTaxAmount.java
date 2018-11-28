
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
 * <p>Java class for ArrayOfVehicleChargeTypeTaxAmount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleChargeTypeTaxAmount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TaxAmount" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Total" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="TaxCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Percentage" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "ArrayOfVehicleChargeTypeTaxAmount", propOrder = {
    "taxAmount"
})
public class ArrayOfVehicleChargeTypeTaxAmount {

    @XmlElement(name = "TaxAmount")
    protected List<ArrayOfVehicleChargeTypeTaxAmount.TaxAmount> taxAmount;

    /**
     * Gets the value of the taxAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleChargeTypeTaxAmount.TaxAmount }
     * 
     * 
     */
    public List<ArrayOfVehicleChargeTypeTaxAmount.TaxAmount> getTaxAmount() {
        if (taxAmount == null) {
            taxAmount = new ArrayList<ArrayOfVehicleChargeTypeTaxAmount.TaxAmount>();
        }
        return this.taxAmount;
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
     *       &lt;attribute name="Total" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="TaxCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Percentage" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *       &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TaxAmount {

        @XmlAttribute(name = "Total", required = true)
        protected BigDecimal total;
        @XmlAttribute(name = "CurrencyCode")
        protected String currencyCode;
        @XmlAttribute(name = "TaxCode")
        protected String taxCode;
        @XmlAttribute(name = "Percentage")
        protected BigDecimal percentage;
        @XmlAttribute(name = "Description")
        protected String description;

        /**
         * Gets the value of the total property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotal() {
            return total;
        }

        /**
         * Sets the value of the total property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotal(BigDecimal value) {
            this.total = value;
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

    }

}
