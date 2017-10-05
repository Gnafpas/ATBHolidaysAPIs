package ATBAPIBeans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 11/07/2017.
 */
public class CategoriesJson {
    List<Category> categories=new ArrayList<>();
    private boolean DBError=false;

    public boolean isDBError() {
        return DBError;
    }

    public void setDBError(boolean DBError) {
        this.DBError = DBError;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
