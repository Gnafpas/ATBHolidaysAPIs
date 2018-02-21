
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationLiabilitiesTypeCoverage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationLiabilitiesTypeCoverage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Coverage" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CoverageInfo" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                   &lt;element name="CoverageFees" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="RequiredInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
@XmlType(name = "ArrayOfVehicleLocationLiabilitiesTypeCoverage", propOrder = {
    "coverage"
})
public class ArrayOfVehicleLocationLiabilitiesTypeCoverage {

    @XmlElement(name = "Coverage")
    protected List<ArrayOfVehicleLocationLiabilitiesTypeCoverage.Coverage> coverage;

    /**
     * Gets the value of the coverage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coverage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoverage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationLiabilitiesTypeCoverage.Coverage }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationLiabilitiesTypeCoverage.Coverage> getCoverage() {
        if (coverage == null) {
            coverage = new ArrayList<ArrayOfVehicleLocationLiabilitiesTypeCoverage.Coverage>();
        }
        return this.coverage;
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
     *         &lt;element name="CoverageInfo" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *         &lt;element name="CoverageFees" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="RequiredInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "coverageInfo",
        "coverageFees"
    })
    public static class Coverage {

        @XmlElement(name = "CoverageInfo")
        protected FormattedTextType coverageInfo;
        @XmlElement(name = "CoverageFees")
        protected ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee coverageFees;
        @XmlAttribute(name = "Type")
        protected String type;
        @XmlAttribute(name = "RequiredInd")
        protected Boolean requiredInd;

        /**
         * Gets the value of the coverageInfo property.
         * 
         * @return
         *     possible object is
         *     {@link FormattedTextType }
         *     
         */
        public FormattedTextType getCoverageInfo() {
            return coverageInfo;
        }

        /**
         * Sets the value of the coverageInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link FormattedTextType }
         *     
         */
        public void setCoverageInfo(FormattedTextType value) {
            this.coverageInfo = value;
        }

        /**
         * Gets the value of the coverageFees property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee }
         *     
         */
        public ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee getCoverageFees() {
            return coverageFees;
        }

        /**
         * Sets the value of the coverageFees property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee }
         *     
         */
        public void setCoverageFees(ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFee value) {
            this.coverageFees = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Gets the value of the requiredInd property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isRequiredInd() {
            return requiredInd;
        }

        /**
         * Sets the value of the requiredInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setRequiredInd(Boolean value) {
            this.requiredInd = value;
        }

    }

}
