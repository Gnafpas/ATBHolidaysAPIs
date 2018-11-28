
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_PriceInformationVisa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_PriceInformationVisa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VisaInfo" type="{http://www.juniper.es/webservice/2007/}JP_VisaInfo" minOccurs="0"/>
 *         &lt;element name="VisaOptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_VisaOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_PriceInformationVisa", propOrder = {
    "visaInfo",
    "visaOptions"
})
public class JPPriceInformationVisa {

    @XmlElement(name = "VisaInfo")
    protected JPVisaInfo visaInfo;
    @XmlElement(name = "VisaOptions")
    protected ArrayOfJPVisaOption visaOptions;

    /**
     * Gets the value of the visaInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPVisaInfo }
     *     
     */
    public JPVisaInfo getVisaInfo() {
        return visaInfo;
    }

    /**
     * Sets the value of the visaInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPVisaInfo }
     *     
     */
    public void setVisaInfo(JPVisaInfo value) {
        this.visaInfo = value;
    }

    /**
     * Gets the value of the visaOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPVisaOption }
     *     
     */
    public ArrayOfJPVisaOption getVisaOptions() {
        return visaOptions;
    }

    /**
     * Sets the value of the visaOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPVisaOption }
     *     
     */
    public void setVisaOptions(ArrayOfJPVisaOption value) {
        this.visaOptions = value;
    }

}
