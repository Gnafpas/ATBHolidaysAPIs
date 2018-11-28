
package DAOs.JuniperAPIDAOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JP_AgencyData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JP_AgencyData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReferencedAgency" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AgencyCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AgencyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgencyHandledBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgencyEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgencyCommercialPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgencyReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AgencyFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecurityKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JP_AgencyData", propOrder = {
    "referencedAgency",
    "agencyCode",
    "agencyName",
    "agencyHandledBy",
    "agencyEmail",
    "agencyCommercialPhone",
    "agencyReference",
    "agencyFile",
    "securityKey"
})
public class JPAgencyData {

    @XmlElement(name = "ReferencedAgency")
    protected boolean referencedAgency;
    @XmlElement(name = "AgencyCode")
    protected int agencyCode;
    @XmlElement(name = "AgencyName")
    protected String agencyName;
    @XmlElement(name = "AgencyHandledBy")
    protected String agencyHandledBy;
    @XmlElement(name = "AgencyEmail")
    protected String agencyEmail;
    @XmlElement(name = "AgencyCommercialPhone")
    protected String agencyCommercialPhone;
    @XmlElement(name = "AgencyReference")
    protected String agencyReference;
    @XmlElement(name = "AgencyFile")
    protected String agencyFile;
    @XmlElement(name = "SecurityKey")
    protected String securityKey;

    /**
     * Gets the value of the referencedAgency property.
     * 
     */
    public boolean isReferencedAgency() {
        return referencedAgency;
    }

    /**
     * Sets the value of the referencedAgency property.
     * 
     */
    public void setReferencedAgency(boolean value) {
        this.referencedAgency = value;
    }

    /**
     * Gets the value of the agencyCode property.
     * 
     */
    public int getAgencyCode() {
        return agencyCode;
    }

    /**
     * Sets the value of the agencyCode property.
     * 
     */
    public void setAgencyCode(int value) {
        this.agencyCode = value;
    }

    /**
     * Gets the value of the agencyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * Sets the value of the agencyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyName(String value) {
        this.agencyName = value;
    }

    /**
     * Gets the value of the agencyHandledBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyHandledBy() {
        return agencyHandledBy;
    }

    /**
     * Sets the value of the agencyHandledBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyHandledBy(String value) {
        this.agencyHandledBy = value;
    }

    /**
     * Gets the value of the agencyEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyEmail() {
        return agencyEmail;
    }

    /**
     * Sets the value of the agencyEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyEmail(String value) {
        this.agencyEmail = value;
    }

    /**
     * Gets the value of the agencyCommercialPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyCommercialPhone() {
        return agencyCommercialPhone;
    }

    /**
     * Sets the value of the agencyCommercialPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyCommercialPhone(String value) {
        this.agencyCommercialPhone = value;
    }

    /**
     * Gets the value of the agencyReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyReference() {
        return agencyReference;
    }

    /**
     * Sets the value of the agencyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyReference(String value) {
        this.agencyReference = value;
    }

    /**
     * Gets the value of the agencyFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyFile() {
        return agencyFile;
    }

    /**
     * Sets the value of the agencyFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyFile(String value) {
        this.agencyFile = value;
    }

    /**
     * Gets the value of the securityKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecurityKey() {
        return securityKey;
    }

    /**
     * Sets the value of the securityKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecurityKey(String value) {
        this.securityKey = value;
    }

}
