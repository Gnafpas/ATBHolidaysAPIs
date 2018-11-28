package APIJSONs.ATBAPIJSONs.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 28/03/2018.
 */
public class Categories {
    private List<Category> categories=new ArrayList<>();

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
