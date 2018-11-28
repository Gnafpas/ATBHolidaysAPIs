
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelInfo" type="{http://www.juniper.es/webservice/2007/}JP_HotelInfo" minOccurs="0"/>
 *         &lt;element name="HotelOptions" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelOption" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="JPCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OriginZone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="JPDCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ResultType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SubType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BestDeal" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="DestinationZone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelResult", propOrder = {
    "hotelInfo",
    "hotelOptions"
})
public class JPHotelResult {

    @XmlElement(name = "HotelInfo")
    protected JPHotelInfo hotelInfo;
    @XmlElement(name = "HotelOptions")
    protected ArrayOfJPHotelOption hotelOptions;
    @XmlAttribute(name = "Code")
    protected String code;
    @XmlAttribute(name = "JPCode")
    protected String jpCode;
    @XmlAttribute(name = "OriginZone")
    protected String originZone;
    @XmlAttribute(name = "JPDCode")
    protected String jpdCode;
    @XmlAttribute(name = "ResultType")
    protected String resultType;
    @XmlAttribute(name = "SubType")
    protected String subType;
    @XmlAttribute(name = "BestDeal")
    protected Boolean bestDeal;
    @XmlAttribute(name = "DestinationZone")
    protected String destinationZone;

    /**
     * Gets the value of the hotelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelInfo }
     *     
     */
    public JPHotelInfo getHotelInfo() {
        return hotelInfo;
    }

    /**
     * Sets the value of the hotelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelInfo }
     *     
     */
    public void setHotelInfo(JPHotelInfo value) {
        this.hotelInfo = value;
    }

    /**
     * Gets the value of the hotelOptions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelOption }
     *     
     */
    public ArrayOfJPHotelOption getHotelOptions() {
        return hotelOptions;
    }

    /**
     * Sets the value of the hotelOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelOption }
     *     
     */
    public void setHotelOptions(ArrayOfJPHotelOption value) {
        this.hotelOptions = value;
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
     * Gets the value of the jpCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJPCode() {
        return jpCode;
    }

    /**
     * Sets the value of the jpCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJPCode(String value) {
        this.jpCode = value;
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
     * Gets the value of the jpdCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJPDCode() {
        return jpdCode;
    }

    /**
     * Sets the value of the jpdCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJPDCode(String value) {
        this.jpdCode = value;
    }

    /**
     * Gets the value of the resultType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultType() {
        return resultType;
    }

    /**
     * Sets the value of the resultType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultType(String value) {
        this.resultType = value;
    }

    /**
     * Gets the value of the subType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubType() {
        return subType;
    }

    /**
     * Sets the value of the subType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubType(String value) {
        this.subType = value;
    }

    /**
     * Gets the value of the bestDeal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBestDeal() {
        return bestDeal;
    }

    /**
     * Sets the value of the bestDeal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBestDeal(Boolean value) {
        this.bestDeal = value;
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
