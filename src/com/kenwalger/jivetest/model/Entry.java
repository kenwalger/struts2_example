package com.kenwalger.jivetest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Ken on 5/14/2015.
 */

@Entity
@Table(name="Entries")
public class Entry implements Serializable{

    private Long id;
    private String os;
    private String osVersion;
    private String notes;

    private Date created;

    private Entry entry;
    private List<Entry> entryList;



    @Id
    @GeneratedValue
    @Column(name="id")
    public Long getId() {
        return id;
    }
    @Column(name="OS")
    public String getOs() {
        return os;
    }
    @Column(name="osVersion")
    public String getOsVersion(){
        return osVersion;
    }
    @Column(name="created")
    public Date getCreated() {
        return created;
    }
    @Column(name="notes")
    public String getNotes() {
        return notes;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setOs(String os) {
        this.os = os;
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


    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }
}
