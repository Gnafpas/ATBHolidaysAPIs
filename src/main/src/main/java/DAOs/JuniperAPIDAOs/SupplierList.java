
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SupplierListRQ" type="{http://www.juniper.es/webservice/2007/}JP_SupplierListRQ" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "supplierListRQ"
})
@XmlRootElement(name = "SupplierList")
public class SupplierList {

    @XmlElement(name = "SupplierListRQ")
    protected JPSupplierListRQ supplierListRQ;

    /**
     * Gets the value of the supplierListRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPSupplierListRQ }
     *     
     */
    public JPSupplierListRQ getSupplierListRQ() {
        return supplierListRQ;
    }

    /**
     * Sets the value of the supplierListRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSupplierListRQ }
     *     
     */
    public void setSupplierListRQ(JPSupplierListRQ value) {
        this.supplierListRQ = value;
    }

}
