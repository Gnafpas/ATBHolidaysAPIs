package Beans.TravelGateXBeans;

import java.math.BigDecimal;

/**
 * Created by George on 16/07/2018.
 */
public class Price {

    private String currency;
    private boolean binding;
    private BigDecimal net;
    private BigDecimal gross;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isBinding() {
        return binding;
    }

    public void setBinding(boolean binding) {
        this.binding = binding;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public BigDecimal getGross() {
        return gross;
    }

    public void setGross(BigDecimal gross) {
        this.gross = gross;
    }
}
