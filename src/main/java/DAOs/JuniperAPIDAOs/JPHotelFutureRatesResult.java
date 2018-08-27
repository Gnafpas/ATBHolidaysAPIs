
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_HotelFutureRatesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_HotelFutureRatesResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResultInfo" type="{http://www.juniper.es/webservice/2007/}JP_FutureRatesResultInfo" minOccurs="0"/>
 *         &lt;element name="HotelResult" type="{http://www.juniper.es/webservice/2007/}JP_HotelResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_HotelFutureRatesResult", propOrder = {
    "resultInfo",
    "hotelResult"
})
public class JPHotelFutureRatesResult {

    @XmlElement(name = "ResultInfo")
    protected JPFutureRatesResultInfo resultInfo;
    @XmlElement(name = "HotelResult")
    protected JPHotelResult hotelResult;

    /**
     * Gets the value of the resultInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JPFutureRatesResultInfo }
     *     
     */
    public JPFutureRatesResultInfo getResultInfo() {
        return resultInfo;
    }

    /**
     * Sets the value of the resultInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPFutureRatesResultInfo }
     *     
     */
    public void setResultInfo(JPFutureRatesResultInfo value) {
        this.resultInfo = value;
    }

    /**
     * Gets the value of the hotelResult property.
     * 
     * @return
     *     possible object is
     *     {@link JPHotelResult }
     *     
     */
    public JPHotelResult getHotelResult() {
        return hotelResult;
    }

    /**
     * Sets the value of the hotelResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JPHotelResult }
     *     
     */
    public void setHotelResult(JPHotelResult value) {
        this.hotelResult = value;
    }

}
