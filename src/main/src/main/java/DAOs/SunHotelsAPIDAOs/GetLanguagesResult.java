
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetLanguagesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetLanguagesResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="languages" type="{http://xml.sunhotels.net/15/}ArrayOfLanguage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetLanguagesResult", propOrder = {
    "languages"
})
public class GetLanguagesResult
    extends BaseResult
{

    protected ArrayOfLanguage languages;

    /**
     * Gets the value of the languages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLanguage }
     *     
     */
    public ArrayOfLanguage getLanguages() {
        return languages;
    }

    /**
     * Sets the value of the languages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLanguage }
     *     
     */
    public void setLanguages(ArrayOfLanguage value) {
        this.languages = value;
    }

}
