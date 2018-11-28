
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JP_BookingListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_BookingListRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StartingBookingDate" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="From" type="{http://www.w3.org/2001/XMLSchema}date" />
 *                 &lt;attribute name="To" type="{http://www.w3.org/2001/XMLSchema}date" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CancellationBookingDate" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="From" type="{http://www.w3.org/2001/XMLSchema}date" />
 *                 &lt;attribute name="To" type="{http://www.w3.org/2001/XMLSchema}date" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ModificationBookingDate" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="From" type="{http://www.w3.org/2001/XMLSchema}date" />
 *                 &lt;attribute name="To" type="{http://www.w3.org/2001/XMLSchema}date" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BookingDate" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="From" type="{http://www.w3.org/2001/XMLSchema}date" />
 *                 &lt;attribute name="To" type="{http://www.w3.org/2001/XMLSchema}date" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ExternalBookingReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_BookingListRequest", propOrder = {
    "startingBookingDate",
    "cancellationBookingDate",
    "modificationBookingDate",
    "bookingDate",
    "externalBookingReference"
})
public class JPBookingListRequest {

    @XmlElement(name = "StartingBookingDate")
    protected JPBookingListRequest.StartingBookingDate startingBookingDate;
    @XmlElement(name = "CancellationBookingDate")
    protected JPBookingListRequest.CancellationBookingDate cancellationBookingDate;
    @XmlElement(name = "ModificationBookingDate")
    protected JPBookingListRequest.ModificationBookingDate modificationBookingDate;
    @XmlElement(name = "BookingDate")
    protected JPBookingListRequest.BookingDate bookingDate;
    @XmlElement(name = "ExternalBookingReference")
    protected String externalBookingReference;

    /**
     * Gets the value of the startingBookingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JPBookingListRequest.StartingBookingDate }
     *     
     */
    public JPBookingListRequest.StartingBookingDate getStartingBookingDate() {
        return startingBookingDate;
    }

    /**
     * Sets the value of the startingBookingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBookingListRequest.StartingBookingDate }
     *     
     */
    public void setStartingBookingDate(JPBookingListRequest.StartingBookingDate value) {
        this.startingBookingDate = value;
    }

    /**
     * Gets the value of the cancellationBookingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JPBookingListRequest.CancellationBookingDate }
     *     
     */
    public JPBookingListRequest.CancellationBookingDate getCancellationBookingDate() {
        return cancellationBookingDate;
    }

    /**
     * Sets the value of the cancellationBookingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBookingListRequest.CancellationBookingDate }
     *     
     */
    public void setCancellationBookingDate(JPBookingListRequest.CancellationBookingDate value) {
        this.cancellationBookingDate = value;
    }

    /**
     * Gets the value of the modificationBookingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JPBookingListRequest.ModificationBookingDate }
     *     
     */
    public JPBookingListRequest.ModificationBookingDate getModificationBookingDate() {
        return modificationBookingDate;
    }

    /**
     * Sets the value of the modificationBookingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBookingListRequest.ModificationBookingDate }
     *     
     */
    public void setModificationBookingDate(JPBookingListRequest.ModificationBookingDate value) {
        this.modificationBookingDate = value;
    }

    /**
     * Gets the value of the bookingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JPBookingListRequest.BookingDate }
     *     
     */
    public JPBookingListRequest.BookingDate getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the value of the bookingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPBookingListRequest.BookingDate }
     *     
     */
    public void setBookingDate(JPBookingListRequest.BookingDate value) {
        this.bookingDate = value;
    }

    /**
     * Gets the value of the externalBookingReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalBookingReference() {
        return externalBookingReference;
    }

    /**
     * Sets the value of the externalBookingReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalBookingReference(String value) {
        this.externalBookingReference = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="From" type="{http://www.w3.org/2001/XMLSchema}date" />
     *       &lt;attribute name="To" type="{http://www.w3.org/2001/XMLSchema}date" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BookingDate {

        @XmlAttribute(name = "From")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar from;
        @XmlAttribute(name = "To")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar to;

        /**
         * Gets the value of the from property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFrom() {
            return from;
        }

        /**
         * Sets the value of the from property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFrom(XMLGregorianCalendar value) {
            this.from = value;
        }

        /**
         * Gets the value of the to property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTo() {
            return to;
        }

        /**
         * Sets the value of the to property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTo(XMLGregorianCalendar value) {
            this.to = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="From" type="{http://www.w3.org/2001/XMLSchema}date" />
     *       &lt;attribute name="To" type="{http://www.w3.org/2001/XMLSchema}date" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CancellationBookingDate {

        @XmlAttribute(name = "From")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar from;
        @XmlAttribute(name = "To")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar to;

        /**
         * Gets the value of the from property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFrom() {
            return from;
        }

        /**
         * Sets the value of the from property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFrom(XMLGregorianCalendar value) {
            this.from = value;
        }

        /**
         * Gets the value of the to property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTo() {
            return to;
        }

        /**
         * Sets the value of the to property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTo(XMLGregorianCalendar value) {
            this.to = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="From" type="{http://www.w3.org/2001/XMLSchema}date" />
     *       &lt;attribute name="To" type="{http://www.w3.org/2001/XMLSchema}date" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ModificationBookingDate {

        @XmlAttribute(name = "From")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar from;
        @XmlAttribute(name = "To")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar to;

        /**
         * Gets the value of the from property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFrom() {
            return from;
        }

        /**
         * Sets the value of the from property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFrom(XMLGregorianCalendar value) {
            this.from = value;
        }

        /**
         * Gets the value of the to property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTo() {
            return to;
        }

        /**
         * Sets the value of the to property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTo(XMLGregorianCalendar value) {
            this.to = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="From" type="{http://www.w3.org/2001/XMLSchema}date" />
     *       &lt;attribute name="To" type="{http://www.w3.org/2001/XMLSchema}date" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class StartingBookingDate {

        @XmlAttribute(name = "From")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar from;
        @XmlAttribute(name = "To")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar to;

        /**
         * Gets the value of the from property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFrom() {
            return from;
        }

        /**
         * Sets the value of the from property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFrom(XMLGregorianCalendar value) {
            this.from = value;
        }

        /**
         * Gets the value of the to property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTo() {
            return to;
        }

        /**
         * Sets the value of the to property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTo(XMLGregorianCalendar value) {
            this.to = value;
        }

    }

}
