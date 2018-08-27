
package DAOs.JuniperAPIDAOs;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfJPSOAP_IntCodeAttr3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJPSOAP_IntCodeAttr3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Board" type="{http://www.juniper.es/webservice/2007/}JPSOAP_IntCodeAttr" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJPSOAP_IntCodeAttr3", propOrder = {
    "board"
})
public class ArrayOfJPSOAPIntCodeAttr3 {

    @XmlElement(name = "Board")
    protected List<JPSOAPIntCodeAttr> board;

    /**
     * Gets the value of the board property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the board property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JPSOAPIntCodeAttr }
     * 
     * 
     */
    public List<JPSOAPIntCodeAttr> getBoard() {
        if (board == null) {
            board = new ArrayList<JPSOAPIntCodeAttr>();
        }
        return this.board;
    }

}
