
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchPreSegmentsCruise complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchPreSegmentsCruise">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentCruise" type="{http://www.juniper.es/webservice/2007/}JP_SearchPreSegmentCruise" minOccurs="0"/>
 *         &lt;element name="CruiseSuppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseSupplier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchPreSegmentsCruise", propOrder = {
    "searchSegmentCruise",
    "cruiseSuppliers"
})
public class JPSearchPreSegmentsCruise {

    @XmlElement(name = "SearchSegmentCruise")
    protected JPSearchPreSegmentCruise searchSegmentCruise;
    @XmlElement(name = "CruiseSuppliers")
    protected ArrayOfJPCruiseSupplier cruiseSuppliers;

    /**
     * Gets the value of the searchSegmentCruise property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchPreSegmentCruise }
     *     
     */
    public JPSearchPreSegmentCruise getSearchSegmentCruise() {
        return searchSegmentCruise;
    }

    /**
     * Sets the value of the searchSegmentCruise property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchPreSegmentCruise }
     *     
     */
    public void setSearchSegmentCruise(JPSearchPreSegmentCruise value) {
        this.searchSegmentCruise = value;
    }

    /**
     * Gets the value of the cruiseSuppliers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseSupplier }
     *     
     */
    public ArrayOfJPCruiseSupplier getCruiseSuppliers() {
        return cruiseSuppliers;
    }

    /**
     * Sets the value of the cruiseSuppliers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseSupplier }
     *     
     */
    public void setCruiseSuppliers(ArrayOfJPCruiseSupplier value) {
        this.cruiseSuppliers = value;
    }

}
