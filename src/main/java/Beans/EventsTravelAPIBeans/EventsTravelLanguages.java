package Beans.EventsTravelAPIBeans;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class EventsTravelLanguages {


    private Map<String, EventsTravelDescription> langDescription = new HashMap<String, EventsTravelDescription>();

    @JsonAnyGetter
    public Map<String, EventsTravelDescription> getLangDescription() {
        return this.langDescription;
    }

    @JsonAnySetter
    public void setLanguages(String name, EventsTravelDescription value) {
        this.langDescription.put(name, value);
    }

}
