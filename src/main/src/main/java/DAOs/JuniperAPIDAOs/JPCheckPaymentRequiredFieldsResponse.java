
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CheckPaymentRequiredFieldsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CheckPaymentRequiredFieldsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fields" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_RequiredField" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CheckPaymentRequiredFieldsResponse", propOrder = {
    "fields"
})
public class JPCheckPaymentRequiredFieldsResponse {

    @XmlElement(name = "Fields")
    protected ArrayOfJPRequiredField fields;

    /**
     * Gets the value of the fields property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPRequiredField }
     *     
     */
    public ArrayOfJPRequiredField getFields() {
        return fields;
    }

    /**
     * Sets the value of the fields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPRequiredField }
     *     
     */
    public void setFields(ArrayOfJPRequiredField value) {
        this.fields = value;
    }

}
