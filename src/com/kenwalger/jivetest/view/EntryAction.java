package com.kenwalger.jivetest.view;

import com.kenwalger.jivetest.model.Entry;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


    public String execute() {
        String ret = SUCCESS;
        Connection connection = null;

        try {
            String URL = "jdbc:mysql://localhost:3306/jive_ssei_test/entries";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "root");
            String sql = "INSERT INTO entries (OS, osVersion, notes, created) VALUES(?,?,?, CURRENT_TIMESTAMP)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, getOS());
            ps.setString(2, getOsVersion());
            ps.setString(3, getNotes());

            ps.executeUpdate();

            ret = SUCCESS;

        } catch (Exception e) {
            ret = ERROR;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    ret = ERROR;
                }
            }
        }
        return ret;
    }

    public void validate() {
        if (OS == null || OS.trim().equals("")) {
            addFieldError("OS", "The OS is required.");
        }
        if (osVersion == null || osVersion.trim().equals("")) {
            addFieldError("osVersion", "The OS Version is required.");
        }
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
