
package DAOs.SunHotelsAPIDAOs;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReviewValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReviewValues">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="pricevalue" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recommendCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReviewValues", propOrder = {
    "rating",
    "pricevalue",
    "count",
    "recommendCount"
})
public class ReviewValues {

    @XmlElement(required = true)
    protected BigDecimal rating;
    @XmlElement(required = true)
    protected BigDecimal pricevalue;
    protected int count;
    protected int recommendCount;

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRating(BigDecimal value) {
        this.rating = value;
    }

    /**
     * Gets the value of the pricevalue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPricevalue() {
        return pricevalue;
    }

    /**
     * Sets the value of the pricevalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPricevalue(BigDecimal value) {
        this.pricevalue = value;
    }

    /**
     * Gets the value of the count property.
     * 
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     */
    public void setCount(int value) {
        this.count = value;
    }

    /**
     * Gets the value of the recommendCount property.
     * 
     */
    public int getRecommendCount() {
        return recommendCount;
    }

    /**
     * Sets the value of the recommendCount property.
     * 
     */
    public void setRecommendCount(int value) {
        this.recommendCount = value;
    }

}
