
package DAOs.JuniperAPIDAOs;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_Overview complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_Overview">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Building" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Span" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Servicelevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tonnage" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Sleeve" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Length" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CabExt" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CabInt" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CabBal" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CapMaxCab" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CapTotal" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Crew" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Decks" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Refurbished" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_Overview", propOrder = {
    "building",
    "span",
    "servicelevel",
    "tonnage",
    "sleeve",
    "length",
    "cabExt",
    "cabInt",
    "cabBal",
    "capMaxCab",
    "capTotal",
    "flag",
    "crew",
    "decks",
    "refurbished"
})
public class JPOverview {

    @XmlElement(name = "Building")
    protected Integer building;
    @XmlElement(name = "Span")
    protected BigDecimal span;
    @XmlElement(name = "Servicelevel")
    protected String servicelevel;
    @XmlElement(name = "Tonnage")
    protected BigDecimal tonnage;
    @XmlElement(name = "Sleeve")
    protected BigDecimal sleeve;
    @XmlElement(name = "Length")
    protected BigDecimal length;
    @XmlElement(name = "CabExt")
    protected Integer cabExt;
    @XmlElement(name = "CabInt")
    protected Integer cabInt;
    @XmlElement(name = "CabBal")
    protected Integer cabBal;
    @XmlElement(name = "CapMaxCab")
    protected Integer capMaxCab;
    @XmlElement(name = "CapTotal")
    protected Integer capTotal;
    @XmlElement(name = "Flag")
    protected String flag;
    @XmlElement(name = "Crew")
    protected String crew;
    @XmlElement(name = "Decks")
    protected Integer decks;
    @XmlElement(name = "Refurbished")
    protected Integer refurbished;

    /**
     * Gets the value of the building property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBuilding() {
        return building;
    }

    /**
     * Sets the value of the building property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBuilding(Integer value) {
        this.building = value;
    }

    /**
     * Gets the value of the span property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpan() {
        return span;
    }

    /**
     * Sets the value of the span property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpan(BigDecimal value) {
        this.span = value;
    }

    /**
     * Gets the value of the servicelevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicelevel() {
        return servicelevel;
    }

    /**
     * Sets the value of the servicelevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicelevel(String value) {
        this.servicelevel = value;
    }

    /**
     * Gets the value of the tonnage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTonnage() {
        return tonnage;
    }

    /**
     * Sets the value of the tonnage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTonnage(BigDecimal value) {
        this.tonnage = value;
    }

    /**
     * Gets the value of the sleeve property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSleeve() {
        return sleeve;
    }

    /**
     * Sets the value of the sleeve property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSleeve(BigDecimal value) {
        this.sleeve = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLength(BigDecimal value) {
        this.length = value;
    }

    /**
     * Gets the value of the cabExt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCabExt() {
        return cabExt;
    }

    /**
     * Sets the value of the cabExt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCabExt(Integer value) {
        this.cabExt = value;
    }

    /**
     * Gets the value of the cabInt property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCabInt() {
        return cabInt;
    }

    /**
     * Sets the value of the cabInt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCabInt(Integer value) {
        this.cabInt = value;
    }

    /**
     * Gets the value of the cabBal property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCabBal() {
        return cabBal;
    }

    /**
     * Sets the value of the cabBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCabBal(Integer value) {
        this.cabBal = value;
    }

    /**
     * Gets the value of the capMaxCab property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCapMaxCab() {
        return capMaxCab;
    }

    /**
     * Sets the value of the capMaxCab property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCapMaxCab(Integer value) {
        this.capMaxCab = value;
    }

    /**
     * Gets the value of the capTotal property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCapTotal() {
        return capTotal;
    }

    /**
     * Sets the value of the capTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCapTotal(Integer value) {
        this.capTotal = value;
    }

    /**
     * Gets the value of the flag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag(String value) {
        this.flag = value;
    }

    /**
     * Gets the value of the crew property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrew() {
        return crew;
    }

    /**
     * Sets the value of the crew property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrew(String value) {
        this.crew = value;
    }

    /**
     * Gets the value of the decks property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDecks() {
        return decks;
    }

    /**
     * Sets the value of the decks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDecks(Integer value) {
        this.decks = value;
    }

    /**
     * Gets the value of the refurbished property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRefurbished() {
        return refurbished;
    }

    /**
     * Sets the value of the refurbished property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRefurbished(Integer value) {
        this.refurbished = value;
    }

}
