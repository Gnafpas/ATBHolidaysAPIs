
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleLocationDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleLocationDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.opentravel.org/OTA/2003/05}AddressInfoType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Telephone" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="PhoneTechType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RPH" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AdditionalInfo" type="{http://www.opentravel.org/OTA/2003/05}VehicleLocationAdditionalDetailsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AtAirport" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ExtendedLocationCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AssocAirportLocList">
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
@XmlType(name = "VehicleLocationDetailsType", propOrder = {
    "address",
    "telephone",
    "additionalInfo"
})
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehRateRuleRS.LocationDetails.class
})
public class VehicleLocationDetailsType {

    @XmlElement(name = "Address")
    protected List<AddressInfoType> address;
    @XmlElement(name = "Telephone")
    protected List<VehicleLocationDetailsType.Telephone> telephone;
    @XmlElement(name = "AdditionalInfo")
    protected VehicleLocationAdditionalDetailsType additionalInfo;
    @XmlAttribute(name = "AtAirport")
    protected Boolean atAirport;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "CodeContext")
    protected String codeContext;
    @XmlAttribute(name = "ExtendedLocationCode")
    protected String extendedLocationCode;
    @XmlAttribute(name = "AssocAirportLocList")
    protected List<String> assocAirportLocList;

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressInfoType }
     * 
     * 
     */
    public List<AddressInfoType> getAddress() {
        if (address == null) {
            address = new ArrayList<AddressInfoType>();
        }
        return this.address;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the telephone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTelephone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleLocationDetailsType.Telephone }
     * 
     * 
     */
    public List<VehicleLocationDetailsType.Telephone> getTelephone() {
        if (telephone == null) {
            telephone = new ArrayList<VehicleLocationDetailsType.Telephone>();
        }
        return this.telephone;
    }

    /**
     * Gets the value of the additionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationAdditionalDetailsType }
     *     
     */
    public VehicleLocationAdditionalDetailsType getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the value of the additionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationAdditionalDetailsType }
     *     
     */
    public void setAdditionalInfo(VehicleLocationAdditionalDetailsType value) {
        this.additionalInfo = value;
    }

    /**
     * Gets the value of the atAirport property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAtAirport() {
        return atAirport;
    }

    /**
     * Sets the value of the atAirport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAtAirport(Boolean value) {
        this.atAirport = value;
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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the extendedLocationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtendedLocationCode() {
        return extendedLocationCode;
    }

    /**
     * Sets the value of the extendedLocationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtendedLocationCode(String value) {
        this.extendedLocationCode = value;
    }

    /**
     * Gets the value of the assocAirportLocList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assocAirportLocList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssocAirportLocList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAssocAirportLocList() {
        if (assocAirportLocList == null) {
            assocAirportLocList = new ArrayList<String>();
        }
        return this.assocAirportLocList;
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
     *       &lt;attribute name="PhoneTechType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RPH" type="{http://www.w3.org/2001/XMLSchema}string" />
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

        @XmlAttribute(name = "PhoneTechType")
        protected String phoneTechType;
        @XmlAttribute(name = "PhoneNumber")
        protected String phoneNumber;
        @XmlAttribute(name = "RPH")
        protected String rph;

        /**
         * Gets the value of the phoneTechType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPhoneTechType() {
            return phoneTechType;
        }

        /**
         * Sets the value of the phoneTechType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPhoneTechType(String value) {
            this.phoneTechType = value;
        }

        /**
         * Gets the value of the phoneNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPhoneNumber() {
            return phoneNumber;
        }

        /**
         * Sets the value of the phoneNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPhoneNumber(String value) {
            this.phoneNumber = value;
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

    }

}
