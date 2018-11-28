
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_GenericCatalogueItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_GenericCatalogueItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CatalogueItem" type="{http://www.juniper.es/webservice/2007/}JP_GenericCatalogueItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_GenericCatalogueItem", propOrder = {
    "catalogueItem"
})
public class ArrayOfJPGenericCatalogueItem {

    @XmlElement(name = "CatalogueItem")
    protected List<JPGenericCatalogueItem> catalogueItem;

    /**
     * Gets the value of the catalogueItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the catalogueItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCatalogueItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPGenericCatalogueItem }
     * 
     * 
     */
    public List<JPGenericCatalogueItem> getCatalogueItem() {
        if (catalogueItem == null) {
            catalogueItem = new ArrayList<JPGenericCatalogueItem>();
        }
        return this.catalogueItem;
    }

}
