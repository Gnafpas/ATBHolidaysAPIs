package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.*;
import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;
import Beans.ATBDBBeans.KalitaonProduct.ProductCategoriesBean;
import Beans.ATBDBBeans.KalitaonSystem.AllLanguageBean;
import Beans.ATBDBBeans.KalitaonSystem.CityCodeBean;
import Beans.ATBDBBeans.KalitaonSystem.CountryCodeBean;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.AProductTitleDAO;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.ProductCategoriesDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.AllLanguageDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CityCodeDAO;
import DAOs.ATBDBDAOs.KalitaonSysDAOs.CountryCodeDAO;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 15/09/2017.
 */
@RestController
public class TaxonomyController {


    @RequestMapping("/taxonomy/languages")
    public LanguagesJSON getAllLanguages(){
        List<AllLanguageBean> languages;
        LanguagesJSON languagesJSON=new LanguagesJSON();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        languagesJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");
        languages= AllLanguageDAO.getAllLanguages();
        if(languages!=null) {
            languagesJSON.setData(languages);
            languagesJSON.setTotalCount(languages.size());
        }else{
            languagesJSON.setSuccess(false);
            languagesJSON.setErrorMessageText("Database Communication Error.");
        }

        return languagesJSON;
    }


    @RequestMapping("/taxonomy/countries")
    public CountriesJSON getAllCountries(){
        List<CountryCodeBean> countries;
        CountriesJSON countriesJSON=new CountriesJSON();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        countriesJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");
        countries= CountryCodeDAO.getCountries();
        if(countries!=null) {
            countriesJSON.setData(countries);
            countriesJSON.setTotalCount(countries.size());
        }else{
            countriesJSON.setSuccess(false);
            countriesJSON.setErrorMessageText("Database Communication Error.");
        }

        return countriesJSON;
    }

    @RequestMapping("/taxonomy/citiesofCountry")
    public CitiesJSON getAllCities(@RequestParam (value="countryCode", defaultValue="") String countryCode){
        List<CityCodeBean> cities;
        CitiesJSON citiesJSON = new CitiesJSON();
        if(!countryCode.equals("")) {
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
        return citiesJSON;
    }


    @RequestMapping("/taxonomy/categories")
    public CategoriesJson getAllCategories(@RequestParam (value="countryCode", defaultValue="") String countryCode,
                                           @RequestParam (value="cityCode", defaultValue="") String cityCode){
//todo fix country codes at database.they have spaces
        ProductsAndCategoriesPOST params=new ProductsAndCategoriesPOST();
        params.setCityCode(cityCode);
        params.setCountryCode(countryCode);
        List <AProductTitleBean>  products;
        List<ProductCategoriesBean> categories;
        List<String> categoryNames=new ArrayList<>();
        CategoriesJson categoriesJson=new CategoriesJson();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        categoriesJson.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");
        Category category;
        categories=ProductCategoriesDAO.getAllCategories();
        if(categories!=null) {
            for (ProductCategoriesBean cat : categories) {
                category = new Category();
                category.setCategory(cat);
                categoryNames.clear();
                categoryNames.add(cat.getCategoryName());

                if(!params.getCityCode().equals("") || !params.getCountryCode().equals("")) {
                    params.setCategories(categoryNames);
                    products = AProductTitleDAO.getProducts(params,null,null);
                    if (products != null)
                        category.setProductCount(products.size());
                }
                categoriesJson.getData().add(category);
            }
            categoriesJson.setTotalCount(categoriesJson.getData().size());
        }else {
            categoriesJson.setSuccess(false);
            categoriesJson.setErrorMessageText("Database Communication Error.");
        }


        return categoriesJson;
    }

}
