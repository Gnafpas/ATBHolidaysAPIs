
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
 *         &lt;element name="FinalCustomerReadRQ" type="{http://www.juniper.es/webservice/2007/}JP_FinalCustomerRead" minOccurs="0"/>
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
    "finalCustomerReadRQ"
})
@XmlRootElement(name = "FinalCustomerRead")
public class FinalCustomerRead {

    @XmlElement(name = "FinalCustomerReadRQ")
    protected JPFinalCustomerRead finalCustomerReadRQ;

    /**
     * Gets the value of the finalCustomerReadRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPFinalCustomerRead }
     *     
     */
    public JPFinalCustomerRead getFinalCustomerReadRQ() {
        return finalCustomerReadRQ;
    }

    /**
     * Sets the value of the finalCustomerReadRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFinalCustomerRead }
     *     
     */
    public void setFinalCustomerReadRQ(JPFinalCustomerRead value) {
        this.finalCustomerReadRQ = value;
    }

}
