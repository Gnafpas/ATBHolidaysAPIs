
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PackageListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PackageListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Suppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfString5" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="OriginZone" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="DestinationZone" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Masters" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PackageListRequest", propOrder = {
    "suppliers"
})
public class JPPackageListRequest {

    @XmlElement(name = "Suppliers")
    protected ArrayOfString5 suppliers;
    @XmlAttribute(name = "OriginZone")
    protected Integer originZone;
    @XmlAttribute(name = "DestinationZone")
    protected Integer destinationZone;
    @XmlAttribute(name = "Masters")
    protected Boolean masters;

    /**
     * Gets the value of the suppliers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString5 }
     *     
     */
    public ArrayOfString5 getSuppliers() {
        return suppliers;
    }

    /**
     * Sets the value of the suppliers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString5 }
     *     
     */
    public void setSuppliers(ArrayOfString5 value) {
        this.suppliers = value;
    }

    /**
     * Gets the value of the originZone property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOriginZone() {
        return originZone;
    }

    /**
     * Sets the value of the originZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOriginZone(Integer value) {
        this.originZone = value;
    }

    /**
     * Gets the value of the destinationZone property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDestinationZone() {
        return destinationZone;
    }

    /**
     * Sets the value of the destinationZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDestinationZone(Integer value) {
        this.destinationZone = value;
    }

    /**
     * Gets the value of the masters property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMasters() {
        return masters;
    }

    /**
     * Sets the value of the masters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMasters(Boolean value) {
        this.masters = value;
    }

}
