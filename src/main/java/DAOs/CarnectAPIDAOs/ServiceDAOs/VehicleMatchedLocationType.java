
package DAOs.CarnectAPIDAOs.ServiceDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleMatchedLocationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleMatchedLocationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LocationDetail" type="{http://www.opentravel.org/OTA/2003/05}VehicleLocationDetailsType" minOccurs="0"/>
 *         &lt;element name="VehLocSearchCriterion" type="{http://www.opentravel.org/OTA/2003/05}ItemSearchCriterionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AlternateLocInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleMatchedLocationType", propOrder = {
    "locationDetail",
    "vehLocSearchCriterion"
})
public class VehicleMatchedLocationType {

    @XmlElement(name = "LocationDetail")
    protected VehicleLocationDetailsType locationDetail;
    @XmlElement(name = "VehLocSearchCriterion")
    protected List<ItemSearchCriterionType> vehLocSearchCriterion;
    @XmlAttribute(name = "AlternateLocInd")
    protected Boolean alternateLocInd;

    /**
     * Gets the value of the locationDetail property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleLocationDetailsType }
     *     
     */
    public VehicleLocationDetailsType getLocationDetail() {
        return locationDetail;
    }

    /**
     * Sets the value of the locationDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleLocationDetailsType }
     *     
     */
    public void setLocationDetail(VehicleLocationDetailsType value) {
        this.locationDetail = value;
    }

    /**
     * Gets the value of the vehLocSearchCriterion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehLocSearchCriterion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehLocSearchCriterion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemSearchCriterionType }
     * 
     * 
     */
    public List<ItemSearchCriterionType> getVehLocSearchCriterion() {
        if (vehLocSearchCriterion == null) {
            vehLocSearchCriterion = new ArrayList<ItemSearchCriterionType>();
        }
        return this.vehLocSearchCriterion;
    }

    /**
     * Gets the value of the alternateLocInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAlternateLocInd() {
        return alternateLocInd;
    }

    /**
     * Sets the value of the alternateLocInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAlternateLocInd(Boolean value) {
        this.alternateLocInd = value;
    }

}
