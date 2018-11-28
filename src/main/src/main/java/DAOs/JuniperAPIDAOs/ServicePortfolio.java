
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
 *         &lt;element name="ServicePortfolioRQ" type="{http://www.juniper.es/webservice/2007/}JP_ServicePortfolioRQ" minOccurs="0"/>
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
    "servicePortfolioRQ"
})
@XmlRootElement(name = "ServicePortfolio")
public class ServicePortfolio {

    @XmlElement(name = "ServicePortfolioRQ")
    protected JPServicePortfolioRQ servicePortfolioRQ;

    /**
     * Gets the value of the servicePortfolioRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPServicePortfolioRQ }
     *     
     */
    public JPServicePortfolioRQ getServicePortfolioRQ() {
        return servicePortfolioRQ;
    }

    /**
     * Sets the value of the servicePortfolioRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServicePortfolioRQ }
     *     
     */
    public void setServicePortfolioRQ(JPServicePortfolioRQ value) {
        this.servicePortfolioRQ = value;
    }

}
