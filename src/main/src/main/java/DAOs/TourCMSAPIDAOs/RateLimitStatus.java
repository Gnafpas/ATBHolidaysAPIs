package DAOs.TourCMSAPIDAOs;

import java.io.IOException;
import java.io.StringReader;
import Beans.TourCMSAPIBeans.RateLimitStatusBean;
import javax.xml.bind.JAXB;
import static Helper.ProjectProperties.tourCMSAPIKey;
import static Helper.ProjectProperties.tourCMSmarketplaceId;

/**
 * Created by George on 13/06/2018.
 */
public class RateLimitStatus {

    public static RateLimitStatusBean checkAvailability() throws Exception {
        String body = null;
        ApiRequester tourcms = new ApiRequester(tourCMSmarketplaceId, "0", tourCMSAPIKey);
        try {
            body = tourcms.apiRequest("/api/rate_limit_status.xml", "GET", null);
        } catch (IOException ioe) {
            throw new Exception(ioe.getMessage(), ioe);
        }
        RateLimitStatusBean value = JAXB.unmarshal(new StringReader(body), RateLimitStatusBean.class);
        return value;
    }
}