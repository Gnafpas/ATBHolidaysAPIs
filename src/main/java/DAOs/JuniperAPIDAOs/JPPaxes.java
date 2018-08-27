
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Paxes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Paxes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Pax" type="{http://www.juniper.es/webservice/2007/}JP_Pax" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AdultsFree" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ChildrenFree" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Paxes", propOrder = {
    "pax"
})
public class JPPaxes {

    @XmlElement(name = "Pax")
    protected List<JPPax> pax;
    @XmlAttribute(name = "AdultsFree")
    protected Integer adultsFree;
    @XmlAttribute(name = "ChildrenFree")
    protected Integer childrenFree;

    /**
     * Gets the value of the pax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPPax }
     * 
     * 
     */
    public List<JPPax> getPax() {
        if (pax == null) {
            pax = new ArrayList<JPPax>();
        }
        return this.pax;
    }

    /**
     * Gets the value of the adultsFree property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAdultsFree() {
        return adultsFree;
    }

    /**
     * Sets the value of the adultsFree property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAdultsFree(Integer value) {
        this.adultsFree = value;
    }

    /**
     * Gets the value of the childrenFree property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getChildrenFree() {
        return childrenFree;
    }

    /**
     * Sets the value of the childrenFree property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setChildrenFree(Integer value) {
        this.childrenFree = value;
    }

}
