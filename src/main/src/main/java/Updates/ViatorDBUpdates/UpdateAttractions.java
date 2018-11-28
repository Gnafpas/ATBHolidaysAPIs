package Updates.ViatorDBUpdates;


import Beans.ViatorAPIBeans.SearchFreetext.SearchFreetextAttractionMetaData;
import Beans.ViatorAPIBeans.SearchFreetext.SearchFreetextAttractionsAPIJSON;
import Beans.ViatorAPIBeans.SearchFreetext.SearchFreetextPOST;
import Beans.ViatorAPIBeans.Taxonomy.TaxonomyAttractionsAPIJSON;
import Beans.ViatorAPIBeans.Taxonomy.TaxonomyDestinationsAPIJSON;
import Beans.ViatorAPIBeans.Taxonomy.TaxonomyDestinationsData;
import DAOs.ViatorAPIDAOs.ProductAPIDAO;
import DAOs.ViatorAPIDAOs.TaxonomyAPIDAO;
import DAOs.ViatorDBDAOs.*;
import Beans.ViatorDBBeans.*;
import Helper.ProjectProperties;
import Beans.ViatorDBBeans.UpdateDBBeans.FailedAttraction;
import Beans.ViatorDBBeans.UpdateDBBeans.UpdateAttractionsInfoJSON;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static Controller.Application.errLogger;

/**
 * Created by George on 12/07/2017.
 */
public class  UpdateAttractions {

