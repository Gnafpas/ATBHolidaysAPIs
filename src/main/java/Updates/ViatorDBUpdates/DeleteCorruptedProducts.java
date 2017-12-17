package Updates.ViatorDBUpdates;

import Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix.PricingMatrix;
import Beans.ViatorDBBeans.UpdateDBBeans.TotalExpiredProducts;
import Beans.ViatorDBBeans.ViatorNoneAvailableDatesBean;
import Beans.ViatorDBBeans.ViatorPricingMatrixBean;
import Beans.ViatorDBBeans.ViatorUpdateFailedProductsBean;
import Beans.ViatorDBBeans.ViatorUpdateProductsInfoBean;
import DAOs.ViatorDBDAOs.*;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static Controller.Application.errLogger;

/**
 * Created by George on 02/11/2017.
 */
public class DeleteCorruptedProducts {

    public  static boolean deleteCorruptedProducts(Logger logger) {

        int lastUpdateRid;
        int counter=0;
        int counter2=0;
        boolean errorWhileDeleting=false;
        boolean exist;
        ViatorUpdateProductsInfoBean viatorUpdateProductsInfo=ViatorUpdateProductsInfoDAO.getLastRecord();
        List<String> corruptedProducts;
        List<String> productCodesWithFailedPricematrixes;
        List<String> productCodesWithFailedAvailDates;
        if(viatorUpdateProductsInfo!=null){
            lastUpdateRid=viatorUpdateProductsInfo.getRid();
            corruptedProducts=ViatorUpdateFailedProductsDAO.getProductCodeByUpdateRid(lastUpdateRid);
            productCodesWithFailedAvailDates=ViatorUpdateFailedAvailDatesDAO.getProductCodeByUpdateRid(lastUpdateRid);
            productCodesWithFailedPricematrixes=ViatorUpdateFailedPricematrixesDAO.getProductCodeByUpdateRid(lastUpdateRid);

            /**
             * Adding to corruptedProducts list products with failed availability dates and pricematrixes.
             */
            if(corruptedProducts==null)
                corruptedProducts=new ArrayList<>();
            if(productCodesWithFailedAvailDates!=null) {
                for (String code : productCodesWithFailedAvailDates) {
                    exist = false;
                    for (String code2 : corruptedProducts) {
                        if (code.equals(code2))
                            exist = true;
                    }
                    if (!exist)
                        corruptedProducts.add(code);
                }
            }
            if(productCodesWithFailedPricematrixes!=null) {
                for (String code : productCodesWithFailedPricematrixes) {
                    exist = false;
                    for (String code2 : corruptedProducts) {
                        if (code.equals(code2))
                            exist = true;
                    }
                    if (!exist)
                        corruptedProducts.add(code);
                }
            }


            for (String code:corruptedProducts) {
                StatelessSession session = HibernateUtil.getSession();
                Transaction tx;
                try {
                    tx = session.beginTransaction();
                    if (ViatorProductDetailsDAO.deleteProduct(code,session)) {
                        errorWhileDeleting = true;
                        tx.rollback();
                    } else {
                        tx.commit();
                    }
                } catch (HibernateException e) {
                    StringWriter errors = new StringWriter();
                    e.printStackTrace(new PrintWriter(errors));
                    errLogger.info(errors.toString());
                    errorWhileDeleting = true;
                } catch (ExceptionInInitializerError e) {
                    StringWriter errors = new StringWriter();
                    e.printStackTrace(new PrintWriter(errors));
                    errLogger.info(errors.toString());
                    errorWhileDeleting = true;
                } catch (CJCommunicationsException e) {
                    StringWriter errors = new StringWriter();
                    e.printStackTrace(new PrintWriter(errors));
                    errLogger.info(errors.toString());
                    errorWhileDeleting = true;
                } finally {
                    session.close();
                }
                counter++;
                logger.info("********************** Deleting corrupted product with code: " + code + " **********************");

            }


        }else
            errorWhileDeleting=true;

        /**
         * Delete products comming from viator with no rates or comming only with price zero
         */
        List<String> allCodes=ViatorProductDetailsDAO.getAllProductsCodes();
        List<ViatorPricingMatrixBean> pricingMatrixes;
        List<ViatorNoneAvailableDatesBean> noneAvailableDates;
        if(allCodes!=null){
            for(String code:allCodes){
                pricingMatrixes=ViatorPricingMatrixDAO.getPricingMatrixByProductCode(code);
                if(pricingMatrixes!=null){
                    if(pricingMatrixes.size()==0){

                        StatelessSession session = HibernateUtil.getSession();
                        Transaction tx;
                        try {
                            tx = session.beginTransaction();
                            if (ViatorProductDetailsDAO.deleteProduct(code,session)){
                                errorWhileDeleting=true;
                                tx.rollback();
                            } else {
                                tx.commit();
                            }
                        } catch (HibernateException e) {
                            StringWriter errors = new StringWriter();
                            e.printStackTrace(new PrintWriter(errors));
                            errLogger.info(errors.toString());
                            errorWhileDeleting = true;
                        } catch (ExceptionInInitializerError e) {
                            StringWriter errors = new StringWriter();
                            e.printStackTrace(new PrintWriter(errors));
                            errLogger.info(errors.toString());
                            errorWhileDeleting = true;
                        } catch (CJCommunicationsException e) {
                            StringWriter errors = new StringWriter();
                            e.printStackTrace(new PrintWriter(errors));
                            errLogger.info(errors.toString());
                            errorWhileDeleting = true;
                        } finally {
                            session.close();
                        }
                        counter2++;
                        logger.info("********************** Deleting product comming from viator with no rates with code: " + code + " **********************");
                    }else{
                        BigDecimal maxprice=new BigDecimal(0);
                        for(ViatorPricingMatrixBean pricingMatrix:pricingMatrixes){
                            if(pricingMatrix.getMerchantNetPrice().compareTo(maxprice)==1) {
                                maxprice = pricingMatrix.getMerchantNetPrice();
                            }
                        }
                        if(maxprice.compareTo(new BigDecimal(0))==0){
                            StatelessSession session = HibernateUtil.getSession();
                            Transaction tx;
                            try {
                                tx = session.beginTransaction();
                                if (ViatorProductDetailsDAO.deleteProduct(code,session)){
                                    errorWhileDeleting=true;
                                    tx.rollback();
                                } else {
                                    tx.commit();
                                }
                            } catch (HibernateException e) {
                                StringWriter errors = new StringWriter();
                                e.printStackTrace(new PrintWriter(errors));
                                errLogger.info(errors.toString());
                                errorWhileDeleting = true;
                            } catch (ExceptionInInitializerError e) {
                                StringWriter errors = new StringWriter();
                                e.printStackTrace(new PrintWriter(errors));
                                errLogger.info(errors.toString());
                                errorWhileDeleting = true;
                            } catch (CJCommunicationsException e) {
                                StringWriter errors = new StringWriter();
                                e.printStackTrace(new PrintWriter(errors));
                                errLogger.info(errors.toString());
                                errorWhileDeleting = true;
                            } finally {
                                session.close();
                            }
                            counter2++;
                            logger.info("********************** Deleting product comming from viator with no rates with code: " + code + " **********************");
                        }
                    }

                }else
                    errorWhileDeleting=true;
            }
            for(String code:allCodes){
                noneAvailableDates=ViatorNoneAvailableDatesDAO.getNoneAvailableDatesBeanByProductCode(code);
                if(noneAvailableDates!=null){
                    if(noneAvailableDates.size()==0){
                        StatelessSession session = HibernateUtil.getSession();
                        Transaction tx;
                        try {
                            tx = session.beginTransaction();
                            if (ViatorProductDetailsDAO.deleteProduct(code,session)){
                                errorWhileDeleting=true;
                                tx.rollback();
                            } else {
                                tx.commit();
                            }
                        } catch (HibernateException e) {
                            StringWriter errors = new StringWriter();
                            e.printStackTrace(new PrintWriter(errors));
                            errLogger.info(errors.toString());
                            errorWhileDeleting = true;
                        } catch (ExceptionInInitializerError e) {
                            StringWriter errors = new StringWriter();
                            e.printStackTrace(new PrintWriter(errors));
                            errLogger.info(errors.toString());
                            errorWhileDeleting = true;
                        } catch (CJCommunicationsException e) {
                            StringWriter errors = new StringWriter();
                            e.printStackTrace(new PrintWriter(errors));
                            errLogger.info(errors.toString());
                            errorWhileDeleting = true;
                        } finally {
                            session.close();
                        }
                        counter2++;
                        logger.info("********************** Deleting product comming from viator with no available dates with code: " + code + " **********************");
                    }

                }else
                    errorWhileDeleting=true;
            }
        }else
            errorWhileDeleting=true;

        logger.info("**********************  " + counter + " corrupted products deleted."+ " **********************");
        logger.info("**********************  " + counter2 + " products comming from viator with no rates deleted."+ " **********************");
        return errorWhileDeleting;//todo delete all products that had not been updated for more than 2 weeks
    }
}
