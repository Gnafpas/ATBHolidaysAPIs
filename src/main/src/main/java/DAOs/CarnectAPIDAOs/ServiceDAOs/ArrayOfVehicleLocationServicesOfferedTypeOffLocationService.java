
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationServicesOfferedTypeOffLocationService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationServicesOfferedTypeOffLocationService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OffLocationService" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OffLocServiceDesc" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.opentravel.org/OTA/2003/05}FormattedTextType">
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="OperationSchedules" type="{http://www.opentravel.org/OTA/2003/05}OperationSchedulesType" minOccurs="0"/>
 *                   &lt;element name="OffLocServiceCharges" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}OffLocationServiceID_Type" />
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
@XmlType(name = "ArrayOfVehicleLocationServicesOfferedTypeOffLocationService", propOrder = {
    "offLocationService"
})
public class ArrayOfVehicleLocationServicesOfferedTypeOffLocationService {

    @XmlElement(name = "OffLocationService")
    protected List<ArrayOfVehicleLocationServicesOfferedTypeOffLocationService.OffLocationService> offLocationService;

    /**
     * Gets the value of the offLocationService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offLocationService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffLocationService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationServicesOfferedTypeOffLocationService.OffLocationService }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationServicesOfferedTypeOffLocationService.OffLocationService> getOffLocationService() {
        if (offLocationService == null) {
            offLocationService = new ArrayList<ArrayOfVehicleLocationServicesOfferedTypeOffLocationService.OffLocationService>();
        }
        return this.offLocationService;
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
     *         &lt;element name="OffLocServiceDesc" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}FormattedTextType">
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="OperationSchedules" type="{http://www.opentravel.org/OTA/2003/05}OperationSchedulesType" minOccurs="0"/>
     *         &lt;element name="OffLocServiceCharges" type="{http://www.opentravel.org/OTA/2003/05}ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}OffLocationServiceID_Type" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "offLocServiceDesc",
        "operationSchedules",
        "offLocServiceCharges"
    })
    public static class OffLocationService {

        @XmlElement(name = "OffLocServiceDesc")
        protected ArrayOfVehicleLocationServicesOfferedTypeOffLocationService.OffLocationService.OffLocServiceDesc offLocServiceDesc;
        @XmlElement(name = "OperationSchedules")
        protected OperationSchedulesType operationSchedules;
        @XmlElement(name = "OffLocServiceCharges")
        protected ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge offLocServiceCharges;
        @XmlAttribute(name = "Type", required = true)
        protected OffLocationServiceIDType type;

        /**
         * Gets the value of the offLocServiceDesc property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfVehicleLocationServicesOfferedTypeOffLocationService.OffLocationService.OffLocServiceDesc }
         *     
         */
        public ArrayOfVehicleLocationServicesOfferedTypeOffLocationService.OffLocationService.OffLocServiceDesc getOffLocServiceDesc() {
            return offLocServiceDesc;
        }

        /**
         * Sets the value of the offLocServiceDesc property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfVehicleLocationServicesOfferedTypeOffLocationService.OffLocationService.OffLocServiceDesc }
         *     
         */
        public void setOffLocServiceDesc(ArrayOfVehicleLocationServicesOfferedTypeOffLocationService.OffLocationService.OffLocServiceDesc value) {
            this.offLocServiceDesc = value;
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
         * Gets the value of the offLocServiceCharges property.
         * 
         * @return
         *     possible object is
         *     {@link ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge }
         *     
         */
        public ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge getOffLocServiceCharges() {
            return offLocServiceCharges;
        }

        /**
         * Sets the value of the offLocServiceCharges property.
         * 
         * @param value
         *     allowed object is
         *     {@link ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge }
         *     
         */
        public void setOffLocServiceCharges(ArrayOfVehicleLocationServicesOfferedTypeOffLocationServiceOffLocServiceCharge value) {
            this.offLocServiceCharges = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link OffLocationServiceIDType }
         *     
         */
        public OffLocationServiceIDType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link OffLocationServiceIDType }
         *     
         */
        public void setType(OffLocationServiceIDType value) {
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
        public static class OffLocServiceDesc
            extends FormattedTextType
        {


        }

    }

}
