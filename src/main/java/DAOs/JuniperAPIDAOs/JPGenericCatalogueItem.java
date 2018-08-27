
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_GenericCatalogueItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_GenericCatalogueItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemContentList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_GenericCatalogueItemContent" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_GenericCatalogueItem", propOrder = {
    "itemContentList"
})
public class JPGenericCatalogueItem {

    @XmlElement(name = "ItemContentList")
    protected ArrayOfJPGenericCatalogueItemContent itemContentList;
    @XmlAttribute(name = "Code")
    protected String code;

    /**
     * Gets the value of the itemContentList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPGenericCatalogueItemContent }
     *     
     */
    public ArrayOfJPGenericCatalogueItemContent getItemContentList() {
        return itemContentList;
    }

    /**
     * Sets the value of the itemContentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPGenericCatalogueItemContent }
     *     
     */
    public void setItemContentList(ArrayOfJPGenericCatalogueItemContent value) {
        this.itemContentList = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

}
