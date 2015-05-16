package com.kenwalger.jivetest.view;

import com.kenwalger.jivetest.controller.EntryManager;
import com.kenwalger.jivetest.model.Entry;
import com.kenwalger.jivetest.util.EntryDao;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;
import java.util.List;

/**
 * Created by Ken on 5/14/2015.
 */
public class EntryAction extends ActionSupport {

    private static final long serialVersionUID = 9149826260758390091L;
    private Entry entry;
    private List<Entry> entryList;
    private Long id;
    private String OS;
    private String osVersion;
    private String notes;

    private Date created;

    private EntryManager entryManager;

    public EntryAction() {
        entryManager = new EntryManager();
    }

    public String execute() {
        this.entryList = entryManager.list();
        System.out.println("execute called");
        return SUCCESS;
    }

    public String add() {
        int i= EntryDao.save(this);
        if(i>0) {
            this.entryList = entryManager.list();
            return SUCCESS;
        }
        return ERROR;
    }

    public Entry getEntry() {
        return entry;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    public Long getId() {
        return id;
    }
    public String getOS() {
        return OS;
    }
    public String getOsVersion(){
        return osVersion;
    }
    public String getNotes() { return notes; }
    public Date getCreated() {
        return created;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setOS(String OS) {
        this.OS = OS;
    }
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

}
