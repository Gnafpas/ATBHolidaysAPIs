package Updates.ATBDBUpdates.EventsTravelDBUpdates;
import Beans.EventsTravelAPIBeans.EventsTravelDescription;
import Beans.EventsTravelAPIBeans.EventsTravelProduct;
import Beans.EventsTravelAPIBeans.EventsTravelProductsRespone;
import Beans.ATBDBBeans.KalitaonProduct.*;
import Beans.ATBDBBeans.KalitaonSystem.CityCodeBean;
import Beans.ATBDBBeans.KalitaonSystem.CountryCodeBean;
import Controller.EventsTravelController.EventsTravelController;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.*;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CityCodeDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CountryCodeDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.SupplierDAO;
import DAOs.EventsTravelAPIDAO.EventsTravelProductsAPIDAO;
import DBConnection.ATBHibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by George on 10/07/2017.
 */
public class UpdateEventsTravelDBTimerTask extends TimerTask {

    private EventsTravelProductsRespone resultSet;
    private InitialContext initialContext;
    private String eventsTravelAPIkey;
    private int productId;
    private static String apiKeyJNDI = "java:comp/env/string/EventsTravelAPIkey";
    private static final Logger logger = Logger.getLogger(UpdateEventsTravelDBTimerTask.class);
    private boolean addPorduct;
    private static int total ;
    private static int stored ;
    private static String days[] = {"Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday"};


    public UpdateEventsTravelDBTimerTask() {
        super();

    }

    private EventsTravelProductsRespone refreshProducts (){
        resultSet = null;
        StringBuilder request= new StringBuilder("?");
        try {
            initialContext = new InitialContext();
            eventsTravelAPIkey = (String) initialContext.lookup(apiKeyJNDI);
        } catch (NamingException e) {
            logger.info("API key retrieval failed" + e.getMessage());
            e.printStackTrace();
        }
        logger.debug("API key " + eventsTravelAPIkey);
        /* Build Request */
        if (eventsTravelAPIkey != null && !"".equals(eventsTravelAPIkey))
            request.append("token="+eventsTravelAPIkey);
       return resultSet = EventsTravelProductsAPIDAO.getProducts(request.toString()); //todo test to be removed
    }

