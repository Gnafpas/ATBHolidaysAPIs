
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JPSOAP_HotelRatePlanBoardUpgradeOffer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JPSOAP_HotelRatePlanBoardUpgradeOffer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="BoardCodePay" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="BoardCodeGet" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JPSOAP_HotelRatePlanBoardUpgradeOffer")
public class JPSOAPHotelRatePlanBoardUpgradeOffer {

    @XmlAttribute(name = "BoardCodePay", required = true)
    protected int boardCodePay;
    @XmlAttribute(name = "BoardCodeGet", required = true)
    protected int boardCodeGet;

    /**
     * Gets the value of the boardCodePay property.
     * 
     */
    public int getBoardCodePay() {
        return boardCodePay;
    }

    /**
     * Sets the value of the boardCodePay property.
     * 
     */
    public void setBoardCodePay(int value) {
        this.boardCodePay = value;
    }

    /**
     * Gets the value of the boardCodeGet property.
     * 
     */
    public int getBoardCodeGet() {
        return boardCodeGet;
    }

    /**
     * Sets the value of the boardCodeGet property.
     * 
     */
    public void setBoardCodeGet(int value) {
        this.boardCodeGet = value;
    }

}
