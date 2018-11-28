package Beans.TravelGateXBeans;

/**
 * Created by George on 16/07/2018.
 */
public class Bed {

    private String type;
    private String description;
    private Integer count;
    private boolean shared;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }
}
