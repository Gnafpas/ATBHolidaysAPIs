
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehicleLocationAdditionalDetailsTypeShuttleShuttleInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehicleLocationAdditionalDetailsTypeShuttleShuttleInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShuttleInfo" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}FormattedTextType">
 *                 &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}LocationDetailShuttleInfoType" />
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
@XmlType(name = "ArrayOfVehicleLocationAdditionalDetailsTypeShuttleShuttleInfo", propOrder = {
    "shuttleInfo"
})
public class ArrayOfVehicleLocationAdditionalDetailsTypeShuttleShuttleInfo {

    @XmlElement(name = "ShuttleInfo")
    protected List<ArrayOfVehicleLocationAdditionalDetailsTypeShuttleShuttleInfo.ShuttleInfo> shuttleInfo;

    /**
     * Gets the value of the shuttleInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shuttleInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShuttleInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfVehicleLocationAdditionalDetailsTypeShuttleShuttleInfo.ShuttleInfo }
     * 
     * 
     */
    public List<ArrayOfVehicleLocationAdditionalDetailsTypeShuttleShuttleInfo.ShuttleInfo> getShuttleInfo() {
        if (shuttleInfo == null) {
            shuttleInfo = new ArrayList<ArrayOfVehicleLocationAdditionalDetailsTypeShuttleShuttleInfo.ShuttleInfo>();
        }
        return this.shuttleInfo;
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
     *       &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}LocationDetailShuttleInfoType" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ShuttleInfo
        extends FormattedTextType
    {

        @XmlAttribute(name = "Type", required = true)
        protected LocationDetailShuttleInfoType type;

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link LocationDetailShuttleInfoType }
         *     
         */
        public LocationDetailShuttleInfoType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link LocationDetailShuttleInfoType }
         *     
         */
        public void setType(LocationDetailShuttleInfoType value) {
            this.type = value;
        }

    }

}
