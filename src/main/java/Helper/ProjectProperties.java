package Helper;

import java.math.BigDecimal;

/**

 * Created by George on 07/07/2017.

 */

public class ProjectProperties {
    public static String apiKey="3491840412405367";
    public static String hotelBedsApiKey="5ztuwywbs97w5hz3emzuc6bn";//"pmj75vktdp9ewexvhf97rug6";
    public static String hotelBedsSecret="qfGCVJHVrP";//"dBD9QqNQtR";
    public static String apiURL="https://viatorapi.sandbox.viator.com";
    public static String sunhotelsUsername="ATBHolidaysTK";
    public static String sunhotelspass="Beyoglu321";
    public static String travelXGateApikey="9aa86953-8f0c-4b63-4cf4-9b3672576b63";
    public static int runDBUpdateEveryXMillisecs=60 * 60 * 144 * 1000;//todo change time elapsed when go out live
    public static int runSunhotDBUpdateEveryXMillisecs=60 * 60 * 24 * 1000;
    public static int countOfDisplayedHotels=15;
    public static int minElapsedTimeBetweenViatorRequests=670;//todo change time elapsed when go out live
    public static String defaultCurrencyCode="USD";
    public static int requestTimeOut=1000*60;
    public static String Adminuser="Adm";
    public static String Adminpass="trouble25";
    public static String photoSupplierId="10236";
    public static String photoUrlSplitKey="graphicslib/";//todo change when go out live
    public static String photoSizeUrl="/thumbs674x446/";
    public static String sanHotelsImageURL="https://www.sunhotels.net/SunHotels.net/HotelInfo/hotelImage.aspx";
    public static String hotelBedsImageURL="http://photos.hotelbeds.com/giata/bigger/";
    public static BigDecimal viatorComission=new BigDecimal(0.3);
    public static int sanHotelsProviderId=1;
    public static String sanHotelsProviderName="SunHotels";
    public static int hotelBedsProviderId=1771;
    public static int mattHotelsProvider=396;
    public static int atbHotelsProvider=387;
    public static String hotelBedsProvideName="Hotelbeds";
    public static String hotelBedsDeafultCurrency="USD";
    public static int eventTravelProviderId=10260;
    public static int travelXGateProviderId=10325;
    public static final String SALTForKeyGeneration = "Allatamatiatoylagoukiallatiskoukouvagias";
    public static final String localImagesURL="https://31.169.67.162:8443/hotelImages/";
    public static final String logspath = "/usr/local/apache-tomcat-7.0.64/logs/";
    public static final int plusCancelationPolicyHours = 96;
    public static final String eventsTravelGetProductsURL = "https://www.eventstravel.eu/webservice/v1/products/get";
    public static final String eventsTravelCreateOrderURL = "https://www.eventstravel.eu/webservice/v1/orders/create";
    public static final String tourCMSmarketplaceId="43462";
    public static final String tourCMSAPIKey="d3fc1815275c";
}
