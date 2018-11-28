
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelItemStaticData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelItemStaticData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomCategoryList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RoomCategory" minOccurs="0"/>
 *         &lt;element name="RoomList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelRoomCode" minOccurs="0"/>
 *         &lt;element name="HotelCategoryList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelCategory" minOccurs="0"/>
 *         &lt;element name="HotelTypeList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelType" minOccurs="0"/>
 *         &lt;element name="BoardList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Board" minOccurs="0"/>
 *         &lt;element name="BoardCodeList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Board" minOccurs="0"/>
 *         &lt;element name="OfferSupplementTypeList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_OfferSupplementType" minOccurs="0"/>
 *         &lt;element name="SpecialSupplementTypeList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_SpecialSupplementType" minOccurs="0"/>
 *         &lt;element name="ContractTypeList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_HotelContractType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelItemStaticData", propOrder = {
    "roomCategoryList",
    "roomList",
    "hotelCategoryList",
    "hotelTypeList",
    "boardList",
    "boardCodeList",
    "offerSupplementTypeList",
    "specialSupplementTypeList",
    "contractTypeList"
})
public class JPHotelItemStaticData {

    @XmlElement(name = "RoomCategoryList")
    protected ArrayOfJPRoomCategory roomCategoryList;
    @XmlElement(name = "RoomList")
    protected ArrayOfJPHotelRoomCode roomList;
    @XmlElement(name = "HotelCategoryList")
    protected ArrayOfJPHotelCategory hotelCategoryList;
    @XmlElement(name = "HotelTypeList")
    protected ArrayOfJPHotelType hotelTypeList;
    @XmlElement(name = "BoardList")
    protected ArrayOfJPBoard boardList;
    @XmlElement(name = "BoardCodeList")
    protected ArrayOfJPBoard boardCodeList;
    @XmlElement(name = "OfferSupplementTypeList")
    protected ArrayOfJPOfferSupplementType offerSupplementTypeList;
    @XmlElement(name = "SpecialSupplementTypeList")
    protected ArrayOfJPSpecialSupplementType specialSupplementTypeList;
    @XmlElement(name = "ContractTypeList")
    protected ArrayOfJPHotelContractType contractTypeList;

    /**
     * Gets the value of the roomCategoryList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRoomCategory }
     *     
     */
    public ArrayOfJPRoomCategory getRoomCategoryList() {
        return roomCategoryList;
    }

    /**
     * Sets the value of the roomCategoryList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRoomCategory }
     *     
     */
    public void setRoomCategoryList(ArrayOfJPRoomCategory value) {
        this.roomCategoryList = value;
    }

    /**
     * Gets the value of the roomList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelRoomCode }
     *     
     */
    public ArrayOfJPHotelRoomCode getRoomList() {
        return roomList;
    }

    /**
     * Sets the value of the roomList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelRoomCode }
     *     
     */
    public void setRoomList(ArrayOfJPHotelRoomCode value) {
        this.roomList = value;
    }

    /**
     * Gets the value of the hotelCategoryList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelCategory }
     *     
     */
    public ArrayOfJPHotelCategory getHotelCategoryList() {
        return hotelCategoryList;
    }

    /**
     * Sets the value of the hotelCategoryList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelCategory }
     *     
     */
    public void setHotelCategoryList(ArrayOfJPHotelCategory value) {
        this.hotelCategoryList = value;
    }

    /**
     * Gets the value of the hotelTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelType }
     *     
     */
    public ArrayOfJPHotelType getHotelTypeList() {
        return hotelTypeList;
    }

    /**
     * Sets the value of the hotelTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelType }
     *     
     */
    public void setHotelTypeList(ArrayOfJPHotelType value) {
        this.hotelTypeList = value;
    }

    /**
     * Gets the value of the boardList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPBoard }
     *     
     */
    public ArrayOfJPBoard getBoardList() {
        return boardList;
    }

    /**
     * Sets the value of the boardList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPBoard }
     *     
     */
    public void setBoardList(ArrayOfJPBoard value) {
        this.boardList = value;
    }

    /**
     * Gets the value of the boardCodeList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPBoard }
     *     
     */
    public ArrayOfJPBoard getBoardCodeList() {
        return boardCodeList;
    }

    /**
     * Sets the value of the boardCodeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPBoard }
     *     
     */
    public void setBoardCodeList(ArrayOfJPBoard value) {
        this.boardCodeList = value;
    }

    /**
     * Gets the value of the offerSupplementTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPOfferSupplementType }
     *     
     */
    public ArrayOfJPOfferSupplementType getOfferSupplementTypeList() {
        return offerSupplementTypeList;
    }

    /**
     * Sets the value of the offerSupplementTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPOfferSupplementType }
     *     
     */
    public void setOfferSupplementTypeList(ArrayOfJPOfferSupplementType value) {
        this.offerSupplementTypeList = value;
    }

    /**
     * Gets the value of the specialSupplementTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPSpecialSupplementType }
     *     
     */
    public ArrayOfJPSpecialSupplementType getSpecialSupplementTypeList() {
        return specialSupplementTypeList;
    }

    /**
     * Sets the value of the specialSupplementTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPSpecialSupplementType }
     *     
     */
    public void setSpecialSupplementTypeList(ArrayOfJPSpecialSupplementType value) {
        this.specialSupplementTypeList = value;
    }

    /**
     * Gets the value of the contractTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPHotelContractType }
     *     
     */
    public ArrayOfJPHotelContractType getContractTypeList() {
        return contractTypeList;
    }

    /**
     * Sets the value of the contractTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPHotelContractType }
     *     
     */
    public void setContractTypeList(ArrayOfJPHotelContractType value) {
        this.contractTypeList = value;
    }

}
