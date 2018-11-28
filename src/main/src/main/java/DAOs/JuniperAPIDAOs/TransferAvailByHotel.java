
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
 *         &lt;element name="TransferAvailRQByHotel" type="{http://www.juniper.es/webservice/2007/}JP_TransferAvailabilityRQByHotel" minOccurs="0"/>
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
    "transferAvailRQByHotel"
})
@XmlRootElement(name = "TransferAvailByHotel")
public class TransferAvailByHotel {

    @XmlElement(name = "TransferAvailRQByHotel")
    protected JPTransferAvailabilityRQByHotel transferAvailRQByHotel;

    /**
     * Gets the value of the transferAvailRQByHotel property.
     * 
     * @return
     *     possible object is
     *     {@link JPTransferAvailabilityRQByHotel }
     *     
     */
    public JPTransferAvailabilityRQByHotel getTransferAvailRQByHotel() {
        return transferAvailRQByHotel;
    }

    /**
     * Sets the value of the transferAvailRQByHotel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPTransferAvailabilityRQByHotel }
     *     
     */
    public void setTransferAvailRQByHotel(JPTransferAvailabilityRQByHotel value) {
        this.transferAvailRQByHotel = value;
    }

}
