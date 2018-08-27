
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_Ages complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_Ages">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Infants" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ChildA" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ChildB" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="InfantAsChild" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_Ages")
public class JPSOAPAges {

    @XmlAttribute(name = "Infants")
    protected Integer infants;
    @XmlAttribute(name = "ChildA")
    protected Integer childA;
    @XmlAttribute(name = "ChildB")
    protected Integer childB;
    @XmlAttribute(name = "InfantAsChild")
    protected Integer infantAsChild;

    /**
     * Gets the value of the infants property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInfants() {
        return infants;
    }

    /**
     * Sets the value of the infants property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInfants(Integer value) {
        this.infants = value;
    }

    /**
     * Gets the value of the childA property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getChildA() {
        return childA;
    }

    /**
     * Sets the value of the childA property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setChildA(Integer value) {
        this.childA = value;
    }

    /**
     * Gets the value of the childB property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getChildB() {
        return childB;
    }

    /**
     * Sets the value of the childB property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setChildB(Integer value) {
        this.childB = value;
    }

    /**
     * Gets the value of the infantAsChild property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInfantAsChild() {
        return infantAsChild;
    }

    /**
     * Sets the value of the infantAsChild property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInfantAsChild(Integer value) {
        this.infantAsChild = value;
    }

}
