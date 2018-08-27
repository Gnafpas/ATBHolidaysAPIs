
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ConceptBreakdown complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ConceptBreakdown">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Items" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ItemBreakdown" minOccurs="0"/>
 *         &lt;element name="Taxes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CommonPriceBreakdown" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="BAS"/>
 *             &lt;enumeration value="SUP"/>
 *             &lt;enumeration value="OFE"/>
 *             &lt;enumeration value="HFE"/>
 *             &lt;enumeration value="TAS"/>
 *             &lt;enumeration value="PRO"/>
 *             &lt;enumeration value="DTO"/>
 *             &lt;enumeration value="OTH"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RelationalCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ConceptBreakdown", propOrder = {
    "items",
    "taxes"
})
public class JPConceptBreakdown {

    @XmlElement(name = "Items")
    protected ArrayOfJPItemBreakdown items;
    @XmlElement(name = "Taxes")
    protected ArrayOfJPCommonPriceBreakdown taxes;
    @XmlAttribute(name = "Type")
    protected String type;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "RelationalCode")
    protected String relationalCode;

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPItemBreakdown }
     *     
     */
    public ArrayOfJPItemBreakdown getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPItemBreakdown }
     *     
     */
    public void setItems(ArrayOfJPItemBreakdown value) {
        this.items = value;
    }

    /**
     * Gets the value of the taxes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCommonPriceBreakdown }
     *     
     */
    public ArrayOfJPCommonPriceBreakdown getTaxes() {
        return taxes;
    }

    /**
     * Sets the value of the taxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCommonPriceBreakdown }
     *     
     */
    public void setTaxes(ArrayOfJPCommonPriceBreakdown value) {
        this.taxes = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the relationalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationalCode() {
        return relationalCode;
    }

    /**
     * Sets the value of the relationalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationalCode(String value) {
        this.relationalCode = value;
    }

}
