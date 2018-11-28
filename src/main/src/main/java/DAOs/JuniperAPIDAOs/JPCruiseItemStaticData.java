
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_CruiseItemStaticData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_CruiseItemStaticData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CruiseItineraryList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseItinerary" minOccurs="0"/>
 *         &lt;element name="CruiseShipList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_Ship" minOccurs="0"/>
 *         &lt;element name="CruiseDataList" type="{http://www.juniper.es/webservice/2007/}ArrayOfJP_CruiseData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_CruiseItemStaticData", propOrder = {
    "cruiseItineraryList",
    "cruiseShipList",
    "cruiseDataList"
})
public class JPCruiseItemStaticData {

    @XmlElement(name = "CruiseItineraryList")
    protected ArrayOfJPCruiseItinerary cruiseItineraryList;
    @XmlElement(name = "CruiseShipList")
    protected ArrayOfJPShip cruiseShipList;
    @XmlElement(name = "CruiseDataList")
    protected ArrayOfJPCruiseData cruiseDataList;

    /**
     * Gets the value of the cruiseItineraryList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseItinerary }
     *     
     */
    public ArrayOfJPCruiseItinerary getCruiseItineraryList() {
        return cruiseItineraryList;
    }

    /**
     * Sets the value of the cruiseItineraryList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseItinerary }
     *     
     */
    public void setCruiseItineraryList(ArrayOfJPCruiseItinerary value) {
        this.cruiseItineraryList = value;
    }

    /**
     * Gets the value of the cruiseShipList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPShip }
     *     
     */
    public ArrayOfJPShip getCruiseShipList() {
        return cruiseShipList;
    }

    /**
     * Sets the value of the cruiseShipList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPShip }
     *     
     */
    public void setCruiseShipList(ArrayOfJPShip value) {
        this.cruiseShipList = value;
    }

    /**
     * Gets the value of the cruiseDataList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJPCruiseData }
     *     
     */
    public ArrayOfJPCruiseData getCruiseDataList() {
        return cruiseDataList;
    }

    /**
     * Sets the value of the cruiseDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJPCruiseData }
     *     
     */
    public void setCruiseDataList(ArrayOfJPCruiseData value) {
        this.cruiseDataList = value;
    }

}
