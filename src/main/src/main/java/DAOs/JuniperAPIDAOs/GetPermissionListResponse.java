
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
 *         &lt;element name="UserPermissionsRS" type="{http://www.juniper.es/webservice/2007/}JP_StaticDataRS" minOccurs="0"/>
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
    "userPermissionsRS"
})
@XmlRootElement(name = "GetPermissionListResponse")
public class GetPermissionListResponse {

    @XmlElement(name = "UserPermissionsRS")
    protected JPStaticDataRS userPermissionsRS;

    /**
     * Gets the value of the userPermissionsRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPStaticDataRS }
     *     
     */
    public JPStaticDataRS getUserPermissionsRS() {
        return userPermissionsRS;
    }

    /**
     * Sets the value of the userPermissionsRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPStaticDataRS }
     *     
     */
    public void setUserPermissionsRS(JPStaticDataRS value) {
        this.userPermissionsRS = value;
    }

}
