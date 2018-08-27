
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Ship complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Ship">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Shipping" type="{http://www.juniper.es/webservice/2007/}JP_Shipping" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.juniper.es/webservice/2007/}JP_Description" minOccurs="0"/>
 *         &lt;element name="Images" type="{http://www.juniper.es/webservice/2007/}ArrayOfString1" minOccurs="0"/>
 *         &lt;element name="ImagesLong" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ImageLong" minOccurs="0"/>
 *         &lt;element name="Cruises" type="{http://www.juniper.es/webservice/2007/}JP_CruiseList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Overview" type="{http://www.juniper.es/webservice/2007/}JP_Overview" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Tipstandards" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Serv" type="{http://www.juniper.es/webservice/2007/}JP_CruiseServices" minOccurs="0"/>
 *         &lt;element name="Sport" type="{http://www.juniper.es/webservice/2007/}JP_CruiseSportServices" minOccurs="0"/>
 *         &lt;element name="Nin" type="{http://www.juniper.es/webservice/2007/}JP_CruiseChildServices" minOccurs="0"/>
 *         &lt;element name="Cabin" type="{http://www.juniper.es/webservice/2007/}JP_CruiseCabinServices" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Ship", propOrder = {
    "name",
    "shipping",
    "description",
    "images",
    "imagesLong",
    "cruises",
    "overview",
    "tipstandards",
    "serv",
    "sport",
    "nin",
    "cabin"
})
public class JPShip {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Shipping")
    protected JPShipping shipping;
    @XmlElement(name = "Description")
    protected JPDescription description;
    @XmlElement(name = "Images")
    protected ArrayOfString1 images;
    @XmlElement(name = "ImagesLong")
    protected ArrayOfJPImageLong imagesLong;
    @XmlElement(name = "Cruises")
    protected List<JPCruiseList> cruises;
    @XmlElement(name = "Overview")
    protected List<JPOverview> overview;
    @XmlElement(name = "Tipstandards")
    protected String tipstandards;
    @XmlElement(name = "Serv")
    protected JPCruiseServices serv;
    @XmlElement(name = "Sport")
    protected JPCruiseSportServices sport;
    @XmlElement(name = "Nin")
    protected JPCruiseChildServices nin;
    @XmlElement(name = "Cabin")
    protected JPCruiseCabinServices cabin;
    @XmlAttribute(name = "Code")
    protected String code;

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
     * Gets the value of the shipping property.
     * 
     * @return
     *     possible object is
     *     {@link JPShipping }
     *     
     */
    public JPShipping getShipping() {
        return shipping;
    }

    /**
     * Sets the value of the shipping property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPShipping }
     *     
     */
    public void setShipping(JPShipping value) {
        this.shipping = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JPDescription }
     *     
     */
    public JPDescription getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPDescription }
     *     
     */
    public void setDescription(JPDescription value) {
        this.description = value;
    }

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString1 }
     *     
     */
    public ArrayOfString1 getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString1 }
     *     
     */
    public void setImages(ArrayOfString1 value) {
        this.images = value;
    }

    /**
     * Gets the value of the imagesLong property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPImageLong }
     *     
     */
    public ArrayOfJPImageLong getImagesLong() {
        return imagesLong;
    }

    /**
     * Sets the value of the imagesLong property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPImageLong }
     *     
     */
    public void setImagesLong(ArrayOfJPImageLong value) {
        this.imagesLong = value;
    }

    /**
     * Gets the value of the cruises property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cruises property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCruises().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPCruiseList }
     * 
     * 
     */
    public List<JPCruiseList> getCruises() {
        if (cruises == null) {
            cruises = new ArrayList<JPCruiseList>();
        }
        return this.cruises;
    }

    /**
     * Gets the value of the overview property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the overview property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOverview().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPOverview }
     * 
     * 
     */
    public List<JPOverview> getOverview() {
        if (overview == null) {
            overview = new ArrayList<JPOverview>();
        }
        return this.overview;
    }

    /**
     * Gets the value of the tipstandards property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipstandards() {
        return tipstandards;
    }

    /**
     * Sets the value of the tipstandards property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipstandards(String value) {
        this.tipstandards = value;
    }

    /**
     * Gets the value of the serv property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseServices }
     *     
     */
    public JPCruiseServices getServ() {
        return serv;
    }

    /**
     * Sets the value of the serv property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseServices }
     *     
     */
    public void setServ(JPCruiseServices value) {
        this.serv = value;
    }

    /**
     * Gets the value of the sport property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseSportServices }
     *     
     */
    public JPCruiseSportServices getSport() {
        return sport;
    }

    /**
     * Sets the value of the sport property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseSportServices }
     *     
     */
    public void setSport(JPCruiseSportServices value) {
        this.sport = value;
    }

    /**
     * Gets the value of the nin property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseChildServices }
     *     
     */
    public JPCruiseChildServices getNin() {
        return nin;
    }

    /**
     * Sets the value of the nin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseChildServices }
     *     
     */
    public void setNin(JPCruiseChildServices value) {
        this.nin = value;
    }

    /**
     * Gets the value of the cabin property.
     * 
     * @return
     *     possible object is
     *     {@link JPCruiseCabinServices }
     *     
     */
    public JPCruiseCabinServices getCabin() {
        return cabin;
    }

    /**
     * Sets the value of the cabin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPCruiseCabinServices }
     *     
     */
    public void setCabin(JPCruiseCabinServices value) {
        this.cabin = value;
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

}
