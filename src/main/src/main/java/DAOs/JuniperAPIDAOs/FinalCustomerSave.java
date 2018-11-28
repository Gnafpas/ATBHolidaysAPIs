
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
 *         &lt;element name="FinalCustomerSaveRQ" type="{http://www.juniper.es/webservice/2007/}JP_FinalCustomerSave" minOccurs="0"/>
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
    "finalCustomerSaveRQ"
})
@XmlRootElement(name = "FinalCustomerSave")
public class FinalCustomerSave {

    @XmlElement(name = "FinalCustomerSaveRQ")
    protected JPFinalCustomerSave finalCustomerSaveRQ;

    /**
     * Gets the value of the finalCustomerSaveRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPFinalCustomerSave }
     *     
     */
    public JPFinalCustomerSave getFinalCustomerSaveRQ() {
        return finalCustomerSaveRQ;
    }

    /**
     * Sets the value of the finalCustomerSaveRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFinalCustomerSave }
     *     
     */
    public void setFinalCustomerSaveRQ(JPFinalCustomerSave value) {
        this.finalCustomerSaveRQ = value;
    }

}
