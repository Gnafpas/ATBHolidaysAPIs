
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SupplementRelPaxDist complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SupplementRelPaxDist">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SupplementRelPaxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_SupplementRelPax" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Source" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SupplementRelPaxDist", propOrder = {
    "supplementRelPaxes"
})
public class JPSupplementRelPaxDist {

    @XmlElement(name = "SupplementRelPaxes")
    protected ArrayOfJPSupplementRelPax supplementRelPaxes;
    @XmlAttribute(name = "Source", required = true)
    protected int source;

    /**
     * Gets the value of the supplementRelPaxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSupplementRelPax }
     *     
     */
    public ArrayOfJPSupplementRelPax getSupplementRelPaxes() {
        return supplementRelPaxes;
    }

    /**
     * Sets the value of the supplementRelPaxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSupplementRelPax }
     *     
     */
    public void setSupplementRelPaxes(ArrayOfJPSupplementRelPax value) {
        this.supplementRelPaxes = value;
    }

    /**
     * Gets the value of the source property.
     * 
     */
    public int getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     */
    public void setSource(int value) {
        this.source = value;
    }

}
