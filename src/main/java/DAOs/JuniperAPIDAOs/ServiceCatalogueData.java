
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
 *         &lt;element name="ServiceCatalogueDataRQ" type="{http://www.juniper.es/webservice/2007/}JP_ServiceCatalogueDataRQ" minOccurs="0"/>
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
    "serviceCatalogueDataRQ"
})
@XmlRootElement(name = "ServiceCatalogueData")
public class ServiceCatalogueData {

    @XmlElement(name = "ServiceCatalogueDataRQ")
    protected JPServiceCatalogueDataRQ serviceCatalogueDataRQ;

    /**
     * Gets the value of the serviceCatalogueDataRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPServiceCatalogueDataRQ }
     *     
     */
    public JPServiceCatalogueDataRQ getServiceCatalogueDataRQ() {
        return serviceCatalogueDataRQ;
    }

    /**
     * Sets the value of the serviceCatalogueDataRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPServiceCatalogueDataRQ }
     *     
     */
    public void setServiceCatalogueDataRQ(JPServiceCatalogueDataRQ value) {
        this.serviceCatalogueDataRQ = value;
    }

}
