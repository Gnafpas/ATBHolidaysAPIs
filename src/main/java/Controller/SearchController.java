package Controller;

import DAOs.DBDAOs.ViatorDestinationsDAO;
import DBBeans.ViatorDestinationsBean;
import WebServicesBeans.PagingList.DestinationCategory;
import WebServicesBeans.Suggestions.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 04/07/2017.
 */

@RestController
public class SearchController {

    @RequestMapping("/getDestinations")
    public SearchFreetextSuggestionsJSON getCategoriesByDestination(@RequestParam(value="destName", defaultValue="") String destName) {

        SearchFreetextSuggestionsJSON searchFreetextSuggestionsJSON =new SearchFreetextSuggestionsJSON();
        List<ViatorDestinationsBean> viatorDestinations=null;
        SuggestedDestinationsList suggestedDestinationsList=new SuggestedDestinationsList();
        List<Country> countries=new ArrayList<>();
        Country country;
        List<City> cities=new ArrayList<>();
        City city;
        List<Region> regions=new ArrayList<>();
        Region region;
        if(!destName.isEmpty() && destName.length()>=2) {
            ViatorDestinationsDAO dest=new ViatorDestinationsDAO();
            viatorDestinations=dest.getDestinationsByName(destName);
            if(viatorDestinations!=null) {
                for (ViatorDestinationsBean destination : viatorDestinations) {
                    if (destination.getDestinationType().equals("COUNTRY")) {
                        country = new Country();
                        country.setDestinationId(destination.getDestinationId());
                        country.setName(destination.getDestinationNameEn());
                        countries.add(country);
                    } else if (destination.getDestinationType().equals("CITY")) {
                        city = new City();
                        city.setDestinationId(destination.getDestinationId());
                        city.setName(destination.getDestinationNameEn());
                        cities.add(city);
                    } else {
                        region = new Region();
                        region.setDestinationId(destination.getDestinationId());
                        region.setName(destination.getDestinationNameEn());
                        regions.add(region);
                    }
                    suggestedDestinationsList.setCities(cities);
                    suggestedDestinationsList.setCountries(countries);
                    suggestedDestinationsList.setRegions(regions);
                }
                searchFreetextSuggestionsJSON.setDestinations(suggestedDestinationsList);
            }else
                searchFreetextSuggestionsJSON.setDbCommError(true);

        }

        return searchFreetextSuggestionsJSON;
    }
}
