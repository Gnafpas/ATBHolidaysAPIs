
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PriceInformationPackage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PriceInformationPackage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageInfo" type="{http://www.juniper.es/webservice/2007/}JP_PackageInfo" minOccurs="0"/>
 *         &lt;element name="Stays" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageStay" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_PackageAdditionalElements" minOccurs="0"/>
 *         &lt;element name="Prices" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Price" minOccurs="0"/>
 *         &lt;element name="AFIPInformation" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PackageInfoAFIPAmount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PriceInformationPackage", propOrder = {
    "packageInfo",
    "stays",
    "additionalElements",
    "prices",
    "afipInformation"
})
public class JPPriceInformationPackage {

    @XmlElement(name = "PackageInfo")
    protected JPPackageInfo packageInfo;
    @XmlElement(name = "Stays")
    protected ArrayOfJPPackageStay stays;
    @XmlElement(name = "AdditionalElements")
    protected JPPackageAdditionalElements additionalElements;
    @XmlElement(name = "Prices")
    protected ArrayOfJPPrice prices;
    @XmlElement(name = "AFIPInformation")
    protected ArrayOfJPPackageInfoAFIPAmount afipInformation;

    /**
     * Gets the value of the packageInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageInfo }
     *     
     */
    public JPPackageInfo getPackageInfo() {
        return packageInfo;
    }

    /**
     * Sets the value of the packageInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageInfo }
     *     
     */
    public void setPackageInfo(JPPackageInfo value) {
        this.packageInfo = value;
    }

    /**
     * Gets the value of the stays property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageStay }
     *     
     */
    public ArrayOfJPPackageStay getStays() {
        return stays;
    }

    /**
     * Sets the value of the stays property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageStay }
     *     
     */
    public void setStays(ArrayOfJPPackageStay value) {
        this.stays = value;
    }

    /**
     * Gets the value of the additionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPPackageAdditionalElements }
     *     
     */
    public JPPackageAdditionalElements getAdditionalElements() {
        return additionalElements;
    }

    /**
     * Sets the value of the additionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPPackageAdditionalElements }
     *     
     */
    public void setAdditionalElements(JPPackageAdditionalElements value) {
        this.additionalElements = value;
    }

    /**
     * Gets the value of the prices property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPrice }
     *     
     */
    public ArrayOfJPPrice getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPrice }
     *     
     */
    public void setPrices(ArrayOfJPPrice value) {
        this.prices = value;
    }

    /**
     * Gets the value of the afipInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPackageInfoAFIPAmount }
     *     
     */
    public ArrayOfJPPackageInfoAFIPAmount getAFIPInformation() {
        return afipInformation;
    }

    /**
     * Sets the value of the afipInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPackageInfoAFIPAmount }
     *     
     */
    public void setAFIPInformation(ArrayOfJPPackageInfoAFIPAmount value) {
        this.afipInformation = value;
    }

}
