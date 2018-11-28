
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_OccupanciesRules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_OccupanciesRules">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_Occupancies">
 *       &lt;attribute name="MinPaxes" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxPaxes" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="Infants" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_OccupanciesRules")
public class JPSOAPOccupanciesRules
    extends JPSOAPOccupancies
{

    @XmlAttribute(name = "MinPaxes")
    protected Integer minPaxes;
    @XmlAttribute(name = "MaxPaxes")
    protected Integer maxPaxes;
    @XmlAttribute(name = "Infants")
    protected Boolean infants;

    /**
     * Gets the value of the minPaxes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinPaxes() {
        return minPaxes;
    }

    /**
     * Sets the value of the minPaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinPaxes(Integer value) {
        this.minPaxes = value;
    }

    /**
     * Gets the value of the maxPaxes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxPaxes() {
        return maxPaxes;
    }

    /**
     * Sets the value of the maxPaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxPaxes(Integer value) {
        this.maxPaxes = value;
    }

    /**
     * Gets the value of the infants property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInfants() {
        return infants;
    }

    /**
     * Sets the value of the infants property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInfants(Boolean value) {
        this.infants = value;
    }

}
