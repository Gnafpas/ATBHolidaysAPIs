//package Controller;
//
//import APIBeans.ProductsByDestIDSeoID.ProductsByAttractionPOST;
//import APIBeans.ProductsByDestIDSeoID.ProductsByDestIdSeoIdAPIJSON;
//import APIBeans.ProductsByDestIDSeoID.ProductsByDestinationPOST;
//import APIBeans.SearchFreetext.*;
//import APIBeans.ProductDetails.ProductDetailedInfoAPIJSON;
//import APIBeans.Taxonomy.TaxonomyDestinationsAPIJSON;
//import DAOs.APIDAOs.ProductAPIDAO;
//import DAOs.APIDAOs.TaxonomyAPIDAO;
//import WebServicesBeans.PagingList.*;
//import WebServicesBeans.Suggestions.*;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Pattern;
//
///**
// * Created by George on 29/05/17.
// */
//@RestController
//public class SearchControllerViatorServices {
//
//    @RequestMapping("/getCategoriesByDestination")
//    public List<DestinationCategory> getCategoriesByDestination(@RequestParam(value="destId", defaultValue="0")Integer destId){
//        List<DestinationCategory> destinationCategories =new ArrayList<>();
//        DestinationCategory destinationCategory;
//        ProductsByDestIdSeoIdAPIJSON productsByDestIDSeoIdAPIJSON;
//        ProductAPIDAO product_APIDAO = new ProductAPIDAO();
//        ProductsByDestinationPOST productsByDestinationPOST= new ProductsByDestinationPOST();
//        ProductsByAttractionPOST products_by_attraction_POST=new ProductsByAttractionPOST();
//        productsByDestinationPOST.setCatId(0);
//        productsByDestinationPOST.setCurrencyCode("EUR");
//        productsByDestinationPOST.setDealsOnly(false);
//        productsByDestinationPOST.setDestId(destId);
//        productsByDestinationPOST.setEndDate("");
//        productsByDestinationPOST.setStartDate("");
//        productsByDestinationPOST.setSortOrder("TOP_SELLERS");
//        productsByDestinationPOST.setTopX("");
//        productsByDestinationPOST.setSubCatId(0);
//        productsByDestIDSeoIdAPIJSON = product_APIDAO.searchProducts(productsByDestinationPOST,products_by_attraction_POST,true);
//        if (productsByDestIDSeoIdAPIJSON.isSuccess()) {
//            for (int i = 0; i < productsByDestIDSeoIdAPIJSON.getData().size(); i++) {
//                for(int j=0;j<productsByDestIDSeoIdAPIJSON.getData().get(i).getCatIds().size();j++){
//                    boolean exists=false;
//                    for(int x=0;x<destinationCategories.size();x++) {
//                        if(destinationCategories.get(x).getId()==productsByDestIDSeoIdAPIJSON.getData().get(i).getCatIds().get(j)) {
//                            destinationCategories.get(x).setCount(destinationCategories.get(x).getCount() + 1);
//                            exists=true;
//                        }
//                    }
//                    if(!exists) {
//                        destinationCategory=new DestinationCategory();
//                        destinationCategory.setCount(0);
//                        destinationCategory.setId(productsByDestIDSeoIdAPIJSON.getData().get(i).getCatIds().get(j));
//                        destinationCategories.add(destinationCategory);
//                        //todo set name
//                    }
//                }
//
//            }
//        }
//
//        return destinationCategories;
//    }
//
//
//    @RequestMapping("/getProductsByDestIdSeoId")
//    public ProductsPagingListJSON getProductsByDestIdSeoId(@RequestParam(value="destId", defaultValue="0") Integer destId,
//                                                               @RequestParam(value="topX", defaultValue="") String topX,
//                                                               @RequestParam(value="currencyCode", defaultValue="EUR") String currencyCode,
//                                                               @RequestParam(value="startDate", defaultValue="") String startDate,
//                                                               @RequestParam(value="endDate", defaultValue="") String endDate,
//                                                               @RequestParam(value="catId", defaultValue="0") Integer catId,
//                                                               @RequestParam(value="subCatId", defaultValue="0") Integer subCatId,
//                                                               @RequestParam(value="dealsOnly", defaultValue="false") boolean dealsOnly,
//                                                               @RequestParam(value="sortOrder", defaultValue="TOP_SELLERS") String sortOrder,
//                                                               @RequestParam(value="seoId", defaultValue="0") Integer seoId){
//
//        ProductsPagingListJSON products =new ProductsPagingListJSON();
//        ProductsByDestIdSeoIdAPIJSON productsByDestIdSeoIdAPIJSON;
//        ProductAPIDAO product_APIDAO = new ProductAPIDAO();
//        ProductsByAttractionPOST productByAttractionPOST=new ProductsByAttractionPOST();
//        ProductsByDestinationPOST productsByDestinationPOST= new ProductsByDestinationPOST();
//        ProductSummary productSummary;
//        List<ProductSummary> productsSummaries = new ArrayList<>();
//
//        if(seoId==0) {
//            productsByDestinationPOST.setCatId(catId);
//            productsByDestinationPOST.setCurrencyCode(currencyCode);
//            productsByDestinationPOST.setDealsOnly(dealsOnly);
//            productsByDestinationPOST.setDestId(destId);
//            productsByDestinationPOST.setEndDate(endDate);
//            productsByDestinationPOST.setStartDate(startDate);
//            productsByDestinationPOST.setSortOrder(sortOrder);
//            productsByDestinationPOST.setTopX(topX);
//            productsByDestinationPOST.setSubCatId(subCatId);
//            productsByDestIdSeoIdAPIJSON = product_APIDAO.searchProducts(productsByDestinationPOST,productByAttractionPOST,true);
//        }else{
//            productByAttractionPOST.setCatId(catId);
//            productByAttractionPOST.setCurrencyCode(currencyCode);
//            productByAttractionPOST.setDealsOnly(dealsOnly);
//            productByAttractionPOST.setSeoId(seoId);
//            productByAttractionPOST.setEndDate(endDate);
//            productByAttractionPOST.setStartDate(startDate);
//            productByAttractionPOST.setSortOrder(sortOrder);
//            productByAttractionPOST.setTopX(topX);
//            productByAttractionPOST.setSubCatId(subCatId);
//            productsByDestIdSeoIdAPIJSON = product_APIDAO.searchProducts(productsByDestinationPOST,productByAttractionPOST,false);
//        }
//
//        if (productsByDestIdSeoIdAPIJSON.isSuccess()) {
//            for (int i = 0; i < productsByDestIdSeoIdAPIJSON.getData().size(); i++) {
//                productSummary = new ProductSummary();
//                productSummary.setTitle(productsByDestIdSeoIdAPIJSON.getData().get(i).getTitle());
//                productSummary.setRating(productsByDestIdSeoIdAPIJSON.getData().get(i).getRating());
//                productSummary.setLocation(productsByDestIdSeoIdAPIJSON.getData().get(i).getPrimaryDestinationName());
//                productSummary.setCode(productsByDestIdSeoIdAPIJSON.getData().get(i).getCode());
//                productSummary.setCurrencyCode(productsByDestIdSeoIdAPIJSON.getData().get(i).getCurrencyCode());
//                productSummary.setDuration(productsByDestIdSeoIdAPIJSON.getData().get(i).getDuration());
//                productSummary.setPriceFormatted(productsByDestIdSeoIdAPIJSON.getData().get(i).getPriceFormatted());
//                productSummary.setPrice(productsByDestIdSeoIdAPIJSON.getData().get(i).getPrice());
//                productSummary.setShortDescription(productsByDestIdSeoIdAPIJSON.getData().get(i).getShortDescription());
//                productSummary.setReviewCount(productsByDestIdSeoIdAPIJSON.getData().get(i).getReviewCount());
//                productSummary.setSpecialOfferAvailable(productsByDestIdSeoIdAPIJSON.getData().get(i).isSpecialOfferAvailable());
//                productSummary.setThumbnailHiResURL(productsByDestIdSeoIdAPIJSON.getData().get(i).getThumbnailHiResURL());
//                productSummary.setThumbnailURL(productsByDestIdSeoIdAPIJSON.getData().get(i).getThumbnailURL());
//                //todo Find country
//                //todo Likely to sell out and New on viator
//                //todo Short order by duration and filters by duration and filters by price
//                /**
//                 * If product has special offer,retrieve the price from /service/product (Poduct's details) sevice.
//                 */
//                if (productSummary.isSpecialOfferAvailable()) {
//                    ProductDetailedInfoAPIJSON product_detailed_info_APIJSON;
//                    product_detailed_info_APIJSON = product_APIDAO.productDetailedInfo(productSummary.getCode(),
//                            productSummary.getCurrencyCode(),
//                            false,
//                            false);
//                    productSummary.setRrp(product_detailed_info_APIJSON.getData().getRrp());
//                }
//
//                productsSummaries.add(productSummary);
//            }
//
//                products.setProducts(productsSummaries);
//                products.setTotalCount(productsByDestIdSeoIdAPIJSON.getTotalCount());
//        } else
//            products.setViatorΕrror(true);
//
//        return products;
//
//    }
//    /**
//     * Returns a List(Size depends on topX parameter) of Products
//     * based on what user had type to the searchbox.
//     * If something goes wrong at API's side the boolean
//     * Viator_error will be set to true.
//     */                                               //todo Return also results from isolated words of textbox
//    @RequestMapping("/getSearchboxProductsResults")//todo Put also language parameter
//    public ProductsPagingListJSON getSearchboxProductsResults(@RequestParam(value="textbox", defaultValue="") String textbox,
//                                                                 @RequestParam(value="topX", defaultValue="") String topX,
//                                                                 @RequestParam(value="currencyCode", defaultValue="EUR") String currencyCode) {
//
//        ProductsPagingListJSON products =new ProductsPagingListJSON();
//        if(!textbox.isEmpty()) {
//            ProductAPIDAO product_APIDAO = new ProductAPIDAO();
//            SearchFreetextPOST searchFreetextPOST = new SearchFreetextPOST();
//            SearchFreetextProductsAPIJSON searchFreetextProductsAPIJSON;
//            ProductSummary productSummary;
//            List<ProductSummary> productsSummaries = new ArrayList<>();
//            searchFreetextPOST.setTopX(topX);
//            searchFreetextPOST.setText(textbox);
//            searchFreetextPOST.setCurrencyCode(currencyCode);
//            searchFreetextProductsAPIJSON = product_APIDAO.searchFreeTextProduct(searchFreetextPOST);
//            if (searchFreetextProductsAPIJSON.isSuccess()) {
//                for (int i = 0; i < searchFreetextProductsAPIJSON.getData().size(); i++) {
//                    productSummary = new ProductSummary();
//                    productSummary.setTitle(searchFreetextProductsAPIJSON.getData().get(i).getData().getTitle());
//                    productSummary.setRating(searchFreetextProductsAPIJSON.getData().get(i).getData().getRating());
//                    productSummary.setLocation(searchFreetextProductsAPIJSON.getData().get(i).getData().getPrimaryDestinationName());
//                    productSummary.setCode(searchFreetextProductsAPIJSON.getData().get(i).getData().getCode());
//                    productSummary.setCurrencyCode(searchFreetextProductsAPIJSON.getData().get(i).getData().getCurrencyCode());
//                    productSummary.setDuration(searchFreetextProductsAPIJSON.getData().get(i).getData().getDuration());
//                    productSummary.setPriceFormatted(searchFreetextProductsAPIJSON.getData().get(i).getData().getPriceFormatted());
//                    productSummary.setPrice(searchFreetextProductsAPIJSON.getData().get(i).getData().getPrice());
//                    productSummary.setShortDescription(searchFreetextProductsAPIJSON.getData().get(i).getData().getShortDescription());
//                    productSummary.setReviewCount(searchFreetextProductsAPIJSON.getData().get(i).getData().getReviewCount());
//                    productSummary.setSpecialOfferAvailable(searchFreetextProductsAPIJSON.getData().get(i).getData().isSpecialOfferAvailable());
//                    productSummary.setThumbnailHiResURL(searchFreetextProductsAPIJSON.getData().get(i).getData().getThumbnailHiResURL());
//                    productSummary.setThumbnailURL(searchFreetextProductsAPIJSON.getData().get(i).getData().getThumbnailURL());
//                    //todo Find country
//                    //todo Likely to sell out and New on viator
//                    /**
//                     * If product has special offer,retrieve the price from /service/product (Poduct's details) sevice.
//                     */
//                    if (productSummary.isSpecialOfferAvailable()) {
//                        ProductDetailedInfoAPIJSON product_detailed_info_APIJSON;
//                        product_detailed_info_APIJSON = product_APIDAO.productDetailedInfo(productSummary.getCode(),
//                                productSummary.getCurrencyCode(),
//                                false,
//                                false);
//                        productSummary.setRrp(product_detailed_info_APIJSON.getData().getRrp());
//                    }
//
//                    productsSummaries.add(productSummary);
//                }
//                products.setProducts(productsSummaries);
//                products.setTotalCount(searchFreetextProductsAPIJSON.getTotalCount());
//            } else
//                products.setViatorΕrror(true);
//        }
//        return products;
//
//    }
//
//
//    /**
//     * Returns a List(Size depends on topX parameter) of Attractions
//     * based on what user had type to the searchbox.
//     * If something goes wrong at API's side the boolean
//     * Viator_error will be set to true.
//     */
//    @RequestMapping("/getSearchboxAtractionsresults")//todo Put also language parameter
//    public AttractionsPagingListJSON getSearchboxAttractionsResults(@RequestParam(value="textbox", defaultValue="") String textbox,
//                                                                       @RequestParam(value="topX", defaultValue="") String topX) {
//
//        AttractionsPagingListJSON attractions =new AttractionsPagingListJSON();
//        if(!textbox.isEmpty()) {
//            ProductAPIDAO productAPIDAO = new ProductAPIDAO();
//            SearchFreetextPOST searchFreetextPOST = new SearchFreetextPOST();
//            SearchFreetextAttractionsAPIJSON searchFreetextAttractionsAPIJSON;
//            AttractionSummary attractionSummary;
//            List<AttractionSummary> attractions_summaries = new ArrayList<>();
//            searchFreetextPOST.setTopX(topX);
//            searchFreetextPOST.setText(textbox);
//            searchFreetextAttractionsAPIJSON = productAPIDAO.searchFreeTextAttraction(searchFreetextPOST);
//            if (searchFreetextAttractionsAPIJSON.isSuccess()) {
//                for (int i = 0; i < searchFreetextAttractionsAPIJSON.getData().size(); i++) {
//                    attractionSummary = new AttractionSummary();
//                    attractionSummary.setTitle(searchFreetextAttractionsAPIJSON.getData().get(i).getData().getTitle());
//                    attractionSummary.setRating(searchFreetextAttractionsAPIJSON.getData().get(i).getData().getRating());
//                    attractionSummary.setAttractionCity(searchFreetextAttractionsAPIJSON.getData().get(i).getData().getAttractionCity());
//                    attractionSummary.setReviewCount(searchFreetextAttractionsAPIJSON.getData().get(i).getData().getReviewCount());
//                    attractionSummary.setAttractionState(searchFreetextAttractionsAPIJSON.getData().get(i).getData().getAttractionState());
//                    attractionSummary.setThumbnailHiResURL(searchFreetextAttractionsAPIJSON.getData().get(i).getData().getThumbnailHiResURL());
//                    attractionSummary.setThumbnailURL(searchFreetextAttractionsAPIJSON.getData().get(i).getData().getThumbnailURL());
//                    attractionSummary.setSeoId(searchFreetextAttractionsAPIJSON.getData().get(i).getData().getSeoId());
//                    attractionSummary.setDescriptionText(searchFreetextAttractionsAPIJSON.getData().get(i).getData().getDescriptionText());
//                    attractionSummary.setPagePrimaryLanguage(searchFreetextAttractionsAPIJSON.getData().get(i).getData().getPagePrimaryLanguage());
//                    attractionSummary.setPrimaryDestinationName(searchFreetextAttractionsAPIJSON.getData().get(i).getData().getPrimaryDestinationName());
//
//                    attractions_summaries.add(attractionSummary);
//                }
//                attractions.setAtractions(attractions_summaries);
//                attractions.setTotalCount(searchFreetextAttractionsAPIJSON.getTotalCount());
//            } else
//                attractions.setViatorΕrror(true);
//        }
//        return attractions;
//
//    }
//
//
//
//    /**
//     * Returns a List of suggested Destinations/Attractions/Products
//     * based on what user had type to the searchbox.
//     * If something goes wrong at API's side the boolean
//     * Viator_error will be set to true. //todo Return Top Destinations Attractions if textbox=""
//     */                                //todo Return also results from isolated words of textbox
//    @RequestMapping("/getSearchboxSuggestionsResults")//todo Put also language parameter
//    public SearchFreetextSuggestionsJSON getSearchboxSuggestionsResults(@RequestParam(value="textbox", defaultValue="") String textbox) {
//
//        SearchFreetextSuggestionsJSON searchFreetextSuggestionsJSON =new SearchFreetextSuggestionsJSON();
//        if(!textbox.isEmpty() && textbox.length()>=2) {
//            SuggestedProductsList products = products(textbox,"1-5");
//            SuggestedAttractionsList attractions = attractions(textbox,"1-5");
//            SuggestedDestinationsList destinations = destinations(textbox,"1-5");
//            if (destinations.isViatorΕrror() || attractions.isViatorΕrror() || products.isViatorΕrror())
//                searchFreetextSuggestionsJSON.setViatorΕrror(true);
//            searchFreetextSuggestionsJSON.setProducts(products);
//            searchFreetextSuggestionsJSON.setAttractionsList(attractions);
//            searchFreetextSuggestionsJSON.setDestinations(destinations);
//        }
//        return searchFreetextSuggestionsJSON;
//
//    }
//
//
//    /**
//     * Returns a List of Products
//     * based on what user had type to the searchbox.
//     * If something goes wrong at API's side the boolean
//     * Viator_error will be set to true.
//     */
//    public SuggestedProductsList products(String textbox, String Topx) {
//
//        SuggestedProductsList products =new SuggestedProductsList();
//        ProductAPIDAO productAPIDAO = new ProductAPIDAO();
//        SearchFreetextPOST searchFreeTextPOST = new SearchFreetextPOST();
//        SearchFreetextProductsAPIJSON searchFreeTextProductsAPIJSON;
//        SuggestedProduct suggestedProduct;
//        List<SuggestedProduct> suggestedProducts =new ArrayList<>();
//        searchFreeTextPOST.setTopX(Topx);
//        searchFreeTextPOST.setText(textbox);
//        searchFreeTextProductsAPIJSON = productAPIDAO.searchFreeTextProduct(searchFreeTextPOST);
//        if (searchFreeTextProductsAPIJSON.isSuccess()){
//            for (int i = 0; i < searchFreeTextProductsAPIJSON.getData().size(); i++) {
//                suggestedProduct = new SuggestedProduct();
//                suggestedProduct.setTitle(searchFreeTextProductsAPIJSON.getData().get(i).getData().getTitle());
//                suggestedProduct.setRating(searchFreeTextProductsAPIJSON.getData().get(i).getData().getRating());
//                suggestedProduct.setDestination(searchFreeTextProductsAPIJSON.getData().get(i).getData().getPrimaryDestinationName());
//                suggestedProduct.setCode(searchFreeTextProductsAPIJSON.getData().get(i).getData().getCode());
//                suggestedProducts.add(suggestedProduct);
//            }
//            products.setProducts(suggestedProducts);
//        }else
//            products.setViatorΕrror(true);
//        return products;
//    }
//
//
//    /**
//     * Returns a List of Attractions
//     * based on what user had type to the searchbox.
//     * If something goes wrong at API's side the boolean
//     * Viator_error will be set to true.
//     */
//    public SuggestedAttractionsList attractions(String textbox, String Topx) {
//
//        SuggestedAttractionsList attractions =new SuggestedAttractionsList();
//        ProductAPIDAO productSearch = new ProductAPIDAO();
//        SearchFreetextPOST searchFreeTextPOST = new SearchFreetextPOST();
//        SearchFreetextAttractionsAPIJSON searchFreeTextAttractionsAPIJSON;
//        SuggestedAttraction suggestedΑttraction;
//        List<SuggestedAttraction> suggestedΑttractions =new ArrayList<>();
//        searchFreeTextPOST.setTopX(Topx);
//        searchFreeTextPOST.setText(textbox);
//        searchFreeTextAttractionsAPIJSON = productSearch.searchFreeTextAttraction(searchFreeTextPOST);
//        if (searchFreeTextAttractionsAPIJSON.isSuccess()){
//            for (int i = 0; i < searchFreeTextAttractionsAPIJSON.getData().size(); i++) {
//                suggestedΑttraction = new SuggestedAttraction();
//                suggestedΑttraction.setTitle(searchFreeTextAttractionsAPIJSON.getData().get(i).getData().getTitle());
//                suggestedΑttraction.setRating(searchFreeTextAttractionsAPIJSON.getData().get(i).getData().getRating());
//                suggestedΑttraction.setState(searchFreeTextAttractionsAPIJSON.getData().get(i).getData().getAttractionState());
//                suggestedΑttraction.setCity(searchFreeTextAttractionsAPIJSON.getData().get(i).getData().getPrimaryDestinationName());
//                suggestedΑttraction.setSeoId(searchFreeTextAttractionsAPIJSON.getData().get(i).getData().getSeoId());
//                suggestedΑttractions.add(suggestedΑttraction);
//            }
//            attractions.setAtractions(suggestedΑttractions);
//        }else
//            attractions.setViatorΕrror(true);
//        return attractions;
//
//    }
//
//
//    /**
//     * Returns a List of Destinations(Countries,Cities,Regions)
//     * based on what user had type to the searchbox.
//     * If something goes wrong at API's side the boolean
//     * Viator_error will be set to true.
//     */
//    public SuggestedDestinationsList destinations(String textbox, String Topx) {
//
//        SuggestedDestinationsList destinations =new SuggestedDestinationsList();
//        ProductAPIDAO productAPIDAO = new ProductAPIDAO();
//        SearchFreetextPOST searchFreetextPOST = new SearchFreetextPOST();
//        SearchFreetextDestinationsAPIJSON searchFreetextDestinationsAPIJSON;
//        TaxonomyDestinationsAPIJSON taxonomyDestinationsAPIJSON;
//        List<Country> countries = new ArrayList<>();
//        List<City> cities = new ArrayList<>();
//        List<Region> regions = new ArrayList<>();
//        Country country;
//        City city;
//        Region region;
//        TaxonomyAPIDAO taxonomy_APIDAO = new TaxonomyAPIDAO();
//        String[] split_lookupid;
//        searchFreetextPOST.setTopX(Topx);
//        searchFreetextPOST.setText(textbox);
//        searchFreetextDestinationsAPIJSON = productAPIDAO.searchFreeTextDestination(searchFreetextPOST);
//        taxonomyDestinationsAPIJSON = taxonomy_APIDAO.retrieveDestinations();
//        if (searchFreetextDestinationsAPIJSON.isSuccess() && taxonomyDestinationsAPIJSON.isSuccess()){
//            for (int i = 0; i < searchFreetextDestinationsAPIJSON.getData().size(); i++) {
//                if (searchFreetextDestinationsAPIJSON.getData().get(i).getData().getDestinationType().equals("COUNTRY")) {
//                    country=new Country();
//                    country.setName(searchFreetextDestinationsAPIJSON.getData().get(i).getData().getDestinationName());
//                    country.setDestinationId(searchFreetextDestinationsAPIJSON.getData().get(i).getData().getDestinationId());
//                    countries.add(country);
//                }
//                if (searchFreetextDestinationsAPIJSON.getData().get(i).getData().getDestinationType().equals("CITY")) {
//                    city = new City();
//                    city.setName(searchFreetextDestinationsAPIJSON.getData().get(i).getData().getDestinationName());
//                    city.setDestinationId(searchFreetextDestinationsAPIJSON.getData().get(i).getData().getDestinationId());
//
//                    /**
//                     * Code for finding city's Country from Taxonomy/Destinations API Service
//                     */
//                    split_lookupid = searchFreetextDestinationsAPIJSON.getData().get(i).getData().getLookupId().split(Pattern.quote("."));
//                    for (int j = 0; j < taxonomyDestinationsAPIJSON.getData().size(); j++) {
//                        if (taxonomyDestinationsAPIJSON.getData().get(j).getDestinationId() == Integer.parseInt(split_lookupid[1])) {
//                            city.setCountry(taxonomyDestinationsAPIJSON.getData().get(j).getDestinationName());
//                            break;
//                        }
//                    }
//                    cities.add(city);
//                }
//                if (searchFreetextDestinationsAPIJSON.getData().get(i).getData().getDestinationType().equals("REGION")) {
//                    region = new Region();
//                    region.setName(searchFreetextDestinationsAPIJSON.getData().get(i).getData().getDestinationName());
//                    region.setDestinationId(searchFreetextDestinationsAPIJSON.getData().get(i).getData().getDestinationId());
//
//                    /**
//                     * Code for finding region's Country from Taxonomy/Destinations API Service
//                     */
//                    split_lookupid = searchFreetextDestinationsAPIJSON.getData().get(i).getData().getLookupId().split(Pattern.quote("."));
//                    for (int j = 0; j < taxonomyDestinationsAPIJSON.getData().size(); j++) {
//                        if (taxonomyDestinationsAPIJSON.getData().get(j).getDestinationId() == Integer.parseInt(split_lookupid[1])) {
//                            region.setCountry(taxonomyDestinationsAPIJSON.getData().get(j).getDestinationName());
//                            break;
//                        }
//                    }
//                    regions.add(region);
//
//
//                }
//            }
//            destinations.setCities(cities);
//            destinations.setCountries(countries);
//            destinations.setRegions(regions);
//        }else
//            destinations.setViatorΕrror(true);
//        return destinations;
//
//    }
//}
