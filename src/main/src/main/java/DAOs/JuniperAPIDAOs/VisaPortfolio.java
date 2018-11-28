
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
 *         &lt;element name="VisaPortfolioRQ" type="{http://www.juniper.es/webservice/2007/}JP_VisaPortfolioRQ" minOccurs="0"/>
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
    "visaPortfolioRQ"
})
@XmlRootElement(name = "VisaPortfolio")
public class VisaPortfolio {

    @XmlElement(name = "VisaPortfolioRQ")
    protected JPVisaPortfolioRQ visaPortfolioRQ;

    /**
     * Gets the value of the visaPortfolioRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPVisaPortfolioRQ }
     *     
     */
    public JPVisaPortfolioRQ getVisaPortfolioRQ() {
        return visaPortfolioRQ;
    }

    /**
     * Sets the value of the visaPortfolioRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPVisaPortfolioRQ }
     *     
     */
    public void setVisaPortfolioRQ(JPVisaPortfolioRQ value) {
        this.visaPortfolioRQ = value;
    }

}
