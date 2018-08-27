
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ZoneListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ZoneListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ProductType" type="{http://www.juniper.es/webservice/2007/}JP_ProductType" />
 *       &lt;attribute name="ShowIATA" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="MaxLevel" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ZoneListRequest")
public class JPZoneListRequest {

    @XmlAttribute(name = "ProductType")
    protected JPProductType productType;
    @XmlAttribute(name = "ShowIATA")
    protected Boolean showIATA;
    @XmlAttribute(name = "MaxLevel")
    protected Integer maxLevel;

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link JPProductType }
     *     
     */
    public JPProductType getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPProductType }
     *     
     */
    public void setProductType(JPProductType value) {
        this.productType = value;
    }

    /**
     * Gets the value of the showIATA property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowIATA() {
        return showIATA;
    }

    /**
     * Sets the value of the showIATA property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowIATA(Boolean value) {
        this.showIATA = value;
    }

    /**
     * Gets the value of the maxLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxLevel() {
        return maxLevel;
    }

    /**
     * Sets the value of the maxLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxLevel(Integer value) {
        this.maxLevel = value;
    }

}
