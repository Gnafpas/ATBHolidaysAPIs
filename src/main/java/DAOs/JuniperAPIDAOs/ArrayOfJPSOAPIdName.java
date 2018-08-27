
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJPSOAP_IdName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJPSOAP_IdName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DirectPaymentCardType" type="{http://www.juniper.es/webservice/2007/}JPSOAP_IdName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJPSOAP_IdName", propOrder = {
    "directPaymentCardType"
})
public class ArrayOfJPSOAPIdName {

    @XmlElement(name = "DirectPaymentCardType")
    protected List<JPSOAPIdName> directPaymentCardType;

    /**
     * Gets the value of the directPaymentCardType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directPaymentCardType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectPaymentCardType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPIdName }
     * 
     * 
     */
    public List<JPSOAPIdName> getDirectPaymentCardType() {
        if (directPaymentCardType == null) {
            directPaymentCardType = new ArrayList<JPSOAPIdName>();
        }
        return this.directPaymentCardType;
    }

}
