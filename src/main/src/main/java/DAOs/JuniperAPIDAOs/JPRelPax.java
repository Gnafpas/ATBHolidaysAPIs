
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RelPax complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RelPax">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaxSeats" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_PaxSeat" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="IdPax" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RelPax", propOrder = {
    "paxSeats"
})
@XmlSeeAlso({
    JPExtendedRelPaxBag.class,
    JPCruiseExtendedRelPax.class,
    JPExtendedRelPax.class
})
public class JPRelPax {

    @XmlElement(name = "PaxSeats")
    protected ArrayOfJPPaxSeat paxSeats;
    @XmlAttribute(name = "IdPax", required = true)
    protected int idPax;

    /**
     * Gets the value of the paxSeats property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPPaxSeat }
     *     
     */
    public ArrayOfJPPaxSeat getPaxSeats() {
        return paxSeats;
    }

    /**
     * Sets the value of the paxSeats property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPPaxSeat }
     *     
     */
    public void setPaxSeats(ArrayOfJPPaxSeat value) {
        this.paxSeats = value;
    }

    /**
     * Gets the value of the idPax property.
     * 
     */
    public int getIdPax() {
        return idPax;
    }

    /**
     * Sets the value of the idPax property.
     * 
     */
    public void setIdPax(int value) {
        this.idPax = value;
    }

}
