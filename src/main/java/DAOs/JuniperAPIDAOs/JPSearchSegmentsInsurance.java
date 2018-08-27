
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_SearchSegmentsInsurance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_SearchSegmentsInsurance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSegmentInsurance" type="{http://www.juniper.es/webservice/2007/}JP_SearchSegmentInsurance" minOccurs="0"/>
 *         &lt;element name="CountryOfResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Suppliers" type="{http://www.juniper.es/webservice/2007/}ArrayOfString5" minOccurs="0"/>
 *         &lt;element name="ProductTypes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ProductType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_SearchSegmentsInsurance", propOrder = {
    "searchSegmentInsurance",
    "countryOfResidence",
    "suppliers",
    "productTypes"
})
public class JPSearchSegmentsInsurance {

    @XmlElement(name = "SearchSegmentInsurance")
    protected JPSearchSegmentInsurance searchSegmentInsurance;
    @XmlElement(name = "CountryOfResidence")
    protected String countryOfResidence;
    @XmlElement(name = "Suppliers")
    protected ArrayOfString5 suppliers;
    @XmlElement(name = "ProductTypes")
    protected ArrayOfJPProductType productTypes;

    /**
     * Gets the value of the searchSegmentInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link JPSearchSegmentInsurance }
     *     
     */
    public JPSearchSegmentInsurance getSearchSegmentInsurance() {
        return searchSegmentInsurance;
    }

    /**
     * Sets the value of the searchSegmentInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSearchSegmentInsurance }
     *     
     */
    public void setSearchSegmentInsurance(JPSearchSegmentInsurance value) {
        this.searchSegmentInsurance = value;
    }

    /**
     * Gets the value of the countryOfResidence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    /**
     * Sets the value of the countryOfResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfResidence(String value) {
        this.countryOfResidence = value;
    }

    /**
     * Gets the value of the suppliers property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString5 }
     *     
     */
    public ArrayOfString5 getSuppliers() {
        return suppliers;
    }

    /**
     * Sets the value of the suppliers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString5 }
     *     
     */
    public void setSuppliers(ArrayOfString5 value) {
        this.suppliers = value;
    }

    /**
     * Gets the value of the productTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPProductType }
     *     
     */
    public ArrayOfJPProductType getProductTypes() {
        return productTypes;
    }

    /**
     * Sets the value of the productTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPProductType }
     *     
     */
    public void setProductTypes(ArrayOfJPProductType value) {
        this.productTypes = value;
    }

}
