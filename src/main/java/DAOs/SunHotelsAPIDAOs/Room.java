
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Room complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Room">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="beds" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="extrabeds" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="meals" type="{http://xml.sunhotels.net/15/}ArrayOfRoomMeal" minOccurs="0"/>
 *         &lt;element name="cancellation_policies" type="{http://xml.sunhotels.net/15/}ArrayOfPercentageCancellationPolicy" minOccurs="0"/>
 *         &lt;element name="notes" type="{http://xml.sunhotels.net/15/}ArrayOfCalendarNote" minOccurs="0"/>
 *         &lt;element name="isSuperDeal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isBestBuy" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="paymentMethods" type="{http://xml.sunhotels.net/15/}ArrayOfRoomPaymentMethod" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Room", propOrder = {
    "id",
    "beds",
    "extrabeds",
    "meals",
    "cancellationPolicies",
    "notes",
    "isSuperDeal",
    "isBestBuy",
    "paymentMethods"
})
@XmlSeeAlso({
    StaticRoom.class
})
public class Room {

    protected int id;
    protected int beds;
    protected int extrabeds;
    protected ArrayOfRoomMeal meals;
    @XmlElement(name = "cancellation_policies")
    protected ArrayOfPercentageCancellationPolicy cancellationPolicies;
    protected ArrayOfCalendarNote notes;
    protected boolean isSuperDeal;
    protected boolean isBestBuy;
    protected ArrayOfRoomPaymentMethod paymentMethods;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the beds property.
     * 
     */
    public int getBeds() {
        return beds;
    }

    /**
     * Sets the value of the beds property.
     * 
     */
    public void setBeds(int value) {
        this.beds = value;
    }

    /**
     * Gets the value of the extrabeds property.
     * 
     */
    public int getExtrabeds() {
        return extrabeds;
    }

    /**
     * Sets the value of the extrabeds property.
     * 
     */
    public void setExtrabeds(int value) {
        this.extrabeds = value;
    }

    /**
     * Gets the value of the meals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomMeal }
     *     
     */
    public ArrayOfRoomMeal getMeals() {
        return meals;
    }

    /**
     * Sets the value of the meals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomMeal }
     *     
     */
    public void setMeals(ArrayOfRoomMeal value) {
        this.meals = value;
    }

    /**
     * Gets the value of the cancellationPolicies property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPercentageCancellationPolicy }
     *     
     */
    public ArrayOfPercentageCancellationPolicy getCancellationPolicies() {
        return cancellationPolicies;
    }

    /**
     * Sets the value of the cancellationPolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPercentageCancellationPolicy }
     *     
     */
    public void setCancellationPolicies(ArrayOfPercentageCancellationPolicy value) {
        this.cancellationPolicies = value;
    }

    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCalendarNote }
     *     
     */
    public ArrayOfCalendarNote getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCalendarNote }
     *     
     */
    public void setNotes(ArrayOfCalendarNote value) {
        this.notes = value;
    }

    /**
     * Gets the value of the isSuperDeal property.
     * 
     */
    public boolean isIsSuperDeal() {
        return isSuperDeal;
    }

    /**
     * Sets the value of the isSuperDeal property.
     * 
     */
    public void setIsSuperDeal(boolean value) {
        this.isSuperDeal = value;
    }

    /**
     * Gets the value of the isBestBuy property.
     * 
     */
    public boolean isIsBestBuy() {
        return isBestBuy;
    }

    /**
     * Sets the value of the isBestBuy property.
     * 
     */
    public void setIsBestBuy(boolean value) {
        this.isBestBuy = value;
    }

    /**
     * Gets the value of the paymentMethods property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRoomPaymentMethod }
     *     
     */
    public ArrayOfRoomPaymentMethod getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * Sets the value of the paymentMethods property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRoomPaymentMethod }
     *     
     */
    public void setPaymentMethods(ArrayOfRoomPaymentMethod value) {
        this.paymentMethods = value;
    }

}
