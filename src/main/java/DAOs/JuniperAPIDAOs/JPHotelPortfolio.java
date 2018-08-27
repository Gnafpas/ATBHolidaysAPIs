
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelPortfolio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelPortfolio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Hotel" type="{http://www.juniper.es/webservice/2007/}JP_ExtendedHotelInfo" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "JP_HotelPortfolio", propOrder = {
    "hotel"
})
public class JPHotelPortfolio {

    @XmlElement(name = "Hotel")
    protected List<JPExtendedHotelInfo> hotel;
    @XmlAttribute(name = "Page", required = true)
    protected int page;
    @XmlAttribute(name = "RecordsPerPage", required = true)
    protected int recordsPerPage;
    @XmlAttribute(name = "TotalPages", required = true)
    protected int totalPages;
    @XmlAttribute(name = "TotalRecords", required = true)
    protected int totalRecords;

    /**
     * Gets the value of the hotel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPExtendedHotelInfo }
     * 
     * 
     */
    public List<JPExtendedHotelInfo> getHotel() {
        if (hotel == null) {
            hotel = new ArrayList<JPExtendedHotelInfo>();
        }
        return this.hotel;
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
