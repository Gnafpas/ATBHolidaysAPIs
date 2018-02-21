package APIJSONs.ATBAPIJSONs.Hotel;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by George on 29/01/2018.
 */
public class Note {
    private String text;
    private XMLGregorianCalendar startDate;
    private XMLGregorianCalendar endDate;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(XMLGregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(XMLGregorianCalendar endDate) {
        this.endDate = endDate;
    }
}
