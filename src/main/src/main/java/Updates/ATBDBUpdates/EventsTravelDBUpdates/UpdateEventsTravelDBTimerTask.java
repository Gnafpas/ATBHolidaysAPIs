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
import Helper.ProjectProperties;
import org.apache.log4j.Logger;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.joda.time.DateTimeComparator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.SimpleFormatter;

import static Controller.Application.errLogger;

/**
 * Created by George on 10/07/2017.
 */
public class UpdateEventsTravelDBTimerTask extends TimerTask {

    private EventsTravelProductsRespone resultSet;
    private InitialContext initialContext;
    private String eventsTravelAPIkey;
    private int productId;
    private static String apiKeyJNDI = "java:comp/env/string/EventsTravelAPIkey";
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger("UpdateEventsTravelDBTimerTask");
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
        //logger.debug("API key " + eventsTravelAPIkey);
        /* Build Request */
        if (eventsTravelAPIkey != null && !"".equals(eventsTravelAPIkey))
            request.append("token="+eventsTravelAPIkey);//+"&test=true");
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
        HSpecialDateBean hSpecialDateBean= new HSpecialDateBean();
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

        /**
         * Set up logger.
         */
        FileHandler fh;
        try {
            for (Handler handler : logger.getHandlers()) {
                logger.removeHandler(handler);
            }
            // This block configure the logger with handler and formatter
            fh = new FileHandler(ProjectProperties.logspath + "EventsTravel.log");
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



        logger.info("Received: "+products.size()+" products. \n Inserting...");
        currentTimestamp = Timestamp.valueOf(LocalDateTime.now());
        session=ATBHibernateUtil.getSession();

        for (Map.Entry<String, EventsTravelProduct> entry : products.entrySet()){
            tx=session.beginTransaction();
            total++;
            EventsTravelProduct currentProduct = entry.getValue();
            if(Integer.parseInt(currentProduct.getStock())==0) {
                tx.rollback();
                continue;
            }
            AProductTitleBean atbProductTitle = AProductTitleDAO.getProductByCode(entry.getValue().getSku(), EventsTravelController.EVENTS_TRAVEL);
            productDetailList.clear();
            priceList.clear();

            if (atbProductTitle!=null){
                //TODO delete product from all tables
                productId = atbProductTitle.getId();
                try {
                    HAvailableDateDAO.deleteAvailableDate(String.valueOf(productId));
                    IAvailableTimeDAO.deleteavailableTime(String.valueOf(productId));
                    HSpecialDateDAO.deleteSpecialDate(String.valueOf(productId));
                } catch (Exception e){
                    logger.info(e.getMessage());
                    tx.rollback();
                    break;
                }
            }else
                productId=0;

            //Init - add product
            try {
                if("Hong Kong SAR China".equals(currentProduct.getLanguages().getLangDescription().get("EN").getCountry())) {
                    currentProduct.getLanguages().getLangDescription().get("EN").setCountry("Hong Kong");
                }
                countryCode = CountryCodeDAO.getCountryBycountryName(currentProduct.getLanguages().getLangDescription().get("EN").getCountry());
                if (countryCode == null) {
                    logger.info("Country not found "+currentProduct.getLanguages().getLangDescription().get("EN").getCountry());
                    tx.rollback();
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

                //get city code New York City
                if("New York".equals(currentProduct.getLanguages().getLangDescription().get("EN").getCity())){
                    currentProduct.getLanguages().getLangDescription().get("EN").setCity("New York City");
                } else if ("Milan".equals(currentProduct.getLanguages().getLangDescription().get("EN").getCity())){
                    currentProduct.getLanguages().getLangDescription().get("EN").setCity("Milano");
                } else if ("Rostov-On-Don".equals(currentProduct.getLanguages().getLangDescription().get("EN").getCity())){
                    currentProduct.getLanguages().getLangDescription().get("EN").setCity("Rostov-na-Donu");
                } else if ("Nizhny Novgorod".equals(currentProduct.getLanguages().getLangDescription().get("EN").getCity())){
                    currentProduct.getLanguages().getLangDescription().get("EN").setCity("Nizhniy Novgorod");
                }else if ("Kyiv".equals(currentProduct.getLanguages().getLangDescription().get("EN").getCity())){
                    currentProduct.getLanguages().getLangDescription().get("EN").setCity("Kiev");
                }else if ("Ekaterinburg".equals(currentProduct.getLanguages().getLangDescription().get("EN").getCity())){
                    currentProduct.getLanguages().getLangDescription().get("EN").setCity("Yekaterinburg");
                }
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
                        if (city.getLongitude().replaceAll("\\.","").substring(0,2).equals(currentProduct.getLng().replaceAll("\\.","").substring(0,2))
                                && city.getLatitude().replaceAll("\\.","").substring(0,2).equals(currentProduct.getLat().replaceAll("\\.","").substring(0,2))){
                            cityCode = city;
                        }
                        //distance = distance(Double.parseDouble(currentProduct.getLat()), Double.parseDouble(city.getLatitude()), Double.parseDouble(currentProduct.getLng()), Double.parseDouble(city.getLongitude()));
                        //if (minDistance == 0) {
                        //   minDistance = distance;
                        //    cityCode = city;
                        //} else if (distance < minDistance) {
                        //    minDistance = distance;
                        //    cityCode = city;
                        //}
                    }
                }else if(cities.size()==1){
                    cityCode= cities.get(0);
                } else{
                    logger.info("City not found " +currentProduct.getLanguages().getLangDescription().get("EN").getCity()+" {"+countryCode.getIsoCode().trim()+"}");
                    tx.rollback();
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
                        continue;
                    }
                }

                if(currentProduct.getLanguages().getLangDescription().get("EN").getCategory()!=null && !currentProduct.getLanguages().getLangDescription().get("EN").getCategory().equals("")) {
                    List<ProductCategoriesBean> categories=ProductCategoriesDAO.getAllCategories();
                    if (categories != null) {
                        boolean exists = false;
                        for (ProductCategoriesBean category : categories) {
                            if (category.getCategoryName().equals(currentProduct.getLanguages().getLangDescription().get("EN").getCategory()))
                                exists = true;
                        }
                        if (!exists) {
                            ProductCategoriesBean productCategoriesBean = new ProductCategoriesBean();
                            productCategoriesBean.setCategoryName(currentProduct.getLanguages().getLangDescription().get("EN").getCategory());
                            productCategoriesBean.setLng("");
                            productCategoriesBean.setSubCatId("");
                            ProductCategoriesDAO.addProductCategoriesBean(productCategoriesBean);
                        }
                    }
                }

                distance = 0;
                minDistance = 0;
                EventsTravelDescription desc = currentProduct.getLanguages().getLangDescription().get("EN");
                atbProductTitle = new AProductTitleBean(true);
                // Assign
                atbProductTitle.setProductCode(currentProduct.getSku());
                atbProductTitle.setSubId("evtTicket");
                atbProductTitle.setTextLanguage("EN");
                atbProductTitle.setTypeOfProduct("5");
                atbProductTitle.setCountryCode(countryCode.getIsoCode());
                atbProductTitle.setCountryName(countryCode.getCountryName());
                atbProductTitle.setCurrencyCode("EUR");
                atbProductTitle.setStock(currentProduct.getStock());
                atbProductTitle.setMainSupplierId(String.valueOf(SupplierDAO.getSupplierId(EventsTravelController.EVENTS_TRAVEL)));
                atbProductTitle.setMainSupplierName(EventsTravelController.EVENTS_TRAVEL);
                if(!currentProduct.getImage().equals("http://www.eventstravel.eu/uploads/images/products/options/variants/"))
                    atbProductTitle.setThumbnailUrl(currentProduct.getImage());
                else
                    atbProductTitle.setThumbnailUrl("https://www.atbholidays.com/images/no_hotel.gif?%3E");
                atbProductTitle.setCreatedAt(currentTimestamp.toString());
                atbProductTitle.setUpdatedAt(currentTimestamp.toString());
                atbProductTitle.setCityName(cityCode.getOriginalName());
                atbProductTitle.setCityCode(String.valueOf(cityCode.getId()));
                atbProductTitle.setMarchandNetPrice(currentProduct.getPrice());
                atbProductTitle.setOnSale("1");
                atbProductTitle.setShippable(true);


                if(currentProduct.getLanguages().getLangDescription().get("EN").getCategory()!=null && !currentProduct.getLanguages().getLangDescription().get("EN").getCategory().equals("")){
                    if(currentProduct.getLanguages().getLangDescription().get("EN").getCategory().equals("Tennis"))
                        atbProductTitle.setThumbnailUrl("https://nv.ua/img/article/2990/32_main.jpg");
                    else if(currentProduct.getLanguages().getLangDescription().get("EN").getCategory().equals("Football"))
                        atbProductTitle.setThumbnailUrl("https://ae01.alicdn.com/kf/HTB13q.WJVXXXXXiXXXXq6xXFXXXA/Papel-pintado-de-encargo-de-la-foto-f-tbol-en-el-c-sped-para-el-sal.jpg_640x640q90.jpg");
                    else if(currentProduct.getLanguages().getLangDescription().get("EN").getCategory().equals("Motorsports"))
                        atbProductTitle.setThumbnailUrl("https://i.ytimg.com/vi/rtfifEoFdVA/hqdefault.jpg");
                    else if(currentProduct.getLanguages().getLangDescription().get("EN").getCategory().equals("Concerts"))
                        atbProductTitle.setThumbnailUrl("http://freedesignfile.com/upload/2016/11/The-rock-concert-cheered-the-crowd-with-yellow-light-smoke.jpg");
                    else if(currentProduct.getLanguages().getLangDescription().get("EN").getCategory().equals("Rugby"))
                        atbProductTitle.setThumbnailUrl("https://www.verve.ie/wp-content/uploads/Rugby_WC.png");
                    else if(currentProduct.getLanguages().getLangDescription().get("EN").getCategory().equals("Darts"))
                        atbProductTitle.setThumbnailUrl("https://static.vinepair.com/wp-content/uploads/2017/03/darts-int.jpg");
                    else if(currentProduct.getLanguages().getLangDescription().get("EN").getCategory().equals("American Football"))
                        atbProductTitle.setThumbnailUrl("https://www.verve.ie/wp-content/uploads/Rugby_WC.png");
                }

                if(desc.getSeating_description().contains("FIFA") && countryCode.getIsoCode().equals("RU ")) {//todo remove this code after mudial ends
                    atbProductTitle.setCategoriesTag("World Cup 2018");
                    atbProductTitle.setThumbnailUrl("https://www.atbholidays.com/product_data/0RUSSIA%20WORLD%20CUP%20LOGO%20KULLANILACAK.jpg");
                }else{
                    if (currentProduct.getLanguages().getLangDescription().get("EN").getCategory() != null && !currentProduct.getLanguages().getLangDescription().get("EN").getCategory().equals(""))
                        atbProductTitle.setCategoriesTag(currentProduct.getLanguages().getLangDescription().get("EN").getCategory());
                    else
                        atbProductTitle.setCategoriesTag("");
                }

                String title="("+currentProduct.getLanguages().getLangDescription().get("EN").getName().substring(0, 1).toUpperCase()+
                                 currentProduct.getLanguages().getLangDescription().get("EN").getName().substring(1)+") "+
                                 currentProduct.getLanguages().getLangDescription().get("EN").getEvent();
                if(!currentProduct.getLanguages().getLangDescription().get("EN").getEvent_guest().equals(""))
                    title=title +" - ";//todo Upercase the first letter of tittle
                title=title+ currentProduct.getLanguages().getLangDescription().get("EN").getEvent_guest()+" "+currentProduct.getDate();
                atbProductTitle.setProductTitle(title);

                //Execute
                try {
                    if(productId==0)
                        productId=AProductTitleDAO.addproduct(atbProductTitle);
                    else {
                        atbProductTitle.setId(productId);
                        AProductTitleDAO.updateproduct(atbProductTitle);
                    }
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    continue;
                }


                productDetail = new BProductDetailBean();
                productDetail.setDescriptionSummary(desc.getName());
                productDetail.setProductDetail(desc.getSeating().replaceAll("Events Travel","ATB Holidays")+
                                               "#"+desc.getSeating_id().replaceAll("Events Travel","ATB Holidays")+
                                               "#"+desc.getSeating_description().replaceAll("Events Travel","ATB Holidays"));
                productDetail.setProductId(String.valueOf(productId));
                productDetail.setCategories(desc.getCategory());
                productDetail.setAdittionalInfo(desc.getHospitality_description());
                productDetail.setHighlight(desc.getEvent());
                productDetail.setInclusions("");
                productDetail.setExclusions("");
                productDetail.setCancellationPolicy("");
                productDetail.setMerchantCancellable("false");
                productDetail.setVoucherInfo("");
                productDetail.setCreatedAt(currentTimestamp.toString());
                productDetail.setUpdatedAt(currentTimestamp.toString());
                productDetail.setVoucherTelephone("");
                productDetail.setMobileAccess("no");
                productDetail.setVoucherCountryCode("");
                productDetailList.add(productDetail);

                try {
                    BProductDetailDAO.saveOrUpdateProductDetail(productDetailList);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    continue;
                }

                List<DProductPhotoBean> photos = new ArrayList<>();//todo remove this code when mudial ends
                if(desc.getSeating_description().contains("FIFA") && countryCode.getIsoCode().equals("RU ")) {
                    photo = new DProductPhotoBean();
                    photo.setPhotoName("0RUSSIA%20WORLD%20CUP%20LOGO%20KULLANILACAK.jpg");
                    photo.setSupplierId("10232");
                    photo.setProductId(String.valueOf(productId));
                    photo.setVt("2");
                    photo.setAtb("");
                    photo.setCaption("");
                    photo.setMainPhoto("ON");
                    photo.setSubId("evtTicket");
                    photo.setCreatedAt(currentTimestamp.toString());
                    photo.setUpdatedAt(currentTimestamp.toString());
                    photos.add(photo);
                }

                photo = new DProductPhotoBean();
                photo.setPhotoName(currentProduct.getImage().replace(EventsTravelController.PHOTO_PATH,""));
                photo.setSupplierId(String.valueOf(SupplierDAO.getSupplierId(EventsTravelController.EVENTS_TRAVEL)));
                photo.setProductId(String.valueOf(productId));
                photo.setVt("2");
                photo.setAtb("");
                photo.setCaption("seat plan");
                photo.setMainPhoto("");
                photo.setSubId("evtTicket");
                photo.setCreatedAt(currentTimestamp.toString());
                photo.setUpdatedAt(currentTimestamp.toString());
                photos.add(photo);
                try {
                    DProductPhotoDAO.saveOrUpdatePhoto(photos);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    continue;
                }
                pricePlan = new FPricePlanBean();
                pricePlan.setMinParticipants("1");
                pricePlan.setPlanTitle("default");
                pricePlan.setProductId(String.valueOf(productId));
                pricePlan.setSubId("evtTicket");
                pricePlan.setPriceType("Price Per Person");
                pricePlan.setRateType("net");
                pricePlan.setTourGradeCode("");
                pricePlan.setCreatedAt(currentTimestamp.toString());
                pricePlan.setUpdatedAt(currentTimestamp.toString());

                int pricePlanId=0;
                try {
                    pricePlan=FPricePlanDAO.saveOrUpdatePriceplanViatorProductsOnly(pricePlan);
                    if(pricePlan!=null)
                        pricePlanId=pricePlan.getId();
                    else
                        continue;
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    continue;
                }
                price = new GPriceMatrixBean();
                price.setAgeFrom("0");
                price.setAgeTo("99");
                price.setCommission("");
                price.setCreatedAt(currentTimestamp.toString());
                price.setUpdatedAt(currentTimestamp.toString());
                price.setPriceNet(currentProduct.getPrice());
                price.setProductId(String.valueOf(productId));
                price.setCurrencyCode("EUR");
                price.setPersonType("adult");
                price.setCommission("");
                price.setPlanId(String.valueOf(pricePlanId));
                price.setOptionTitle("");
                price.setMinCountRequired(1);
                if(Integer.parseInt(currentProduct.getStock())>4)
                    price.setMaxCountRequired(4);
                else
                    price.setMaxCountRequired(Integer.parseInt(currentProduct.getStock()));
                price.setPriceRate("");
                priceList.add(price);
                try {
                    GPriceMatrixDAO.saveOrUpdatePriceMatrix(priceList);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    continue;
                }
                date = new HAvailableDateBean();
                date.setCreatedAt(currentTimestamp);
                date.setDepartimeOnOff("");
                date.setPlanId(String.valueOf(pricePlanId));
                date.setProductId(String.valueOf(productId));
                Timestamp timeStampDate=null;
                try {
                    DateFormat formatter;
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date d = (Date) formatter.parse(currentProduct.getDate());
                    timeStampDate = new Timestamp(d.getTime());
                    date.setStartDate(timeStampDate);
                    timeStampDate = new Timestamp(d.getTime()+(1000*60*60*48));
                    date.setEndDate(timeStampDate);
                    timeStampDate = new Timestamp(d.getTime()+(1000*60*60*24));
                } catch (ParseException e) {
                    //System.out.println("Exception :" + e);
                }
                date.setAvailableTitle(desc.getSeating());
                date.setAvailableTimeType("Opening hours/operating hours");
                date.setUpdatedAt(currentTimestamp);
                int dateId=0;
                try {
                    dateId=HAvailableDateDAO.addAvailableDate(date);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    continue;
                }

                time = new IAvailableTimeBean();
                time.setAvailableId(String.valueOf(dateId));
                time.setCreatedAt(currentTimestamp);
                time.setEndTime("23:59:59");
                time.setPlanId(String.valueOf(pricePlanId));
                time.setProductId(String.valueOf(productId));
                time.setStartTime("00:00:00");
                time.setUpdatedAt(currentTimestamp);
                LocalDateTime withoutTimezone = convertStringToDate(currentProduct.getDate()).toLocalDateTime();
                time.setWeekDay(withoutTimezone.getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE , Locale.US));
                try {
                    IAvailableTimeDAO.addAvailableTime(time);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    continue;
                }

