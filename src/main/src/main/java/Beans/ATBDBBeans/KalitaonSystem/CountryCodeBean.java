package Beans.ATBDBBeans.KalitaonSystem;

import javax.persistence.*;

/**
 * Created by George on 18/09/2017.
 */
@Entity
@Table(name = "country_code", schema = "atb_System_DB", catalog = "")
public class CountryCodeBean {
    private int id;
    private String countryName;
    private String countryCode;
    private String isoCode;
    private String isoCode2;
    private String population;
    private String areaKm2;
    private String gdpUsd;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Basic
    @Column(name = "country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "iso_code")
    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    @Basic
    @Column(name = "iso_code_2")
    public String getIsoCode2() {
        return isoCode2;
    }

    public void setIsoCode2(String isoCode2) {
        this.isoCode2 = isoCode2;
    }

    @Basic
    @Column(name = "population")
    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Basic
    @Column(name = "area_km2")
    public String getAreaKm2() {
        return areaKm2;
    }

    public void setAreaKm2(String areaKm2) {
        this.areaKm2 = areaKm2;
    }

    @Basic
    @Column(name = "gdp_usd")
    public String getGdpUsd() {
        return gdpUsd;
    }

    public void setGdpUsd(String gdpUsd) {
        this.gdpUsd = gdpUsd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryCodeBean that = (CountryCodeBean) o;

        if (id != that.id) return false;
        if (countryName != null ? !countryName.equals(that.countryName) : that.countryName != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (isoCode != null ? !isoCode.equals(that.isoCode) : that.isoCode != null) return false;
        if (isoCode2 != null ? !isoCode2.equals(that.isoCode2) : that.isoCode2 != null) return false;
        if (population != null ? !population.equals(that.population) : that.population != null) return false;
        if (areaKm2 != null ? !areaKm2.equals(that.areaKm2) : that.areaKm2 != null) return false;
        if (gdpUsd != null ? !gdpUsd.equals(that.gdpUsd) : that.gdpUsd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (isoCode != null ? isoCode.hashCode() : 0);
        result = 31 * result + (isoCode2 != null ? isoCode2.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + (areaKm2 != null ? areaKm2.hashCode() : 0);
        result = 31 * result + (gdpUsd != null ? gdpUsd.hashCode() : 0);
        return result;
    }
}
