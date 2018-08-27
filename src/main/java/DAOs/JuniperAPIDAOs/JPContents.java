
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Contents complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Contents">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelContent" type="{http://www.juniper.es/webservice/2007/}JP_HotelContent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PackageContent" type="{http://www.juniper.es/webservice/2007/}JP_PackageContent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RentacarLocationContent" type="{http://www.juniper.es/webservice/2007/}JP_RentacarLocationDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Contents", propOrder = {
    "hotelContent",
    "packageContent",
    "rentacarLocationContent"
})
public class JPContents {

    @XmlElement(name = "HotelContent")
    protected List<JPHotelContent> hotelContent;
    @XmlElement(name = "PackageContent")
    protected List<JPPackageContent> packageContent;
    @XmlElement(name = "RentacarLocationContent")
    protected List<JPRentacarLocationDetail> rentacarLocationContent;

    /**
     * Gets the value of the hotelContent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelContent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPHotelContent }
     * 
     * 
     */
    public List<JPHotelContent> getHotelContent() {
        if (hotelContent == null) {
            hotelContent = new ArrayList<JPHotelContent>();
        }
        return this.hotelContent;
    }

    /**
     * Gets the value of the packageContent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packageContent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackageContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPPackageContent }
     * 
     * 
     */
    public List<JPPackageContent> getPackageContent() {
        if (packageContent == null) {
            packageContent = new ArrayList<JPPackageContent>();
        }
        return this.packageContent;
    }

    /**
     * Gets the value of the rentacarLocationContent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentacarLocationContent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentacarLocationContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPRentacarLocationDetail }
     * 
     * 
     */
    public List<JPRentacarLocationDetail> getRentacarLocationContent() {
        if (rentacarLocationContent == null) {
            rentacarLocationContent = new ArrayList<JPRentacarLocationDetail>();
        }
        return this.rentacarLocationContent;
    }

}
