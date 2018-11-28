
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationServicesOfferedTypeOnLocationService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationServicesOfferedTypeOnLocationService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OnLocationService" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OnLocServiceDesc" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}FormattedTextType">
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="OperationSchedules" type="{http://www.opentravel.org/OTA/2003/05}OperationSchedulesType" minOccurs="0"/>
 *                   &lt;element name="OnLocServiceCharges" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationServicesOfferedTypeOnLocationServiceOnLocServiceCharge" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}OnLocationServiceID_Type" />
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
@XmlType(name = "ArrayOfVehicleLocationServicesOfferedTypeOnLocationService", propOrder = {
    "onLocationService"
})
public class ArrayOfVehicleLocationServicesOfferedTypeOnLocationService {

    @XmlElement(name = "OnLocationService")
    protected List<ArrayOfVehicleLocationServicesOfferedTypeOnLocationService.OnLocationService> onLocationService;

    /**
     * Gets the value of the onLocationService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the onLocationService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOnLocationService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationServicesOfferedTypeOnLocationService.OnLocationService }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationServicesOfferedTypeOnLocationService.OnLocationService> getOnLocationService() {
        if (onLocationService == null) {
            onLocationService = new ArrayList<ArrayOfVehicleLocationServicesOfferedTypeOnLocationService.OnLocationService>();
        }
        return this.onLocationService;
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
     *         &lt;element name="OnLocServiceDesc" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}FormattedTextType">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="OperationSchedules" type="{http://www.opentravel.org/OTA/2003/05}OperationSchedulesType" minOccurs="0"/>
     *         &lt;element name="OnLocServiceCharges" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationServicesOfferedTypeOnLocationServiceOnLocServiceCharge" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}OnLocationServiceID_Type" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "onLocServiceDesc",
        "operationSchedules",
        "onLocServiceCharges"
    })
    public static class OnLocationService {

        @XmlElement(name = "OnLocServiceDesc")
        protected ArrayOfVehicleLocationServicesOfferedTypeOnLocationService.OnLocationService.OnLocServiceDesc onLocServiceDesc;
        @XmlElement(name = "OperationSchedules")
        protected OperationSchedulesType operationSchedules;
        @XmlElement(name = "OnLocServiceCharges")
        protected ArrayOfVehicleLocationServicesOfferedTypeOnLocationServiceOnLocServiceCharge onLocServiceCharges;
        @XmlAttribute(name = "Type", required = true)
        protected OnLocationServiceIDType type;

        /**
         * Gets the value of the onLocServiceDesc property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfVehicleLocationServicesOfferedTypeOnLocationService.OnLocationService.OnLocServiceDesc }
         *     
         */
        public ArrayOfVehicleLocationServicesOfferedTypeOnLocationService.OnLocationService.OnLocServiceDesc getOnLocServiceDesc() {
            return onLocServiceDesc;
        }

        /**
         * Sets the value of the onLocServiceDesc property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfVehicleLocationServicesOfferedTypeOnLocationService.OnLocationService.OnLocServiceDesc }
         *     
         */
        public void setOnLocServiceDesc(ArrayOfVehicleLocationServicesOfferedTypeOnLocationService.OnLocationService.OnLocServiceDesc value) {
            this.onLocServiceDesc = value;
        }

        /**
         * Gets the value of the operationSchedules property.
         * 
         * @return
         *     possible object is
         *     {@link OperationSchedulesType }
         *     
         */
        public OperationSchedulesType getOperationSchedules() {
            return operationSchedules;
        }

        /**
         * Sets the value of the operationSchedules property.
         * 
         * @param value
         *     allowed object is
         *     {@link OperationSchedulesType }
         *     
         */
        public void setOperationSchedules(OperationSchedulesType value) {
            this.operationSchedules = value;
        }

        /**
         * Gets the value of the onLocServiceCharges property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfVehicleLocationServicesOfferedTypeOnLocationServiceOnLocServiceCharge }
         *     
         */
        public ArrayOfVehicleLocationServicesOfferedTypeOnLocationServiceOnLocServiceCharge getOnLocServiceCharges() {
            return onLocServiceCharges;
        }

        /**
         * Sets the value of the onLocServiceCharges property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfVehicleLocationServicesOfferedTypeOnLocationServiceOnLocServiceCharge }
         *     
         */
        public void setOnLocServiceCharges(ArrayOfVehicleLocationServicesOfferedTypeOnLocationServiceOnLocServiceCharge value) {
            this.onLocServiceCharges = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link OnLocationServiceIDType }
         *     
         */
        public OnLocationServiceIDType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link OnLocationServiceIDType }
         *     
         */
        public void setType(OnLocationServiceIDType value) {
            this.type = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}FormattedTextType">
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class OnLocServiceDesc
            extends FormattedTextType
        {


        }

    }

}
