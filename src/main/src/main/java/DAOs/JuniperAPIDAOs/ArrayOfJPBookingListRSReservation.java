
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ArrayOfJP_BookingListRSReservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJP_BookingListRSReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reservation" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BookingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Locator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Status" use="required" type="{http://www.juniper.es/webservice/2007/}JP_ResStatus" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJP_BookingListRSReservation", propOrder = {
    "reservation"
})
public class ArrayOfJPBookingListRSReservation {

    @XmlElement(name = "Reservation")
    protected List<ArrayOfJPBookingListRSReservation.Reservation> reservation;

    /**
     * Gets the value of the reservation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reservation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReservation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfJPBookingListRSReservation.Reservation }
     * 
     * 
     */
    public List<ArrayOfJPBookingListRSReservation.Reservation> getReservation() {
        if (reservation == null) {
            reservation = new ArrayList<ArrayOfJPBookingListRSReservation.Reservation>();
        }
        return this.reservation;
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
     *       &lt;sequence>
     *         &lt;element name="BookingDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *       &lt;/sequence>
     *       &lt;attribute name="Locator" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Status" use="required" type="{http://www.juniper.es/webservice/2007/}JP_ResStatus" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bookingDate"
    })
    public static class Reservation {

        @XmlElement(name = "BookingDate", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar bookingDate;
        @XmlAttribute(name = "Locator")
        protected String locator;
        @XmlAttribute(name = "Status", required = true)
        protected JPResStatus status;

        /**
         * Gets the value of the bookingDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getBookingDate() {
            return bookingDate;
        }

        /**
         * Sets the value of the bookingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setBookingDate(XMLGregorianCalendar value) {
            this.bookingDate = value;
        }

        /**
         * Gets the value of the locator property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocator() {
            return locator;
        }

        /**
         * Sets the value of the locator property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocator(String value) {
            this.locator = value;
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link JPResStatus }
         *     
         */
        public JPResStatus getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link JPResStatus }
         *     
         */
        public void setStatus(JPResStatus value) {
            this.status = value;
        }

    }

}
