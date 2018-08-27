
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Warnings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Warnings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Warning" type="{http://www.juniper.es/webservice/2007/}JP_WarningType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CancelInfo" type="{http://www.juniper.es/webservice/2007/}JP_CancelInformation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Warnings", propOrder = {
    "warning",
    "cancelInfo"
})
public class JPWarnings {

    @XmlElement(name = "Warning")
    protected List<JPWarningType> warning;
    @XmlElement(name = "CancelInfo")
    protected List<JPCancelInformation> cancelInfo;

    /**
     * Gets the value of the warning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPWarningType }
     * 
     * 
     */
    public List<JPWarningType> getWarning() {
        if (warning == null) {
            warning = new ArrayList<JPWarningType>();
        }
        return this.warning;
    }

    /**
     * Gets the value of the cancelInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancelInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancelInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPCancelInformation }
     * 
     * 
     */
    public List<JPCancelInformation> getCancelInfo() {
        if (cancelInfo == null) {
            cancelInfo = new ArrayList<JPCancelInformation>();
        }
        return this.cancelInfo;
    }

}
