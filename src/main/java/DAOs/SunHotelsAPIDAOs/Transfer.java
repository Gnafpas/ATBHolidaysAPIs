
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Transfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Transfer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}NonStaticTransfer">
 *       &lt;sequence>
 *         &lt;element name="transferTypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="minimumPassengers" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maximumPassengers" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estimatedTimeInHours" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estimatedTimeInMinutes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transfer", propOrder = {
    "transferTypeId",
    "minimumPassengers",
    "maximumPassengers",
    "estimatedTimeInHours",
    "estimatedTimeInMinutes"
})
@XmlSeeAlso({
    StaticTransfer.class
})
public class Transfer
    extends NonStaticTransfer
{

    protected int transferTypeId;
    protected int minimumPassengers;
    protected int maximumPassengers;
    protected int estimatedTimeInHours;
    protected int estimatedTimeInMinutes;

    /**
     * Gets the value of the transferTypeId property.
     * 
     */
    public int getTransferTypeId() {
        return transferTypeId;
    }

    /**
     * Sets the value of the transferTypeId property.
     * 
     */
    public void setTransferTypeId(int value) {
        this.transferTypeId = value;
    }

    /**
     * Gets the value of the minimumPassengers property.
     * 
     */
    public int getMinimumPassengers() {
        return minimumPassengers;
    }

    /**
     * Sets the value of the minimumPassengers property.
     * 
     */
    public void setMinimumPassengers(int value) {
        this.minimumPassengers = value;
    }

    /**
     * Gets the value of the maximumPassengers property.
     * 
     */
    public int getMaximumPassengers() {
        return maximumPassengers;
    }

    /**
     * Sets the value of the maximumPassengers property.
     * 
     */
    public void setMaximumPassengers(int value) {
        this.maximumPassengers = value;
    }

    /**
     * Gets the value of the estimatedTimeInHours property.
     * 
     */
    public int getEstimatedTimeInHours() {
        return estimatedTimeInHours;
    }

    /**
     * Sets the value of the estimatedTimeInHours property.
     * 
     */
    public void setEstimatedTimeInHours(int value) {
        this.estimatedTimeInHours = value;
    }

    /**
     * Gets the value of the estimatedTimeInMinutes property.
     * 
     */
    public int getEstimatedTimeInMinutes() {
        return estimatedTimeInMinutes;
    }

    /**
     * Sets the value of the estimatedTimeInMinutes property.
     * 
     */
    public void setEstimatedTimeInMinutes(int value) {
        this.estimatedTimeInMinutes = value;
    }

}
