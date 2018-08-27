
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SeatGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SeatGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GroupFee" type="{http://www.juniper.es/webservice/2007/}JP_GroupFee" minOccurs="0"/>
 *         &lt;element name="GroupDetail" type="{http://www.juniper.es/webservice/2007/}JP_GroupDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Group" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SeatGroup", propOrder = {
    "groupFee",
    "groupDetail"
})
public class JPSeatGroup {

    @XmlElement(name = "GroupFee")
    protected JPGroupFee groupFee;
    @XmlElement(name = "GroupDetail")
    protected JPGroupDetail groupDetail;
    @XmlAttribute(name = "Group", required = true)
    protected int group;

    /**
     * Gets the value of the groupFee property.
     * 
     * @return
     *     possible object is
     *     {@link JPGroupFee }
     *     
     */
    public JPGroupFee getGroupFee() {
        return groupFee;
    }

    /**
     * Sets the value of the groupFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPGroupFee }
     *     
     */
    public void setGroupFee(JPGroupFee value) {
        this.groupFee = value;
    }

    /**
     * Gets the value of the groupDetail property.
     * 
     * @return
     *     possible object is
     *     {@link JPGroupDetail }
     *     
     */
    public JPGroupDetail getGroupDetail() {
        return groupDetail;
    }

    /**
     * Sets the value of the groupDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPGroupDetail }
     *     
     */
    public void setGroupDetail(JPGroupDetail value) {
        this.groupDetail = value;
    }

    /**
     * Gets the value of the group property.
     * 
     */
    public int getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     */
    public void setGroup(int value) {
        this.group = value;
    }

}
