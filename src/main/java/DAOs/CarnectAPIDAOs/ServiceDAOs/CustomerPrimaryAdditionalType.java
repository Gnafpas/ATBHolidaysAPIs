
package DAOs.CarnectAPIDAOs.ServiceDAOs;

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
 * <p>Java class for CustomerPrimaryAdditionalType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerPrimaryAdditionalType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Primary" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}CustomerType">
 *                 &lt;sequence>
 *                   &lt;element name="CustomerID" type="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Additional" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}CustomerType">
 *                 &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Duration" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CorpDiscountName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CorpDiscountNmbr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="QualificationMethod">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="RT_AirlineTicket"/>
 *                       &lt;enumeration value="CreditCard"/>
 *                       &lt;enumeration value="PassportAndReturnTkt"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="Age" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *               &lt;/extension>
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
@XmlType(name = "CustomerPrimaryAdditionalType", propOrder = {
    "primary",
    "additional"
})
public class CustomerPrimaryAdditionalType {

    @XmlElement(name = "Primary")
    protected CustomerPrimaryAdditionalType.Primary primary;
    @XmlElement(name = "Additional")
    protected List<CustomerPrimaryAdditionalType.Additional> additional;

    /**
     * Gets the value of the primary property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerPrimaryAdditionalType.Primary }
     *     
     */
    public CustomerPrimaryAdditionalType.Primary getPrimary() {
        return primary;
    }

    /**
     * Sets the value of the primary property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerPrimaryAdditionalType.Primary }
     *     
     */
    public void setPrimary(CustomerPrimaryAdditionalType.Primary value) {
        this.primary = value;
    }

    /**
     * Gets the value of the additional property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additional property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditional().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerPrimaryAdditionalType.Additional }
     * 
     * 
     */
    public List<CustomerPrimaryAdditionalType.Additional> getAdditional() {
        if (additional == null) {
            additional = new ArrayList<CustomerPrimaryAdditionalType.Additional>();
        }
        return this.additional;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}CustomerType">
     *       &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Duration" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CorpDiscountName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CorpDiscountNmbr" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="QualificationMethod">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="RT_AirlineTicket"/>
     *             &lt;enumeration value="CreditCard"/>
     *             &lt;enumeration value="PassportAndReturnTkt"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="Age" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Additional
        extends CustomerType
    {

        @XmlAttribute(name = "Start")
        protected String start;
        @XmlAttribute(name = "Duration")
        protected String duration;
        @XmlAttribute(name = "End")
        protected String end;
        @XmlAttribute(name = "CorpDiscountName")
        protected String corpDiscountName;
        @XmlAttribute(name = "CorpDiscountNmbr")
        protected String corpDiscountNmbr;
        @XmlAttribute(name = "QualificationMethod")
        protected String qualificationMethod;
        @XmlAttribute(name = "Age")
        protected BigInteger age;
        @XmlAttribute(name = "Code")
        protected String code;
        @XmlAttribute(name = "CodeContext")
        protected String codeContext;
        @XmlAttribute(name = "URI")
        @XmlSchemaType(name = "anyURI")
        protected String uri;

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
         * Gets the value of the corpDiscountName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCorpDiscountName() {
            return corpDiscountName;
        }

        /**
         * Sets the value of the corpDiscountName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCorpDiscountName(String value) {
            this.corpDiscountName = value;
        }

        /**
         * Gets the value of the corpDiscountNmbr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCorpDiscountNmbr() {
            return corpDiscountNmbr;
        }

        /**
         * Sets the value of the corpDiscountNmbr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCorpDiscountNmbr(String value) {
            this.corpDiscountNmbr = value;
        }

        /**
         * Gets the value of the qualificationMethod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQualificationMethod() {
            return qualificationMethod;
        }

        /**
         * Sets the value of the qualificationMethod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQualificationMethod(String value) {
            this.qualificationMethod = value;
        }

        /**
         * Gets the value of the age property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getAge() {
            return age;
        }

        /**
         * Sets the value of the age property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setAge(BigInteger value) {
            this.age = value;
        }

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Gets the value of the codeContext property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodeContext() {
            return codeContext;
        }

        /**
         * Sets the value of the codeContext property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodeContext(String value) {
            this.codeContext = value;
        }

        /**
         * Gets the value of the uri property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getURI() {
            return uri;
        }

        /**
         * Sets the value of the uri property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setURI(String value) {
            this.uri = value;
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
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}CustomerType">
     *       &lt;sequence>
     *         &lt;element name="CustomerID" type="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type" minOccurs="0"/>
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
        "customerID"
    })
    public static class Primary
        extends CustomerType
    {

        @XmlElement(name = "CustomerID")
        protected UniqueIDType customerID;

        /**
         * Gets the value of the customerID property.
         * 
         * @return
         *     possible object is
         *     {@link UniqueIDType }
         *     
         */
        public UniqueIDType getCustomerID() {
            return customerID;
        }

        /**
         * Sets the value of the customerID property.
         * 
         * @param value
         *     allowed object is
         *     {@link UniqueIDType }
         *     
         */
        public void setCustomerID(UniqueIDType value) {
            this.customerID = value;
        }

    }

}
