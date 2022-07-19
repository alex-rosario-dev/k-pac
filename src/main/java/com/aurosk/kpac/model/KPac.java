package com.aurosk.kpac.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class KPac {

    private long id;
    private String title;
    private String description;
    private Date creationDate;
    @JsonProperty("creation_date")
    private String creationDateStr;
    private String action;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAction() { return action; }

    public void setAction(String action) { this.action = action; }

    public String getCreationDateStr() {
        return creationDateStr;
    }

    public void setCreationDateStr(String creationDateStr) {
        this.creationDateStr = creationDateStr;
    }
}
