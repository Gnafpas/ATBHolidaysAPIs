package Beans.ATBDBBeans.KalitaonSystem;

import javax.persistence.*;

/**
 * Created by George on 04/11/2017.
 */
@Entity
@Table(name = "city_code", schema = "atb_System_DB", catalog = "")
public class CityCodeBean {
    private int id;
    private String geonameid;
    private Integer viatorid;
    private String originalName;
    private String sanitizedName;
    private String alternateNamesCsv;
    private String latitude;
    private String longitude;
    private String featureClass;
    private String featureCode;
    private String countryCodeIso;
    private String population;
    private String dem;
    private String timeZoneRegion;
    private boolean hasProduct;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "geonameid")
    public String getGeonameid() {
        return geonameid;
    }

    public void setGeonameid(String geonameid) {
        this.geonameid = geonameid;
    }

    @Basic
    @Column(name = "hasProduct")
    public boolean isHasProduct() {
        return hasProduct;
    }

    public void setHasProduct(boolean hasProduct) {
        this.hasProduct = hasProduct;
    }

    @Basic
    @Column(name = "viatorid")
    public Integer getViatorid() {
        return viatorid;
    }

    public void setViatorid(Integer viatorid) {
        this.viatorid = viatorid;
    }

    @Basic
    @Column(name = "original_name")
    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    @Basic
    @Column(name = "sanitized_name")
    public String getSanitizedName() {
        return sanitizedName;
    }

    public void setSanitizedName(String sanitizedName) {
        this.sanitizedName = sanitizedName;
    }

    @Basic
    @Column(name = "alternate_names_CSV")
    public String getAlternateNamesCsv() {
        return alternateNamesCsv;
    }

    public void setAlternateNamesCsv(String alternateNamesCsv) {
        this.alternateNamesCsv = alternateNamesCsv;
    }

    @Basic
    @Column(name = "latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "feature_class")
    public String getFeatureClass() {
        return featureClass;
    }

    public void setFeatureClass(String featureClass) {
        this.featureClass = featureClass;
    }

    @Basic
    @Column(name = "feature_code")
    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    @Basic
    @Column(name = "country_code_iso")
    public String getCountryCodeIso() {
        return countryCodeIso;
    }

    public void setCountryCodeIso(String countryCodeIso) {
        this.countryCodeIso = countryCodeIso;
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
    @Column(name = "dem")
    public String getDem() {
        return dem;
    }

    public void setDem(String dem) {
        this.dem = dem;
    }

    @Basic
    @Column(name = "time_zone_region")
    public String getTimeZoneRegion() {
        return timeZoneRegion;
    }

    public void setTimeZoneRegion(String timeZoneRegion) {
        this.timeZoneRegion = timeZoneRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityCodeBean that = (CityCodeBean) o;

        if (id != that.id) return false;
        if (geonameid != null ? !geonameid.equals(that.geonameid) : that.geonameid != null) return false;
        if (viatorid != null ? !viatorid.equals(that.viatorid) : that.viatorid != null) return false;
        if (originalName != null ? !originalName.equals(that.originalName) : that.originalName != null) return false;
        if (sanitizedName != null ? !sanitizedName.equals(that.sanitizedName) : that.sanitizedName != null)
            return false;
        if (alternateNamesCsv != null ? !alternateNamesCsv.equals(that.alternateNamesCsv) : that.alternateNamesCsv != null)
            return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (featureClass != null ? !featureClass.equals(that.featureClass) : that.featureClass != null) return false;
        if (featureCode != null ? !featureCode.equals(that.featureCode) : that.featureCode != null) return false;
        if (countryCodeIso != null ? !countryCodeIso.equals(that.countryCodeIso) : that.countryCodeIso != null)
            return false;
        if (population != null ? !population.equals(that.population) : that.population != null) return false;
        if (dem != null ? !dem.equals(that.dem) : that.dem != null) return false;
        if (timeZoneRegion != null ? !timeZoneRegion.equals(that.timeZoneRegion) : that.timeZoneRegion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (geonameid != null ? geonameid.hashCode() : 0);
        result = 31 * result + (viatorid != null ? viatorid.hashCode() : 0);
        result = 31 * result + (originalName != null ? originalName.hashCode() : 0);
        result = 31 * result + (sanitizedName != null ? sanitizedName.hashCode() : 0);
        result = 31 * result + (alternateNamesCsv != null ? alternateNamesCsv.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (featureClass != null ? featureClass.hashCode() : 0);
        result = 31 * result + (featureCode != null ? featureCode.hashCode() : 0);
        result = 31 * result + (countryCodeIso != null ? countryCodeIso.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        result = 31 * result + (dem != null ? dem.hashCode() : 0);
        result = 31 * result + (timeZoneRegion != null ? timeZoneRegion.hashCode() : 0);
        return result;
    }
}
