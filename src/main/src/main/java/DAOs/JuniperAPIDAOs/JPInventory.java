
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Inventory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Inventory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelAllotment" type="{http://www.juniper.es/webservice/2007/}JP_HotelAllotmentRS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="HotelRates" type="{http://www.juniper.es/webservice/2007/}JP_HotelRatesRS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="HotelSpecifications" type="{http://www.juniper.es/webservice/2007/}JPSOAP_HotelInventoryHotel" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="HotelListInventory" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelInventorySimpleInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Inventory", propOrder = {
    "hotelAllotment",
    "hotelRates",
    "hotelSpecifications",
    "hotelListInventory"
})
public class JPInventory {

    @XmlElement(name = "HotelAllotment")
    protected List<JPHotelAllotmentRS> hotelAllotment;
    @XmlElement(name = "HotelRates")
    protected List<JPHotelRatesRS> hotelRates;
    @XmlElement(name = "HotelSpecifications")
    protected List<JPSOAPHotelInventoryHotel> hotelSpecifications;
    @XmlElement(name = "HotelListInventory")
    protected ArrayOfJPHotelInventorySimpleInfo hotelListInventory;

    /**
     * Gets the value of the hotelAllotment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelAllotment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelAllotment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPHotelAllotmentRS }
     * 
     * 
     */
    public List<JPHotelAllotmentRS> getHotelAllotment() {
        if (hotelAllotment == null) {
            hotelAllotment = new ArrayList<JPHotelAllotmentRS>();
        }
        return this.hotelAllotment;
    }

    /**
     * Gets the value of the hotelRates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelRates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelRates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPHotelRatesRS }
     * 
     * 
     */
    public List<JPHotelRatesRS> getHotelRates() {
        if (hotelRates == null) {
            hotelRates = new ArrayList<JPHotelRatesRS>();
        }
        return this.hotelRates;
    }

    /**
     * Gets the value of the hotelSpecifications property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelSpecifications property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelSpecifications().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPHotelInventoryHotel }
     * 
     * 
     */
    public List<JPSOAPHotelInventoryHotel> getHotelSpecifications() {
        if (hotelSpecifications == null) {
            hotelSpecifications = new ArrayList<JPSOAPHotelInventoryHotel>();
        }
        return this.hotelSpecifications;
    }

    /**
     * Gets the value of the hotelListInventory property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelInventorySimpleInfo }
     *     
     */
    public ArrayOfJPHotelInventorySimpleInfo getHotelListInventory() {
        return hotelListInventory;
    }

    /**
     * Sets the value of the hotelListInventory property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelInventorySimpleInfo }
     *     
     */
    public void setHotelListInventory(ArrayOfJPHotelInventorySimpleInfo value) {
        this.hotelListInventory = value;
    }

}
