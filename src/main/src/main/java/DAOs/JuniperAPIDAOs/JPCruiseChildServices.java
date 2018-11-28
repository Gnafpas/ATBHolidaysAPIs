
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseChildServices complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseChildServices">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Creche" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Ninzone" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Youthzone" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Ninpool" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Youthprogram" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseChildServices")
public class JPCruiseChildServices {

    @XmlAttribute(name = "Creche")
    protected Boolean creche;
    @XmlAttribute(name = "Ninzone")
    protected Boolean ninzone;
    @XmlAttribute(name = "Youthzone")
    protected Boolean youthzone;
    @XmlAttribute(name = "Ninpool")
    protected Boolean ninpool;
    @XmlAttribute(name = "Youthprogram")
    protected Boolean youthprogram;

    /**
     * Gets the value of the creche property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCreche() {
        return creche;
    }

    /**
     * Sets the value of the creche property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCreche(Boolean value) {
        this.creche = value;
    }

    /**
     * Gets the value of the ninzone property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNinzone() {
        return ninzone;
    }

    /**
     * Sets the value of the ninzone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNinzone(Boolean value) {
        this.ninzone = value;
    }

    /**
     * Gets the value of the youthzone property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isYouthzone() {
        return youthzone;
    }

    /**
     * Sets the value of the youthzone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setYouthzone(Boolean value) {
        this.youthzone = value;
    }

    /**
     * Gets the value of the ninpool property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNinpool() {
        return ninpool;
    }

    /**
     * Sets the value of the ninpool property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNinpool(Boolean value) {
        this.ninpool = value;
    }

    /**
     * Gets the value of the youthprogram property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isYouthprogram() {
        return youthprogram;
    }

    /**
     * Sets the value of the youthprogram property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setYouthprogram(Boolean value) {
        this.youthprogram = value;
    }

}
