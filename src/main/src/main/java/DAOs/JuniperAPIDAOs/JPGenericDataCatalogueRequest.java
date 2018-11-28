
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_GenericDataCatalogueRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_GenericDataCatalogueRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Type" type="{http://www.juniper.es/webservice/2007/}JP_GenericCatalogueType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_GenericDataCatalogueRequest")
public class JPGenericDataCatalogueRequest {

    @XmlAttribute(name = "Type")
    protected JPGenericCatalogueType type;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JPGenericCatalogueType }
     *     
     */
    public JPGenericCatalogueType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPGenericCatalogueType }
     *     
     */
    public void setType(JPGenericCatalogueType value) {
        this.type = value;
    }

}
