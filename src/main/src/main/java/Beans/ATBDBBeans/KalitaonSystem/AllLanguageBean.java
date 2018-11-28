package Beans.ATBDBBeans.KalitaonSystem;

import javax.persistence.*;

/**
 * Created by George on 21/08/2017.
 */
@Entity
@Table(name = "all_language", schema = "atb_System_DB", catalog = "")
public class AllLanguageBean {
    private int id;
    private String languageCode;
    private String language;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "language_code")
    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Basic
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllLanguageBean that = (AllLanguageBean) o;

        if (id != that.id) return false;
        if (languageCode != null ? !languageCode.equals(that.languageCode) : that.languageCode != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (languageCode != null ? languageCode.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
