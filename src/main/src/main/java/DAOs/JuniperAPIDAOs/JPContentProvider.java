
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_ContentProvider complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_ContentProvider">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ImageLong" minOccurs="0"/>
 *         &lt;element name="MultimediaContents" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_MultimediaContent" minOccurs="0"/>
 *         &lt;element name="HotelCategory" type="{http://www.juniper.es/webservice/2007/}JP_HotelCategory" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ExternalCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_ContentProvider", propOrder = {
    "images",
    "multimediaContents",
    "hotelCategory"
})
public class JPContentProvider {

    @XmlElement(name = "Images")
    protected ArrayOfJPImageLong images;
    @XmlElement(name = "MultimediaContents")
    protected ArrayOfJPMultimediaContent multimediaContents;
    @XmlElement(name = "HotelCategory")
    protected JPHotelCategory hotelCategory;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "ExternalCode")
    protected String externalCode;

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPImageLong }
     *     
     */
    public ArrayOfJPImageLong getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPImageLong }
     *     
     */
    public void setImages(ArrayOfJPImageLong value) {
        this.images = value;
    }

    /**
     * Gets the value of the multimediaContents property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPMultimediaContent }
     *     
     */
    public ArrayOfJPMultimediaContent getMultimediaContents() {
        return multimediaContents;
    }

    /**
     * Sets the value of the multimediaContents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPMultimediaContent }
     *     
     */
    public void setMultimediaContents(ArrayOfJPMultimediaContent value) {
        this.multimediaContents = value;
    }

    /**
     * Gets the value of the hotelCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelCategory }
     *     
     */
    public JPHotelCategory getHotelCategory() {
        return hotelCategory;
    }

    /**
     * Sets the value of the hotelCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelCategory }
     *     
     */
    public void setHotelCategory(JPHotelCategory value) {
        this.hotelCategory = value;
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
     * Gets the value of the externalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalCode() {
        return externalCode;
    }

    /**
     * Sets the value of the externalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalCode(String value) {
        this.externalCode = value;
    }

}
