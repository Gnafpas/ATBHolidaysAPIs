
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResortList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResortList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="Resorts" type="{http://xml.sunhotels.net/15/}ArrayOfResort" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResortList", propOrder = {
    "resorts"
})
public class ResortList
    extends BaseResult
{

    @XmlElement(name = "Resorts")
    protected ArrayOfResort resorts;

    /**
     * Gets the value of the resorts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfResort }
     *     
     */
    public ArrayOfResort getResorts() {
        return resorts;
    }

    /**
     * Sets the value of the resorts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfResort }
     *     
     */
    public void setResorts(ArrayOfResort value) {
        this.resorts = value;
    }

}
