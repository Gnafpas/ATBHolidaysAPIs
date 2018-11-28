
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_FareGroupService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_FareGroupService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="TypeCode" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="PriceApplicationCode" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_FareGroupService")
public class JPFareGroupService {

    @XmlAttribute(name = "TypeCode", required = true)
    protected int typeCode;
    @XmlAttribute(name = "PriceApplicationCode", required = true)
    protected int priceApplicationCode;

    /**
     * Gets the value of the typeCode property.
     * 
     */
    public int getTypeCode() {
        return typeCode;
    }

    /**
     * Sets the value of the typeCode property.
     * 
     */
    public void setTypeCode(int value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the priceApplicationCode property.
     * 
     */
    public int getPriceApplicationCode() {
        return priceApplicationCode;
    }

    /**
     * Sets the value of the priceApplicationCode property.
     * 
     */
    public void setPriceApplicationCode(int value) {
        this.priceApplicationCode = value;
    }

}
