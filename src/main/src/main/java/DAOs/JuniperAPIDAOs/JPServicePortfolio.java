
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ServicePortfolio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ServicePortfolio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Service" type="{http://www.juniper.es/webservice/2007/}JP_ServiceSimpleInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Page" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="RecordsPerPage" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="TotalPages" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="TotalRecords" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ServicePortfolio", propOrder = {
    "service"
})
public class JPServicePortfolio {

    @XmlElement(name = "Service")
    protected List<JPServiceSimpleInfo> service;
    @XmlAttribute(name = "Page", required = true)
    protected int page;
    @XmlAttribute(name = "RecordsPerPage", required = true)
    protected int recordsPerPage;
    @XmlAttribute(name = "TotalPages", required = true)
    protected int totalPages;
    @XmlAttribute(name = "TotalRecords", required = true)
    protected int totalRecords;

    /**
     * Gets the value of the service property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the service property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPServiceSimpleInfo }
     * 
     * 
     */
    public List<JPServiceSimpleInfo> getService() {
        if (service == null) {
            service = new ArrayList<JPServiceSimpleInfo>();
        }
        return this.service;
    }

    /**
     * Gets the value of the page property.
     * 
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     */
    public void setPage(int value) {
        this.page = value;
    }

    /**
     * Gets the value of the recordsPerPage property.
     * 
     */
    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    /**
     * Sets the value of the recordsPerPage property.
     * 
     */
    public void setRecordsPerPage(int value) {
        this.recordsPerPage = value;
    }

    /**
     * Gets the value of the totalPages property.
     * 
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * Sets the value of the totalPages property.
     * 
     */
    public void setTotalPages(int value) {
        this.totalPages = value;
    }

    /**
     * Gets the value of the totalRecords property.
     * 
     */
    public int getTotalRecords() {
        return totalRecords;
    }

    /**
     * Sets the value of the totalRecords property.
     * 
     */
    public void setTotalRecords(int value) {
        this.totalRecords = value;
    }

}
