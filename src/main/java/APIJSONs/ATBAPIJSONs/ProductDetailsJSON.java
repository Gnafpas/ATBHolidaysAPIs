package APIJSONs.ATBAPIJSONs;

import Beans.ATBDBBeans.KalitaonProduct.*;

import java.util.List;

/**
 * Created by George on 27/09/2017.
 */
public class ProductDetailsJSON {

    private List<AProductTitleBean> aProductTitleBean;
    private List<BProductDetailBean> bProductDetailBean;
    private List<CProductOptionsBean>cProductOptionsBean;
    private List<DProductPhotoBean> dProductPhotoBean;
    private List<EPickupPointBean> ePickupPointBean;
    private List<FPricePlanBean> fPricePlanBean;
    private List<GPriceMatrixBean> gPriceMatrixBean;
    private List<HAvailableDateBean> hAvailableDateBean;
    private List<JProductQuestionsBean> JProductQuestionsBean;
    private List<HSpecialDateBean> HSpecialDateBean;
    private List<HStopsaleDateBean> hStopsaleDateBean;
    private List<IAvailableTimeBean> iAvailableTimeBean;
    private boolean DBError=false;


    public List<Beans.ATBDBBeans.KalitaonProduct.JProductQuestionsBean> getJProductQuestionsBean() {
        return JProductQuestionsBean;
    }

    public void setJProductQuestionsBean(List<Beans.ATBDBBeans.KalitaonProduct.JProductQuestionsBean> JProductQuestionsBean) {
        this.JProductQuestionsBean = JProductQuestionsBean;
    }

    public List<Beans.ATBDBBeans.KalitaonProduct.HSpecialDateBean> getHSpecialDateBean() {
        return HSpecialDateBean;
    }

    public void setHSpecialDateBean(List<Beans.ATBDBBeans.KalitaonProduct.HSpecialDateBean> HSpecialDateBean) {
        this.HSpecialDateBean = HSpecialDateBean;
    }

    public List<AProductTitleBean> getaProductTitleBean() {
        return aProductTitleBean;
    }

    public void setaProductTitleBean(List<AProductTitleBean> aProductTitleBean) {
        this.aProductTitleBean = aProductTitleBean;
    }

    public List<BProductDetailBean> getbProductDetailBean() {
        return bProductDetailBean;
    }

    public void setbProductDetailBean(List<BProductDetailBean> bProductDetailBean) {
        this.bProductDetailBean = bProductDetailBean;
    }

    public List<CProductOptionsBean> getcProductOptionsBean() {
        return cProductOptionsBean;
    }

    public void setcProductOptionsBean(List<CProductOptionsBean> cProductOptionsBean) {
        this.cProductOptionsBean = cProductOptionsBean;
    }

    public List<DProductPhotoBean> getdProductPhotoBean() {
        return dProductPhotoBean;
    }

    public void setdProductPhotoBean(List<DProductPhotoBean> dProductPhotoBean) {
        this.dProductPhotoBean = dProductPhotoBean;
    }

    public List<EPickupPointBean> getePickupPointBean() {
        return ePickupPointBean;
    }

    public void setePickupPointBean(List<EPickupPointBean> ePickupPointBean) {
        this.ePickupPointBean = ePickupPointBean;
    }

    public List<FPricePlanBean> getfPricePlanBean() {
        return fPricePlanBean;
    }

    public void setfPricePlanBean(List<FPricePlanBean> fPricePlanBean) {
        this.fPricePlanBean = fPricePlanBean;
    }

    public List<GPriceMatrixBean> getgPriceMatrixBean() {
        return gPriceMatrixBean;
    }

    public void setgPriceMatrixBean(List<GPriceMatrixBean> gPriceMatrixBean) {
        this.gPriceMatrixBean = gPriceMatrixBean;
    }

    public List<HAvailableDateBean> gethAvailableDateBean() {
        return hAvailableDateBean;
    }

    public void sethAvailableDateBean(List<HAvailableDateBean> hAvailableDateBean) {
        this.hAvailableDateBean = hAvailableDateBean;
    }

    public List<HStopsaleDateBean> gethStopsaleDateBean() {
        return hStopsaleDateBean;
    }

    public void sethStopsaleDateBean(List<HStopsaleDateBean> hStopsaleDateBean) {
        this.hStopsaleDateBean = hStopsaleDateBean;
    }

    public List<IAvailableTimeBean> getiAvailableTimeBean() {
        return iAvailableTimeBean;
    }

    public void setiAvailableTimeBean(List<IAvailableTimeBean> iAvailableTimeBean) {
        this.iAvailableTimeBean = iAvailableTimeBean;
    }

    public boolean isDBError() {
        return DBError;
    }

    public void setDBError(boolean DBError) {
        this.DBError = DBError;
    }
}
