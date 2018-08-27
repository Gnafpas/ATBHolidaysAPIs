
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseDataRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseDataRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentData" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentShip" minOccurs="0"/>
 *         &lt;element name="IncludeShipInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SelectionCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseDataRequest", propOrder = {
    "searchSegmentData",
    "includeShipInfo"
})
public class JPCruiseDataRequest {

    @XmlElement(name = "SearchSegmentData")
    protected JPSearchSegmentShip searchSegmentData;
    @XmlElement(name = "IncludeShipInfo")
    protected boolean includeShipInfo;
    @XmlAttribute(name = "SelectionCode")
    protected String selectionCode;

    /**
     * Gets the value of the searchSegmentData property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentShip }
     *     
     */
    public JPSearchSegmentShip getSearchSegmentData() {
        return searchSegmentData;
    }

    /**
     * Sets the value of the searchSegmentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentShip }
     *     
     */
    public void setSearchSegmentData(JPSearchSegmentShip value) {
        this.searchSegmentData = value;
    }

    /**
     * Gets the value of the includeShipInfo property.
     * 
     */
    public boolean isIncludeShipInfo() {
        return includeShipInfo;
    }

    /**
     * Sets the value of the includeShipInfo property.
     * 
     */
    public void setIncludeShipInfo(boolean value) {
        this.includeShipInfo = value;
    }

    /**
     * Gets the value of the selectionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectionCode() {
        return selectionCode;
    }

    /**
     * Sets the value of the selectionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectionCode(String value) {
        this.selectionCode = value;
    }

}
