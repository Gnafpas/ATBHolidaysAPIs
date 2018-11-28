
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_ZoneInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_ZoneInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ZoneInfo" type="{http://www.juniper.es/webservice/2007/}JP_ZoneInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_ZoneInfo", propOrder = {
    "zoneInfo"
})
public class ArrayOfJPZoneInfo {

    @XmlElement(name = "ZoneInfo")
    protected List<JPZoneInfo> zoneInfo;

    /**
     * Gets the value of the zoneInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zoneInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZoneInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPZoneInfo }
     * 
     * 
     */
    public List<JPZoneInfo> getZoneInfo() {
        if (zoneInfo == null) {
            zoneInfo = new ArrayList<JPZoneInfo>();
        }
        return this.zoneInfo;
    }

}
