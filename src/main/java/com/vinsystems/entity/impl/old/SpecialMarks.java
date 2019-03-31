package com.vinsystems.entity.impl.old;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;
@Embeddable
public class SpecialMarks {
    @Column (name="dateOFmark")
  private   Date date;

    @Column (name="textOfMark")
    private String log;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public SpecialMarks() {

    }

    @Override
    public String toString() {
        return "SpecialMarks{" +
                "date=" + date +
                ", log='" + log + '\'' +
                '}';
    }
}
