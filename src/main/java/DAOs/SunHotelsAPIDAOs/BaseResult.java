
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Error" type="{http://xml.sunhotels.net/15/}ErrorObject" minOccurs="0"/>
 *         &lt;element name="ErrorAttributes" type="{http://xml.sunhotels.net/15/}ArrayOfErrorAttribute" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseResult", propOrder = {
    "error",
    "errorAttributes"
})
@XmlSeeAlso({
    GetFeaturesResult.class,
    CancellationResult.class,
    GetLanguagesResult.class,
    BookResult.class,
    GetThemesResult.class,
    GetSpecialRequestResult.class,
    GetRoomTypesResult.class,
    GetTransferTypesResult.class,
    AddTransferResult.class,
    ResortList.class,
    GetStaticHotelsAndRoomsResult.class,
    GetRoomNoteTypesResult.class,
    GetMealsResult.class,
    DestinationList.class,
    SearchResult.class,
    GetHotelNoteTypesResult.class,
    GetTransferBookingInformationResult.class,
    AmendmentPriceRequestResult.class,
    PreBookResult.class,
    CancelTransferBookingResult.class,
    AmendmentRequestResult.class,
    GetBookingInformationResult.class,
    SearchTransfersResult.class,
    UpdateSpecialRequestResult.class,
    Booking.class
})
public class BaseResult {

    @XmlElement(name = "Error")
    protected ErrorObject error;
    @XmlElement(name = "ErrorAttributes")
    protected ArrayOfErrorAttribute errorAttributes;

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorObject }
     *     
     */
    public ErrorObject getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorObject }
     *     
     */
    public void setError(ErrorObject value) {
        this.error = value;
    }

    /**
     * Gets the value of the errorAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfErrorAttribute }
     *     
     */
    public ArrayOfErrorAttribute getErrorAttributes() {
        return errorAttributes;
    }

    /**
     * Sets the value of the errorAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfErrorAttribute }
     *     
     */
    public void setErrorAttributes(ArrayOfErrorAttribute value) {
        this.errorAttributes = value;
    }

}
