
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
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for ItemSearchCriterionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemSearchCriterionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Position" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Latitude" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Longitude" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Altitude" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="AltitudeUnitOfMeasureCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Address" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AddressType">
 *                 &lt;attribute name="SameCountryInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/extension>
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
 *         &lt;element name="RefPoint" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="StateProv" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                 &lt;attribute name="RefPointType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CityName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CodeRef" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>LocationType">
 *                 &lt;attribute name="VicinityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="HotelRef" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="SegmentCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="PropertyClassCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="ArchitecturalStyleCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="SupplierIntegrationLevel" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Radius" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Distance" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="DistanceMeasure" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Direction" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="DistanceMax" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="ExactMatch" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ImportanceType">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Mandatory"/>
 *             &lt;enumeration value="High"/>
 *             &lt;enumeration value="Medium"/>
 *             &lt;enumeration value="Low"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Ranking" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemSearchCriterionType", propOrder = {
    "position",
    "address",
    "telephone",
    "refPoint",
    "codeRef",
    "hotelRef",
    "radius"
})
public class ItemSearchCriterionType {

    @XmlElement(name = "Position")
    protected ItemSearchCriterionType.Position position;
    @XmlElement(name = "Address")
    protected ItemSearchCriterionType.Address address;
    @XmlElement(name = "Telephone")
    protected ItemSearchCriterionType.Telephone telephone;
    @XmlElement(name = "RefPoint")
    protected List<ItemSearchCriterionType.RefPoint> refPoint;
    @XmlElement(name = "CodeRef")
    protected ItemSearchCriterionType.CodeRef codeRef;
    @XmlElement(name = "HotelRef")
    protected ItemSearchCriterionType.HotelRef hotelRef;
    @XmlElement(name = "Radius")
    protected ItemSearchCriterionType.Radius radius;
    @XmlAttribute(name = "ExactMatch")
    protected Boolean exactMatch;
    @XmlAttribute(name = "ImportanceType")
    protected String importanceType;
    @XmlAttribute(name = "Ranking")
    protected BigInteger ranking;

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link ItemSearchCriterionType.Position }
     *     
     */
    public ItemSearchCriterionType.Position getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemSearchCriterionType.Position }
     *     
     */
    public void setPosition(ItemSearchCriterionType.Position value) {
        this.position = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link ItemSearchCriterionType.Address }
     *     
     */
    public ItemSearchCriterionType.Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemSearchCriterionType.Address }
     *     
     */
    public void setAddress(ItemSearchCriterionType.Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link ItemSearchCriterionType.Telephone }
     *     
     */
    public ItemSearchCriterionType.Telephone getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemSearchCriterionType.Telephone }
     *     
     */
    public void setTelephone(ItemSearchCriterionType.Telephone value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the refPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemSearchCriterionType.RefPoint }
     * 
     * 
     */
    public List<ItemSearchCriterionType.RefPoint> getRefPoint() {
        if (refPoint == null) {
            refPoint = new ArrayList<ItemSearchCriterionType.RefPoint>();
        }
        return this.refPoint;
    }

    /**
     * Gets the value of the codeRef property.
     * 
     * @return
     *     possible object is
     *     {@link ItemSearchCriterionType.CodeRef }
     *     
     */
    public ItemSearchCriterionType.CodeRef getCodeRef() {
        return codeRef;
    }

    /**
     * Sets the value of the codeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemSearchCriterionType.CodeRef }
     *     
     */
    public void setCodeRef(ItemSearchCriterionType.CodeRef value) {
        this.codeRef = value;
    }

    /**
     * Gets the value of the hotelRef property.
     * 
     * @return
     *     possible object is
     *     {@link ItemSearchCriterionType.HotelRef }
     *     
     */
    public ItemSearchCriterionType.HotelRef getHotelRef() {
        return hotelRef;
    }

    /**
     * Sets the value of the hotelRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemSearchCriterionType.HotelRef }
     *     
     */
    public void setHotelRef(ItemSearchCriterionType.HotelRef value) {
        this.hotelRef = value;
    }

    /**
     * Gets the value of the radius property.
     * 
     * @return
     *     possible object is
     *     {@link ItemSearchCriterionType.Radius }
     *     
     */
    public ItemSearchCriterionType.Radius getRadius() {
        return radius;
    }

    /**
     * Sets the value of the radius property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemSearchCriterionType.Radius }
     *     
     */
    public void setRadius(ItemSearchCriterionType.Radius value) {
        this.radius = value;
    }

    /**
     * Gets the value of the exactMatch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExactMatch() {
        return exactMatch;
    }

    /**
     * Sets the value of the exactMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExactMatch(Boolean value) {
        this.exactMatch = value;
    }

    /**
     * Gets the value of the importanceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportanceType() {
        return importanceType;
    }

    /**
     * Sets the value of the importanceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportanceType(String value) {
        this.importanceType = value;
    }

    /**
     * Gets the value of the ranking property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRanking() {
        return ranking;
    }

    /**
     * Sets the value of the ranking property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRanking(BigInteger value) {
        this.ranking = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AddressType">
     *       &lt;attribute name="SameCountryInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Address
        extends AddressType
    {

        @XmlAttribute(name = "SameCountryInd")
        protected Boolean sameCountryInd;

        /**
         * Gets the value of the sameCountryInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isSameCountryInd() {
            return sameCountryInd;
        }

        /**
         * Sets the value of the sameCountryInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setSameCountryInd(Boolean value) {
            this.sameCountryInd = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>LocationType">
     *       &lt;attribute name="VicinityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CodeRef
        extends LocationType
    {

        @XmlAttribute(name = "VicinityCode")
        protected String vicinityCode;

        /**
         * Gets the value of the vicinityCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVicinityCode() {
            return vicinityCode;
        }

        /**
         * Sets the value of the vicinityCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVicinityCode(String value) {
            this.vicinityCode = value;
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
     *       &lt;attribute name="ChainCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="BrandCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="HotelCityCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="HotelName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="HotelCodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ChainName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="BrandName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="SegmentCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="PropertyClassCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="ArchitecturalStyleCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="SupplierIntegrationLevel" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class HotelRef {

        @XmlAttribute(name = "ChainCode")
        protected String chainCode;
        @XmlAttribute(name = "BrandCode")
        protected String brandCode;
        @XmlAttribute(name = "HotelCode")
        protected String hotelCode;
        @XmlAttribute(name = "HotelCityCode")
        protected String hotelCityCode;
        @XmlAttribute(name = "HotelName")
        protected String hotelName;
        @XmlAttribute(name = "HotelCodeContext")
        protected String hotelCodeContext;
        @XmlAttribute(name = "ChainName")
        protected String chainName;
        @XmlAttribute(name = "BrandName")
        protected String brandName;
        @XmlAttribute(name = "SegmentCategoryCode")
        protected String segmentCategoryCode;
        @XmlAttribute(name = "PropertyClassCode")
        protected String propertyClassCode;
        @XmlAttribute(name = "ArchitecturalStyleCode")
        protected String architecturalStyleCode;
        @XmlAttribute(name = "SupplierIntegrationLevel")
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger supplierIntegrationLevel;

        /**
         * Gets the value of the chainCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getChainCode() {
            return chainCode;
        }

        /**
         * Sets the value of the chainCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setChainCode(String value) {
            this.chainCode = value;
        }

        /**
         * Gets the value of the brandCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrandCode() {
            return brandCode;
        }

        /**
         * Sets the value of the brandCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrandCode(String value) {
            this.brandCode = value;
        }

        /**
         * Gets the value of the hotelCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHotelCode() {
            return hotelCode;
        }

        /**
         * Sets the value of the hotelCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHotelCode(String value) {
            this.hotelCode = value;
        }

        /**
         * Gets the value of the hotelCityCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHotelCityCode() {
            return hotelCityCode;
        }

        /**
         * Sets the value of the hotelCityCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHotelCityCode(String value) {
            this.hotelCityCode = value;
        }

        /**
         * Gets the value of the hotelName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHotelName() {
            return hotelName;
        }

        /**
         * Sets the value of the hotelName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHotelName(String value) {
            this.hotelName = value;
        }

        /**
         * Gets the value of the hotelCodeContext property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHotelCodeContext() {
            return hotelCodeContext;
        }

        /**
         * Sets the value of the hotelCodeContext property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHotelCodeContext(String value) {
            this.hotelCodeContext = value;
        }

        /**
         * Gets the value of the chainName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getChainName() {
            return chainName;
        }

        /**
         * Sets the value of the chainName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setChainName(String value) {
            this.chainName = value;
        }

        /**
         * Gets the value of the brandName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBrandName() {
            return brandName;
        }

        /**
         * Sets the value of the brandName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBrandName(String value) {
            this.brandName = value;
        }

        /**
         * Gets the value of the segmentCategoryCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSegmentCategoryCode() {
            return segmentCategoryCode;
        }

        /**
         * Sets the value of the segmentCategoryCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSegmentCategoryCode(String value) {
            this.segmentCategoryCode = value;
        }

        /**
         * Gets the value of the propertyClassCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPropertyClassCode() {
            return propertyClassCode;
        }

        /**
         * Sets the value of the propertyClassCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPropertyClassCode(String value) {
            this.propertyClassCode = value;
        }

        /**
         * Gets the value of the architecturalStyleCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getArchitecturalStyleCode() {
            return architecturalStyleCode;
        }

        /**
         * Sets the value of the architecturalStyleCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setArchitecturalStyleCode(String value) {
            this.architecturalStyleCode = value;
        }

        /**
         * Gets the value of the supplierIntegrationLevel property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSupplierIntegrationLevel() {
            return supplierIntegrationLevel;
        }

        /**
         * Sets the value of the supplierIntegrationLevel property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSupplierIntegrationLevel(BigInteger value) {
            this.supplierIntegrationLevel = value;
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
     *       &lt;attribute name="Latitude" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Longitude" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Altitude" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="AltitudeUnitOfMeasureCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Position {

        @XmlAttribute(name = "Latitude")
        protected String latitude;
        @XmlAttribute(name = "Longitude")
        protected String longitude;
        @XmlAttribute(name = "Altitude")
        protected String altitude;
        @XmlAttribute(name = "AltitudeUnitOfMeasureCode")
        protected String altitudeUnitOfMeasureCode;

        /**
         * Gets the value of the latitude property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLatitude() {
            return latitude;
        }

        /**
         * Sets the value of the latitude property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLatitude(String value) {
            this.latitude = value;
        }

        /**
         * Gets the value of the longitude property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLongitude() {
            return longitude;
        }

        /**
         * Sets the value of the longitude property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLongitude(String value) {
            this.longitude = value;
        }

        /**
         * Gets the value of the altitude property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAltitude() {
            return altitude;
        }

        /**
         * Sets the value of the altitude property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAltitude(String value) {
            this.altitude = value;
        }

        /**
         * Gets the value of the altitudeUnitOfMeasureCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAltitudeUnitOfMeasureCode() {
            return altitudeUnitOfMeasureCode;
        }

        /**
         * Sets the value of the altitudeUnitOfMeasureCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAltitudeUnitOfMeasureCode(String value) {
            this.altitudeUnitOfMeasureCode = value;
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
     *       &lt;attribute name="Distance" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="DistanceMeasure" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Direction" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="DistanceMax" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Radius {

        @XmlAttribute(name = "Distance")
        protected String distance;
        @XmlAttribute(name = "DistanceMeasure")
        protected String distanceMeasure;
        @XmlAttribute(name = "Direction")
        protected String direction;
        @XmlAttribute(name = "DistanceMax")
        protected String distanceMax;

        /**
         * Gets the value of the distance property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDistance() {
            return distance;
        }

        /**
         * Sets the value of the distance property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDistance(String value) {
            this.distance = value;
        }

        /**
         * Gets the value of the distanceMeasure property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDistanceMeasure() {
            return distanceMeasure;
        }

        /**
         * Sets the value of the distanceMeasure property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDistanceMeasure(String value) {
            this.distanceMeasure = value;
        }

        /**
         * Gets the value of the direction property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDirection() {
            return direction;
        }

        /**
         * Sets the value of the direction property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDirection(String value) {
            this.direction = value;
        }

        /**
         * Gets the value of the distanceMax property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDistanceMax() {
            return distanceMax;
        }

        /**
         * Sets the value of the distanceMax property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDistanceMax(String value) {
            this.distanceMax = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="StateProv" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *       &lt;attribute name="RefPointType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CityName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class RefPoint {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "StateProv")
        protected String stateProv;
        @XmlAttribute(name = "CountryCode")
        protected String countryCode;
        @XmlAttribute(name = "URI")
        @XmlSchemaType(name = "anyURI")
        protected String uri;
        @XmlAttribute(name = "RefPointType")
        protected String refPointType;
        @XmlAttribute(name = "Name")
        protected String name;
        @XmlAttribute(name = "CityName")
        protected String cityName;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the stateProv property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStateProv() {
            return stateProv;
        }

        /**
         * Sets the value of the stateProv property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStateProv(String value) {
            this.stateProv = value;
        }

        /**
         * Gets the value of the countryCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCountryCode() {
            return countryCode;
        }

        /**
         * Sets the value of the countryCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCountryCode(String value) {
            this.countryCode = value;
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

        /**
         * Gets the value of the refPointType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRefPointType() {
            return refPointType;
        }

        /**
         * Sets the value of the refPointType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRefPointType(String value) {
            this.refPointType = value;
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
         * Gets the value of the cityName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCityName() {
            return cityName;
        }

        /**
         * Sets the value of the cityName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCityName(String value) {
            this.cityName = value;
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
