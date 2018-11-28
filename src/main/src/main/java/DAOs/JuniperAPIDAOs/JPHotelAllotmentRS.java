
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelAllotmentRS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelAllotmentRS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Contract" type="{http://www.juniper.es/webservice/2007/}JPSOAP_HotelAvailContract" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="HotelCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotelCodeEncrypt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelAllotmentRS", propOrder = {
    "contract"
})
public class JPHotelAllotmentRS {

    @XmlElement(name = "Contract")
    protected List<JPSOAPHotelAvailContract> contract;
    @XmlAttribute(name = "HotelCode")
    protected String hotelCode;
    @XmlAttribute(name = "HotelCodeEncrypt")
    protected String hotelCodeEncrypt;

    /**
     * Gets the value of the contract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPHotelAvailContract }
     * 
     * 
     */
    public List<JPSOAPHotelAvailContract> getContract() {
        if (contract == null) {
            contract = new ArrayList<JPSOAPHotelAvailContract>();
        }
        return this.contract;
    }

    /**
     * Gets the value of the hotelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCode() {
        return hotelCode;
    }

    /**
     * Sets the value of the hotelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCode(String value) {
        this.hotelCode = value;
    }

    /**
     * Gets the value of the hotelCodeEncrypt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelCodeEncrypt() {
        return hotelCodeEncrypt;
    }

    /**
     * Sets the value of the hotelCodeEncrypt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelCodeEncrypt(String value) {
        this.hotelCodeEncrypt = value;
    }

}
