package Beans.EventsTravelAPIBeans;

import java.util.Map;

public class EventsTravelCreateOrderResponse {
    private String message;
    private String status_code;
    private Map<String,String> products_failed;


    public EventsTravelCreateOrderResponse() {
        super();
    }
    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public Map<String, String> getProducts_failed() {
        return products_failed;
    }

    public void setProducts_failed(Map<String, String> products_failed) {
        this.products_failed = products_failed;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        StringBuilder response= new StringBuilder("message: "+message+" status_code: "+status_code+" \n");
        for (Map.Entry<String, String> entry : products_failed.entrySet()){
            response.append(entry.getKey()+": "+entry.getValue());
        }
        return response.toString();
    }


}
