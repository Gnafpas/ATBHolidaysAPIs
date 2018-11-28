
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContentRS" type="{http://www.juniper.es/webservice/2007/}JP_ContentRS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contentRS"
})
@XmlRootElement(name = "PackageContentResponse")
public class PackageContentResponse {

    @XmlElement(name = "ContentRS")
    protected JPContentRS contentRS;

    /**
     * Gets the value of the contentRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPContentRS }
     *     
     */
    public JPContentRS getContentRS() {
        return contentRS;
    }

    /**
     * Sets the value of the contentRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPContentRS }
     *     
     */
    public void setContentRS(JPContentRS value) {
        this.contentRS = value;
    }

}
