
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpecialEquipment" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="EquipDesc" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
 *                   &lt;element name="EquipCharges" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
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
@XmlType(name = "ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment", propOrder = {
    "specialEquipment"
})
public class ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment {

    @XmlElement(name = "SpecialEquipment")
    protected List<ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment.SpecialEquipment> specialEquipment;

    /**
     * Gets the value of the specialEquipment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialEquipment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialEquipment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment.SpecialEquipment }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment.SpecialEquipment> getSpecialEquipment() {
        if (specialEquipment == null) {
            specialEquipment = new ArrayList<ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipment.SpecialEquipment>();
        }
        return this.specialEquipment;
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
     *         &lt;element name="EquipDesc" type="{http://www.opentravel.org/OTA/2003/05}FormattedTextType" minOccurs="0"/>
     *         &lt;element name="EquipCharges" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "equipDesc",
        "equipCharges"
    })
    public static class SpecialEquipment {

        @XmlElement(name = "EquipDesc")
        protected FormattedTextType equipDesc;
        @XmlElement(name = "EquipCharges")
        protected ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge equipCharges;
        @XmlAttribute(name = "Type")
        protected String type;

        /**
         * Gets the value of the equipDesc property.
         * 
         * @return
         *     possible object is
         *     {@link FormattedTextType }
         *     
         */
        public FormattedTextType getEquipDesc() {
            return equipDesc;
        }

        /**
         * Sets the value of the equipDesc property.
         * 
         * @param value
         *     allowed object is
         *     {@link FormattedTextType }
         *     
         */
        public void setEquipDesc(FormattedTextType value) {
            this.equipDesc = value;
        }

        /**
         * Gets the value of the equipCharges property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge }
         *     
         */
        public ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge getEquipCharges() {
            return equipCharges;
        }

        /**
         * Sets the value of the equipCharges property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge }
         *     
         */
        public void setEquipCharges(ArrayOfVehicleLocationServicesOfferedTypeSpecialEquipmentEquipCharge value) {
            this.equipCharges = value;
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

    }

}
