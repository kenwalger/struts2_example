package com.kenwalger.jivetest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Ken on 5/14/2015.
 */

@Entity
@Table(name="Entries")
public class Entry implements Serializable{

    private static final long serialVersionUID = -8767337896773261247L;

    private Long id;
    private String OS;
    private String osVersion;
    private String notes;

    private Date created;

    @Id
    @GeneratedValue
    @Column(name="id")
    public Long getId() {
        return id;
    }
    @Column(name="OS")
    public String getOS() {
        return OS;
    }
    @Column(name="osVersion")
    public String getOsVersion(){
        return osVersion;
    }
    @Column(name="created")
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
