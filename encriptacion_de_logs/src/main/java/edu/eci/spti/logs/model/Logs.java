package edu.eci.spti.logs.model;

import java.util.Date;

public class Logs {
    private String log;
    private String author;
    private Date date;

    public Logs(String log, String author, Date Date) {
        this.log = log;
        this.author = author;
        this.date = date;
    }

    public String getLog() {
        return log;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public void setLog(String log) {
        this.log = log;
    }

}
