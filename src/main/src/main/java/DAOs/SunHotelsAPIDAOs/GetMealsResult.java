
package DAOs.SunHotelsAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMealsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMealsResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xml.sunhotels.net/15/}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="meals" type="{http://xml.sunhotels.net/15/}ArrayOfMealWithLabels" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMealsResult", propOrder = {
    "meals"
})
public class GetMealsResult
    extends BaseResult
{

    protected ArrayOfMealWithLabels meals;

    /**
     * Gets the value of the meals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMealWithLabels }
     *     
     */
    public ArrayOfMealWithLabels getMeals() {
        return meals;
    }

    /**
     * Sets the value of the meals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMealWithLabels }
     *     
     */
    public void setMeals(ArrayOfMealWithLabels value) {
        this.meals = value;
    }

}
