
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for VehicleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}VehicleCoreType">
 *       &lt;sequence>
 *         &lt;element name="VehMakeModel" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="ModelYear" type="{http://www.w3.org/2001/XMLSchema}gYear" />
 *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PictureURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="VehIdentity" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="VehicleAssetNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="LicensePlateNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="StateProvCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="VehicleID_Number" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="VehicleColor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="PassengerQuantity" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BaggageQuantity" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="VendorCarType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CodeContext" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="UnitOfMeasureQuantity" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="UnitOfMeasure" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="UnitOfMeasureCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Duration" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OdometerUnitOfMeasure" type="{http://www.opentravel.org/OTA/2003/05}DistanceUnitNameType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleType", propOrder = {
    "vehMakeModel",
    "pictureURL",
    "vehIdentity"
})
@XmlSeeAlso({
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehicleLocationVehiclesType.Vehicle.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.VehRateRuleRS.Vehicle.class,
        DAOs.CarnectAPIDAOs.ServiceDAOs.ArrayOfVehicleLocationLiabilitiesTypeCoverageCoverageFeeVehicle.Vehicle.class
})
public class VehicleType
    extends VehicleCoreType
{

    @XmlElement(name = "VehMakeModel")
    protected VehicleType.VehMakeModel vehMakeModel;
    @XmlElement(name = "PictureURL")
    @XmlSchemaType(name = "anyURI")
    protected String pictureURL;
    @XmlElement(name = "VehIdentity")
    protected VehicleType.VehIdentity vehIdentity;
    @XmlAttribute(name = "PassengerQuantity")
    protected String passengerQuantity;
    @XmlAttribute(name = "BaggageQuantity")
    protected BigInteger baggageQuantity;
    @XmlAttribute(name = "VendorCarType")
    protected String vendorCarType;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "CodeContext")
    protected String codeContext;
    @XmlAttribute(name = "UnitOfMeasureQuantity")
    protected BigDecimal unitOfMeasureQuantity;
    @XmlAttribute(name = "UnitOfMeasure")
    protected String unitOfMeasure;
    @XmlAttribute(name = "UnitOfMeasureCode")
    protected String unitOfMeasureCode;
    @XmlAttribute(name = "Start")
    protected String start;
    @XmlAttribute(name = "Duration")
    protected String duration;
    @XmlAttribute(name = "End")
    protected String end;
    @XmlAttribute(name = "OdometerUnitOfMeasure")
    protected DistanceUnitNameType odometerUnitOfMeasure;

    /**
     * Gets the value of the vehMakeModel property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleType.VehMakeModel }
     *     
     */
    public VehicleType.VehMakeModel getVehMakeModel() {
        return vehMakeModel;
    }

    /**
     * Sets the value of the vehMakeModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleType.VehMakeModel }
     *     
     */
    public void setVehMakeModel(VehicleType.VehMakeModel value) {
        this.vehMakeModel = value;
    }

    /**
     * Gets the value of the pictureURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPictureURL() {
        return pictureURL;
    }

    /**
     * Sets the value of the pictureURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureURL(String value) {
        this.pictureURL = value;
    }

    /**
     * Gets the value of the vehIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleType.VehIdentity }
     *     
     */
    public VehicleType.VehIdentity getVehIdentity() {
        return vehIdentity;
    }

    /**
     * Sets the value of the vehIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleType.VehIdentity }
     *     
     */
    public void setVehIdentity(VehicleType.VehIdentity value) {
        this.vehIdentity = value;
    }

    /**
     * Gets the value of the passengerQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerQuantity() {
        return passengerQuantity;
    }

    /**
     * Sets the value of the passengerQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerQuantity(String value) {
        this.passengerQuantity = value;
    }

    /**
     * Gets the value of the baggageQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBaggageQuantity() {
        return baggageQuantity;
    }

    /**
     * Sets the value of the baggageQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBaggageQuantity(BigInteger value) {
        this.baggageQuantity = value;
    }

    /**
     * Gets the value of the vendorCarType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorCarType() {
        return vendorCarType;
    }

    /**
     * Sets the value of the vendorCarType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorCarType(String value) {
        this.vendorCarType = value;
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
     * Gets the value of the unitOfMeasureQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitOfMeasureQuantity() {
        return unitOfMeasureQuantity;
    }

    /**
     * Sets the value of the unitOfMeasureQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitOfMeasureQuantity(BigDecimal value) {
        this.unitOfMeasureQuantity = value;
    }

    /**
     * Gets the value of the unitOfMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     * Sets the value of the unitOfMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitOfMeasure(String value) {
        this.unitOfMeasure = value;
    }

    /**
     * Gets the value of the unitOfMeasureCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitOfMeasureCode() {
        return unitOfMeasureCode;
    }

    /**
     * Sets the value of the unitOfMeasureCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitOfMeasureCode(String value) {
        this.unitOfMeasureCode = value;
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
     * Gets the value of the odometerUnitOfMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link DistanceUnitNameType }
     *     
     */
    public DistanceUnitNameType getOdometerUnitOfMeasure() {
        return odometerUnitOfMeasure;
    }

    /**
     * Sets the value of the odometerUnitOfMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistanceUnitNameType }
     *     
     */
    public void setOdometerUnitOfMeasure(DistanceUnitNameType value) {
        this.odometerUnitOfMeasure = value;
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
     *       &lt;attribute name="VehicleAssetNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="LicensePlateNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="StateProvCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="VehicleID_Number" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="VehicleColor" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class VehIdentity {

        @XmlAttribute(name = "VehicleAssetNumber")
        protected String vehicleAssetNumber;
        @XmlAttribute(name = "LicensePlateNumber")
        protected String licensePlateNumber;
        @XmlAttribute(name = "StateProvCode")
        protected String stateProvCode;
        @XmlAttribute(name = "CountryCode")
        protected String countryCode;
        @XmlAttribute(name = "VehicleID_Number")
        protected String vehicleIDNumber;
        @XmlAttribute(name = "VehicleColor")
        protected String vehicleColor;

        /**
         * Gets the value of the vehicleAssetNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVehicleAssetNumber() {
            return vehicleAssetNumber;
        }

        /**
         * Sets the value of the vehicleAssetNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVehicleAssetNumber(String value) {
            this.vehicleAssetNumber = value;
        }

        /**
         * Gets the value of the licensePlateNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLicensePlateNumber() {
            return licensePlateNumber;
        }

        /**
         * Sets the value of the licensePlateNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLicensePlateNumber(String value) {
            this.licensePlateNumber = value;
        }

        /**
         * Gets the value of the stateProvCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStateProvCode() {
            return stateProvCode;
        }

        /**
         * Sets the value of the stateProvCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStateProvCode(String value) {
            this.stateProvCode = value;
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
         * Gets the value of the vehicleIDNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVehicleIDNumber() {
            return vehicleIDNumber;
        }

        /**
         * Sets the value of the vehicleIDNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVehicleIDNumber(String value) {
            this.vehicleIDNumber = value;
        }

        /**
         * Gets the value of the vehicleColor property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVehicleColor() {
            return vehicleColor;
        }

        /**
         * Sets the value of the vehicleColor property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVehicleColor(String value) {
            this.vehicleColor = value;
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
     *       &lt;attribute name="ModelYear" type="{http://www.w3.org/2001/XMLSchema}gYear" />
     *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class VehMakeModel {

        @XmlAttribute(name = "ModelYear")
        @XmlSchemaType(name = "gYear")
        protected XMLGregorianCalendar modelYear;
        @XmlAttribute(name = "Name")
        protected String name;
        @XmlAttribute(name = "Code")
        protected String code;

        /**
         * Gets the value of the modelYear property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getModelYear() {
            return modelYear;
        }

        /**
         * Sets the value of the modelYear property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setModelYear(XMLGregorianCalendar value) {
            this.modelYear = value;
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

    }

}
