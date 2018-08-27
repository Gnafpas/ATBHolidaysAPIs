
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ExternalInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ExternalInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Supplier" type="{http://www.juniper.es/webservice/2007/}JP_Supplier" minOccurs="0"/>
 *         &lt;element name="ExternalLocator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ExternalInfo", propOrder = {
    "supplier",
    "externalLocator"
})
public class JPExternalInfo {

    @XmlElement(name = "Supplier")
    protected JPSupplier supplier;
    @XmlElement(name = "ExternalLocator")
    protected String externalLocator;

    /**
     * Gets the value of the supplier property.
     * 
     * @return
     *     possible object is
     *     {@link JPSupplier }
     *     
     */
    public JPSupplier getSupplier() {
        return supplier;
    }

    /**
     * Sets the value of the supplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSupplier }
     *     
     */
    public void setSupplier(JPSupplier value) {
        this.supplier = value;
    }

    /**
     * Gets the value of the externalLocator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalLocator() {
        return externalLocator;
    }

    /**
     * Sets the value of the externalLocator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalLocator(String value) {
        this.externalLocator = value;
    }

}
