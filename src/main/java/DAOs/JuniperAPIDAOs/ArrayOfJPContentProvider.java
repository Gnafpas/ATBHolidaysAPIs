
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJP_ContentProvider complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_ContentProvider">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContentProvider" type="{http://www.juniper.es/webservice/2007/}JP_ContentProvider" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_ContentProvider", propOrder = {
    "contentProvider"
})
public class ArrayOfJPContentProvider {

    @XmlElement(name = "ContentProvider")
    protected List<JPContentProvider> contentProvider;

    /**
     * Gets the value of the contentProvider property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentProvider property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentProvider().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPContentProvider }
     * 
     * 
     */
    public List<JPContentProvider> getContentProvider() {
        if (contentProvider == null) {
            contentProvider = new ArrayList<JPContentProvider>();
        }
        return this.contentProvider;
    }

}
