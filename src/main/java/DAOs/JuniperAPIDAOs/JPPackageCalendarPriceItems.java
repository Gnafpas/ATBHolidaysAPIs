
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageCalendarPriceItems complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageCalendarPriceItems">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PackageCalendarPriceItem" type="{http://www.juniper.es/webservice/2007/}JP_PackageCalendarPriceItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OriginZone" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="DestinationZone" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageCalendarPriceItems", propOrder = {
    "packageCalendarPriceItem"
})
public class JPPackageCalendarPriceItems {

    @XmlElement(name = "PackageCalendarPriceItem")
    protected List<JPPackageCalendarPriceItem> packageCalendarPriceItem;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "OriginZone", required = true)
    protected int originZone;
    @XmlAttribute(name = "DestinationZone", required = true)
    protected int destinationZone;
    @XmlAttribute(name = "Currency")
    protected String currency;

    /**
     * Gets the value of the packageCalendarPriceItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the packageCalendarPriceItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPackageCalendarPriceItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPPackageCalendarPriceItem }
     * 
     * 
     */
    public List<JPPackageCalendarPriceItem> getPackageCalendarPriceItem() {
        if (packageCalendarPriceItem == null) {
            packageCalendarPriceItem = new ArrayList<JPPackageCalendarPriceItem>();
        }
        return this.packageCalendarPriceItem;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the originZone property.
     * 
     */
    public int getOriginZone() {
        return originZone;
    }

    /**
     * Sets the value of the originZone property.
     * 
     */
    public void setOriginZone(int value) {
        this.originZone = value;
    }

    /**
     * Gets the value of the destinationZone property.
     * 
     */
    public int getDestinationZone() {
        return destinationZone;
    }

    /**
     * Sets the value of the destinationZone property.
     * 
     */
    public void setDestinationZone(int value) {
        this.destinationZone = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

}
