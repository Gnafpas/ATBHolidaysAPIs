
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookResult" type="{http://xml.sunhotels.net/15/}BookResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bookResult"
})
@XmlRootElement(name = "BookResponse")
public class BookResponse {

    @XmlElement(required = true, nillable = true)
    protected BookResult bookResult;

    /**
     * Gets the value of the bookResult property.
     * 
     * @return
     *     possible object is
     *     {@link BookResult }
     *     
     */
    public BookResult getBookResult() {
        return bookResult;
    }

    /**
     * Sets the value of the bookResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookResult }
     *     
     */
    public void setBookResult(BookResult value) {
        this.bookResult = value;
    }

}