                hSpecialDateBean=new HSpecialDateBean();
                hSpecialDateBean.setAvailableId(String.valueOf(dateId));
                hSpecialDateBean.setCreatedAt(java.sql.Date.valueOf(currentTimestamp.toLocalDateTime().toLocalDate()));
                hSpecialDateBean.setPlanId(String.valueOf(pricePlanId));
                hSpecialDateBean.setProductId(String.valueOf(productId));
                hSpecialDateBean.setServiceDate(java.sql.Date.valueOf(timeStampDate.toLocalDateTime().toLocalDate()));
                hSpecialDateBean.setUpdatedAt(java.sql.Date.valueOf(currentTimestamp.toLocalDateTime().toLocalDate()));
                try {
                    HSpecialDateDAO.addSpecialDate(hSpecialDateBean);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                    tx.rollback();
                    continue;
                }

                stored++;
                logger.info(stored+") Product with Id: "+productId+" Sku: "+currentProduct.getSku());
                tx.commit();

            }catch (Exception e) {
                logger.info(e.getMessage());
                e.printStackTrace();
                tx.rollback();
                session.close();
                continue;
            }
        }
        List<AProductTitleBean> outDatedproducts = AProductTitleDAO.getOutdatedProducts(EventsTravelController.EVENTS_TRAVEL, currentTimestamp.toString(),"evtTicket" );
        for (AProductTitleBean prd : outDatedproducts){
            tx=session.beginTransaction();
            try {
                prd.setOnSale("0");
                AProductTitleDAO.updateproduct(prd);
                HAvailableDateDAO.deleteAvailableDate(String.valueOf(prd.getId()));
                IAvailableTimeDAO.deleteavailableTime(String.valueOf(prd.getId()));
                HSpecialDateDAO.deleteSpecialDate(String.valueOf(prd.getId()));
                logger.info("Removing unavailable product: "+prd.getId());
                tx.commit();
            } catch (Exception e){
                logger.info(e.getMessage());
                tx.rollback();
                break;
            }

        }
        currentTimestamp = Timestamp.valueOf(LocalDateTime.now());
        logger.info("Stored: "+stored+" out of: "+total+" products.\nThe update process took "+ (currentTimestamp.getTime() - startingTimestamp.getTime())+" ms");
        session.close();
    }
    public static Timestamp convertStringToDate(String str_date) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = (Date) formatter.parse(str_date);
            Timestamp timeStampDate = new Timestamp(date.getTime());
            return timeStampDate;
        } catch (ParseException e) {
            //System.out.println("Exception :" + e);
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
            //System.out.println("Exception :" + e);
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

