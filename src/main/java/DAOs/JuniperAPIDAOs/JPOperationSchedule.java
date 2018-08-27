
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_OperationSchedule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_OperationSchedule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OperationTimes" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_OperationTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_OperationSchedule", propOrder = {
    "operationTimes"
})
public class JPOperationSchedule {

    @XmlElement(name = "OperationTimes")
    protected ArrayOfJPOperationTime operationTimes;

    /**
     * Gets the value of the operationTimes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPOperationTime }
     *     
     */
    public ArrayOfJPOperationTime getOperationTimes() {
        return operationTimes;
    }

    /**
     * Sets the value of the operationTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPOperationTime }
     *     
     */
    public void setOperationTimes(ArrayOfJPOperationTime value) {
        this.operationTimes = value;
    }

}
