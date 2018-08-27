
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJPSOAP_RatePrice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJPSOAP_RatePrice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RatePrice" type="{http://www.juniper.es/webservice/2007/}JPSOAP_RatePrice" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJPSOAP_RatePrice", propOrder = {
    "ratePrice"
})
public class ArrayOfJPSOAPRatePrice {

    @XmlElement(name = "RatePrice")
    protected List<JPSOAPRatePrice> ratePrice;

    /**
     * Gets the value of the ratePrice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ratePrice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRatePrice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPRatePrice }
     * 
     * 
     */
    public List<JPSOAPRatePrice> getRatePrice() {
        if (ratePrice == null) {
            ratePrice = new ArrayList<JPSOAPRatePrice>();
        }
        return this.ratePrice;
    }

}
