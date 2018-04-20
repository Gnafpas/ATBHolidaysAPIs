package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 06/04/2018.
 */
@Entity
@Table(name = "prebook_log", schema = "develope_viator", catalog = "")
public class PrebookLogBean {
    private int id;
    private String prebookRef;
    private String client;
    private String clientRequest;
    private String clientResponse;
    private String provider;
    private String providerRequest;
    private String providerResponse;
    private Timestamp dateTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "prebook_ref")
    public String getPrebookRef() {
        return prebookRef;
    }

    public void setPrebookRef(String prebookRef) {
        this.prebookRef = prebookRef;
    }

    @Basic
    @Column(name = "client")
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Basic
    @Column(name = "client_request")
    public String getClientRequest() {
        return clientRequest;
    }

    public void setClientRequest(String clientRequest) {
        this.clientRequest = clientRequest;
    }

    @Basic
    @Column(name = "client_response")
    public String getClientResponse() {
        return clientResponse;
    }

    public void setClientResponse(String clientResponse) {
        this.clientResponse = clientResponse;
    }

    @Basic
    @Column(name = "provider")
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Basic
    @Column(name = "provider_request")
    public String getProviderRequest() {
        return providerRequest;
    }

    public void setProviderRequest(String providerRequest) {
        this.providerRequest = providerRequest;
    }

    @Basic
    @Column(name = "provider_response")
    public String getProviderResponse() {
        return providerResponse;
    }

    public void setProviderResponse(String providerResponse) {
        this.providerResponse = providerResponse;
    }

    @Basic
    @Column(name = "date_time")
    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrebookLogBean that = (PrebookLogBean) o;

        if (id != that.id) return false;
        if (prebookRef != null ? !prebookRef.equals(that.prebookRef) : that.prebookRef != null) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (clientRequest != null ? !clientRequest.equals(that.clientRequest) : that.clientRequest != null)
            return false;
        if (clientResponse != null ? !clientResponse.equals(that.clientResponse) : that.clientResponse != null)
            return false;
        if (provider != null ? !provider.equals(that.provider) : that.provider != null) return false;
        if (providerRequest != null ? !providerRequest.equals(that.providerRequest) : that.providerRequest != null)
            return false;
        if (providerResponse != null ? !providerResponse.equals(that.providerResponse) : that.providerResponse != null)
            return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (prebookRef != null ? prebookRef.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (clientRequest != null ? clientRequest.hashCode() : 0);
        result = 31 * result + (clientResponse != null ? clientResponse.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (providerRequest != null ? providerRequest.hashCode() : 0);
        result = 31 * result + (providerResponse != null ? providerResponse.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }
}
