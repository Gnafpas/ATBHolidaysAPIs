
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentVisa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentVisa">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentBase">
 *       &lt;sequence>
 *         &lt;element name="Suppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfString5" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="InternalSupplier" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentVisa", propOrder = {
    "suppliers"
})
public class JPSearchSegmentVisa
    extends JPSearchSegmentBase
{

    @XmlElement(name = "Suppliers")
    protected ArrayOfString5 suppliers;
    @XmlAttribute(name = "Type")
    protected Integer type;
    @XmlAttribute(name = "InternalSupplier")
    protected Integer internalSupplier;

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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setType(Integer value) {
        this.type = value;
    }

    /**
     * Gets the value of the internalSupplier property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInternalSupplier() {
        return internalSupplier;
    }

    /**
     * Sets the value of the internalSupplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInternalSupplier(Integer value) {
        this.internalSupplier = value;
    }

}