    @Override
    public void run() {
        addPorduct = false;
        //Initializations
        StatelessSession session;
        Transaction tx;
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        Timestamp startingTimestamp = new Timestamp(System.currentTimeMillis());
        GPriceMatrixBean price = new GPriceMatrixBean();
        BProductDetailBean productDetail = new BProductDetailBean();
        FPricePlanBean pricePlan = new FPricePlanBean();
        HAvailableDateBean date = new HAvailableDateBean();
        IAvailableTimeBean time = new IAvailableTimeBean();
        DProductPhotoBean photo = null;
        SupplierPhotoPathBean photoPath = null;
        List<CityCodeBean> cities=null;
        CountryCodeBean countryCode ;
        List<GPriceMatrixBean> priceList = new ArrayList<GPriceMatrixBean>();
        List<BProductDetailBean> productDetailList = new ArrayList<BProductDetailBean>();
        double distance =0;
        double minDistance =0;
        total=0;
        stored=0;
        //Get The products
        resultSet = refreshProducts();
        Map<String, EventsTravelProduct> products = resultSet.getProducts();
        String supplierId;
        CityCodeBean cityCode ;
        int planId = 0 ;
        logger.info("Received: "+products.size()+" products. \n Inserting...");

        for (Map.Entry<String, EventsTravelProduct> entry : products.entrySet()){
            session=ATBHibernateUtil.getSession();
            tx=session.beginTransaction();
            total++;

            EventsTravelProduct currentProduct = entry.getValue();
            currentTimestamp = Timestamp.valueOf(LocalDateTime.now());
            AProductTitleBean atbProductTitle = AProductTitleDAO.getProductByCode(entry.getValue().getSku(), EventsTravelController.EVENTS_TRAVEL);
            if (atbProductTitle!=null){
                //TODO delete product from all tables
                productId = atbProductTitle.getId();
                try {
                    AProductTitleDAO.deleteProduct(entry.getValue().getSku(),EventsTravelController.EVENTS_TRAVEL);
                    GPriceMatrixDAO.deletePriceMatrix(String.valueOf(productId));
                    HAvailableDateDAO.deleteAvailableDate(String.valueOf(productId));
                    FPricePlanDAO.deletePriceplan(String.valueOf(productId));
                    IAvailableTimeDAO.deleteavailableTime(String.valueOf(productId));
                    DProductPhotoDAO.deletePhoto(String.valueOf(productId));
                } catch (Exception e){
                    logger.info(e.getMessage());
                    tx.rollback();
                    break;
                }
            }
            //Init - add product
            try {
                countryCode = CountryCodeDAO.getCountryBycountryName(currentProduct.getLanguages().getLangDescription().get("EN").getCountry());
                if (countryCode == null) {
                    logger.info("Country not found"+currentProduct.getLanguages().getLangDescription().get("EN").getCountry());
                    continue;
                }
//                    countryCode = new CountryCodeBean();
//                    countryCode.setAreaKm2("");
//                    countryCode.setPopulation("");
//                    countryCode.setCountryCode(currentProduct.getLanguages().getLangDescription().get("EN").getCountry().toUpperCase().substring(0,2));
//                    countryCode.setIsoCode(currentProduct.getLanguages().getLangDescription().get("EN").getCountry().toUpperCase().substring(0,2));
//                    countryCode.setIsoCode2("");
//                    countryCode.setGdpUsd("");
//                    countryCode.setCountryName(currentProduct.getLanguages().getLangDescription().get("EN").getCountry());
//                    try {
//                        CountryCodeDAO.storeCountryCode(countryCode);
//                    } catch (Exception e) {
//                        logger.info(e.getMessage());
//                        tx.rollback();
//                    }
//                }

                //get city code
                cities = CityCodeDAO.getCityByNameAndIsoCode(currentProduct.getLanguages().getLangDescription().get("EN").getCity(), countryCode.getIsoCode().trim());
                cityCode = new CityCodeBean();
//                if (cities.isEmpty()) {
//                    cityCode.setGeonameid(currentProduct.getLanguages().getLangDescription().get("EN").getCity());
//                    cityCode.setCountryCodeIso(currentProduct.getLanguages().getLangDescription().get("EN").getCountry().toUpperCase().substring(0,2));
//                    cityCode.setHasProduct(true);
//                    cityCode.setOriginalName(currentProduct.getLanguages().getLangDescription().get("EN").getCity());
//                    cityCode.setLatitude(currentProduct.getLat());
//                    cityCode.setLongitude(currentProduct.getLng());
//                    cityCode.setSanitizedName("");
//                    cityCode.setViatorid(0);
//                    cityCode.setAlternateNamesCsv("");
//                    cityCode.setDem("");
//                    cityCode.setFeatureCode("");
//                    cityCode.setFeatureClass("");
//                    cityCode.setPopulation("");
//                    cityCode.setTimeZoneRegion("");
//                    try {
//                        CityCodeDAO.storeCityCode(cityCode);
//                    } catch (Exception e) {
//                        logger.info(e.getMessage());
//                        tx.rollback();
//                    }
//                }

                if(cities.size()>1) {
                    for (CityCodeBean city : cities) {
                        distance = distance(Double.parseDouble(currentProduct.getLat()), Double.parseDouble(city.getLatitude()), Double.parseDouble(currentProduct.getLng()), Double.parseDouble(city.getLongitude()));
                        if (minDistance == 0) {
                            minDistance = distance;
                            cityCode = city;
                        } else if (distance < minDistance) {
                            minDistance = distance;
                            cityCode = city;
                        }
                    }
                }else if(cities.size()==1){
                    cityCode= cities.get(0);
                } else{
                    logger.info("City not found" +currentProduct.getLanguages().getLangDescription().get("EN").getCity());
                    continue;
                }
                photoPath = SupplierPhotoPathDAO.getSupplierPhotoPathBySupplierId(String.valueOf(SupplierDAO.getSupplierId(EventsTravelController.EVENTS_TRAVEL)));
                if (photoPath == null){
                    photoPath = new SupplierPhotoPathBean();
                    photoPath.setSupplierId(String.valueOf(SupplierDAO.getSupplierId(EventsTravelController.EVENTS_TRAVEL)));
                    photoPath.setPhotoPath(EventsTravelController.PHOTO_PATH);
                    photoPath.setPhotoPathThumb(EventsTravelController.PHOTO_PATH);
                    try {
                        SupplierPhotoPathDAO.addupplierPhotoPath(photoPath);
                    } catch (Exception e) {
                        logger.info(e.getMessage());
                        tx.rollback();
                        session.close();
                        continue;
                    }
                }

                distance = 0;
                minDistance = 0;
                atbProductTitle = new AProductTitleBean(true);
                // Assign
                atbProductTitle.setProductCode(currentProduct.getSku());
                atbProductTitle.setSubId("");
                atbProductTitle.setTextLanguage("EN");
                atbProductTitle.setTypeOfProduct(currentProduct.getShipping_method());
                atbProductTitle.setCountryCode(countryCode.getIsoCode());
                atbProductTitle.setCountryName(countryCode.getCountryName());
                atbProductTitle.setCurrencyCode("EUR");
                atbProductTitle.setStock(currentProduct.getStock());
                atbProductTitle.setMainSupplierId(String.valueOf(SupplierDAO.getSupplierId(EventsTravelController.EVENTS_TRAVEL)));
                atbProductTitle.setMainSupplierName(EventsTravelController.EVENTS_TRAVEL);
                atbProductTitle.setThumbnailUrl(currentProduct.getImage());
                atbProductTitle.setCreatedAt(currentTimestamp.toString());
                atbProductTitle.setUpdatedAt(currentTimestamp.toString());
                atbProductTitle.setCityName(cityCode.getOriginalName());
                atbProductTitle.setCityCode(String.valueOf(cityCode.getId()));
                atbProductTitle.setMarchandNetPrice(currentProduct.getPrice());
                //Execute
                try {
                    AProductTitleDAO.addproduct(atbProductTitle);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    session.close();
                    continue;
                }
                productId = atbProductTitle.getId();
                EventsTravelDescription desc = currentProduct.getLanguages().getLangDescription().get("EN");
                productDetail = new BProductDetailBean();
                productDetail.setDescriptionSummary(desc.getName());
                productDetail.setProductDetail(desc.getSeating()+"#"+desc.getSeating_id()+"#"+desc.getSeating_description());
                productDetail.setProductId(String.valueOf(productId));
                productDetail.setCategories(desc.getCategory());
                productDetail.setAdittionalInfo(desc.getHospitality_description());
                productDetail.setHighlight(desc.getEvent());
                productDetail.setInclusions("");
                productDetail.setExclusions("");
                productDetail.setCancellationPolicy("");
                productDetail.setMerchantCancellable("");
                productDetail.setVoucherInfo("");
                productDetail.setCreatedAt(currentTimestamp.toString());
                productDetail.setUpdatedAt(currentTimestamp.toString());
                productDetail.setVoucherTelephone("");
                productDetail.setMobileAccess("no");
                productDetail.setVoucherCountryCode("");
                productDetailList.add(productDetail);

                try {
                    BProductDetailDAO.addproduct(productDetailList);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    session.close();
                    continue;
                }
                photo = new DProductPhotoBean();
                photo.setPhotoName(currentProduct.getImage().replace(EventsTravelController.PHOTO_PATH,""));
                photo.setSupplierId(String.valueOf(SupplierDAO.getSupplierId(EventsTravelController.EVENTS_TRAVEL)));
                photo.setProductId(String.valueOf(productId));
                photo.setVt("2");
                photo.setAtb("");
                photo.setCaption("");
                photo.setMainPhoto("");
                photo.setSubId("evt");
                photo.setCreatedAt(currentTimestamp.toString());
                photo.setUpdatedAt(currentTimestamp.toString());
                List<DProductPhotoBean> photos = new ArrayList<>();
                photos.add(photo);
                try {
                    DProductPhotoDAO.addPhoto(photos);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    session.close();
                    continue;
                }
                pricePlan = new FPricePlanBean();
                pricePlan.setMinParticipants("1");
                pricePlan.setPlanTitle("default");
                pricePlan.setProductId(String.valueOf(productId));
                pricePlan.setSubId("");
                pricePlan.setPriceType("Price Per Person");
                pricePlan.setRateType("net");
                pricePlan.setTourGradeCode("");
                pricePlan.setCreatedAt(currentTimestamp.toString());
                pricePlan.setUpdatedAt(currentTimestamp.toString());

                try {
                    FPricePlanDAO.addPriceplan(pricePlan);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    session.close();
                    continue;
                }
                price = new GPriceMatrixBean();
                price.setAgeFrom("0");
                price.setAgeTo("999");
                price.setCommission("");
                price.setCreatedAt(currentTimestamp.toString());
                price.setUpdatedAt(currentTimestamp.toString());
                price.setPriceNet(currentProduct.getPrice());
                price.setProductId(String.valueOf(productId));
                price.setCurrencyCode("EUR");
                price.setPersonType("adult");
                price.setCommission("");
                price.setPlanId(String.valueOf(pricePlan.getId()));
                price.setOptionTitle("");
                price.setMinCountRequired(1);
                price.setMaxCountRequired(1);
                price.setPriceRate("");
                priceList.add(price);
                try {
                    GPriceMatrixDAO.addPriceMatrix(priceList);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    session.close();
                    continue;
                }
                date = new HAvailableDateBean();
                date.setCreatedAt(currentTimestamp);
                date.setDepartimeOnOff("");
                date.setStartDate(currentTimestamp);
                date.setPlanId(String.valueOf(pricePlan.getId()));
                date.setProductId(String.valueOf(productId));
                date.setEndDate(convertStringToDate(currentProduct.getDate()));
                date.setAvailableTitle("Available period");
                date.setAvailableTimeType("Opening hours/operating hours");
                date.setUpdatedAt(currentTimestamp);
                date.setStartDate(currentTimestamp);
                try {
                    HAvailableDateDAO.addAvailableDate(date);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    session.close();
                    continue;
                }
                for(int i = 0; i < days.length; i++) {
                    time = new IAvailableTimeBean();
                    time.setAvailableId(String.valueOf(date.getId()));
                    time.setCreatedAt(currentTimestamp);
                    time.setEndTime("23:59:59");
                    time.setPlanId(String.valueOf(pricePlan.getId()));
                    time.setProductId(String.valueOf(productId));
                    time.setStartTime("00:00:00");
                    time.setUpdatedAt(currentTimestamp);
                    time.setWeekDay(days[i]);
                    try {
                        IAvailableTimeDAO.addAvailableTime(time);
                    } catch (Exception e) {
                        logger.info(e.getMessage());
                        tx.rollback();
                        continue;
                    }
                }
                stored++;
                tx.commit();
            }catch (Exception e) {
                logger.info(e.getMessage());
                e.printStackTrace();
                tx.rollback();
                session.close();
                continue;
            }
            session.close();
        }

        logger.info("Stored: "+stored+" out of: "+total+" products.\nThe update process took "+ (currentTimestamp.getTime() - startingTimestamp.getTime())+" ms");

    }
    public static Timestamp convertStringToDate(String str_date) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = (Date) formatter.parse(str_date);
            Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }
    public static Timestamp convertStringToTimestamp(String str_date) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            Date date = (Date) formatter.parse(str_date);
            Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            return null;
        }
    }
    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2) {

        final int R = 6371; // Radius of the earth
        double el1= 0;
        double el2=0;
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }
}

