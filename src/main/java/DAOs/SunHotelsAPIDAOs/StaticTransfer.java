
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StaticTransfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StaticTransfer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}Transfer">
 *       &lt;sequence>
 *         &lt;element name="transferTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StaticTransfer", propOrder = {
    "transferTypeName"
})
public class StaticTransfer
    extends Transfer
{

    protected String transferTypeName;

    /**
     * Gets the value of the transferTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferTypeName() {
        return transferTypeName;
    }

    /**
     * Sets the value of the transferTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferTypeName(String value) {
        this.transferTypeName = value;
    }

}
