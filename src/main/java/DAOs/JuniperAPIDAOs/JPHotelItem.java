
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_HotelItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.juniper.es/webservice/2007/}JP_BaseItem">
 *       &lt;sequence>
 *         &lt;element name="HotelInfo" type="{http://www.juniper.es/webservice/2007/}JP_ItemHotelInfo" minOccurs="0"/>
 *         &lt;element name="Board" type="{http://www.juniper.es/webservice/2007/}JP_Board" minOccurs="0"/>
 *         &lt;element name="HotelRooms" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_ItemHotelRoom" minOccurs="0"/>
 *         &lt;element name="AdditionalElements" type="{http://www.juniper.es/webservice/2007/}JP_HotelAdditionalElements" minOccurs="0"/>
 *         &lt;element name="Supplier" type="{http://www.juniper.es/webservice/2007/}JP_Supplier" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Start" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="End" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="PaymentDestination" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelItem", propOrder = {
    "hotelInfo",
    "board",
    "hotelRooms",
    "additionalElements",
    "supplier"
})
public class JPHotelItem
    extends JPBaseItem
{

    @XmlElement(name = "HotelInfo")
    protected JPItemHotelInfo hotelInfo;
    @XmlElement(name = "Board")
    protected JPBoard board;
    @XmlElement(name = "HotelRooms")
    protected ArrayOfJPItemHotelRoom hotelRooms;
    @XmlElement(name = "AdditionalElements")
    protected JPHotelAdditionalElements additionalElements;
    @XmlElement(name = "Supplier")
    protected JPSupplier supplier;
    @XmlAttribute(name = "Start")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar start;
    @XmlAttribute(name = "End")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar end;
    @XmlAttribute(name = "PaymentDestination")
    protected Boolean paymentDestination;

    /**
     * Gets the value of the hotelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPItemHotelInfo }
     *     
     */
    public JPItemHotelInfo getHotelInfo() {
        return hotelInfo;
    }

    /**
     * Sets the value of the hotelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPItemHotelInfo }
     *     
     */
    public void setHotelInfo(JPItemHotelInfo value) {
        this.hotelInfo = value;
    }

    /**
     * Gets the value of the board property.
     * 
     * @return
     *     possible object is
     *     {@link JPBoard }
     *     
     */
    public JPBoard getBoard() {
        return board;
    }

    /**
     * Sets the value of the board property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBoard }
     *     
     */
    public void setBoard(JPBoard value) {
        this.board = value;
    }

    /**
     * Gets the value of the hotelRooms property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPItemHotelRoom }
     *     
     */
    public ArrayOfJPItemHotelRoom getHotelRooms() {
        return hotelRooms;
    }

    /**
     * Sets the value of the hotelRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPItemHotelRoom }
     *     
     */
    public void setHotelRooms(ArrayOfJPItemHotelRoom value) {
        this.hotelRooms = value;
    }

    /**
     * Gets the value of the additionalElements property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelAdditionalElements }
     *     
     */
    public JPHotelAdditionalElements getAdditionalElements() {
        return additionalElements;
    }

    /**
     * Sets the value of the additionalElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelAdditionalElements }
     *     
     */
    public void setAdditionalElements(JPHotelAdditionalElements value) {
        this.additionalElements = value;
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
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStart(XMLGregorianCalendar value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnd(XMLGregorianCalendar value) {
        this.end = value;
    }

    /**
     * Gets the value of the paymentDestination property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPaymentDestination() {
        return paymentDestination;
    }

    /**
     * Sets the value of the paymentDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPaymentDestination(Boolean value) {
        this.paymentDestination = value;
    }

}
