package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 12/12/2017.
 */
@Entity
@Table(name = "meal", schema = "Sunhotels", catalog = "")
public class MealBean {
    private int id;
    private String name;
    private int providerId;



    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "provider_id")
    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MealBean mealBean = (MealBean) o;

        if (id != mealBean.id) return false;
        if (name != null ? !name.equals(mealBean.name) : mealBean.name != null) return false;
        if (providerId != mealBean.providerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + providerId;
        return result;
    }
}
