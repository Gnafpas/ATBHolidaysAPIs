
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetThemesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetThemesResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="themes" type="{http://xml.sunhotels.net/15/}ArrayOfTheme" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetThemesResult", propOrder = {
    "themes"
})
public class GetThemesResult
    extends BaseResult
{

    protected ArrayOfTheme themes;

    /**
     * Gets the value of the themes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTheme }
     *     
     */
    public ArrayOfTheme getThemes() {
        return themes;
    }

    /**
     * Sets the value of the themes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTheme }
     *     
     */
    public void setThemes(ArrayOfTheme value) {
        this.themes = value;
    }

}
