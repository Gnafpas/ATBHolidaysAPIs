
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelRoomContract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelRoomContract">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Days" type="{http://www.juniper.es/webservice/2007/}ArrayOfInt1" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="IntCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="IsSalesContract" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Type" use="required" type="{http://www.juniper.es/webservice/2007/}JP_ContractType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelRoomContract", propOrder = {
    "name",
    "days"
})
public class JPHotelRoomContract {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Days")
    protected ArrayOfInt1 days;
    @XmlAttribute(name = "IntCode")
    protected String intCode;
    @XmlAttribute(name = "IsSalesContract", required = true)
    protected boolean isSalesContract;
    @XmlAttribute(name = "Type", required = true)
    protected JPContractType type;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the days property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt1 }
     *     
     */
    public ArrayOfInt1 getDays() {
        return days;
    }

    /**
     * Sets the value of the days property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt1 }
     *     
     */
    public void setDays(ArrayOfInt1 value) {
        this.days = value;
    }

    /**
     * Gets the value of the intCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntCode() {
        return intCode;
    }

    /**
     * Sets the value of the intCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntCode(String value) {
        this.intCode = value;
    }

    /**
     * Gets the value of the isSalesContract property.
     * 
     */
    public boolean isIsSalesContract() {
        return isSalesContract;
    }

    /**
     * Sets the value of the isSalesContract property.
     * 
     */
    public void setIsSalesContract(boolean value) {
        this.isSalesContract = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPContractType }
     *     
     */
    public JPContractType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPContractType }
     *     
     */
    public void setType(JPContractType value) {
        this.type = value;
    }

}
