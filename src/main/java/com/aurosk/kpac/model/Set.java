package com.aurosk.kpac.model;

import java.util.List;

public class Set {
    private int id;
    private String title;
    private List<Integer> kPacIds;
    private String action;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getkPacIds() {
        return kPacIds;
    }

    public void setkPacIds(List<Integer> kPacIds) {
        this.kPacIds = kPacIds;
    }

    public String getAction() { return action; }

    public void setAction(String action) { this.action = action; }
}
