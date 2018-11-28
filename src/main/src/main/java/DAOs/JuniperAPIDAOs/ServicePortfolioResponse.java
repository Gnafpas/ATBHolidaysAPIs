
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
 *         &lt;element name="ServicePortfolioRS" type="{http://www.juniper.es/webservice/2007/}JP_StaticDataRS" minOccurs="0"/>
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
    "servicePortfolioRS"
})
@XmlRootElement(name = "ServicePortfolioResponse")
public class ServicePortfolioResponse {

    @XmlElement(name = "ServicePortfolioRS")
    protected JPStaticDataRS servicePortfolioRS;

    /**
     * Gets the value of the servicePortfolioRS property.
     * 
     * @return
     *     possible object is
     *     {@link JPStaticDataRS }
     *     
     */
    public JPStaticDataRS getServicePortfolioRS() {
        return servicePortfolioRS;
    }

    /**
     * Sets the value of the servicePortfolioRS property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPStaticDataRS }
     *     
     */
    public void setServicePortfolioRS(JPStaticDataRS value) {
        this.servicePortfolioRS = value;
    }

}
