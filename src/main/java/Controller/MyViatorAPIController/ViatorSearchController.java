package Controller.MyViatorAPIController;

import DAOs.ViatorDBDAOs.ViatorAttractionsDAO;
import DAOs.ViatorDBDAOs.ViatorDestinationsDAO;
import DAOs.ViatorDBDAOs.ViatorNoneAvailableDatesDAO;
import DAOs.ViatorDBDAOs.ViatorProductDetailsDAO;
import Beans.ViatorDBBeans.ViatorAttractionsBean;
import Beans.ViatorDBBeans.ViatorDestinationsBean;
import Beans.ViatorDBBeans.ViatorNoneAvailableDatesBean;
import Beans.ViatorDBBeans.ViatorProductDetailsBean;
import Helper.SortOrderType;
import APIJSONs.MyViatorAPIJSONs.ListingPage.GetAttractionsDAOParams;
import APIJSONs.MyViatorAPIJSONs.ListingPage.GetProductsDAOParams;
import APIJSONs.MyViatorAPIJSONs.Suggestions.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by George on 04/07/2017.
 */

@RestController
public class ViatorSearchController {


    /**
     * Returns the last month that there is availability information for one of the given products.
     */
    @RequestMapping(value = "/getLastMonthWithAvailabilityInfo", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public LastMonthWithAvailabilityInfoJSON getLastMonthWithAvailabilityInfo(@RequestBody  LastMonthWithAvailabilityInfoPOST params){

        LastMonthWithAvailabilityInfoJSON lastMonthWithAvailabilityInfoJSON=new LastMonthWithAvailabilityInfoJSON();
        List<ViatorProductDetailsBean> productsDetails= new ArrayList();
        ViatorProductDetailsBean viatorProductDetailsBean;
        List <ViatorNoneAvailableDatesBean> dates;
        ViatorNoneAvailableDatesBean lastDate=null;
        if(params.getProductCodes().size()==0)
            return lastMonthWithAvailabilityInfoJSON;
        for(String code:params.getProductCodes()) {
            viatorProductDetailsBean=new ViatorProductDetailsBean();
            viatorProductDetailsBean.setCode(code);
            productsDetails.add(viatorProductDetailsBean);
        }
        dates=ViatorNoneAvailableDatesDAO.getNoneAvailDatesOfProducts(productsDetails);
        if(dates!=null && dates.size()>0) {
            lastDate=dates.get(0);
            for (ViatorNoneAvailableDatesBean lDate : dates) {
                if (lastDate.getMonth() < lDate.getMonth() && lastDate.getYear().equals(lDate.getYear()))
                        lastDate=lDate;
                else if (lastDate.getYear() < lDate.getYear())
                        lastDate=lDate;
            }
            lastDate.setDay(0);
        }
        for(int i=0;i< dates.size(); i++)
        lastMonthWithAvailabilityInfoJSON.setLastMonthWithAvailabilityInfo(lastDate);
        if(dates==null)
            lastMonthWithAvailabilityInfoJSON.setDBError(true);
        return lastMonthWithAvailabilityInfoJSON;
    }

    /**
     * Returns suggested destinations and suggested products based on text.Products have popularity order.
     */
    @RequestMapping("/getFreeTextSuggestions")
    public SearchFreetextSuggestionsJSON getFreeTextSuggestions(@RequestParam(value="text", defaultValue="") String text,
                                                                @RequestParam(value="topXdest", defaultValue="5") Integer topXdest,
                                                                @RequestParam(value="topXproducts", defaultValue="5") Integer topXproducts,
                                                                @RequestParam(value="topXattractions", defaultValue="5") Integer topXattractions) {

        SearchFreetextSuggestionsJSON searchFreetextSuggestionsJSON =new SearchFreetextSuggestionsJSON();
        searchFreetextSuggestionsJSON.setDestinations(getSuggestedDestinations(text,topXdest));
        searchFreetextSuggestionsJSON.setProducts(getSuggestedProducts(text,topXproducts));
        searchFreetextSuggestionsJSON.setAttractionsList(getSuggestedAttractions(text,topXattractions));

        if(searchFreetextSuggestionsJSON.getDestinations().isDbCommError() || searchFreetextSuggestionsJSON.getProducts().isDbCommError())
            searchFreetextSuggestionsJSON.setDBError(true);

        return searchFreetextSuggestionsJSON;
    }

    public SuggestedDestinationsList getSuggestedDestinations(String destName,int topXdest){

        List<ViatorDestinationsBean> reqDestinations=null;
        List<ViatorDestinationsBean> allDestinations=null;
        SuggestedDestinationsList suggestedDestinationsList=new SuggestedDestinationsList();
        List<Country> countries=new ArrayList<>();
        Country country;
        List<City> cities=new ArrayList<>();
        City city;
        List<Region> regions=new ArrayList<>();
        Region region;
        String[] split_lookupid;
        int countDestinations=0;
        if(!destName.isEmpty() && destName.length()>=2) {
            allDestinations = ViatorDestinationsDAO.getDestinationsByName("");
            if(allDestinations==null)
                suggestedDestinationsList.setDbCommError(true);
            reqDestinations=ViatorDestinationsDAO.getDestinationsByName(destName);
            if(reqDestinations!=null) {
                for (ViatorDestinationsBean destination : reqDestinations) {
                    if (destination.getDestinationType().equals("COUNTRY")) {
                        if(countDestinations>=topXdest)
                            break;
                        country = new Country();
                        country.setDestinationId(destination.getDestinationId());
                        country.setName(destination.getDestinationNameEn());
                        countries.add(country);
                        countDestinations++;
                    } else if (destination.getDestinationType().equals("CITY") && countDestinations<topXdest) {
                        if(countDestinations>=topXdest)
                            break;
                        city = new City();
                        city.setDestinationId(destination.getDestinationId());
                        city.setName(destination.getDestinationNameEn());

                        /**
                         * Code for finding city's Country from Taxonomy/Destinations API Service
                         */
                        split_lookupid = destination.getLookupId().split(Pattern.quote("."));
                        for (int j = 0; j < allDestinations.size(); j++) {
                            if (allDestinations.get(j).getDestinationId() == Integer.parseInt(split_lookupid[1])) {
                                city.setCountry(allDestinations.get(j).getDestinationNameEn());
                                break;
                            }
                        }
                        cities.add(city);
                        countDestinations++;
                    } else if(countDestinations<topXdest){
                        if(countDestinations>=topXdest)
                            break;
                        region = new Region();
                        region.setDestinationId(destination.getDestinationId());
                        region.setName(destination.getDestinationNameEn());

                        /**
                         * Code for finding city's Country from Taxonomy/Destinations API Service
                         */
                        split_lookupid = destination.getLookupId().split(Pattern.quote("."));
                        for (int j = 0; j < allDestinations.size(); j++) {
                            if (allDestinations.get(j).getDestinationId() == Integer.parseInt(split_lookupid[1])) {
                                region.setCountry(allDestinations.get(j).getDestinationNameEn());
                                break;
                            }
                        }
                        regions.add(region);
                        countDestinations++;
                    }
                    suggestedDestinationsList.setCities(cities);
                    suggestedDestinationsList.setCountries(countries);
                    suggestedDestinationsList.setRegions(regions);
                }
            }else
                suggestedDestinationsList.setDbCommError(true);

        }

        return suggestedDestinationsList;
    }

    public SuggestedProductsList getSuggestedProducts( String text,int topXproducts){
        SuggestedProductsList suggestedProducts=new SuggestedProductsList();
        List<ViatorProductDetailsBean> products;
        SuggestedProduct suggestedProduct;
        GetProductsDAOParams parameters=new GetProductsDAOParams();
        parameters.setTitle(text);
        parameters.setLastProduct(topXproducts);
        parameters.setSortOrder(SortOrderType.popularity);
        products=ViatorProductDetailsDAO.getProducts(parameters);
        if(products==null)
            suggestedProducts.setDbCommError(true);
        else{
            for(ViatorProductDetailsBean product:products) {
                suggestedProduct = new SuggestedProduct();
                suggestedProduct.setCode(product.getCode());
                suggestedProduct.setDestination(product.getPrimaryDestinationNameEn());
                suggestedProduct.setRating(product.getRating());
                suggestedProduct.setTitle(product.getTitleEn());
                suggestedProducts.getProducts().add(suggestedProduct);
            }
        }

        return suggestedProducts;
    }


    public SuggestedAttractionsList getSuggestedAttractions( String text,int topXproducts){
        SuggestedAttractionsList suggestedAttractions=new SuggestedAttractionsList();
        List<ViatorAttractionsBean> attractions;
        SuggestedAttraction suggestedAttraction;
        GetAttractionsDAOParams parameters=new GetAttractionsDAOParams();
        parameters.setTitle(text);
        parameters.setLastAttraction(topXproducts);
        parameters.setSortOrder(SortOrderType.avgRatingD);
        attractions=ViatorAttractionsDAO.getAttractions(parameters);
        if(attractions==null)
            suggestedAttractions.setDbCommError(true);
        else{
            for(ViatorAttractionsBean attraction:attractions) {
                suggestedAttraction = new SuggestedAttraction();
                suggestedAttraction.setSeoId(attraction.getSeoId());
                suggestedAttraction.setCity(attraction.getAttractionCity());
                suggestedAttraction.setState(attraction.getAttractionState());
                suggestedAttraction.setRating(attraction.getRating());
                suggestedAttraction.setTitle(attraction.getTitle());
                suggestedAttractions.getAtractions().add(suggestedAttraction);
            }
        }

        return suggestedAttractions;
    }
}
