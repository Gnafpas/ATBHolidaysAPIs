
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_UserPermission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_UserPermission">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserPermissionsList" type="{http://www.juniper.es/webservice/2007/}JP_UserPermission" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_UserPermission", propOrder = {
    "userPermissionsList"
})
public class ArrayOfJPUserPermission {

    @XmlElement(name = "UserPermissionsList")
    protected List<JPUserPermission> userPermissionsList;

    /**
     * Gets the value of the userPermissionsList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userPermissionsList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserPermissionsList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPUserPermission }
     * 
     * 
     */
    public List<JPUserPermission> getUserPermissionsList() {
        if (userPermissionsList == null) {
            userPermissionsList = new ArrayList<JPUserPermission>();
        }
        return this.userPermissionsList;
    }

}
