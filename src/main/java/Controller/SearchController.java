package Controller;

import DAOs.DBDAOs.ViatorDestinationsDAO;
import DAOs.DBDAOs.ViatorProductDetailsDAO;
import DBBeans.ViatorDestinationsBean;
import DBBeans.ViatorProductDetailsBean;
import Helper.SortOrderType;
import WebServicesBeans.PagingList.GetProductsControllerParams;
import WebServicesBeans.Suggestions.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by George on 04/07/2017.
 */

@RestController
public class SearchController {

    /**
     * Returns suggested destinations and suggested products based on text.Products have popularity order.
     */
    @RequestMapping("/getFreeTextSuggestions")
    public SearchFreetextSuggestionsJSON getFreeTextSuggestions(@RequestParam(value="text", defaultValue="") String text,
                                                                @RequestParam(value="topXdest", defaultValue="5") Integer topXdest,
                                                                @RequestParam(value="topXproducts", defaultValue="5") Integer topXproducts) {

        SearchFreetextSuggestionsJSON searchFreetextSuggestionsJSON =new SearchFreetextSuggestionsJSON();
        searchFreetextSuggestionsJSON.setDestinations(getSuggestedDestinations(text,topXdest));
        searchFreetextSuggestionsJSON.setProducts(getSuggestedProducts(text,topXproducts));

        if(searchFreetextSuggestionsJSON.getDestinations().isDbCommError() || searchFreetextSuggestionsJSON.getProducts().isDbCommError())
            searchFreetextSuggestionsJSON.setDbCommError(true);

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
            ViatorDestinationsDAO dest=new ViatorDestinationsDAO();
            allDestinations = dest.getDestinationsByName("");
            if(allDestinations==null)
                suggestedDestinationsList.setDbCommError(true);
            reqDestinations=dest.getDestinationsByName(destName);
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
        ViatorProductDetailsDAO  productsDao=new ViatorProductDetailsDAO();
        SuggestedProductsList suggestedProducts=new SuggestedProductsList();
        List<ViatorProductDetailsBean> products;
        SuggestedProduct suggestedProduct;
        List<Integer> cat=new ArrayList<>();
        List<Integer> subcat=new ArrayList<>();
        products=productsDao.getProducts("",text,"","","",0,0, SortOrderType.popularity,0,topXproducts,cat,subcat,null,null);
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
}
