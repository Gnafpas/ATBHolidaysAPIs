
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_LengthOfStay complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_LengthOfStay">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JPSOAP_DateIntervals">
 *       &lt;attribute name="MinNights" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxNights" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_LengthOfStay")
public class JPSOAPLengthOfStay
    extends JPSOAPDateIntervals
{

    @XmlAttribute(name = "MinNights")
    protected Integer minNights;
    @XmlAttribute(name = "MaxNights")
    protected Integer maxNights;

    /**
     * Gets the value of the minNights property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinNights() {
        return minNights;
    }

    /**
     * Sets the value of the minNights property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinNights(Integer value) {
        this.minNights = value;
    }

    /**
     * Gets the value of the maxNights property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxNights() {
        return maxNights;
    }

    /**
     * Sets the value of the maxNights property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxNights(Integer value) {
        this.maxNights = value;
    }

}