    public static UpdateAttractionsInfoJSON UpdateAttractions(int destIdToStartRetrieveAttractions, int destIdToStopRetrieveAttractions) {

        SearchFreetextPOST searchFreetextPOST = new SearchFreetextPOST();
        ViatorAttractionsBean viatorAttractionsBean = new ViatorAttractionsBean();
        TaxonomyDestinationsAPIJSON taxonomyDestinationsAPIJSON;
        TaxonomyAttractionsAPIJSON taxonomyAttractionsAPIJSON;
        SearchFreetextAttractionsAPIJSON searchFreetextAttractionsAPIJSON;

        DateTime dateTime;

        /**
         * Set up logger.
         */
        Logger logger = Logger.getLogger("UpdateViatorAtractionsLog");
        FileHandler fh;
        try {
            for(Handler handler:logger.getHandlers()) {
                logger.removeHandler(handler);
            }
            // This block configure the logger with handler and formatter
            fh = new FileHandler(ProjectProperties.logspath+"UpdateViatorAtractionsLog.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (IOException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }

        /**
         * Declare from which point in the destinations list start to retrieving destination's attractions and at which
         * destination to stop.If  destIdToStartRRetrieveAttractions is 0 and destIdToStopRetrieveAttractions is 0 retrieve
         *  attractions from all destinations.Else retrieve attractions for the destinations in the list which are following the one
         * with destination Id "destIdToStartRetrieveAttractions" and stop at destination with destination Id"destIdToStopRetrieveAttractions".
         */
        boolean RetrieveAttractions;
        if (destIdToStartRetrieveAttractions == 0)
            RetrieveAttractions = true;
        else
            RetrieveAttractions = false;

        /**
         * Statistic Values/Information/Results in JSON for Admin.
         */
        UpdateAttractionsInfoJSON updateAttractionsInfoJSON=new UpdateAttractionsInfoJSON();
        dateTime = new DateTime(DateTimeZone.UTC);
        updateAttractionsInfoJSON.setStartDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                   dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                   dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
        updateAttractionsInfoJSON.setTotalLeafNodes(0);
        updateAttractionsInfoJSON.setLastLeafDestid(0);
        updateAttractionsInfoJSON.setTotalAttractions(0);
        updateAttractionsInfoJSON.setDbCommError(false);
        updateAttractionsInfoJSON.setViatorError(false);
        updateAttractionsInfoJSON.setDbCommErrorsCounter(0);
        updateAttractionsInfoJSON.setTotalProcessSleep(0);
        List<Integer> failedDestinations = new ArrayList<>();
        List<FailedAttraction> failedAttractions = new ArrayList();
        FailedAttraction failedAttraction;

        /**
         * Time between viator server requests.There is a limit for the number of requests per
         * 10 seconds that we can make at viator's server(15req/10sec for prelive and 35req/10sec for live).
         * Process may sleep for an amount of time to stay in the limits.
         */
        long timeElapsed = 0;


        /**
         * Search all Destinations.
         */
        taxonomyDestinationsAPIJSON = TaxonomyAPIDAO.retrieveDestinations();

        /**
         * If couldn't retrieve destinations cancel the update.
         */
        if (!taxonomyDestinationsAPIJSON.isSuccess() || taxonomyDestinationsAPIJSON.getData() == null) {
            logger.info("********************** Communication ERROR.Did not received Destinations **********************");
            updateAttractionsInfoJSON.setViatorError(true);
            updateAttractionsInfoJSON.setViatorErrorInfo("Communication ERROR.Did not received Destinations");
            return updateAttractionsInfoJSON;
        }

        for (TaxonomyDestinationsData dest : taxonomyDestinationsAPIJSON.getData()) {

            logger.info("* * * * * * * * * * *      DESTINATION : " + dest.getDestinationName() +
                               "  DESTINATION ID : " + dest.getDestinationId() +
                               "      * * * * * * * * * * *");

            /**
             * Start receiving attractions for the desired destinations.
             */
            if (destIdToStartRetrieveAttractions == dest.getDestinationId())
                RetrieveAttractions = true;

            /**
             * Check if current destination is a leaf.Only leaf destinations have Attractions.Parerent
             * Object have same Attractions as their child.
             */
            boolean leafNodeDest = true;
            for (TaxonomyDestinationsData d : taxonomyDestinationsAPIJSON.getData()) {
                if (dest.getDestinationId() == d.getParentId()) {
                    leafNodeDest = false;
                    break;
                }
            }
            /**
             * If a destination it's a leaf retrieve all its Attractions and store in DB.
             */
            if (leafNodeDest && RetrieveAttractions) {

                /**
                 * Statistic Information for Admin.
                 */
                updateAttractionsInfoJSON.setTotalLeafNodes(updateAttractionsInfoJSON.getTotalLeafNodes() + 1);
                updateAttractionsInfoJSON.setLastLeafDestid(dest.getDestinationId());

                /**
                 * Process may sleep for an amount of time to stay in the limits.
                 */
                timeElapsed = System.currentTimeMillis() - timeElapsed;
                if (ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed > 0) {
                    try {
                        Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                        updateAttractionsInfoJSON.setTotalProcessSleep(updateAttractionsInfoJSON.getTotalProcessSleep() +
                                                                       ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }

                /** Get attraction summary*/
                taxonomyAttractionsAPIJSON = TaxonomyAPIDAO.retrieveAttractions(dest.getDestinationId(), "", "SEO_ALPHABETICAL");
                timeElapsed = System.currentTimeMillis();

                if (taxonomyAttractionsAPIJSON.isSuccess() && taxonomyAttractionsAPIJSON.getData() != null) {

                    for (int i = 0; i < taxonomyAttractionsAPIJSON.getData().size(); i++) {
                        /**
                         * Update/Add records of all related tables of attraction in the DB.
                         */
                        if (taxonomyAttractionsAPIJSON.getData().get(i).getTitle() != null) {

                            /**
                             * Process may sleep for an amount of time to stay in the limits.
                             */
                            timeElapsed = System.currentTimeMillis() - timeElapsed;
                            if (ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed > 0) {
                                try {
                                    Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                                    updateAttractionsInfoJSON.setTotalProcessSleep(updateAttractionsInfoJSON.getTotalProcessSleep() +
                                                                                   ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                                } catch (InterruptedException ex) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                            /** Get Attractions's details*/
                            searchFreetextPOST.setText(taxonomyAttractionsAPIJSON.getData().get(i).getTitle());
                            searchFreetextPOST.setDestId(taxonomyAttractionsAPIJSON.getData().get(i).getDestinationId());
                            searchFreetextAttractionsAPIJSON = ProductAPIDAO.searchFreeTextAttraction(searchFreetextPOST);
                            timeElapsed = System.currentTimeMillis();

                            dateTime = new DateTime(DateTimeZone.UTC);

                            if (searchFreetextAttractionsAPIJSON.isSuccess() && searchFreetextAttractionsAPIJSON.getData() != null) {
                                for (SearchFreetextAttractionMetaData metadata : searchFreetextAttractionsAPIJSON.getData()) {
                                    if (metadata.getData().getSeoId()==taxonomyAttractionsAPIJSON.getData().get(i).getSeoId()) {
                                        viatorAttractionsBean.setAttractionCity(metadata.getData().getAttractionCity());
                                        viatorAttractionsBean.setAttractionLatitude(metadata.getData().getAttractionLatitude());
                                        viatorAttractionsBean.setAttractionLongitude(metadata.getData().getAttractionLongitude());
                                        viatorAttractionsBean.setAttractionState(metadata.getData().getAttractionState());
                                        viatorAttractionsBean.setAttractionStreetAddress(metadata.getData().getAttractionStreetAddress());
                                        viatorAttractionsBean.setDescriptionIntro(metadata.getData().getDescriptionIntro());
                                        viatorAttractionsBean.setDescriptionText(metadata.getData().getDescriptionText());
                                        viatorAttractionsBean.setDestinationId(metadata.getData().getDestinationId());
                                        viatorAttractionsBean.setEditorsPick(metadata.getData().isEditorsPick());
                                        viatorAttractionsBean.setOverviewSummary(metadata.getData().getOverviewSummary());
                                        viatorAttractionsBean.setPagePrimaryLanguage(metadata.getData().getPagePrimaryLanguage());
                                        viatorAttractionsBean.setPageTitle(metadata.getData().getPageTitle());
                                        viatorAttractionsBean.setPageUrlName(metadata.getData().getPageUrlName());
                                        viatorAttractionsBean.setPrimaryDestinationId(metadata.getData().getPrimaryDestinationId());
                                        viatorAttractionsBean.setPrimaryDestinationName(metadata.getData().getPrimaryDestinationName());
                                        viatorAttractionsBean.setPrimaryDestinationUrlName(metadata.getData().getPrimaryDestinationUrlName());
                                        viatorAttractionsBean.setProductCount(metadata.getData().getProductCount());
                                        viatorAttractionsBean.setPublishedDate(metadata.getData().getPublishedDate());
                                        viatorAttractionsBean.setRating(metadata.getData().getRating());
                                        viatorAttractionsBean.setSeoId(metadata.getData().getSeoId());
                                        viatorAttractionsBean.setThumbnailHiResUrl(metadata.getData().getThumbnailHiResURL());
                                        viatorAttractionsBean.setThumbnailUrl(metadata.getData().getThumbnailURL());
                                        viatorAttractionsBean.setTitle(metadata.getData().getTitle());
                                        viatorAttractionsBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
                                        viatorAttractionsBean.setUserName(metadata.getData().getUserName());
                                        viatorAttractionsBean.setWebUrl(metadata.getData().getWebURL());

                                        if (ViatorAttractionsDAO.deleteAttraction(metadata.getData().getSeoId())) {
                                            updateAttractionsInfoJSON.setDbCommErrorsCounter(updateAttractionsInfoJSON.getDbCommErrorsCounter() + 1);
                                            updateAttractionsInfoJSON.setDbCommError(true);
                                        }
                                        if (ViatorAttractionsDAO.addAttraction(viatorAttractionsBean)) {
                                            updateAttractionsInfoJSON.setDbCommErrorsCounter(updateAttractionsInfoJSON.getDbCommErrorsCounter() + 1);
                                            updateAttractionsInfoJSON.setDbCommError(true);
                                        } else {
                                            updateAttractionsInfoJSON.setTotalAttractions(updateAttractionsInfoJSON.getTotalAttractions() + 1);
                                            if (metadata.getData().getSeoId() != 0)
                                                logger.info("      ****************     Attraction ID : " + metadata.getData().getSeoId() +
                                                                   " . Attractions count :" + updateAttractionsInfoJSON.getTotalAttractions() +
                                                                   "     ****************      ");
                                        }
                                        break;
                                    }

                                }
                            } else {
                                failedAttraction = new FailedAttraction();
                                failedAttraction.setDestId(dest.getDestinationId());
                                failedAttraction.setSeoId(taxonomyAttractionsAPIJSON.getData().get(i).getSeoId());
                                failedAttractions.add(failedAttraction);
                                updateAttractionsInfoJSON.setViatorError(true);
                                updateAttractionsInfoJSON.setViatorErrorInfo("Update completed but some Attractions did not added correctly " +
                                        "to DB or not updated.Check Failed Destinations/Failed Attractions " +
                                        "List.");
                            }
                        }
                    }
                } else {
                    failedDestinations.add(dest.getDestinationId());
                    updateAttractionsInfoJSON.setViatorError(true);
                    updateAttractionsInfoJSON.setViatorErrorInfo("Update completed but some Attractions did not added correctly to DB " +
                                                                 "or not updated.Check Failed Destinations/Failed Attractions List.");
                }
                /**
                 * Stop receiving Attractions after the update has reached the desired destination.
                 */
                if (destIdToStopRetrieveAttractions != 0 && destIdToStopRetrieveAttractions == dest.getDestinationId())
                    RetrieveAttractions = false;
            }

        }


        /**
         * Set last update informations
         */
        updateAttractionsInfoJSON.setFailedDestinations(failedDestinations);
        updateAttractionsInfoJSON.setFailedAttractions(failedAttractions);
        dateTime = new DateTime(DateTimeZone.UTC);
        updateAttractionsInfoJSON.setEndDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));

        /**
         * Print update Informations
         */
        logger.info("\n\n**********************     " + " Update started at: " + updateAttractionsInfoJSON.getStartDateTime() +
                "\n**********************     " + " Update ended at: " + updateAttractionsInfoJSON.getEndDateTime() +
                "\n**********************     " + " Viator communication Error: " + updateAttractionsInfoJSON.isViatorError() +
                "\n**********************     " + " Viator communication Error info: " + updateAttractionsInfoJSON.getViatorErrorInfo() +
                "\n**********************     " + " Database Error: " + updateAttractionsInfoJSON.isDbCommError() +
                "\n**********************     " + " Database Errors counter: " + updateAttractionsInfoJSON.getDbCommErrorsCounter() +
                "\n**********************     " + " Total process Sleep(in milliseconds): " + updateAttractionsInfoJSON.getTotalProcessSleep() +
                "\n**********************     " + " Total Leaf Nodes: " + updateAttractionsInfoJSON.getTotalLeafNodes() +
                "\n**********************     " + " Total Attractions updated/added: " + updateAttractionsInfoJSON.getTotalAttractions() +
                "\n**********************     " + " Last Leaf Node Object Id: " + updateAttractionsInfoJSON.getLastLeafDestid() +
                "\n**********************     " + " Failed Destinations Id: " + updateAttractionsInfoJSON.getFailedDestinations());
        for (int i = 0; i < updateAttractionsInfoJSON.getFailedAttractions().size(); i++) {
            logger.info("**********************     " + " Failed Attraction seoId,DestId: " +
                               updateAttractionsInfoJSON.getFailedAttractions().get(i).getSeoId() +
                               "," + updateAttractionsInfoJSON.getFailedAttractions().get(i).getDestId());
        }

        return updateAttractionsInfoJSON;
    }
}
