package modena.infra.db.entity;

import java.util.Date;

import modena.infra.db.entity.common.CommonEntity;

public class NrEntity extends CommonEntity {
    public String name;
    public String title;
    public Date date;
    public int userId;
    public boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(String date) {
        this.date = convertYearMonthDayToDate(date);
    }

}
