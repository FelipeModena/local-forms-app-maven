package modena.infra.db.entity.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonEntity {

    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date convertYearMonthDayToDate(String yearMonthDay) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = format.parse(yearMonthDay);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String convertDateToYearMonthDay(Date dateChooser) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String date = format.format(dateChooser);

        return date;
    }

}
