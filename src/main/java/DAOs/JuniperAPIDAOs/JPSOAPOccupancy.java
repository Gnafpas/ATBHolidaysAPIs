
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_Occupancy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_Occupancy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="MinAdult" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxAdult" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MinChild" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxChild" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_Occupancy")
public class JPSOAPOccupancy {

    @XmlAttribute(name = "MinAdult", required = true)
    protected int minAdult;
    @XmlAttribute(name = "MaxAdult", required = true)
    protected int maxAdult;
    @XmlAttribute(name = "MinChild", required = true)
    protected int minChild;
    @XmlAttribute(name = "MaxChild", required = true)
    protected int maxChild;

    /**
     * Gets the value of the minAdult property.
     * 
     */
    public int getMinAdult() {
        return minAdult;
    }

    /**
     * Sets the value of the minAdult property.
     * 
     */
    public void setMinAdult(int value) {
        this.minAdult = value;
    }

    /**
     * Gets the value of the maxAdult property.
     * 
     */
    public int getMaxAdult() {
        return maxAdult;
    }

    /**
     * Sets the value of the maxAdult property.
     * 
     */
    public void setMaxAdult(int value) {
        this.maxAdult = value;
    }

    /**
     * Gets the value of the minChild property.
     * 
     */
    public int getMinChild() {
        return minChild;
    }

    /**
     * Sets the value of the minChild property.
     * 
     */
    public void setMinChild(int value) {
        this.minChild = value;
    }

    /**
     * Gets the value of the maxChild property.
     * 
     */
    public int getMaxChild() {
        return maxChild;
    }

    /**
     * Sets the value of the maxChild property.
     * 
     */
    public void setMaxChild(int value) {
        this.maxChild = value;
    }

}
