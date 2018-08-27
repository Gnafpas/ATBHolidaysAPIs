
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
 *         &lt;element name="UserPermissionsRQ" type="{http://www.juniper.es/webservice/2007/}JP_UserPermissionsRQ" minOccurs="0"/>
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
    "userPermissionsRQ"
})
@XmlRootElement(name = "GetPermissionList")
public class GetPermissionList {

    @XmlElement(name = "UserPermissionsRQ")
    protected JPUserPermissionsRQ userPermissionsRQ;

    /**
     * Gets the value of the userPermissionsRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPUserPermissionsRQ }
     *     
     */
    public JPUserPermissionsRQ getUserPermissionsRQ() {
        return userPermissionsRQ;
    }

    /**
     * Sets the value of the userPermissionsRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPUserPermissionsRQ }
     *     
     */
    public void setUserPermissionsRQ(JPUserPermissionsRQ value) {
        this.userPermissionsRQ = value;
    }

}
