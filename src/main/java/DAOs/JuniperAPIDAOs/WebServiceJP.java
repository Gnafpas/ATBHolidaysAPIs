
package DAOs.JuniperAPIDAOs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.*;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServiceJP", targetNamespace = "http://www.juniper.es/webservice/2007/", wsdlLocation = "http://xml2.bookingengine.es/WebService/JP/WebServiceJP.asmx?WSDL")
public class WebServiceJP
    extends Service
{

    private final static URL WEBSERVICEJP_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICEJP_EXCEPTION;
    private final static QName WEBSERVICEJP_QNAME = new QName("http://www.juniper.es/webservice/2007/", "WebServiceJP");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://xml2.bookingengine.es/WebService/JP/WebServiceJP.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICEJP_WSDL_LOCATION = url;
        WEBSERVICEJP_EXCEPTION = e;
    }

    public WebServiceJP() {
        super(__getWsdlLocation(), WEBSERVICEJP_QNAME);
    }

    public WebServiceJP(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICEJP_QNAME, features);
    }

    public WebServiceJP(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICEJP_QNAME);
    }

    public WebServiceJP(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICEJP_QNAME, features);
    }

    public WebServiceJP(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceJP(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BookTransactions
     */
    @WebEndpoint(name = "BookTransactions")
    public BookTransactions getBookTransactions() {
        return super.getPort(new QName("http://www.juniper.es/webservice/2007/", "BookTransactions"), BookTransactions.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BookTransactions
     */
    @WebEndpoint(name = "BookTransactions")
    public BookTransactions getBookTransactions(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.juniper.es/webservice/2007/", "BookTransactions"), BookTransactions.class, features);
    }

    /**
     * 
     * @return
     *     returns AvailTransactions
     */
    @WebEndpoint(name = "AvailTransactions")
    public AvailTransactions getAvailTransactions() {
        return super.getPort(new QName("http://www.juniper.es/webservice/2007/", "AvailTransactions"), AvailTransactions.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AvailTransactions
     */
    @WebEndpoint(name = "AvailTransactions")
    public AvailTransactions getAvailTransactions(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.juniper.es/webservice/2007/", "AvailTransactions"), AvailTransactions.class, features);
    }

    /**
     * 
     * @return
     *     returns InventoryTransactions
     */
    @WebEndpoint(name = "InventoryTransactions")
    public InventoryTransactions getInventoryTransactions() {
        return super.getPort(new QName("http://www.juniper.es/webservice/2007/", "InventoryTransactions"), InventoryTransactions.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns InventoryTransactions
     */
    @WebEndpoint(name = "InventoryTransactions")
    public InventoryTransactions getInventoryTransactions(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.juniper.es/webservice/2007/", "InventoryTransactions"), InventoryTransactions.class, features);
    }

    /**
     * 
     * @return
     *     returns StaticDataTransactions
     */
    @WebEndpoint(name = "StaticDataTransactions")
    public StaticDataTransactions getStaticDataTransactions() {



        return super.getPort(new QName("http://www.juniper.es/webservice/2007/", "StaticDataTransactions"), StaticDataTransactions.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StaticDataTransactions
     */
    @WebEndpoint(name = "StaticDataTransactions")
    public StaticDataTransactions getStaticDataTransactions(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.juniper.es/webservice/2007/", "StaticDataTransactions"), StaticDataTransactions.class, features);
    }

    /**
     * 
     * @return
     *     returns CheckTransactions
     */
    @WebEndpoint(name = "CheckTransactions")
    public CheckTransactions getCheckTransactions() {
        return super.getPort(new QName("http://www.juniper.es/webservice/2007/", "CheckTransactions"), CheckTransactions.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CheckTransactions
     */
    @WebEndpoint(name = "CheckTransactions")
    public CheckTransactions getCheckTransactions(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.juniper.es/webservice/2007/", "CheckTransactions"), CheckTransactions.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICEJP_EXCEPTION!= null) {
            throw WEBSERVICEJP_EXCEPTION;
        }
        return WEBSERVICEJP_WSDL_LOCATION;
    }

}
