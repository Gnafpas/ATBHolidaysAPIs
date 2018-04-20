package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.Product.*;
import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;
import Beans.ATBDBBeans.KalitaonProduct.ProductCategoriesBean;
import Beans.ATBDBBeans.KalitaonSystem.AllLanguageBean;
import Beans.ATBDBBeans.KalitaonSystem.CityCodeBean;
import Beans.ATBDBBeans.KalitaonSystem.CountryCodeBean;
import Controller.Application;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.AProductTitleDAO;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.ProductCategoriesDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.AllLanguageDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CityCodeDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CountryCodeDAO;
import DBConnection.ATBHibernateUtil;
import org.hibernate.StatelessSession;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 15/09/2017.
 */
@RestController
public class ProductTaxonomyController {


    @RequestMapping("/product/taxonomy/languages")
    public LanguagesJSON getAllLanguages(){
        Application.agent.increment("app.web.request.api.product.languages");
        List<AllLanguageBean> languages;
        LanguagesJSON languagesJSON=new LanguagesJSON();
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            languagesJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
            languages = AllLanguageDAO.getAllLanguages();
            if (languages != null) {
                languagesJSON.setData(languages);
                languagesJSON.setTotalCount(languages.size());
            } else {
                languagesJSON.setSuccess(false);
                languagesJSON.setErrorMessageText("Database Communication Error.");
            }
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            languagesJSON.setSuccess(false);
            languagesJSON.setErrorMessageText(errors.toString());
        }
        return languagesJSON;
    }


    @RequestMapping("/product/taxonomy/countries")
    public CountriesJSON getAllCountries(){
        Application.agent.increment("app.web.request.api.product.countries");
        List<CountryCodeBean> countries;
        CountriesJSON countriesJSON=new CountriesJSON();
        try {
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            countriesJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
            countries = CountryCodeDAO.getCountries();
            if (countries != null) {
                countriesJSON.setData(countries);
                countriesJSON.setTotalCount(countries.size());
            } else {
                countriesJSON.setSuccess(false);
                countriesJSON.setErrorMessageText("Database Communication Error.");
            }
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            countriesJSON.setSuccess(false);
            countriesJSON.setErrorMessageText(errors.toString());
        }
        return countriesJSON;
    }

    @RequestMapping("/product/taxonomy/citiesOfCountry")
    public CitiesJSON getAllCities(@RequestParam (value="countryCode", defaultValue="") String countryCode){
        Application.agent.increment("app.web.request.api.product.citiesOfCountry");
        List<CityCodeBean> cities;
        CitiesJSON citiesJSON = new CitiesJSON();
        try {
            if (!countryCode.equals("")) {
                DateTime dateTime = new DateTime(DateTimeZone.UTC);
                citiesJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                        dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                        dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
                cities = CityCodeDAO.getCountryCities(countryCode);
                if (cities != null) {
                    citiesJSON.setData(cities);
                    citiesJSON.setTotalCount(cities.size());
                } else {
                    citiesJSON.setSuccess(false);
                    citiesJSON.setErrorMessageText("Database Communication Error.");
                }
            }
        }catch(Exception e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
                citiesJSON.setSuccess(false);
                citiesJSON.setErrorMessageText(errors.toString());
        }
        return citiesJSON;
    }


    @RequestMapping("/product/taxonomy/categories")
    public CategoriesJson getAllCategories(@RequestParam (value="cityCode", defaultValue="") String cityCode){
        //todo fix country codes at database.they have spaces
        Application.agent.increment("app.web.request.api.product.categories");
        ProductsAndCategoriesPOST params=new ProductsAndCategoriesPOST();
        CategoriesJson categoriesJson = new CategoriesJson();
        try {
            List<AProductTitleBean> products;
            List<ProductCategoriesBean> categories;
            List<String> categoryNames = new ArrayList<>();
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            categoriesJson.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour(), dateTime.getSecondOfMinute())).toString() + "+0000");
            Category category;
            categories = ProductCategoriesDAO.getAllCategories();
            if (categories != null) {
                StatelessSession session = ATBHibernateUtil.getSession();
                for (ProductCategoriesBean cat : categories) {
                    category = new Category();
                    category.setCategoryName(cat.getCategoryName());
                    category.setId(cat.getId());
                    categoryNames.clear();
                    categoryNames.add(cat.getCategoryName());
                    params.setCityCode(cityCode);
                    if (!params.getCityCode().equals("")) {
                        params.setCategories(categoryNames);
                        products = AProductTitleDAO.getProducts(params, null, null, session);
                        if (products != null)
                            category.setProductCount(products.size());
                    }
                    categoriesJson.getData().getCategories().add(category);
                }
                session.close();
                categoriesJson.setTotalCount(categoriesJson.getData().getCategories().size());
            } else {
                categoriesJson.setSuccess(false);
                categoriesJson.setErrorMessageText("Database Communication Error.");
            }
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            categoriesJson.setSuccess(false);
            categoriesJson.setErrorMessageText(errors.toString());
        }
        return categoriesJson;
    }

}
