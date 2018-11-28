
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleTourInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleTourInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TourOperator" type="{http://www.opentravel.org/OTA/2003/05}CompanyNameType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TourNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleTourInfoType", propOrder = {
    "tourOperator"
})
public class VehicleTourInfoType {

    @XmlElement(name = "TourOperator")
    protected CompanyNameType tourOperator;
    @XmlAttribute(name = "TourNumber")
    protected String tourNumber;

    /**
     * Gets the value of the tourOperator property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyNameType }
     *     
     */
    public CompanyNameType getTourOperator() {
        return tourOperator;
    }

    /**
     * Sets the value of the tourOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyNameType }
     *     
     */
    public void setTourOperator(CompanyNameType value) {
        this.tourOperator = value;
    }

    /**
     * Gets the value of the tourNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTourNumber() {
        return tourNumber;
    }

    /**
     * Sets the value of the tourNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTourNumber(String value) {
        this.tourNumber = value;
    }

}
