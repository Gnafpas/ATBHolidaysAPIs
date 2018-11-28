package Beans.HotelBedsAPIBeans;

import DAOs.HotelBedsAPIDAOs.*;

/**
 * Created by George on 11/01/2018.
 */
public class StatusBean {
    private AuditData auditData;
    private String status;

    public AuditData getAuditData() {
        return auditData;
    }

    public void setAuditData(AuditData auditData) {
        this.auditData = auditData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
