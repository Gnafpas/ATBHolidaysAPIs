
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelAvailContract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelAvailContract">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_Contract">
 *       &lt;sequence>
 *         &lt;element name="Allotments" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_HotelAvailAllotment" minOccurs="0"/>
 *         &lt;element name="StopSales" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_HotelAvailStopSale" minOccurs="0"/>
 *         &lt;element name="Releases" type="{http://www.juniper.es/webservice/2007/}JPSOAP_HotelAvailReleases" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="OnRequestAllowedWithoutAllotment" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelAvailContract", propOrder = {
    "allotments",
    "stopSales",
    "releases"
})
public class JPSOAPHotelAvailContract
    extends JPSOAPContract
{

    @XmlElement(name = "Allotments")
    protected ArrayOfJPSOAPHotelAvailAllotment allotments;
    @XmlElement(name = "StopSales")
    protected ArrayOfJPSOAPHotelAvailStopSale stopSales;
    @XmlElement(name = "Releases")
    protected JPSOAPHotelAvailReleases releases;
    @XmlAttribute(name = "OnRequestAllowedWithoutAllotment", required = true)
    protected boolean onRequestAllowedWithoutAllotment;

    /**
     * Gets the value of the allotments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelAvailAllotment }
     *     
     */
    public ArrayOfJPSOAPHotelAvailAllotment getAllotments() {
        return allotments;
    }

    /**
     * Sets the value of the allotments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelAvailAllotment }
     *     
     */
    public void setAllotments(ArrayOfJPSOAPHotelAvailAllotment value) {
        this.allotments = value;
    }

    /**
     * Gets the value of the stopSales property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPHotelAvailStopSale }
     *     
     */
    public ArrayOfJPSOAPHotelAvailStopSale getStopSales() {
        return stopSales;
    }

    /**
     * Sets the value of the stopSales property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPHotelAvailStopSale }
     *     
     */
    public void setStopSales(ArrayOfJPSOAPHotelAvailStopSale value) {
        this.stopSales = value;
    }

    /**
     * Gets the value of the releases property.
     * 
     * @return
     *     possible object is
     *     {@link JPSOAPHotelAvailReleases }
     *     
     */
    public JPSOAPHotelAvailReleases getReleases() {
        return releases;
    }

    /**
     * Sets the value of the releases property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSOAPHotelAvailReleases }
     *     
     */
    public void setReleases(JPSOAPHotelAvailReleases value) {
        this.releases = value;
    }

    /**
     * Gets the value of the onRequestAllowedWithoutAllotment property.
     * 
     */
    public boolean isOnRequestAllowedWithoutAllotment() {
        return onRequestAllowedWithoutAllotment;
    }

    /**
     * Sets the value of the onRequestAllowedWithoutAllotment property.
     * 
     */
    public void setOnRequestAllowedWithoutAllotment(boolean value) {
        this.onRequestAllowedWithoutAllotment = value;
    }

}
