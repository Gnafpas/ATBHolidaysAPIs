package Beans.TravelGateXBeans;

import java.util.List;

/**
 * Created by George on 16/07/2018.
 */
public class Search {

    private List<Option> options;
    private List<Error> errors;
    private List<Error> warnings;

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public List<Error> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Error> warnings) {
        this.warnings = warnings;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
