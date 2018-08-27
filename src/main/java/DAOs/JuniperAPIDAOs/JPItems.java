
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Items complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Items">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FlightItem" type="{http://www.juniper.es/webservice/2007/}JP_FlightItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="HotelItem" type="{http://www.juniper.es/webservice/2007/}JP_HotelItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PackageItem" type="{http://www.juniper.es/webservice/2007/}JP_PackageItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CarItem" type="{http://www.juniper.es/webservice/2007/}JP_RentacarItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InsuranceItem" type="{http://www.juniper.es/webservice/2007/}JP_InsuranceItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CruiseItem" type="{http://www.juniper.es/webservice/2007/}JP_CruiseItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ServiceItem" type="{http://www.juniper.es/webservice/2007/}JP_ServiceItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TransferItem" type="{http://www.juniper.es/webservice/2007/}JP_TransferItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="VisaItem" type="{http://www.juniper.es/webservice/2007/}JP_VisaItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Items", propOrder = {
    "flightItem",
    "hotelItem",
    "packageItem",
    "carItem",
    "insuranceItem",
    "cruiseItem",
    "serviceItem",
    "transferItem",
    "visaItem"
})
public class JPItems {

    @XmlElement(name = "FlightItem")
    protected List<JPFlightItem> flightItem;
    @XmlElement(name = "HotelItem")
    protected List<JPHotelItem> hotelItem;
    @XmlElement(name = "PackageItem")
    protected List<JPPackageItem> packageItem;
    @XmlElement(name = "CarItem")
    protected List<JPRentacarItem> carItem;
    @XmlElement(name = "InsuranceItem")
    protected List<JPInsuranceItem> insuranceItem;
    @XmlElement(name = "CruiseItem")
    protected List<JPCruiseItem> cruiseItem;
    @XmlElement(name = "ServiceItem")
    protected List<JPServiceItem> serviceItem;
    @XmlElement(name = "TransferItem")
    protected List<JPTransferItem> transferItem;
    @XmlElement(name = "VisaItem")
    protected List<JPVisaItem> visaItem;

    /**
     * Gets the value of the flightItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flightItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlightItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPFlightItem }
     * 
     * 
     */
    public List<JPFlightItem> getFlightItem() {
        if (flightItem == null) {
            flightItem = new ArrayList<JPFlightItem>();
        }
        return this.flightItem;
    }

    /**
     * Gets the value of the hotelItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPHotelItem }
     * 
     * 
     */
    public List<JPHotelItem> getHotelItem() {
        if (hotelItem == null) {
            hotelItem = new ArrayList<JPHotelItem>();
        }
        return this.hotelItem;
    }

    /**
     * Gets the value of the packageItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packageItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackageItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPPackageItem }
     * 
     * 
     */
    public List<JPPackageItem> getPackageItem() {
        if (packageItem == null) {
            packageItem = new ArrayList<JPPackageItem>();
        }
        return this.packageItem;
    }

    /**
     * Gets the value of the carItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the carItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCarItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPRentacarItem }
     * 
     * 
     */
    public List<JPRentacarItem> getCarItem() {
        if (carItem == null) {
            carItem = new ArrayList<JPRentacarItem>();
        }
        return this.carItem;
    }

    /**
     * Gets the value of the insuranceItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the insuranceItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInsuranceItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPInsuranceItem }
     * 
     * 
     */
    public List<JPInsuranceItem> getInsuranceItem() {
        if (insuranceItem == null) {
            insuranceItem = new ArrayList<JPInsuranceItem>();
        }
        return this.insuranceItem;
    }

    /**
     * Gets the value of the cruiseItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cruiseItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCruiseItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPCruiseItem }
     * 
     * 
     */
    public List<JPCruiseItem> getCruiseItem() {
        if (cruiseItem == null) {
            cruiseItem = new ArrayList<JPCruiseItem>();
        }
        return this.cruiseItem;
    }

    /**
     * Gets the value of the serviceItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPServiceItem }
     * 
     * 
     */
    public List<JPServiceItem> getServiceItem() {
        if (serviceItem == null) {
            serviceItem = new ArrayList<JPServiceItem>();
        }
        return this.serviceItem;
    }

    /**
     * Gets the value of the transferItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transferItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransferItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPTransferItem }
     * 
     * 
     */
    public List<JPTransferItem> getTransferItem() {
        if (transferItem == null) {
            transferItem = new ArrayList<JPTransferItem>();
        }
        return this.transferItem;
    }

    /**
     * Gets the value of the visaItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the visaItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVisaItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPVisaItem }
     * 
     * 
     */
    public List<JPVisaItem> getVisaItem() {
        if (visaItem == null) {
            visaItem = new ArrayList<JPVisaItem>();
        }
        return this.visaItem;
    }

}
