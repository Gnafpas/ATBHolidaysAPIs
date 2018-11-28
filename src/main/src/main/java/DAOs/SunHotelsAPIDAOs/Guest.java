
package DAOs.SunHotelsAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Guest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Guest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="price" type="{http://xml.sunhotels.net/15/}Price" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="total" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="age" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Guest", propOrder = {
    "price"
})
public class Guest {

    protected List<Price> price;
    @XmlAttribute(name = "total")
    protected String total;
    @XmlAttribute(name = "age")
    protected String age;

    /**
     * Gets the value of the price property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the price property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Price }
     * 
     * 
     */
    public List<Price> getPrice() {
        if (price == null) {
            price = new ArrayList<Price>();
        }
        return this.price;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotal(String value) {
        this.total = value;
    }

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAge(String value) {
        this.age = value;
    }

}
