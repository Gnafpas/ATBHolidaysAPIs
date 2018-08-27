
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_GroupDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_GroupDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Names" type="{http://www.juniper.es/webservice/2007/}ArrayOfString4" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_GroupDetail", propOrder = {
    "names"
})
public class JPGroupDetail {

    @XmlElement(name = "Names")
    protected ArrayOfString4 names;

    /**
     * Gets the value of the names property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString4 }
     *     
     */
    public ArrayOfString4 getNames() {
        return names;
    }

    /**
     * Sets the value of the names property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString4 }
     *     
     */
    public void setNames(ArrayOfString4 value) {
        this.names = value;
    }

}
