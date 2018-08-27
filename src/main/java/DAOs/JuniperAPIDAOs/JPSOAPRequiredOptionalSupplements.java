
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_RequiredOptionalSupplements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_RequiredOptionalSupplements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SupplementCategories" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IntCodeAttr" minOccurs="0"/>
 *         &lt;element name="Supplements" type="{http://www.juniper.es/webservice/2007/}ArrayOfJPSOAP_IntCodeAttr1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_RequiredOptionalSupplements", propOrder = {
    "supplementCategories",
    "supplements"
})
public class JPSOAPRequiredOptionalSupplements {

    @XmlElement(name = "SupplementCategories")
    protected ArrayOfJPSOAPIntCodeAttr supplementCategories;
    @XmlElement(name = "Supplements")
    protected ArrayOfJPSOAPIntCodeAttr1 supplements;

    /**
     * Gets the value of the supplementCategories property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIntCodeAttr }
     *     
     */
    public ArrayOfJPSOAPIntCodeAttr getSupplementCategories() {
        return supplementCategories;
    }

    /**
     * Sets the value of the supplementCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIntCodeAttr }
     *     
     */
    public void setSupplementCategories(ArrayOfJPSOAPIntCodeAttr value) {
        this.supplementCategories = value;
    }

    /**
     * Gets the value of the supplements property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSOAPIntCodeAttr1 }
     *     
     */
    public ArrayOfJPSOAPIntCodeAttr1 getSupplements() {
        return supplements;
    }

    /**
     * Sets the value of the supplements property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSOAPIntCodeAttr1 }
     *     
     */
    public void setSupplements(ArrayOfJPSOAPIntCodeAttr1 value) {
        this.supplements = value;
    }

}
