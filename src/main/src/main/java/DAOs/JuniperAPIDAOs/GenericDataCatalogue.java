
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
 *         &lt;element name="GenericDataCatalogueRQ" type="{http://www.juniper.es/webservice/2007/}JP_GenericDataCatalogueRQ" minOccurs="0"/>
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
    "genericDataCatalogueRQ"
})
@XmlRootElement(name = "GenericDataCatalogue")
public class GenericDataCatalogue {

    @XmlElement(name = "GenericDataCatalogueRQ")
    protected JPGenericDataCatalogueRQ genericDataCatalogueRQ;

    /**
     * Gets the value of the genericDataCatalogueRQ property.
     * 
     * @return
     *     possible object is
     *     {@link JPGenericDataCatalogueRQ }
     *     
     */
    public JPGenericDataCatalogueRQ getGenericDataCatalogueRQ() {
        return genericDataCatalogueRQ;
    }

    /**
     * Sets the value of the genericDataCatalogueRQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPGenericDataCatalogueRQ }
     *     
     */
    public void setGenericDataCatalogueRQ(JPGenericDataCatalogueRQ value) {
        this.genericDataCatalogueRQ = value;
    }

}
