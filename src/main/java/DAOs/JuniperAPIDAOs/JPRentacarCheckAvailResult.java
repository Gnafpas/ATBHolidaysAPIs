
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_RentacarCheckAvailResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_RentacarCheckAvailResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentacarInfo" type="{http://www.juniper.es/webservice/2007/}JP_RentacarInfo" minOccurs="0"/>
 *         &lt;element name="OriginZoneName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="DestinationZoneName" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="ExternalProduct" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Order" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RentacarOptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RentacarCheckAvailOption" minOccurs="0"/>
 *         &lt;element name="Supplier" type="{http://www.juniper.es/webservice/2007/}JP_Supplier" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OriginZone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DestinationZone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_RentacarCheckAvailResult", propOrder = {
    "rentacarInfo",
    "originZoneName",
    "destinationZoneName",
    "externalProduct",
    "order",
    "rentacarOptions",
    "supplier"
})
public class JPRentacarCheckAvailResult {

    @XmlElement(name = "RentacarInfo")
    protected JPRentacarInfo rentacarInfo;
    @XmlElement(name = "OriginZoneName")
    protected Object originZoneName;
    @XmlElement(name = "DestinationZoneName")
    protected Object destinationZoneName;
    @XmlElement(name = "ExternalProduct")
    protected Boolean externalProduct;
    @XmlElement(name = "Order")
    protected Integer order;
    @XmlElement(name = "RentacarOptions")
    protected ArrayOfJPRentacarCheckAvailOption rentacarOptions;
    @XmlElement(name = "Supplier")
    protected JPSupplier supplier;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "OriginZone")
    protected String originZone;
    @XmlAttribute(name = "DestinationZone")
    protected String destinationZone;

    /**
     * Gets the value of the rentacarInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPRentacarInfo }
     *     
     */
    public JPRentacarInfo getRentacarInfo() {
        return rentacarInfo;
    }

    /**
     * Sets the value of the rentacarInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPRentacarInfo }
     *     
     */
    public void setRentacarInfo(JPRentacarInfo value) {
        this.rentacarInfo = value;
    }

    /**
     * Gets the value of the originZoneName property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getOriginZoneName() {
        return originZoneName;
    }

    /**
     * Sets the value of the originZoneName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setOriginZoneName(Object value) {
        this.originZoneName = value;
    }

    /**
     * Gets the value of the destinationZoneName property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDestinationZoneName() {
        return destinationZoneName;
    }

    /**
     * Sets the value of the destinationZoneName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDestinationZoneName(Object value) {
        this.destinationZoneName = value;
    }

    /**
     * Gets the value of the externalProduct property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExternalProduct() {
        return externalProduct;
    }

    /**
     * Sets the value of the externalProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExternalProduct(Boolean value) {
        this.externalProduct = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrder(Integer value) {
        this.order = value;
    }

    /**
     * Gets the value of the rentacarOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRentacarCheckAvailOption }
     *     
     */
    public ArrayOfJPRentacarCheckAvailOption getRentacarOptions() {
        return rentacarOptions;
    }

    /**
     * Sets the value of the rentacarOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRentacarCheckAvailOption }
     *     
     */
    public void setRentacarOptions(ArrayOfJPRentacarCheckAvailOption value) {
        this.rentacarOptions = value;
    }

    /**
     * Gets the value of the supplier property.
     * 
     * @return
     *     possible object is
     *     {@link JPSupplier }
     *     
     */
    public JPSupplier getSupplier() {
        return supplier;
    }

    /**
     * Sets the value of the supplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPSupplier }
     *     
     */
    public void setSupplier(JPSupplier value) {
        this.supplier = value;
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

    /**
     * Gets the value of the originZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginZone() {
        return originZone;
    }

    /**
     * Sets the value of the originZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginZone(String value) {
        this.originZone = value;
    }

    /**
     * Gets the value of the destinationZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationZone() {
        return destinationZone;
    }

    /**
     * Sets the value of the destinationZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationZone(String value) {
        this.destinationZone = value;
    }

}
